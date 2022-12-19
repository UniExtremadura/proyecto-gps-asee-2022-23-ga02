package es.unex.trackstone10.ui.favorites.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import es.unex.trackstone10.HeroFavInfoActivity
import es.unex.trackstone10.TrackstoneViewModel
import es.unex.trackstone10.adapter.HeroFavAdapter
import es.unex.trackstone10.databinding.FragmentHeroesBinding
import es.unex.trackstone10.domain.CardModel
import es.unex.trackstone10.roomdb.Entity.ClassEntity

@AndroidEntryPoint
class HeroesFavoritesFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentHeroesBinding
    private lateinit var adapter: HeroFavAdapter
    private val handler = Handler(Looper.getMainLooper())
    private var heroList = (mutableListOf<ClassEntity?>())

    private val trackstoneViewModel : TrackstoneViewModel by viewModels()

    var userId:Int? = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeroesBinding.inflate(inflater,container,false)
        val view = binding.root
        binding.svCard.setOnQueryTextListener(this)
        initRecyclerView()
        val sharedPreferences = activity?.getSharedPreferences("userid", Context.MODE_PRIVATE)
        userId = sharedPreferences?.getInt("userid", 0)
        setAdapter()
        return view
    }

    private fun initRecyclerView(){
        adapter = HeroFavAdapter() { onItemSelected(it) }
        binding.recyclerViewCards.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewCards.adapter = adapter
    }

    private fun onItemSelected(heroes: CardModel){
        val intent: Intent = Intent(activity, HeroFavInfoActivity::class.java)
        intent.putExtra("CARD_OBJ", heroes)
        startActivity(intent)
    }

    private fun setAdapter(){
        trackstoneViewModel.getAllHerosDatabase(userId)
        trackstoneViewModel.getAllHerosFromDatabaseResult.observe(viewLifecycleOwner, Observer {
            adapter.swap(it)
        })
    }

    private fun hideKeyboard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.Hroot.windowToken, 0)
    }
    override fun onQueryTextSubmit(query: String?): Boolean {
        hideKeyboard()
        if (!query.isNullOrEmpty()) {
            trackstoneViewModel.getHerosByNameDatabase(query,userId)
            trackstoneViewModel.getHerosByNameFromDatabaseResult.observe(viewLifecycleOwner, Observer {
                adapter.swap(it)
            })
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if(newText?.length == 0){
            setAdapter()
        }
        return true
    }
}
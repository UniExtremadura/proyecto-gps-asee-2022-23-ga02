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
import es.unex.trackstone10.CardBackFavInfoActivity
import es.unex.trackstone10.TrackstoneViewModel
import es.unex.trackstone10.adapter.cardbackAdapterFav
import es.unex.trackstone10.databinding.FragmentCardBacksBinding
import es.unex.trackstone10.domain.CardBackModel
import es.unex.trackstone10.roomdb.Entity.CardBackEntity


@AndroidEntryPoint
class CardBacksFavoritesFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentCardBacksBinding
    private lateinit var adapter: cardbackAdapterFav
    private val handler = Handler(Looper.getMainLooper())
    private var cardBackList = (mutableListOf<CardBackEntity?>())

    private val trackstoneViewModel : TrackstoneViewModel by viewModels()

    var userId:Int? = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardBacksBinding.inflate(inflater,container,false)
        val view = binding.root
        binding.svCard.setOnQueryTextListener(this)
        initRecyclerView()
        val sharedPreferences = activity?.getSharedPreferences("userid", Context.MODE_PRIVATE)
        userId = sharedPreferences?.getInt("userid", 0)
        setAdapter()
        return view
    }

    private fun initRecyclerView(){
        adapter = cardbackAdapterFav() { onItemSelected((it))}
        binding.recyclerViewCards.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewCards.adapter = adapter
    }

    private fun onItemSelected(cardbacks: CardBackModel) {
        val intent: Intent = Intent(activity, CardBackFavInfoActivity::class.java)
        intent.putExtra("CARD_BACK_OBJ", cardbacks)
        startActivity(intent)
    }

    private fun setAdapter(){
        trackstoneViewModel.getAllCardBacksDatabase(userId)
        trackstoneViewModel.getAllCardBacksFromDatabaseResult.observe(viewLifecycleOwner, Observer {
            adapter.swap(it)
        })
    }

    private fun hideKeyboard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.CBroot.windowToken, 0)
    }


    override fun onQueryTextSubmit(query: String?):Boolean{
        hideKeyboard()
        if(!query.isNullOrEmpty()){
            trackstoneViewModel.getCardBacksByNameDatabase(query,userId)
            trackstoneViewModel.getCardBacksByNameFromDatabaseResult.observe(viewLifecycleOwner, Observer {
                adapter.swap(it)
            })
        }
        return true
    }

    override fun onQueryTextChange(newText:String?): Boolean{
        if(newText?.length == 0) {
            setAdapter()
        }
        return true
    }
}
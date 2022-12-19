package es.unex.trackstone10.ui.home.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import es.unex.trackstone10.HeroInfoActivity
import es.unex.trackstone10.TrackstoneViewModel
import es.unex.trackstone10.adapter.heroAdapter
import es.unex.trackstone10.databinding.FragmentHeroesBinding
import es.unex.trackstone10.domain.CardModel

@AndroidEntryPoint
class HeroesFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentHeroesBinding
    private lateinit var adapter: heroAdapter


    private val trackstoneViewModel: TrackstoneViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeroesBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.svCard.setOnQueryTextListener(this)
        initRecyclerView()
        setAdapter()
        return view
    }

    private fun initRecyclerView() {
        adapter = heroAdapter() { onItemSelected(it) }
        binding.recyclerViewCards.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewCards.adapter = adapter
    }

    private fun onItemSelected(cards: CardModel) {
        val intent: Intent = Intent(activity, HeroInfoActivity::class.java)
        intent.putExtra("CARD_OBJ", cards)
        startActivity(intent)
    }

    private fun setAdapter() {
        trackstoneViewModel.getAllHeroes()
        trackstoneViewModel.allHeroes.observe(viewLifecycleOwner) {
            adapter.swap(it)
        }
    }

    private fun hideKeyboard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.Hroot.windowToken, 0)
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        hideKeyboard()
        if (!query.isNullOrEmpty()) {
            trackstoneViewModel.getHeroesByName(query)
            trackstoneViewModel.searchedHeroes.observe(viewLifecycleOwner) {
                adapter.swap(it)
            }
        }

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText?.length == 0) {
            setAdapter()
        }
        return true
    }
}
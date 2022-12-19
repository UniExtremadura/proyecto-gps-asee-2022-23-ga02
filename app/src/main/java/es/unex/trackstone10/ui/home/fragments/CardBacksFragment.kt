package es.unex.trackstone10.ui.home.fragments

import android.content.Context.INPUT_METHOD_SERVICE
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
import es.unex.trackstone10.CardBackInfoActivity
import es.unex.trackstone10.TrackstoneViewModel
import es.unex.trackstone10.adapter.cardbackAdapter
import es.unex.trackstone10.databinding.FragmentCardBacksBinding
import es.unex.trackstone10.domain.CardBackModel

@AndroidEntryPoint
class CardBacksFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentCardBacksBinding
    private lateinit var adapter: cardbackAdapter

    private val trackstoneViewModel: TrackstoneViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardBacksBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.svCard.setOnQueryTextListener(this)
        initRecyclerView()
        setAdapter()
        return view
    }

    private fun initRecyclerView() {
        adapter = cardbackAdapter() { onItemSelected(it) }
        binding.recyclerViewCards.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewCards.adapter = adapter
    }

    private fun onItemSelected(cardbacks: CardBackModel) {
        val intent = Intent(activity, CardBackInfoActivity::class.java)
        intent.putExtra("CARD_BACK_OBJ", cardbacks)
        startActivity(intent)

    }

    private fun setAdapter() {
        trackstoneViewModel.getAllCardbacks()
        trackstoneViewModel.allCardbacks.observe(viewLifecycleOwner) {
            adapter.swap(it)
        }
    }


    private fun hideKeyboard() {
        val imm = activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.CBroot.windowToken, 0)
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        hideKeyboard()
        if (!query.isNullOrEmpty()) {
            trackstoneViewModel.getCarbacksByName(query)
            trackstoneViewModel.searchedCarbacks.observe(viewLifecycleOwner) {
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
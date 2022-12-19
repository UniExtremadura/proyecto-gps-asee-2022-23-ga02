package es.unex.trackstone10.ui.decks

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import es.unex.trackstone10.*
import es.unex.trackstone10.adapter.deckAdapter
import es.unex.trackstone10.databinding.FragmentDecksBinding


@AndroidEntryPoint
class DecksFragment : Fragment() {

    private lateinit var binding: FragmentDecksBinding
    private lateinit var adapter: deckAdapter

    private val trackstoneViewModel: TrackstoneViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDecksBinding.inflate(inflater, container, false)
        val view = binding.root

        initRecyclerView()
        binding.buttonCreateDeck.setOnClickListener {
            val intent = Intent(activity, CreateDeckActivity::class.java)
            startActivity(intent)
        }
        return view
    }

    private fun initRecyclerView() {
        adapter = deckAdapter( activity) { onDeletedItem(it) }
        binding.recyclerViewDecks.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewDecks.adapter = adapter
        setAdapter()
    }

    private fun setAdapter() {
        trackstoneViewModel.getAllDecks()
        trackstoneViewModel.allDecks.observe(viewLifecycleOwner, Observer {
            adapter.swap(it)
            adapter.notifyDataSetChanged()
        })
    }


    private fun onDeletedItem(position: Int) {
        trackstoneViewModel.deleteDeck(adapter.getAtPostition(position))
        trackstoneViewModel.deleteDeckResult.observe(viewLifecycleOwner) {
            when (it) {
                true -> {
                    trackstoneViewModel.allDecks.observe(viewLifecycleOwner){ deck ->
                        adapter.swap(deck)
                    }
                }
                false -> {
                    Toast.makeText(activity, "Deck cant be deleted", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
package es.unex.trackstone10.ui.decks

import es.unex.trackstone10.roomdb.TrackstoneDatabase
import es.unex.trackstone10.adapter.deckAdapter
import es.unex.trackstone10.CreateDeckActivity
import es.unex.trackstone10.roomdb.Entity.DeckEntity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import es.unex.trackstone10.databinding.FragmentDecksBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DecksFragment : Fragment() {

    private lateinit var binding: FragmentDecksBinding
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var adapter: deckAdapter
    private val deckList = (mutableListOf<DeckEntity?>())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDecksBinding.inflate(inflater, container, false)
        val view = binding.root
        initRecyclerView()
        getDecksRecycler()
        binding.buttonCreateDeck.setOnClickListener {
            val intent = Intent(activity, CreateDeckActivity::class.java)
            startActivity(intent)
        }
        return view
    }

    private fun initRecyclerView() {
        adapter = deckAdapter(deckList, activity) {onDeletedItem(it, deckList[it]}
        binding.recyclerViewDecks.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewDecks.adapter = adapter
    }

    private fun getDecksRecycler() {
        CoroutineScope(Dispatchers.IO).launch {
            val db = TrackstoneDatabase.getInstance(activity)
            val deck = db?.deckDao?.getAll()
            handler.post {
                if (deck != null) {
                    deckList.clear()
                    deckList.addAll(deck)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    private fun onDeletedItem(position: Int, deck: DeckEntity?) {

    }
}
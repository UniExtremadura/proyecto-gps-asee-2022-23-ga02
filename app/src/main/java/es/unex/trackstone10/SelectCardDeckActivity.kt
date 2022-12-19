package es.unex.trackstone10


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import es.unex.trackstone10.adapter.cardAddDeckAdapter
import es.unex.trackstone10.databinding.ActivitySelectCardDeckBinding

@AndroidEntryPoint
class SelectCardDeckActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivitySelectCardDeckBinding
    private lateinit var adapter: cardAddDeckAdapter
    private var classSelected: String? = null
    private lateinit var classSlug: String

    private val trackstoneViewModel: TrackstoneViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectCardDeckBinding.inflate((layoutInflater))
        binding.buttonCreateDeck.text = "Edit Deck"
        var deckId = intent.getIntExtra("DECK_ID", 0)
        var userId = intent.getIntExtra("USER_ID", 0)
        classSelected = intent.getStringExtra("CLASS_SLUG")
        classSlug = "$classSelected,neutral"
        binding.svCard.setOnQueryTextListener(this)
        setContentView(binding.root)
        initRecyclerView(deckId, userId)
        setAdapter()

        binding.buttonCreateDeck.setOnClickListener {
            goToEditCards(deckId)
        }
        binding.buttonFinishDeck.setOnClickListener {
            val intent = Intent(this, ButtonNavigationMenuActivity::class.java)
            startActivity(intent)
        }

    }


    private fun initRecyclerView(deckId: Int?, userId: Int?) {
        adapter = cardAddDeckAdapter(deckId, userId, this)
        binding.recyclerViewCards.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewCards.adapter = adapter
    }


    private fun setAdapter() {
        trackstoneViewModel.getCardsByClass(classSlug)
        trackstoneViewModel.cardsByClass.observe(this) {
            adapter.swap(it)
        }
    }

    private fun searchByName(query: String) {
        trackstoneViewModel.getCardsByClassAndName(classSlug, query)
        trackstoneViewModel.cardsByClassAndName.observe(this) {
            adapter.swap(it)
        }
    }

    private fun hideKeyboard() {
        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.Croot.windowToken, 0)
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        hideKeyboard()
        if (!query.isNullOrEmpty()) {
            searchByName(query)
        }

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        hideKeyboard()
        if (newText?.length == 0) {
            setAdapter()
        }
        return true
    }

    fun goToEditCards(deckId: Int) {
        val sharedPreferences = getSharedPreferences("userid", Context.MODE_PRIVATE)
        var userId = sharedPreferences.getInt("userid", 0)
        val intent = Intent(this@SelectCardDeckActivity, EditDeckActivity::class.java)
        intent.putExtra("USER_ID", userId)
        intent.putExtra("DECK_ID", deckId)
        intent.putExtra("CLASS_SLUG", classSelected)
        startActivity(intent)
    }

}

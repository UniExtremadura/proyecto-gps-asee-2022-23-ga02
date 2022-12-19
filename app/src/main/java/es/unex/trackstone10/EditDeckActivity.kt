package es.unex.trackstone10

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import es.unex.trackstone10.adapter.editCardDeckAdapter
import es.unex.trackstone10.databinding.ActivitySelectCardDeckBinding
import es.unex.trackstone10.domain.CardModel

@AndroidEntryPoint
class EditDeckActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivitySelectCardDeckBinding
    private lateinit var adapter: editCardDeckAdapter
    private var deckId = 0

    private val trackstoneViewModel: TrackstoneViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectCardDeckBinding.inflate(layoutInflater)
        val deckIdFromIntent = intent.getIntExtra("DECK_ID", 0)
        binding.svCard.setOnQueryTextListener(this)
        deckId = deckIdFromIntent

        trackstoneViewModel.getDecklistCount(deckId)
        trackstoneViewModel.deckCount.observe(this){
            binding.contCards.text = "CARD COUNT: $it/30"
        }

        setContentView(binding.root)
        initRecyclerView(deckId)
        setAdapter()
        binding.buttonCreateDeck.setOnClickListener {
            goToAddCards(deckId)
        }
        binding.buttonFinishDeck.setOnClickListener {
            val intent = Intent(this, ButtonNavigationMenuActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerView(deckId: Int) {
        adapter = editCardDeckAdapter(
            onClickDeleted = { onDeletedItem(it, adapter.getAtPosition(it)) },
            deckId = deckId,
            conText = this
        )
        binding.recyclerViewCards.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewCards.adapter = adapter
    }

    private fun setAdapter() {
        trackstoneViewModel.getDeckList(deckId)
        trackstoneViewModel.deckList.observe(this) {
            adapter.swap(it)
        }
    }

    private fun getDeckCardByName(query: String) {
        trackstoneViewModel.getCardFromDeckList(query, deckId)
        trackstoneViewModel.cardsFromDeckByName.observe(this) {
            adapter.swap(it)
        }
    }

    fun onDeletedItem(position: Int, cards: CardModel) {
        cards.name?.let { trackstoneViewModel.deleteCardFromDeck(deckId, it) }
        trackstoneViewModel.deleteCardFromDeckResult.observe(this) {
            when (it) {
                1 -> trackstoneViewModel.deckList.observe(this){ card ->
                    adapter.swap(card)
                }

                2 -> Toast.makeText(this, "Copy removed from deck", Toast.LENGTH_SHORT).show()

                3 -> Toast.makeText(this, "ERROR removing card from deck", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        hideKeyboard()
        if (!query.isNullOrEmpty()) {
            getDeckCardByName(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText?.length == 0) {
            setAdapter()
        }
        return true
    }

    fun goToAddCards(deckId: Int) {
        val sharedPreferences = getSharedPreferences("userid", Context.MODE_PRIVATE)
        var userId = sharedPreferences.getInt("userid", 0)
        var idClass = 0
        trackstoneViewModel.getDeck(deckId)
        trackstoneViewModel.deckById.observe(this) {
            idClass = it.classid ?: 0
            val textClass = slugIntToString(idClass)

            val intent = Intent(this@EditDeckActivity, SelectCardDeckActivity::class.java)
            intent.putExtra("USER_ID", userId)
            intent.putExtra("DECK_ID", deckId)
            intent.putExtra("CLASS_SLUG", textClass.lowercase())
            startActivity(intent)
        }
    }

    private fun hideKeyboard() {
        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.Croot.windowToken, 0)
    }

    fun slugIntToString(id: Int?): String {
        var slug = ""
        when (id) {
            1 -> slug = "DeathKnight"
            2 -> slug = "DemonHunter"
            3 -> slug = "Druid"
            4 -> slug = "Hunter"
            5 -> slug = "Mage"
            6 -> slug = "Paladin"
            7 -> slug = "Priest"
            8 -> slug = "Rogue"
            9 -> slug = "Shaman"
            10 -> slug = "Warlock"
            11 -> slug = "Warrior"
        }
        return slug
    }

}

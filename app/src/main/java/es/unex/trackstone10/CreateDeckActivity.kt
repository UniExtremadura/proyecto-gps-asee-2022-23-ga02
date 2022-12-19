package es.unex.trackstone10

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import es.unex.trackstone10.databinding.ActivityCreateDeckBinding
import es.unex.trackstone10.roomdb.Entity.DeckEntity

@AndroidEntryPoint
class CreateDeckActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateDeckBinding
    lateinit var option: Spinner
    private lateinit var textClass: String
    var deckId: Int = 0

    private val trackstoneViewModel: TrackstoneViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateDeckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("userid", Context.MODE_PRIVATE)
        var userId = sharedPreferences.getInt("userid", 0)

        val lista = listOf(
            "DeathKnight",
            "DemonHunter",
            "Druid",
            "Hunter",
            "Mage",
            "Paladin",
            "Priest",
            "Rogue",
            "Shaman",
            "Warlock",
            "Warrior"
        )
        option = findViewById(R.id.mySpinner)
        var num: Int = 0

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        option.adapter = adaptador

        option.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                textClass = option.selectedItem.toString()
                num = stringToInt(textClass)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        binding.addCardButton.setOnClickListener {
            val deck = DeckEntity(num, binding.editTextTextPersonName.text.toString(), 0, userId)
            trackstoneViewModel.addDeck(deck)
            trackstoneViewModel.createDeckResult.observe(this, Observer {
                if(it > 0){
                        val intent = Intent(this, SelectCardDeckActivity::class.java)
                        intent.putExtra("USER_ID", userId)
                        intent.putExtra("DECK_ID", it)
                        intent.putExtra("CLASS_SLUG", textClass.lowercase())
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "Deck cant be create", Toast.LENGTH_SHORT).show()
                    }
            })
        }
    }

    fun stringToInt(className: String): Int {
        var num: Int = 0
        when (className) {
            "DeathKnight" -> num = 1
            "DemonHunter" -> num = 2
            "Druid" -> num = 3
            "Hunter" -> num = 4
            "Mage" -> num = 5
            "Paladin" -> num = 6
            "Priest" -> num = 7
            "Rogue" -> num = 8
            "Shaman" -> num = 9
            "Warlock" -> num = 10
            "Warrior" -> num = 11
        }
        return num
    }
}
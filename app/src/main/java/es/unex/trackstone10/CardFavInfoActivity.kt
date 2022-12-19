package es.unex.trackstone10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.unex.trackstone10.databinding.ActivityCardInfoBinding
import es.unex.trackstone10.domain.CardModel

@AndroidEntryPoint
class CardFavInfoActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityCardInfoBinding

    private val trackstoneViewModel : TrackstoneViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cards = intent.getSerializableExtra("CARD_OBJ") as CardModel
        binding.cardtitle.text = cards.name
        when (cards.rarity){
            1 -> binding.cardDetail1.text = "Common"
            2 -> binding.cardDetail1.text = "Free"
            3 -> binding.cardDetail1.text = "Rare"
            4 -> binding.cardDetail1.text = "Epic"
            5 -> binding.cardDetail1.text = "Legendary"
        }
        binding.cardDetail2.text = cards.type
        binding.cardDetail3.text = "Mana cost: ${cards.manacost}"
        when (cards.cardclass){
            1 -> binding.cardDetail4.text = "Death Knight"
            14 -> binding.cardDetail4.text = "Demon hunter"
            3 -> binding.cardDetail4.text = "Hunter"
            4 -> binding.cardDetail4.text = "Hunter"
            5 -> binding.cardDetail4.text = "Mage"
            6 -> binding.cardDetail4.text = "Paladin"
            7 -> binding.cardDetail4.text = "Priest"
            8 -> binding.cardDetail4.text = "Rogue"
            9 -> binding.cardDetail4.text = "Shaman"
            10 -> binding.cardDetail4.text = "Warlock"
            11 -> binding.cardDetail4.text = "Warrior"
        }
        Glide.with(binding.cardDetails.context).load(cards.info).into(binding.cardDetails)

        binding.addDeleteFavoriteButton.text = "Delete from Favorites"

        binding.addDeleteFavoriteButton.setOnClickListener {
            trackstoneViewModel.deleteCard(cards.name)
            trackstoneViewModel.deleteFavoriteCardResult.observe(this, Observer {
                when (it) {
                    true -> {
                        val intent = Intent(this, ButtonNavigationMenuActivity::class.java)
                        startActivity(intent)
                    }
                    false -> {
                        Toast.makeText(this, "Card cant be deleted", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }

    }

}
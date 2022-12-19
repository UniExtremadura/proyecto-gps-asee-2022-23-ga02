package es.unex.trackstone10

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.unex.trackstone10.databinding.ActivityCardInfoBinding
import es.unex.trackstone10.domain.CardModel

@AndroidEntryPoint
class CardInfoActivity() : AppCompatActivity() {

    private lateinit var binding: ActivityCardInfoBinding

    private val trackstoneViewModel: TrackstoneViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cards = intent.getSerializableExtra("CARD_OBJ") as CardModel
        binding.cardtitle.text = cards.name
        binding.cardDetail1.text = cards.flavorText
        when (cards.rarity) {
            1 -> binding.cardDetail2.text = "Common"
            2 -> binding.cardDetail2.text = "Free"
            3 -> binding.cardDetail2.text = "Rare"
            4 -> binding.cardDetail2.text = "Epic"
            5 -> binding.cardDetail2.text = "Legendary"
        }
        binding.cardDetail3.text = cards.type
        binding.cardDetail4.text = "Artist: ${cards.artist}"
        Glide.with(binding.cardDetails.context).load(cards.info).into(binding.cardDetails)

        val sharedPreferences = getSharedPreferences("userid", Context.MODE_PRIVATE)
        var userId = sharedPreferences.getInt("userid", 0)


        binding.addDeleteFavoriteButton.setOnClickListener {
            trackstoneViewModel.addCard(cards, userId)
            trackstoneViewModel.addCardFavoriteResult.observe(this) {
                when (it) {
                    true -> {
                        val intent = Intent(this, ButtonNavigationMenuActivity::class.java)
                        startActivity(intent)
                    }

                    false -> {
                        Toast.makeText(this, "Card cant be inserted", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
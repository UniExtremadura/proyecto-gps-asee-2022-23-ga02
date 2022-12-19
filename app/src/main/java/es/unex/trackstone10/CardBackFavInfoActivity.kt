package es.unex.trackstone10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.unex.trackstone10.databinding.ActivityCardBackInfoBinding
import es.unex.trackstone10.domain.CardBackModel

@AndroidEntryPoint
class CardBackFavInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCardBackInfoBinding

    private val trackstoneViewModel: TrackstoneViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardBackInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cardbacks = intent.getSerializableExtra("CARD_BACK_OBJ") as CardBackModel
        binding.cardBackDetailsName.text = cardbacks.name
        binding.cardBackDetail1.text = ""
        Glide.with(binding.cardBackDetails.context).load(cardbacks.image)
            .into(binding.cardBackDetails)

        binding.addCardBackFavorite.text = "Delete from Favorites"

        binding.addCardBackFavorite.setOnClickListener {
            trackstoneViewModel.deleteCardback(cardbacks.id)
            trackstoneViewModel.deleteFavoriteCardbackResult.observe(this, Observer {
                when (it) {
                    true -> {
                        val intent = Intent(this, ButtonNavigationMenuActivity::class.java)
                        startActivity(intent)
                    }

                    false -> {
                        Toast.makeText(this, "Cardback cant be deleted", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}
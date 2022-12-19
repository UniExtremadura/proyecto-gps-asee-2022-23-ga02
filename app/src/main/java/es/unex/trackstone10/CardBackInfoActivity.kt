package es.unex.trackstone10

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.unex.trackstone10.databinding.ActivityCardBackInfoBinding
import es.unex.trackstone10.domain.CardBackModel

@AndroidEntryPoint
class CardBackInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCardBackInfoBinding
    private val trackstoneViewModel: TrackstoneViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardBackInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cardBacks = intent.getSerializableExtra("CARD_BACK_OBJ") as CardBackModel
        binding.cardBackDetailsName.text = cardBacks.name
        binding.cardBackDetail1.text = ""
        Glide.with(binding.cardBackDetails.context).load(cardBacks.image)
            .into(binding.cardBackDetails)

        val sharedPreferences = getSharedPreferences("userid", Context.MODE_PRIVATE)
        var userId = sharedPreferences.getInt("userid", 0)

        binding.addCardBackFavorite.setOnClickListener {
            trackstoneViewModel.addCardback(cardBacks)
            trackstoneViewModel.addCardbackFavoriteResult.observe(this) {
                when (it) {
                    true -> {
                        val intent = Intent(this, ButtonNavigationMenuActivity::class.java)
                        startActivity(intent)
                    }

                    false -> {
                        Toast.makeText(this, "Cardback cant be inserted", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
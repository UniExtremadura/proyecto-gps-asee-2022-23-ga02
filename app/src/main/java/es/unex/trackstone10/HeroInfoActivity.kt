package es.unex.trackstone10

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.unex.trackstone10.databinding.ActivityHeroeSkinInfoBinding
import es.unex.trackstone10.domain.CardModel

@AndroidEntryPoint
class HeroInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroeSkinInfoBinding
    private val trackstoneViewModel: TrackstoneViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroeSkinInfoBinding.inflate(layoutInflater)
        val cards = intent.getSerializableExtra("CARD_OBJ") as CardModel
        setContentView(binding.root)
        Glide.with(binding.heroeSkinDetails).load(cards.info).into(binding.heroeSkinDetails)
        binding.heroeSkinDetailsName.text = cards.name
        binding.textViewArtist.text = "Artist: ${cards.artist}"

        val sharedPreferences = getSharedPreferences("userid", Context.MODE_PRIVATE)
        var userId = sharedPreferences.getInt("userid", 0)

        binding.addHeroeSkinFavorite.setOnClickListener{
            trackstoneViewModel.addHero(cards, userId)
            trackstoneViewModel.addHeroFavoriteResult.observe(this) {
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
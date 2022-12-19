package es.unex.trackstone10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.unex.trackstone10.databinding.ActivityHeroeSkinInfoBinding
import es.unex.trackstone10.domain.CardModel

@AndroidEntryPoint
class HeroFavInfoActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityHeroeSkinInfoBinding

    private val trackstoneViewModel : TrackstoneViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroeSkinInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val heroes = intent.getSerializableExtra("CARD_OBJ") as CardModel
        binding.heroeSkinDetailsName.text = heroes.name
        Glide.with(binding.heroeSkinDetails.context).load(heroes.info).into(binding.heroeSkinDetails)

        binding.addHeroeSkinFavorite.text = "Delete from Favorites"

        binding.addHeroeSkinFavorite.setOnClickListener {
            trackstoneViewModel.deleteHero(heroes.id)
            trackstoneViewModel.deleteFavoriteHeroesResult.observe(this, Observer {
                when(it){
                    true -> {
                        val intent = Intent(this, ButtonNavigationMenuActivity::class.java)
                        startActivity(intent)
                    }
                    false -> {
                        Toast.makeText(this, "Hero cant be deleted", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }

}
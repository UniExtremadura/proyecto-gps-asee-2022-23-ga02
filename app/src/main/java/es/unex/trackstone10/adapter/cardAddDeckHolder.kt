package es.unex.trackstone10.adapter

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.unex.trackstone10.databinding.ItemAddCardDeckBinding
import es.unex.trackstone10.di.RoomModule
import es.unex.trackstone10.domain.CardModel
import es.unex.trackstone10.roomdb.Entity.DeckListCardEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class cardAddDeckHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemAddCardDeckBinding.bind(view)
    private val handler = Handler(Looper.getMainLooper())


    fun render(cards: CardModel, id: Int?, user: Int?, context: Context) {
        binding.tvCard.text = cards.name

        Glide.with(binding.ivCard.context).load(cards.info).into(binding.ivCard)
        binding.AddCardDeckButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val db = RoomModule.provideRoom(context)
                if(db?.getDeckListDao()?.getCount(id)?:0 < 30) {
                    if (cards != null && id != null) {
                        val check = db?.getDeckListDao()?.checkCard(id, cards.name!!)
                        if (check?.size != 0) {
                            if (db.getDeckListDao()?.checkCopies(id, cards.name!!)!! == 1) {
                                db.getDeckListDao()?.incCopies(id, cards.name!!)
                                db.getDeckDao()?.AddingCards(id)
                            } else {
                                //error
                            }
                        } else {
                            db.getDeckListDao()?.insert(
                                DeckListCardEntity(
                                    id,
                                    user,
                                    cards.name,
                                    1,
                                    cards.rarity,
                                    cards.cardclass,
                                    cards.manacost,
                                    cards.info
                                )
                            )
                            db?.getDeckDao()?.AddingCards(id)
                        }
                    }
                }
                else{
                    handler.post {
                        Toast.makeText(context, "Has alcanzado el límite de cartas", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
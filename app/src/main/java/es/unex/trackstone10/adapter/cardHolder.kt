package es.unex.trackstone10.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import es.unex.trackstone10.databinding.ItemCardBinding
import es.unex.trackstone10.domain.CardModel

class cardHolder(view: View) : ViewHolder(view) {

    val binding = ItemCardBinding.bind(view)


    fun render(cards: CardModel, onClickListener: (CardModel) -> Unit){
        binding.tvCard.text = cards.name
        when (cards.rarity){
            1 -> binding.tvCard2.text = "40"
            2 -> binding.tvCard2.text = "Free"
            3 -> binding.tvCard2.text = "100"
            4 -> binding.tvCard2.text = "400"
            5 -> binding.tvCard2.text = "1600"
        }
        Glide.with(binding.ivCard.context).load(cards.info).into(binding.ivCard)
        itemView.setOnClickListener{ onClickListener(cards) }
    }
}
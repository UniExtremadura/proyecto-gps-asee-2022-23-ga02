package es.unex.trackstone10.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.unex.trackstone10.databinding.ItemCardBinding
import es.unex.trackstone10.domain.CardModel

class heroHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemCardBinding.bind(view)

    fun render(cards: CardModel, onClickListener: (CardModel) -> Unit) {
        binding.tvCard.text = cards.name


        Glide.with(binding.ivCard.context).load(cards.info).into(binding.ivCard)
        itemView.setOnClickListener{ onClickListener(cards) }
    }
}
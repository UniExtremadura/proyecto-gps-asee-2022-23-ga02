package es.unex.trackstone10.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.unex.trackstone10.databinding.ItemAddCardDeckBinding
import es.unex.trackstone10.domain.CardModel

class editCardDeckHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemAddCardDeckBinding.bind(view)

    fun render(
        cards: CardModel,
        onClickDeleted:(Int) -> Unit
    ) {
        binding.AddCardDeckButton.text = "Delete Card"
        binding.tvCard.text = cards.name
        Glide.with(binding.ivCard.context).load(cards.info).into(binding.ivCard)
        binding.AddCardDeckButton.setOnClickListener { onClickDeleted(adapterPosition) }
    }
}
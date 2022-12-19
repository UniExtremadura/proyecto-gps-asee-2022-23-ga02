package es.unex.trackstone10.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.unex.trackstone10.databinding.ItemCardBinding
import es.unex.trackstone10.domain.CardBackModel

class cardbackHolderFav(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemCardBinding.bind(view)

    fun render(cardbacks: CardBackModel, onClickListener: (CardBackModel) ->  Unit){
        if(cardbacks != null){
            binding.tvCard.text = cardbacks.name
            binding.tvCard2.text = ""
            Glide.with(binding.ivCard.context).load(cardbacks.image).into(binding.ivCard)
            itemView.setOnClickListener { onClickListener(cardbacks) }
        }
    }
}
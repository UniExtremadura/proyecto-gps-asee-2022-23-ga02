package es.unex.trackstone10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.unex.trackstone10.R
import es.unex.trackstone10.domain.CardModel

class cardAdapterFav(private val onClickListener: (CardModel) -> Unit) :
    RecyclerView.Adapter<cardHolderFav>() {

    private var cardList: List<CardModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardHolderFav {
        val layoutInflater = LayoutInflater.from(parent.context)
        return cardHolderFav(layoutInflater.inflate(R.layout.item_card, parent, false))
    }

    override fun onBindViewHolder(holder: cardHolderFav, position: Int) {
        val item = cardList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = cardList.size

    fun swap(cardList2: List<CardModel>) {
        cardList = cardList2
        notifyDataSetChanged()
    }

    fun clear() {
        cardList = emptyList()
        notifyDataSetChanged()
    }
}
package es.unex.trackstone10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.unex.trackstone10.R
import es.unex.trackstone10.domain.CardModel

class cardAdapter( private val onClickListener: (CardModel) -> Unit) : RecyclerView.Adapter<cardHolder>() {

    private var cardsList: List<CardModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return cardHolder(layoutInflater.inflate(R.layout.item_card, parent, false))
    }

    override fun onBindViewHolder(holder: cardHolder, position: Int) {
        val item = cardsList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = cardsList.size

    fun swap(cardlist2: List<CardModel>){
        cardsList = cardlist2
        notifyDataSetChanged()
    }

    fun clear(){
        cardsList = emptyList()
        notifyDataSetChanged()
    }

}
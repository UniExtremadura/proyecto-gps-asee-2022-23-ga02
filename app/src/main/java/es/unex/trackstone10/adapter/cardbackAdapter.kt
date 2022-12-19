package es.unex.trackstone10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.unex.trackstone10.R
import es.unex.trackstone10.domain.CardBackModel

class cardbackAdapter(private val onClickListener: (CardBackModel) -> Unit) :
    RecyclerView.Adapter<cardbackHolder>() {
    private var cardbacksList: List<CardBackModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardbackHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return cardbackHolder(layoutInflater.inflate(R.layout.item_card, parent, false))
    }

    override fun onBindViewHolder(holder: cardbackHolder, position: Int) {
        val item = cardbacksList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = cardbacksList.size

    fun swap(cbList: List<CardBackModel>) {
        cardbacksList = cbList
        notifyDataSetChanged()
    }

    fun clear() {
        cardbacksList = emptyList()
        notifyDataSetChanged()
    }
}

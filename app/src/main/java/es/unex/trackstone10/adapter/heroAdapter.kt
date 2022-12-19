package es.unex.trackstone10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.unex.trackstone10.R
import es.unex.trackstone10.domain.CardModel

class heroAdapter(private val onClickListener: (CardModel) -> Unit) :
    RecyclerView.Adapter<heroHolder>() {

    private var heroesList: List<CardModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): heroHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return heroHolder(layoutInflater.inflate(R.layout.item_card, parent, false))
    }

    override fun onBindViewHolder(holder: heroHolder, position: Int) {
        val item = heroesList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = heroesList.size

    fun swap(heroList2: List<CardModel>) {
        heroesList = heroList2
        notifyDataSetChanged()
    }

    fun clear() {
        heroesList = emptyList()
        notifyDataSetChanged()
    }
}
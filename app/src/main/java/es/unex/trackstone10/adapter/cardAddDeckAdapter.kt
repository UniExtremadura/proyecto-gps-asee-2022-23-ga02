package es.unex.trackstone10.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.unex.trackstone10.R
import es.unex.trackstone10.domain.CardModel

class cardAddDeckAdapter(var id:Int?, var user:Int?,var conText: Context) : RecyclerView.Adapter<cardAddDeckHolder>() {

    private var cardsList: List<CardModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardAddDeckHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return cardAddDeckHolder(layoutInflater.inflate(R.layout.item_add_card_deck, parent, false))
    }

    override fun onBindViewHolder(holder: cardAddDeckHolder, position: Int) {
        val item = cardsList[position]
        holder.render(item,id,user, conText)
    }

    override fun getItemCount(): Int = cardsList.size


    fun swap(cdList: List<CardModel>){
        cardsList = cdList
        notifyDataSetChanged()
    }

    fun clear(){
        cardsList = emptyList()
        notifyDataSetChanged()
    }
}
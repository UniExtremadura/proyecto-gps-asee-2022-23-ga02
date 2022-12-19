package es.unex.trackstone10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.unex.trackstone10.R
import es.unex.trackstone10.domain.CardModel

class HeroFavAdapter(private val onClickListener: (CardModel) -> Unit) : RecyclerView.Adapter<HeroFavHolder>() {

    private var favHeroList: List<CardModel> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroFavHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroFavHolder(layoutInflater.inflate(R.layout.item_card,parent,false))
    }

    override fun onBindViewHolder(holder: HeroFavHolder, position: Int) {
        val item = favHeroList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = favHeroList.size

    fun swap(heroList2: List<CardModel>) {
        favHeroList = heroList2
        notifyDataSetChanged()
    }

    fun clear() {
        favHeroList = emptyList()
        notifyDataSetChanged()
    }
}
package es.unex.trackstone10.ui.home.fragments

import android.content.Intent
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import es.unex.trackstone10.HeroInfoActivity


class HeroesFragment : Fragment(), SearchView.OnQueryTextListener {


    private fun onItemSelected(cards: CardResponse) {
        val intent: Intent = Intent(activity, HeroInfoActivity::class.java)
        intent.putExtra("CARD_OBJ", cards)
        startActivity(intent)
    }
}
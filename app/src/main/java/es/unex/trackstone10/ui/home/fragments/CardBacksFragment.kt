package es.unex.trackstone10.ui.home.fragments


import android.content.Intent
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import es.unex.trackstone10.CardBackInfoActivity


class CardBacksFragment : Fragment(), SearchView.OnQueryTextListener {

    private fun onItemSelected(cardbacks: CardBackResponse){
        val intent: Intent = Intent(activity, CardBackInfoActivity::class.java)
        intent.putExtra("CARD_BACK_OBJ",cardbacks)
        startActivity(intent)

    }

}
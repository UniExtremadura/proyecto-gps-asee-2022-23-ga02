package es.unex.trackstone10.ui.favorites.fragments


import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import es.unex.trackstone10.databinding.FragmentHeroesBinding


class HeroesFavoritesFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentHeroesBinding

    override fun onQueryTextSubmit(query: String?): Boolean {

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {

        return true
    }


}
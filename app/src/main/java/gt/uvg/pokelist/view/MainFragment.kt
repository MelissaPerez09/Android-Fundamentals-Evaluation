package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.R
import gt.uvg.pokelist.repository.PokemonRepository

class MainFragment: Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*New val for RecyclerView*/
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val repository = PokemonRepository()
        val adapter = PokemonListAdapter(repository.pokemonList)

        /*Starts doing the adapter*/
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapter
        val pokemonList = repository.getPokemonList(adapter)

        /*Divides depending on the context*/
        recyclerView.addItemDecoration(
            DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL)
        )
    }

    /*Retrieve the layout for the fragment*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}
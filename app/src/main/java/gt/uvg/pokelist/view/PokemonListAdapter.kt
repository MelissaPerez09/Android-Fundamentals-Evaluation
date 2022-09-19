package gt.uvg.pokelist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.databinding.ItemPokemonViewBinding
import gt.uvg.pokelist.model.Pokemon

class PokemonListAdapter(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonListAdapter.PokemonListHolder>() {

    inner class PokemonListHolder(val binding: ItemPokemonViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListHolder {
        val binding = ItemPokemonViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) {
        /*Invoke the layout manager to implement the pictures*/
        val poke = pokemonList[position]
        holder.binding.pokemonName.text = poke.name
        Picasso.get().load(poke.imageUrlFront).into(holder.binding.pokemonPhoto)

        /*Generates the action for the fragment*/
        val action = MainFragmentDirections.actionMainFragmentToDetailFragment(poke)
        holder.binding.root.setOnClickListener{
            holder.itemView.findNavController().navigate(action)
        }
    }

    /*Returns the size of the dataset*/
    override fun getItemCount(): Int {
        return pokemonList.size
    }
}
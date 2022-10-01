package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R

class DetailFragment : Fragment() {
    private val thisPokemon by navArgs<DetailFragmentArgs>()

    /*Retrieve the layout for the fragment*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    /*Picasso for images*/
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?) {

        var pic: ImageView = view.findViewById(R.id.front)
        super.onViewCreated(view, savedInstanceState)
        Picasso.get().load(thisPokemon.pokemonID.imageUrlFront).into(pic)
        pic = view.findViewById(R.id.back)
        Picasso.get().load(thisPokemon.pokemonID.imageUrlBack).into(pic)
        pic = view.findViewById(R.id.frontShinny)
        Picasso.get().load(thisPokemon.pokemonID.imageUrlShinnyFront).into(pic)
        pic = view.findViewById(R.id.backShinny)
        Picasso.get().load(thisPokemon.pokemonID.imageUrlShinnyBack).into(pic)
    }
}
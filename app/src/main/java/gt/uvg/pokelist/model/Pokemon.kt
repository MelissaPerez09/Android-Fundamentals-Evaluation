package gt.uvg.pokelist.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.StringRes

data class Pokemon(
    @StringRes
    val id: Int,
    val name: String?
    ){

    val imageUrlFront: String get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
    val imageUrlBack: String get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/$id.png"
    val imageUrlShinnyFront: String get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/$id.png"
    val imageUrlShinnyBack: String get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/$id.png"
}
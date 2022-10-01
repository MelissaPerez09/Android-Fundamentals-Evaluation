package gt.uvg.pokelist.repository

import android.util.Log
import gt.uvg.pokelist.model.GetFirst100Pokemon
import gt.uvg.pokelist.model.PokeAPI
import gt.uvg.pokelist.model.Pokemon
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import gt.uvg.pokelist.view.PokemonListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class PokemonRepository {
    val pokemonList = mutableListOf<Pokemon>()
    fun getPokemonList(adapter: PokemonListAdapter): List<Pokemon> {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        val pokeA: PokeAPI = retrofit.create(PokeAPI::class.java)

        pokeA.getFirst100Pokemon().enqueue(object: Callback<GetFirst100Pokemon>{
            override fun onResponse(call: Call<GetFirst100Pokemon>, response: Response<GetFirst100Pokemon>) {
                Log.i("API'S RESPONSE", response.toString())
                val body = response.body()!!
                var i: Int = 1

                for (pokemon in body.result) {
                    pokemonList.add(Pokemon(i++, pokemon.name))
                }
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<GetFirst100Pokemon>, t: Throwable) {
                Log.i("FAIL", t.message ?: "Null Message")
            }
        })
        return pokemonList
    }
}
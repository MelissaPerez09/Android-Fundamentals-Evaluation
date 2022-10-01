package gt.uvg.pokelist.model

data class GetFirst100Pokemon(
    val count: Int = 0,
    val next: String = "",
    val previous: String? = "",
    val result: List<ResultPokemon> = listOf()
) {
    data class ResultPokemon(
        val name : String,
        val url: String,
    )
}
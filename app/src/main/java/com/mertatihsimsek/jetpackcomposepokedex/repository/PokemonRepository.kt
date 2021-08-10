package com.mertatihsimsek.jetpackcomposepokedex.repository

import com.mertatihsimsek.jetpackcomposepokedex.data.remote.PokeApi
import com.mertatihsimsek.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.mertatihsimsek.jetpackcomposepokedex.data.remote.responses.PokemonList
import com.mertatihsimsek.jetpackcomposepokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }

}
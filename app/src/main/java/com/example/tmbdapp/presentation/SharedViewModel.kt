package com.example.tmbdapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmbdapp.core.utils.Constants
import com.example.tmbdapp.core.utils.NetworkResponse
import com.example.tmbdapp.domain.model.Movie
import com.example.tmbdapp.domain.model.MovieDetails
import com.example.tmbdapp.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val movieRepo: MovieRepository
) : ViewModel() {
    var state by mutableStateOf(SharedState())
    fun onEvent(event: SharedEvent) {
        when (event) {
            is SharedEvent.QueryChanged -> {
                state = state.copy(query = event.query)
            }
            is SharedEvent.SearchMovies -> {
                //TODO navigate to search screen, non existant yet
                state = state.copy(searchList = mutableListOf())
                searchMovies(query = state.query)
            }
            is SharedEvent.TabClicked ->{
                state = state.copy(tabPage = event.index)
                changeDashboard(tab = event.tab)
            }
        }
}

    init {
        getNowPlaying()
        getUpcoming()
        getPopular()
        getTopRated()
    }

   private fun getNowPlaying(){
    viewModelScope.launch {
        movieRepo.getNowPlayingMovies().collectLatest { networkResponse ->
            val moviesList = networkResponse.data
            when(networkResponse){
                is NetworkResponse.Success ->{
                    if(moviesList != null){
                        state = state.copy(nowPlaying = moviesList)
                    }
                    }
                is NetworkResponse.Error -> {
                    state = state.copy( isError = true )
                    }
                is NetworkResponse.Loading -> Unit
                }
            }
        }
    }

    private fun getUpcoming(){
        viewModelScope.launch {
            movieRepo.getUpcomingMovies().collectLatest { networkResponse ->
                val moviesList = networkResponse.data
                when(networkResponse){
                    is NetworkResponse.Success ->{
                        if(moviesList != null){
                            state = state.copy(upcoming = moviesList)
                        }
                    }
                    is NetworkResponse.Error -> {
                        state = state.copy( isError = true )
                    }
                    is NetworkResponse.Loading -> Unit
                }
            }
        }
    }

    private fun getPopular(){
        viewModelScope.launch {
            movieRepo.getPopularMovies().collectLatest { networkResponse ->
                val moviesList = networkResponse.data
                when(networkResponse){
                    is NetworkResponse.Success ->{
                        if(moviesList != null){
                            state = state.copy(popular = moviesList)
                        }
                    }
                    is NetworkResponse.Error -> {
                        state = state.copy( isError = true )
                    }
                    is NetworkResponse.Loading -> Unit
                }
            }
        }
    }
    private fun getTopRated(){
        viewModelScope.launch {
            movieRepo.getTopRatedMovies().collectLatest { networkResponse ->
                val moviesList = networkResponse.data
                when(networkResponse){
                    is NetworkResponse.Success ->{
                        if(moviesList != null){
                            state = state.copy(topRated = moviesList)
                        }
                    }
                    is NetworkResponse.Error -> {
                        state = state.copy( isError = true )
                    }
                    is NetworkResponse.Loading -> Unit
                }
            }
        }
    }

    private fun searchMovies(query : String){
        viewModelScope.launch {
            movieRepo.getSearch(query = query).collectLatest { networkResponse ->
                val idList = networkResponse.data
                when(networkResponse){
                    is NetworkResponse.Success ->{
                        idList?.forEach { id ->
                            getMovieDetails(id)
                        }
                    }
                    is NetworkResponse.Error -> {
                        state = state.copy( isError = true )
                    }
                    is NetworkResponse.Loading -> Unit
                }
            }
        }
    }

    private fun getMovieDetails(id : Int){
        viewModelScope.launch {
            movieRepo.getMovieDetails(id = id).collectLatest { networkResponse ->
                val movieDetails = networkResponse.data
                when(networkResponse){
                    is NetworkResponse.Success -> {
                        if(movieDetails != null){
                            val newList = state.searchList
                            newList.add(movieDetails)
                            state = state.copy(searchList = newList)
                        }
                    }
                    is NetworkResponse.Error -> {
                        state = state.copy( isError = true )
                    }
                    is NetworkResponse.Loading -> Unit
                }
            }
        }
    }

    private fun changeDashboard(tab : Constants.Tabs){
        when(tab){
            Constants.Tabs.NOW_PLAYING -> {
                state = state.copy(tabMovies = state.nowPlaying)
            }
            Constants.Tabs.UPCOMING -> {
                state = state.copy(tabMovies = state.upcoming)
            }
            Constants.Tabs.TOP_RATED -> {
                state = state.copy(tabMovies = state.topRated)
            }
            Constants.Tabs.POPULAR -> {
                state = state.copy(tabMovies = state.popular)
            }
        }
    }
}

data class SharedState(
    val shouldShowSearch: Boolean = false,
    val isError: Boolean = false,
    val nowPlaying : List<Movie> = listOf(),
    val upcoming : List<Movie> = listOf(),
    val popular : List<Movie> = listOf(),
    val topRated : List<Movie> = listOf(),
    val tabMovies : List<Movie> = listOf(),
    val tabPage : Int = 0,
    val query: String = String(),
    val searchList : MutableList<MovieDetails> = mutableListOf()
    )
sealed class SharedEvent {
    data class QueryChanged(val query: String) : SharedEvent()
    object SearchMovies : SharedEvent()
    data class TabClicked(val index : Int, val tab : Constants.Tabs) : SharedEvent()
}

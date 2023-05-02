package com.example.tmbdapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmbdapp.core.utils.Constants
import com.example.tmbdapp.core.utils.NetworkResponse
import com.example.tmbdapp.domain.model.Movie
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
                state = state.copy(searchList = listOf())
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
                        state = state.copy(nowPlaying = moviesList, tabMovies = moviesList)
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
                when(networkResponse){
                    is NetworkResponse.Success ->{
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
        state = when(tab){
            Constants.Tabs.NOW_PLAYING -> {
                state.copy(tabMovies = state.nowPlaying)
            }
            Constants.Tabs.UPCOMING -> {
                state.copy(tabMovies = state.upcoming)
            }
            Constants.Tabs.TOP_RATED -> {
                state.copy(tabMovies = state.topRated)
            }
            Constants.Tabs.POPULAR -> {
                state.copy(tabMovies = state.popular)
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
    val searchList : List<Movie> = listOf(),
    val shouldShowBottomNavBar : Boolean = true
    )
sealed class SharedEvent {
    data class QueryChanged(val query: String) : SharedEvent()
    object SearchMovies : SharedEvent()
    data class TabClicked(val index : Int, val tab : Constants.Tabs) : SharedEvent()
}

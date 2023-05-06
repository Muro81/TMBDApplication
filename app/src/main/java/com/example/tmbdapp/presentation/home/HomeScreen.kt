package com.example.tmbdapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmbdapp.R
import com.example.tmbdapp.core.components.SearchBar
import com.example.tmbdapp.presentation.SharedEvent
import com.example.tmbdapp.presentation.SharedViewModel
import com.example.tmbdapp.ui.theme.Gray2
import com.example.tmbdapp.ui.theme.White

@Composable
fun HomeScreen(
    viewModel: SharedViewModel,
    toSearchScreen : () ->Unit,
    getMovieDetails : () -> Unit
) {
    val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray2)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
                .weight(0.1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
                ){
            Text(
                text = stringResource(id = R.string.watch),
                fontSize = 18.sp,
                color = White,
                fontWeight = FontWeight.Bold
                )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f)
                .padding(horizontal = 24.dp)
        ) {
            SearchBar(
                value = state.query,
                placeholder = stringResource(id = R.string.search),
                isError = state.isError,
                onTextChanged = {
                        query ->
                    viewModel.onEvent(SharedEvent.QueryChanged(query = query))
                }
            ) {
                viewModel.onEvent(SharedEvent.SearchMovies)
                toSearchScreen()
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                .padding(horizontal = 24.dp)
                ){
            TopMovies(topMovies = state.popular){ movie ->
                viewModel.onEvent(SharedEvent.MovieClicked(movie))
                getMovieDetails()
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                ) {
            Dashboard(
                nowPlaying = state.nowPlaying,
                popular = state.popular,
                upcoming = state.upcoming,
                topRated = state.topRated
               ){ movie ->
                viewModel.onEvent(SharedEvent.MovieClicked(movie))
                getMovieDetails()
            }
        }

    }
}
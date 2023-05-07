package com.example.tmbdapp.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.tmbdapp.R
import com.example.tmbdapp.domain.model.Movie

@Composable
fun TopMovies(
    topMovies : List<Movie>,
    goToDetails : (movie : Movie) ->Unit
) {
    LazyRow(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(30.dp)
    ){
        items(topMovies){ movie: Movie ->
            AsyncImage(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .height(210.dp)
                    .width(140.dp)
                    .clickable {
                               goToDetails(movie)
                    },
                model = stringResource(id = R.string.poster_template,movie.poster),
                contentDescription =null,
            contentScale = ContentScale.Crop)
        }
    }
}

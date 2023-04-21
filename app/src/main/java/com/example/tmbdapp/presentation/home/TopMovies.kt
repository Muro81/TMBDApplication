package com.example.tmbdapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun TopMovies(
    topMovies : List<String>
    // will be changed to Movie after API implementation
) {
    LazyRow(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(30.dp)
    ){
        items(topMovies){ item: String ->
            Image(painter = rememberAsyncImagePainter(model = item), contentDescription =null)
        }
    }
}

package com.example.tmbdapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.tmbdapp.ui.theme.TMBDAppTheme

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

@Preview(showBackground = true)
@Composable
fun TopMoviesPreview(){
    TMBDAppTheme{
        TopMovies(topMovies = listOf("https://image.tmdb.org/t/p/original/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg",
            "https://image.tmdb.org/t/p/original/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg",
            "https://image.tmdb.org/t/p/original/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg",
            "https://image.tmdb.org/t/p/original/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg",
            "https://image.tmdb.org/t/p/original/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg"))
    }
}
package com.example.tmbdapp.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tmbdapp.R
import com.example.tmbdapp.ui.theme.Black
import com.example.tmbdapp.ui.theme.TMDBAppTheme


@Composable 
fun SplashScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
    ){
        Image(
            painter = painterResource(id = R.drawable.popcorn_illustration),
            contentDescription = null,
            modifier = Modifier
                .size(189.dp)
                .align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    TMDBAppTheme{
        SplashScreen()
    }
}
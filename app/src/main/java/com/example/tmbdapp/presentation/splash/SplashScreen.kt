package com.example.tmbdapp.presentation.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tmbdapp.R
import com.example.tmbdapp.ui.theme.Black
import com.example.tmbdapp.ui.theme.TMDBAppTheme
import kotlinx.coroutines.delay


@Composable 
fun SplashScreen(
    goHome : () -> Unit
) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(2000)
        goHome()
    }

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
                .alpha(alphaAnim.value)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    TMDBAppTheme{
        SplashScreen(){}
    }
}
package com.example.tmbdapp.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmbdapp.R
import com.example.tmbdapp.ui.theme.Blue
import com.example.tmbdapp.ui.theme.LightGray
import com.example.tmbdapp.ui.theme.Orange
import com.example.tmbdapp.ui.theme.White
import kotlin.math.roundToInt

@Composable
fun RateAppComponent(
    closeSheet : () -> Unit
) {
    var sliderValue by remember {
        mutableStateOf(5f)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(265.dp)
            .background(White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.rate_movie),
                fontSize = 18.sp,
                color = LightGray
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.rating_template,sliderValue.roundToInt()),
                fontSize = 32.sp,
                color = LightGray
                )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Slider(
                value = sliderValue,
                onValueChange ={
                    sliderValue = it
                },
            colors = SliderDefaults.colors(
                thumbColor = White,
                activeTrackColor = Orange,
                inactiveTrackColor = LightGray,
                activeTickColor = Orange,
                inactiveTickColor = LightGray
            ),
                valueRange = 0f..10f,
                steps = 4
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
                Button(
                    onClick = { closeSheet()
                              sliderValue = 5f},
                    modifier = Modifier
                        .width(220.dp)
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Blue
                    ),
                    shape = RoundedCornerShape(28.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.ok),
                        textAlign = TextAlign.Center,
                        color = White,
                        fontSize = 16.sp
                    )
                }
        }
    }
}
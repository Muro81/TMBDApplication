package com.example.tmbdapp.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tmbdapp.R
import com.example.tmbdapp.domain.model.Movie
import com.example.tmbdapp.ui.theme.Gray
import com.example.tmbdapp.ui.theme.Orange
import com.example.tmbdapp.ui.theme.White

@Composable
fun MovieIllustrationsComponent(
    movie : Movie,
    onStarClicked : () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .clip(RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp))
                .align(alignment = Alignment.TopStart),
            model = stringResource(id = R.string.poster_template, movie.backdrop),
            contentDescription = null,
            contentScale = ContentScale.Crop)
        AsyncImage(
            modifier = Modifier
                .padding(start = 29.dp, bottom = 50.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .height(130.dp)
                .width(95.dp)
                .align(alignment = Alignment.BottomStart),
            model = stringResource(id = R.string.poster_template,movie.poster),
            contentDescription = null,
            contentScale = ContentScale.Crop)
        Text(
            text = movie.title,
            fontWeight = FontWeight.Bold,
            color = White,
            fontSize = 18.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 35.dp, bottom = 75.dp)
        )
        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(top = 55.dp, end = 30.dp)
                .clip(CircleShape)
                .background(Gray)
                .width(55.dp)
                .height(26.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = {
                          onStarClicked()
                },
            content = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Icon(
                        painter = painterResource(id =  R.drawable.rates_ic),
                        contentDescription = null,
                        tint = Orange
                    )
                    Text(
                        text = movie.votes.toString(),
                        fontSize = 12.sp,
                        color = Orange,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            )
        }
    }
}
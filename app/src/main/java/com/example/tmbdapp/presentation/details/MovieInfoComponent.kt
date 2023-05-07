package com.example.tmbdapp.presentation.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmbdapp.R
import com.example.tmbdapp.core.utils.toYear
import com.example.tmbdapp.domain.model.Movie
import com.example.tmbdapp.ui.theme.Gray
import com.example.tmbdapp.ui.theme.GrayText

@Composable
fun MovieInfoComponent(
    movie : Movie
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 65.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
            ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            Icon(
                painter = painterResource(id =  R.drawable.date_ic),
                contentDescription = null,
                tint = GrayText
            )
            Text(
                text = movie.date.toYear(),
                fontSize = 12.sp,
                color = GrayText
            )
        }
        Divider(
            color = Gray,
            modifier = Modifier
                .height(25.dp)
                .width(1.dp)
        )
        Row (
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            Icon(
                painter = painterResource(id =  R.drawable.runtime_ic),
                contentDescription = null,
                tint = GrayText
            )
            Text(
                text = stringResource(id = R.string.runtime_template,movie.runtime),
                fontSize = 12.sp,
                color = GrayText
            )
        }
        Divider(
            color = Gray,
            modifier = Modifier
                .height(25.dp)
                .width(1.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            Icon(
                painter = painterResource(id =  R.drawable.genre_ic),
                contentDescription = null,
                tint = GrayText,
                modifier = Modifier.padding(top = 3.dp)
            )
            Text(
                text = movie.genre,
                fontSize = 12.sp,
                color = GrayText
            )
        }
    }
}
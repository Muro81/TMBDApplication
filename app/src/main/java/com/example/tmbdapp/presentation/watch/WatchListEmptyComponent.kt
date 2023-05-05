package com.example.tmbdapp.presentation.watch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmbdapp.R
import com.example.tmbdapp.ui.theme.Gray2
import com.example.tmbdapp.ui.theme.GrayText
import com.example.tmbdapp.ui.theme.White

@Composable
fun WatchListEmptyComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 93.dp,end = 93.dp,top = 269.dp)
            .background(Gray2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(
            modifier = Modifier
                .size(76.dp),
            painter = painterResource(id = R.drawable.watch_list_empty),
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.watch_list_empty_1),
            fontSize = 16.sp,
            color = White,
            textAlign = TextAlign.Center,
            maxLines = 1,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = R.string.watch_list_empty_2),
            fontSize = 12.sp,
            color = GrayText,
            textAlign = TextAlign.Center,
            maxLines = 2
        )
    }
    
}
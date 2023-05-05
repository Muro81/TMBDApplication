package com.example.tmbdapp.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmbdapp.R
import com.example.tmbdapp.ui.theme.Gray
import com.example.tmbdapp.ui.theme.Gray2
import com.example.tmbdapp.ui.theme.TMDBAppTheme
import com.example.tmbdapp.ui.theme.White

@Composable
fun SearchListErrorComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 93.dp,end = 93.dp,top = 144.dp)
            .background(Gray2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Image(
            modifier = Modifier
                .size(76.dp),
            painter = painterResource(id = R.drawable.no_results_search),
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.search_error_1),
            fontSize = 16.sp,
            color = White,
            textAlign = TextAlign.Center,
            maxLines = 2
            )
        Text(
            text = stringResource(id = R.string.search_error_2),
            fontSize = 12.sp,
            color = Gray,
            textAlign = TextAlign.Center,
            maxLines = 2
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchListErrorPreview(){
    TMDBAppTheme{
        SearchListErrorComponent()
    }
}
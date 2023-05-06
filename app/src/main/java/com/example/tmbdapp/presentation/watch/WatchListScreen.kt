package com.example.tmbdapp.presentation.watch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmbdapp.R
import com.example.tmbdapp.core.components.MoviesListComponent
import com.example.tmbdapp.presentation.SharedEvent
import com.example.tmbdapp.presentation.SharedViewModel
import com.example.tmbdapp.ui.theme.Gray2
import com.example.tmbdapp.ui.theme.White

@Composable
fun WatchListScreen(
    viewModel : SharedViewModel,
    onArrowClicked : () -> Unit,
    getMovieDetails : () -> Unit
) {
    val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray2)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp, start = 20.dp, end = 20.dp)
                .weight(0.1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(94.dp)
        ) {
            IconButton(
                onClick = { onArrowClicked() },
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.back_arrow_ic),
                        contentDescription = null,
                        tint = White
                    )
                }
            )
            Text(
                text = stringResource(id = R.string.watch_list),
                color = White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.9f)
        ){
            if(state.watchList.isEmpty()) WatchListEmptyComponent()
            else MoviesListComponent(movies = state.watchList){ movie ->
                viewModel.onEvent(SharedEvent.MovieClicked(movie))
                getMovieDetails()

            }
        }
    }
}
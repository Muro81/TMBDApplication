package com.example.tmbdapp.presentation.search

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmbdapp.R
import com.example.tmbdapp.core.components.SearchBar
import com.example.tmbdapp.presentation.SharedEvent
import com.example.tmbdapp.presentation.SharedViewModel
import com.example.tmbdapp.ui.theme.Gray2
import com.example.tmbdapp.ui.theme.White

@Composable
fun SearchScreen(
    viewModel : SharedViewModel,
    onArrowClicked : () -> Unit
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
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { onArrowClicked() },
                content = {
                    Icon(
                    painter = painterResource(id =  R.drawable.back_arrow_ic),
                    contentDescription = null,
                    tint = White
                    )
                }
            )
            Text(
                text = stringResource(id = R.string.search),
                color = White,
                fontSize = 16.sp
                )
            Icon(
                painter = painterResource(id =  R.drawable.info_ic),
                contentDescription = null,
                tint = White
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 29.dp, end = 15.dp)
                .weight(0.1f)
        ) {
            SearchBar(
                value = state.query,
                placeholder = stringResource(id = R.string.search),
                isError = state.isError,
                onTextChanged = { query ->
                    viewModel.onEvent(SharedEvent.QueryChanged(query = query))
                }
            ) {
                viewModel.onEvent(SharedEvent.SearchMovies)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)
        ) {
            if(state.isError || state.searchList.isEmpty()){
                SearchListErrorComponent()
            }
            else{
            SearchListComponent(movies = state.searchList)
            }
        }
    }

}
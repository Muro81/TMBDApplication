package com.example.tmbdapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmbdapp.R
import com.example.tmbdapp.core.components.SearchBar
import com.example.tmbdapp.core.utils.Constants.topMovies
import com.example.tmbdapp.presentation.SharedViewModel
import com.example.tmbdapp.ui.theme.Gray2
import com.example.tmbdapp.ui.theme.White

@Composable
fun HomeScreen(
    viewModel: SharedViewModel
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray2)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
                .weight(0.1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
                ){
            Text(text = stringResource(id = R.string.watch),
            fontSize = 18.sp,
            color = White,
                )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f)
                .padding(horizontal = 24.dp)
        ) {
            SearchBar(value = "", placeholder = stringResource(id = R.string.placeholder), isError =false , onTextChanged ={} ) {
                //TODO update with API
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                .padding(horizontal = 24.dp)
                ){
            TopMovies(topMovies = topMovies)
            //TODO update with API
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                ) {
            Dashboard(selectedTabIndex = 0, onClickedTab = {})
            //TODO update with API
        }

    }
}
package com.example.tmbdapp.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmbdapp.R
import com.example.tmbdapp.presentation.SharedEvent
import com.example.tmbdapp.presentation.SharedViewModel
import com.example.tmbdapp.ui.theme.Gray2
import com.example.tmbdapp.ui.theme.White
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailsScreen(
    viewModel : SharedViewModel,
    onArrowClicked : () -> Unit
) {
    val state = viewModel.state
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    ModalBottomSheetLayout(
        sheetContent ={
            RateAppComponent{
                scope.launch{
                    sheetState.hide()
                }
            }
        },
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp),
        sheetBackgroundColor = White,
        sheetElevation = 5.dp
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Gray2)
                .blur(  if(sheetState.isVisible) 28.dp
                        else 0.dp)
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
                    text = stringResource(id = R.string.detail),
                    color = White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                IconButton(
                    onClick = {
                        if(state.detailMovie != null)
                            viewModel.onEvent(SharedEvent.MovieBookmark(movie = state.detailMovie ))
                    },
                    content = {
                        Icon(
                            painter = painterResource(id =  if(state.isBookmarked){
                                R.drawable.bookmark_true_ic
                            }
                            else R.drawable.bookmark_false_ic
                            ),
                            contentDescription = null,
                            tint = White
                        )
                    })
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f),
            ){
                if(state.detailMovie != null)
                    MovieIllustrationsComponent(movie = state.detailMovie ){
                        scope.launch{
                            sheetState.show()
                        }
                    }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.1f),
            ){
                if(state.detailMovie != null)
                    MovieInfoComponent(movie = state.detailMovie)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f),
            ){
                if(state.detailMovie != null)
                    MovieDetailsDashboardComponent(
                        movie = state.detailMovie,
                        reviews = state.reviews,
                        cast = state.cast,
                    )
            }
        }
    }
}
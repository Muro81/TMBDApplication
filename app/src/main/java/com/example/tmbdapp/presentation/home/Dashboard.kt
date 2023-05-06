package com.example.tmbdapp.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmbdapp.core.utils.Constants
import com.example.tmbdapp.core.utils.enumToName
import com.example.tmbdapp.domain.model.Movie
import com.example.tmbdapp.ui.theme.Gray2
import com.example.tmbdapp.ui.theme.LightGray
import com.example.tmbdapp.ui.theme.TMDBAppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Dashboard(
    nowPlaying : List<Movie>,
    popular : List<Movie>,
    upcoming : List<Movie>,
    topRated : List<Movie>,
    goToDetails : (movie : Movie) ->Unit
) {
    val pagerState : PagerState = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                        .height(4.dp)
                        .padding(horizontal = 28.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(color = LightGray)
                )
            }
        ) {
            Constants.Tabs.values().forEachIndexed { index, tabs ->
                Tab(
                    modifier = Modifier
                        .background(Gray2),
                    selected = index == pagerState.currentPage,
                    onClick = {
                              scope.launch {
                                  pagerState.scrollToPage(index)
                              }
                              },
                    text = { Text(text = tabs.name.enumToName(), maxLines = 1, fontSize = 9.sp, fontWeight = FontWeight.Bold) }
                )
            }
        }
        HorizontalPager(
            pageCount = Constants.Tabs.values().size,
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 20.dp)
                .fillMaxSize(),
            state = pagerState
        ) { page ->
            when(page){
                0 ->{
                    MovieGridComponent(movies = nowPlaying , goToDetails = goToDetails)
                }
                1-> {
                    MovieGridComponent(movies = upcoming , goToDetails = goToDetails)
                }
                2->{
                    MovieGridComponent(movies = topRated , goToDetails = goToDetails)
                }
                3->{
                    MovieGridComponent(movies = popular , goToDetails = goToDetails)
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun DashboardPreview() {
    TMDBAppTheme{
       // Dashboard(selectedTabIndex = 1, onClickedTab = { }, movies = listOf() )
    }
    
}
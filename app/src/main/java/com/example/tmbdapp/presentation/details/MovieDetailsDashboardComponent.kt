package com.example.tmbdapp.presentation.details

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmbdapp.core.utils.Constants
import com.example.tmbdapp.core.utils.enumToName
import com.example.tmbdapp.domain.model.Cast
import com.example.tmbdapp.domain.model.Movie
import com.example.tmbdapp.domain.model.Review
import com.example.tmbdapp.ui.theme.Gray2
import com.example.tmbdapp.ui.theme.LightGray
import com.example.tmbdapp.ui.theme.White
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieDetailsDashboardComponent(
    movie : Movie,
    reviews : List<Review>,
    cast : List<Cast>,
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
            Constants.Tabs2.values().forEachIndexed { index, tabs ->
                Tab(
                    modifier = Modifier
                        .background(Gray2),
                    selected = index == pagerState.currentPage,
                    onClick = {
                        scope.launch {
                            pagerState.scrollToPage(index)
                        }
                              },
                    text = {
                        Text(
                            text = tabs.name.enumToName(),
                            maxLines = 1,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
            }
        }
        HorizontalPager(
            pageCount = Constants.Tabs2.values().size,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                .fillMaxSize(),
            state = pagerState
            ) { page ->
            when(page){
                0 ->{
                    Text(
                        modifier = Modifier.
                            fillMaxSize(),
                        text = movie.overview,
                        fontSize = 12.sp,
                        color = White
                    )
                }
                1-> {
                    ReviewsComponent(reviews)
                }
                2->{
                    CastComponent(cast)
                }
            }

        }
    }
}
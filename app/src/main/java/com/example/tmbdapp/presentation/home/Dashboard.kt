package com.example.tmbdapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tmbdapp.R
import com.example.tmbdapp.core.utils.Constants
import com.example.tmbdapp.core.utils.enumToName
import com.example.tmbdapp.domain.model.Movie
import com.example.tmbdapp.ui.theme.Gray2
import com.example.tmbdapp.ui.theme.LightGray
import com.example.tmbdapp.ui.theme.TMDBAppTheme

@Composable
fun Dashboard(
    selectedTabIndex : Int,
    onClickedTab : (Int,Constants.Tabs) -> Unit,
    movies : List<Movie>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
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
                    selected = index == selectedTabIndex,
                    onClick = { onClickedTab(index,tabs) },
                    text = { Text(text = tabs.name.enumToName(), maxLines = 1, fontSize = 9.sp, fontWeight = FontWeight.Bold) }
                )
            }
        }
        LazyVerticalGrid(
            modifier = Modifier
                .padding(top = 20.dp),
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            items(movies) { item: Movie ->
                AsyncImage(
                    modifier = Modifier
                        .height(146.dp)
                        .width(100.dp),
                    model = stringResource(id = R.string.poster_template, item.poster),
                    contentDescription = null
                )
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
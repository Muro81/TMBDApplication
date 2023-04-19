package com.example.tmbdapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmbdapp.ui.theme.LightGray
import com.example.tmbdapp.ui.theme.TMBDAppTheme

@Composable
fun Dashboard(
    selectedTabIndex : Int,
    onClickedTab : (Tabs) -> Unit
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
        Tabs.values().forEachIndexed { index, tabs ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = {onClickedTab(tabs)},
                text = {Text(text = tabs.name, maxLines = 1, fontSize = 14.sp)}
            )
        }
    }
}

enum class Tabs{
    NOW_PLAYING,
    UPCOMING,
    TOP_RATED,
    POPULAR
}


@Preview(showBackground = false)
@Composable
fun DashboardPreview() {
    TMBDAppTheme{
        Dashboard(selectedTabIndex = 1, onClickedTab ={} )
    }
    
}
package com.example.seriesapp.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.seriesapp.ui.component.SeriesItem
import com.example.seriesapp.viewmodel.SeriesViewModel
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun MainScreen(viewModel: SeriesViewModel = hiltViewModel()) {
    val series by viewModel.series
    val isLoading by viewModel.isLoading
    val listState = rememberLazyGridState()
    val scope = rememberCoroutineScope()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        state = listState
    ) {
        items(series) { s ->
            SeriesItem(s)
        }
        if (isLoading) {
            item(span = { GridItemSpan(2) }) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }

    // Infinite scroll trigger
    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .collect { lastVisible ->
                if (lastVisible == series.size - 1 && !isLoading) {
                    viewModel.loadSeries()
                }
            }
    }
}


package com.example.seriesapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.seriesapp.data.model.Series

@Composable
fun SeriesItem(series: Series) {
    Column(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = rememberImagePainter(series.imageThumbnailPath),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Crop
        )
        Text(text = series.name, modifier = Modifier.padding(top = 4.dp))
    }
}

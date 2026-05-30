package com.example.features.news.presentation.component


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.features.news.domain.model.Article

@Composable
fun NewsCard(
    article: Article
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        AsyncImage(
            model = article.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.55f),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .weight(0.45f)
                .padding(20.dp)
        ) {

            Text(
                text = article.source,
                style = MaterialTheme.typography.labelMedium
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = article.title,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = article.description,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
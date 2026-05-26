package com.example.features.news.presentation.component


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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

    Card(

        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(20.dp),

        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )

    ) {

        Column {

            AsyncImage(

                model = article.imageUrl,

                contentDescription = null,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),

                contentScale =
                    ContentScale.Crop
            )

            Text(

                text = article.title,

                style =
                    MaterialTheme.typography.titleMedium,

                modifier = Modifier.padding(12.dp)
            )

            Text(

                text = article.description,

                style =
                    MaterialTheme.typography.bodyMedium,

                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )
        }
    }
}
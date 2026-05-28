package com.example.features.news.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun ShimmerNewsCard() {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .shimmer(),

        shape = RoundedCornerShape(20.dp)

    ) {

        Column {

            androidx.compose.foundation.layout.Box(

                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .background(
                        Color.LightGray
                    )
            )

            androidx.compose.foundation.layout.Box(

                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .height(24.dp)
                    .background(
                        Color.LightGray
                    )
            )

            androidx.compose.foundation.layout.Box(

                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
                    .height(18.dp)
                    .background(
                        Color.LightGray
                    )
            )
        }
    }
}
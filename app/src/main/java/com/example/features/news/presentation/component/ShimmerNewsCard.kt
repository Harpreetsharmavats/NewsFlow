package com.example.features.news.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .shimmer()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.55f)
                .background(Color.LightGray)
        )

        Column(
            modifier = Modifier
                .weight(0.45f)
                .padding(20.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .height(14.dp)
                    .background(
                        Color.LightGray,
                        RoundedCornerShape(4.dp)
                    )
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
                    .background(
                        Color.LightGray,
                        RoundedCornerShape(4.dp)
                    )
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(32.dp)
                    .background(
                        Color.LightGray,
                        RoundedCornerShape(4.dp)
                    )
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            repeat(4) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(18.dp)
                        .background(
                            Color.LightGray,
                            RoundedCornerShape(4.dp)
                        )
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )
            }
        }
    }
}
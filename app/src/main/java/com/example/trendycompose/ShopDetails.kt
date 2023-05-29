package com.example.trendycompose

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.trendycompose.models.ShoppingItemItem

@Composable
fun QuoteDetail(shop: ShoppingItemItem) {


    BackHandler() {
        DataManager.switchPages(null)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Color.White
            ),
    )
    {

        Column(
            verticalArrangement = Arrangement.Center, modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp, 24.dp)
        ) {
            AsyncImage(model = shop.image, contentDescription = "")

            Text(
                text = shop.description,
                fontFamily = FontFamily.SansSerif,
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = shop.category,
                fontFamily = FontFamily.Serif,
                style = MaterialTheme.typography.body1,
                fontSize = 23.sp


            )
        }
    }
}

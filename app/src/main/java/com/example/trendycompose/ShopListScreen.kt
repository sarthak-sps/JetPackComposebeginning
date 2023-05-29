package com.example.trendycompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trendycompose.models.ShoppingItemItem

@Composable
fun ShopListScreen(data: Array<ShoppingItemItem>, onClick: (shop: ShoppingItemItem) -> Unit) {
    Column() {
        Text(
            text = "Today's Deals",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp, 20.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.h5,
            fontFamily = FontFamily.Monospace
        )

        Text(
            text = "Recommended deals for you",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp, 24.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.h6,
            fontFamily = FontFamily.Monospace
        )
        ShopList(data = data, onClick)
    }

}
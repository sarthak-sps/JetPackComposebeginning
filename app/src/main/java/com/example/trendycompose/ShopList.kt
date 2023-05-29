package com.example.trendycompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.trendycompose.models.ShoppingItemItem

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ShopList(data: Array<ShoppingItemItem>, onClick: (shop: ShoppingItemItem) -> Unit) {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        LazyRow(
            content = {
                items(data) {
                    SHopListItems(shop = it, onClick)
                }

            }, modifier = Modifier
                .background(Color.LightGray)
                .height(280.dp)
        )



        FlowRow(
            Modifier
                .fillMaxWidth(1f)
                .wrapContentHeight(align = Alignment.Top),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            data.forEach {

                SHopListItems(shop = it, onClick)

            }


        }
    }
}
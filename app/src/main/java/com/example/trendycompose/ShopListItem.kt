package com.example.trendycompose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.trendycompose.models.ShoppingItemItem

@OptIn(ExperimentalGlideComposeApi::class)

@Composable
fun SHopListItems(shop:ShoppingItemItem,onClick:(shop:ShoppingItemItem)->Unit) {
        Card(elevation = 4.dp,
            modifier = Modifier
                .padding(16.dp)
                .clickable { onClick(shop) }
                .height(250.dp)
                .width(150.dp)) {
            Column(modifier = Modifier.padding(10.dp)) {
                Row(modifier = Modifier.padding(16.dp)) {
                    AsyncImage(model = shop.image, contentDescription = "")
                }
                Box(modifier = Modifier
                    .width(60.dp)
                    .height(20.dp)
                    .background(Color.Red), Alignment.Center) {
                    Text(text = "₹ ${(shop.price*80)}",
                        color = Color.White,
                    )
                }
                Text(text = shop.title)

            }

        }


}
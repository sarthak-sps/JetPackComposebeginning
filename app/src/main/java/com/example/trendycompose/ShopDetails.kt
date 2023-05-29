package com.example.trendycompose

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.trendycompose.models.ShoppingItemItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShopDetails(shop: ShoppingItemItem) {

    var isLiked by remember {
        mutableStateOf(false)
    }
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    BackHandler() {
        DataManager.switchPages(null)
    }
    Scaffold(scaffoldState = scaffoldState, modifier = Modifier.fillMaxSize()) {
        TopAppBar {

        }
        Box(
            modifier = Modifier
                .fillMaxSize(2f)
                .background(
                    Color.White
                ),
        )
        {

            Column(
                verticalArrangement = Arrangement.Center, modifier = Modifier
                    .padding(16.dp, 24.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = shop.image,
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(.5f),
                    contentScale = ContentScale.FillWidth
                )
                Text(
                    text = shop.category,
                    fontFamily = FontFamily.Serif,
                    style = MaterialTheme.typography.body1,
                    fontSize = 23.sp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {
                        isLiked = !isLiked
                        coroutineScope.launch {
                            if (isLiked) {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Added to wishlist",
                                    actionLabel = "Undo",
                                    duration = SnackbarDuration.Short
                                )
                            } else {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Removed from wishlist",
                                    actionLabel = "Undo",
                                    duration = SnackbarDuration.Short
                                )
                            }

                        }
                    }) {
                        Icon(
                            painter = rememberVectorPainter(image = if (isLiked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder),
                            contentDescription = ""
                        )
                    }
                    Text(
                        text = "₹ ${(shop.price * 80)}",
                        color = Color.Black,
                    )
                }

                Text(
                    text = shop.description,
                    fontFamily = FontFamily.SansSerif,
                    style = MaterialTheme.typography.h6
                )
            }


        }

    }
}

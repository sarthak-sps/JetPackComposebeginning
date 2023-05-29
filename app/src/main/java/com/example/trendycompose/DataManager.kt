package com.example.trendycompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.trendycompose.models.ShoppingItemItem
import com.google.gson.Gson

object DataManager {
    var currentShop: ShoppingItemItem? = null
    var isDataLoaded = mutableStateOf(false)
    var data = emptyArray<ShoppingItemItem>()
    var currentPages = mutableStateOf(Pages.LISTING)
    fun loadShopingItems(context: Context) {
        val inputStream = context.assets.open("shopping.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<ShoppingItemItem>::class.java)
        isDataLoaded.value = true

    }

    fun switchPages(shop: ShoppingItemItem?) {
        if (currentPages.value == Pages.LISTING) {
            currentShop = shop
            currentPages.value = Pages.DETAIL
        } else {
            currentPages.value = Pages.LISTING
        }
    }
}
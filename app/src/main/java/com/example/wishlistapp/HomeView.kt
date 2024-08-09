package com.example.wishlistapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wishlistapp.data.DummyWishList
import com.example.wishlistapp.data.Wish

@Composable
fun HomeView(
    navigateToAddWish : () -> Unit,
    viewModel: WishViewModel
) {

    val context = LocalContext.current


    Scaffold(
        topBar = {
            AppBarView(
                title = "Wishlist",
                onBackNavClicked = {
                    Toast.makeText(context,"Clicked",Toast.LENGTH_LONG ).show()
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToAddWish() },
                modifier = Modifier.padding(all = 20.dp),
                containerColor = Color.Black,
                contentColor = Color.White,
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add icon")
            }
        }
    ) {

        val wishlist = viewModel.getAllWishes.collectAsState(initial = listOf())
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            items(wishlist.value){
                wish -> 
                WishItem(wish = wish) {}
            }
        }

    }
}

@Composable
fun WishItem(wish : Wish, onClick : () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 8.dp, end = 8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {

        Column (modifier = Modifier.padding(16.dp)) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)

        }
    }
}
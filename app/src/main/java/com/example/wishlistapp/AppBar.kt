package com.example.wishlistapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarView(
    title : String,
    onBackNavClicked : () -> Unit = {}
) {


    TopAppBar(
        title = {
            Text(
                text = title,
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .padding(start = 5.dp)
                    .heightIn(max = 24.dp)
            )
        },
        navigationIcon = {

            if ( title != "Wishlist"){
                IconButton(onClick = { onBackNavClicked()}) {
                    Icon(
                        painter = painterResource(id = R.drawable.back_arraw_btn),
                        contentDescription = "Back Arraw btn",
                        modifier = Modifier.clickable { onBackNavClicked() }
                    )
                }
            }

        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = colorResource(id = R.color.appBarcolor)
        )

    )


}
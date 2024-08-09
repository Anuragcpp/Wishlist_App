package com.example.wishlistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wishlistapp.data.Wish
import kotlinx.coroutines.launch

@Composable
fun AddEditDetailView(
    id : Long,
    viewModel: WishViewModel,
    navController: NavController
) {

    val snackMessage = remember{ mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
//    val scaffoldState = rememberScaffoldState()

    Scaffold (
        topBar = {
            // navigateUp automaticaaly allow us to naviage up , I don't know how
            AppBarView(title = if(id != 0L) "Update Wish" else " Add Wish"){navController.navigateUp()}
        }
    ) {

        Column( modifier = Modifier
            .padding(it)
            .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            
            Spacer(modifier = Modifier.height(10.dp))
            
            WishTextField(
                lable = "Title",
                value =  viewModel.wishTitleState,
                onValueChange = { viewModel.onWishtitleChanged(it)}
                )

            Spacer(modifier = Modifier.height(10.dp))

            WishTextField(
                lable = "Description",
                value =  viewModel.wishDescriptionState,
                onValueChange = { viewModel.onWishDescriptionChanged(it)}
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    if ( viewModel.wishTitleState.isNotEmpty() &&
                        viewModel.wishDescriptionState.isNotEmpty()){
                        if (id != 0L ){


                            //TODO updatae the wish
                        }else{
                            //TODO addwish
                            viewModel.addWish(
                                Wish(
                                    title = viewModel.wishTitleState.trim(),
                                    description = viewModel.wishDescriptionState.trim()
                                )
                            )
                            snackMessage.value = "Wish has been Created"
                            navController.navigateUp()

                        }
                    }else {
                        //empty fields so show a snack message 
                        snackMessage.value = "Enter fields to Create Wish"
                    }

                    scope.launch {
                        snackbarHostState.showSnackbar(snackMessage.value)
                        navController.navigateUp()
                    }
                }
            ) {
                Text(
                    text = if (id != 0L) "Update Wish" else "Add Wish" ,
                    style = TextStyle(fontSize = 18.sp)
                )
            }

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishTextField(
    lable : String,
    value : String,
    onValueChange : (String) -> Unit
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = lable)},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Gray,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Gray
        )
        )
}
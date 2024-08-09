package com.example.wishlistapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(wishViewModel :WishViewModel = viewModel(), navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route ){

        composable(Screen.HomeScreen.route){
            HomeView(
                navigateToAddWish = {
                    navController.navigate(Screen.AddScreen.route)
                },
                viewModel = wishViewModel
            )
        }
        
        composable(Screen.AddScreen.route){
            AddEditDetailView(id = 0L, viewModel = wishViewModel, navController = navController)
        }
    }
}
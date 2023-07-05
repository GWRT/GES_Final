package com.example.ges_final.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ges_final.Navigation.Destinations.*
import com.example.ges_final.Screens.EventScreen
import com.example.ges_final.Screens.ProfileScreen
import com.example.ges_final.Screens.SearchEventScreen

@Composable
fun Nav(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = Event.route,
    ){

        composable(Event.route){
            EventScreen(navController)
        }

        composable(Profile.route){
            ProfileScreen()
        }

        composable(SearchEvents.route){
            SearchEventScreen()
        }
    }
}
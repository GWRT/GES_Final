package com.example.ges_final

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.ges_final.Navigation.Destinations.*
import com.example.ges_final.Navigation.Nav
import com.example.ges_final.Bars.BottomNavigationBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController = rememberNavController()

    val navigationItems = listOf(
        Event,
        Profile
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, items = navigationItems)
        }
    ){
        Nav(navController)
    }
}

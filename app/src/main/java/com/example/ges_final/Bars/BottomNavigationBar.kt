package com.example.ges_final.Bars

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ges_final.Navigation.Destinations
import com.example.ges_final.ui.theme.AppColor
import com.example.ges_final.ui.theme.IconBarColor

@Composable
fun BottomNavigationBar(
    navController: NavController,
    items: List<Destinations>
) {
    val currentRoute = currentRoute(navController)

    BottomNavigation(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
        backgroundColor = AppColor,
        contentColor = IconBarColor
    ){
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    if (screen.icon != null)
                       Icon(
                           painter = painterResource( id=screen.icon) ,
                           tint = IconBarColor,
                           contentDescription = screen.title)
                },
                label = {
                        Text(text = screen.title)
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                alwaysShowLabel = false
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavController) : String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}
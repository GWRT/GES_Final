package com.example.ges_final.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ges_final.Bars.TopBar
import com.example.ges_final.Navigation.Destinations
import com.example.ges_final.R
import com.example.ges_final.ui.theme.AppColor
import com.example.ges_final.ui.theme.BackgroundColorApp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.navigation.NavController


@Composable
@Preview
fun EventScreen(navController: NavController){

    val screenWidth = LocalConfiguration.current.screenWidthDp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColorApp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopBar(
                site = Destinations.Event,
                onClickLeft = {},
                onClickRight = {}
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColorApp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .width((screenWidth * 0.9).dp)
                    .height((screenWidth * 0.9).dp)
                    .padding(5.dp),
                horizontalArrangement = Arrangement.Center

            ) {
                rowElements(navController, screenWidth)
            }
        }
    }
}

@Composable
fun rowElements(navController: NavController, screenWidth: Int){
    Box(
        modifier = Modifier
            .padding(5.dp)
            .size((screenWidth * 0.43).dp)
            .background(Color(0xFFffffff), shape = RoundedCornerShape(10))
            .border(
                width = 5.dp,
                color = Color(0xFFe2e6e4),
                shape = RoundedCornerShape(10)
            )
            .clickable { navController.navigate(Destinations.SearchEvents.route) },
        contentAlignment = Alignment.Center,

        ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .size((screenWidth * 0.2).dp),
                painter = painterResource(id = R.drawable.baseline_sports_24),
                tint = AppColor,
                contentDescription = "Evento Deporte"
            )

            Text(
                text = "Organizar\nPartido",
                color = Color(0xFF6e6e6e),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }

    Box(
        modifier = Modifier
            .padding(5.dp)
            .size((screenWidth * 0.43).dp)
            .background(Color(0xFFffffff), shape = RoundedCornerShape(10))
            .border(
                width = 5.dp,
                color = Color(0xFFe2e6e4),
                shape = RoundedCornerShape(10)
            )
            .clickable { },
        contentAlignment = Alignment.Center,
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .size((screenWidth * 0.2).dp),
                painter = painterResource(id = R.drawable.baseline_search_24),
                tint = AppColor,
                contentDescription = "Evento Deporte"
            )

            Text(
                text = "Buscar\nPartido",
                color = Color(0xFF6e6e6e),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

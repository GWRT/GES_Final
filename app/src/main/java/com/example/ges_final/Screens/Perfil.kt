package com.example.ges_final.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ges_final.Bars.TopBar
import com.example.ges_final.Navigation.Destinations
import com.example.ges_final.R
import com.example.ges_final.ui.theme.*

@Composable
@Preview
fun ProfileScreen(){

    val screenWidth = LocalConfiguration.current.screenWidthDp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColorApp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(
            site = Destinations.Profile,
            idIconRight = R.drawable.baseline_settings_24,
            contentDescRight = "Perfil",
            onClickLeft = {},
            onClickRight = {}
        )
        Column(
            modifier = Modifier.background(Color(0xFFfcfcfc))
        ) {
            fisrtLine(screenWidth)
            secondLine(screenWidth)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )
            Box(modifier = Modifier.padding(top = 15.dp, start = 15.dp, end = 15.dp)) {
                Divider(color = Color(0xFF696969), thickness = 1.dp)
            }
            thirdLine(screenWidth)
        }
    }
}

@Composable
fun thirdLine(screenWidth: Int) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(id = R.drawable.baseline_person_add_alt_1_24),
                tint = AppColor,
                contentDescription = "Add Friend",
                modifier = Modifier
                    .padding(8.dp)
                    .size(25.dp),
            )
            Text(
                text = "Traer a mis amigos",
                fontSize = 15.sp
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.baseline_navigate_next_24),
            tint = Color(0xFF696969),
            contentDescription = "Next Screen for Add Friend",
            modifier = Modifier
                .padding(5.dp)
                .size(20.dp),
        )

    }
}

@Composable
fun secondLine(screenWidth: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.width((screenWidth/3).dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "0",
                color = AppColor,
                fontSize = 20.sp
            )
            Text(text = "Organizados")
        }
        Column(
            modifier = Modifier.width((screenWidth/3).dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "0",
                color = AppColor,
                fontSize = 20.sp
            )
            Text(text = "Jugados")
        }
        Column(
            modifier = Modifier.width((screenWidth/3).dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Ganados: 0")
            Text(text = "Perdidos: 0")
        }
    }
}

@Composable
fun fisrtLine(screenWidth: Int){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .padding(8.dp)
                .size((screenWidth * 0.25).dp),
            painter = painterResource(id = R.drawable.baseline_account_circle_24),
            tint = AppColor,
            contentDescription = "Profile Logo")

        Column(
            modifier = Modifier
                .padding(10.dp)
                .height((screenWidth * 0.25).dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Gilbert Ramos",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "Juega en Arequipa",
                fontSize = 20.sp,
            )
            Text(
                text = "Fiabilidad: 0.0%",
                fontSize = 20.sp,
            )
        }
    }
}

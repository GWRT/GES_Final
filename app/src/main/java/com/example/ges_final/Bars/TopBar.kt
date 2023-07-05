package com.example.ges_final.Bars

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ges_final.Navigation.Destinations
import com.example.ges_final.ui.theme.AppColor

@Composable
fun TopBar(
    site: Destinations,
    idIconLeft : Int ?= null,
    contentDescLeft : String = "",
    onClickLeft: () -> Unit,
    idIconRight : Int ?= null,
    contentDescRight : String = "",
    onClickRight: () -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(AppColor)
    ) {
        Box(
           modifier = Modifier
               .size(30.dp)
        )
        Text(
            text = site.title,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFffffff),
        )
        if (idIconRight != null) {
            Icon(
                modifier = Modifier
                    .padding(10.dp)
                    .size(20.dp)
                    .clickable(onClick = onClickRight),
                painter = painterResource(id = idIconRight),
                contentDescription = contentDescRight,
                tint = Color(0xFFffffff),
            )
        } else{
            Box(
                modifier = Modifier
                    .size(30.dp)
            )
        }
    }
}
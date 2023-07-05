package com.example.ges_final.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ges_final.Bars.TopBar
import com.example.ges_final.Navigation.Destinations
import com.example.ges_final.R
import com.example.ges_final.ui.theme.BackgroundColorApp

data class Item(
    val name: String,
    var isSelected: MutableState<Boolean>
)

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview
fun SearchEventScreen() {

    val sportSelected = remember { mutableStateListOf<String>() }

    val itemList = listOf(
        Item("Futbol", mutableStateOf(false)),
        Item("Voley", mutableStateOf(false)),
        Item("Basquet", mutableStateOf(false)),
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundColorApp)
    ) {
        TopBar(
            site = Destinations.Event,
            onClickLeft = { /*TODO*/ }) {
        }
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            ChooseSport(
                itemList,
                onItemChange = { newItems ->
                    sportSelected.clear()
                    sportSelected.addAll(newItems)
                }
            )
            Text(
                text = "Deportes seleccionados",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                sportSelected.forEach{
                    Text(
                        text = it,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
            ChooseWhen()
        }
    }
}

@Composable
fun CheckBoxListOfSports(
    itemList : List<Item>,
    onDismiss: () -> Unit,
    onItemsChange : (List<String>) -> Unit
) {

    val selectedItems = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        itemList.forEach { item ->
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Checkbox(
                    checked = item.isSelected.value,
                    onCheckedChange = {
                        //item.isSelected.value = !item.isSelected.value
                        item.isSelected.value = it

                        if(item.isSelected.value)
                            selectedItems.add(item.name)
                        else
                            selectedItems.remove(item.name)

                        onItemsChange(selectedItems)
                    }
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = item.name)
            }

        }

        Button(
            onClick = onDismiss,
            modifier = Modifier.padding(start = 40.dp, top = 10.dp, bottom = 10.dp)
        ) {
            Text(text = "Listo")
        }
    }
}

@Composable
fun ChooseSport(
    itemList : List<Item>,
    onItemChange : (List<String>) -> Unit
) {
    val showList = remember { mutableStateOf(false) }
    val selectedItems = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .clickable {
                    showList.value = true
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_navigate_next_24),
                contentDescription = "list"
            )
            Text(
                text = "Elige un o varios deporte",
                fontSize = 20.sp
            )

        }
        if (showList.value){
            CheckBoxListOfSports(
                itemList,
                onDismiss = {
                    showList.value = false
                    onItemChange(selectedItems)
                },
                onItemsChange = { newItem ->
                    selectedItems.clear()
                    selectedItems.addAll(newItem)
                }
            )
        }
    }
}

@Composable
fun ChooseWhen() {
    Row(
        modifier = Modifier
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_navigate_next_24),
            contentDescription = "list"
        )
        Text(
            text = "Elige una fecha",
            fontSize = 20.sp
        )
    }
}
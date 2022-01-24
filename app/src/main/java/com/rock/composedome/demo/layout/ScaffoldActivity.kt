package com.rock.composedome.compose.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class ScaffoldActivity : AppCompatActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            ScaffoldBasic()
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun ScaffoldBasic(){
    Scaffold(
        topBar = {TopAppBarBasic2()},
        bottomBar = { BottomAppBarBasic()},
        floatingActionButton = { FloatingActionButtonBasic() },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        drawerGesturesEnabled = true,
        drawerShape = RoundedCornerShape(4.dp),
        drawerContent = { Box(modifier = Modifier.fillMaxSize().background(Color.Yellow))}

    ) {

    }
}

//region  TopAppBar
@Composable
fun TopAppBarBasic(){
    TopAppBar(
        backgroundColor = Color.DarkGray,
        contentColor = Color.White,
        elevation = 20.dp,
        navigationIcon = {
            IconButton(onClick = {},modifier = Modifier.background(Color.Red)) {
                Icon(Icons.Filled.Close, null)
            }
        },
        title = {
            Text(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth(),
                color = Color.Green,
                text = "TopAppBar"
            )
        },
        actions = {//row
            IconButton(onClick = {},modifier = Modifier.background(Color.Blue)) {
                Icon(Icons.Filled.Email, null)
            }
            IconButton(onClick = {},modifier = Modifier.background(Color.Yellow)) {
                Icon(Icons.Filled.Edit, null)
            }
            IconButton(onClick = {},modifier = Modifier.background(Color.Magenta)) {
                Icon(Icons.Filled.Phone, null)
            }
            IconButton(onClick = {},modifier = Modifier.background(Color.Green)) {
                Icon(Icons.Filled.Home, null)
            }
            IconButton(onClick = {},modifier = Modifier.background(Color.Blue)) {
                Icon(Icons.Filled.Email, null)
            }
        }

    )
}

@Composable
fun TopAppBarBasic2(){
    TopAppBar(backgroundColor = Color.LightGray) {
        //父容器是 Row
        IconButton(onClick = {},modifier = Modifier.background(Color.Red)) {
            Icon(Icons.Filled.Close, null)
        }
        Text(
            modifier = Modifier
                .background(Color.White)
                .weight(1f),
            color = Color.Green,
            textAlign = TextAlign.Center,
            text = "TopAppBar"
        )
        IconButton(onClick = {},modifier = Modifier.background(Color.Blue)) {
            Icon(Icons.Filled.Email, null)
        }
    }
}

//endregion  End

//region BottomAppBar

@ExperimentalMaterialApi
@Composable
fun BottomAppBarBasic(){
    val checked  = remember { mutableStateOf(false)}

    BottomAppBar(
        cutoutShape = CircleShape,
    ) {
        IconButton(onClick = {},modifier = Modifier
//            .background(Color.Blue)
            .weight(0.2f)) {
            Icon(Icons.Filled.Email, null)
        }
        IconButton(onClick = {},modifier = Modifier
//            .background(Color.Yellow)
            .weight(0.2f)) {
            BadgeBox(badgeContent = {Text("99")}){
                Icon(Icons.Filled.Edit, null)
            }
        }
        Spacer(modifier = Modifier.weight(0.2f))
        IconButton(onClick = {},modifier = Modifier
//            .background(Color.Magenta)
            .weight(0.2f)) {
            Icon(Icons.Filled.Phone, null)
        }

        IconToggleButton(checked = checked.value, onCheckedChange = {checked.value = it},
            modifier = Modifier.weight(0.2f) //.background(Color.Green)
            ) {
            val tintColor =  if (checked.value) Color.Magenta else Color.White
            Icon(Icons.Filled.Home, null, tint = tintColor)
        }

//        IconButton(onClick = {},modifier = Modifier
////            .background(Color.Green)
//            .weight(0.2f)) {
//            Icon(Icons.Filled.Home, null)
//        }
    }
}
//endregion BottomAppBar End

//region
@Composable
fun FloatingActionButtonBasic(){
    FloatingActionButton(
        onClick = { },
        shape = CircleShape,
    ) {
        Icon(Icons.Filled.Add, null)
    }
}
//endregion  End


package com.rock.composedome.compose.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class ScaffoldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            ScaffoldBasic()
        }
    }
}

@Composable
fun ScaffoldBasic(){
    Scaffold(
        topBar = {TopAppBarBasic2()},
        bottomBar = { BottomAppBarBasic()}
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
@Composable
fun BottomAppBarBasic(){
    BottomAppBar(
        cutoutShape = RoundedCornerShape(4.dp)
    ) {
        IconButton(onClick = {},modifier = Modifier.background(Color.Blue).weight(1f)) {
            Icon(Icons.Filled.Email, null)
        }
        IconButton(onClick = {},modifier = Modifier.background(Color.Yellow).weight(1f)) {
            Icon(Icons.Filled.Edit, null)
        }
        IconButton(onClick = {},modifier = Modifier.background(Color.Magenta).weight(1f)) {
            Icon(Icons.Filled.Phone, null)
        }
        IconButton(onClick = {},modifier = Modifier.background(Color.Green).weight(1f)) {
            Icon(Icons.Filled.Home, null)
        }
    }
}
//endregion BottomAppBar End




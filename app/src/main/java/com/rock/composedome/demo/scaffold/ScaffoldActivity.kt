package com.rock.composedome.demo.scaffold

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
        topBar = { TopAppBarBasic2() },
        bottomBar = { BottomAppBarBasic() },
        floatingActionButton = { FloatingActionButtonBasic() },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        drawerGesturesEnabled = true,
        drawerShape = RoundedCornerShape(4.dp),
        drawerContent = { Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow))}

    ) {

    }
}



//region BottomAppBar

@OptIn(ExperimentalMaterialApi::class)
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
            BadgedBox(badge = {Text("99")}){
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


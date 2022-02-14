package com.rock.composedome.demo.scaffold

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape

class BottomBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Scaffold(
                bottomBar = { BottomAppBarBasic()},
                floatingActionButton = { FloatingActionButtonBasic()},
//                //fab 是否停靠在 bottomBar 上
//                isFloatingActionButtonDocked = true,
//                //fab 在 bottomBar 上的位置 FabPosition.Center 或者 FabPosition.End
//                floatingActionButtonPosition = FabPosition.Center,
            ) {
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomAppBarBasic(){
    val checked  = remember { mutableStateOf(false) }
    BottomAppBar(
        backgroundColor = Color.Magenta,//bar 的背景颜色
        contentColor = Color.Black //内容的 tintColor
    ) {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
            IconButton(onClick = {}, modifier = Modifier
                .background(Color.Blue)
                .weight(0.2f)) {
                Icon(Icons.Filled.Email, null)
            }
        }

        IconButton(onClick = {},modifier = Modifier
            .background(Color.Yellow)
            .weight(0.2f)) {
            BadgedBox(//角标容器
                badge = {
                    //角标
                    Badge(backgroundColor = Color.Red, contentColor = Color.White){
                        Text(text = "99")
                    }
                }){
                Icon(Icons.Filled.Edit, null)
            }
        }

        IconButton(onClick = {},modifier = Modifier
            .background(Color.Red)
            .weight(0.2f)) {
            Icon(Icons.Filled.Phone, null)
        }

        IconToggleButton(checked = checked.value, onCheckedChange = {checked.value = it},
            modifier = Modifier
                .weight(0.2f)
                .background(Color.Green)) {
            val tintColor =  if (checked.value) Color.Magenta else Color.White
            Icon(Icons.Filled.Home, null, tint = tintColor)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomAppBarBasic2(){
    val checked  = remember { mutableStateOf(false) }

    BottomAppBar(
        cutoutShape = CircleShape // fab 在 bottomBar 上 bottomBar 裁剪形状
    ) {
        IconButton(onClick = {},modifier = Modifier.weight(0.2f)) {
            Icon(Icons.Filled.Email, null)
        }
        IconButton(onClick = {},modifier = Modifier.weight(0.2f)) {
            BadgedBox(badge = { Badge(backgroundColor = Color.Red, contentColor = Color.White){
                Text(text = "99")
            }}){
                Icon(Icons.Filled.Edit, null)
            }
        }
        //为fab 停靠在中间占位
        Spacer(modifier = Modifier.weight(0.2f))

        IconButton(onClick = {},modifier = Modifier.weight(0.2f)) {
            Icon(Icons.Filled.Phone, null)
        }

        IconToggleButton(checked = checked.value, onCheckedChange = {checked.value = it},
            modifier = Modifier.weight(0.2f)) {
            val tintColor =  if (checked.value) Color.Magenta else Color.White
            Icon(Icons.Filled.Home, null, tint = tintColor)
        }
    }
}

@Composable
fun FloatingActionButtonBasic(){
    FloatingActionButton(onClick = { }, shape = CircleShape,) {
        Icon(Icons.Filled.Add, null)
    }
}
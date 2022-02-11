package com.rock.composedome.demo.scaffold

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class TopBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Scaffold(topBar = { TopAppBarBasic2() }) {
            }
        }
    }
}

@Composable
fun TopAppBarBasic(){
    //Material 风格的标题栏 [导航按钮 + 标题 + Actions]，使用方便但标题居中不好设置
    //Actions 多的情况会挤压 title 的宽度
    TopAppBar(
        //背景颜色
        backgroundColor = Color.DarkGray,
        //子组件的 tintColor
        contentColor = Color.Red,
        //阴影
        elevation = 0.dp,
        //导航图标
        navigationIcon = { IconButton(onClick = {},modifier = Modifier.background(Color.Cyan)) {
                Icon(Icons.Filled.Close, null)
            } },
        //标题
        title = { Text(modifier = Modifier.background(Color.White).fillMaxWidth(), color = Color.Green, text = "TopAppBar") },
        //标题右侧的Action 按钮
        actions = {
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
    //自定义 灵活设置布局，
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

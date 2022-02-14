package com.rock.composedome.demo.scaffold

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class DrawerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScaffoldWithDrawer()
        }

//        setContent{
//            Column() {
//                Box(modifier = Modifier.height(200.dp))
//                BottomDrawerBasic()
//            }
//        }
    }
}

@Composable
fun ModalDrawerBasic(){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalDrawer(
        modifier = Modifier.background(Color.Magenta),//content 背景色
        drawerState = drawerState,//抽屉状态 打开/关闭
        drawerContent = { Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Red))}, //抽屉UI
        drawerShape = RoundedCornerShape(12.dp),//抽屉的形状
        gesturesEnabled = true,//手势能否打开/关闭抽屉， 默认 true
        scrimColor = Color.Yellow //抽屉打开后剩余部分的颜色
    ) {
        //抽屉关闭时的UI
        Button(onClick = {
            scope.launch { drawerState.open() }
        }) {
            Text(text = "打开")
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomDrawerBasic(){
    //BottomDrawerValue ： Closed 关闭，  Open 打开 Content 高度的 50%， Expand 打开 100%
    val drawerState = rememberBottomDrawerState(BottomDrawerValue.Closed)
    val scope = rememberCoroutineScope()
    BottomDrawer(
        drawerContent =  {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)){
                Button(onClick = { scope.launch { drawerState.close() } }){ Text("关闭") }
            }
        },
        drawerState = drawerState
    ) {
        Column {
            Button(onClick = { scope.launch { drawerState.open() } }) {
                Text("打开")
            }
            Button(onClick = { scope.launch { drawerState.expand() } }) {
                Text("完全打开")
            }
        }
    }
}

@Composable
fun ScaffoldWithDrawer(){
    //rememberScaffoldState(
    //    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    //    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
    //)
    // 默认 DrawerState Closed
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        // drawerState 和 snackbarHostState 组合
        scaffoldState = scaffoldState,
        drawerGesturesEnabled = true,
        drawerShape = RoundedCornerShape(4.dp),
        //侧滑抽屉
        drawerContent = { Box(modifier = Modifier.fillMaxSize().background(Color.Yellow))}
    ) {
        Button(onClick = {
            scope.launch { scaffoldState.drawerState.open() }
        }) {
            Text(text = "打开")
        }
    }
}
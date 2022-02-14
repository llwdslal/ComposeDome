package com.rock.composedome.demo.scaffold

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

class SnackBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            SnackBarBasic()
        }
    }
}

@Composable
fun SnackBarBasic(){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(scaffoldState = scaffoldState) {
        Button(onClick = { 
           scope.launch {
               //可以添加 action 按钮但无法添加其点击事件
               scaffoldState.snackbarHostState.showSnackbar(
                   //消息内容
                   message = "SnackBarBasic",
                   // action 显示内容
                   actionLabel = "OK",
                   //显示的时间 ， Short 、Long 、Indefinite
                   //Indefinite = Long.MAX_VALUE , 手动关闭或者点击 action 后才会消失
                   duration = SnackbarDuration.Indefinite
               )
           }
        }) {
            Text(text = "Show SnackBar")
        }
    }
}

@Composable
fun SnackBarCustom(){
    //fixme 点击事件
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHost(hostState = it,){ snackbarData ->
                Snackbar(
                    snackbarData = snackbarData,
                )
            }
        }
    ) {

    }
}
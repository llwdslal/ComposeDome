package com.rock.composedome.demo.gesture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rock.composedome.compose.OutlinedColumn

private const val TAG = "ScrollActivity"

class ScrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column{
                ScrollBasic()
                ScrollableBasic()
            }
        }
    }
}

@Composable
fun ScrollBasic(){
    OutlinedColumn(color = Color.Blue) {
        Column(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                //垂直滚动 ，水平滚动用 horizontalScroll()
                .verticalScroll(rememberScrollState(0)))
        {
            repeat(20){
                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                        .fillMaxWidth(),
                    text = "$it",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun ScrollableBasic(){

    var scrollOffset by remember{ mutableStateOf(0f)}

    val scrollableState = rememberScrollableState { delta -> //记录每次滚动在滚动方向上的增量
        scrollOffset += delta
        Log.e(TAG, "ScrollableBasic delta: $delta")
        delta
    }

    OutlinedColumn(color = Color.Magenta) {
        Column(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                 //指定滚动方向，并记录每次滚动的增量
                 //但并不能触发 UI 界面的滚动 要搭配 overScrollController 控制滚动
                 // overScrollController 参数被 api 屏蔽了 ，所以滚动不要使用 scrollable
                .scrollable(
                    state = scrollableState,
                    orientation = Orientation.Vertical,
                )
        ) {
            Text(modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp).fillMaxWidth(),
                text = "$scrollOffset",
                textAlign = TextAlign.Center
            )
        }
    }
}


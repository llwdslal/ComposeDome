package com.rock.composedome.demo.gesture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.rock.composedome.compose.OutlinedColumn
import com.rock.composedome.demo.layout.BoxBasic
import kotlin.math.roundToInt

private const val TAG = "DragActivity"
class DragActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                DragBasic()
                DragGesturesBasic()
            }
        }
    }
}

@Composable
fun DragBasic(){
    var offsetX by remember{ mutableStateOf(0f)}
    val dragState = rememberDraggableState{ delta ->
        offsetX+=delta
        Log.e(TAG, "DragBasic offsetX: $offsetX" )
    }
    OutlinedColumn(color = Color.Magenta) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
        ){
            Text(
                modifier = Modifier
                    //draggable 并不能移动 UI, 移动需要配合 offset
                    //注意顺序 放在背景后的话 背景是不会受到 offset 影响，文本移动走了， 背景还停在初始位置
                    .offset { IntOffset(offsetX.roundToInt(), 0) }
                    .size(50.dp, 50.dp)
                    .background(Color.Gray)
                    // 单一方向上的拖动监听
                    // state 监听拖动在 orientation 指定方向上的增量
                    .draggable(
                        state = dragState,
                        orientation = Orientation.Horizontal
                    ),
                text = "XXXXXX"
            )
        }
    }
}

@Composable
fun DragGesturesBasic(){
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    OutlinedColumn(color = Color.Blue) {
        Box(modifier = Modifier.fillMaxWidth().height(200.dp)
        ){
            Text(
                modifier = Modifier.size(100.dp, 50.dp).background(Color.Gray)
                    .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDragStart = {
                                Log.e(TAG, "DragGesturesBasic onDragStart: $it" )
                            },
                            onDragEnd = {
                                Log.e(TAG, "DragGesturesBasic onDragEnd" )
                            },
                            onDragCancel = {
                                Log.e(TAG, "DragGesturesBasic onDragCancel" )
                            }
                        ) { change, dragAmount ->
                            change.consumeAllChanges()
                            offsetX += dragAmount.x
                            offsetY += dragAmount.y
                        }
                    },
                text = "XXXXXX"
            )
        }
    }
}
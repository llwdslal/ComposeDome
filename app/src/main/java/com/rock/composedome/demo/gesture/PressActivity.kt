package com.rock.composedome.demo.gesture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.rock.composedome.compose.OutlinedColumn

private const val TAG = "PressActivity"
class PressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            Column {
                ClickBasic()
                TapGesturesBasic()
            }
        }
    }
}

@Composable
fun ClickBasic(){
    OutlinedColumn(color = Color.Green) {
        Box(modifier = Modifier
            .size(100.dp, 50.dp)
            .background(Color.LightGray)
            .clickable {
                //按下跟抬起都 在 Box 中就会触发，不会区分 长按 、 双击
                //在 Box 外抬起视为取消
                Log.e(TAG, "ClickBasic clickable : onClick")
            }
        )
    }
}

@Composable
fun TapGesturesBasic(){
    OutlinedColumn(color = Color.Magenta) {
        Box(modifier = Modifier
            .size(100.dp, 50.dp)
            .background(Color.Gray)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        //在 Box 中 按下就会触发
                        Log.e(TAG, "TapGesturesBasic: onPress" )
                    },
                    onLongPress = {
                        //在 Box 中长按时触发 ，先触发 onPress 再触发 onLongPress
                        Log.e(TAG, "TapGesturesBasic: onLongPress" )
                    },
                    onTap = {
                        //单击 100 ms 内 按下抬起,
                        //private static final int TAP_TIMEOUT = 100;  ViewConfiguration.java
                        //onDoubleTap == null 时双击也会触发 onTap
                        Log.e(TAG, "TapGesturesBasic: onTap" )
                    },
                    onDoubleTap = {
                        //双击 300 ms 内双击触发
                        Log.e(TAG, "TapGesturesBasic: onDoubleTap" )
                    }
                )
            }
        )
    }
}
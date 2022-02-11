package com.rock.composedome.demo.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rock.composedome.compose.OutlinedColumn

private const val TAG = "SliderProgressBarActivi"
class SliderProgressBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                CircularProgressIndicatorBasic()
                CircularProgressIndicatorBasic2()
                LinearProgressIndicatorBasic()
                LinearProgressIndicatorBasic2()
                SliderBasic()
                RangeSliderBasic()
            }
        }
    }
}

@Composable
fun SliderBasic(){
    var sliderValue by remember { mutableStateOf(0f)}
    OutlinedColumn(color = Color.Cyan) {
        Slider(
            //滑块 在 valueRange 中对应在控件上的位置
            value = sliderValue,
            //滑块位置改变（点击、拖动）后触发
            onValueChange = {
                sliderValue = it
                Log.e(TAG, "SliderBasic: onValueChange: $it" )
            },
            //值范围，默认 0f .. 1f
            valueRange = 0f .. 100f,
            //滑动停止后触发
            onValueChangeFinished = {
                Log.e(TAG, "SliderBasic: onValueChangeFinished: $sliderValue" )
            },
            //除去首尾，在组件中添加等分的点。分成 N 份，就添加 N - 1 个点
            //添加后滑块选值只能选择点上的值，点击或拖动会自动滑块会自动靠近最近的点
            steps = 4,
            colors = SliderDefaults.colors(
                //滑块的颜色
                thumbColor = Color.Cyan,
                //打点未选后的颜色 设置 steps 才会有点
                inactiveTickColor = Color.Black,
                //打点选中后的颜色 设置 steps 才会有点
                activeTickColor = Color.Green,
                //未选中轨迹的颜色
                inactiveTrackColor = Color.Yellow,
                //选中轨迹的颜色
                activeTrackColor = Color.Red,
            )
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RangeSliderBasic(){
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    OutlinedColumn(color = Color.Magenta) {
        RangeSlider(
            //当前滑块起点和终点的位置，记得设置 valueRange
            values = sliderPosition,
            onValueChange ={
                sliderPosition = it
                Log.e(TAG, "RangeSliderBasic: onValueChange: $it" )
            },
            //值范围，默认 0f .. 1f ,
            valueRange = 0f .. 100f,
        )
    }
}

@Composable
fun CircularProgressIndicatorBasic(){
    OutlinedColumn(color = Color.Green) {
        CircularProgressIndicator(color = Color.Magenta, strokeWidth = 4.dp)
    }
}
@Composable
fun CircularProgressIndicatorBasic2(){
    var progress by remember { mutableStateOf(0.1f) }
    val animatedProgress by animateFloatAsState(targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec)
    OutlinedColumn(color = Color.Blue) {
       Row {
           CircularProgressIndicator(
               /*@FloatRange(from = 0.0, to = 1.0)*/
               progress = animatedProgress,
               color = Color.Magenta,
               strokeWidth = 8.dp
           )
           Spacer(modifier = Modifier.width(4.dp))
           Button(onClick = {
               if (progress > 1f){
                   progress -= 1f
               }
               progress += 0.1f

           }) { Text(text = "Increase")}
       }
    }
}

@Composable
fun LinearProgressIndicatorBasic(){
    OutlinedColumn(color = Color.Red) {
        LinearProgressIndicator(color = Color.Magenta, backgroundColor = Color.Cyan)
    }
}
@Composable
fun LinearProgressIndicatorBasic2(){
    var progress by remember { mutableStateOf(0.1f) }
    val animatedProgress by animateFloatAsState(targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec)
    OutlinedColumn(color = Color.Blue) {
        Row {
            LinearProgressIndicator(
                /*@FloatRange(from = 0.0, to = 1.0)*/
                progress = animatedProgress,
                color = Color.Magenta,
                backgroundColor = Color.Cyan
            )
            Spacer(modifier = Modifier.width(4.dp))
            Button(onClick = {
                progress += 0.1f
                if (progress > 1f){
                    progress -= 1f
                }
            }) { Text(text = "Increase")}
        }
    }
}
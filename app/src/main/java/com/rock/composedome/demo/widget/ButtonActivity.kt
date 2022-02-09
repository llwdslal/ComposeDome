package com.rock.composedome.demo.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.rock.composedome.compose.OutlinedColumn

class ButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                ButtonBasic()
                OutlinedButtonBasic()
                IconButtonBasic()
                TextButtonBasic()
                IconToggleButtonBasic()
                RadioButtonBasic()
                RadioButtonCustom()
            }
        }
    }
}

@Composable
fun ButtonBasic(){
    val context = LocalContext.current
    var buttonEnable:Boolean by remember { mutableStateOf(true)}

    OutlinedColumn(color = Color.Cyan) {
        Button(
            onClick = {Toast.makeText(context, "Click Button ", Toast.LENGTH_SHORT).show()},
            enabled = buttonEnable,
            //设置阴影
            elevation =  ButtonDefaults.elevation(defaultElevation = 0.dp, pressedElevation = 10.dp, disabledElevation = 4.dp),
            //设置 enable disable 状态下的背景及内容颜色
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan, contentColor = Color.White,
                disabledBackgroundColor = Color.DarkGray, disabledContentColor = Color.LightGray),
        ) {
            //content 是个 row
            Icon(imageVector = Icons.Default.Call, contentDescription = null)
            Text(text = "ButtonBasic")
            Text(text = "_xxx")
        }
        Spacer(modifier = Modifier.height(4.dp))

        Button(
            onClick ={ buttonEnable = !buttonEnable},
            //边框，边框加在内容部分不是加在内容外
            border = BorderStroke(6.dp, Color.Magenta),
            //默认 圆角矩形
            shape = RectangleShape,
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(text = "ChangeTopEnable")
        }
    }
}

@Composable
fun OutlinedButtonBasic(){
    OutlinedColumn(color = Color.Magenta) {
        //默认带一个 border -> outlinedBorder
        OutlinedButton(onClick = {  },) {
            Text(text = "OutlinedButtonBasic" )
        }
    }
}

@Composable
fun IconButtonBasic(){
    OutlinedColumn(color = Color.Yellow) {
        IconButton(onClick = {}) {
            Icon(Icons.Filled.Favorite, contentDescription = null )
        }
    }
}

@Composable
fun TextButtonBasic(){
    OutlinedColumn(color = Color.Green) {
        TextButton(onClick = {}) { Text("TextButtonBasic") }
        Text(text = "TextButtonBasic", modifier = Modifier.clickable(onClick = {}))
    }
}

@Composable
fun IconToggleButtonBasic(){
    var checked by remember { mutableStateOf(false)}
    OutlinedColumn(color = Color.Cyan) {
        IconToggleButton(checked = checked, onCheckedChange = {checked = it}) {
            val tint by animateColorAsState(if (checked) Color(0xFFEC407A) else Color(0xFFB0BEC5))
            Icon(Icons.Filled.CheckCircle, tint = tint, contentDescription = null)
        }
    }
}

@Composable
fun RadioButtonBasic() {
    var checkedIndex by remember { mutableStateOf(0) }
    OutlinedColumn(color = Color.Magenta) {
        //设置 selectableGroup 实现 RadioButton 互斥效果
        Row(modifier = Modifier
            .fillMaxWidth()
            .selectableGroup()) {
            RadioButton(selected = checkedIndex == 0, onClick = { checkedIndex = 0 })
            RadioButton(selected = checkedIndex == 1, onClick = { checkedIndex = 1 })
            RadioButton(selected = checkedIndex == 2, onClick = { checkedIndex = 2 })
        }
    }
}

@Composable
fun RadioButtonCustom() {
    val radioOptions = listOf("Calls", "Missed", "Friends")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(0) }
    OutlinedColumn(color = Color.Green) {
        Row(
            Modifier
                .fillMaxWidth()
                .selectableGroup(), horizontalArrangement = Arrangement.SpaceBetween) {
            radioOptions.forEachIndexed { index,text ->
                val selected = index == selectedOption
                // Modifier.selectable() 实现 RadioButton
                Row(Modifier.selectable(selected = selected, onClick = { onOptionSelected(index) },
                    role = Role.RadioButton)) {
                    val tint by animateColorAsState(if (selected) Color(0xFFEC407A) else Color(0xFFB0BEC5))
                    Icon(Icons.Filled.CheckCircle, tint = tint, contentDescription = null)
                    Text(text = text, modifier = Modifier.padding(start = 16.dp))
                }
            }
        }
    }
}
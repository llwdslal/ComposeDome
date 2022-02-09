package com.rock.composedome.demo.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.rock.composedome.compose.OutlinedColumn

class StateButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                RadioButtonBasic()
                RadioButtonCustom()
                CheckBoxBasic()
                CheckBoxCustom()
                IconToggleButtonBasic()
                SwitchBasic()
            }
        }
    }
}

@Composable
fun IconToggleButtonBasic(){
    var checked by remember { mutableStateOf(false) }
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
    //解构出 value  和 setValue()
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(0) }
    OutlinedColumn(color = Color.Green) {
        Row(
            Modifier.fillMaxWidth().selectableGroup(), horizontalArrangement = Arrangement.SpaceBetween) {
            radioOptions.forEachIndexed { index,text ->
                val selected = index == selectedOption
                // Modifier.selectable() 实现 RadioButton
                Row(
                    Modifier.selectable(selected = selected, onClick = { onOptionSelected(index) },
                    role = Role.RadioButton)) {
                    val tint by animateColorAsState(if (selected) Color(0xFFEC407A) else Color(0xFFB0BEC5))
                    Icon(Icons.Filled.CheckCircle, tint = tint, contentDescription = null)
                    Text(text = text, modifier = Modifier.padding(start = 16.dp))
                }
            }
        }
    }
}

@Composable
fun CheckBoxBasic(){
    val options = listOf("Calls", "Missed", "Friends")
    val optionsState = options.map { remember{ mutableStateOf(false)} }

    OutlinedColumn(color = Color.Magenta) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            options.forEachIndexed { index, optionStr ->
                //解构出 value  和 setValue()
                val (checked,setChecked) = optionsState[index]
                Row(verticalAlignment = Alignment.CenterVertically) {
                    //点击 CheckBox 可以触发时间 ， 点击文本无反应
                    Checkbox(checked = checked, onCheckedChange = setChecked)
                    Text(text = optionStr)
                }
            }
        }
    }
}

@Composable
fun CheckBoxCustom(){
    val options = listOf("Calls", "Missed", "Friends")
    val optionsState = options.map { remember{ mutableStateOf(false)} }

    OutlinedColumn(color = Color.Blue) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            options.forEachIndexed { index, optionStr ->
                val (checked,setChecked) = optionsState[index]
                val tint by animateColorAsState(if (checked) Color(0xFFEC407A) else Color(0xFFB0BEC5))
                // Modifier.toggleable() 实现 CheckBox
                Row(modifier = Modifier.toggleable(value = checked, onValueChange = setChecked),
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.CheckCircle, tint = tint, contentDescription = null)
                    Text(text = optionStr)
                }
            }
        }
    }
}

@Composable
fun SwitchBasic(){
    var checked by remember{ mutableStateOf(false)}
    OutlinedColumn(color = Color.Green) {
        Switch(checked = checked, onCheckedChange = { checked = it })
    }
}
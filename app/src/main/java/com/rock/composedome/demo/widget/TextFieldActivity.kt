package com.rock.composedome.demo.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TextInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column{
                TextFieldBasic{ onKeyDoneClick() }
                Spacer(modifier = Modifier.height(8.dp))
                PasswordStyle()
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextFieldBasic{ onKeyDoneClick() }
            }
        }
    }

    private fun onLogin(username:String,password:String){
        Toast.makeText(this, "username:$username <> password:$password", Toast.LENGTH_SHORT).show()
    }

    private fun onKeyDoneClick(){
        Toast.makeText(this, "onKeyDoneClick", Toast.LENGTH_SHORT).show()
    }

}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldBasic(onKeyDoneClick: (KeyboardActionScope.() -> Unit)) {
    // 键盘控制器
    val keyboardController = LocalSoftwareKeyboardController.current
    // remember 返回的是 State<T> 类型
    val inputContent: MutableState<String> = remember { mutableStateOf("") }
    // by + remember 直接返回类型 T
    var isError: Boolean by remember { mutableStateOf(false) }

    fun changeInputContent(text: String) {
        inputContent.value = text
        isError = inputContent.value.length > 11
    }

    Column(modifier = Modifier
        .border(width = 1.dp, color = Color.Cyan, shape = RectangleShape)
        .padding(16.dp)
        .fillMaxWidth()) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 18.sp),//输入文本的样式
            value = inputContent.value,//显示的文本
            onValueChange = { changeInputContent(it.trim()) },  //输入变化
            //文本上显示的标签
            label = { if (isError) Text(text = "*电话号格式错误") else Text(text = "电话号") },
            placeholder = { Text(text = "请输入 11 位移动电话号码") }, //占位提示
            //前面的图标
            leadingIcon = { Icon(imageVector = Icons.Default.Phone, contentDescription = null) },
            //后面的图标
            trailingIcon = {
                if (inputContent.value.isNotEmpty()) {
                    IconButton(onClick = { changeInputContent("") }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                    }
                }
            },
            isError = isError,  //输入内容是否有误
            readOnly = false,  //是否是只读
            //键盘设置 KeyboardType-> 键盘类型 ， ImeAction -> 回车键类型
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            //回车键点击后响应回调
            keyboardActions = KeyboardActions(onDone = {
                onKeyDoneClick()
                keyboardController?.hide()
            }),
            singleLine = true,//是否单行
            // maxLines = 15,  // 最大行数
            shape = RoundedCornerShape(4.dp), // TextField 的形状1
            //颜色配置
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Cyan,
                cursorColor = Color.Yellow,
                backgroundColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                placeholderColor = Color.Blue,
                trailingIconColor = Color.Red
            )
        )
    }
}

@Composable
fun PasswordStyle(){
    //rememberSaveable 旋转屏幕 ， 配置变更等重新加载 值会保留 类似 saveInstanceState
    var password by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(
            "123456789",
            TextRange(2, 5)))//选中的的区域
    }
    Column(modifier = Modifier
        .border(width = 1.dp, color = Color.Green, shape = RectangleShape)
        .padding(16.dp)
        .fillMaxWidth()) {
        TextField(value = password, onValueChange = {password = it},
            //内容输入后 用'\uD83D' 代替
            visualTransformation = PasswordVisualTransformation(mask = '\uD83D'),
            //显示 密码键盘
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OutlinedTextFieldBasic(onKeyDoneClick: (KeyboardActionScope.() -> Unit)) {
    // 键盘控制器
    val keyboardController = LocalSoftwareKeyboardController.current
    // remember 返回的是 State<T> 类型
    val inputContent: MutableState<String> = remember { mutableStateOf("") }
    // by + remember 直接返回类型 T
    var isError: Boolean by remember { mutableStateOf(false) }

    fun changeInputContent(text: String) {
        inputContent.value = text
        isError = inputContent.value.length > 11
    }

    Column(modifier = Modifier
        .border(width = 1.dp, color = Color.Cyan, shape = RectangleShape)
        .padding(16.dp)
        .fillMaxWidth()) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 18.sp),//输入文本的样式
            value = inputContent.value,//显示的文本
            onValueChange = { changeInputContent(it.trim()) },  //输入变化
            //文本上显示的标签
            label = { if (isError) Text(text = "*电话号格式错误") else Text(text = "电话号") },
            placeholder = { Text(text = "请输入 11 位移动电话号码") }, //占位提示
            //前面的图标
            leadingIcon = { Icon(imageVector = Icons.Default.Phone, contentDescription = null) },
            //后面的图标
            trailingIcon = {
                if (inputContent.value.isNotEmpty()) {
                    IconButton(onClick = { changeInputContent("") }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                    }
                }
            },
            isError = isError,  //输入内容是否有误
            readOnly = false,  //是否是只读
            //键盘设置 KeyboardType-> 键盘类型 ， ImeAction -> 回车键类型
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            //回车键点击后响应回调
            keyboardActions = KeyboardActions(onDone = {
                onKeyDoneClick()
                keyboardController?.hide()
            }),
            singleLine = true,//是否单行
            // maxLines = 15,  // 最大行数
            shape = RoundedCornerShape(4.dp), // TextField 的形状1
            //颜色配置
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Cyan,
                cursorColor = Color.Yellow,
                backgroundColor = Color.LightGray,
                placeholderColor = Color.Blue,
                trailingIconColor = Color.Red
            )
        )
    }
}
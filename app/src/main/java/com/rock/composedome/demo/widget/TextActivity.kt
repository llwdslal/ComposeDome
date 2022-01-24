package com.rock.composedome.demo.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rock.composedome.R

class TextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                TextBasic()
                Spacer(modifier = Modifier.height(8.dp))
                TextMultiStyle()
                Spacer(modifier = Modifier.height(8.dp))
                TextSelectable()
            }
        }
    }
}

@Composable
fun TextBasic(){
    Column(modifier = Modifier
        .border(width = 1.dp, color = Color.Cyan, shape = RectangleShape)
        .padding(16.dp)
        .fillMaxWidth()) {
        //使用 string.xml 引用
        Text(text = stringResource(id = R.string.string_from_xml))
        //设置颜色
        Text(text = "TextBasic", color = Color.Red)
        //设置对齐
        Text(text = "TextBasic", modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Red), textAlign = TextAlign.Center)
        //粗体，斜体
        Text(text = "TextBasic", fontSize = 24.sp, fontWeight = FontWeight.Black, fontStyle = FontStyle.Italic)
        //下划线 ，中划线
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "TextBasic", textDecoration = TextDecoration.LineThrough)
            Text(text = "TextBasic", textDecoration = TextDecoration.Underline)
            Text(text = "TextBasic", textDecoration = TextDecoration.combine(listOf(TextDecoration.LineThrough,TextDecoration.Underline)))
        }
        //设置最大行数、文字溢出 、段落中的行距(单行不生效)
        Text(text = "TextBasic".repeat(30), maxLines = 2, overflow = TextOverflow.Ellipsis, lineHeight = 50.sp)
        //设置字符间距 ，lineHeight 单行不生效
        Text(text = "TextBasic", letterSpacing = 4.sp, lineHeight = 50.sp)
        //设置自动换行  默认 true , false 不换行
        Text(text = "TextBasic".repeat(30), softWrap = false)
    }
}

@Composable
fun TextMultiStyle(){
    Column(modifier = Modifier
        .border(width = 1.dp, color = Color.Red, shape = RectangleShape)
        .padding(16.dp)
        .fillMaxWidth()) {
        Text(text = buildAnnotatedString {
            //ParagraphStyle 设置段落样式
            withStyle(style = ParagraphStyle(lineHeight = 50.sp)){
                //SpanStyle 设置文本样式
                withStyle(style = SpanStyle(color = Color.Red)){
                    append("Ann")
                }
                append("otated")
                withStyle(style = SpanStyle(fontSize = 18.sp)){
                    append("String")
                }
                append("\n")
                append("AnnotatedString")
            }
        },
            //设置整体样式
            fontStyle = FontStyle.Italic)
    }
}

@Composable
fun TextSelectable(){
    Column(modifier = Modifier
        .border(width = 1.dp, color = Color.Blue, shape = RectangleShape)
        .padding(16.dp)
        .fillMaxWidth()) {
        SelectionContainer() {
            Text(text = "TextSelectable".repeat(20))
        }
    }
}
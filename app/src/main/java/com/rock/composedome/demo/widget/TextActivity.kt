package com.rock.composedome.demo.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
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
                Spacer(modifier = Modifier.height(8.dp))
                TextAnnotated()
                Spacer(modifier = Modifier.height(8.dp))
                TextFontFamily()
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
        Text(text = "TextBasic".repeat(30), maxLines = 2, overflow = TextOverflow.Ellipsis, lineHeight = 30.sp)
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
            withStyle(style = ParagraphStyle(lineHeight = 30.sp)){
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
            Text(text = "TextSelectable".repeat(10))
        }
    }
}

@Composable
fun TextAnnotated(){
    val annotatedText = buildAnnotatedString {
        append("ClickableText + AnnotatedString 实现的可点链接样式")
        //开始添加一段注解字符串，指定 tag 和 annotation
        pushStringAnnotation(tag = "URL_En", annotation = "https://developer.android.com")
        withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.LineThrough)) {
            append("Android Developer")
        }

        append("没有调用 pop() 点到这注解部分也会触发")
        //注解结束
        pop()
        append("或者")
        pushStringAnnotation(tag = "URL_Ch", annotation = "https://developer.android.google.cn")
        withStyle(style = SpanStyle(color = Color.Blue,textDecoration = TextDecoration.Underline) ) {
            append("安卓开发者")
        }
        pop()
    }
    
    Column(modifier = Modifier
        .border(width = 1.dp, color = Color.Green, shape = RectangleShape)
        .padding(16.dp)
        .fillMaxWidth()) {
        Text(text = "用 Text 实现的可点链接样式",color = Color.Blue, textDecoration = TextDecoration.Underline , modifier = Modifier.clickable {
            Log.e("TextAnnotated","Text on click")
        })
        Spacer(modifier = Modifier.height(8.dp))
        ClickableText(text = annotatedText, onClick = { offset ->
            Log.e("ClickableText","点击到文本的位置:$offset")
            annotatedText.getStringAnnotations(offset,offset).firstOrNull()?.let {
                Log.e("TextAnnotated", "getStringAnnotations:${it.item} AnnotatedString:${it}")
            }
        })

    }
}

@Composable
fun TextFontFamily(){
    //配置字体
    val customFamily = FontFamily(//瞎配的
        Font(R.font.bickhamscriptfancy2, FontWeight.Thin), // Thin = W100
        Font(R.font.biaukai, FontWeight.Normal),//Normal = W400
        Font(R.font.belong_faith_regular_nrjjm, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.bmjua_regular, FontWeight.Medium),//Medium = FontWeight.W500
        Font(R.font.din_alternate, FontWeight.Bold)//Bold = W700
    )
    Column(modifier = Modifier
        .border(width = 1.dp, color = Color.Yellow, shape = RectangleShape)
        .padding(16.dp)
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())//滚动
    ) {
        //compose ui 包中的字体
        Text(text = "FontFamily Default", fontFamily = FontFamily.Default)
        Text(text = "FontFamily FontFamily", fontFamily = FontFamily.Serif)
        Text(text = "FontFamily Monospace", fontFamily = FontFamily.Monospace)
        Text(text = "FontFamily SansSerif", fontFamily = FontFamily.SansSerif)
        Text(text = "FontFamily Cursive", fontFamily = FontFamily.Cursive)

        //自定义字体  根据  fontWeight  fontStyle 自动寻找到对应的字体，
        //没有配置的 weight ，会在配置中找到最近的 weight ，优先大的值。
        Text(text = "CustomFontFamily", fontFamily = customFamily, fontStyle = FontStyle.Italic)
        // Medium W500 , Bold = W700 ;
        // W600 没配置过先向上找 +100  -> W700  -> din_alternate
        Text(text = "CustomFontFamily W500", fontFamily = customFamily, fontWeight = FontWeight.Medium)
        Text(text = "CustomFontFamily W700", fontFamily = customFamily, fontWeight = FontWeight.Bold)
        Text(text = "CustomFontFamily W600", fontFamily = customFamily, fontWeight = FontWeight.W600)
        Spacer(modifier = Modifier.height(8.dp))
        // W200 没配置过先向上找 +100 -> W300 没找到,向下找 -> -100 -> W100 -> bickhamscriptfancy2
        Text(text = "CustomFontFamily W100", fontFamily = customFamily, fontWeight = FontWeight.Thin)
        Text(text = "CustomFontFamily W400", fontFamily = customFamily, fontWeight = FontWeight.Normal)
        Text(text = "CustomFontFamily W200", fontFamily = customFamily, fontWeight = FontWeight.W200)
    }
}
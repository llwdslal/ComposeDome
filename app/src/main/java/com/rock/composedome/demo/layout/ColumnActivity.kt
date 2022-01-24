package com.rock.composedome.demo.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class ColumnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnBasic()
        }
    }
}

@Composable
fun ColumnBasic(){
    Column(
        modifier = Modifier.fillMaxWidth().background(Color.Cyan).padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.background(Color.Yellow).size(200.dp,60.dp))
        Box(modifier = Modifier.background(Color.Magenta).size(200.dp,60.dp).align(Alignment.Start))
        Box(modifier = Modifier.background(Color.LightGray).size(200.dp,60.dp).align(Alignment.End))
    }
}
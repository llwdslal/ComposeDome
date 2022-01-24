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

class RowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RowBasic()
        }
    }
}

@Composable
fun RowBasic(){
    Row(
        modifier = Modifier.height(200.dp).background(Color.Cyan).padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.background(Color.Yellow).size(100.dp,60.dp))
        Box(modifier = Modifier.background(Color.Magenta).size(100.dp,60.dp).align(Alignment.Top))
        Box(modifier = Modifier.background(Color.LightGray).size(100.dp,60.dp).align(Alignment.Bottom))
    }
}
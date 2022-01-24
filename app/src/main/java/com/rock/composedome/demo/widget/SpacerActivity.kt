package com.rock.composedome.demo.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class SpacerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpacerBasic()
        }
    }
}

@Composable
fun SpacerBasic(){
    Row(
        Modifier.fillMaxWidth().padding(8.dp).background(Color.Cyan, RoundedCornerShape(12.dp)).padding(6.dp)
    ) {
        Box(Modifier.background(Color.Red).size(100.dp, 80.dp))
        Spacer(Modifier.width(20.dp))
        Box(Modifier.background(Color.Magenta).height(60.dp).weight(1f))
    }
}

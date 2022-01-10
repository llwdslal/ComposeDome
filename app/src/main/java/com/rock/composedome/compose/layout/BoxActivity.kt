package com.rock.composedome.compose.layout

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
import com.rock.composedome.ui.theme.ComposeDomeTheme

class BoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDomeTheme{
                Column() {
                    BoxBasic()
                    Spacer(modifier = Modifier.height(4.dp))
                    BoxAlignment()
                }
            }
        }
    }
}

@Composable
fun BoxBasic(){
    Box(modifier = Modifier.background(Color.Cyan).size(200.dp, 200.dp)){
        Box(modifier = Modifier.background(Color.Green).size(150.dp, 150.dp))
        Box(modifier = Modifier.background(Color.Blue).size(100.dp, 100.dp))
    }
}

@Composable
fun BoxAlignment(){
    Box(
        modifier = Modifier.background(Color.Cyan).size(200.dp, 200.dp),
        contentAlignment = Alignment.Center
    ){
        Box(modifier = Modifier.background(Color.Green).size(150.dp, 150.dp))
        Box(modifier = Modifier.background(Color.Blue).size(100.dp, 100.dp).align(Alignment.BottomEnd))
    }
}


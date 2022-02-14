package com.rock.composedome.demo.scaffold

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class ScaffoldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            ScaffoldBasic()
        }
    }
}

@Composable
fun ScaffoldBasic(){
    Scaffold(
        topBar = { TopAppBarBasic2() },
        bottomBar = { BottomAppBarBasic2() },
        floatingActionButton = { FloatingActionButtonBasic() },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        drawerGesturesEnabled = true,
        drawerShape = RoundedCornerShape(4.dp),
        drawerContent = { Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow))}

    ) {

    }
}




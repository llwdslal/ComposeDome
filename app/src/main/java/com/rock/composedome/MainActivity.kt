package com.rock.composedome

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rock.composedome.compose.layout.BoxActivity
import com.rock.composedome.compose.layout.ColumnActivity
import com.rock.composedome.compose.layout.RowActivity
import com.rock.composedome.ui.theme.ComposeDomeTheme

class MainActivity : ComponentActivity() {

    private val items = mutableListOf<MenuItem>().also {
        it.add(MenuItem("Box Activity"){trans2Activity(BoxActivity::class.java)})
        it.add(MenuItem("Column Activity"){trans2Activity(ColumnActivity::class.java)})
        it.add(MenuItem("Row Activity"){trans2Activity(RowActivity::class.java)})
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDomeTheme {
                OptionMenu(items)
            }
        }
    }
    
    private fun trans2Activity(clazz: Class<out Activity>){
        startActivity(Intent(this,clazz))
    }
}

data class MenuItem(val title:String,val onClick:(()->Unit))

@Composable
fun OptionMenu(menuItems:List<MenuItem>) {
    LazyColumn(
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)){
        items(menuItems){
            Button(modifier = Modifier.fillMaxWidth() ,onClick = it.onClick) {
                Text(text = it.title)
            }
        }
    }
}



package com.rock.composedome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import com.rock.composedome.compose.OptionMenu
import com.rock.composedome.demo.widget.*
import com.rock.composedome.ktx.startActivity
import com.rock.composedome.models.MenuItem

class WidgetsIndex : AppCompatActivity() {
    private val menuItems = mutableListOf<MenuItem>().also {
        it.add(MenuItem("Text"){startActivity(TextActivity::class.java)})
        it.add(MenuItem("TextField"){startActivity(TextFieldActivity::class.java)})
        it.add(MenuItem("Button"){startActivity(ButtonActivity::class.java)})
        it.add(MenuItem("Image"){startActivity(ImageActivity::class.java)})
        it.add(MenuItem("StateButton"){startActivity(StateButtonActivity::class.java)})
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = { TopAppBar(
                    title = {Text("Widgets")},
                    navigationIcon = { IconButton(onClick = { finish() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }}
                )}
            ) {
                OptionMenu(menuItems = menuItems)
            }
        }
    }
}




package com.rock.composedome.base

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import com.rock.composedome.compose.OptionMenu
import com.rock.composedome.models.MenuItem

abstract class MenuActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = { TopAppBar(
                    title = { Text(getMenuTitle()) },
                    navigationIcon = { IconButton(onClick = { finish() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                    }
                )
                }
            ) {
                OptionMenu(menuItems = getMenu())
            }
        }
    }

    abstract fun getMenuTitle():String

    abstract fun getMenu():List<MenuItem>

}
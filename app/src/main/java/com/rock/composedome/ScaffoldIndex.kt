package com.rock.composedome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import com.rock.composedome.compose.OptionMenu
import com.rock.composedome.demo.layout.BoxActivity
import com.rock.composedome.demo.layout.ColumnActivity
import com.rock.composedome.demo.layout.RowActivity
import com.rock.composedome.demo.scaffold.BottomBarActivity
import com.rock.composedome.demo.scaffold.ScaffoldActivity
import com.rock.composedome.demo.scaffold.TopBarActivity
import com.rock.composedome.demo.widget.SpacerActivity
import com.rock.composedome.ktx.startActivity
import com.rock.composedome.models.MenuItem

class ScaffoldIndex : AppCompatActivity() {
    private val menuItems = mutableListOf<MenuItem>().also {
        it.add(MenuItem("TopBar"){startActivity(TopBarActivity::class.java)})
        it.add(MenuItem("BottomBar"){startActivity(BottomBarActivity::class.java)})
        it.add(MenuItem("Scaffold"){startActivity(ScaffoldActivity::class.java)})
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = { TopAppBar(
                    title = { Text("Scaffold") },
                    navigationIcon = { IconButton(onClick = { finish() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                    }
                )
                }
            ) {
                OptionMenu(menuItems = menuItems)
            }
        }
    }
}
package com.rock.composedome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rock.composedome.compose.OptionMenu
import com.rock.composedome.ktx.startActivity
import com.rock.composedome.models.MenuItem
import com.rock.composedome.ui.theme.ComposeDomeTheme

class MainActivity : ComponentActivity() {

    private val menuItems = mutableListOf<MenuItem>().also {

        it.add(MenuItem("布局 Layouts"){startActivity(LayoutsIndex::class.java)})
        it.add(MenuItem("组件 Widgets"){startActivity(WidgetsIndex::class.java)})
        it.add(MenuItem("脚手架 Scaffold"){startActivity(ScaffoldIndex::class.java)})
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDomeTheme {
                OptionMenu(menuItems)
            }
        }
    }
}







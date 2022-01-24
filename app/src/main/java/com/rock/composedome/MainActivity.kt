package com.rock.composedome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rock.composedome.compose.OptionMenu
import com.rock.composedome.demo.layout.BoxActivity
import com.rock.composedome.demo.layout.ColumnActivity
import com.rock.composedome.demo.layout.RowActivity
import com.rock.composedome.demo.widget.SpacerActivity
import com.rock.composedome.demo.layout.ScaffoldActivity
import com.rock.composedome.ktx.startActivity
import com.rock.composedome.models.MenuItem
import com.rock.composedome.ui.theme.ComposeDomeTheme

class MainActivity : ComponentActivity() {

    private val menuItems = mutableListOf<MenuItem>().also {
        it.add(MenuItem("Box"){startActivity(BoxActivity::class.java)})
        it.add(MenuItem("Column"){startActivity(ColumnActivity::class.java)})
        it.add(MenuItem("Row"){startActivity(RowActivity::class.java)})
        it.add(MenuItem("Spacer"){startActivity(SpacerActivity::class.java)})
        it.add(MenuItem("Scaffold"){startActivity(ScaffoldActivity::class.java)})
        it.add(MenuItem("Widgets"){startActivity(WidgetsIndex::class.java)})
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







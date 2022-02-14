package com.rock.composedome

import com.rock.composedome.base.MenuActivity
import com.rock.composedome.demo.layout.BoxActivity
import com.rock.composedome.demo.layout.ColumnActivity
import com.rock.composedome.demo.layout.RowActivity
import com.rock.composedome.demo.widget.*
import com.rock.composedome.ktx.startActivity
import com.rock.composedome.models.MenuItem

class LayoutsIndex : MenuActivity() {

    override fun getMenuTitle(): String = "Widgets"

    override fun getMenu(): List<MenuItem> = mutableListOf<MenuItem>().also {
        it.add(MenuItem("Box"){startActivity(BoxActivity::class.java)})
        it.add(MenuItem("Column"){startActivity(ColumnActivity::class.java)})
        it.add(MenuItem("Row"){startActivity(RowActivity::class.java)})
        it.add(MenuItem("Spacer"){startActivity(SpacerActivity::class.java)})
    }
}
package com.rock.composedome

import com.rock.composedome.base.MenuActivity
import com.rock.composedome.ktx.startActivity
import com.rock.composedome.models.MenuItem

class ListIndex : MenuActivity() {


    override fun getMenuTitle(): String = "List"

    override fun getMenu(): List<MenuItem> = mutableListOf<MenuItem>().also {
//        it.add(MenuItem("TopBar"){startActivity(TopBarActivity::class.java)})

    }
}
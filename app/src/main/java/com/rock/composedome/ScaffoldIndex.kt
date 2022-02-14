package com.rock.composedome

import com.rock.composedome.base.MenuActivity
import com.rock.composedome.demo.scaffold.*
import com.rock.composedome.ktx.startActivity
import com.rock.composedome.models.MenuItem

class ScaffoldIndex : MenuActivity() {
    override fun getMenuTitle() = "Scaffold"

    override fun getMenu(): List<MenuItem> =  mutableListOf<MenuItem>().also {
        it.add(MenuItem("TopBar"){startActivity(TopBarActivity::class.java)})
        it.add(MenuItem("BottomBar"){startActivity(BottomBarActivity::class.java)})
        it.add(MenuItem("Drawer"){startActivity(DrawerActivity::class.java)})
        it.add(MenuItem("SnackBar"){startActivity(SnackBarActivity::class.java)})
        it.add(MenuItem("Scaffold"){startActivity(ScaffoldActivity::class.java)})
    }
}
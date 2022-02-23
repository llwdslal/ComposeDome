package com.rock.composedome

import com.rock.composedome.base.MenuActivity
import com.rock.composedome.demo.gesture.DragActivity
import com.rock.composedome.demo.gesture.PressActivity
import com.rock.composedome.demo.gesture.ScrollActivity
import com.rock.composedome.ktx.startActivity
import com.rock.composedome.models.MenuItem

class GestureIndex : MenuActivity() {

    override fun getMenuTitle(): String = "Gesture"

    override fun getMenu(): List<MenuItem> =  mutableListOf<MenuItem>().also {
        it.add(MenuItem("Press & Tap"){startActivity(PressActivity::class.java)})
        it.add(MenuItem("Scroll"){startActivity(ScrollActivity::class.java)})
        it.add(MenuItem("Drag"){startActivity(DragActivity::class.java)})
    }
}
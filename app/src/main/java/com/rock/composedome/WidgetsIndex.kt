package com.rock.composedome

import com.rock.composedome.base.MenuActivity
import com.rock.composedome.demo.widget.*
import com.rock.composedome.ktx.startActivity
import com.rock.composedome.models.MenuItem

class WidgetsIndex : MenuActivity() {

    override fun getMenuTitle() = "Widgets"

    override fun getMenu(): List<MenuItem> = mutableListOf<MenuItem>().also {
        it.add(MenuItem("Text"){startActivity(TextActivity::class.java)})
        it.add(MenuItem("TextField"){startActivity(TextFieldActivity::class.java)})
        it.add(MenuItem("Button"){startActivity(ButtonActivity::class.java)})
        it.add(MenuItem("Image"){startActivity(ImageActivity::class.java)})
        it.add(MenuItem("StateButton"){startActivity(StateButtonActivity::class.java)})
        it.add(MenuItem("SliderProgressBar"){startActivity(SliderProgressBarActivity::class.java)})
    }
}




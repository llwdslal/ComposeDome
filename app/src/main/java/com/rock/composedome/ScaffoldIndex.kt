package com.rock.composedome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rock.composedome.demo.layout.BoxActivity
import com.rock.composedome.demo.layout.ColumnActivity
import com.rock.composedome.demo.layout.RowActivity
import com.rock.composedome.demo.scaffold.ScaffoldActivity
import com.rock.composedome.demo.widget.SpacerActivity
import com.rock.composedome.ktx.startActivity
import com.rock.composedome.models.MenuItem

class ScaffoldIndex : AppCompatActivity() {
    private val menuItems = mutableListOf<MenuItem>().also {
        it.add(MenuItem("Scaffold"){startActivity(ScaffoldActivity::class.java)})
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
package com.rock.composedome.demo.scaffold

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.rock.composedome.R

class BottomNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationBasic()
        }
    }
}

data class TabItem(val name:String,val resId:Int)

@Composable
fun BottomNavigationBasic(){
    val tabs = mutableListOf(
        TabItem("One", R.drawable.ic_img_test),
        TabItem("Two", R.drawable.ic_img_test),
        TabItem("Three", R.drawable.ic_img_test),
        TabItem("Four", R.drawable.ic_img_test),
    )

    val checkedIndex = remember{ mutableStateOf(0)}
    Scaffold(
        bottomBar = {
            BottomNavigation{
                tabs.forEachIndexed { index, tabItem ->
                    val selected = checkedIndex.value == index
                    BottomNavigationItem(
                        selected = selected,
                        onClick = { if (!selected) checkedIndex.value = index},
                        icon = { Icon(painter = painterResource(id = tabItem.resId), contentDescription = "") },
                        label = { Text(text = tabItem.name) },
                        unselectedContentColor = Color.Gray,
                        selectedContentColor = Color.Magenta
                    )
                }
            }
        }
    ) {}
}
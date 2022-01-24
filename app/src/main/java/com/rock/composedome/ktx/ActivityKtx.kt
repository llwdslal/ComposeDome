package com.rock.composedome.ktx

import android.app.Activity
import android.content.Intent

fun Activity.startActivity(clazz: Class<out Activity>) = this.apply {
    startActivity(Intent(this,clazz))
}
package com.rock.composedome.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rock.composedome.models.MenuItem

@Composable
fun OptionMenu(menuItems:List<MenuItem>) {
    LazyColumn(
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)){
        items(menuItems){
            Button(modifier = Modifier.fillMaxWidth() ,onClick = it.onClick) {
                Text(text = it.title)
            }
        }
    }
}
package com.rock.composedome.compose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedColumn(color:Color, content: @Composable ColumnScope.() -> Unit) {
    Column(modifier = Modifier
        .padding(horizontal = 0.dp, vertical = 4.dp)
        .border(width = 1.dp, color = color, shape = RectangleShape)
        .padding(16.dp)
        .fillMaxWidth(),
        content = content
     )
}
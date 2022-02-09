package com.rock.composedome.demo.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rock.composedome.R
import com.rock.composedome.compose.OutlinedColumn

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                ImageBasic()
                ImageBasic2()
            }
        }
    }
}

@Composable
fun ImageBasic() {
    OutlinedColumn(color = Color.Magenta) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Image(
                painter = painterResource(id = R.drawable.ic_img_test),
                modifier = Modifier.background(Color.Gray),
                contentDescription = "",
            )
            Image(
                painter = painterResource(id = R.drawable.ic_img_test),
                modifier = Modifier.background(Color.Gray).size(50.dp, 100.dp),
                contentDescription = "",
            )
            Image(
                painter = painterResource(id = R.drawable.ic_img_test),
                modifier = Modifier.background(Color.Gray).size(50.dp, 100.dp),
                //默认 Alignment.Center
                alignment = Alignment.TopCenter,
                contentDescription = "",
            )
            Image(
                painter = painterResource(id = R.drawable.ic_img_test),
                modifier = Modifier.background(Color.Gray).size(50.dp, 100.dp),
                //默认 ContentScale.Fit
                contentScale = ContentScale.FillHeight,
                contentDescription = "",
            )
        }
    }
}

@Composable
fun ImageBasic2() {
    OutlinedColumn(color = Color.Cyan) {
        Image(imageVector = Icons.Default.Email, contentDescription = "")
    }
}

//fixme

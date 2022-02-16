package com.rock.composedome.demo.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.rock.composedome.R
import com.rock.composedome.compose.OutlinedColumn

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                ImageBasic()
                ImageBasic2()
                IconBasic()
                ImageFromNet()
                ImageGif()
            }
        }
    }
}

@Composable
fun ImageBasic() {
    OutlinedColumn(color = Color.Magenta) {
        val imageResId = R.drawable.ic_img_test
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {

            Image(painter = painterResource(imageResId), modifier = Modifier.background(Color.Gray),
                contentDescription = "",)

            Image(painter = painterResource(imageResId),
                modifier = Modifier
                    .background(Color.Gray)
                    .size(50.dp, 100.dp),
                contentDescription = "",)

            Image(painter = painterResource(imageResId),
                modifier = Modifier
                    .background(Color.Gray)
                    .size(50.dp, 100.dp),
                //默认 Alignment.Center
                alignment = Alignment.TopCenter,
                contentDescription = "",
            )

            Image(painter = painterResource(imageResId),
                modifier = Modifier
                    .background(Color.Gray)
                    .size(50.dp, 100.dp),
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

@Composable
fun ImageFromNet(){
    val imageUrl = "https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3D450%2C600/sign=0058b75d632762d0806bacbb95dc24cc/e7cd7b899e510fb3a6907fe9d933c895d0430cc6.jpg"
    OutlinedColumn(color = Color.Magenta) {
        Image(
            modifier = Modifier.size(60.dp),
            painter = rememberImagePainter(
                data = imageUrl,
                builder = {
                    //变形
                    transformations(CircleCropTransformation())
                    //动画
                    crossfade(true)
                }),
            contentDescription = "")
    }
}
@Composable
fun ImageGif(){
    val imageUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202003%2F29%2F20200329042030_uCcGM.thumb.400_0.gif"
    Image(painter = rememberImagePainter(data = imageUrl), contentDescription = "")
}

@Composable
fun IconBasic(){
    OutlinedColumn(color = Color.Red) {
        //默认会使用 LocalContentColor.current 作为 tint 渲染
        Icon( painter = painterResource(id = R.drawable.ic_img_test) , contentDescription = null)
    }
}
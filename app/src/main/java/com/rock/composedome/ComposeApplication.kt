package com.rock.composedome

import android.app.Application
import android.os.Build.VERSION.SDK_INT
import coil.Coil
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder

class ComposeApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        val imageLoader = ImageLoader.Builder(this)
            .componentRegistry{
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder(this@ComposeApplication))
                } else {
                    add(GifDecoder())
                }
            }
            .build()
        Coil.setImageLoader(imageLoader)
    }
}
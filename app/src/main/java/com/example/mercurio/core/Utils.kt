package com.example.mercurio.core

import android.os.Handler
import android.os.Looper

fun delayNavigation(navigate: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed({
        navigate()
    }, 500)
}
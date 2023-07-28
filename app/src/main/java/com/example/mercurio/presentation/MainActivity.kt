package com.example.mercurio.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mercurio.presentation.navigation.Navigation
import com.example.mercurio.presentation.ui.theme.MercurioTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MercurioTheme {
                Navigation()
            }
        }
    }
}
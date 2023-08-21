package com.example.mercurio.presentation.views.signin.login.components

import androidx.compose.ui.graphics.Color
import com.example.mercurio.presentation.ui.theme.md_theme_dark_onBackground
import com.example.mercurio.presentation.ui.theme.md_theme_light_onBackground

data class SwitcherColors(
    val darkTheme: Boolean = false,
    val signinBackgroundColor: Color = Color.Transparent,
    val signinContentColor: Color = if (darkTheme) md_theme_dark_onBackground else md_theme_light_onBackground,
    val signupBackgroundColor: Color = Color.Transparent,
    val signupContentColor: Color = if (darkTheme) md_theme_dark_onBackground else md_theme_light_onBackground,
)

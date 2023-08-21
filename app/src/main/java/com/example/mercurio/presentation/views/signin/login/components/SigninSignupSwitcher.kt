package com.example.mercurio.presentation.views.signin.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mercurio.core.StringConstants.LOGIN
import com.example.mercurio.core.StringConstants.SIGN_UP

@Composable
fun SigninSignupSwitcher(
    switcher: Switcher,
    onSwitch: (Switcher) -> Unit
) {
    var colors by remember {
        mutableStateOf(SwitcherColors())
    }

    colors = when (switcher) {
        Switcher.Signin -> {
            SwitcherColors(
                darkTheme = isSystemInDarkTheme(),
                signinBackgroundColor = MaterialTheme.colorScheme.primary,
                signinContentColor = MaterialTheme.colorScheme.onPrimary
            )
        }
        Switcher.Signup -> {
            SwitcherColors(
                darkTheme = isSystemInDarkTheme(),
                signupBackgroundColor = MaterialTheme.colorScheme.primary,
                signupContentColor = MaterialTheme.colorScheme.onPrimary
            )
        }
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.onPrimary,
                RoundedCornerShape(4.dp)
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(4.dp)
            )
    ) {
        SwitcherItem(
            text = LOGIN,
            modifier = Modifier.weight(1f),
            backgroundColor = colors.signinBackgroundColor,
            contentColor = colors.signinContentColor,
            switcher = switcher,
            onSwitch = {
                onSwitch(it)
            }
        )
        SwitcherItem(
            text = SIGN_UP,
            modifier = Modifier.weight(1f),
            backgroundColor = colors.signupBackgroundColor,
            contentColor = colors.signupContentColor,
            switcher = switcher,
            onSwitch = {
                onSwitch(it)
            }
        )
    }
}
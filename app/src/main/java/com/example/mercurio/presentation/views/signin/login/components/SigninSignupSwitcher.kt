package com.example.mercurio.presentation.views.signin.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mercurio.core.StringConstants.LOGIN
import com.example.mercurio.core.StringConstants.SIGN_UP
import com.example.mercurio.presentation.ui.theme.Beige
import com.example.mercurio.presentation.ui.theme.DeepBlue

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
                signinBackgroundColor = Beige,
                signinContentColor = DeepBlue,
            )
        }
        Switcher.Signup -> {
            SwitcherColors(
                signupBackgroundColor = Beige,
                signupContentColor = DeepBlue
            )
        }
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                DeepBlue,
                RoundedCornerShape(6.dp)
            )
            .border(
                1.dp,
                Beige,
                RoundedCornerShape(6.dp)
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
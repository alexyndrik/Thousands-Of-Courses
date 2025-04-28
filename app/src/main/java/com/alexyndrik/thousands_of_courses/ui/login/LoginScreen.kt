package com.alexyndrik.thousands_of_courses.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexyndrik.common.GreenButton
import com.alexyndrik.common.InputText
import com.alexyndrik.thousands_of_courses.R

@Composable
fun LoginScreen(
    onLoginClick: (email: String) -> Unit,
    onVkClick: () -> Unit,
    onOkClick: () -> Unit
) {

    var email: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }

    var isEmailError by rememberSaveable { mutableStateOf(false) }
    var isPasswordError by rememberSaveable { mutableStateOf(false) }

    fun validateEmail() {
        isEmailError = email.isEmpty() || !Regex("[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+").matches(email)
    }

    fun validatePassword() {
        isPasswordError = password.isEmpty()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = com.alexyndrik.common.R.color.black))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {

            Spacer(modifier = Modifier.height(140.dp))

            Text(
                text = stringResource(id = R.string.login),
                color = colorResource(id = com.alexyndrik.common.R.color.white),
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(28.dp))

            InputText(
                R.string.email,
                email,
                R.string.email_hint,
                {
                    email = it
                    validateEmail()
                },
                isError = isEmailError
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputText(
                R.string.password,
                password,
                R.string.password_hint,
                {
                    password = it
                    validatePassword()
                },
                isError = isPasswordError
            )

            Spacer(modifier = Modifier.height(24.dp))

            GreenButton(
                text = R.string.login,
                onClick = {
                    validateEmail()
                    validatePassword()
                    if (!isEmailError && !isPasswordError) onLoginClick(email)
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {

                Text(
                    text = stringResource(id = R.string.no_account),
                    color = colorResource(id = com.alexyndrik.common.R.color.white),
                    fontSize = 12.sp
                )

                Spacer(modifier = Modifier.width(3.dp))

                Text(
                    text = stringResource(id = R.string.registration),
                    color = colorResource(id = com.alexyndrik.common.R.color.green),
                    fontSize = 12.sp
                )

            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = stringResource(id = R.string.forget_password),
                color = colorResource(id = com.alexyndrik.common.R.color.green),
                fontSize = 12.sp
            )

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(id = R.drawable.divider),
                contentDescription = ""
            )

            Row {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clickable(onClick = onVkClick),
                    contentScale = ContentScale.FillWidth,
                    painter = painterResource(id = R.drawable.vk),
                    contentDescription = "",
                )

                Spacer(modifier = Modifier.width(16.dp))

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clickable(onClick = onOkClick),
                    contentScale = ContentScale.FillWidth,
                    painter = painterResource(id = R.drawable.ok),
                    contentDescription = "",
                )
            }

        }

    }

}
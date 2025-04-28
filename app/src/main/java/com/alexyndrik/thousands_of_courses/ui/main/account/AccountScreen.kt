package com.alexyndrik.thousands_of_courses.ui.main.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alexyndrik.common.GreenButton
import com.alexyndrik.thousands_of_courses.R
import com.alexyndrik.thousands_of_courses.data.datastore.AppSettingsDataStore

@Composable
fun AccountScreen(
    onLogout: () -> Unit
) {

    val context = LocalContext.current
    var email: String by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        email = AppSettingsDataStore.readEmail(context)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(com.alexyndrik.common.R.color.black))
            .padding(horizontal = 16.dp)
    ) {

        Spacer(modifier = Modifier.height(56.dp))

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = email,
            color = colorResource(com.alexyndrik.common.R.color.white),
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        GreenButton(text = R.string.logout, onClick = onLogout)

        Spacer(modifier = Modifier.weight(1f))

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(R.string.alexyndrik),
            color = colorResource(com.alexyndrik.common.R.color.green),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(120.dp))

    }

}
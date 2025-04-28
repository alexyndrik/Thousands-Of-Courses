package com.alexyndrik.thousands_of_courses.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexyndrik.common.GreenButton
import com.alexyndrik.thousands_of_courses.R

@Composable
fun OnboardingScreen(
    onFinished: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = com.alexyndrik.common.R.color.black))
    ) {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.systemBars))
        Spacer(modifier = Modifier.height(100.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .width(296.dp)
                .align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.onboarding_title),
            color = colorResource(id = com.alexyndrik.common.R.color.white),
            textAlign = TextAlign.Center,
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Image(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = R.drawable.img),
            contentDescription = stringResource(id = R.string.onboarding_title)
        )

        Spacer(modifier = Modifier.weight(1f))

        GreenButton(
            modifier = Modifier.padding(horizontal = 16.dp),
            R.string.onboarding_continue,
            onFinished
        )

        Spacer(modifier = Modifier.padding(bottom = 16.dp))
        Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.systemBars))
    }
}
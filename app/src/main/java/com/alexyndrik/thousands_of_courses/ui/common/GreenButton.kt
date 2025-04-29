package com.alexyndrik.thousands_of_courses.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alexyndrik.thousands_of_courses.R

@Composable
fun GreenButton(
    modifier: Modifier = Modifier,
    text: Int,
    onClick: () -> Unit
) {

    Button(
        modifier = modifier.fillMaxWidth().height(40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.green)
        ),
        onClick = onClick
    ) {

        Text(
            text = stringResource(id = text),
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center
        )

    }

}
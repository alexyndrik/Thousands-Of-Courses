package com.alexyndrik.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun InputText(
    title: Int,
    value: String,
    hint: Int,
    onValueChange: (it: String) -> Unit,
    isError: Boolean
) {
    
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = stringResource(id = title),
            color = colorResource(R.color.white),
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorResource(R.color.light_gray),
                unfocusedContainerColor = colorResource(R.color.light_gray),
                focusedTextColor = colorResource(R.color.white),
                unfocusedTextColor = colorResource(R.color.white),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                errorContainerColor = Color.Red,
                errorIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            value = value,
            placeholder = {
                Text(
                    text = stringResource(hint),
                    color = colorResource(R.color.white_50)
                )
            },
            onValueChange = { onValueChange(it) },
            shape = RoundedCornerShape(30.dp),
            isError = isError
        )
        
    }
    
}
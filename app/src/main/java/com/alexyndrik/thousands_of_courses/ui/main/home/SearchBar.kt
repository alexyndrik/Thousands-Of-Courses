package com.alexyndrik.thousands_of_courses.ui.main.home

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.alexyndrik.thousands_of_courses.R

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {

    var input by remember { mutableStateOf("") }

    TextField(
        modifier = modifier.height(56.dp),
        value = input,
        onValueChange = { input = it },
        placeholder = {
            Text(
                text = stringResource(R.string.search_courses),
                color = colorResource(com.alexyndrik.common.R.color.white_50)
            )
        },
        leadingIcon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = colorResource(com.alexyndrik.common.R.color.white)
            )
        },
        shape = RoundedCornerShape(28.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorResource(com.alexyndrik.common.R.color.dark_gray),
            unfocusedContainerColor = colorResource(com.alexyndrik.common.R.color.dark_gray),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = colorResource(com.alexyndrik.common.R.color.white),
            unfocusedTextColor = colorResource(com.alexyndrik.common.R.color.white)
        )
    )

}
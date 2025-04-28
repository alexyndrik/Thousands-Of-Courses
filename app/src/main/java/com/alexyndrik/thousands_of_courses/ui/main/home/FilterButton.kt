package com.alexyndrik.thousands_of_courses.ui.main.home

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun FilterButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Surface(
        modifier = modifier.size(56.dp),
        shape = RoundedCornerShape(28.dp),
        color = colorResource(com.alexyndrik.common.R.color.dark_gray)
    ) {

        IconButton(
            onClick = onClick
        ) {

            Icon(
                imageVector = Icons.Default.FilterAlt,
                contentDescription = null,
                tint = colorResource(com.alexyndrik.common.R.color.white)
            )

        }

    }

}
package com.alexyndrik.thousands_of_courses.ui.main.courses

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onClick: () -> Unit
) {

    Surface(
        modifier = Modifier.padding(all = 8.dp),
        shape = RoundedCornerShape(20.dp),
        color = colorResource(com.alexyndrik.common.R.color.glass)
    ) {

        IconButton(
            modifier = Modifier.size(28.dp).padding(all = 6.dp),
            onClick = onClick,
        ) {
            Icon(
                imageVector = if (isFavorite) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                contentDescription = null,
                tint = if (isFavorite) colorResource(com.alexyndrik.common.R.color.green) else colorResource(com.alexyndrik.common.R.color.white)
            )
        }

    }
}
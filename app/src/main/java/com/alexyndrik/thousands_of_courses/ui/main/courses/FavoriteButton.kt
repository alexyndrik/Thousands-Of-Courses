package com.alexyndrik.thousands_of_courses.ui.main.courses

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.alexyndrik.thousands_of_courses.R

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onClick: () -> Unit
) {

    Surface(
        modifier = Modifier.padding(all = 8.dp),
        shape = RoundedCornerShape(20.dp),
        color = colorResource(R.color.glass)
    ) {

        IconButton(
            modifier = Modifier.size(28.dp).padding(all = 6.dp),
            onClick = onClick,
        ) {
            Icon(
                imageVector = if (isFavorite) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                contentDescription = null,
                tint = if (isFavorite) colorResource(R.color.green) else colorResource(R.color.white)
            )
        }

    }
}
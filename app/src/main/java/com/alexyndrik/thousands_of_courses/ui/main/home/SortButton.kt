package com.alexyndrik.thousands_of_courses.ui.main.home

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SyncAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alexyndrik.thousands_of_courses.R

@Composable
fun SortButton(
    onClick: () -> Unit
) {

    TextButton(
        modifier = Modifier,
        onClick = onClick,
    ) {

        Text(
            text = stringResource(R.string.by_date_add),
            color = colorResource(com.alexyndrik.common.R.color.green),
            textAlign = TextAlign.Right,
            style = MaterialTheme.typography.bodyMedium
        )

        Icon(
            modifier = Modifier
                .rotate(90f)
                .height(14.dp)
                .align(Alignment.CenterVertically),
            imageVector = Icons.Default.SyncAlt,
            contentDescription = null,
            tint = colorResource(com.alexyndrik.common.R.color.green)
        )

    }

}
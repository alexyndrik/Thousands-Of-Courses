package com.alexyndrik.thousands_of_courses.ui.main.courses

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.alexyndrik.thousands_of_courses.R
import com.alexyndrik.thousands_of_courses.data.model.Course
import com.alexyndrik.thousands_of_courses.ui.main.favorites.FavoritesViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun CourseCard(
    course: Course,
    favoritesViewModel: FavoritesViewModel
) {
    var isFavorite by remember { mutableStateOf(false) }

    LaunchedEffect(course) {
        isFavorite = favoritesViewModel.isFavorite(course)
    }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = colorResource(com.alexyndrik.common.R.color.dark_gray)
    ) {

        Column {

            Surface(
                modifier = Modifier.fillMaxWidth().height(114.dp),
                shape = RoundedCornerShape(16.dp),
                color = colorResource(com.alexyndrik.common.R.color.white_70)
            ) {

                Column {

                    Row {
                        Spacer(modifier = Modifier.weight(1f))
                        FavoriteButton(isFavorite) {
                            isFavorite = !isFavorite
                            favoritesViewModel.toggleFavorite(course)
                        }
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Row(
                        modifier = Modifier.padding(all = 8.dp)
                    ) {

                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = colorResource(com.alexyndrik.common.R.color.glass)
                        ) {

                            Row(
                                modifier = Modifier.padding(vertical = 4.dp, horizontal = 6.dp)
                            ) {

                                Icon(
                                    modifier = Modifier.size(12.dp),
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = colorResource(com.alexyndrik.common.R.color.green)
                                )

                                Text(
                                    text = course.rate,
                                    color = colorResource(com.alexyndrik.common.R.color.white),
                                    style = MaterialTheme.typography.bodySmall
                                )

                            }

                        }

                        Spacer(modifier = Modifier.width(4.dp))

                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = colorResource(com.alexyndrik.common.R.color.glass)
                        ) {

                            val dtf = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.forLanguageTag("ru-RU"))

                            Text(
                                modifier = Modifier.padding(vertical = 4.dp, horizontal = 6.dp),
                                text = LocalDate.parse(course.startDate).format(dtf),
                                color = colorResource(com.alexyndrik.common.R.color.white),
                                style = MaterialTheme.typography.bodySmall
                            )

                        }

                    }

                }

            }

            Column(
                modifier = Modifier.fillMaxWidth().padding(all = 16.dp)
            ) {

                Text(
                    text = course.title,
                    color = colorResource(com.alexyndrik.common.R.color.white),
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = course.text,
                    color = colorResource(com.alexyndrik.common.R.color.white_70),
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row {

                    Text(
                        text = stringResource(com.alexyndrik.thousands_of_courses.R.string.price).format(course.price),
                        color = colorResource(com.alexyndrik.common.R.color.white),
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Row (
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {

                        Text(
                            text = stringResource(R.string.more),
                            color = colorResource(com.alexyndrik.common.R.color.green),
                            style = MaterialTheme.typography.bodySmall
                        )

                        Icon(
                            modifier = Modifier
                                .height(16.dp)
                                .align(Alignment.CenterVertically),
                            imageVector = Icons.Default.ArrowRightAlt,
                            contentDescription = null,
                            tint = colorResource(com.alexyndrik.common.R.color.green)
                        )

                    }

                }

            }

        }

    }
}
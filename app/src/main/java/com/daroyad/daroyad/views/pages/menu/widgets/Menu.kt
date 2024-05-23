package com.daroyad.daroyad.views.pages.menu.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daroyad.daroyad.R

@Composable
fun Menu(
    title: Int,
    icon: Int,
    text: Int,
    isVisible: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            onClick = onClick,
            modifier = modifier.width(
                width = LocalConfiguration.current.screenWidthDp.dp,
            ),
            color = Color(0x00000000),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        20.0.dp,
                        16.0.dp,
                        26.0.dp,
                        16.0.dp,
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(
                            id = icon,
                        ),
                        contentDescription = "bottom_bar_item_active",
                        modifier = modifier.size(30.0.dp),
                        tint = Color(0xFF2D89FF),
                    )
                    Text(
                        text = stringResource(
                            id = title,
                        ),
                        style = TextStyle(
                            color = Color(0xFF000000),
                            fontSize = 16.0.sp,
                            fontWeight = FontWeight.W800,
                            fontFamily = FontFamily(
                                Font(
                                    R.font.iranyekan_regular,
                                ),
                            ),
                        ),
                    )
                }
                Icon(
                    imageVector = ImageVector.vectorResource(
                        id = if (isVisible) R.drawable.menu_item_up else R.drawable.menu_item_down,
                    ),
                    contentDescription = "bottom_bar_item_active",
                    modifier = modifier.size(24.0.dp),
                    tint = Color(0xFF2D89FF),
                )
            }
        }
        if (isVisible) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth(),
                thickness = 1.0.dp,
                color = Color(0xFF2D89FF),
            )
            Text(
                text = stringResource(
                    id = text,
                ),
                modifier = modifier.padding(
                    58.0.dp,
                    16.0.dp,
                    30.0.dp,
                    27.0.dp,
                ),
                style = TextStyle(
                    color = Color(0xFF000000),
                    fontSize = 16.0.sp,
                    fontWeight = FontWeight.W400,
                    fontFamily = FontFamily(
                        Font(
                            R.font.iranyekan_regular,
                        ),
                    ),
                    textAlign = TextAlign.Justify,
                    lineHeight = 24.0.sp,
                ),
            )
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 1.0.dp,
            color = Color(0xFFE3E3E3),
        )
    }
}

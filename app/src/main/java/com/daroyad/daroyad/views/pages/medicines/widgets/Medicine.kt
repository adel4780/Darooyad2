package com.daroyad.daroyad.views.pages.medicines.widgets


import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.daroyad.daroyad.R

@Composable
fun Medicine(
    navController: NavHostController,
    isEdit: Boolean,
    onClick: () -> Unit = {
        navController.navigate("show_medicine")
    },
    isAdd: Boolean = false,
    ) {
    val text = if (isAdd) {
        stringResource(id = R.string.add_medicine)
    } else {
        "استامینوفن"
    }
    Surface(
        onClick = onClick,
        modifier = Modifier.width(
            width = LocalConfiguration.current.screenWidthDp.dp,
        ),
        color = Color(0x00000000),
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 4.dp),
                    text = text,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        fontFamily = FontFamily(
                            Font(
                                R.font.iranyekan_regular,
                            ),
                        ),
                        color = if (isAdd) {
                            Color(0xFFE3E3E3)
                        } else {
                            Color(0xFF000000)
                        },
                    )
                )
                if (isEdit)
                    Icon(
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 8.dp)
                            .size(30.0.dp)
                            .clickable {
                                if (isAdd) {
                                    navController.navigate("medicines_page")
                                }
                            },
                        imageVector = ImageVector.vectorResource(
                            id = if (isAdd) {
                                R.drawable.message_add
                            } else {
                                R.drawable.message_minus
                            }
                        ),
                        contentDescription = "bottom_bar_item_active",
                        tint = if (isAdd) {
                            Color(0xFFE3E3E3)
                        } else {
                            Color(0xFFFF1F01)
                        }

                    )
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 8.0.dp,
                    ),
                thickness = 1.0.dp,
                color = Color(0xFFE3E3E3),
            )
        }
    }
}

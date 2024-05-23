package com.daroyad.daroyad.views.pages.reminder.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daroyad.daroyad.R
import com.daroyad.daroyad.models.entities.Reminder

@Composable
fun ReminderItem(
    reminder: Reminder,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.width(
            width = LocalConfiguration.current.screenWidthDp.dp,
        ),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    20.0.dp,
                    20.0.dp,
                    20.0.dp,
                    15.0.dp,
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = reminder.medicineName,
                style = TextStyle(
                    color = Color(0xFF2D89FF),
                    fontSize = 20.0.sp,
                    fontWeight = FontWeight.W800,
                    fontFamily = FontFamily(
                        Font(
                            R.font.iranyekan_regular,
                        ),
                    ),
                ),
            )
            Icon(
                imageVector = ImageVector.vectorResource(
                    id = R.drawable.reminder,
                ),
                contentDescription = "bottom_bar_item_active",
                modifier = modifier.size(30.0.dp),
                tint = Color(0xFF2D89FF),
            )
        }
        Divider(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxWidth(),
            thickness = 1.0.dp,
            color = Color(0xFF2D89FF),
        )
        ReminderInfo(
            title = R.string.patient_name,
            info = reminder.patientName,
        )
        ReminderInfo(
            title = R.string.time,
            info = reminder.time.toString(),
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.0.dp,
                ),
            thickness = 1.0.dp,
            color = Color(0xFFE3E3E3),
        )
    }
}

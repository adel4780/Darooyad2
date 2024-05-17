package com.daroyad.daroyad.views.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daroyad.daroyad.R

@Composable
fun MyTextField(
    modifier: Modifier,
    text: String,
    editable: Boolean,
    onTextChanged: (String) -> Unit,
    placeholder: String,
    trailingIcon: @Composable (() -> Unit)? = null,
    helperMessage: String
) {
    Column {
        TextField(
            enabled = editable,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                cursorColor = Color(0xFF2D89FF),
                focusedIndicatorColor = Color(0xFF2D89FF),
                unfocusedIndicatorColor = Color(0xFF2D89FF),
                disabledIndicatorColor = Color(0xFF2D89FF),
                focusedTrailingIconColor = Color(0xFF2D89FF),
                unfocusedTrailingIconColor = Color(0xFF2D89FF),
                disabledTrailingIconColor = Color(0xFF2D89FF),
                focusedLabelColor = Color(0xFF2D89FF),
                unfocusedLabelColor = Color(0xFF2D89FF),
                disabledLabelColor = Color(0xFF2D89FF),
            ),
            modifier = modifier,
            value = text,
            textStyle = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(
                    Font(
                        R.font.iranyekan_regular,
                    ),
                ),
                color = Color(0xFF000000),


                ),
            maxLines = 1,
            placeholder = {
                Text(
                    text = placeholder,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily(
                            Font(
                                R.font.iranyekan_regular,
                            ),
                        ),
                        color = Color.Gray
                    ),
                )
            },
            trailingIcon = trailingIcon,
            onValueChange = {
                onTextChanged(it)
            },
        )
        Text(
            text = helperMessage,
            modifier = Modifier.padding(start = 16.dp),
            style = TextStyle(
                color = Color(0xFF2D89FF),
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(
                    Font(
                        R.font.iranyekan_regular,
                    ),
                ),
            ),
        )
    }
}


package com.daroyad.daroyad.views.pages.medicine


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.daroyad.daroyad.views.widgets.MyButton
import com.daroyad.daroyad.views.widgets.MyTextField
import com.daroyad.daroyad.views.widgets.TopAppBar


@Composable
fun MedicinePage(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    isEdit: Boolean = false,
    isShow: Boolean = false,
) {
    val title = if (isShow) {
        stringResource(id=R.string.info_medicine)
    } else {
        if (isEdit) {
            stringResource(id=R.string.edit_medicine)
        } else {
            stringResource(id=R.string.add_medicine)
        }

    }
    Scaffold(
        topBar = {
            TopAppBar(title = title, modifier, navController)
        },
        containerColor = Color(0xffffffff),
    ) {
        var medicineName by remember {
            mutableStateOf(
                if (isEdit || isShow) {
                    "استامینوفن"
                } else {
                    ""
                }
            )
        }
        var period by remember {
            mutableStateOf(
                if (isEdit || isShow) {
                    "1"
                } else {
                    ""
                }
            )
        }
        var data by remember {
            mutableStateOf(
                if (isEdit || isShow) {
                    "۱۴۰۳/۰۱/۰۱"
                } else {
                    ""
                }
            )
        }
        var time by remember {
            mutableStateOf(
                if (isEdit || isShow) {
                    "۰۹:۰۰"
                } else {
                    ""
                }
            )
        }
        var description by remember {
            mutableStateOf(
                if (isEdit || isShow) {
                    "همزمان با داروی دیگری مصرف نشود."
                } else {
                    ""
                }
            )
        }
        val period_time by remember {
            mutableStateOf(
                "ساعت"
            )
        }
        Column(
            modifier
                .padding(it)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f, false)
            ) {
                MyTextField(
                    text = medicineName,
                    onTextChanged = { newText ->
                        medicineName = newText
                    },
                    placeholder = "کوریزان",
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    trailingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(
                                id = R.drawable.external_drive,
                            ),
                            contentDescription = "logo",
                            modifier = modifier.size(30.0.dp),
                        )
                    },
                    helperMessage =  stringResource(id=R.string.medicine_name),
                    editable = !isShow,
                    )
                Spacer(modifier = Modifier.height(20.dp))
                MyTextField(
                    text = period,
                    onTextChanged = { newText ->
                        period = newText
                    },
                    placeholder = "۸",
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    trailingIcon = {
                        Text(
                            text = period_time, style = TextStyle(
                                color = Color(0xff000000),
                                fontSize = 16.sp,
                                fontWeight = FontWeight(600),
                                fontFamily = FontFamily(
                                    Font(
                                        R.font.iranyekan_regular,
                                    ),
                                ),
                            )
                        )
                    },
                    helperMessage =  stringResource(id=R.string.period),
                    editable = !isShow,
                )
                Spacer(modifier = Modifier.height(20.dp))
                MyTextField(
                    text = data,
                    onTextChanged = { newText ->
                        data = newText
                    },
                    placeholder = "۱۴۰۲/۱۲/۰۵",
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    trailingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(
                                id = R.drawable.calendar,
                            ),
                            contentDescription = "logo",
                            modifier = modifier.size(30.0.dp),
                        )
                    },
                    helperMessage =  stringResource(id=R.string.start_date),
                    editable = !isShow,
                )
                Spacer(modifier = Modifier.height(20.dp))
                MyTextField(
                    text = time,
                    onTextChanged = { newText ->
                        time = newText
                    },
                    placeholder = "۱۲:۰۴",
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    trailingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(
                                id = R.drawable.timer_start,
                            ),
                            contentDescription = "logo",
                            modifier = modifier.size(30.0.dp),
                        )
                    },
                    helperMessage =  stringResource(id=R.string.start_time),
                    editable = !isShow,
                )
                Spacer(modifier = Modifier.height(20.dp))
                MyTextField(
                    text = description,
                    onTextChanged = { newText ->
                        description = newText
                    },
                    placeholder =  stringResource(id=R.string.write_description),
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    trailingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(
                                id = R.drawable.document_text,
                            ),
                            contentDescription = "logo",
                            modifier = modifier.size(30.0.dp),
                        )
                    },
                    helperMessage =  stringResource(id=R.string.description),
                    editable = !isShow,
                )
            }
            MyButton(
                onClick = {
                    if (isShow) {
                        navController.navigate("edit_medicine")
                    } else {
                        //todo add or edit medicine
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                text = if (isEdit || isShow) {
                    stringResource(id=R.string.edit)
                } else {
                    stringResource(id=R.string.add)
                }
            )
        }
    }
}

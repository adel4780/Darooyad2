package com.daroyad.daroyad.views.pages.prescription.widgets


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
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
fun PrescriptionPage(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    isEdit: Boolean = false,
    isShow: Boolean = false,
) {
    val title = if (isShow) {
        stringResource(id = R.string.prescription)
    } else {
        if (isEdit) {
            stringResource(id = R.string.edit_prescriptions)
        } else {
            stringResource(id = R.string.add_prescriptions)
        }

    }
    Scaffold(
        topBar = {
            TopAppBar(title = title, modifier, navController)
        },
        containerColor = Color(0xffffffff),
    ) {
        var doctorName by remember {
            mutableStateOf(
                if (isEdit || isShow) {
                    "پدرام شاهینی"
                } else {
                    ""
                }
            )
        }
        var patientName by remember {
            mutableStateOf(
                if (isEdit || isShow) {
                    "شاهرخ شاهینی"
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

        Column(
            modifier
                .padding(it)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                MyTextField(
                    text = doctorName,
                    onTextChanged = { newText ->
                        doctorName = newText
                    },
                    placeholder = "نیما یزدی",
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    trailingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(
                                id = R.drawable.personalcard,
                            ),
                            contentDescription = "logo",
                            modifier = modifier.size(30.0.dp),
                        )
                    },
                    helperMessage = stringResource(id = R.string.doctor_name),
                    editable = !isShow,
                    )
                Spacer(modifier = Modifier.height(40.dp))
                MyTextField(
                    text = patientName,
                    onTextChanged = { newText ->
                        patientName = newText
                    },
                    placeholder = "حسین مولوی",
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    trailingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(
                                id = R.drawable.user,
                            ),
                            contentDescription = "logo",
                            modifier = modifier.size(30.0.dp),
                        )
                    },
                    helperMessage = stringResource(id = R.string.patient_name),
                    editable = !isShow,
                )
                Spacer(modifier = Modifier.height(40.dp))
                MyTextField(
                    text = data,
                    onTextChanged = { newText ->
                        data = newText
                    },
                    placeholder = "۱۴۰۲/۰۲/۰۲",
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
                    helperMessage = stringResource(id = R.string.data),
                    editable = !isShow,
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp),
                    text = stringResource(id = R.string.medicines),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        fontFamily = FontFamily(
                            Font(
                                R.font.iranyekan_regular,
                            ),
                        ),
                        color = Color.Gray
                    ),
                )
                Divider(color = Color.Gray)
                LazyColumn(
                    modifier = Modifier
                        .weight(1f, false).height(370.dp)
                ) {
                    if (isShow || isEdit) {
                        item {
                            Medicine(isEdit = isEdit, navController = navController)
                            Medicine(isEdit = isEdit, navController = navController)
                            Medicine(isEdit = isEdit, navController = navController)
                            Medicine(isEdit = isEdit, navController = navController)
                            Medicine(isEdit = isEdit, navController = navController)
                            Medicine(isEdit = isEdit, navController = navController)
                            Medicine(isEdit = isEdit, navController = navController)
                            Medicine(isEdit = isEdit, navController = navController)
                        }
                    }
                    if (!isShow)
                        item {
                            Medicine(
                                isEdit = isEdit, isAdd = true, navController = navController,
                                onClick = {
                                    navController.navigate("medicines_page")
                                },
                            )
                        }

                }
            }
            MyButton(
                onClick = {
                    if (isShow) {
                        navController.navigate("edit_prescriptions")
                    } else {
                        //todo edit or add a prescription
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                text = if (isEdit || isShow) {
                    stringResource(id = R.string.edit)
                } else {
                    stringResource(id = R.string.add)
                }
            )
        }
    }
}

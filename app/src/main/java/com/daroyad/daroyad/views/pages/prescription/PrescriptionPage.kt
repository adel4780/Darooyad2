package com.daroyad.daroyad.views.pages.prescription


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
import com.daroyad.daroyad.core.nav.GlobalState
import com.daroyad.daroyad.core.nav.PagesRouteEnum
import com.daroyad.daroyad.models.entities.Prescription
import com.daroyad.daroyad.views.pages.prescription.widgets.MedicineItem
import com.daroyad.daroyad.views.widgets.MyButton
import com.daroyad.daroyad.views.widgets.MyTextField
import com.daroyad.daroyad.views.widgets.TopAppBar
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun PrescriptionPage(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val prescription by GlobalState::prescription

    Scaffold(
        topBar = {
            TopAppBar(
                title = stringResource(
                    id = R.string.prescription,
                ),
                modifier,
                navController,
            )
        },
        containerColor = Color(0xffffffff),
    ) {
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
                    text = prescription.doctorName,
                    onTextChanged = {},
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
                    editable = false,
                )
                Spacer(modifier = Modifier.height(40.dp))
                MyTextField(
                    text = prescription.patientName,
                    onTextChanged = {},
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
                    editable = false,
                )
                Spacer(modifier = Modifier.height(40.dp))
                MyTextField(
                    text = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(prescription.date),
                    onTextChanged = {},
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
                    editable = false,
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
                        .weight(1f, false)
                        .height(370.dp)
                ) {
                    items(prescription.medicines.size) { medicine ->
                        MedicineItem(
                            medicine = prescription.medicines[medicine],
                            navController = navController,
                        )
                    }
                }
            }
            MyButton(
                onClick = {
                    navController.navigate(
                        PagesRouteEnum.EDIT_PRESCRIPTION.route
                    )
                },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                text = stringResource(
                    id = R.string.edit,
                ),
            )
        }
    }
}

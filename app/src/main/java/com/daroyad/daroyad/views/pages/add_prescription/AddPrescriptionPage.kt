package com.daroyad.daroyad.views.pages.add_prescription

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.daroyad.daroyad.R
import com.daroyad.daroyad.core.nav.GlobalState
import com.daroyad.daroyad.core.nav.LoadPrescriptions
import com.daroyad.daroyad.models.database.DatabaseProvider
import com.daroyad.daroyad.models.entities.Prescription
import com.daroyad.daroyad.models.factories.PrescriptionViewModelFactory
import com.daroyad.daroyad.view_models.PrescriptionViewModel
import com.daroyad.daroyad.views.pages.add_prescription.widgets.MedicineItem
import com.daroyad.daroyad.views.widgets.MyButton
import com.daroyad.daroyad.views.widgets.MyTextField
import com.daroyad.daroyad.views.widgets.TopAppBar
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Composable function for the Add Prescription Page.
 *
 * @param navController The [NavHostController] for navigation.
 * @param modifier The modifier to be applied to the component.
 */
@Composable
fun AddPrescriptionPage(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val database = DatabaseProvider.getDatabase(context)
    val factory = PrescriptionViewModelFactory(database)
    val prescriptionViewModel: PrescriptionViewModel = viewModel(factory = factory)

    var add by remember {
        mutableStateOf(false)
    }
    var doctorName by remember {
        mutableStateOf("")
    }
    var patientName by remember {
        mutableStateOf("")
    }

    var date by remember { mutableStateOf("") }
    val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())

    if (add) {
        LoadPrescriptions()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = stringResource(
                    id = R.string.add_prescription,
                ),
                modifier,
                navController,
            )
        },
        floatingActionButton = {
            MyButton(
                onClick = {
                    prescriptionViewModel.addPrescription(
                        Prescription(
                            doctorName = doctorName,
                            patientName = patientName,
                            date = dateFormat.parse(date),
                            medicines = GlobalState.prescription.medicines,
                        ),
                    )

                    navController.navigateUp()

                    add = true
                },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                text = stringResource(
                    id = R.string.add,
                ),
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = Color(0xffffffff),
    ) {
        Column(
            modifier
                .padding(it)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
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
                    editable = true,
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
                    editable = true,
                )
                Spacer(modifier = Modifier.height(40.dp))
                MyTextField(
                    text = date,
                    onTextChanged = { newValue ->
                        date = newValue
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
                    editable = true,
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp),
                    text = stringResource(id = R.string.medicines),
                    style = TextStyle(
                        fontSize = 18.sp, fontWeight = FontWeight(700), fontFamily = FontFamily(
                            Font(
                                R.font.iranyekan_regular,
                            ),
                        ), color = Color.Gray
                    ),
                )
                Divider(color = Color.Gray)
                LazyColumn(
                    modifier = Modifier
                        .weight(1f, false)
                        .height(370.dp)
                ) {
                    item {
                        MedicineItem(
                            navController = navController,
                            isAdd = true,
                            isEdit = true,
                        )
                    }
                }
            }
        }
    }
}

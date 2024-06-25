package com.daroyad.daroyad.views.pages.medicines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.daroyad.daroyad.R
import com.daroyad.daroyad.core.nav.GlobalState
import com.daroyad.daroyad.core.nav.LoadMedicines
import com.daroyad.daroyad.views.pages.medicines.widgets.MedicineItem
import com.daroyad.daroyad.views.widgets.MyButton
import com.daroyad.daroyad.views.widgets.TopAppBar

/**
 * Composable function to display the Medicines Page, which shows a list of medicines and provides an option to add new medicines.
 *
 * @param navController The [NavHostController] for navigation.
 * @param modifier The modifier to be applied to the component.
 */
@Composable
fun MedicinesPage(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    LoadMedicines()

    val title = stringResource(id = R.string.medicines)
    Scaffold(
        containerColor = Color(0xffffffff),
        topBar = {
            TopAppBar(
                title = title,
                modifier,
                navController,
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding),
        ) {
            Column(
                modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                if (GlobalState.medicines.isEmpty()) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Text(
                            text = "هنوز دارویی وجود ندارد.",
                            style = TextStyle(
                                color = Color(0xFF000000),
                                fontSize = 16.0.sp,
                                fontWeight = FontWeight.W700,
                                fontFamily = FontFamily(
                                    Font(
                                        R.font.iranyekan_regular,
                                    ),
                                ),
                            ),
                        )
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.weight(1f, false),
                    ) {
                        items(GlobalState.medicines.size) { index ->
                            MedicineItem(
                                medicine = GlobalState.medicines[index],
                                navController = navController,
                                isEdit = false,
                                isAdd = false,
                            )
                        }
                    }
                }
                MyButton(
                    onClick = {
                        navController.navigate("add_medicine")
                    },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    text = stringResource(id = R.string.add)
                )
            }
        }
    }
}

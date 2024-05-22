package com.daroyad.daroyad.views.pages.medicines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.daroyad.daroyad.R
import com.daroyad.daroyad.views.pages.medicines.widgets.Medicine
import com.daroyad.daroyad.views.widgets.MyButton
import com.daroyad.daroyad.views.widgets.TopAppBar

@Composable
fun MedicinesPage(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val title =  stringResource(id= R.string.medicines)
    Scaffold(
        containerColor = Color(0xffffffff),
        topBar = {
            TopAppBar(title = title, modifier, navController)
        },

        ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding),
        ) {
            Column(
                modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                LazyColumn(
                    modifier = Modifier.weight(1f, false),
                ) {
                    items(8) { index ->
                        Medicine(
                            navController = navController,
                            isEdit = false,
                            isAdd = false,
                        )
                    }
                }
                MyButton(
                    onClick = {
                            navController.navigate("add_medicine")
                    },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    text =
                    stringResource(id=R.string.add)
                )
        }
        }
    }
}
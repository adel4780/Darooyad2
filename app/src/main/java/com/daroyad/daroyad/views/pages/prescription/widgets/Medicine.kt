package com.daroyad.daroyad.views.pages.prescription.widgets


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.daroyad.daroyad.models.entities.Medicine

@Composable
fun MedicineItem(
    medicine: Medicine,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
//    val text = if (isAdd) {
//        stringResource(id = R.string.add_medicine)
//    } else {
//        "استامینوفن"
//    }
//    Surface(
//        onClick = onClick,
//        modifier = modifier.width(
//            width = LocalConfiguration.current.screenWidthDp.dp,
//        ),
//        color = Color(0x00000000),
//    ) {
//        Column(
//            verticalArrangement = Arrangement.SpaceBetween,
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(
//                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 4.dp),
//                    text = text,
//                    style = TextStyle(
//                        fontSize = 18.sp,
//                        fontWeight = FontWeight(700),
//                        fontFamily = FontFamily(
//                            Font(
//                                R.font.iranyekan_regular,
//                            ),
//                        ),
//                        color = if (isAdd) {
//                            Color(0xFFE3E3E3)
//                        } else {
//                            Color(0xFF000000)
//                        },
//                    )
//                )
//                if (isEdit)
//                    Icon(
//                        modifier = Modifier
//                            .padding(horizontal = 20.dp, vertical = 8.dp)
//                            .size(30.0.dp)
//                            .clickable {
//                                if (isAdd) {
//                                    navController.navigate("medicines_page")
//                                }
//                            },
//                        imageVector = ImageVector.vectorResource(
//                            id = if (isAdd) {
//                                R.drawable.message_add
//                            } else {
//                                R.drawable.message_minus
//                            }
//                        ),
//                        contentDescription = "bottom_bar_item_active",
//                        tint = if (isAdd) {
//                            Color(0xFFE3E3E3)
//                        } else {
//                            Color(0xFFFF1F01)
//                        }
//
//                    )
//            }
//            Divider(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(
//                        top = 8.0.dp,
//                    ),
//                thickness = 1.0.dp,
//                color = Color(0xFFE3E3E3),
//            )
//        }
//    }
}

package com.example.profilecardlayout.compose.apps.tripCalculatorApp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.profilecardlayout.R
import com.example.profilecardlayout.compose.DataEntry
import com.example.profilecardlayout.compose.apps.tripCalculatorApp.AppRoutes.TIME

@Composable
fun DistanceScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    DataEntry(
        text = R.string.enter_the_total_distance,
        fieldLabel = R.string.distance_in_kilometers,
        modifier = modifier
    ) { distanceField ->

        val distance = distanceField.toFloat()
        navController.navigate("$TIME/$distance")

    }

}

@Preview(showBackground = true)
@Composable
private fun DistanceScreenPreview() {
    DistanceScreen(rememberNavController())
}
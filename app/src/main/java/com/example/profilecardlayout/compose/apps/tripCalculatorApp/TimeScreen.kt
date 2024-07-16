package com.example.profilecardlayout.compose.apps.tripCalculatorApp


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.profilecardlayout.R
import com.example.profilecardlayout.compose.DataEntry
import com.example.profilecardlayout.compose.apps.tripCalculatorApp.AppRoutes.TRAFFIC_CALCULATOR

@Composable
fun TimeScreen(
    navController: NavController,
    km: Float,
    modifier: Modifier = Modifier
) {

    DataEntry(
        text = R.string.enter_the_total_time,
        fieldLabel = R.string.time_in_minutes,
        isTimeInput = true,
        modifier = modifier
    ) { timeField ->

        val time = timeField.toInt()
        navController.navigate("$TRAFFIC_CALCULATOR/$km/$time")

    }

}

@Preview(showBackground = true)
@Composable
private fun DistanceScreenPreview() {
    TimeScreen(rememberNavController(), 0.2f)
}
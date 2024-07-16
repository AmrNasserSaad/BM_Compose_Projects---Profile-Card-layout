package com.example.profilecardlayout.compose.apps.tripCalculatorApp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.profilecardlayout.compose.apps.tripCalculatorApp.AppRoutes.DISTANCE
import com.example.profilecardlayout.compose.apps.tripCalculatorApp.AppRoutes.START
import com.example.profilecardlayout.compose.apps.tripCalculatorApp.AppRoutes.TIME
import com.example.profilecardlayout.compose.apps.tripCalculatorApp.AppRoutes.TRAFFIC_CALCULATOR
import com.example.profilecardlayout.compose.apps.tripCalculatorApp.AppRoutes.TRIP_PRICE

object AppRoutes {
    const val START = "start"
    const val DISTANCE = "distance"
    const val TIME = "time"
    const val TRAFFIC_CALCULATOR = "traffic_calculator"
    const val TRIP_PRICE = "trip_price"
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = START) {

        composable(route = START) { FirstScreen(navController) }
        composable(route = DISTANCE) { DistanceScreen(navController) }

        composable(
            route = "$TIME/{km}",
            arguments = listOf(navArgument("km") { type = NavType.FloatType })
        ) {
            val km = it.arguments?.getFloat("km")!!
            TimeScreen(navController, km)
        }

        composable(
            route = "$TRAFFIC_CALCULATOR/{km}/{mins}",
            arguments = listOf(
                navArgument("km") { type = NavType.FloatType },
                navArgument("mins") { type = NavType.IntType }
            )
        ) {
            val km = it.arguments?.getFloat("km")!!
            val mins = it.arguments?.getInt("mins")!!
            TrafficCalculator(navController, km, mins)
        }
        composable(
            route = "$TRIP_PRICE/{km}/{trip_time}/{traffic}",
            arguments = listOf(
                navArgument("km") { type = NavType.FloatType },
                navArgument("trip_time") { type = NavType.IntType },
                navArgument("traffic") { type = NavType.FloatType }
            )
        ) {
            val km = it.arguments?.getFloat("km")!!
            val time = it.arguments?.getInt("trip_time")!!
            val traffic = it.arguments?.getFloat("traffic")!!
            TripPriceScreen(navController, km = km, time = time, traffic = traffic)
        }



    }
}
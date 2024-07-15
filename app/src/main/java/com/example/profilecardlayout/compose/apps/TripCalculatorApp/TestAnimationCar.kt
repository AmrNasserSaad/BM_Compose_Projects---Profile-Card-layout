package com.example.profilecardlayout.compose.apps.TripCalculatorApp

import androidx.compose.animation.core.animateOffset
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StartScreen(modifier: Modifier = Modifier) {

    var isAnimated by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = isAnimated, label = "transaction")
    val screenWidth =
        LocalConfiguration.current.screenWidthDp.toFloat()  // give me screen width Number
    val context = LocalContext.current
    val animationDuration = 300


    val carOffset by transition.animateOffset(
        transitionSpec = { tween(animationDuration) },
        label = "car"
    ) { animated ->
        if (animated) Offset(screenWidth / 2, 0f) else Offset(screenWidth, 0f)
    }
    val roadOffset by transition.animateOffset(
        transitionSpec = { tween(animationDuration) },
        label = "road"
    ) { animated ->
        if (animated) Offset(0f, 0f) else Offset(-300f, 0f)
    }

    LaunchedEffect(Unit) {
        isAnimated = true
    }


}

@Preview(showBackground = true)
@Composable
private fun StartScreenPreview() {
    StartScreen()
}
package com.example.profilecardlayout.compose.apps.TripCalculatorApp

import android.media.MediaPlayer
import androidx.compose.animation.core.animateOffset
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilecardlayout.R
import com.example.profilecardlayout.ui.theme.DarkBlue

@Composable
fun FirstScreen(modifier: Modifier = Modifier) {

    // animations
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

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.road),
            contentDescription = stringResource(id = R.string.road),
            modifier = modifier
                .size(300.dp)
                .offset(roadOffset.x.dp, roadOffset.y.dp)

        )
        Button(
            onClick = {
                MediaPlayer.create(context, R.raw.car_horn).start()
            },
            colors = ButtonDefaults.buttonColors(DarkBlue),
            modifier = modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = stringResource(id = R.string.start))
        }
        Image(
            painter = painterResource(id = R.drawable.car),
            contentDescription = stringResource(id = R.string.car),
            modifier = modifier
                .size(300.dp)
                .offset(carOffset.x.dp, carOffset.y.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun FirstScreenPreview() {
    FirstScreen()
}
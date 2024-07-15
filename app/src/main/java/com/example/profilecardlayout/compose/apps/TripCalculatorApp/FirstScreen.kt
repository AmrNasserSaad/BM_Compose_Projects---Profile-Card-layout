package com.example.profilecardlayout.compose.apps.TripCalculatorApp

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilecardlayout.R
import com.example.profilecardlayout.ui.theme.DarkBlue

@Composable
fun FirstScreen(modifier: Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp // give me screen width Number
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.road),
            contentDescription = stringResource(id = R.string.road),
            modifier = modifier.size(300.dp)
        )
        Button(
            onClick = {},
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
                .offset(screenWidth.dp / 2)
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun FirstScreenPreview() {
    FirstScreen()
}
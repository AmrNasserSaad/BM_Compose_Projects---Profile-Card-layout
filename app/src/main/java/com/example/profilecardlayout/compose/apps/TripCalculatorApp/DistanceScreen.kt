package com.example.profilecardlayout.compose.apps.TripCalculatorApp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilecardlayout.R
import com.example.profilecardlayout.ui.theme.DarkBlue

@Composable
fun DistanceScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = stringResource(id = R.string.enter_the_total_distance))

        var distanceField by remember { mutableStateOf("0") }
        OutlinedTextField(
            value = distanceField,
            onValueChange = { distanceField = it },
            label = {
                Text(
                    text = stringResource(id = R.string.distance_in_kilometers),
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = modifier.padding(32.dp)
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(DarkBlue),
            modifier = modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = stringResource(id = R.string.next))
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun DistanceScreenPreview() {
    DistanceScreen()
}
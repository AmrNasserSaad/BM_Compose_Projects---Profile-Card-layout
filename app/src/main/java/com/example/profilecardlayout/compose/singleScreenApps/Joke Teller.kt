package com.example.profilecardlayout.compose.singleScreenApps

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getString
import com.example.profilecardlayout.R
import com.example.profilecardlayout.ui.theme.Blue
import com.example.profilecardlayout.ui.theme.DarkBlue
import com.example.profilecardlayout.ui.theme.LightBlue
import com.example.profilecardlayout.ui.theme.LightGreen
import com.example.profilecardlayout.ui.theme.LightRed

@Composable
fun JokeWithTextAndButton(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            border = BorderStroke(
                width = 2.dp,
                brush = Brush.horizontalGradient(
                    listOf(LightRed, LightGreen)
                )
            ),
            colors = CardDefaults.cardColors(containerColor = LightBlue),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.8f)
        ) {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val jokes = listOf(
                    R.string.joke_1,
                    R.string.joke_2,
                    R.string.joke_3,
                    R.string.joke_4
                )

                var randomJoke by remember { mutableIntStateOf(R.string.jokes_will_appear_here) }
                Text(
                    text = stringResource(id = randomJoke),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        brush = Brush.horizontalGradient(
                            listOf(Blue, DarkBlue)
                        )
                    )

                )
                TextButton(
                    onClick = {
                        randomJoke = jokes.random()
                        Toast.makeText(
                            context,
                            getString(context, R.string.ha_ha),
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    modifier = modifier.padding(top = 32.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(LightRed, LightGreen)
                        )
                    ),
                ) {
                    Text(
                        text = stringResource(id = R.string.ha_ha_me),
                        style = TextStyle(
                            brush = Brush.horizontalGradient(
                                listOf(Blue, DarkBlue)
                            )
                        )
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun JokeWithTextAndButtonPreview() {
    JokeWithTextAndButton()
}
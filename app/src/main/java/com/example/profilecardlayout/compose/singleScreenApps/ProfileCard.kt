package com.example.profilecardlayout.compose.singleScreenApps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilecardlayout.R

@Composable
fun ProfileCard(
    name: String,
    job: String,
    email: String,
    phone: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.profile_bg),
                contentScale = ContentScale.Crop,
                alpha = 0.4f

            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "PP",
            modifier = Modifier
                .size(150.dp)
                .padding(8.dp)
                .border(
                    width = 4.dp,
                    color = Color.Black,
                    shape = CircleShape
                )
                .background(Color.DarkGray, shape = CircleShape)
                .clip(CircleShape)

        )

        Text(text = name, fontSize = 46.sp)
        Text(
            text = job,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp)
        )
        Row(modifier = Modifier.padding(top = 28.dp)) {
            Text(
                text = email,
                modifier = Modifier.padding(end = 16.dp),
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = phone,
                textDecoration = TextDecoration.Underline
            )

        }

    }
}

@Preview(showBackground = true, locale = "ar")
@Composable
fun ProfileCardPreview() {
    ProfileCard(
        name = stringResource(R.string.amr_nasser),
        job = stringResource(R.string.android_developer),
        email = stringResource(R.string.amrnasser_gmail_com),
        phone = stringResource(R.string._201025573949)
    )
}
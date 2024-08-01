package com.example.profilecardlayout.compose.Speedo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilecardlayout.R
import com.example.profilecardlayout.compose.Speedo.components.OtpTextField
import com.example.profilecardlayout.ui.theme.RedP300

@Composable
fun OTP(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color(0xFFFFEAEE)
                    )
                )
            )
            .padding(horizontal = 16.dp, vertical = 36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.vector),
                contentDescription = "vector",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Bank Card OTP", fontSize = 20.sp,
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),

                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(45.dp))
        Text(
            text = "Enter the digits verification code send to Email@gmail.com",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        var otpValue by remember {
            mutableStateOf("")
        }


        OtpTextField(
            otpText = otpValue,
            onOtpTextChange = { value, otpInputFilled ->
                otpValue = value
            }
        )
        Spacer(modifier = Modifier.height(48.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){

            Text(
                text = "Don’t receive OTP?",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontSize = 16.sp
            )
            Text(
                text = "  Resend OTP",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color = RedP300,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.padding(150.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = RedP300),
            shape = RoundedCornerShape(size = 8.dp)
        ) {
            Text(
                text = "Connect another account", fontSize = 16.sp
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun OTPPreview() {
    OTP()
}


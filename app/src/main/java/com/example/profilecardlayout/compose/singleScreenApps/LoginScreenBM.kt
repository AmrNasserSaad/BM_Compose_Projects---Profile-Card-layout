package com.example.profilecardlayout.compose.singleScreenApps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilecardlayout.R
import com.example.profilecardlayout.ui.theme.DarkRed
import com.example.profilecardlayout.ui.theme.LightGray
import com.example.profilecardlayout.ui.theme.NiceRed

@Composable
fun LoginScreenBM(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 64.dp, start = 28.dp, end = 28.dp)
    ) {

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.bm_icon),
                contentDescription = stringResource(R.string.bm_icon)
            )
            Text(
                text = stringResource(id = R.string.en),
                color = DarkRed,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        var userNameTextField by remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            value = userNameTextField,
            onValueChange = { userNameTextField = it },
            label = {
                Text(
                    text = stringResource(id = R.string.user_name),
                    color = LightGray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            },
        )

        var passwordTextField by remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            value = passwordTextField,
            onValueChange = { passwordTextField = it },
            label = {
                Text(
                    text = stringResource(id = R.string.password),
                    color = LightGray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            trailingIcon = {
                Image(
                    painter = painterResource(
                        id = R.drawable.hide_svgrepo_com
                    ),
                    contentDescription = ""
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        val isButtonEnabled = userNameTextField.isNotBlank() && passwordTextField.isNotBlank()
        val buttonColor = if (isButtonEnabled) DarkRed else NiceRed

        Text(
            modifier = modifier
                .padding(top = 16.dp)
                .alpha(0.6f),
            text = stringResource(id = R.string.forget_username_password),
            textDecoration = TextDecoration.Underline,
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
                .height(42.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
            shape = RoundedCornerShape(size = 8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.login),
            )
        }

        Row(modifier = modifier.padding(top = 16.dp, bottom = 64.dp)) {
            Text(text = stringResource(id = R.string.need_help))
            Text(
                text = stringResource(id = R.string.contact_us),
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                color = DarkRed, modifier = modifier.padding(start = 4.dp)
            )
        }
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(LightGray)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            ImageWithText(
                modifier,
                stringResource(id = R.string.our_products),
                R.drawable.our_products
            )
            ImageWithText(
                modifier,
                stringResource(id = R.string.exchange_rate),
                R.drawable.exchange_rate
            )
            ImageWithText(
                modifier,
                stringResource(id = R.string.security_tips),
                R.drawable.security_tips
            )
            ImageWithText(
                modifier,
                stringResource(id = R.string.nearest_branch_or_atm),
                R.drawable.nearest_branch_or_atm
            )

        }

    }
}

@Composable
private fun ImageWithText(modifier: Modifier, text: String, imgIcon: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(top = 24.dp, start = 4.dp, end = 4.dp)
    ) {
        Image(
            painter = painterResource(id = imgIcon),
            contentDescription = "",
            modifier = modifier.size(64.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = text,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenBMPreview() {
    LoginScreenBM()
}

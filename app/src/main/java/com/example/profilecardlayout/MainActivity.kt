package com.example.profilecardlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.profilecardlayout.compose.singleScreenApps.JokeWithTextAndButton
import com.example.profilecardlayout.ui.theme.ProfileCardLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileCardLayoutTheme {
                // trip app
                //AppNavHost()

                // Jokes App
                //JokeWithTextAndButton()

                //Profile Card
                //  ProfileCard(
                //  name = "Amr Nasser",
                //  job = "Android Developer",
                //  email = "amrnasser@gmail.com",
                //  phone = "+201025573949"
                //  )

                //LoginScreenBM
                //LoginScreenBM()

                // animals list app
                // AnimalsList(animals = DataSource().getAnimalsData())
            }
        }
    }
}
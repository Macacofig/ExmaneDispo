package com.ucb.exmanedispo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ucb.exmanedispo.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint
import com.connectsdk.discovery.DiscoveryManager

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Ucbtest)
        super.onCreate(savedInstanceState)
        DiscoveryManager.init(applicationContext)
        enableEdgeToEdge()
        setContent {
            AppNavigation()

        }
    }
}




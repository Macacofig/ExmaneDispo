package com.ucb.exmanedispo.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ucb.exmanedispo.mapa.MapaUI
import com.ucb.exmanedispo.planes.HomePlan10UI
import com.ucb.exmanedispo.planes.HomePlan5UI
import com.ucb.exmanedispo.planes.HomePlan8UI


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HomePlan8Screen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    )
    {
        composable(Screen.HomePlan8Screen.route)
        {
           HomePlan8UI(
               onDereClick = {
                   navController.navigate(Screen.HomePlan10Screen.route)
               },
               onIzqClick = {
                   navController.navigate(Screen.HomePlan5Screen.route)
               },
               onMapaClick = {
                   navController.navigate(Screen.MapaScreen.createRoute("Plan FLEX 8"))
               }
           )
        }
        composable(Screen.HomePlan5Screen.route)
        {
            HomePlan5UI(
                onDereClick = {
                    navController.navigate(Screen.HomePlan8Screen.route)
                },
                onIzqClick = {
                    navController.navigate(Screen.HomePlan10Screen.route)
                },
                onMapaClick = {
                    navController.navigate(Screen.MapaScreen.createRoute("Plan FLEX 5"))
                }
            )
        }

        composable(Screen.HomePlan10Screen.route)
        {
            HomePlan10UI(
                onDereClick = {
                    navController.navigate(Screen.HomePlan5Screen.route)
                },
                onIzqClick = {
                    navController.navigate(Screen.HomePlan8Screen.route)
                },
                onMapaClick = {
                    navController.navigate(Screen.MapaScreen.createRoute("Plan FLEX 10"))
                }
            )
        }

        composable( route = "mapa/{plan}")
        { backStackEntry ->
            val plan = backStackEntry.arguments?.getString("plan") ?: "Plan Desconocido"
            MapaUI(
                onBackClick = { navController.popBackStack() },
                plan = plan
            )
        }


    }
}
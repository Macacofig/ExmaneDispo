package com.ucb.exmanedispo.navigation

sealed class Screen (val route: String){
    object HomePlan5Screen: Screen("plan5")
    object HomePlan8Screen: Screen("plan8")
    object HomePlan10Screen: Screen("plan10")
    object MapaScreen: Screen("mapa/{plan}")
    {
        fun createRoute(plan: String) = "mapa/$plan"
    }
}
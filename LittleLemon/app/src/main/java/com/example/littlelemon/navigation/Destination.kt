package com.example.littlelemon.navigation

interface Destination {
    val route: String
}

object Home: Destination{
    override val route: String = "Home"
}

object Profile: Destination{
    override val route: String = "Profile"
}

object OnBoarding: Destination{
    override val route: String = "OnBoarding"
}
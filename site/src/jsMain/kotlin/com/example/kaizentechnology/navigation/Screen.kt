package com.example.kaizentechnology.navigation

sealed class Screen(val route: String) {
    data object HomePage: Screen(route = "/")
    data object ProductsPage: Screen(route = "/products")
    data object ServicesPage: Screen(route = "/services")
    data object AboutUsPage: Screen(route = "/about-us")
    data object ContactUsPage: Screen(route = "/contact-us")
    data object PrivacyPolicyPage: Screen(route = "/privacy-policy")

}
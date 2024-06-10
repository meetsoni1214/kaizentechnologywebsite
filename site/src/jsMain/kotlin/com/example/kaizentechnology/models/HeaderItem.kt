package com.example.kaizentechnology.models

import com.example.kaizentechnology.navigation.Screen

enum class HeaderItem(
    val itemName: String,
    val link: String
) {
    Home(
        itemName = "Home",
        link = Screen.HomePage.route
    ),
    Products(
    itemName = "Products",
    link = Screen.ProductsPage.route
    ),
    Services(
    itemName = "Services",
    link = Screen.ServicesPage.route
    ),
    AboutUs(
        itemName = "About Us",
        link = Screen.AboutUsPage.route
    ),
    ContactUs(
    itemName = "Contact Us",
    link = Screen.ContactUsPage.route
    )

}
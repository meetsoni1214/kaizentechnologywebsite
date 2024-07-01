package com.example.kaizentechnology.models

import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.Res
import com.varabyte.kobweb.compose.ui.graphics.Color

enum class Product(
    val logo: String,
    val productName: String,
    val productTagline: String,
    val productDesc: String,
    val productColor: Color.Rgb,
    val link: String
) {
    Kaizen(
        logo = Res.Image.kaizen,
        productName = "Kaizen Property Group",
        productDesc = "\"Kaizen\" is a Japanese word, it means continuous improvement of working practices. The Kaizen property group is a non-profit organization working for real estate consultants. Our aim is to improve working methods of real estate consultants in India. If you are a real estate consultant and you are looking to increase your profitability and expand your business or increase your productivity then come and join Kaizen property group. Let’s work with technology, beyond the traditional working method of real estate agents.",
        productTagline = "Connecting The Unconnected",
        productColor = JsTheme.KaizenColor.rgb,
        link = "https://kaizenproperty.org/"
    ),
    Techno(
        logo = Res.Image.techno,
        productName = "Techno Property Solution",
        productDesc = "\"Techno\" is a Greek word that means art or skill, often used in the context of technology. With the help of technology, we strive to provide a hassle-free service experience for real estate consultants. We offer a vast, verified database of active properties owned by individuals. This database will help grow your property portfolio. Our administrative staff updates new properties daily and refreshes existing property data periodically. This allows real estate consultants to save time on daily property management tasks.",
        productTagline = "Let’s Work With Technology",
        productColor = JsTheme.TechnoColor.rgb,
        link = "https://www.technoproperty.in/"
    ),
    Greenrooms(
        logo = Res.Image.greenrooms,
        productName = "Greenrooms",
        productDesc = "Greenrooms is an organization that acts as a bridge between paying guests, hostels, studio apartments, corporate PG owners, and accommodation seekers. Our focus is on becoming a one-stop shop for all accommodation needs. Finding suitable accommodation in a metro city is a challenging task for working professionals and bachelors/students. Our aim is to make the room search simple and hassle-free, without any brokerage fees.",
        productTagline = "Connecting The Unconnected",
        productColor = JsTheme.GreenroomsColor.rgb,
        link = "https://greenrooms.in/"
    ),
    PIG(
        logo = Res.Image.pig,
        productName = "Property Idea Group",
        productDesc = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque  penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu pretium quis, sem Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque  penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu pretium quis, sem",
        productTagline = "Connecting The Unconnected",
        productColor = JsTheme.PIGColor.rgb,
        link = "https://kaizenproperty.org/"
    )

}
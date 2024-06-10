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
        productDesc = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque  penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu pretium quis, sem Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque  penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu pretium quis, sem",
        productTagline = "Connecting The Unconnected",
        productColor = JsTheme.KaizenColor.rgb,
        link = "https://kaizenproperty.org/"
    ),
    Techno(
        logo = Res.Image.techno,
        productName = "Techno Property Solution",
        productDesc = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque  penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu pretium quis, sem Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque  penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu pretium quis, sem",
        productTagline = "Let’s Work With Technology",
        productColor = JsTheme.TechnoColor.rgb,
        link = "https://www.technoproperty.in/"
    ),
    Greenrooms(
        logo = Res.Image.greenrooms,
        productName = "Greenrooms",
        productDesc = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque  penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu pretium quis, sem Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque  penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu pretium quis, sem",
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
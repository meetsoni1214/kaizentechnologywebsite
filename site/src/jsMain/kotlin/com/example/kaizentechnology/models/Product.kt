package com.example.kaizentechnology.models

import com.example.kaizentechnology.util.Res

enum class Product(
    val logo: String,
    val productName: String,
    val link: String
) {
    Kaizen(
        logo = Res.Image.kaizen,
        productName = "Kaizen Property Group",
        link = "https://kaizenproperty.org/"
    ),
    Techno(
        logo = Res.Image.techno,
        productName = "Techno Property Solution",
        link = "https://www.technoproperty.in/"
    ),
   Greenrooms(
       logo = Res.Image.greenrooms,
       productName = "Greenrooms",
       link = "https://greenrooms.in/"
   ),
    PIG(
    logo = Res.Image.pig,
    productName = "Property Idea Group",
    link = "https://kaizenproperty.org/"
    )

}
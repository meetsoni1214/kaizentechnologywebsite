package com.example.kaizentechnology.models

import kotlinx.serialization.Serializable

@Serializable
data class Inquiry(
    val _id: String = "",
    val date: Double = 0.0,
    val firstName: String = "",
    val lastName: String = "",
    val mobile: String = "",
    val email: String = "",
    val message: String = ""
)

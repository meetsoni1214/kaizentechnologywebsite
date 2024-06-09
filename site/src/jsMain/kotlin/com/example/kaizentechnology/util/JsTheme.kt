package com.example.kaizentechnology.util

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.rgb

enum class JsTheme(
    val hex: String,
    val rgb: Color.Rgb
) {
    Primary(
        hex = "#007CC3",
        rgb = rgb(r = 0, g = 124, b = 194)
    ),
    Secondary(
        hex = "#005484",
        rgb = rgb(r = 0, g = 84, b = 132)
    ),
    FooterColor(
        hex = "#3E3E3E",
        rgb = rgb(r = 62, g = 62, b = 62)
    ),
    HalfBlack(
        hex = "#000000",
        rgb = Color.rgba(r = 0, g = 0, b = 0, a = 0.5f)
    ),
}
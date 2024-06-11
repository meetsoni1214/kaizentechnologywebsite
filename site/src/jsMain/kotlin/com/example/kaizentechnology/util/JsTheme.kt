package com.example.kaizentechnology.util

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.rgb
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.rgba

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
    KaizenColor(
        hex = "#0A7CBF",
        rgb = rgb(r = 10, g = 124, b = 191)
    ),
    TechnoColor(
        hex = "#25A9E0",
        rgb = rgb(r = 37, g = 169, b = 224)
    ),
    GreenroomsColor(
        hex = "#15903C",
        rgb = rgb(r = 21, g = 144, b = 60)
    ),
    PIGColor(
        hex = "#E77817",
        rgb = rgb(r = 231, g = 120, b = 23)
    ),
    LightGray(
        hex = "#D9D9D9",
        rgb = rgba(r = 217, g = 217, b = 217, a = 0.4f)
    )
}
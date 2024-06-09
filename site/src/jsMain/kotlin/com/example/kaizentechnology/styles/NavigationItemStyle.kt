package com.example.kaizentechnology.styles


import com.example.kaizentechnology.util.JsTheme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.anyLink
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.ms

val NavigationItemStyle = CssStyle {
    base {
        Modifier
            .color(Colors.White)
            .textDecorationLine(TextDecorationLine.None)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 300.ms))
    }
    anyLink {
        Modifier.color(Colors.White)
    }
    hover {
        Modifier
            .textDecorationLine(TextDecorationLine.Underline)
            .color(JsTheme.Primary.rgb)
    }
}

val NavigationItemStyleSM = CssStyle {
    base {
        Modifier
            .color(Colors.Black)
            .textDecorationLine(TextDecorationLine.None)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 300.ms))
    }
    anyLink {
        Modifier.color(Colors.Black)
    }
    hover {
        Modifier
            .textDecorationLine(TextDecorationLine.Underline)
            .color(JsTheme.Primary.rgb)
    }
}


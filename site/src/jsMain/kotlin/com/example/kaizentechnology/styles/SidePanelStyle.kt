package com.example.kaizentechnology.styles

import com.example.kaizentechnology.util.Id
import com.example.kaizentechnology.util.JsTheme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.ms

val SidePanelNavigationItemStyle = CssStyle {
    cssRule(" > #${Id.svgParent} > #${Id.vectorIcon}") {
        Modifier
            .transition(CSSTransition(property = TransitionProperty.All, duration = 300.ms))
            .styleModifier {
                property("stroke", Colors.Black)
            }
    }
    cssRule(":hover > #${Id.svgParent} > #${Id.vectorIcon}") {
        Modifier.styleModifier {
            property("stroke", JsTheme.Primary.hex)
        }
    }
    cssRule(" > #${Id.navigationText}") {
        Modifier
            .transition(CSSTransition(property = TransitionProperty.All, duration = 300.ms))
            .color(Colors.Black)
    }
    cssRule(":hover > #${Id.navigationText}") {
        Modifier.color(JsTheme.Primary.rgb)
    }
}
package com.example.kaizentechnology.styles

import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.noBorder
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val DynamicServiceChipStyle = CssStyle{
    base {
        Modifier
            .noBorder()
            .transition(CSSTransition(property = TransitionProperty.All, duration = 300.ms))
    }
    hover {
        Modifier
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = JsTheme.Primary.rgb
            )
    }
}
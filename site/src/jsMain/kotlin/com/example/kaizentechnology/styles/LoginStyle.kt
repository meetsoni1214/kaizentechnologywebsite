package com.example.kaizentechnology.styles

import com.example.kaizentechnology.util.JsTheme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.focus
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val LoginInputStyle = CssStyle {
    base {
        Modifier.border(
            width = 2.px,
            style = LineStyle.Solid,
            color = Colors.Transparent
        )
            .transition(CSSTransition(property = "border", duration = 300.ms))
    }
    focus {
        Modifier.border(
            width = 2.px,
            style = LineStyle.Solid,
            color = JsTheme.Primary.rgb
        )
    }
}
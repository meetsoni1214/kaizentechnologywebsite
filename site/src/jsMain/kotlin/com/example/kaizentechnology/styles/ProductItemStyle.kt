package com.example.kaizentechnology.styles

import androidx.compose.runtime.Composable
import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.noBorder
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

val ProductItemStyle = CssStyle {
    base {
        Modifier
            .scale(100.percent)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 100.ms))
    }
    hover {
        Modifier
            .boxShadow(
                offsetX = 4.px,
                offsetY = 4.px,
                blurRadius = 4.px,
                spreadRadius = 0.px,
                color = rgba(0, 84, 132, 0.5)
            )
            .scale(102.percent)
    }
}

val ProductItemButtonStyle = CssStyle {
    base {
        Modifier
            .noBorder()
            .backgroundColor(JsTheme.Primary.rgb)
            .color(Colors.White)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 100.ms))
    }
    hover {
        Modifier
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = JsTheme.Primary.rgb
            )
            .color(JsTheme.Primary.rgb)
            .backgroundColor(Colors.White)
    }
}


//val ProductItemButtonTextStyle = CssStyle {
//    base {
//        Modifier
//
//            .transition(CSSTransition(property = TransitionProperty.All, duration = 100.ms))
//    }
//    hover {
//        Modifier
//
//    }
//}
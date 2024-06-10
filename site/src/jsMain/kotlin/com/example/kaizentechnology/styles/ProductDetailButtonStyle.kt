package com.example.kaizentechnology.styles

import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.noBorder
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px


val KaizenButtonStyle = CssStyle {
    base {
        Modifier
            .noBorder()
            .backgroundColor(JsTheme.KaizenColor.rgb)
            .color(Colors.White)
            .borderRadius(0.percent)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 20.ms))
    }
    hover {
        Modifier
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = Colors.Black.copy(alpha = 60)
            )
            .color(Colors.Black)
            .borderRadius(100.px)
            .backgroundColor(Colors.White)
    }
}


val TechnoButtonStyle = CssStyle {
    base {
        Modifier
            .noBorder()
            .backgroundColor(JsTheme.TechnoColor.rgb)
            .color(Colors.White)
            .borderRadius(0.percent)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 20.ms))
    }
    hover {
        Modifier
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = Colors.Black.copy(alpha = 60)
            )
            .color(Colors.Black)
            .borderRadius(100.px)
            .backgroundColor(Colors.White)
    }
}


val GreenroomsButtonStyle = CssStyle {
    base {
        Modifier
            .noBorder()
            .backgroundColor(JsTheme.GreenroomsColor.rgb)
            .color(Colors.White)
            .borderRadius(0.percent)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 20.ms))
    }
    hover {
        Modifier
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = Colors.Black.copy(alpha = 60)
            )
            .color(Colors.Black)
            .borderRadius(100.px)
            .backgroundColor(Colors.White)
    }
}


val PIGButtonStyle = CssStyle {
    base {
        Modifier
            .noBorder()
            .backgroundColor(JsTheme.PIGColor.rgb)
            .color(Colors.White)
            .borderRadius(0.percent)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 20.ms))
    }
    hover {
        Modifier
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = Colors.Black.copy(alpha = 60)
            )
            .color(Colors.Black)
            .borderRadius(100.px)
            .backgroundColor(Colors.White)
    }
}
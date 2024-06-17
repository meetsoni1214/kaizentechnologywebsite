package com.example.kaizentechnology.styles


import com.example.kaizentechnology.util.JsTheme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.anyLink
import com.varabyte.kobweb.silk.style.selectors.focus
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent

val NavigationHomeItemStyle = CssStyle {
    base {
        Modifier
            .textDecorationLine(TextDecorationLine.None)
            .transition(CSSTransition(property = "text-underline-offset", duration = 400.ms))
    }
    anyLink {
        Modifier.color(Colors.White)
    }
    hover {
        Modifier
            .textDecorationLine(TextDecorationLine.Underline)
            .styleModifier {
                property("text-underline-offset", 0.4.em)
            }
    }
}
val NavigationItemStyle = CssStyle {
    base {
        Modifier
            .color(Colors.Black)
            .textDecorationLine(TextDecorationLine.None)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 400.ms))
    }
    anyLink {
        Modifier.color(Colors.Black)
    }
    hover {
        Modifier
            .textDecorationLine(TextDecorationLine.Underline)
            .color(JsTheme.Primary.rgb)
            .styleModifier {
                property("text-underline-offset", 0.4.em)
            }
    }
}

val NavigationItemStyleSM = CssStyle {
    base {
        Modifier
            .color(Colors.Black)
            .textDecorationLine(TextDecorationLine.None)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 400.ms))
    }
    anyLink {
        Modifier.color(Colors.Black)
    }
    hover {
        Modifier
            .textDecorationLine(TextDecorationLine.Underline)
            .color(JsTheme.Primary.rgb)
            .styleModifier {
                property("text-underline-offset", 0.4.em)
            }
    }
}

val LinkStyleModifier = CssStyle {
    base {
        Modifier
            .opacity(0.percent)
            .overflow(Overflow.Hidden)
            .translateX((-100).percent)
    }
    hover {
        Modifier
            .opacity(100.percent)
            .translateX(0.percent)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 300.ms))
    }
    focus {
        Modifier
            .opacity(100.percent)
            .translateX(0.percent)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 300.ms))
    }
}

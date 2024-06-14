package com.example.kaizentechnology.components

import androidx.compose.runtime.Composable
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.Res
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.Span

@Composable
fun SuccessPopup() {
    Box(
        modifier = Modifier
            .width(100.vw)
            .height(100.vh)
            .position(Position.Fixed)
            .zIndex(19),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .backgroundColor(JsTheme.HalfBlack.rgb)
                .onClick {  }
        )
        Column(
            modifier = Modifier
                .backgroundColor(Colors.White)
                .padding(40.px),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                src = Res.Icon.checkmark,
                description = "checkmark Icon",
                modifier = Modifier.margin(bottom = 24.px)
            )
            SpanText(
                modifier = Modifier
                    .fontFamily(FONT_FAMILY)
                    .margin(bottom = 8.px)
                    .fontSize(24.px),
                text = "Your Inquiry has been sent Successfully!"
            )
            SpanText(
                modifier = Modifier
                    .fontFamily(FONT_FAMILY)
                    .color(JsTheme.HalfBlack.rgb)
                    .fontSize(18.px),
                text = "We'll get back to you soon"
            )
        }

    }
}
package com.example.kaizentechnology.components

import androidx.compose.runtime.Composable
import com.example.kaizentechnology.styles.ContactChipStyle
import com.example.kaizentechnology.util.Constants
import com.example.kaizentechnology.util.JsTheme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ContactChip(
    icon: String,
    title: String,
    body: String,
    onClick: () -> Unit,
    breakpoint: Breakpoint
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = ContactChipStyle.toModifier()
            .backgroundColor(JsTheme.LightGray.rgb)
            .borderRadius(8.px)
            .margin(topBottom = 12.px)
            .onClick { onClick() }
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 85.percent else 97.percent)
            .cursor(Cursor.Pointer)
//            .padding(leftRight = 24.px, topBottom = 12.px)
            .padding(leftRight = if (breakpoint > Breakpoint.MD) 24.px else 12.px, topBottom = 12.px)
    ) {
        Image(
            src = icon,
            description = "Icon",
            modifier = Modifier
                .width(50.px)
                .height(50.px)
                .margin(right = if (breakpoint > Breakpoint.MD) 32.px else 18.px)
//                .margin(right = 32.px)
        )
        Column() {
            SpanText(
                text = title,
                modifier = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .margin(bottom = 4.px)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Medium)
            )
            SpanText(
                text = body,
                modifier = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(16.px)
                    .color(JsTheme.Primary.rgb)
                    .fontWeight(FontWeight.Medium)
            )
        }
    }
}
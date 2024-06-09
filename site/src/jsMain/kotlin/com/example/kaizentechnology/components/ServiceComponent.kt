package com.example.kaizentechnology.components

import androidx.compose.runtime.Composable
import com.example.kaizentechnology.styles.ServiceItemStyle
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px
import kotlin.math.log

@Composable
fun ServiceComponent(
    logo: String,
    service: String
) {
    Column(
        modifier = ServiceItemStyle.toModifier()
            .margin(bottom = 24.px)
            .cursor(Cursor.Pointer)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            src = logo,
            description = "services",
            modifier = Modifier
                .height(150.px)
                .margin(bottom = 8.px)
        )
        SpanText(
            text = service,
            modifier = Modifier
                .fontFamily(FONT_FAMILY)
                .fontSize(24.px)
                .fontWeight(FontWeight.SemiBold)
        )
    }
}
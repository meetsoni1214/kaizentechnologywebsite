package com.example.kaizentechnology.components

import androidx.compose.runtime.Composable
import com.example.kaizentechnology.models.Product
import com.example.kaizentechnology.styles.ProductItemButtonStyle
import com.example.kaizentechnology.styles.ProductItemStyle
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.example.kaizentechnology.util.JsTheme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button

@Composable
fun ProductComponent(
    product: Product
) {
    val context = rememberPageContext()
    Column(
        modifier = ProductItemStyle.toModifier()
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = JsTheme.Secondary.rgb
            )
            .margin(topBottom = 12.px)
            .padding(top = if (product.name == "Greenrooms") 90.px else 16.px, bottom = 16.px, leftRight = 16.px)
           .borderRadius(15.px)
            .fillMaxWidth(85.percent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .height(
                    if (product.productName == "Greenrooms")50.px
//                else if (product.productName == "Property Idea Group") 150.px
                else 150.px
                )
                .width(200.px)
                .margin(bottom = 12.px),
            src = product.logo,
            description = "Kaizen Technology Product"
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .margin(top = if (product.name == "Greenrooms") 48.px else 0.px),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpanText(
                text = product.productName,
                modifier = Modifier
                    .fontFamily(FONT_FAMILY)
                    .fontSize(24.px)
                    .textAlign(TextAlign.Center)
                    .margin(bottom = 16.px)
                    .fontWeight(FontWeight.SemiBold)
            )
            Button(
                attrs = ProductItemButtonStyle.toModifier()
                    .onClick {
                        context.router.navigateTo(product.link)
                    }
                    .height(30.px)
                    .borderRadius(100.px)
                    .padding(leftRight = 16.px)
                    .cursor(Cursor.Pointer)
                    .toAttrs()
            ) {
                SpanText(
                    modifier = Modifier
                        .fontSize(15.px)
                        .margin(bottom = 12.px)
                        .fontWeight(FontWeight.Medium)
                        .fontFamily(FONT_FAMILY),
                    text = "Visit Now"
                )
            }
        }
    }
}
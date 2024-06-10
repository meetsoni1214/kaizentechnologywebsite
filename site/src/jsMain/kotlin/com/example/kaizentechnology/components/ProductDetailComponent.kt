package com.example.kaizentechnology.components

import androidx.compose.runtime.Composable
import com.example.kaizentechnology.models.Product
import com.example.kaizentechnology.styles.GreenroomsButtonStyle
import com.example.kaizentechnology.styles.KaizenButtonStyle
import com.example.kaizentechnology.styles.PIGButtonStyle
import com.example.kaizentechnology.styles.TechnoButtonStyle
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.border
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
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button

@Composable
fun ProductDetailComponent(
    product: Product,
    buttonText: String,
    breakpoint: Breakpoint,
    isRight: Boolean = false,
    onButtonClick: (Product) -> Unit,
) {
    if (breakpoint > Breakpoint.MD) {
        Row(
            modifier = Modifier
                .padding(topBottom = 24.px, leftRight = 36.px)
                .border(
                    width = 2.px,
                    color = product.productColor,
                    style = LineStyle.Solid
                )
                .margin(bottom = 32.px)
                .borderRadius(30.px)
                .fillMaxWidth(90.percent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (!isRight) {
                ProductImage(
                    modifier = Modifier.margin(right = 50.px),
                    product = product
                )
                ProductDetails(
                    product = product,
                    breakpoint = breakpoint,
                    onButtonClick = onButtonClick,
                    buttonText = buttonText
                )
            } else {
                ProductDetails(
                    product = product,
                    breakpoint = breakpoint,
                    onButtonClick = onButtonClick,
                    buttonText = buttonText
                )
                ProductImage(
                    modifier = Modifier.margin(left = 50.px),
                    product = product
                )
            }
        }
    } else {
        Column(
            modifier = Modifier
                .padding(24.px)
                .border(
                    width = 2.px,
                    color = product.productColor,
                    style = LineStyle.Solid
                )
                .margin(bottom = 32.px)
                .borderRadius(30.px)
                .fillMaxWidth(90.percent),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                src = product.logo,
                description = product.productName,
                modifier = Modifier
                    .width(if (product == Product.Greenrooms) 246.px else 250.px)
                    .height(if (product == Product.Greenrooms) 49.px else 160.px)
                    .margin(bottom = 32.px)
            )
            ProductDetails(
                product = product,
                breakpoint = breakpoint,
                onButtonClick = onButtonClick,
                buttonText = buttonText,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun ProductImage(
    modifier: Modifier,
    product: Product
) {
    Image(
        src = product.logo,
        description = product.productName,
        modifier = modifier
            .width(if (product == Product.Greenrooms) 292.px else 250.px)
            .height(if (product == Product.Greenrooms) 58.px else 160.px)
    )
}
@Composable
fun ProductDetails(
    product: Product,
    breakpoint: Breakpoint,
    onButtonClick: (Product) -> Unit,
    buttonText: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        ProductTitle(title = product.productName)
        ProductTagLine(
            text = product.productTagline,
            color = product.productColor
        )
        ProductDescription(
            desc = product.productDesc,
            breakpoint = breakpoint
        )
        Button(
            attrs = Modifier
                .thenIf(
                    condition = (product == Product.Kaizen),
                    other = KaizenButtonStyle.toModifier()
                )
                .thenIf(
                    condition = (product == Product.Techno),
                    other = TechnoButtonStyle.toModifier()
                )
                .thenIf(
                    condition = (product == Product.Greenrooms),
                    other = GreenroomsButtonStyle.toModifier()
                )
                .thenIf(
                    condition = (product == Product.PIG),
                    other = PIGButtonStyle.toModifier()
                )
                .onClick {
                    onButtonClick(product)
                }
                .height(40.px)
                .padding(leftRight = 24.px, topBottom = 8.px)
                .cursor(Cursor.Pointer)
                .toAttrs()
        ) {
            SpanText(
                modifier = Modifier
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Medium)
                    .fontFamily(FONT_FAMILY),
                text = buttonText
            )
        }
    }
}
@Composable
fun ProductTitle(
    title: String
) {
    SpanText(
        text = title,
        modifier = Modifier
            .fontFamily(FONT_FAMILY)
            .margin(bottom = 8.px)
            .fontSize(32.px)
            .styleModifier {
                property("display", "-webkit-box")
                property("-webkit-line-clamp", "2")
                property("line-clamp", "2")
                property("-webkit-box-orient", "vertical")
            }
            .fontWeight(FontWeight.SemiBold)
    )
}

@Composable
fun ProductTagLine(
    text: String,
    color: Color.Rgb
) {
    SpanText(
        text = text,
        modifier = Modifier
            .fontFamily(FONT_FAMILY)
            .margin(bottom = 24.px)
            .fontSize(20.px)
            .color(color)
            .styleModifier {
                property("display", "-webkit-box")
                property("-webkit-line-clamp", "2")
                property("line-clamp", "2")
                property("-webkit-box-orient", "vertical")
            }
            .fontWeight(FontWeight.SemiBold)
    )
}

@Composable
fun ProductDescription(
    desc: String,
    breakpoint: Breakpoint
) {
    SpanText(
        modifier = Modifier
            .fontWeight(FontWeight.Medium)
            .fontFamily(FONT_FAMILY)
            .margin(bottom = 12.px)
            .fontSize(if (breakpoint > Breakpoint.MD) 18.px else 16.px)
            .styleModifier {
                property("display", "-webkit-box")
                property("-webkit-line-clamp", "16")
                property("line-clamp", "16")
                property("-webkit-box-orient", "vertical")
            },
        text = desc
    )
}
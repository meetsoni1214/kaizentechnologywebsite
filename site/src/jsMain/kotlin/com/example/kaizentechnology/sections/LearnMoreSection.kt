package com.example.kaizentechnology.sections

import androidx.compose.runtime.Composable
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.noBorder
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.layout.VerticalDivider
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button

@Composable
fun LearnMoreSection(
    onLearnMoreClick: () -> Unit,
    onNumberClick: () -> Unit,
    breakpoint: Breakpoint
) {
    if (breakpoint > Breakpoint.MD) {
        Row(
            modifier = Modifier
                .margin(top = 40.px, bottom = 60.px)
                .fillMaxWidth(90.percent)
                .padding(leftRight = 60.px, top = 60.px, bottom = 40.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(50.percent)
                    .padding(right = 210.px),
                horizontalAlignment = Alignment.Start
            ) {
                LearnMoreTitle(text = "No bullshit.")
                LearnMoreText(
                    text = "We know what we're doing and we're straight-talkers. We'll always have your back, and you'll always knows where you stand.",
                    modifier = Modifier.margin(bottom = 24.px))
                LearnMoreButton(
                    btnText = "LEARN MORE ABOUT US",
                    modifier = Modifier
                        .width(270.px),
                    onButtonClick = onLearnMoreClick)
            }
            VerticalDivider(
                modifier = Modifier
                    .noBorder()
                    .margin(right = 40.px)
                    .width(2.px)
                    .backgroundColor(JsTheme.Primary.rgb)
                    .fillMaxHeight()
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(50.percent)
                    .padding(left = 40.px, right = 140.px),
                horizontalAlignment = Alignment.Start
            ) {
                LearnMoreTitle(text = "Talk to us")
                LearnMoreText(
                    text = "Give us a yell to see how we can help and decide if we're a good fit for your business.",
                    modifier = Modifier.margin(bottom = 36.px))
                Box(
                    modifier = Modifier
                        .cursor(Cursor.Pointer)
                        .onClick { onNumberClick() }
                ) {
                    LearnMoreButton(btnText = "GET IN TOUCH",
                        modifier = Modifier
                            .zIndex(-1)
                            .align(Alignment.CenterStart)
                            .width(200.px),
                        onButtonClick = {  })
                    NumberButton(
                        btnText = "7046327745",
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .margin(left = 150.px)
                            .zIndex(9)
                            .width(180.px),
                        onButtonClick = { }
                    )
                }
            }
        }
    } else {
        Column(
            modifier = Modifier
                .margin(top = 40.px, bottom = 60.px)
                .fillMaxWidth(90.percent)
                .padding(leftRight = 30.px, top = 60.px, bottom = 40.px),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                LearnMoreTitle(text = "No bullshit.")
                LearnMoreText(
                    text = "We know what we're doing and we're straight-talkers. We'll always have your back, and you'll always knows where you stand.",
                    modifier = Modifier.margin(bottom = 24.px))
                LearnMoreButton(
                    btnText = "LEARN MORE ABOUT US",
                    modifier = Modifier
                        .width(270.px),
                    onButtonClick = onLearnMoreClick)
                HorizontalDivider(
                    modifier = Modifier
                        .noBorder()
                        .margin(topBottom = 40.px)
                        .height(2.px)
                        .fillMaxWidth()
                        .backgroundColor(JsTheme.Primary.rgb)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                LearnMoreTitle(text = "Talk to us")
                LearnMoreText(
                    text = "Give us a yell to see how we can help and decide if we're a good fit for your business.",
                    modifier = Modifier.margin(bottom = 36.px))
                Box(
                    modifier = Modifier
                        .cursor(Cursor.Pointer)
                        .onClick { onNumberClick() }
                ) {
                    LearnMoreButton(btnText = "GET IN TOUCH",
                        modifier = Modifier
                            .zIndex(-1)
                            .align(Alignment.CenterStart)
                            .width(170.px),
                        onButtonClick = {  })
                    NumberButton(
                        btnText = "7046327745",
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .margin(left = 120.px)
                            .zIndex(9)
                            .width(150.px),
                        onButtonClick = { }
                    )
                }
            }
        }
    }
}



@Composable
fun LearnMoreTitle(
    text: String
) {
    SpanText(
        text = text,
        modifier = Modifier
            .fontFamily(FONT_FAMILY)
            .fontWeight(FontWeight.SemiBold)
            .fontSize(32.px)
            .color(JsTheme.Primary.rgb)
            .margin(bottom = 24.px)
    )
}

@Composable
fun LearnMoreText(
    modifier: Modifier = Modifier,
    text: String
) {
    SpanText(
        text = text,
        modifier = modifier
            .fontFamily(FONT_FAMILY)
            .fontSize(16.px)
            .fontWeight(FontWeight.Medium)
            .styleModifier {
                property("display", "-webkit-box")
                property("-webkit-line-clamp", 4)
                property("line-clamp", 4)
                property("-webkit-box-orient", "vertical")
            }
            .color(JsTheme.HalfBlack.rgb)
    )
}

@Composable
fun LearnMoreButton(
    btnText: String,
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    Button(
        attrs = modifier
            .onClick {
                onButtonClick()
            }
            .height(54.px)
            .backgroundColor(JsTheme.Primary.rgb)
            .padding(left = 12.px, top = 12.px, right = 32.px, bottom = 12.px)
            .noBorder()
            .cursor(Cursor.Pointer)
            .styleModifier {
                property("clip-path", "polygon(0 0, 100% 0%, 85% 100%, 0% 100%)")
                property("-webkit-clip-path", "polygon(0 0, 100% 0%, 85% 100%, 0% 100%)")
            }
            .toAttrs()
    ) {
        SpanText(
            modifier = Modifier
                .fontSize(14.px)
                .color(Colors.White)
                .fontWeight(FontWeight.Medium)
                .fontFamily(FONT_FAMILY),
            text = btnText
        )
    }
}

@Composable
fun NumberButton(
    btnText: String,
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    Button(
        attrs = modifier
            .onClick {
                onButtonClick()
            }
            .height(54.px)
            .backgroundColor(JsTheme.Secondary.rgb)
            .padding(left = 24.px, top = 12.px, right = 12.px, bottom = 12.px)
            .noBorder()
            .cursor(Cursor.Pointer)
            .styleModifier {
                property("clip-path", "polygon(25% 0%, 100% 0%, 100% 100%, 0% 100%)")
                property("-webkit-clip-path", "polygon(25% 0%, 100% 0%, 100% 100%, 0% 100%)")
            }
            .toAttrs()
    ) {
        SpanText(
            modifier = Modifier
                .fontSize(14.px)
                .color(Colors.White)
                .fontWeight(FontWeight.Medium)
                .fontFamily(FONT_FAMILY),
            text = btnText
        )
    }
}
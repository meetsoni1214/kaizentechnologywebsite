package com.example.kaizentechnology.sections

import androidx.compose.runtime.Composable
import com.example.kaizentechnology.pages.TitleText
import com.example.kaizentechnology.util.Constants.ABOUT_US_TEXT
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.example.kaizentechnology.util.Constants.SUCCESS_STORIES_TEXT
import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.Res
import com.example.kaizentechnology.util.noBorder
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Col

@Composable
fun AboutIntroSection(
    breakpoint: Breakpoint
) {
    if (breakpoint > Breakpoint.MD) {
        Row(
            modifier = Modifier
                .margin(bottom = 32.px)
                .fillMaxWidth(90.percent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AboutIntroImage(
                modifier = Modifier
                    .width(580.px)
                    .height(482.px)
                    .margin(right = 32.px),
            )
            AboutUsIntroText(
                text = ABOUT_US_TEXT,
                noOfLines = "22",
                modifier = Modifier
                    .fontSize(22.px)
            )
        }
    } else {
        Column(
            modifier = Modifier
                .margin(bottom = 32.px)
                .fillMaxWidth(90.percent),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AboutIntroImage(
                modifier = Modifier
                    .width(364.px)
                    .height(302.px)
                    .margin(bottom = 24.px),
            )
            AboutUsIntroText(
                text = ABOUT_US_TEXT,
                noOfLines = "22",
                modifier = Modifier
                    .fillMaxWidth()
                    .fontSize(18.px)
            )
        }
    }
}

@Composable
fun AboutSuccessStories(
    breakpoint: Breakpoint
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(90.percent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleText(
            title = "Success Stories",
            modifier = Modifier
                .fillMaxWidth()
        )
        HorizontalDivider(
            modifier = Modifier
                .width(200.px)
                .height(2.px)
                .noBorder()
                .backgroundColor(JsTheme.Primary.rgb)
                .margin(top = 24.px, bottom = 24.px)
        )
        SpanText(
            text = "Failure Paves the Way to Success",
            modifier = Modifier
                .fontFamily(FONT_FAMILY)
                .fontWeight(FontWeight.Medium)
                .fontSize(18.px)
                .fontStyle(FontStyle.Italic)
                .margin(bottom = 24.px)
        )
            AboutUsIntroText(
                text = SUCCESS_STORIES_TEXT,
                noOfLines = "10",
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(bottom = 24.px)
                    .fontSize(if (breakpoint > Breakpoint.MD) 22.px else 18.px)
            )
            SuccessStoriesImage(
                modifier = Modifier
                    .width( if (breakpoint > Breakpoint.MD) 1190.px else 352.px)
                    .height( if (breakpoint > Breakpoint.MD) 957.px else 283.px)
            )
    }
}

@Composable
fun SuccessStoriesImage(
    modifier: Modifier
) {
    Image(
        modifier = modifier,
        src = Res.Image.successStoriesImage,
        description = "Success Stories",
    )
}

@Composable
fun AboutIntroImage(
    modifier: Modifier
) {
    Image(
        modifier = modifier,
        src = Res.Image.aboutUsIntroImage,
        description = "About Us Image",
    )
}

@Composable
fun AboutUsIntroText(
    modifier: Modifier,
    noOfLines: String,
    text: String
) {
    SpanText(
        text = text,
        modifier = modifier
            .fontFamily(FONT_FAMILY)
            .fontWeight(FontWeight.Medium)
            .styleModifier {
                property("display", "-webkit-box")
                property("-webkit-line-clamp", noOfLines)
                property("line-clamp", noOfLines)
                property("-webkit-box-orient", "vertical")
            }
    )

}
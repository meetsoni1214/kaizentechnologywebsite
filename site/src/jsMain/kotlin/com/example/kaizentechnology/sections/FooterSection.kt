package com.example.kaizentechnology.sections

import androidx.compose.runtime.Composable
import com.example.kaizentechnology.styles.FooterIconStyle
import com.example.kaizentechnology.styles.FooterTextStyle
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.Res
import com.example.kaizentechnology.util.noBorder
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaEnvelope
import com.varabyte.kobweb.silk.components.icons.fa.FaFacebook
import com.varabyte.kobweb.silk.components.icons.fa.FaInstagram
import com.varabyte.kobweb.silk.components.icons.fa.FaLocationDot
import com.varabyte.kobweb.silk.components.icons.fa.FaPhone
import com.varabyte.kobweb.silk.components.icons.fa.FaXTwitter
import com.varabyte.kobweb.silk.components.icons.fa.FaYoutube
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.icons.fa.IconStyle
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun FooterSection(
    breakpoint: Breakpoint,
    onPhoneClick: () -> Unit,
    onLocationClick: () -> Unit,
    onEmailClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .margin(top = 32.px)
            .padding(leftRight = 46.px)
            .backgroundColor(JsTheme.FooterColor.rgb)
            .height(if (breakpoint <= Breakpoint.SM) 1035.px else 440.px)
    ) {
        if (breakpoint <= Breakpoint.SM) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(top = 120.px, bottom = 24.px)
            ) {
                FooterAbout(modifier = Modifier
                    .margin(bottom = 32.px)
                    .fillMaxWidth())
                FooterHelpCentre(
                    modifier = Modifier
                    .fillMaxWidth(),
                    onEmailClick = onEmailClick,
                    onLocationClick = onLocationClick,
                    onPhoneClick = onPhoneClick
                )
                HelpfulLinks(modifier = Modifier
                    .margin(top = 32.px)
                    .fillMaxWidth())
                OtherLinks(modifier = Modifier.fillMaxWidth())
            }
            FooterCopyright(modifier = Modifier.margin(top = 40.px))
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(top = 120.px, bottom = 24.px),
                verticalAlignment = Alignment.Top
            ) {
                FooterAbout(modifier = Modifier.fillMaxWidth(25.percent))
                FooterHelpCentre(
                    onEmailClick = onEmailClick,
                    onLocationClick = onLocationClick,
                    onPhoneClick = onPhoneClick,
                    modifier = Modifier.fillMaxWidth(25.percent)
                )
                HelpfulLinks(modifier = Modifier.fillMaxWidth(25.percent))
                OtherLinks(modifier = Modifier.fillMaxWidth(25.percent))
            }
            FooterCopyright(modifier = Modifier.margin(top = 40.px))

        }
    }
}

@Composable
fun FooterAbout(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Image(
            src = Res.Image.whiteLogo,
            description = "Logo",
            modifier = Modifier
                .margin(bottom = 8.px)
                .height(100.px)
                .width(200.px)
        )
        SpanText(
            text = "Kaizen property group is an organization with the unique understanding of real estate field." +
                    "We have young, dynamic & professional team.",
            modifier = Modifier
                .fontFamily(FONT_FAMILY)
                .fontSize(16.px)
                .margin(right = 24.px)
                .fontWeight(FontWeight.Normal)
                .color(Colors.White)
                .styleModifier {
                    property("display", "-webkit-box")
                    property("-webkit-line-clamp", "7")
                    property("line-clamp", "7")
                    property("-webkit-box-orient", "vertical")
                },
        )
    }
}

@Composable
fun FooterHelpCentre(
    modifier: Modifier = Modifier,
    onPhoneClick: () -> Unit,
    onLocationClick: () -> Unit,
    onEmailClick: () -> Unit
) {
    Column(
        modifier = modifier
            .margin(right = 24.px)
    ) {
        FooterTitleText(
            text = "Help Centre",
            width = 50
        )
        Row(
            modifier = Modifier
                .cursor(Cursor.Pointer)
                .margin(bottom = 24.px)
                .onClick { onLocationClick()  }
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FaLocationDot(
                modifier = Modifier
                    .color(Colors.White)
                    .margin(right = 8.px),
                size = IconSize.XL
            )
            FooterSubTitle(
                modifier = Modifier
                    .styleModifier {
                        property("display", "-webkit-box")
                        property("-webkit-line-clamp", "2")
                        property("line-clamp", "2")
                        property("-webkit-box-orient", "vertical")
                    },
                text = "New York Tower, Thaltej Cross Road, Thaltej")
        }
        Row(
            modifier = Modifier
                .cursor(Cursor.Pointer)
                .margin(bottom = 24.px)
                .onClick { onPhoneClick()  }
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FaPhone(
                modifier = Modifier
                    .color(Colors.White)
                    .margin(right = 8.px),
                size = IconSize.XL
            )
            FooterSubTitle(text = "+91 7046327745")
        }
        Row(
            modifier = Modifier
                .cursor(Cursor.Pointer)
                .margin(bottom = 24.px)
                .onClick { onEmailClick() }
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FaEnvelope(
                modifier = Modifier
                    .color(Colors.White)
                    .margin(right = 8.px),
                style = IconStyle.FILLED,
                size = IconSize.XL
            )
            FooterSubTitle(text = "support@kaizentechnology.org.in")
        }
    }
}

@Composable
fun HelpfulLinks(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        FooterTitleText(text = "Helpful Links", width = 70)
        FooterSubTitle(text = "Our Services", modifier = Modifier.margin(bottom = 8.px))
        FooterSubTitle(text = "Our Products", modifier = Modifier.margin(bottom = 8.px))
        FooterSubTitle(text = "Our Team", modifier = Modifier.margin(bottom = 8.px))
    }
}

@Composable
fun OtherLinks(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .margin(top = 50.px)
    ) {
        FooterSubTitle(text = "About Us", modifier = Modifier.margin(bottom = 8.px))
        FooterSubTitle(text = "Contact Us", modifier = Modifier.margin(bottom = 8.px))
        FooterSubTitle(text = "Privacy Policy", modifier = Modifier.margin(bottom = 8.px))
        FooterSocials()
    }
}

@Composable
fun FooterSocials() {
    Row(
        modifier = Modifier
            .margin(top = 24.px)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        FaFacebook(
            modifier = FooterIconStyle.toModifier()
                .cursor(Cursor.Pointer)
                .margin(right = 12.px),
            size = IconSize.XL
        )
        FaInstagram(
            modifier = FooterIconStyle.toModifier()
                .cursor(Cursor.Pointer)
                .margin(right = 12.px),
            size = IconSize.XL
        )
        FaXTwitter(
            modifier = FooterIconStyle.toModifier()
                .cursor(Cursor.Pointer)
                .margin(right = 12.px),
            size = IconSize.XL
        )
        FaYoutube(
            modifier = FooterIconStyle.toModifier()
                .cursor(Cursor.Pointer)
                .margin(right = 12.px),
            size = IconSize.XL
        )
    }
}

@Composable
fun FooterTitleText(
    text: String,
    width: Int
) {
    SpanText(
        text = text,
        modifier = Modifier
            .fontFamily(FONT_FAMILY)
            .fontSize(24.px)
            .fontWeight(FontWeight.Bold)
            .color(Colors.White)
            .margin(bottom = 6.px)
    )
    HorizontalDivider(
        modifier = Modifier
            .width(width.px)
            .height(2.px)
            .noBorder()
            .backgroundColor(JsTheme.Primary.rgb)
            .margin(bottom = 24.px)
    )
}

@Composable
fun FooterSubTitle(
    text: String,
    modifier: Modifier = Modifier
){
    SpanText(
        text = text,
        modifier = FooterTextStyle.toModifier()
            .then(modifier)
            .fontFamily(FONT_FAMILY)
            .fontSize(16.px)
            .cursor(Cursor.Pointer)
            .fontWeight(FontWeight.Medium)
    )
}

@Composable
fun FooterCopyright(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .noBorder()
                .opacity(60.percent)
                .height(1.px)
                .margin(bottom = 12.px)
                .backgroundColor(Colors.White)
        )
        FooterSubTitle(
            text = "Copyright  © 2024 Kaizen Technology | All rights reserved",
            modifier = Modifier
                .textAlign(TextAlign.Center)
        )
    }


}

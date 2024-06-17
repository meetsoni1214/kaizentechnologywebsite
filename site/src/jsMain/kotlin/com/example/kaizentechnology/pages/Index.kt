package com.example.kaizentechnology.pages

import androidx.compose.runtime.*
import com.example.kaizentechnology.components.NavigationItem
import com.example.kaizentechnology.components.OverflowSidePanel
import com.example.kaizentechnology.models.HeaderItem
import com.example.kaizentechnology.navigation.Screen
import com.example.kaizentechnology.sections.FooterSection
import com.example.kaizentechnology.sections.HeaderSection
import com.example.kaizentechnology.sections.LearnMoreSection
import com.example.kaizentechnology.sections.ProductsSection
import com.example.kaizentechnology.sections.ServicesSection
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.example.kaizentechnology.util.Constants.HOME_PAGE_INTRO
import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.Res
import com.example.kaizentechnology.util.noBorder
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    val breakpoint = rememberBreakpoint()
    val context = rememberPageContext()
    var overflowOpened by remember { mutableStateOf(false) }
    Image(
        modifier = Modifier
            .height(if (breakpoint > Breakpoint.SM) 600.px else 300.px)
            .fillMaxWidth(),
        src = "/real-estate-banner-home.avif",
        description = "Header Image"
    )
    Column(
        modifier = Modifier
            .zIndex(19)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (overflowOpened) {
            OverflowSidePanel(
                onMenuClosed = {
                    overflowOpened = false
                },
                content = {
                    Column {
                        NavigationItem(
                            vertical = true,
                            onLinkClick = {
                                context.router.navigateTo(it)
                            }
                        )
                    }

                }
            )
        }
        HeaderSection(
            breakpoint = breakpoint,
            onMenuOpened = { overflowOpened = true},
            logo = Res.Image.whiteLogo,
            isHomePage = true,
            selectedItem = HeaderItem.Home.itemName,
            onLogoClick = {
                context.router.navigateTo(Screen.HomePage.route)
            },
            onLinkClick = {
                context.router.navigateTo(it)
            }
        )
        if (breakpoint > Breakpoint.SM) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(top = 600.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HomePageIntro(
                    isSM = false
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(top = 224.px),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HomePageIntro(
                    isSM = true
                )
            }
        }
        TitleText(
            title = "Our Services",
            modifier = Modifier
                .fillMaxWidth()
                .margin(top = 100.px)
        )
        HorizontalDivider(
            modifier = Modifier
                .width(150.px)
                .height(2.px)
                .noBorder()
                .backgroundColor(JsTheme.Primary.rgb)
                .margin(top = 24.px, bottom = 40.px)
        )
        ServicesSection(
            breakpoint = breakpoint
        )
        TitleText(
            title = "Our Products",
            modifier = Modifier
                .fillMaxWidth()
                .margin(top = if (breakpoint > Breakpoint.MD) 100.px else 70.px)
        )
        HorizontalDivider(
            modifier = Modifier
                .width(150.px)
                .height(2.px)
                .noBorder()
                .backgroundColor(JsTheme.Primary.rgb)
                .margin(top = 24.px, bottom = 32.px)
        )
        ProductsSection(breakpoint = breakpoint)
        TitleText(
            title = "The Team That You Need",
            modifier = Modifier
                .fillMaxWidth(90.percent)
                .margin(top = 100.px)
        )
        HorizontalDivider(
            modifier = Modifier
                .width(200.px)
                .height(2.px)
                .noBorder()
                .backgroundColor(JsTheme.Primary.rgb)
                .margin(top = 24.px, bottom = 32.px)
        )
        SpanText(
            text = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis ",
            modifier = Modifier
                .fillMaxWidth()
                .fontFamily(FONT_FAMILY)
                .textAlign(TextAlign.Center)
                .fontWeight(FontWeight.Medium)
                .fontSize(if (breakpoint > Breakpoint.SM) 24.px else 18.px)
                .margin(bottom = 32.px)
                .opacity(70.percent)
                .fillMaxWidth(85.percent)
                .styleModifier {
                    property("display", "-webkit-box")
                    property("-webkit-line-clamp", "6")
                    property("line-clamp", "6")
                    property("-webkit-box-orient", "vertical")
                },
        )
        Image(
            src = "/team.jpg",
            description = "Kaizen Technology Team",
            modifier = Modifier
                .margin(bottom = 32.px)
                .fillMaxWidth(90.percent)
        )
        LearnMoreSection(
            breakpoint = breakpoint,
            onLearnMoreClick = {
                context.router.navigateTo(Screen.AboutUsPage.route)
            },
            onNumberClick = {
                context.router.navigateTo("tel:7046327745")
            }
        )
        FooterSection(
            breakpoint = breakpoint,
            onLocationClick = {
                context.router.navigateTo("https://maps.app.goo.gl/SGEZpu4cATABGVsZA")
            },
            onEmailClick = {
                context.router.navigateTo("mailto:support@kaizentechnology.org.in")
            },
            onPhoneClick = {
                context.router.navigateTo("tel:7046327745")
            },
            onLogoClick = {
                context.router.navigateTo(Screen.HomePage.route)
            },
            onServicesClick = {
                context.router.navigateTo(Screen.ServicesPage.route)
            },
            onProductsClick = {
                context.router.navigateTo(Screen.ProductsPage.route)
            },
            onAboutUsClick = {
                context.router.navigateTo(Screen.AboutUsPage.route)
            },
            onOurTeamClick = {
                context.router.navigateTo(Screen.AboutUsPage.route)
            },
            onContactUsClick = {
                context.router.navigateTo(Screen.ContactUsPage.route)
            },
            onPrivacyPolicyClick = {
                context.router.navigateTo(Screen.PrivacyPolicyPage.route)
            }
        )
    }
}

@Composable fun HomePageIntro(
    isSM: Boolean,
) {
    Column(
        modifier = Modifier
            .margin(left = if (!isSM) 32.px else 0.px)
            .fillMaxWidth(if (!isSM) 50.percent else 90.percent),
        horizontalAlignment = Alignment.Start
    ) {
        SpanText(
            modifier = Modifier
                .fontWeight(FontWeight.Medium)
                .fontFamily(FONT_FAMILY)
                .fontSize(if (!isSM) 40.px else 30.px)
                .styleModifier {
                property("display", "-webkit-box")
                property("-webkit-line-clamp", "3")
                property("line-clamp", "3")
                property("-webkit-box-orient", "vertical")
            },
            text = "Some Heading, Some More Heading, Some Extra Heading"
        )
        SpanText(
            modifier = Modifier
                .fontWeight(FontWeight.Medium)
                .fontFamily(FONT_FAMILY)
                .margin(top = 12.px)
                .fontSize(if (!isSM) 24.px else 18.px)
                .styleModifier {
                property("display", "-webkit-box")
                property("-webkit-line-clamp", "12")
                property("line-clamp", "12")
                property("-webkit-box-orient", "vertical")
            },
            text = HOME_PAGE_INTRO
        )
    }
    Image(
        modifier = Modifier
            .margin(left = 24.px, right = 24.px, top = if (!isSM) 0.px else 24.px, bottom = 32.px)
            .fillMaxWidth(if (!isSM) 50.percent else 90.percent),
        src = "/home_image_intro.jpg",
        description = "Header Image"
    )
}

@Composable
fun TitleText(
    title: String,
    modifier: Modifier = Modifier
) {
    SpanText(
        text = title,
        modifier = modifier
            .fontFamily(FONT_FAMILY)
            .textAlign(TextAlign.Center)
            .fontWeight(FontWeight.Bold)
            .fontSize(40.px)
//                .textDecorationLine(TextDecorationLine.Underline)
    )
}
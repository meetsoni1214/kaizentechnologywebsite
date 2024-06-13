package com.example.kaizentechnology.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.kaizentechnology.components.NavigationItem
import com.example.kaizentechnology.components.PageBanner
import com.example.kaizentechnology.components.ServiceTitle
import com.example.kaizentechnology.components.SidePanel
import com.example.kaizentechnology.models.HeaderItem
import com.example.kaizentechnology.navigation.Screen
import com.example.kaizentechnology.sections.FooterSection
import com.example.kaizentechnology.sections.HeaderSection
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.example.kaizentechnology.util.Constants.PRIVACY_POLICY
import com.example.kaizentechnology.util.Id
import com.example.kaizentechnology.util.Res
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

@Page(routeOverride = "privacy-policy")
@Composable
fun PrivacyPolicyPage() {
    val breakpoint = rememberBreakpoint()
    val context = rememberPageContext()
    var overflowOpened by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        document.getElementById(Id.privacyPolicyContent)?.innerHTML = PRIVACY_POLICY
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (overflowOpened) {
            SidePanel(
                onMenuClosed = {
                    overflowOpened = false
                },
                content = {
                    Column {
                        NavigationItem(
                            vertical = true,
                            selectedItem = "Privacy Policy",
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
            isHomePage = false,
            onMenuOpened = { overflowOpened = true },
            logo = Res.Image.logo,
            selectedItem = "Privacy Policy",
            onLogoClick = { context.router.navigateTo(Screen.HomePage.route) },
            onLinkClick = { context.router.navigateTo(it) }
        )
        PageBanner(
            title = "Privacy Policy",
            image = Res.Image.privacyPolicyBannerImage,
            breakpoint = breakpoint
        )
        Div(
            attrs = Modifier
                .fillMaxWidth(90.percent)
                .id(Id.privacyPolicyContent)
                .fontFamily(FONT_FAMILY)
                .toAttrs()
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
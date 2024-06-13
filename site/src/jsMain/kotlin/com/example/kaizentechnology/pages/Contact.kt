package com.example.kaizentechnology.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.kaizentechnology.components.ContactChip
import com.example.kaizentechnology.components.NavigationItem
import com.example.kaizentechnology.components.PageBanner
import com.example.kaizentechnology.components.ServiceTitle
import com.example.kaizentechnology.components.SidePanel
import com.example.kaizentechnology.models.Contact
import com.example.kaizentechnology.models.HeaderItem
import com.example.kaizentechnology.navigation.Screen
import com.example.kaizentechnology.sections.ContactUsFormSection
import com.example.kaizentechnology.sections.FooterSection
import com.example.kaizentechnology.sections.HeaderSection
import com.example.kaizentechnology.util.Res
import com.example.kaizentechnology.util.noBorder
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Iframe

@Page(routeOverride = "contact-us")
@Composable
fun ContactUsPage() {
    val breakpoint = rememberBreakpoint()
    val context = rememberPageContext()
    var overflowOpened by remember { mutableStateOf(false) }
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
                            selectedItem = HeaderItem.ContactUs.itemName,
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
            selectedItem = HeaderItem.ContactUs.itemName,
            onLogoClick = { context.router.navigateTo(Screen.HomePage.route) },
            onLinkClick = { context.router.navigateTo(it) }
        )
        PageBanner(
            title = "Get In Touch",
            image = Res.Image.contactBannerImage,
            breakpoint = breakpoint
        )
        ContactUsFormSection(
            breakpoint = breakpoint
        )
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(90.percent),
            numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 3)
        ) {
            Contact.entries.forEach { item ->
                ContactChip(
                    icon = item.icon,
                    title = item.title,
                    body = item.body,
                    onClick = { context.router.navigateTo(item.link) },
                    breakpoint = breakpoint
                )
            }
        }
        ServiceTitle(
            serviceTitle = "Reach out to our Office",
            modifier = Modifier
                .fillMaxWidth(90.percent)
                .margin(top = 32.px, bottom = 24.px)
                .fontSize(38.px)
        )
        Iframe(
            attrs = Modifier
                .fillMaxWidth(90.percent)
                .noBorder()
                .height(450.px)
                .toAttrs {
                    attr("src", "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3671.197161659151!2d72.51658677477107!3d23.05323221518437!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x395e9b54e8029a85%3A0xd6fb370f201f4484!2sNew%20York%20Tower%20B!5e0!3m2!1sen!2sin!4v1718195184833!5m2!1sen!2sin")
                    attr("loading", "lazy")
                    attr("referrerpolicy", "no-referrer-when-downgrade")
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
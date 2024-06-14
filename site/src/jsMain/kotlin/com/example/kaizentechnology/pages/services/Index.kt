package com.example.kaizentechnology.pages.services

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.kaizentechnology.components.DynamicServiceComponent
import com.example.kaizentechnology.components.NavigationItem
import com.example.kaizentechnology.components.PageBanner
import com.example.kaizentechnology.components.ServiceDetailComponent
import com.example.kaizentechnology.components.OverflowSidePanel
import com.example.kaizentechnology.models.DynamicService
import com.example.kaizentechnology.models.HeaderItem
import com.example.kaizentechnology.navigation.Screen
import com.example.kaizentechnology.sections.FooterSection
import com.example.kaizentechnology.sections.HeaderSection
import com.example.kaizentechnology.util.Res
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint

@Page
@Composable
fun ServicesPage() {
    val breakpoint = rememberBreakpoint()
    val context = rememberPageContext()
    var overflowOpened by remember { mutableStateOf(false) }
    var activeService by remember { mutableStateOf(DynamicService.ForPropertyOwner) }
    Column(
        modifier = Modifier
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
                            selectedItem = HeaderItem.Services.itemName,
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
            selectedItem = HeaderItem.Services.itemName,
            onLogoClick = { context.router.navigateTo(Screen.HomePage.route) },
            onLinkClick = { context.router.navigateTo(it) }
        )
        PageBanner(
            title = "Our Services",
            image = Res.Image.serviceBannerImage,
            breakpoint = breakpoint
        )
        ServiceDetailComponent(
            serviceTitle = "Database Aggregator",
            serviceImage = Res.Image.serviceImage,
            breakpoint = breakpoint,
            serviceDesc = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu pretium quis, sem Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu pretium quis, sem"
        )
        ServiceDetailComponent(
            serviceTitle = "Admin Support",
            serviceImage = Res.Image.serviceImage,
            breakpoint = breakpoint,
            serviceDesc = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu pretium quis, sem Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu pretium quis, sem"
        )
        DynamicServiceComponent(
            serviceTitle = "Solution Provider",
            breakpoint = breakpoint,
            dynamicService = activeService,
            onClick = { activeService = it}
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
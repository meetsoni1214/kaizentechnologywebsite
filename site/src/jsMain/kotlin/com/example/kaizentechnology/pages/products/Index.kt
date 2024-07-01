package com.example.kaizentechnology.pages.products

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.kaizentechnology.components.NavigationItem
import com.example.kaizentechnology.components.PageBanner
import com.example.kaizentechnology.components.ProductDetailComponent
import com.example.kaizentechnology.components.OverflowSidePanel
import com.example.kaizentechnology.models.HeaderItem
import com.example.kaizentechnology.models.Product
import com.example.kaizentechnology.navigation.Screen
import com.example.kaizentechnology.sections.FooterSection
import com.example.kaizentechnology.sections.HeaderSection
import com.example.kaizentechnology.util.Constants.EMAIL_LINK
import com.example.kaizentechnology.util.Constants.MAP_LINK
import com.example.kaizentechnology.util.Constants.TEL_LINK
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
fun ProductsPage() {
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
            OverflowSidePanel(
                onMenuClosed = {
                    overflowOpened = false
                },
                content = {
                    Column {
                        NavigationItem(
                            vertical = true,
                            selectedItem = HeaderItem.Products.itemName,
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
            onMenuOpened = { overflowOpened = true},
            logo = Res.Image.logo,
            selectedItem = HeaderItem.Products.itemName,
            onLogoClick = { context.router.navigateTo(Screen.HomePage.route)},
            onLinkClick = { context.router.navigateTo(it)}
        )
        PageBanner(
            title = "Our Company Portfolio",
            image = Res.Image.productBannerImage,
            breakpoint = breakpoint
        )
        ProductDetailComponent(
            product = Product.Kaizen,
            buttonText = "Request for demo",
            breakpoint = breakpoint,
            onButtonClick = {
                context.router.navigateTo("https://www.kaizenproperty.org/broker.kaizenproperty.org/index.php/guest-user-registration.html")
            }
        )
        ProductDetailComponent(
            product = Product.Techno,
            buttonText = "Request for demo",
            breakpoint = breakpoint,
            isRight = true,
            onButtonClick = {
                context.router.navigateTo("https://www.technoproperty.in/contact")
            }
        )
        ProductDetailComponent(
            product = Product.Greenrooms,
            buttonText = "Visit Now",
            breakpoint = breakpoint,
            onButtonClick = {
                context.router.navigateTo("https://greenrooms.in/")
            }
        )
        ProductDetailComponent(
            product = Product.PIG,
            buttonText = "Visit Now",
            isRight = true,
            breakpoint = breakpoint,
            onButtonClick = {
                context.router.navigateTo("https://greenrooms.in/")
            }
        )
        FooterSection(
            breakpoint = breakpoint,
            onLocationClick = {
                context.router.navigateTo(MAP_LINK)
            },
            onEmailClick = {
                context.router.navigateTo(EMAIL_LINK)
            },
            onPhoneClick = {
                context.router.navigateTo(TEL_LINK)
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
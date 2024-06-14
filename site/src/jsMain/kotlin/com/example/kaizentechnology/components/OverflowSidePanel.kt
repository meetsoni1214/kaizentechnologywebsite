package com.example.kaizentechnology.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.example.kaizentechnology.navigation.Screen
import com.example.kaizentechnology.styles.SidePanelNavigationItemStyle
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.example.kaizentechnology.util.Constants.HEADER_HEIGHT
import com.example.kaizentechnology.util.Constants.SIDE_PANEL_WIDTH
import com.example.kaizentechnology.util.Id
import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.Res
import com.example.kaizentechnology.util.logout
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.Svg
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
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.FaXmark
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.shapes.Path
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

@Composable
fun SidePanel(onMenuClick: () -> Unit) {
    val breakpoint = rememberBreakpoint()
    if (breakpoint > Breakpoint.MD) {
        SidePanelInternal()
    } else {
        CollapsedSidePanel(onMenuClick = onMenuClick)
    }
}

@Composable
private fun SidePanelInternal() {
    Column(
        modifier = Modifier
            .backgroundColor(Colors.White)
            .padding(leftRight = 40.px, topBottom = 50.px)
            .width(SIDE_PANEL_WIDTH.px)
            .height(100.vh)
            .position(Position.Fixed)
            .zIndex(9)
    ) {
        Image(
            src = Res.Image.logo,
            description = "Logo Image",
            modifier = Modifier
                .height(50.px)
                .width(120.px)
                .margin(bottom = 60.px)
        )
        NavigationItems()
    }
}

@Composable
fun NavigationItems() {
    val context = rememberPageContext()
    SpanText(
        text = "Dashboard",
        modifier = Modifier
            .fontFamily(FONT_FAMILY)
            .fontSize(14.px)
            .color(JsTheme.HalfBlack.rgb)
            .margin(bottom = 30.px)
    )
    NavigationItem(
        modifier = Modifier.margin(bottom = 24.px),
        title = "Home",
        selected = context.route.path == (Screen.AdminHome.route),
        icon = Res.Path.home,
        onItemClick = {
            context.router.navigateTo(Screen.AdminHome.route)
        }
    )
    NavigationItem(
        modifier = Modifier.margin(bottom = 24.px),
        title = "Inquiries",
        selected = context.route.path == (Screen.AdminInquiries.route),
        icon = Res.Path.inquiries,
        onItemClick = {
            context.router.navigateTo(Screen.AdminInquiries.route)
        }
    )
    NavigationItem(
        title = "Logout",
        icon = Res.Path.logout,
        onItemClick = {
            logout()
            context.router.navigateTo(Screen.AdminLogin.route)
        }
    )
}

@Composable
private fun NavigationItem(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    title: String,
    icon: String,
    onItemClick: () -> Unit
) {
    Row(
        modifier = SidePanelNavigationItemStyle.toModifier()
            .then(modifier)
            .onClick { onItemClick() }
            .cursor(Cursor.Pointer),
        verticalAlignment = Alignment.CenterVertically
    ) {
        VectorIcon(
            modifier = Modifier.margin(right = 10.px),
            pathData = icon,
            selected = selected
        )
        SpanText(
            modifier = Modifier
                .id(Id.navigationText)
                .fontFamily(FONT_FAMILY)
                .fontSize(16.px)
                .thenIf(
                    condition = selected,
                    other = Modifier.color(JsTheme.Primary.rgb)
                ),
            text = title
        )
    }
}

@Composable
private fun VectorIcon(
    modifier: Modifier = Modifier,
    selected: Boolean,
    pathData: String
) {
    Svg(
        attrs = modifier
            .id(Id.svgParent)
            .width(24.px)
            .height(24.px)
            .toAttrs {
                attr("viewBox", "0 0 24 24")
                attr("fill", "none")
            }
    ) {
        Path(
            attrs = Modifier
                .id(Id.vectorIcon)
                .thenIf(
                    condition = selected,
                    other = Modifier.styleModifier {
                        property("stroke", JsTheme.Primary.rgb)
                    }
                )
                .toAttrs {
                    attr("d", pathData)
                    attr("stroke-width", "2")
                    attr("stroke-linecap", "round")
                    attr("stroke-linejoin", "round")
                }
        )
    }
}

@Composable
private fun CollapsedSidePanel(
    onMenuClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.px)
            .padding(leftRight = 24.px)
            .zIndex(9)
            .backgroundColor(Colors.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        FaBars(
            modifier = Modifier
                .margin(right = 24.px)
                .color(Colors.Black)
                .cursor(Cursor.Pointer)
                .onClick { onMenuClick() },
            size = IconSize.XL
        )
        Image(
            src = Res.Image.logo,
            description = "Logo Image",
            modifier = Modifier
                .height(50.px)
                .width(120.px)
        )
    }
}

@Composable
fun OverflowSidePanel(
    onMenuClosed:() -> Unit,
    content:@Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    val breakpoint = rememberBreakpoint()
    val context = rememberPageContext()

    var translateX by remember { mutableStateOf((-100).percent) }
    var opacity by remember { mutableStateOf(0.percent) }
    LaunchedEffect(key1 = breakpoint) {
        translateX = 0.percent
        opacity = 100.percent
        if (breakpoint > Breakpoint.MD) {
            scope.launch { 
                translateX = (-100).percent
                opacity = 0.percent
                delay(500)
                onMenuClosed()
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1000.vh)
            .position(Position.Fixed)
            .zIndex(9)
            .opacity(opacity)
            .transition(CSSTransition(property = "opacity", duration = 300.ms))
            .backgroundColor(JsTheme.HalfBlack.rgb)
    ) { 
        Column(
            modifier = Modifier
                .padding(24.px)
                .backgroundColor(Colors.White)
                .transition(CSSTransition("translate", duration = 300.ms))
                .translateX(translateX)
                .overflow(Overflow.Auto)
                .scrollBehavior(ScrollBehavior.Smooth)
                .fillMaxHeight()
                .width(if(breakpoint < Breakpoint.MD) 50.percent else 25.percent)
        ) {
            Row(
                modifier = Modifier.margin(bottom = 24.px, top = 12.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FaXmark(
                    modifier = Modifier
                        .color(Colors.Black)
                        .margin(right = 20.px)
                        .cursor(Cursor.Pointer)
                        .onClick {
                            scope.launch {
                                translateX = (-100).percent
                                opacity = 0.percent
                                delay(500)
                                onMenuClosed()
                            }
                        },
                    size = IconSize.LG
                )
                Image(
                    src = Res.Image.logo,
                    description = "Logo",
                    modifier = Modifier
                        .cursor(Cursor.Pointer)
                        .onClick {  }
                        .height(50.px)
                        .width(100.px)
                )
            }
            content()
        }

    }

}
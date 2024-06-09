package com.example.kaizentechnology.sections

import androidx.compose.runtime.Composable
import com.example.kaizentechnology.components.NavigationItem
import com.example.kaizentechnology.util.Constants.HEADER_HEIGHT
import com.example.kaizentechnology.util.Constants.PAGE_WIDTH
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun HomePageHeader(
    breakpoint: Breakpoint,
    onMenuOpened: () -> Unit,
    logo: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .backgroundColor(Colors.Transparent)
                .maxWidth(PAGE_WIDTH.px),
            contentAlignment = Alignment.TopStart
        ) {
            Header(
                breakpoint = breakpoint,
                onMenuOpened = onMenuOpened,
                selectedItem = "home",
                logo = logo
            )
        }
    }
}

@Composable
fun Header(
    breakpoint: Breakpoint,
    onMenuOpened: () -> Unit,
    selectedItem: String,
    logo: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(HEADER_HEIGHT.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint <= Breakpoint.MD) {
            FaBars(
                modifier = Modifier
                    .color(Colors.White)
                    .margin(left = 24.px)
                    .cursor(Cursor.Pointer)
                    .onClick { onMenuOpened() },
                size = IconSize.XL
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                src = logo,
                description = "Logo",
                modifier = Modifier
                    .margin(left = if (breakpoint > Breakpoint.SM) 24.px else 4.px)
                    .cursor(Cursor.Pointer)
                    .onClick {  }
                    .height(100.px)
                    .width(200.px)
            )
            if (breakpoint >= Breakpoint.LG) {
                Row(
                    modifier = Modifier.margin(right = 50.px),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NavigationItem(selectedItem = selectedItem)
                }
            }
        }
    }
}
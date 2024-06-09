package com.example.kaizentechnology.components

import androidx.compose.runtime.Composable
import com.example.kaizentechnology.styles.NavigationItemStyle
import com.example.kaizentechnology.styles.NavigationItemStyleSM
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.headerItems
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px

@Composable
fun NavigationItem(
    selectedItem: String = "Home",
    vertical: Boolean = false
) {
//    Row(
//        modifier = Modifier.margin(right = 50.px),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
        headerItems.forEach { item ->
            Link(
                path = "",
                text = item,
                modifier = Modifier
                    .thenIf(
                        condition = !vertical,
                        other = NavigationItemStyle
                            .toModifier()
                            .margin(right = 42.px)
                    )
                    .thenIf(
                        condition = vertical,
                        other = NavigationItemStyleSM
                            .toModifier()
                            .margin(bottom = 24.px)
                    )
                    .thenIf(
                        condition = selectedItem == item,
                        other = Modifier
                            .textDecorationLine(TextDecorationLine.Underline)
                            .color(JsTheme.Primary.rgb)
                    )
                    .fontFamily(FONT_FAMILY)
                    .fontWeight(FontWeight.Bold)
                    .fontSize(20.px)
                    .onClick {  }
            )
        }
    }

//}
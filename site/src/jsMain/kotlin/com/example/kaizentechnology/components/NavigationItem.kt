package com.example.kaizentechnology.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.kaizentechnology.models.HeaderItem
import com.example.kaizentechnology.styles.LinkStyleModifier
import com.example.kaizentechnology.styles.NavigationHomeItemStyle
import com.example.kaizentechnology.styles.NavigationItemStyle
import com.example.kaizentechnology.styles.NavigationItemStyleSM
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.noBorder
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px

@Composable
fun NavigationItem(
    selectedItem: String = "Home",
    vertical: Boolean = false,
    isHomePage: Boolean = true,
    onLinkClick: (String) -> Unit
) {
    println(selectedItem)
    val isHomeAndNotVertical by remember { mutableStateOf((!(vertical) && (isHomePage))) }
    val notHomeAndNotVertical by remember { mutableStateOf((!(vertical) && !(isHomePage))) }
        HeaderItem.entries.forEach { item ->
                    Link(
                        path = "",
                        text = item.itemName,
                        modifier = Modifier
                            .thenIf(
                                condition = isHomeAndNotVertical,
                                other = NavigationHomeItemStyle
                                    .toModifier()
                                    .margin(right = 42.px)
                            )
                            .thenIf(
                                condition = notHomeAndNotVertical,
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
                                condition = (selectedItem == item.itemName),
                                other = Modifier
                                    .textDecorationLine(TextDecorationLine.Underline)
                                    .styleModifier {
                                        property("text-underline-offset", 0.4.em)
                                    }
                                    .color(if (isHomeAndNotVertical) Colors.White else JsTheme.Primary.rgb)
                            )
                            .fontFamily(FONT_FAMILY)
                            .fontWeight(FontWeight.Bold)
                            .fontSize(20.px)
                            .onClick { onLinkClick(item.link) }
                    )

                }
            }
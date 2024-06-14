package com.example.kaizentechnology.pages.admin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.kaizentechnology.components.AdminPageLayout
import com.example.kaizentechnology.components.LoadingIndicator
import com.example.kaizentechnology.models.RandomQuote
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.example.kaizentechnology.util.Constants.SIDE_PANEL_WIDTH
import com.example.kaizentechnology.util.Id
import com.example.kaizentechnology.util.IsUserLoggedIn
import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.fetchRandomQuote
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLInputElement

@Page
@Composable
fun HomePage () {
   IsUserLoggedIn {
       HomeScreen()
   }
}

@Composable
fun HomeScreen() {
    var randomQuote: RandomQuote? by remember { mutableStateOf(null) }
    LaunchedEffect(Unit) {
        fetchRandomQuote { randomQuote = it }
        if (randomQuote != null) {
            println(randomQuote!!.content)
            delay(3000)
            document.getElementById(Id.randomQuote)?.innerHTML = "<em>❞ ${randomQuote!!.content}</em>"
        }
    }
    AdminPageLayout {
        HomeContent(randomQuote = randomQuote)
    }
}

@Composable
fun HomeContent(randomQuote: RandomQuote?) {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .backgroundColor(JsTheme.LighterGray.rgb)
            .padding(
                top = if (breakpoint > Breakpoint.MD) 0.px else 132.px,
                left = if (breakpoint > Breakpoint.MD) SIDE_PANEL_WIDTH.px else 0.px),
        contentAlignment = Alignment.Center
    ) {
        if (randomQuote != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(topBottom = 50.px),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (randomQuote._id != null) {
                    Div(
                        attrs = Modifier
                            .fontFamily(FONT_FAMILY)
                            .fontSize(if (breakpoint > Breakpoint.MD) 28.px else 20.px)
                            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 50.percent else 90.percent)
                            .margin(bottom = 14.px)
                            .textAlign(TextAlign.Center)
                            .fontWeight(FontWeight.SemiBold)
                            .id(Id.randomQuote)
                            .toAttrs()
                    )
                }
            }
        } else {
            LoadingIndicator()
        }
    }
}
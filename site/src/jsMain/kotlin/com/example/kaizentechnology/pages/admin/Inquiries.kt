package com.example.kaizentechnology.pages.admin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.example.kaizentechnology.components.AdminPageLayout
import com.example.kaizentechnology.components.InquiryComponent
import com.example.kaizentechnology.models.ApiListResponse
import com.example.kaizentechnology.models.Inquiry
import com.example.kaizentechnology.pages.TitleText
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.example.kaizentechnology.util.Constants.SIDE_PANEL_WIDTH
import com.example.kaizentechnology.util.IsUserLoggedIn
import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.deleteSelectedInquiries
import com.example.kaizentechnology.util.fetchAllInquiries
import com.example.kaizentechnology.util.noBorder
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.visibility
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.forms.Switch
import com.varabyte.kobweb.silk.components.forms.SwitchSize
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button

@Page
@Composable
fun InquiriesPage() {
    IsUserLoggedIn {
        InquiriesScreen()
    }
}

@Composable
fun InquiriesScreen() {
    AdminPageLayout {
        InquiriesContent()
    }
}

@Composable
fun InquiriesContent() {
    val breakpoint = rememberBreakpoint()
    val inquiries = remember { mutableStateListOf<Inquiry>() }
    var selectableMode by remember { mutableStateOf(false) }
    var switchText by remember { mutableStateOf("Select") }
    val selectedInquiries = remember { mutableStateListOf<String>() }
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        fetchAllInquiries(
            onSuccess = {
                if (it is ApiListResponse.Success) {
                    inquiries.addAll(it.data)
                }
            },
            onError = {
                println(it)
            }
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .backgroundColor(JsTheme.LighterGray.rgb)
            .padding(
                left = if (breakpoint > Breakpoint.MD) SIDE_PANEL_WIDTH.px else 0.px,
                top = if (breakpoint > Breakpoint.MD) 0.px else 100.px
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(90.percent),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .margin(topBottom = 40.px)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TitleText(
                    title = "Contact Inquiries",
                    modifier = Modifier
                )
                Button(
                    attrs = Modifier
                        .onClick {
                            scope.launch {
                                val result = deleteSelectedInquiries(ids = selectedInquiries)
                                if (result) {
                                    selectableMode = false
                                    switchText = "Select"
                                    selectedInquiries.forEach { inquiryId ->
                                        inquiries.removeAll {
                                            it._id == inquiryId
                                        }
                                    }
                                    selectedInquiries.clear()
                                } else {
                                    println(result)
                                }
                            }
                        }
                        .visibility(if (selectedInquiries.isNotEmpty()) Visibility.Visible else Visibility.Hidden)
                        .height(40.px)
                        .backgroundColor(Colors.Red)
                        .noBorder()
                        .padding(leftRight = 24.px, topBottom = 8.px)
                        .cursor(Cursor.Pointer)
                        .toAttrs()
                ) {
                    SpanText(
                        modifier = Modifier
                            .fontSize(18.px)
                            .color(Colors.White)
                            .fontWeight(FontWeight.SemiBold)
                            .fontFamily(FONT_FAMILY),
                        text = "Delete"
                    )
                }
            }
            Row(
                modifier = Modifier
                    .margin(bottom = 40.px)
                    .fillMaxWidth(90.percent),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Switch(
                    modifier = Modifier.margin(right = 8.px),
                    size = SwitchSize.LG,
                    checked = selectableMode,
                    onCheckedChange = {
                        selectableMode = it
                        if (!selectableMode) {
                            switchText = "Select"
                            selectedInquiries.clear()
                        } else {
                            switchText = "${selectedInquiries.size} Inquiries selected"
                        }
                    }
                )
                SpanText(
                    modifier = Modifier
                        .fontFamily(FONT_FAMILY)
                        .color(if (selectableMode) Colors.Black else JsTheme.HalfBlack.rgb),
                    text = switchText
                )
            }
                SimpleGrid(
                    modifier = Modifier.fillMaxWidth(),
                    numColumns = numColumns(base = 1, sm = 2, md = 3, lg = 4)
                ) {
                    inquiries.forEach { inquiry ->
                        InquiryComponent(
                            inquiry = inquiry,
                            breakpoint = breakpoint,
                            selectableMode = selectableMode,
                            onDeleteClick = {
                                scope.launch {
                                    val result = deleteSelectedInquiries(listOf(it))
                                    if (result) {
                                        inquiries.removeAll { inquiry ->
                                            inquiry._id == it
                                        }
                                    } else {
                                        println(result)
                                    }
                                }
                            },
                            onSelect = {
                                selectedInquiries.add(it)
                                switchText = "${selectedInquiries.size} Inquiries Selected"
                            },
                            onDeselect = {
                                selectedInquiries.remove(it)
                                switchText = "${selectedInquiries.size} Inquiries selected"
                            }
                        )
                    }
                }
            }
        }
    }

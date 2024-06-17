package com.example.kaizentechnology.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.kaizentechnology.models.Inquiry
import com.example.kaizentechnology.styles.InquiryStyle
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.parseDate
import com.example.kaizentechnology.util.parseDateString
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextOverflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textOverflow
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaTrashCan
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.CheckboxInput

@Composable
fun InquiryComponent (
    inquiry: Inquiry,
    breakpoint: Breakpoint,
    selectableMode: Boolean = false,
    onSelect: (String) -> Unit = {},
    onDeleteClick: (String) -> Unit = {},
    onDeselect: (String) -> Unit = {}
) {
    var checked by remember(selectableMode) { mutableStateOf(false) }
    Column(
        modifier = InquiryStyle.toModifier()
//            .fillMaxWidth(90.percent)
            .width(if (breakpoint > Breakpoint.MD) 270.px else 300.px)
            .margin(bottom = 24.px)
            .backgroundColor(Colors.White)
            .onClick {
                if (selectableMode) {
                    checked = !checked
                    if (checked) {
                        onSelect(inquiry._id)
                    } else {
                        onDeselect(inquiry._id)
                    }
                }
            }
            .cursor(Cursor.Pointer)
            .padding(12.px),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .margin(bottom = 12.px)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SpanText(
                text = inquiry.date.toLong().parseDate(),
                modifier = Modifier
                    .fontFamily(FONT_FAMILY)
                    .color(JsTheme.HalfBlack.rgb)
                    .fontWeight(FontWeight.Medium)
                    .fontSize(16.px)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (selectableMode) {
                    CheckboxInput(
                        checked = checked,
                        attrs = Modifier
                            .size(20.px)
                            .margin(right = 12.px)
                            .toAttrs()
                    )
                }
                FaTrashCan(
                    modifier = Modifier
                        .cursor(Cursor.Pointer)
                        .onClick { onDeleteClick(inquiry._id) }
                        .color(Colors.Red),
                    size = IconSize.XL
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            InquiryTextAndValue(text = "First Name:", value = inquiry.firstName)
            InquiryTextAndValue(text = "Last Name:", value = inquiry.lastName)
            InquiryTextAndValue(text = "Mobile:", value = inquiry.mobile)
            InquiryTextAndValue(text = "Email:", value = inquiry.email)
            InquiryTextAndValue(text = "Message:", value = inquiry.message)
        }
    }
}

@Composable
fun InquiryTextAndValue(
    text: String,
    value: String
) {
    Row(
        modifier = Modifier
            .margin(bottom = 12.px)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SpanText(
            text = text,
            modifier = Modifier
                .fontFamily(FONT_FAMILY)
                .fontWeight(FontWeight.SemiBold)
                .color(JsTheme.Primary.rgb)
                .fillMaxWidth(if (text == "Message") 40.percent else 50.percent)
                .fontSize(16.px)
        )
        SpanText(
            text = value,
            modifier = Modifier
                .margin(right = 8.px)
                .fontFamily(FONT_FAMILY)
                .fontWeight(FontWeight.Medium)
                .fillMaxWidth(if (text == "Message") 60.percent else 50.percent)
                .fontSize(16.px)
                .styleModifier {
                    property("display", "-webkit-box")
                    property("-webkit-line-clamp", "4")
                    property("line-clamp", "4")
                    property("-webkit-box-orient", "vertical")
                    property("overflow-wrap", "break-word")
                }
        )
    }
}
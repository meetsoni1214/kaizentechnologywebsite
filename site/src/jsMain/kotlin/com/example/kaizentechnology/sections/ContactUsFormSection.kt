package com.example.kaizentechnology.sections

import androidx.compose.runtime.Composable
import com.example.kaizentechnology.models.Product
import com.example.kaizentechnology.styles.ContactUsButtonStyle
import com.example.kaizentechnology.styles.GreenroomsButtonStyle
import com.example.kaizentechnology.styles.InputTextFieldStyle
import com.example.kaizentechnology.styles.KaizenButtonStyle
import com.example.kaizentechnology.styles.PIGButtonStyle
import com.example.kaizentechnology.styles.TechnoButtonStyle
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.example.kaizentechnology.util.Id
import com.example.kaizentechnology.util.JsTheme
import com.example.kaizentechnology.util.Res
import com.example.kaizentechnology.util.noBorder
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.outline
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.TextArea

@Composable
fun ContactUsFormSection(
    breakpoint: Breakpoint,
    onClick: () -> Unit
) {
    if (breakpoint > Breakpoint.MD) {
        Row(
            modifier = Modifier
                .fillMaxWidth(90.percent)
                .margin(bottom = 20.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ContactUsVectorImage(
                modifier = Modifier
                    .margin(right = 40.px)
            )
            InputTextFields(
                breakpoint = breakpoint,
                onClick = onClick
            )
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth(90.percent)
                .margin(bottom = 32.px),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContactUsVectorImage(
                modifier = Modifier
                    .width(340.px)
                    .height(330.px)
            )
            InputTextFields(
                breakpoint = breakpoint,
                onClick = onClick
            )
        }
    }
}

@Composable
fun InputTextFields(
    breakpoint: Breakpoint,
    onClick: () -> Unit
) {
    Column() {
        SpanText(
            text = "Any Queries? Feel free to ask",
            modifier = Modifier
                .fontFamily(FONT_FAMILY)
                .fontSize(24.px)
                .fontWeight(FontWeight.SemiBold)
                .margin(bottom = 24.px)
                .styleModifier {
                    property("display", "-webkit-box")
                    property("-webkit-line-clamp", "2")
                    property("line-clamp", "2")
                    property("-webkit-box-orient", "vertical")
                }
        )
        if (breakpoint > Breakpoint.MD) {
            Row(
                modifier = Modifier
                    .margin(bottom = 24.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                NameInputFields(
                    modifier = Modifier
                        .margin(right = 24.px)
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .margin(bottom = 24.px),
            ) {
                NameInputFields(
                    modifier = Modifier
                        .margin(bottom = 24.px)
                )
            }
        }

        Input(
            type = InputType.Number,
            attrs = InputTextFieldStyle.toModifier()
//                    .fillMaxWidth()
                .height(54.px)
                    .id(Id.mobileInput)
                .margin(bottom = 24.px)
                .padding(leftRight = 20.px)
                .backgroundColor(JsTheme.LightGray.rgb)
                .borderRadius(r = 8.px)
                .fontFamily(FONT_FAMILY)
                .outline(
                    width = 0.px,
                    style = LineStyle.None,
                    color = Colors.Transparent
                )
                .fontSize(16.px)
                .toAttrs {
                    attr("placeholder", "Mobile Number")
                    attr("minlength", "10")
                    attr("maxlength", "10")
//                        attr("value", uiState.title)
                }
        )
        Input(
            type = InputType.Email,
            attrs = InputTextFieldStyle.toModifier()
//                    .fillMaxWidth()
                .height(54.px)
                    .id(Id.emailInput)
                .margin(bottom = 24.px)
                .padding(leftRight = 20.px)
                .backgroundColor(JsTheme.LightGray.rgb)
                .borderRadius(r = 8.px)
                .fontFamily(FONT_FAMILY)
                .outline(
                    width = 0.px,
                    style = LineStyle.None,
                    color = Colors.Transparent
                )
                .fontSize(16.px)
                .toAttrs {
                    attr("placeholder", "Email")
//                        attr("value", uiState.title)
                }
        )
        TextArea(
            attrs = InputTextFieldStyle.toModifier()
//                    .fillMaxWidth()
                .height(150.px)
                .width(300.px)
                    .id(Id.messageInput)
                .margin(bottom = 24.px)
                .padding(leftRight = 20.px, top = 20.px)
                .backgroundColor(JsTheme.LightGray.rgb)
                .borderRadius(r = 8.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(16.px)
                .outline(
                    width = 0.px,
                    style = LineStyle.None,
                    color = Colors.Transparent
                )
                .toAttrs {
                    attr("placeholder", "How can we help ?")
//                        attr("value", uiState.title)
                }
        )
        Button(
            attrs = ContactUsButtonStyle.toModifier()
                .onClick {
                    onClick()
                }
                .height(40.px)
                .padding(leftRight = 24.px, topBottom = 8.px)
                .cursor(Cursor.Pointer)
                .toAttrs()
        ) {
            SpanText(
                modifier = Modifier
                    .fontSize(18.px)
                    .fontWeight(FontWeight.SemiBold)
                    .fontFamily(FONT_FAMILY),
                text = "Submit"
            )
        }
    }
}

@Composable
fun NameInputFields(
    modifier: Modifier = Modifier
) {
    Input(
        type = InputType.Text,
        attrs = InputTextFieldStyle.toModifier()
            .then(modifier)
//                    .fillMaxWidth()
            .height(54.px)
                    .id(Id.firstNameInput)
            .padding(leftRight = 20.px)
            .backgroundColor(JsTheme.LightGray.rgb)
            .borderRadius(r = 8.px)
            .outline(
                width = 0.px,
                style = LineStyle.None,
                color = Colors.Transparent
            )
            .fontFamily(FONT_FAMILY)
            .fontSize(16.px)
            .toAttrs {
                attr("placeholder", "First Name")
//                        attr("value", uiState.title)
            }
    )
    Input(
        type = InputType.Text,
        attrs = InputTextFieldStyle.toModifier()
//                    .fillMaxWidth()
            .height(54.px)
                    .id(Id.lastNameInput)
            .margin(right = 24.px)
            .outline(
                width = 0.px,
                style = LineStyle.None,
                color = Colors.Transparent
            )
            .padding(leftRight = 20.px)
            .backgroundColor(JsTheme.LightGray.rgb)
            .borderRadius(r = 8.px)
            .fontFamily(FONT_FAMILY)
            .fontSize(16.px)
            .toAttrs {
                attr("placeholder", "Last Name")
//                        attr("value", uiState.title)
            }
    )
}

@Composable
fun ContactUsVectorImage(
    modifier: Modifier
) {
    Image(
        src = Res.Image.contactVectorImage,
        description = "Contact Us Vector",
        modifier = modifier
    )
}
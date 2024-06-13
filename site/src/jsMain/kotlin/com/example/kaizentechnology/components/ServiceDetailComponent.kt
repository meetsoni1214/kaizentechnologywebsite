package com.example.kaizentechnology.components

import androidx.compose.runtime.Composable
import com.example.kaizentechnology.models.DynamicService
import com.example.kaizentechnology.styles.DynamicServiceChipStyle
import com.example.kaizentechnology.util.Constants.FONT_FAMILY
import com.example.kaizentechnology.util.JsTheme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ServiceDetailComponent(
    serviceTitle: String,
    serviceImage: String,
    serviceDesc: String,
    breakpoint: Breakpoint
) {
    if (breakpoint > Breakpoint.MD) {
        Row(
            modifier = Modifier
                .padding(32.px)
                .backgroundColor(JsTheme.LightGray.rgb)
                .margin(bottom = 32.px)
                .borderRadius(30.px)
                .fillMaxWidth(90.percent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                ServiceTitle(
                    serviceTitle = serviceTitle,
                    modifier = Modifier
                        .margin(bottom = 24.px)
                        .fontSize(38.px)
                )
                ServiceDesc(
                    serviceDesc = serviceDesc,
                    modifier = Modifier
                        .fontSize(20.px)
                )
            }
            ServiceImage(
                img = serviceImage,
                modifier = Modifier
                    .height(280.px)
                    .width(380.px)
                    .margin(left = 40.px))
        }
    } else {
        Column(
            modifier = Modifier
                .padding(32.px)
                .backgroundColor(JsTheme.LightGray.rgb)
                .margin(bottom = 32.px)
                .borderRadius(30.px)
                .fillMaxWidth(90.percent),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ServiceImage(
                img = serviceImage,
                modifier = Modifier
                    .height(176.px)
                    .width(266.px)
                    .margin(bottom = 32.px)
            )
            ServiceTitle(
                serviceTitle = serviceTitle,
                modifier = Modifier
                    .fontSize(32.px)
                    .margin(bottom = 24.px)
                    .fillMaxWidth()
            )
            ServiceDesc(
                serviceDesc = serviceDesc,
                modifier = Modifier
                    .fontSize(16.px)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun DynamicServiceComponent(
    breakpoint: Breakpoint,
    serviceTitle: String,
    onClick: (DynamicService) -> Unit,
    dynamicService: DynamicService
) {
    println(dynamicService.name)
    if (breakpoint > Breakpoint.MD) {
        Row(
            modifier = Modifier
                .padding(32.px)
                .backgroundColor(JsTheme.LightGray.rgb)
                .margin(bottom = 32.px)
                .borderRadius(30.px)
                .fillMaxWidth(90.percent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                ServiceTitle(
                    serviceTitle = serviceTitle,
                    modifier = Modifier
                        .margin(bottom = 24.px)
                        .fontSize(38.px)
                )
                Row(
                    modifier = Modifier
                        .borderRadius(75.px)
                        .margin(bottom = 18.px)
                        .height(60.px)
                        .cursor(Cursor.Pointer)
                        .backgroundColor(Colors.White),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ServiceChip(isMD = false, isActive = (dynamicService.title == DynamicService.ForPropertyOwner.title), serviceTitle = DynamicService.ForPropertyOwner.title, onClick = onClick)
                    ServiceChip(isMD = false, isActive = (dynamicService.title == DynamicService.ForRealEstateConsultant.title), serviceTitle = DynamicService.ForRealEstateConsultant.title, onClick = onClick)
                    ServiceChip(isMD = false, isActive = (dynamicService.title == DynamicService.ForPGSeeker.title), serviceTitle = DynamicService.ForPGSeeker.title, onClick = onClick)
                    ServiceChip(isMD = false, isActive = (dynamicService.title == DynamicService.ForPGOwner.title), serviceTitle = DynamicService.ForPGOwner.title, onClick = onClick)
                }
                ServiceDesc(
                    serviceDesc = dynamicService.desc,
                    modifier = Modifier
                        .fontSize(20.px)
                )
            }
            ServiceImage(
                img = dynamicService.img,
                modifier = Modifier
                    .height(280.px)
                    .width(380.px)
                    .margin(left = 40.px))
        }
    } else {
        Column(
            modifier = Modifier
                .padding(32.px)
                .backgroundColor(JsTheme.LightGray.rgb)
                .margin(bottom = 32.px)
                .borderRadius(30.px)
                .fillMaxWidth(90.percent),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ServiceImage(
                img = dynamicService.img,
                modifier = Modifier
                    .height(176.px)
                    .width(266.px)
                    .margin(bottom = 32.px)
            )
            ServiceTitle(
                serviceTitle = serviceTitle,
                modifier = Modifier
                    .margin(bottom = 24.px)
                    .fontSize(32.px)
                    .fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .borderRadius(75.px)
                    .margin(bottom = 18.px)
                    .cursor(Cursor.Pointer)
                    .backgroundColor(Colors.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ServiceChip(isMD = true, isActive = (dynamicService.title == "For Property Owner"), serviceTitle = "For Property Owner", onClick = onClick)
                ServiceChip(isMD = true, isActive = (dynamicService.title == "For Real Estate Consultant"), serviceTitle = "For Real Estate Consultant", onClick = onClick)
                ServiceChip(isMD = true, isActive = (dynamicService.title == "For PG Seeker"), serviceTitle = "For PG Seeker", onClick = onClick)
                ServiceChip(isMD = true, isActive = (dynamicService.title == "For PG Owner"), serviceTitle = "For PG Owner", onClick = onClick)
            }
            ServiceDesc(
                serviceDesc = dynamicService.desc,
                modifier = Modifier
                    .fontSize(16.px)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun ServiceTitle(
    serviceTitle: String,
    modifier: Modifier
) {
    SpanText(
        text = serviceTitle,
        modifier = modifier
            .fontFamily(FONT_FAMILY)
            .color(JsTheme.Primary.rgb)
            .fontWeight(FontWeight.SemiBold)
            .styleModifier {
                property("display", "-webkit-box")
                property("-webkit-line-clamp", "2")
                property("line-clamp", "2")
                property("-webkit-box-orient", "vertical")
            }
    )
}

@Composable
fun ServiceDesc(
    serviceDesc: String,
    modifier: Modifier
) {
    SpanText(
        text = serviceDesc,
        modifier = modifier
            .fontFamily(FONT_FAMILY)
            .fontWeight(FontWeight.Medium)
            .styleModifier {
                property("display", "-webkit-box")
                property("-webkit-line-clamp", "18")
                property("line-clamp", "18")
                property("-webkit-box-orient", "vertical")
            }
    )
}

@Composable
fun ServiceImage(
    img: String,
    modifier: Modifier
) {
    Image(
        src = img,
        description = "Service Image",
        modifier = modifier
    )
}

@Composable
fun ServiceChip(
    isActive: Boolean,
    serviceTitle: String,
    isMD: Boolean,
    onClick: (DynamicService) -> Unit
) {
    Box(
        modifier = DynamicServiceChipStyle.toModifier()
            .backgroundColor(if (isActive) JsTheme.Primary.rgb else Colors.White)
            .borderRadius(75.px)
            .padding(12.px)
            .fillMaxHeight()
            .fillMaxWidth(25.percent)
            .onClick { onClick(DynamicService.valueOf(serviceTitle.replace(" ", ""))) },
        contentAlignment = Alignment.Center
    ) {
        SpanText(
            text = serviceTitle,
            modifier = Modifier
                .fontFamily(FONT_FAMILY)
                .textAlign(TextAlign.Center)
                .fontSize(if (isMD) 10.px else 14.px)
                .fontWeight(FontWeight.Medium)
                .styleModifier {
                    property("display", "inline-block")
                    property("-webkit-line-clamp", "3")
                    property("line-clamp", "3")
                    property("-webkit-box-orient", "vertical")
                }
                .color(if (isActive) Colors.White else Colors.Black)
        )
    }
}
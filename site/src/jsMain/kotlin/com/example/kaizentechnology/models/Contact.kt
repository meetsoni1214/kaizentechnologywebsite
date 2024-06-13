package com.example.kaizentechnology.models

import com.example.kaizentechnology.util.Res

enum class Contact(
    val icon: String,
    val title: String,
    val body: String,
    val link: String
) {
    Call(
        icon = Res.Image.callIcon,
        title = "Give Us a Call",
        body = "+91 7046327745",
        link = "tel:7046327745"
    ),
    Chat(
        icon = Res.Image.chatIcon,
        title = "Chat with us",
        body = "+91 7046327745",
        link = "https://api.whatsapp.com/send/?phone=917046327745"
    ),
    Email(
        icon = Res.Image.mailIcon,
        title = "Email us",
        body = "support@kaizentechnology.org.in",
        link = "mailto:support@kaizentechnology.org.in"
    )
}
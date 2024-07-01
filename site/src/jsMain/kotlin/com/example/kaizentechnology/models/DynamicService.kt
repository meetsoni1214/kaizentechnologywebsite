package com.example.kaizentechnology.models

import com.example.kaizentechnology.util.Res

enum class DynamicService(
    val title: String,
    val desc: String,
    val img: String
) {
    ForPropertyOwner(
        title = "For Property Owner",
        desc = "If you are a property owner, Kaizen Technology Services makes it easy to rent out or sell your property quickly. With our Techno Property Software, you can post your property online, reaching around 1,000 brokers in Ahmedabad West, significantly increasing the chances of a quick transaction. Whether you are looking to rent out or sell, our comprehensive services support you throughout the process, making property management seamless and stress-free.",
        img = Res.Image.serviceImage
    ),
    ForRealEstateConsultant(
        title = "For Real Estate Consultant",
        desc = "If you are a real estate consultant, our products are like oxygen for you. With Techno Property, you gain access to a vast database of properties owned by individuals, enabling you to serve your clients quickly and efficiently. Additionally, if your client is a property owner, Kaizen Property Group allows you to easily close deals by connecting with other brokers whose clients have similar property requirements.",
        img = Res.Image.solutionRealEstateConsultant
    ),
    ForPGSeeker(
        title = "For PG Seeker",
        desc = "If you are a PG Seeker than Greenrooms is a one stop destination for all your accommodation needs. Our administrative staff coordinates with you and guides you on how to find the right accommodation using Greenrooms. We also provide suggestions on which option is most appropriate according to your requirements. As a PG seeker, with Greenrooms, there's no need to waste time finding the best accommodation for yourself.",
        img = Res.Image.solutionPGSeeker
    ),
    ForPGOwner(
        title = "For PG Owner",
        desc = "If you are a PG Owner than Greenrooms is the best way to get your customers. Greenrooms provide services like property management, property promotion, and software support you will have access to your own dashboard for efficiently managing PG room availability. With Greenrooms it is our responsibility to get your PG filled in the least amount of time. With zero listing charges on our platform you can get started as quickly as possible.",
        img = Res.Image.solutionPGOwner
    )
}
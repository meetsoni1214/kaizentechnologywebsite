package com.example.kaizentechnology.api

import com.example.kaizentechnology.data.MongoDB
import com.example.kaizentechnology.models.ApiListResponse
import com.example.kaizentechnology.models.Inquiry
import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.data.getValue
import com.varabyte.kobweb.api.http.Request
import com.varabyte.kobweb.api.http.Response
import com.varabyte.kobweb.api.http.setBodyText
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.bson.codecs.ObjectIdGenerator

@Api(routeOverride = "addinquiry")
suspend fun addInquiry(context: ApiContext) {
    try {
        val inquiry = context.req.getBody<Inquiry>()
        val newInquiry = inquiry?.copy(_id = ObjectIdGenerator().generate().toString())
        context.res.setBody(newInquiry?.let { context.data.getValue<MongoDB>().addInquiry(it) })
    } catch (e: Exception) {
        context.logger.error("API Exception: $e")
        context.res.setBody(e.message)
    }
}

@Api(routeOverride = "fetchallinquiries")
suspend fun fetchAllInquiries(context: ApiContext) {
    try {
        val inquiries = context.data.getValue<MongoDB>().fetchAllInquiries()
        context.res.setBody(ApiListResponse.Success(data = inquiries))
    } catch (e: Exception) {
        context.res.setBody(e.message)
    }
}

@Api(routeOverride = "deleteselectedinquiries")
suspend fun deleteSelectedPosts(context: ApiContext) {
    try {
        val request = context.req.getBody<List<String>>()
        context.res.setBody(request?.let {
            context.data.getValue<MongoDB>().deleteSelectedPosts(it)
        })
    } catch (e: Exception) {
        context.res.setBody(e.message)
    }
}

inline fun <reified T> Response.setBody(data: T) {
    setBodyText(Json.encodeToString(data))
}
inline fun <reified T> Request.getBody(): T? {
    return body?.decodeToString()?.let { return Json.decodeFromString(it) }
}
package com.example.kaizentechnology.util

import com.example.kaizentechnology.models.ApiListResponse
import com.example.kaizentechnology.models.Inquiry
import com.example.kaizentechnology.models.RandomQuote
import com.example.kaizentechnology.models.User
import com.example.kaizentechnology.models.UserWithoutPassword
import com.example.kaizentechnology.util.Constants.QUOTES_API_URL
import com.varabyte.kobweb.browser.api
import com.varabyte.kobweb.browser.http.http
import kotlinx.browser.localStorage
import kotlinx.browser.window
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import org.w3c.dom.get
import org.w3c.dom.set
import kotlin.js.Date

suspend fun checkUserExistence(user: User): UserWithoutPassword? {
    return try {
        window.api.tryPost(
            apiPath = "usercheck",
            body = Json.encodeToString(user).encodeToByteArray()
        )?.decodeToString().parseData()
    } catch (e: Exception) {
        println(e.message)
        null
    }
}

suspend fun checkUserId(id: String): Boolean {
    return try {
        val result = window.api.tryPost(
            apiPath = "checkuserid",
            body = Json.encodeToString(id).encodeToByteArray()
        )
        result?.decodeToString().parseData()
    } catch (e: Exception) {
        println(e.message)
        false
    }
}

suspend fun fetchRandomQuote(onComplete: (RandomQuote) -> Unit) {
    val date = localStorage["date"]
    if (date != null) {
        val difference = (Date.now() - date.toDouble())
        val dayHasPassed = (difference >= 86400000)
        if (dayHasPassed) {
            try {
                val result = window.http.get(QUOTES_API_URL).decodeToString()
                onComplete(result.parseData())
                localStorage["date"] = Date.now().toString()
                localStorage["quote"] = result
            } catch (e: Exception) {
                onComplete(RandomQuote(_id = null, content = e.message.toString()))
                println(e.message)
            }
        } else {
            try {
                localStorage["quote"]?.let { onComplete(it.parseData()) }
            } catch (e: Exception) {
                onComplete(RandomQuote(_id = null, content = e.message.toString()))
                println(e.message)
            }
        }
    } else {
        try {
            val result = window.http.get(QUOTES_API_URL).decodeToString()
            onComplete(result.parseData())
            localStorage["date"] = Date.now().toString()
            localStorage["quote"] = result
        } catch (e: Exception) {
            onComplete(RandomQuote(_id = null, content = e.message.toString()))
            println(e.message)
        }
    }
}

suspend fun addInquiry(inquiry: Inquiry): Boolean {
    return try {
        window.api.tryPost(
            apiPath = "addinquiry",
            body = Json.encodeToString(inquiry).encodeToByteArray()
        )?.decodeToString().toBoolean()
    } catch (e: Exception) {
        println(e.message.toString())
        false
    }
}

suspend fun fetchAllInquiries(
    onSuccess: (ApiListResponse) -> Unit,
    onError: (Exception) -> Unit
) {
    try {
        val result = window.api.tryGet(
            apiPath = "fetchallinquiries"
        )?.decodeToString()
        onSuccess(result.parseData())
    } catch (e: Exception) {
        println(e)
        onError(e)
    }
}

suspend fun deleteSelectedInquiries(ids: List<String>): Boolean {
    return try {
        val result = window.api.tryPost(
            apiPath = "deleteselectedinquiries",
            body = Json.encodeToString(ids).encodeToByteArray()
        )?.decodeToString()
        result.toBoolean()
    } catch (e: Exception) {
        println(e.message.toString())
        false
    }
}
inline fun <reified T> String?.parseData(): T {
    return Json.decodeFromString(this.toString())
}

package com.example.kaizentechnology.data

import com.example.kaizentechnology.models.Inquiry
import com.example.kaizentechnology.models.User
import com.example.kaizentechnology.util.Constants.DATABASE_NAME
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Indexes.descending
import com.mongodb.kotlin.client.coroutine.MongoClient
import com.varabyte.kobweb.api.data.add
import com.varabyte.kobweb.api.init.InitApi
import com.varabyte.kobweb.api.init.InitApiContext
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.toList

@InitApi
fun initMongoDB(context: InitApiContext) {
    System.setProperty(
        "org.litote.mongo.test.mapping.service",
        "org.litote.kmongo.serialization.SerializationClassMappingTypeService"
    )
//    System.getenv().forEach { (key, value) ->
//        if (key != null && key == "MONGODB_URI") {
//            context.data.add(MongoDB(context))
//        }
//    }
    context.data.add(MongoDB(context))
}

class MongoDB(private val context: InitApiContext): MongoRepository {
    private val client = MongoClient.create(System.getenv("MONGODB_URI"))
    private val database = client.getDatabase(DATABASE_NAME)
    private val userCollection = database.getCollection<User>("user")
    private val inquiryCollection = database.getCollection<Inquiry>("inquiry")
    override suspend fun checkUserExistence(user: User): User? {
        return try {
            userCollection.
                    find(
                        Filters.and(
                            Filters.eq(User::username.name, user.username),
                            Filters.eq(User::password.name, user.password)
                        )
                    ).firstOrNull()
        } catch (e: Exception) {
            context.logger.error(e.message.toString())
            null
        }
    }

    override suspend fun checkUserId(id: String): Boolean {
        return try {
            val documentCount = userCollection.countDocuments(Filters.eq(User::_id.name, id))
            documentCount > 0
        } catch (e: Exception) {
            context.logger.error(e.message.toString())
            false
        }
    }

    override suspend fun addInquiry(inquiry: Inquiry): Boolean {
        return inquiryCollection.insertOne(inquiry).wasAcknowledged()
    }

    override suspend fun fetchAllInquiries(): List<Inquiry> {
        return inquiryCollection
            .withDocumentClass(Inquiry::class.java)
            .find()
            .sort(descending(Inquiry::date.name))
            .toList()
    }

    override suspend fun deleteSelectedPosts(ids: List<String>): Boolean {
        return inquiryCollection
            .deleteMany(Filters. `in` (Inquiry::_id.name, ids))
            .wasAcknowledged()
    }
}
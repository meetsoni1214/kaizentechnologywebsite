package com.example.kaizentechnology.data

import com.example.kaizentechnology.models.Inquiry
import com.example.kaizentechnology.models.User

interface MongoRepository {
    suspend fun checkUserExistence(user: User): User?
    suspend fun checkUserId(id: String): Boolean
    suspend fun addInquiry(inquiry: Inquiry): Boolean
    suspend fun fetchAllInquiries(): List<Inquiry>
    suspend fun deleteSelectedPosts(ids: List<String>): Boolean
}
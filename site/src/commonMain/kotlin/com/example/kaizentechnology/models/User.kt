package com.example.kaizentechnology.models

expect class User {
    val _id: String
    val username: String
    val password: String
}

expect class UserWithoutPassword {
    val _id: String
    val username: String
}
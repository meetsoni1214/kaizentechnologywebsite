package com.example.kaizentechnology.models

import com.example.kaizentechnology.util.Res

enum class Service(
    val logo: String,
    val serviceName: String
) {
    DatabaseAggregator(Res.Image.databaseAggregator, "Database Aggregator"),
    AdminSupport(Res.Image.adminSupport, "Admin Support"),
    SolutionProvider(Res.Image.lockKey, "Solution Provider"),
}
package com.example.kaizentechnology.util
import java.util.Calendar
object Constants {
    const val DATABASE_NAME = "kaizen_technology"
    private val calendar = Calendar.getInstance()
    val currentYear = calendar.get(Calendar.YEAR)
}
package com.android.uniassist.data

data class User(
    val userName: String,
    val fToken: String,
    val name: String,
    val userNumber: Long,
    val email: String,
    val degree: String,
    val term: String,
    val year: String,
    val courseList: List<String>,
    val countryList: List<String>,
    val applications: List<Long>,
    val files: List<Long>
)

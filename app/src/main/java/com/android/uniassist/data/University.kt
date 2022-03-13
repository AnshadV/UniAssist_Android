package com.android.uniassist.data

data class University(
    val uniID: Long,
    val uniName: String,
    val country: String,
    val city: String,
    val faculties: List<String>,
    val course: List<Course>

)

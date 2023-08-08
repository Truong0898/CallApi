package com.example.callapi.data.entity

import com.squareup.moshi.Json

data class API(
    @Json(name = "entries") val entries : List<Entry>,
    @Json(name = "count") val count: Int
)
data class Entry(
    @Json(name = "API") val API: String,
    @Json(name = "Description") val Description: String,
    @Json(name = "Auth") val Auth: String,
    @Json(name = "HTTPS") val HTTPS: Boolean,
    @Json(name = "Cors") val Cors: String,
    @Json(name = "Link") val Link: String,
    @Json(name = "Category") val Category: String
)
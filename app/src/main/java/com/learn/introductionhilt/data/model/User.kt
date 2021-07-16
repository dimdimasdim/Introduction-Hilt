package com.learn.introductionhilt.data.model

import com.squareup.moshi.Json

/**
 * Created by Dimas Prakoso on 7/16/21 4:14 PM.
 * Email: dimas.prakoso95@gmail.com
 */
data class User(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "email")
    val email: String = "",
    @Json(name = "avatar")
    val avatar: String = ""
)
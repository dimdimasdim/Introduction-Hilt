package com.learn.introductionhilt.data.api

import com.learn.introductionhilt.data.model.User
import retrofit2.Response

/**
 * Created by Dimas Prakoso on 7/16/21 4:13 PM.
 * Email: dimas.prakoso95@gmail.com
 */
interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>

}
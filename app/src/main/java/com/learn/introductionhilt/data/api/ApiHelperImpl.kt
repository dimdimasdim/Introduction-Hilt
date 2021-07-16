package com.learn.introductionhilt.data.api

import com.learn.introductionhilt.data.model.User
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Dimas Prakoso on 7/16/21 4:13 PM.
 * Email: dimas.prakoso95@gmail.com
 */
class ApiHelperImpl @Inject constructor(private val apiService: ApiService): ApiHelper {

    override suspend fun getUsers(): Response<List<User>> {
        return apiService.getUsers()
    }


}
package com.learn.introductionhilt.data

import com.learn.introductionhilt.data.api.ApiHelper
import javax.inject.Inject

/**
 * Created by Dimas Prakoso on 7/16/21 4:14 PM.
 * Email: dimas.prakoso95@gmail.com
 */
class UserRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()

}
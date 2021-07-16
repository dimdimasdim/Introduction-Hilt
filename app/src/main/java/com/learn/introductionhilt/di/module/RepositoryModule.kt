package com.learn.introductionhilt.di.module

import com.learn.introductionhilt.data.api.ApiHelper
import com.learn.introductionhilt.data.api.ApiHelperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Dimas Prakoso on 7/16/21 9:35 PM.
 * Email: dimas.prakoso95@gmail.com
 */

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindApiHelperImpl(impl: ApiHelperImpl): ApiHelper

}
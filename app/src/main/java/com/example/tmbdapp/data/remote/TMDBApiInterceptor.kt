package com.example.tmbdapp.data.remote

import com.example.tmbdapp.core.utils.addTMDBKeys
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TMDBApiInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().addTMDBKeys()
        return chain.proceed(request)
    }
}
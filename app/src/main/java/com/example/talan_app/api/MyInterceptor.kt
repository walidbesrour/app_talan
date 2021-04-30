package com.example.talan_app.api

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
                .newBuilder()
                .addHeader("Content-Type","application/json")
//                .addHeader("MAXAUTH","Qi5XQUxJRDpXYjEyMzQ1Njs=")
                .build()
        return chain.proceed(request)
    }

}
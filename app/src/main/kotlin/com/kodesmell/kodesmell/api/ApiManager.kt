package com.kodesmell.kodesmell.api

import com.apollographql.apollo.ApolloClient
import com.kodesmell.kodesmell.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by sangcomz on 12/08/2017.
 */

// ;) API ApiManager 코드 정리 (#076e20d)
class ApiManager {

    private val BASE_URL = BuildConfig.API_URL
    
    fun getClient(): ApolloClient = ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(getOkHttpClient())
            .build()

    private fun getOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor { chain ->
            val builder = chain
                    .request()
                    .newBuilder()
            chain.proceed(builder.build())
        }

        if (BuildConfig.DEBUG) {
            builder
                    .addInterceptor(HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY))
        }

        return builder.build()
    }
}
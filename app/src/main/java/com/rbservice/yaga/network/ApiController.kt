package com.rbservice.yaga.network

import okhttp3.Dispatcher
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiController {
    companion object {
        private const val TIME_OUT: Long = 30
        fun getService(): ApiService {
            val url = "https://yaga.rbpessacash.com"
            val builder = okhttp3.OkHttpClient.Builder()

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logging)

            val dispatcher = Dispatcher()
            dispatcher.maxRequests = 1
            val okHttpClient = builder
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .dispatcher(dispatcher).build()

            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}

package com.example.challenge2useacademy.movies

import com.example.challenge2useacademy.GlobalVariables
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesAPI {

    companion object {
        private lateinit var retrofit: Retrofit

        private var base_url = "https://imdb-api.com/en/"

        fun getRetrofit(): Retrofit {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient = OkHttpClient().newBuilder().addInterceptor(interceptor)

            if (!::retrofit.isInitialized) {

                retrofit = Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient.build())
                    .build()

            }
            return retrofit
        }
    }

    fun <S> createService(service: Class<S>): S {
        return getRetrofit().create(service)
    }

}
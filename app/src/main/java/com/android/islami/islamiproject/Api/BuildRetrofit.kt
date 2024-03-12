package com.android.islami.islamiproject.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BuildRetrofit {

    companion object{

        private var retrofit_object: Retrofit? = null


        private fun getInstanceRetrofit(url: String): Retrofit {

            // object to return quran api
            if (url == Constant.quran_base_url) {
                retrofit_object = Retrofit.Builder().baseUrl(Constant.quran_base_url)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }

            //object to return radio api
            if (url == Constant.radio_base_url) {
                retrofit_object = Retrofit.Builder().baseUrl(Constant.radio_base_url)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit_object!!

        }

        fun get_api(url: String): ApiServices {
            return getInstanceRetrofit(url).create(ApiServices::class.java)
        }

    }
}
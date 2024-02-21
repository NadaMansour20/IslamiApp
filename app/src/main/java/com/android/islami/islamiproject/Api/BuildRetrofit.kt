package com.android.islami.islamiproject.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BuildRetrofit {

    companion object{

        private var retrofit_object:Retrofit?=null
        private fun getInstanceRetrofit():Retrofit{

            if(retrofit_object==null){

                retrofit_object=Retrofit.Builder().baseUrl(Constant.base_url)
                    .addConverterFactory(GsonConverterFactory.create()).build()


            }
            return retrofit_object!!
        }

        fun get_api():ApiServices{
            return getInstanceRetrofit().create(ApiServices::class.java)
        }

    }
}
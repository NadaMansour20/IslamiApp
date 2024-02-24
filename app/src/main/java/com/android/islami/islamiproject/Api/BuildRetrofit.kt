package com.android.islami.islamiproject.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BuildRetrofit {

    companion object{

        private var quranretrofit_object: Retrofit? = null
        private var radioretrofit_object: Retrofit? = null

        private fun getInstanceRetrofit(): Retrofit {

            // object to return quran api
            if (quranretrofit_object == null) {

                quranretrofit_object = Retrofit.Builder().baseUrl(Constant.quran_base_url)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                return quranretrofit_object!!
            }

            //object to return radio api
            else if (radioretrofit_object == null) {
                radioretrofit_object = Retrofit.Builder().baseUrl(Constant.radio_base_url)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                return radioretrofit_object!!
            }
            //defult
            return quranretrofit_object!!

        }
        fun get_api():ApiServices{
            return getInstanceRetrofit().create(ApiServices::class.java)
        }

    }
}
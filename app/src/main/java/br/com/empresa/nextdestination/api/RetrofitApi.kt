package br.com.empresa.nextdestination.api

import br.com.empresa.nextdestination.constants.ApiConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApi {

    companion object {

        fun getRetrofit() : Retrofit {
            val retrofit = Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }
}
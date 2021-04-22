package br.com.empresa.nextdestination.api

import br.com.empresa.nextdestination.constants.ApiConstants
import br.com.empresa.nextdestination.model.DestinationModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DestinationCall {

    @GET("destinos")
    fun getDestinations(): Call<List<DestinationModel>>

    @GET("destinos/?")
    fun getDestinations(@Query("id") id: Long): Call<DestinationModel>

}
package de.syntax_institut.funappsvorlage.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import de.syntax_institut.funappsvorlage.data.datamodels.MemeList
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.imgflip.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MemeApiService {
    @GET("get_memes")
    suspend fun getMemes(): MemeList
}

object MemeApi {
    val retrofitService: MemeApiService by lazy { retrofit.create(MemeApiService::class.java) }
}
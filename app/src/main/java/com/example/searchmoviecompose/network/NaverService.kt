package com.example.searchmoviecompose.network

import com.example.searchmoviecompose.common.Constants.BASE_NAVER_URL
import com.example.searchmoviecompose.common.Constants.CLIENT_ID
import com.example.searchmoviecompose.common.Constants.SECRET_KEY
import com.example.searchmoviecompose.network.response.MovieResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

interface NaverService {

    @GET("v1/search/movie.json")
    suspend fun getMovieList(
        @Header("X-Naver-Client-Id") clientId: String = CLIENT_ID,
        @Header("X-Naver-Client-Secret") secretKey: String = SECRET_KEY,
        @Query("query") keyWord: String,
        @Query("display") display: Int = INIT_DISPLAY,
        @Query("yearfrom") searchRangeYearStart: Int = START_YEAR,
        @Query("yearto") searchRangeYearEnd: Int = END_YEAR
    ): MovieResponse


    companion object {
        private const val INIT_DISPLAY = 100
        private const val START_YEAR = 2000
        private var END_YEAR = Calendar.getInstance().get(Calendar.YEAR)
    }
}


@Singleton
class RetrofitNaverNetwork : NaverService {

    private val networkApi =
        Retrofit.Builder().baseUrl(BASE_NAVER_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaTypeOrNull()!!))
            .build().create(NaverService::class.java)

    @Inject
    lateinit var json: Json

    override suspend fun getMovieList(
        clientId: String,
        secretKey: String,
        keyWord: String,
        display: Int,
        searchRangeYearStart: Int,
        searchRangeYearEnd: Int
    ): MovieResponse =
        networkApi.getMovieList(
            clientId,
            secretKey,
            keyWord,
            display,
            searchRangeYearStart,
            searchRangeYearEnd
        )
}

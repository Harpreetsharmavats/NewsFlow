package com.example.core.network.api

import com.example.core.network.utils.NetworkResult
import retrofit2.Response

suspend fun <T> safeApiCall(
    apiCall: suspend () -> Response<T>
): NetworkResult<T> {

    return try {

        val response = apiCall()

        if (
            response.isSuccessful &&
            response.body() != null
        ) {

            NetworkResult.Success(
                response.body()!!
            )

        } else {

            NetworkResult.Error(
                response.message()
            )
        }

    } catch (e: Exception) {

        NetworkResult.Error(
            e.message ?: "Unknown Error"
        )
    }
}
package com.zinc.gmcompanion.service

import com.zinc.gmcompanion.model.ChatRequest
import com.zinc.gmcompanion.model.ChatResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAIService {
    @Headers(
        "Content-Type: application/json",
        "Authorization: Bearer YOUR_API_KEY_HERE" // reemplaza con tu clave
    )
    @POST("v1/chat/completions")
    fun chat(@Body request: ChatRequest): Call<ChatResponse>
}

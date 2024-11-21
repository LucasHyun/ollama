package edu.trincoll

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.*

fun main() = runBlocking {
    val client = HttpClient(CIO)
    val url = "http://localhost:11434/api/generate"

    // JSON request body
    val jsonBody = """
        {
            "model": "llama3.2",
            "prompt": "How's your feeling today?",
            "stream": false
        }
    """.trimIndent()

    try {
        val response: HttpResponse = client.post(url) {
            contentType(ContentType.Application.Json)
            setBody(jsonBody)
        }

        val responseBody = response.bodyAsText()
        println("Response: $responseBody")
    } catch (e: Exception) {
        println("Error occur: ${e.message}")
    } finally {
        client.close()
    }
}

/*
repsonse:
Response: {"model":"llama3.2","created_at":"2024-11-21T16:21:46.914914Z","response":"I'm just a language model, I don't have feelings or emotions like humans do. However, I'm functioning properly and ready to assist you with any questions or tasks you may have! How can I help you today?","done":true,"done_reason":"stop","context":[128006,9125,128007,271,38766,1303,33025,2696,25,6790,220,2366,18,271,128009,128006,882,128007,271,4438,596,701,8430,3432,30,128009,128006,78191,128007,271,40,2846,1120,264,4221,1646,11,358,1541,956,617,16024,477,21958,1093,12966,656,13,4452,11,358,2846,31301,10489,323,5644,311,7945,499,449,904,4860,477,9256,499,1253,617,0,2650,649,358,1520,499,3432,30],"total_duration":1241352917,"load_duration":28228917,"prompt_eval_count":31,"prompt_eval_duration":309000000,"eval_count":46,"eval_duration":903000000}
 */
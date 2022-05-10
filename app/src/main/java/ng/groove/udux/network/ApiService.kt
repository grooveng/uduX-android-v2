package ng.groove.udux.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //Demo request
    @GET("messaging/message")
    suspend fun getMessages(
        @Query("handle") wallet: String,
        @Query("since") lastSyncTime: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 10,
    ): String

}
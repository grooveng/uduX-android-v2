package ng.groove.udux.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder(private val gson: Gson) {

    fun create(): Retrofit {
        return Retrofit.Builder()
            .client(
                OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor()
                    .also { it.setLevel(HttpLoggingInterceptor.Level.BODY) })
                .build())
            .baseUrl(BASE_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    companion object {
        private const val BASE_ENDPOINT = ""
    }

}
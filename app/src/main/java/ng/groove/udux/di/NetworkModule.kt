package ng.groove.udux.di

import ng.groove.udux.network.ApiService
import ng.groove.udux.network.RetrofitBuilder
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {

    single { RetrofitBuilder(get()).create() }

    single { get<Retrofit>().create(ApiService::class.java) }

}
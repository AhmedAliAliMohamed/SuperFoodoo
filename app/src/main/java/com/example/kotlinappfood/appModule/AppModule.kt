package com.example.kotlinappfood.appModule

import android.app.Application
import android.content.Context
import com.example.kotlinappfood.network.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
        @Qualifier
        @Retention(AnnotationRetention.RUNTIME)
        private annotation class FoodApplicationBaseUrl

        companion object {

            @Provides
            @Singleton
            fun provideContext(application: Application): Context = application

            @FoodApplicationBaseUrl
            @Provides
            fun provideApplicationBaseUrl(): String = "https://www.google.com/api"

            @Provides
            @Singleton
            fun provideHttpLogging(): HttpLoggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            @Provides
            @Singleton
            fun provideOkHttpClient(
               httpLoggingInterceptor: HttpLoggingInterceptor
            ): OkHttpClient {
                val interceptor = Interceptor { chain ->
                    var request: Request = chain.request()
                    request = request.newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Authorization", "123456").build()
                    chain.proceed(request)
                }
                return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
                    .connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS).addInterceptor(interceptor)
                    .addInterceptor(httpLoggingInterceptor).build()
            }

            @Provides
            @Singleton
            fun provideRetrofit(
                @FoodApplicationBaseUrl baseUrl: String, client: OkHttpClient
            ): Retrofit {
                return Retrofit.Builder().client(client).baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build()
            }

            @Provides
            @Singleton
            fun provideApiInterface(retrofit: Retrofit): ApiInterface = retrofit.create(ApiInterface::class.java)
        }
    }



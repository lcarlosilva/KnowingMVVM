package luiz.com.knowingmvvm.di

import com.google.gson.GsonBuilder
import luiz.com.knowingmvvm.BuildConfig
import luiz.com.knowingmvvm.data.service.RickMortyService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

private const val TIMEOUT: Long = 30L

private val API_URL: StringQualifier = StringQualifier("API_URL")

fun networkModule() = module {
    factory { provideGson() }
    factory { provideOkhttpClient(getAll()) }
    factory(qualifier = API_URL) { provideApiUrl() }
    factory { provideLoggingInterceptor() } bind Interceptor::class
    factory<Converter.Factory> { GsonConverterFactory.create(get()) }

    single { provideRetrofit(get(API_URL), get(), get()) }
    single { get<Retrofit>().create<RickMortyService>() }
}

private fun provideRetrofit(baseUrl: String, client: OkHttpClient, converter: Converter.Factory) =
    Retrofit.Builder().run {
        baseUrl(baseUrl)
        client(client)
        addConverterFactory(converter)
        build()
    }

fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
    if (BuildConfig.DEBUG) {
        this.level = HttpLoggingInterceptor.Level.BODY
    } else {
        this.level = HttpLoggingInterceptor.Level.BASIC
    }
}

private fun provideApiUrl() = BuildConfig.API_RICK_MORTY

fun provideOkhttpClient(interceptors: List<Interceptor>) =
    OkHttpClient.Builder().run {
        readTimeout(TIMEOUT, TimeUnit.SECONDS)
        connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        interceptors.forEach(::addInterceptor)
        build()
    }

private fun provideGson() = GsonBuilder().create()

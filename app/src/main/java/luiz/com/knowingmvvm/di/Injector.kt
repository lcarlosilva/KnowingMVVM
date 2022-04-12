package luiz.com.knowingmvvm.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun Application.inject() {
    startKoin {
        androidLogger()
        androidContext(this@inject)
        modules(getModules())
    }
}

fun getModules() = listOf(
    viewModule(),
    dataModule(),
    networkModule()
)

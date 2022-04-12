package luiz.com.knowingmvvm.di

import luiz.com.knowingmvvm.data.source.RickMortyDataSource
import luiz.com.knowingmvvm.domain.repository.RickMortyRepository
import org.koin.dsl.module

fun dataModule() = module {
    factory<RickMortyRepository> { RickMortyDataSource(service = get()) }
}
package luiz.com.knowingmvvm.di

import luiz.com.knowingmvvm.domain.use_case.RickMortyUseCase
import org.koin.dsl.module

fun useCaseModule() = module {
    single { RickMortyUseCase(repository = get()) }
}
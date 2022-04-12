package luiz.com.knowingmvvm.di

import luiz.com.knowingmvvm.view.view_model.RickMortyViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

fun viewModule() = module {
    viewModel {
        RickMortyViewModel(useCase = get())
    }
}
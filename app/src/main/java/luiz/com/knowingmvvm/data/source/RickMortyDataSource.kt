package luiz.com.knowingmvvm.data.source

import luiz.com.knowingmvvm.data.service.RickMortyService
import luiz.com.knowingmvvm.data.repository.RickMortyRepository

class RickMortyDataSource(private val service: RickMortyService) : RickMortyRepository{
    override suspend fun character() = service.character()
}
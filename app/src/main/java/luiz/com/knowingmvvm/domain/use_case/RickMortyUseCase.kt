package luiz.com.knowingmvvm.domain.use_case

import luiz.com.knowingmvvm.data.repository.RickMortyRepository
import luiz.com.knowingmvvm.domain.entity.Character

class RickMortyUseCase(private val repository: RickMortyRepository) {

    suspend operator fun invoke(): ArrayList<Character> {
        return repository.character().results
    }
}
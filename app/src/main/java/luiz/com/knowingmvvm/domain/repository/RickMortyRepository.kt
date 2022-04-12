package luiz.com.knowingmvvm.domain.repository

import luiz.com.knowingmvvm.data.response.BaseResponse
import luiz.com.knowingmvvm.domain.entity.Character

interface RickMortyRepository {
    suspend fun character(): BaseResponse<Character>
}
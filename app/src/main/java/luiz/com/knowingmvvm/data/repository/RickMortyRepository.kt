package luiz.com.knowingmvvm.data.repository

import luiz.com.knowingmvvm.data.response.BaseResponse
import luiz.com.knowingmvvm.domain.entity.Character

interface RickMortyRepository {
    suspend fun character(): BaseResponse<Character>
}
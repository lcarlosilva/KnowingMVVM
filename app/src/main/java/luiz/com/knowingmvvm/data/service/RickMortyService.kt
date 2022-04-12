package luiz.com.knowingmvvm.data.service

import luiz.com.knowingmvvm.data.response.BaseResponse
import luiz.com.knowingmvvm.domain.entity.Character
import retrofit2.http.GET

interface RickMortyService {
    @GET("character")
    suspend fun character() : BaseResponse<Character>
}
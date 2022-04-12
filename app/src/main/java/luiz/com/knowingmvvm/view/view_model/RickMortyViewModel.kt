package luiz.com.knowingmvvm.view.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import luiz.com.knowingmvvm.domain.entity.Character
import luiz.com.knowingmvvm.domain.use_case.RickMortyUseCase

class RickMortyViewModel(private val useCase: RickMortyUseCase) : ViewModel() {
    private val _characterMutableLiveData = MutableLiveData<ArrayList<Character>>()
    val characterLiveData = _characterMutableLiveData.asLiveData()

    fun characters() {
        viewModelScope.launch {
            _characterMutableLiveData.postValue(useCase())
        }
    }
}

fun <T> MutableLiveData<T>.asLiveData(): LiveData<T> = this
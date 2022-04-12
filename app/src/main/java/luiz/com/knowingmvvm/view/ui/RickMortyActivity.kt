package luiz.com.knowingmvvm.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_rick_morty.*
import luiz.com.knowingmvvm.R
import luiz.com.knowingmvvm.domain.entity.Character
import luiz.com.knowingmvvm.view.adapter.CharacterAdapter
import luiz.com.knowingmvvm.view.view_model.RickMortyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class RickMortyActivity : AppCompatActivity() {

    private val viewModel: RickMortyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rick_morty)

        viewModel.characterLiveData.observe(this, {
            buildRecycler(it)
        })

        viewModel.characters()
    }

    private fun buildRecycler(it: ArrayList<Character>) {
        rv_character.adapter = CharacterAdapter(it)
        rv_character.setHasFixedSize(true)
        rv_character.layoutManager = LinearLayoutManager(this@RickMortyActivity)
    }
}
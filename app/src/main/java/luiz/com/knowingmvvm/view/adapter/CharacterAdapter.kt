package luiz.com.knowingmvvm.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list_character.view.*
import luiz.com.knowingmvvm.R
import luiz.com.knowingmvvm.domain.entity.Character


class CharacterAdapter(private val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflateItemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_character, parent, false)
        return CharacterViewHolder(inflateItemView)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) =
        holder.bindView(characters[position])

    override fun getItemCount(): Int = characters.count()

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameCharacter = itemView.tv_name_character
        private val speciesCharacter = itemView.tv_species_character
        private val genderCharacter = itemView.tv_gender_character

        fun bindView(character: Character) {

            val resources = this.itemView.resources

            nameCharacter.text = resources.getString(R.string.lbl_name, character.name)
            speciesCharacter.text = resources.getString(R.string.lbl_character_specie, character.species)
            genderCharacter.text = resources.getString(R.string.lbl_character_gender, character.gender)
        }
    }
}
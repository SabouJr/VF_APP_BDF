package fr.example.bdf_app.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.example.bdf_app.data.Challenge
import fr.example.bdf_app.databinding.ItemChallengeBinding

class ChallengesAdapter(val items: MutableList<Challenge>, private val listener: IChallengeListener) :
    RecyclerView.Adapter<ChallengesAdapter.ChallengeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeViewHolder {

        val binding = ItemChallengeBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ChallengeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChallengeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun getElement(position: Int): Challenge {
        return items[position]
    }

    fun addItem(name: Challenge) {
        items.add(name)
        notifyItemInserted(items.size)
    }

    fun removeAt(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun refresh(newItems: List<Challenge>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class ChallengeViewHolder(private val binding: ItemChallengeBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(challenge: Challenge) {

            binding.apply {
                tvDefiBank.text = challenge.value
                ivCategory.setImageResource(challenge.firstPicto)
                ivHeart.setImageResource(challenge.secondPicto)
                root.setOnClickListener {
                    listener.onClickChallenge(challenge)
                }
            }
        }
    }

    interface IChallengeListener {
        fun onClickChallenge(item: Challenge)
    }
}
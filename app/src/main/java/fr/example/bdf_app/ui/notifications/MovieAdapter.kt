package fr.example.bdf_app.ui.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.example.bdf_app.databinding.ItemVerticalMovieBinding


class MovieAdapter(private val items: MutableList<MovieModel>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val binding = ItemVerticalMovieBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun getElement(position: Int): MovieModel {
        return items[position]
    }

    fun addItem(name: MovieModel) {
        items.add(name)
        notifyItemInserted(items.size)
    }

    fun removeAt(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun refresh(newItems: List<MovieModel>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(private val binding: ItemVerticalMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movieModel: MovieModel) {

            binding.apply {
                nameItem.text = movieModel.name
            }
        }
    }
}



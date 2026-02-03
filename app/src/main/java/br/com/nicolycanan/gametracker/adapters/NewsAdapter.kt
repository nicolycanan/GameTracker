package br.com.nicolycanan.gametracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.nicolycanan.gametracker.R
import br.com.nicolycanan.gametracker.model.News

class NewsAdapter(
    private val items: MutableList<News> = mutableListOf(),
    private val onClick: ((News) -> Unit)? = null
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.txtTitle)
        val subtitle: TextView = view.findViewById(R.id.txtSubtitle)
        val image: ImageView = view.findViewById(R.id.imgCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.title.text = item.title
        holder.subtitle.text = item.subtitle
        holder.image.setImageResource(item.imageRes)

        holder.itemView.setOnClickListener { onClick?.invoke(item) }
    }

    override fun getItemCount(): Int = items.size

    // ---------- Manipulação de dados (fácil) ----------

    fun setItems(newItems: List<News>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun addItem(news: News) {
        items.add(news)
        notifyItemInserted(items.lastIndex)
    }

    fun removeItem(position: Int) {
        if (position !in items.indices) return
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateItem(position: Int, news: News) {
        if (position !in items.indices) return
        items[position] = news
        notifyItemChanged(position)
    }
}
package br.com.nicolycanan.gametracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.nicolycanan.gametracker.R
import br.com.nicolycanan.gametracker.model.Launch

class LaunchAdapter(
    private val list: List<Launch>,
    private val onClick: (Launch) -> Unit
) : RecyclerView.Adapter<LaunchAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgLaunch: ImageView = view.findViewById(R.id.imgLaunch)
        val txtTitle: TextView = view.findViewById(R.id.txtLaunchTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_launch, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.imgLaunch.setImageResource(item.imageRes)
        holder.txtTitle.text = item.title

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

    override fun getItemCount() = list.size
}
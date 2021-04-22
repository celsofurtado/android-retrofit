package br.com.empresa.nextdestination.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.empresa.nextdestination.R
import br.com.empresa.nextdestination.model.DestinationModel

class TopDestinationAdapter(
    val context: Context) : RecyclerView.Adapter<TopDestinationAdapter.Holder>() {

    var topDestinationList: List<DestinationModel> = listOf()

    fun updateTopDestinationList(lista: List<DestinationModel>) {
        this.topDestinationList = lista
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.top_places_layout, parent, false)
        return Holder(
            view
        )
    }

    override fun getItemCount(): Int {
        return topDestinationList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val recentDestination = topDestinationList[position]

        holder.title.text = recentDestination.nome
        holder.country.text = recentDestination.nomeCidade
        holder.value.text = "A partir de R$ ${recentDestination.valor}"
        holder.image.setImageDrawable(context.getDrawable(R.drawable.ipojuca))
        //holder.image.setImageDrawable(recentDestination.image)

    }

    class Holder(view: View) : RecyclerView.ViewHolder(view){

        val title: TextView = view.findViewById(R.id.tv_top_places_title)
        val country: TextView = view.findViewById(R.id.tv_top_places_country)
        val value: TextView = view.findViewById(R.id.tv_top_places_value)
        val image: ImageView = view.findViewById(R.id.iv_top_places_image)

    }

}
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

class RecentDestinationAdapter(
    val context: Context) : RecyclerView.Adapter<RecentDestinationAdapter.Holder>() {

    //var recentDestinationList: List<DestinationModel>()
    var recentDestinationList: List<DestinationModel> = listOf()

    fun updateDestinationList(lista: List<DestinationModel>) {
        recentDestinationList = lista
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.recents_places_layout, parent, false)
        return Holder(
            view
        )
    }

    override fun getItemCount(): Int {
        return recentDestinationList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val recentDestination = recentDestinationList[position]

        holder.title.text = recentDestination.nome
        holder.country.text = recentDestination.nomeCidade
        holder.value.text = "A partir de R$ ${recentDestination.valor}"
        holder.image.setImageDrawable(context.getDrawable(R.drawable.ipojuca))
        //holder.image.setImageDrawable(recentDestination.image)

    }

    class Holder(view: View) : RecyclerView.ViewHolder(view){

        val title: TextView = view.findViewById(R.id.tv_recent_title)
        val country: TextView = view.findViewById(R.id.tv_recent_country)
        val value: TextView = view.findViewById(R.id.tv_recent_value)
        val image: ImageView = view.findViewById(R.id.iv_teste)

    }

}
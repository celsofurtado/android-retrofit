package br.com.empresa.nextdestination.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.empresa.nextdestination.DestinationDetailActivity
import br.com.empresa.nextdestination.R
import br.com.empresa.nextdestination.model.DestinationModel
import com.bumptech.glide.Glide

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
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return recentDestinationList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val recentDestination = recentDestinationList[position]

        holder.title.text = recentDestination.nome
        holder.country.text = recentDestination.nomeCidade
        holder.value.text = "A partir de R$ ${recentDestination.valor}"
        if (recentDestination.urlFotoCapa.trim().isNotEmpty()) {
            Glide.with(context).load(recentDestination.urlFotoCapa).into(holder.image)
        }
        //holder.image.setImageDrawable(context.getDrawable(R.drawable.ipojuca))
        //Log.d("Teste", recentDestination.fotoCapa)
        //holder.image.setImageDrawable(recentDestination.image)

        holder.cardRecentDestinations.setOnClickListener{
            val i = Intent(context, DestinationDetailActivity::class.java)
            context.startActivity(i)
//            val i = Intent(this, DestinationDetailActivity::class.java)
//            startActivity(i)
        }

    }

    class Holder(view: View) : RecyclerView.ViewHolder(view){

        val title: TextView = view.findViewById(R.id.tv_recent_title)
        val country: TextView = view.findViewById(R.id.tv_recent_country)
        val value: TextView = view.findViewById(R.id.tv_recent_value)
        val image: ImageView = view.findViewById(R.id.iv_teste)
        val cardRecentDestinations: CardView = view.findViewById(R.id.card_recent_destinations)



    }

}
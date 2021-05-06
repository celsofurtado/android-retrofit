package br.com.empresa.nextdestination.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.empresa.nextdestination.R

class ImageGalleryAdapter(val context: Context) : RecyclerView.Adapter<ImageGalleryAdapter.ViewHolder>() {

    var galleryList = listOf<Drawable?>()

    fun updateGalleryList(lista: List<Drawable>) {
        this.galleryList = lista
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_gallery_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return galleryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ivImageGallery.setImageDrawable(galleryList[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var ivImageGallery = view.findViewById<ImageView>(R.id.iv_gallery)

    }
}
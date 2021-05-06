package br.com.empresa.nextdestination

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.empresa.nextdestination.adapter.ImageGalleryAdapter

class DestinationDetailActivity : AppCompatActivity() {

    lateinit var rvImageGallery: RecyclerView
    lateinit var imageGalleryAdapter: ImageGalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination_detail)

        rvImageGallery = findViewById(R.id.rv_image_gallery)
        setImageGallery()
    }

    fun setImageGallery() {

        imageGalleryAdapter = ImageGalleryAdapter(this)
        rvImageGallery.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvImageGallery.adapter = imageGalleryAdapter
        loadImageGallery()

    }

    fun loadImageGallery() {

        val listImages: List<Drawable?> = listOf(
            getDrawable(R.drawable.saopaulo),
            getDrawable(R.drawable.bariloche),
            getDrawable(R.drawable.ipojuca),
            getDrawable(R.drawable.lago_argentina),
            getDrawable(R.drawable.angra))

        imageGalleryAdapter.updateGalleryList(listImages as List<Drawable>)

    }
}
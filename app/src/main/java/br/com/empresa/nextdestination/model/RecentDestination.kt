package br.com.empresa.nextdestination.model

import android.graphics.drawable.Drawable

data class RecentDestination(
    var nomeDestino: String,
    var nomeCidade: String,
    var valor: Double,
    var image: Drawable?
)
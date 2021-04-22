package br.com.empresa.nextdestination.model

data class DestinationModel (
    var id: Long,
    var nome: String,
    var nomeCidade: String,
    var siglaEstado: String,
    var descricao: String,
    var valor: Double
)
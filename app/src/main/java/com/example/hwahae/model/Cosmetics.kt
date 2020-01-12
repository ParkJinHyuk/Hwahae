package com.example.hwahae.model

data class CosmeticsList(
    val body: List<Cosmetics>
)

data class Cosmetics (
    val id: Int,
    val thumbnail_image: String,
    val title : String,
    val price: Int
)
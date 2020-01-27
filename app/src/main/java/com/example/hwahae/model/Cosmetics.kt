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

data class CosmeticsDetailList (
    val body: CosmeticsDetail
)

data class CosmeticsDetail (
    val id: Int,
    val full_size_image: String,
    val title: String,
    val description: String,
    val price: String,
    val oily_score: Int,
    val dry_score: Int,
    val sensitive_score: Int
)


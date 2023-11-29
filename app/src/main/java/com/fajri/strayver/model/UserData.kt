package com.fajri.strayver.model

data class UserData(
    val nama: String= "",
    val avatar: String= "",
    val username: String= "",
    val email: String= "",
    val deskripsi: String= "",
    val telp: String= "",
    val alamat: String= "",
    val password: String= "",
    val role: String= "",
    val saldo: Long= 0,
    val totalDana: Int = 0,
    val totalBarang: Int = 0
)

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
    var totalDana: Long = 0,
    var totalBarang: Long = 0
)

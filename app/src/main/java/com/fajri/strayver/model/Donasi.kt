package com.fajri.strayver.model

data class Donasi(
    val donasiId: String= "",
    val title: String= "",
    val donasiGoal: Long?= 0,
    val donasiGain: Long= 0,
    val deskripsi: String= "",
    val alamat: String= "",
    val gambar: String= "",
    val relawanAvatar: String= "",
    val relawanNama: String= "",
    val waktu: Long= 0,
    val userId: String= "",
    val category: String= "",
)

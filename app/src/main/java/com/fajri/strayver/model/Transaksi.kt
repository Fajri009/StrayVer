package com.fajri.strayver.model

import com.fajri.strayver.util.TipeDonasi

data class Transaksi(
    val transaksiId: String= "",
    val donasiId: String= "",
    val donasiType: String= "",
    val title: String= "",
    val namaRelawan: String= "",
    val idRelawan: String= "",
    val namaMember: String= "",
    val idMember: String= "",
    val income: Long= 0,
    val tanggal: Long= 0,
    val resi: String= "",
    val status: String= "",
    val ekspedisi: String= "",
    val deskripsi: String= "",
    val gambar: String= "",
    val metodePembayaran: String= ""
)
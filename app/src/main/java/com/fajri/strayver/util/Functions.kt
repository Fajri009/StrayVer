package com.fajri.strayver.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun formatLongWithDots(value: Long): String {
    val stringValue = value.toString()
    val length = stringValue.length

    if (length <= 3) {
        return stringValue
    }

    val formatted = StringBuilder()
    var dotCount = 0

    for (i in length - 1 downTo 0) {
        formatted.append(stringValue[i])

        if (++dotCount == 3 && i > 0) {
            formatted.append('.')
            dotCount = 0
        }
    }
    return formatted.reverse().toString()
}

fun formatDate(date: String): LocalDate {
    val dateFormat= DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val localDate= LocalDate.parse("$date", dateFormat)
    return localDate
}
package com.fajri.strayver.util

import java.text.DateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

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

fun Long.toDateString(dateFormat: Int =  DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}
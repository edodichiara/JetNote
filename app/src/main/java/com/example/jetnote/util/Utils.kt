package com.example.jetnote.util

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(time: Long): String{
    val date = Date(time)
    val format = SimpleDateFormat("EEE, dd/MM/yyyy", Locale.getDefault())
    return format.format(date)
}
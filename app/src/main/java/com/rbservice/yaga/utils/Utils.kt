package com.rbservice.yaga.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.concurrent.TimeUnit

@SuppressLint("SimpleDateFormat")
fun convertTimeAgo(time: String): String {
    try {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val past: Date = format.parse(time) as Date
        val now = Date()
        val seconds: Long = TimeUnit.MILLISECONDS.toSeconds(now.time - past.time)
        val minutes: Long = TimeUnit.MILLISECONDS.toMinutes(now.time - past.time)
        val hours: Long = TimeUnit.MILLISECONDS.toHours(now.time - past.time)
        val days: Long = TimeUnit.MILLISECONDS.toDays(now.time - past.time)
        return when {
            seconds < 60 -> {
                "$seconds giây trước"
            }
            minutes < 60 -> {
                "$minutes phút trước"
            }
            hours < 24 -> {
                "$hours giờ trước"
            }
            else -> {
                "$days ngày trước"
            }
        }
    } catch (j: Exception) {
        j.printStackTrace()
    }
    return ""
}

fun convertTimeToString(millis: Long): String? {
    val time = millis / 3600000f
    val hms: String = if (time >= 1) {
        String.format(
            "%02d:%02d:%02d",
            TimeUnit.MILLISECONDS.toHours(millis),
            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(
                TimeUnit.MILLISECONDS.toHours(
                    millis
                )
            ),
            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(
                    millis
                )
            )
        )
    } else {
        String.format(
            "%02d:%02d",
            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(
                TimeUnit.MILLISECONDS.toHours(
                    millis
                )
            ),
            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(
                    millis
                )
            )
        )
    }
    return hms
}
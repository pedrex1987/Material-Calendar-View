package com.applandeo.materialcalendarview.extensions

import java.util.*
import java.util.concurrent.TimeUnit

fun List<Calendar>.getFirstDate(): Calendar {
    return this.sortedBy { it.timeInMillis }.first()
}

fun List<Calendar>.getLastDate(): Calendar {
    return this.sortedBy { it.timeInMillis }.last()
}

fun Calendar.createIntervalDates(endDate: Calendar): List<Calendar> {
    val daysBetweenStartEnd: Int = TimeUnit.DAYS.convert(endDate.timeInMillis - this.timeInMillis, TimeUnit.MILLISECONDS).toInt()
    val minDay = this.time

    val dates = arrayListOf<Calendar>()
    for (i in 0 .. daysBetweenStartEnd) {
        val cal = Calendar.getInstance()
        cal.time = minDay
        cal.add(Calendar.DATE, i)
        dates.add(cal)
    }
    dates.add(endDate)
    return dates
}
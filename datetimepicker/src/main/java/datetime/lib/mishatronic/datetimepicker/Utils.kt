package datetime.lib.mishatronic.datetimepicker

import java.util.*

fun Calendar.addHours(value: Int) {
    this.add(Calendar.HOUR_OF_DAY, value)
}

fun Calendar.addMinutes(value: Int) {
    this.add(Calendar.MINUTE, value)
}

fun Calendar.addSeconds(value: Int) {
    this.add(Calendar.SECOND, value)
}

fun Calendar.addDays(value: Int) {
    this.add(Calendar.DAY_OF_MONTH, value)
}

fun Calendar.addYears(value: Int) {
    this.add(Calendar.YEAR, value)
}

fun Calendar.addMoths(value: Int) {
    this.add(Calendar.MONTH, value)
}

fun Calendar.addWeeks(value: Int) {
    this.add(Calendar.WEEK_OF_YEAR, value)
}
package datetime.lib.mishatronic.datetimepicker

import java.util.*

/**
 * Util to add hours to Calendar instance
 */
fun Calendar.addHours(value: Int) {
    this.add(Calendar.HOUR_OF_DAY, value)
}
/**
 * Util to add minutes to Calendar instance
 */
fun Calendar.addMinutes(value: Int) {
    this.add(Calendar.MINUTE, value)
}
/**
 * Util to add seconds to Calendar instance
 */
fun Calendar.addSeconds(value: Int) {
    this.add(Calendar.SECOND, value)
}
/**
 * Util to add days to Calendar instance
 */
fun Calendar.addDays(value: Int) {
    this.add(Calendar.DAY_OF_MONTH, value)
}

fun Calendar.addYears(value: Int) {
    this.add(Calendar.YEAR, value)
}
/**
 * Util to add months to Calendar instance
 */
fun Calendar.addMoths(value: Int) {
    this.add(Calendar.MONTH, value)
}
/**
 * Util to add addWeeks to Calendar instance
 */
fun Calendar.addWeeks(value: Int) {
    this.add(Calendar.WEEK_OF_YEAR, value)
}
package datetime.lib.mishatronic.datetimepicker

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.view.Window
import kotlinx.android.synthetic.main.item_date_time_picker.*
import java.util.*
import java.util.concurrent.TimeUnit

class DateTimePickerDialog
private constructor(
        context: Context,
        private val onOk: (Long) -> Unit,
        private val params: DialogParams = DialogParams()
) : Dialog(context) {

    private val cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.item_date_time_picker)

        useDialogParams(params)
    }
    private fun useDialogParams(params: DialogParams){
        time_picker.setIs24HourView(params.is24hour)
        date_time_set?.setOnClickListener { onOk(getTime()); dismiss() }

        params.time?.let {
            cal.timeInMillis = it
            setTime()
        }
        params.timeZone?.let {
            cal.timeZone = it
            setTime()
        }
        params.buttonTitle?.let {
            date_time_set?.text = it
        }
        params.background?.let {
            layout_back?.background = it
        }
        params.buttonBackground?.let {
            date_time_set?.background = it
        }
    }
    private fun setTime(){
        date_picker?.updateDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            time_picker?.hour = cal.get(Calendar.HOUR)
            time_picker?.minute = cal.get(Calendar.MINUTE)
        } else {
            time_picker?.currentHour = cal.get(Calendar.HOUR)
            time_picker?.currentMinute = cal.get(Calendar.MINUTE)
        }
    }
    private fun getTime(): Long {

        val calendar = GregorianCalendar(date_picker.year,
                date_picker.month,
                date_picker.dayOfMonth,
                time_picker.currentHour,
                time_picker.currentMinute)

        return calendar.timeInMillis
    }

    /**
     * add seconds
     * @param value
     */
    fun addSeconds(value:Int){
        cal.addSeconds(value)
        setTime()
    }
    /**
     * add minutes
     * @param value
     */
    fun addMinutes(value:Int){
        cal.addMinutes(value)
        setTime()
    }

    /**
     * add hours
     * @param value
     */
    fun addHours(value:Int){
        cal.addHours(value)
        setTime()
    }

    /**
     * add days
     * @param value
     */
    fun addDays(value:Int){
        cal.addDays(value)
        setTime()
    }

    /**
     * add weeks
     * @param value
     */
    fun addWeeks(value:Int){
        cal.addWeeks(value)
        setTime()
    }

    /**
     * add moths
     * @param value
     */
    fun addMoths(value:Int){
        cal.addMoths(value)
        setTime()
    }

    /**
     * add years
     * @param value
     */
    fun addYears(value:Int){
        cal.addYears(value)
        setTime()
    }


    /**
     * Class for building DateTimePickerDialog
     * @param context
     */
    class Builder(private val context: Context) {
        private var onOk: (Long) -> Unit = {}
        private var dialogParams = DialogParams()

        /**
         * set start time for picker
         * @param time
         */
        fun setTime(time: Long): Builder {
            this.dialogParams.time = TimeUnit.SECONDS.toMillis(time)
            return this
        }

        /**
         * set timeZone for picker
         * @param timeZone
         */
        fun setTimeZone(timeZone: TimeZone): Builder {
            this.dialogParams.timeZone = timeZone
            return this
        }

        /**
         * set lambda for button callback
         * @param onOk
         */
        fun setOnOkListener(onOk: (Long) -> Unit = {}): Builder {
            this.onOk = onOk
            return this
        }

        /**
         * set button titlenfrom string
         * @param title
         */
        fun setButtonTitle(title: String): Builder {
            this.dialogParams.buttonTitle = title
            return this
        }

        /**
         * set button title from resource
         * @param resId
         */
        fun setButtonTitle(@StringRes resId: Int): Builder {
            this.dialogParams.buttonTitle = context.getString(resId)
            return this
        }
        /**
         * set button background from resource
         * @param resId
         */
        fun setButtonBackground(@DrawableRes resId: Int): Builder {
            this.dialogParams.buttonBackground = ContextCompat.getDrawable(context, resId)
            return this
        }
        /**
         * set button background from drawable
         * @param d
         */
        fun setButtonBackground(d: Drawable): Builder {
            this.dialogParams.buttonBackground = d
            return this
        }
        /**
         * set button background from color
         * @param color
         */
        fun setButtonBackgroundColor(color: Int): Builder {
             return setButtonBackground(ColorDrawable(color))
        }

        /**
         * set 24/12 time format
         * @param b
         */
        fun setIs24HourTime(b: Boolean): Builder {
            this.dialogParams.is24hour = b
            return this
        }

        /**
         * set background drawable for picker
         * @param drawable
         */
        fun setBackground(drawable: Drawable): Builder {
            this.dialogParams.background = drawable
            return this
        }

        /**
         * set background color for picker
         * @param color
         */
        fun setBackgroundColor(color: Int): Builder {

            return setBackground(ColorDrawable(color))
        }

        /**
         * build dialog with params
         */
        fun build(): DateTimePickerDialog = DateTimePickerDialog(context, onOk, dialogParams)

    }
}

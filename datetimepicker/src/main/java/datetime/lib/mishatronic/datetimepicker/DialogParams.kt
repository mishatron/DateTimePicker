package datetime.lib.mishatronic.datetimepicker

import android.graphics.drawable.Drawable
import java.util.*


/**
 * this class has dialog params to set them up
 */
class DialogParams{
    var time: Long? = null
    var timeZone: TimeZone? = null
    var buttonTitle:String? = null
    var buttonBackround:Drawable? = null
    var is24hour:Boolean = true
    var background: Drawable? = null
}
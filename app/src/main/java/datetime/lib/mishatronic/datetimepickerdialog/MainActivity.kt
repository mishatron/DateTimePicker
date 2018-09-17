package datetime.lib.mishatronic.datetimepickerdialog

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import datetime.lib.mishatronic.datetimepicker.DateTimePickerDialog


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DateTimePickerDialog.Builder(this)
                .setOnOkListener { Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show() }
                .setButtonTitle("okay")
                .setBackgroundColor(Color.GREEN)
                .setButtonBackgroundColor(Color.BLUE)
                .build().show()
    }

}

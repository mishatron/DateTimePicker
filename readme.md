# DateTimePickerDialog
[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

This is an util for choosing date and time in dialog.

It can be customized differently, you can see documentation.

https://github.com/mishatron/DateTimePicker/releases/latest/

![](https://raw.githubusercontent.com/mishatron/DateTimePicker/master/app/src/main/res/drawable/screenshot1.gif)

## How to install

Add it in your root build.gradle at the end of repositories:
``` 
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
Add the dependency:
``` 
dependencies {
    ...
    implementation 'com.github.mishatron:DateTimePicker:0.0.2'
} 
```
And then you can use it:
```
DateTimePickerDialog.Builder(this)
                .setOnOkListener { Toast.makeText(this, "Selected time is $it", Toast.LENGTH_SHORT).show() }
                .setButtonTitle("Ok")
                .setBackgroundColor(Color.GREEN)
                .setButtonBackgroundColor(Color.BLUE)
                .build().show()
```

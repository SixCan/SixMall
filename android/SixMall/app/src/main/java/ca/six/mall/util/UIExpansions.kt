package ca.six.mall.util

import android.widget.EditText


fun EditText.string() : String {
    return this.getText()?.toString() ?: "" //this是指EditText对象。因为这是猴子补丁
}

package ca.six.tomato.util

import android.widget.Toast
import ca.six.mall.core.BaseApp

fun showToast(text : String){
    Toast.makeText(BaseApp.appContext, text, Toast.LENGTH_SHORT).show()
}




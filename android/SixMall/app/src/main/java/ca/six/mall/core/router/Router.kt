package ca.six.mall.core.router

import android.app.Activity
import android.content.Intent

object Router {

    @JvmStatic
    fun nav(src: Activity, dest: Class<out Activity>, args: Map<String, String>? = null,
            vararg preconditions : IPrecondition) {

        var destination = dest

        // deal with preconditions first
        for(precondition in preconditions){

        }


        // navigate to the destination class
        val it = Intent(src, destination)

        if (args != null) {
            for ((k, v) in args) {
                it.putExtra(k, v)
            }
        }

        src.startActivity(it)

    }


    @JvmStatic
    fun nav(){

    }



}
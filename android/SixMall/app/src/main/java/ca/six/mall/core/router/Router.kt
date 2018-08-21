package ca.six.mall.core.router

import android.app.Activity
import android.content.Intent
import ca.six.mall.core.router.precondition.EmptyFilterResult
import ca.six.mall.core.router.precondition.IPrecondition

object Router {

    @JvmStatic
    fun nav(src: Activity, dest: Class<out Activity>, args: Map<String, String>? = null,
            vararg preconditions: IPrecondition) {

        // deal with preconditions first
        for (precondition in preconditions) {
            val filterResult = precondition.isMatching()
            if (filterResult !is EmptyFilterResult) { // is not
                val clazz = filterResult.clazz
                if(args == null){
                    args = HashMap()
                    args.put("errorMsg", filterResult.errorMessage)
                }
                navigate(src, dest, args)
                return
            }
        }


        navigate(src, destination, arguments)

    }

    @JvmStatic
    private fun navigate(src: Activity, destination: Class<out Activity>, arguments: Map<String, String>?) {
        // navigate to the destination class
        val it = Intent(src, destination)

        if (arguments != null) {
            for ((k, v) in arguments) {
                it.putExtra(k, v)
            }
        }

        src.startActivity(it)
    }




}
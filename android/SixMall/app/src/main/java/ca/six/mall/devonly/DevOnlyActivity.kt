package ca.six.mall.devonly

import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ca.six.mall.R
import ca.six.tomato.util.getCircleBitmap
import kotlinx.android.synthetic.main.activity_dev_only.*

class DevOnlyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_only)

//        testView.initData(Color.GREEN, R.drawable.panda, "Panda")
        val srcBitmap = BitmapFactory.decodeResource(resources, R.drawable.panda)
        println("szw w = ${srcBitmap.width}, h = ${srcBitmap.height}")
        val circleBitmap = getCircleBitmap(srcBitmap, 300.0f)
        testView.setImageBitmap(circleBitmap)

    }

}
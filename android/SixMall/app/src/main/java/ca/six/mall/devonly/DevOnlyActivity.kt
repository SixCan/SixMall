package ca.six.mall.devonly

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ca.six.mall.R
import kotlinx.android.synthetic.main.activity_dev_only.*

class DevOnlyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_only)

        testView.initData(R.drawable.panda, "Panda")

    }

}
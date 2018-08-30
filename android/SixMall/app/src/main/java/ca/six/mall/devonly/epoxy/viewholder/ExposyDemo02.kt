package ca.six.mall.devonly.epoxy.viewholder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import ca.six.mall.R
import kotlinx.android.synthetic.main.activity_dev_only_epoxy_rv_one.*

class ExposyDemo02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_only_epoxy_rv_one)

        rvEpoxy.layoutManager = LinearLayoutManager(this)

        val data = List(12) { i -> "ViewHolder Item $i" }
        val controller = EpoxyVhController()
        controller.setData(R.drawable.dev_only_westlake, data)

        rvEpoxy.setController(controller)

    }
}
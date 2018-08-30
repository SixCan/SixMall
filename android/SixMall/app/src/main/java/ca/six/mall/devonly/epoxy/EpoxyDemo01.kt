package ca.six.mall.devonly.epoxy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import ca.six.mall.R
import kotlinx.android.synthetic.main.activity_dev_only_epoxy_rv_one.*

class EpoxyDemo01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_only_epoxy_rv_one)

        val data = List(12) { i -> "Item $i" }
        val controller = EpoxyDemoController01()
        controller.setData(data)

        rvEpoxy.layoutManager = LinearLayoutManager(this)
        rvEpoxy.setController(controller)  // 自带rv.setAdapter(controller.adapter)

    }
}
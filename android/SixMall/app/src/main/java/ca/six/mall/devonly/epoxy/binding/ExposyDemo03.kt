package ca.six.mall.devonly.epoxy.binding

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import ca.six.mall.R
import ca.six.mall.devonly.epoxy.viewholder.EpoxyVhController
import kotlinx.android.synthetic.main.activity_dev_only_epoxy_rv_one.*

class ExposyDemo03 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_only_epoxy_rv_one)

        rvEpoxy.layoutManager = LinearLayoutManager(this)

        val data = List(13) { i -> "Binding Item $i" }
        val controller = EpoxyBindingController()
        controller.setData(R.drawable.dev_only_westlake, data)

        rvEpoxy.setController(controller)
    }
}
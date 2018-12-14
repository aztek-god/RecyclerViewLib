package pj.sdv.com.recyclerviewlib

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import pj.sdv.com.recyclerviewlib.abstr.ItemModel
import pj.sdv.com.recyclerviewlib.adapter.RenderAdapter
import pj.sdv.com.recyclerviewlib.model.ImageModel
import pj.sdv.com.recyclerviewlib.model.TitleModel
import pj.sdv.com.recyclerviewlib.render.ImageViewModelRender
import pj.sdv.com.recyclerviewlib.render.TitleViewModelRender

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apply {
            val renderAdapter = RenderAdapter()
            renderAdapter.registerViewModelRenderer(TitleViewModelRender())
            renderAdapter.registerViewModelRenderer(ImageViewModelRender())
            mainRecyclerView.adapter = renderAdapter
            mainRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            renderAdapter.setData(getData())
        }
    }

    fun getData(): List<ItemModel> {
        return listOf(
            TitleModel("A"),
            TitleModel("B"),
            TitleModel("C"),
            TitleModel("D"),
            TitleModel("E"),
            ImageModel("https://www.trickscity.com/wp-content/uploads/2018/01/alone-sad-girl-whatsapp-dp-images.jpg"),
            ImageModel("https://www.trickscity.com/wp-content/uploads/2018/01/alone-sad-girl-whatsapp-dp-images.jpg"),
            ImageModel("https://www.trickscity.com/wp-content/uploads/2018/01/alone-sad-girl-whatsapp-dp-images.jpg"),
            ImageModel("https://www.trickscity.com/wp-content/uploads/2018/01/alone-sad-girl-whatsapp-dp-images.jpg"),
            TitleModel("E"),
            TitleModel("E"),
            TitleModel("E"),
            TitleModel("E"),
            TitleModel("E")
        )
    }
}

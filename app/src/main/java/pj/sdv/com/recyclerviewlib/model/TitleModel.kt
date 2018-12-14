package pj.sdv.com.recyclerviewlib.model

import pj.sdv.com.recyclerviewlib.abstr.ItemModel

class TitleModel(val title: String) : ItemModel {
    override val type: Int
        get() = TYPE

    companion object {
        const val TYPE = 1
    }
}
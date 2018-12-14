package pj.sdv.com.recyclerviewlib.model

import pj.sdv.com.recyclerviewlib.abstr.ItemModel

class ImageModel(val url: String) : ItemModel {
    override val type: Int
        get() = TYPE

    companion object {
        const val TYPE = 2
    }
}
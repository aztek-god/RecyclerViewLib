package pj.sdv.com.recyclerviewlib.abstr

interface ItemModel {
    val type: Int

    fun itemTheSame(another: ItemModel): Boolean {
        return this == another
    }

    fun contentTheSame(another: ItemModel): Boolean {
        return this == another
    }
}
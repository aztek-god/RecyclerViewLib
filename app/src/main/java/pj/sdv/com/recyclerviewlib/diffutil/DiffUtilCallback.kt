package pj.sdv.com.recyclerviewlib.diffutil

import android.support.v7.util.DiffUtil

abstract class DiffUtilCallback<T> : DiffUtil.Callback() {

    private val mOldDataList: MutableList<T> = mutableListOf()
    private val mNewDataList: MutableList<T> = mutableListOf()

    fun setItems(oldItems: List<T>, newItems: List<T>) {
        mOldDataList.clear()
        mOldDataList.addAll(oldItems)

        mNewDataList.clear()
        mNewDataList.addAll(newItems)
    }

    abstract fun areItemsTheSame(oldItem: T, newItem: T): Boolean

    abstract fun areContentsTheSame(oldItem: T, newItem: T): Boolean

    final override fun getOldListSize() = mOldDataList.size

    final override fun getNewListSize() = mNewDataList.size

    final override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return areItemsTheSame(mOldDataList[oldPosition], mNewDataList[newPosition])
    }

    final override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return areContentsTheSame(mOldDataList[oldPosition], mNewDataList[newPosition])
    }
}
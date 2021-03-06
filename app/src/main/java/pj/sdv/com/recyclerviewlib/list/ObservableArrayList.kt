package pj.sdv.com.recyclerviewlib.list

import java.lang.RuntimeException

internal class ObservableArrayList<T>(
    collection: Collection<T>? = null,
    private val onChangeListener: OnChangeListener<T>
) : ArrayList<T>(collection ?: mutableListOf()) {

    constructor(onChangeListener: OnChangeListener<T>) : this(null, onChangeListener)

    interface OnChangeListener<T> {
        fun onChange(oldList: Collection<T>, newList: Collection<T>)
    }

    private var isTransaction: Boolean = false

    private var mOldData: ArrayList<T>? = null

    fun beginTransaction() {
        if (isTransaction) {
            throw RuntimeException("The beginTransaction() method has been invoked twice.")
        }
        isTransaction = true
        mOldData = ArrayList(this)
    }

    fun commit() {
        if (!isTransaction) {
            throw RuntimeException("The commit() method has been invoked twice.")
        }

        isTransaction = false
        mOldData?.let {
            onChangeListener.onChange(it, this)
        }
        mOldData = null
    }


    override fun addAll(elements: Collection<T>): Boolean {
        val oldList = ArrayList(this)
        val res = super.addAll(elements)
        if (!isTransaction) {
            onChangeListener.onChange(oldList, this)
        }

        return res
    }

    override fun clear() {
        val oldList = ArrayList(this)
        super.clear()
        if (!isTransaction) {
            onChangeListener.onChange(oldList, this)
        }
    }

    override fun add(element: T): Boolean {
        val oldList = ArrayList(this)
        val res = super.add(element)
        if (!isTransaction) {
            onChangeListener.onChange(oldList, this)
        }

        return res
    }

    override fun add(index: Int, element: T) {
        val oldList = ArrayList(this)
        super.add(index, element)
        if (!isTransaction) {
            onChangeListener.onChange(oldList, this)
        }
    }

    override fun addAll(index: Int, elements: Collection<T>): Boolean {
        val oldList = ArrayList(this)
        val res = super.addAll(index, elements)
        if (!isTransaction) {
            onChangeListener.onChange(oldList, this)
        }

        return res
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        val oldList = ArrayList(this)
        val res = super.removeAll(elements)
        if (!isTransaction) {
            onChangeListener.onChange(oldList, this)
        }

        return res
    }

    override fun removeAt(index: Int): T {
        val oldList = ArrayList(this)
        val res = super.removeAt(index)
        if (!isTransaction) {
            onChangeListener.onChange(oldList, this)
        }

        return res
    }

    override fun remove(element: T): Boolean {
        val oldList = ArrayList(this)
        val res = super.remove(element)
        if (!isTransaction) {
            onChangeListener.onChange(oldList, this)
        }

        return res
    }

    override fun set(index: Int, element: T): T {
        val oldList = ArrayList(this)
        val res = super.set(index, element)
        if (!isTransaction) {
            onChangeListener.onChange(oldList, this)
        }

        return res
    }
}
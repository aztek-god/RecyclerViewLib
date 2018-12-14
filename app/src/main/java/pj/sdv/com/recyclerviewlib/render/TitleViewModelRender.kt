package pj.sdv.com.recyclerviewlib.render

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import pj.sdv.com.recyclerviewlib.R
import pj.sdv.com.recyclerviewlib.abstr.ViewModelRender
import pj.sdv.com.recyclerviewlib.model.TitleModel

class TitleViewModelRender : ViewModelRender<TitleModel, TitleViewModelRender.TitleViewHolder>(TitleModel.TYPE) {

    override fun bind(item: TitleModel?, viewHolder: TitleViewHolder?) {
        item?.let {
            viewHolder?.bind(it)
        }
    }

    override fun createViewHolder(parent: ViewGroup?): TitleViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.title_layout, parent, false)
        return TitleViewHolder(view)
    }

    class TitleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val mTitleTv: TextView = view.findViewById(R.id.titleTv)

        fun bind(model: TitleModel) {
            mTitleTv.text = model.title
        }
    }
}
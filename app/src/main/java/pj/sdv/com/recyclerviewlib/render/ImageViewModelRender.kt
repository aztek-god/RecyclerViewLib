package pj.sdv.com.recyclerviewlib.render

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import pj.sdv.com.recyclerviewlib.R
import pj.sdv.com.recyclerviewlib.abstr.ViewModelRender
import pj.sdv.com.recyclerviewlib.model.ImageModel

class ImageViewModelRender : ViewModelRender<ImageModel, ImageViewModelRender.ImageViewHolder>(ImageModel.TYPE) {

    override fun bind(item: ImageModel?, viewHolder: ImageViewHolder?) {
        item?.let {
            viewHolder?.bind(it)
        }
    }

    override fun createViewHolder(parent: ViewGroup?): ImageViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.icon_layout, parent, false)

        return ImageViewHolder(view)
    }

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val mImageView: ImageView = view.findViewById(R.id.iconIv)

        fun bind(item: ImageModel) {
            Glide
                .with(mImageView)
                .load(item.url)
                .into(mImageView)
        }
    }
}
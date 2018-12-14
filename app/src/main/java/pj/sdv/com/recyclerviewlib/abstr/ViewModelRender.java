package pj.sdv.com.recyclerviewlib.abstr;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.Objects;

public abstract class ViewModelRender<M extends ItemModel, VH extends RecyclerView.ViewHolder> {
    private int mType;

    public ViewModelRender(int mType) {
        this.mType = mType;
    }

    public abstract void bind(M item, VH viewHolder);

    public abstract VH createViewHolder(ViewGroup parent);

    public int getType() {
        return mType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewModelRender<?, ?> that = (ViewModelRender<?, ?>) o;
        return mType == that.mType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(mType);
    }
}

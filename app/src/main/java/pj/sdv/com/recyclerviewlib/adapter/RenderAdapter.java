package pj.sdv.com.recyclerviewlib.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.ViewGroup;
import pj.sdv.com.recyclerviewlib.abstr.ItemModel;
import pj.sdv.com.recyclerviewlib.abstr.ViewModelRender;

import java.util.ArrayList;
import java.util.List;

public class RenderAdapter extends RecyclerView.Adapter {

    private List<ItemModel> mData = new ArrayList<>();

    private SparseArray<ViewModelRender> mModelRenders = new SparseArray<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        ViewModelRender viewModelRender = mModelRenders.get(type);

        if (viewModelRender != null) {
            return viewModelRender.createViewHolder(viewGroup);
        } else {
            throw new RuntimeException("Wrong type of render = " + type);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        final ItemModel itemModel = mData.get(position);
        final ViewModelRender viewModelRender = mModelRenders.get(itemModel.getType());

        if (viewModelRender != null) {
            viewModelRender.bind(itemModel, viewHolder);
        } else {
            throw new RuntimeException("Wrong type of render = " + itemModel.getType());
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getType();
    }

    public void setData(final List<ItemModel> dataList) {
        mData.clear();
        mData.addAll(dataList);

        notifyDataSetChanged();
    }

    public void registerViewModelRenderer(@NonNull final ViewModelRender render) {
        mModelRenders.put(render.getType(), render);
    }
}

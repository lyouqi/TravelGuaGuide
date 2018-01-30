package com.standard.guaplayguide.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.standard.guaplayguide.R;
import com.standard.guaplayguide.bean.ModularBean;
import com.standard.guaplayguide.utils.LogUtil;
import com.standard.guaplayguide.utils.UiUtil;

import java.util.List;

/**
 * 纯文本模块适配器<文字>
 * Created by 小龙 on 2018/1/27.
 */

public class SmallGridViewAdapter extends RecyclerView.Adapter<SmallGridViewAdapter.ViewHolder> {
    private final String TAG = getClass().getName();
    private List<ModularBean> mModularBeanList;
    private Context mContext;
    private View.OnClickListener mOnModularClickListener;

    public SmallGridViewAdapter(Context context, List<ModularBean> modularBeanList) {
        mContext = context;
        mModularBeanList = modularBeanList;
    }

    /**
     * @param modularBeanList
     */
    public void setModularBeanList(List<ModularBean> modularBeanList) {
        if (mModularBeanList == null) {
            LogUtil.e(TAG + "please init data list in construction");
            return;
        }
        mModularBeanList.clear();
        this.mModularBeanList.addAll(modularBeanList);
        notifyDataSetChanged();
    }


    public void setOnModularClickListener(View.OnClickListener onModularClickListener) {
        this.mOnModularClickListener = onModularClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_small_grid, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(mModularBeanList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mModularBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvModularName;
        private ImageView ivModularImage;

        public ViewHolder(View itemView) {
            super(itemView);
            tvModularName = itemView.findViewById(R.id.tvModularName);
            ivModularImage = itemView.findViewById(R.id.ivModularImage);
        }

        public void setData(ModularBean data, int position) {
            tvModularName.setText(data.title);
            UiUtil.setCircleImage(ivModularImage, data.imageUrl, ivModularImage.getWidth(), R.drawable.ic_loading, R.drawable.ic_loading);
        }
    }
}

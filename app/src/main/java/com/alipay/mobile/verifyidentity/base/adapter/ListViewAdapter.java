package com.alipay.mobile.verifyidentity.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class ListViewAdapter<T> extends BaseAdapter {
    private int layoutId;
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public abstract void convert(ViewHolder viewHolder, T t, int i);

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public ListViewAdapter(Context context, List<T> list, int i) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mDatas = list;
        this.layoutId = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDatas.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return this.mDatas.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = ViewHolder.get(this.mContext, view, viewGroup, this.layoutId, i);
        convert(viewHolder, getItem(i), i);
        return viewHolder.getConvertView();
    }
}

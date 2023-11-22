package com.alibaba.griver.image.photo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class PhotoAdapter<T> extends BaseAdapter {
    protected Context context;
    protected List<T> dataList;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public PhotoAdapter(Context context, List<T> list) {
        ArrayList arrayList = new ArrayList();
        this.dataList = arrayList;
        this.context = context;
        if (list != null) {
            arrayList.addAll(list);
        }
    }

    public void addDatas(List<T> list) {
        this.dataList.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.dataList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dataList.get(i);
    }

    public void setData(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.dataList.clear();
        this.dataList.addAll(list);
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return this.dataList;
    }
}

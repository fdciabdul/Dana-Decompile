package com.alibaba.griver.image.photo.adapter;

import android.util.SparseArray;
import android.view.View;

/* loaded from: classes6.dex */
public class ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<View> f6605a = new SparseArray<>();
    private View b;

    public static ViewHolder get(View view) {
        Object tag = view.getTag();
        if (tag instanceof ViewHolder) {
            return (ViewHolder) tag;
        }
        return new ViewHolder(view);
    }

    private ViewHolder(View view) {
        this.b = view;
        view.setTag(this);
    }

    public <T extends View> T findViewById(int i) {
        T t = (T) this.f6605a.get(i);
        if (t == null) {
            T t2 = (T) this.b.findViewById(i);
            this.f6605a.put(i, t2);
            return t2;
        }
        return t;
    }
}

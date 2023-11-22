package com.yarolegovich.discretescrollview.util;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

/* loaded from: classes8.dex */
public class ScrollListenerAdapter<T extends RecyclerView.ViewHolder> implements DiscreteScrollView.ScrollStateChangeListener<T> {
    private DiscreteScrollView.ScrollListener<T> MyBillsEntityDataFactory;

    public ScrollListenerAdapter(DiscreteScrollView.ScrollListener<T> scrollListener) {
        this.MyBillsEntityDataFactory = scrollListener;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ScrollListenerAdapter) {
            return this.MyBillsEntityDataFactory.equals(((ScrollListenerAdapter) obj).MyBillsEntityDataFactory);
        }
        return super.equals(obj);
    }
}

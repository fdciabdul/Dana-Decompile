package com.ethanhua.skeleton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class ShimmerViewHolder extends RecyclerView.ViewHolder {
    public ShimmerViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        super(layoutInflater.inflate(R.layout.layout_shimmer, viewGroup, false));
        ViewGroup viewGroup2 = (ViewGroup) this.itemView;
        View inflate = layoutInflater.inflate(i, viewGroup2, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams != null) {
            viewGroup2.setLayoutParams(layoutParams);
        }
        viewGroup2.addView(inflate);
    }
}

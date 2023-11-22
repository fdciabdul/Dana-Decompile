package com.ethanhua.skeleton;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import io.supercharge.shimmerlayout.ShimmerLayout;

/* loaded from: classes3.dex */
public class SkeletonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int BuiltInFictitiousFunctionClassFactory;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    int MyBillsEntityDataFactory;
    int PlaceComponentResult;
    boolean getAuthRequestContext;
    int moveToNextValue;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (this.getAuthRequestContext) {
            return new ShimmerViewHolder(from, viewGroup, this.BuiltInFictitiousFunctionClassFactory);
        }
        return new RecyclerView.ViewHolder(from.inflate(this.BuiltInFictitiousFunctionClassFactory, viewGroup, false)) { // from class: com.ethanhua.skeleton.SkeletonAdapter.1
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (this.getAuthRequestContext) {
            ShimmerLayout shimmerLayout = (ShimmerLayout) viewHolder.itemView;
            shimmerLayout.setShimmerAnimationDuration(this.moveToNextValue);
            shimmerLayout.setShimmerAngle(this.KClassImpl$Data$declaredNonStaticMembers$2);
            shimmerLayout.setShimmerColor(this.PlaceComponentResult);
            shimmerLayout.startShimmerAnimation();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.MyBillsEntityDataFactory;
    }
}

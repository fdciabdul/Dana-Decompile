package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda1 = true;

    public abstract boolean BuiltInFictitiousFunctionClassFactory(RecyclerView.ViewHolder viewHolder);

    public abstract boolean BuiltInFictitiousFunctionClassFactory(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4);

    public abstract boolean KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4);

    public abstract boolean PlaceComponentResult(RecyclerView.ViewHolder viewHolder);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean MyBillsEntityDataFactory(RecyclerView.ViewHolder viewHolder) {
        return !this.NetworkUserEntityData$$ExternalSyntheticLambda1 || viewHolder.isInvalid();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean MyBillsEntityDataFactory(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i = itemHolderInfo.BuiltInFictitiousFunctionClassFactory;
        int i2 = itemHolderInfo.PlaceComponentResult;
        View view = viewHolder.itemView;
        int left = itemHolderInfo2 == null ? view.getLeft() : itemHolderInfo2.BuiltInFictitiousFunctionClassFactory;
        int top = itemHolderInfo2 == null ? view.getTop() : itemHolderInfo2.PlaceComponentResult;
        if (!viewHolder.isRemoved() && (i != left || i2 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return KClassImpl$Data$declaredNonStaticMembers$2(viewHolder, i, i2, left, top);
        }
        return BuiltInFictitiousFunctionClassFactory(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        if (itemHolderInfo != null && (itemHolderInfo.BuiltInFictitiousFunctionClassFactory != itemHolderInfo2.BuiltInFictitiousFunctionClassFactory || itemHolderInfo.PlaceComponentResult != itemHolderInfo2.PlaceComponentResult)) {
            return KClassImpl$Data$declaredNonStaticMembers$2(viewHolder, itemHolderInfo.BuiltInFictitiousFunctionClassFactory, itemHolderInfo.PlaceComponentResult, itemHolderInfo2.BuiltInFictitiousFunctionClassFactory, itemHolderInfo2.PlaceComponentResult);
        }
        return PlaceComponentResult(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean PlaceComponentResult(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        if (itemHolderInfo.BuiltInFictitiousFunctionClassFactory != itemHolderInfo2.BuiltInFictitiousFunctionClassFactory || itemHolderInfo.PlaceComponentResult != itemHolderInfo2.PlaceComponentResult) {
            return KClassImpl$Data$declaredNonStaticMembers$2(viewHolder, itemHolderInfo.BuiltInFictitiousFunctionClassFactory, itemHolderInfo.PlaceComponentResult, itemHolderInfo2.BuiltInFictitiousFunctionClassFactory, itemHolderInfo2.PlaceComponentResult);
        }
        RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = this.lookAheadTest;
        if (itemAnimatorListener != null) {
            itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder);
            return false;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean PlaceComponentResult(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i;
        int i2;
        int i3 = itemHolderInfo.BuiltInFictitiousFunctionClassFactory;
        int i4 = itemHolderInfo.PlaceComponentResult;
        if (viewHolder2.shouldIgnore()) {
            int i5 = itemHolderInfo.BuiltInFictitiousFunctionClassFactory;
            i2 = itemHolderInfo.PlaceComponentResult;
            i = i5;
        } else {
            i = itemHolderInfo2.BuiltInFictitiousFunctionClassFactory;
            i2 = itemHolderInfo2.PlaceComponentResult;
        }
        return BuiltInFictitiousFunctionClassFactory(viewHolder, viewHolder2, i3, i4, i, i2);
    }
}

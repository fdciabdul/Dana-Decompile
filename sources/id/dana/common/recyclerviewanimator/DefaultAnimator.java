package id.dana.common.recyclerviewanimator;

import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.common.recyclerviewanimator.BaseItemAnimator;

/* loaded from: classes4.dex */
public class DefaultAnimator<T> extends BaseItemAnimator<T> {
    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator
    public void lookAheadTest(RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setAlpha(0.0f);
    }

    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator
    public void NetworkUserEntityData$$ExternalSyntheticLambda1(RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setAlpha(1.0f);
    }

    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator
    public void scheduleImpl(RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setAlpha(1.0f);
    }

    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0(RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setAlpha(1.0f);
    }

    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator
    public ViewPropertyAnimatorCompat GetContactSyncConfig(RecyclerView.ViewHolder viewHolder) {
        return ViewCompat.MyBillsEntityDataFactory(viewHolder.itemView).KClassImpl$Data$declaredNonStaticMembers$2(this.GetContactSyncConfig).getAuthRequestContext(0.0f).MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator
    public ViewPropertyAnimatorCompat getErrorConfigVersion(RecyclerView.ViewHolder viewHolder) {
        return ViewCompat.MyBillsEntityDataFactory(viewHolder.itemView).getAuthRequestContext(1.0f).KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0).MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator
    public final ViewPropertyAnimatorCompat PlaceComponentResult(RecyclerView.ViewHolder viewHolder, BaseItemAnimator.ChangeInfo changeInfo) {
        return ViewCompat.MyBillsEntityDataFactory(viewHolder.itemView).KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue).getAuthRequestContext(0.0f).MyBillsEntityDataFactory(changeInfo.BuiltInFictitiousFunctionClassFactory - changeInfo.PlaceComponentResult).PlaceComponentResult(changeInfo.NetworkUserEntityData$$ExternalSyntheticLambda0 - changeInfo.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator
    public final ViewPropertyAnimatorCompat moveToNextValue(RecyclerView.ViewHolder viewHolder) {
        return ViewCompat.MyBillsEntityDataFactory(viewHolder.itemView).MyBillsEntityDataFactory(0.0f).PlaceComponentResult(0.0f).KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue).getAuthRequestContext(1.0f).MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
    }
}

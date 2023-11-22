package id.dana.common.recyclerviewanimator;

import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public class SlideDownAlphaAnimator extends DefaultAnimator<SlideDownAlphaAnimator> {
    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator
    public final long BuiltInFictitiousFunctionClassFactory(long j, long j2, long j3) {
        return 0L;
    }

    @Override // id.dana.common.recyclerviewanimator.DefaultAnimator, id.dana.common.recyclerviewanimator.BaseItemAnimator
    public final void lookAheadTest(RecyclerView.ViewHolder viewHolder) {
        ViewCompat.BuiltInFictitiousFunctionClassFactory(viewHolder.itemView, -viewHolder.itemView.getHeight());
        viewHolder.itemView.setAlpha(0.0f);
    }

    @Override // id.dana.common.recyclerviewanimator.DefaultAnimator, id.dana.common.recyclerviewanimator.BaseItemAnimator
    public final void NetworkUserEntityData$$ExternalSyntheticLambda1(RecyclerView.ViewHolder viewHolder) {
        ViewCompat.BuiltInFictitiousFunctionClassFactory(viewHolder.itemView, 0.0f);
        viewHolder.itemView.setAlpha(1.0f);
    }

    @Override // id.dana.common.recyclerviewanimator.DefaultAnimator, id.dana.common.recyclerviewanimator.BaseItemAnimator
    public final void scheduleImpl(RecyclerView.ViewHolder viewHolder) {
        ViewCompat.BuiltInFictitiousFunctionClassFactory(viewHolder.itemView, 0.0f);
        viewHolder.itemView.setAlpha(1.0f);
    }

    @Override // id.dana.common.recyclerviewanimator.DefaultAnimator, id.dana.common.recyclerviewanimator.BaseItemAnimator
    public final ViewPropertyAnimatorCompat GetContactSyncConfig(RecyclerView.ViewHolder viewHolder) {
        return ViewCompat.MyBillsEntityDataFactory(viewHolder.itemView).KClassImpl$Data$declaredNonStaticMembers$2(this.GetContactSyncConfig).getAuthRequestContext(0.0f).PlaceComponentResult(viewHolder.itemView.getHeight()).MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.common.recyclerviewanimator.DefaultAnimator, id.dana.common.recyclerviewanimator.BaseItemAnimator
    public final ViewPropertyAnimatorCompat getErrorConfigVersion(RecyclerView.ViewHolder viewHolder) {
        return ViewCompat.MyBillsEntityDataFactory(viewHolder.itemView).PlaceComponentResult(0.0f).getAuthRequestContext(1.0f).KClassImpl$Data$declaredNonStaticMembers$2(this.initRecordTimeStamp).MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator
    public final long getAuthRequestContext(long j, long j2, long j3) {
        return j / 2;
    }
}

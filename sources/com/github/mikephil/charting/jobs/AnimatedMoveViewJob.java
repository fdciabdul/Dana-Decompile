package com.github.mikephil.charting.jobs;

import android.animation.ValueAnimator;
import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: classes7.dex */
public class AnimatedMoveViewJob extends AnimatedViewPortJob {
    private static ObjectPool<AnimatedMoveViewJob> PlaceComponentResult;

    static {
        ObjectPool<AnimatedMoveViewJob> PlaceComponentResult2 = ObjectPool.PlaceComponentResult(4, new AnimatedMoveViewJob());
        PlaceComponentResult = PlaceComponentResult2;
        PlaceComponentResult2.PlaceComponentResult = 0.5f;
    }

    public static AnimatedMoveViewJob MyBillsEntityDataFactory(ViewPortHandler viewPortHandler, float f, float f2, Transformer transformer, View view, float f3, float f4, long j) {
        AnimatedMoveViewJob PlaceComponentResult2 = PlaceComponentResult.PlaceComponentResult();
        PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda1 = viewPortHandler;
        PlaceComponentResult2.isLayoutRequested = f;
        PlaceComponentResult2.newProxyInstance = f2;
        PlaceComponentResult2.DatabaseTableConfigUtil = transformer;
        PlaceComponentResult2.initRecordTimeStamp = view;
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = f3;
        PlaceComponentResult2.MyBillsEntityDataFactory = f4;
        PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2.setDuration(j);
        return PlaceComponentResult2;
    }

    private AnimatedMoveViewJob() {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.GetContactSyncConfig[0] = this.BuiltInFictitiousFunctionClassFactory + ((this.isLayoutRequested - this.BuiltInFictitiousFunctionClassFactory) * this.getAuthRequestContext);
        this.GetContactSyncConfig[1] = this.MyBillsEntityDataFactory + ((this.newProxyInstance - this.MyBillsEntityDataFactory) * this.getAuthRequestContext);
        this.DatabaseTableConfigUtil.PlaceComponentResult(this.GetContactSyncConfig);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(this.GetContactSyncConfig, this.initRecordTimeStamp);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    public final ObjectPool.Poolable MyBillsEntityDataFactory() {
        return new AnimatedMoveViewJob();
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob
    public final void PlaceComponentResult() {
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((ObjectPool<AnimatedMoveViewJob>) this);
    }
}

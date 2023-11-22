package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: classes7.dex */
public class AnimatedZoomJob extends AnimatedViewPortJob implements Animator.AnimatorListener {
    private static ObjectPool<AnimatedZoomJob> NetworkUserEntityData$$ExternalSyntheticLambda7 = ObjectPool.PlaceComponentResult(8, new AnimatedZoomJob());
    protected float NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected YAxis getErrorConfigVersion;
    protected Matrix PlaceComponentResult = new Matrix();
    protected float lookAheadTest = 0.0f;
    protected float scheduleImpl = 0.0f;
    protected float moveToNextValue = 0.0f;
    protected float NetworkUserEntityData$$ExternalSyntheticLambda2 = 0.0f;

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob
    public final void PlaceComponentResult() {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    public static AnimatedZoomJob PlaceComponentResult(ViewPortHandler viewPortHandler, View view, Transformer transformer, YAxis yAxis, float f, float f2, float f3, float f4, float f5, long j) {
        AnimatedZoomJob PlaceComponentResult = NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult();
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1 = viewPortHandler;
        PlaceComponentResult.isLayoutRequested = f2;
        PlaceComponentResult.newProxyInstance = f3;
        PlaceComponentResult.DatabaseTableConfigUtil = transformer;
        PlaceComponentResult.initRecordTimeStamp = view;
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = f4;
        PlaceComponentResult.MyBillsEntityDataFactory = f5;
        PlaceComponentResult.getErrorConfigVersion = yAxis;
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 = f;
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.setDuration(j);
        return PlaceComponentResult;
    }

    private AnimatedZoomJob() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.addListener(this);
        this.getErrorConfigVersion = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0.0f;
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f = this.BuiltInFictitiousFunctionClassFactory;
        float f2 = this.isLayoutRequested;
        float f3 = this.BuiltInFictitiousFunctionClassFactory;
        float f4 = this.getAuthRequestContext;
        float f5 = this.MyBillsEntityDataFactory;
        float f6 = this.newProxyInstance;
        float f7 = this.MyBillsEntityDataFactory;
        float f8 = this.getAuthRequestContext;
        Matrix matrix = this.PlaceComponentResult;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(f + ((f2 - f3) * f4), f5 + ((f6 - f7) * f8), matrix);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(matrix, this.initRecordTimeStamp, false);
        float f9 = this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0 / this.NetworkUserEntityData$$ExternalSyntheticLambda1.getErrorConfigVersion;
        float f10 = this.NetworkUserEntityData$$ExternalSyntheticLambda0 / this.NetworkUserEntityData$$ExternalSyntheticLambda1.scheduleImpl;
        float[] fArr = this.GetContactSyncConfig;
        float f11 = this.moveToNextValue;
        fArr[0] = f11 + (((this.lookAheadTest - (f10 / 2.0f)) - f11) * this.getAuthRequestContext);
        float[] fArr2 = this.GetContactSyncConfig;
        float f12 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        fArr2[1] = f12 + (((this.scheduleImpl + (f9 / 2.0f)) - f12) * this.getAuthRequestContext);
        this.DatabaseTableConfigUtil.PlaceComponentResult(this.GetContactSyncConfig);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(this.GetContactSyncConfig, matrix);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(matrix, this.initRecordTimeStamp, true);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ((BarLineChartBase) this.initRecordTimeStamp).calculateOffsets();
        this.initRecordTimeStamp.postInvalidate();
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    public final ObjectPool.Poolable MyBillsEntityDataFactory() {
        return new AnimatedZoomJob();
    }
}

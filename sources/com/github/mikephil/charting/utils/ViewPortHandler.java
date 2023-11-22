package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes3.dex */
public class ViewPortHandler {
    protected final Matrix getAuthRequestContext = new Matrix();
    protected RectF MyBillsEntityDataFactory = new RectF();
    protected float KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
    protected float BuiltInFictitiousFunctionClassFactory = 0.0f;
    private float DatabaseTableConfigUtil = 1.0f;
    private float NetworkUserEntityData$$ExternalSyntheticLambda1 = Float.MAX_VALUE;
    private float NetworkUserEntityData$$ExternalSyntheticLambda2 = 1.0f;
    private float GetContactSyncConfig = Float.MAX_VALUE;
    public float scheduleImpl = 1.0f;
    public float getErrorConfigVersion = 1.0f;
    private float NetworkUserEntityData$$ExternalSyntheticLambda8 = 0.0f;
    private float PrepareContext = 0.0f;
    public float moveToNextValue = 0.0f;
    public float NetworkUserEntityData$$ExternalSyntheticLambda0 = 0.0f;
    protected float[] initRecordTimeStamp = new float[9];
    protected Matrix PlaceComponentResult = new Matrix();
    protected final float[] lookAheadTest = new float[9];

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return this.BuiltInFictitiousFunctionClassFactory > 0.0f && this.KClassImpl$Data$declaredNonStaticMembers$2 > 0.0f;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, float f3, float f4) {
        this.MyBillsEntityDataFactory.set(f, f2, this.KClassImpl$Data$declaredNonStaticMembers$2 - f3, this.BuiltInFictitiousFunctionClassFactory - f4);
    }

    public final float FragmentBottomSheetPaymentSettingBinding() {
        return this.MyBillsEntityDataFactory.left;
    }

    public final float NetworkUserEntityData$$ExternalSyntheticLambda6() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 - this.MyBillsEntityDataFactory.right;
    }

    public final float NetworkUserEntityData$$ExternalSyntheticLambda3() {
        return this.MyBillsEntityDataFactory.top;
    }

    public final float NetworkUserEntityData$$ExternalSyntheticLambda4() {
        return this.BuiltInFictitiousFunctionClassFactory - this.MyBillsEntityDataFactory.bottom;
    }

    public final float moveToNextValue() {
        return this.MyBillsEntityDataFactory.top;
    }

    public final float scheduleImpl() {
        return this.MyBillsEntityDataFactory.left;
    }

    public final float lookAheadTest() {
        return this.MyBillsEntityDataFactory.right;
    }

    public final float BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory.bottom;
    }

    public final float NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.MyBillsEntityDataFactory.width();
    }

    public final float getErrorConfigVersion() {
        return this.MyBillsEntityDataFactory.height();
    }

    public final RectF GetContactSyncConfig() {
        return this.MyBillsEntityDataFactory;
    }

    public final MPPointF DatabaseTableConfigUtil() {
        return MPPointF.getAuthRequestContext(this.MyBillsEntityDataFactory.centerX(), this.MyBillsEntityDataFactory.centerY());
    }

    public final float NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final float initRecordTimeStamp() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final float PrepareContext() {
        return Math.min(this.MyBillsEntityDataFactory.width(), this.MyBillsEntityDataFactory.height());
    }

    public final void PlaceComponentResult(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.getAuthRequestContext);
        matrix.postScale(1.4f, 1.4f, f, f2);
    }

    public final void BuiltInFictitiousFunctionClassFactory(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.getAuthRequestContext);
        matrix.postScale(0.7f, 0.7f, f, f2);
    }

    public final void PlaceComponentResult(Matrix matrix) {
        matrix.reset();
        matrix.set(this.getAuthRequestContext);
        matrix.postScale(1.0f, 1.0f, 0.0f, 0.0f);
    }

    public final void getAuthRequestContext(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.getAuthRequestContext);
        matrix.postScale(f, f2);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, float f3, float f4, Matrix matrix) {
        matrix.reset();
        matrix.set(this.getAuthRequestContext);
        matrix.postScale(f, f2, f3, f4);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.getAuthRequestContext);
        matrix.setScale(f, f2);
    }

    public final void getAuthRequestContext(Matrix matrix) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 1.0f;
        this.DatabaseTableConfigUtil = 1.0f;
        matrix.set(this.getAuthRequestContext);
        float[] fArr = this.initRecordTimeStamp;
        for (int i = 0; i < 9; i++) {
            fArr[i] = 0.0f;
        }
        matrix.getValues(fArr);
        fArr[2] = 0.0f;
        fArr[5] = 0.0f;
        fArr[0] = 1.0f;
        fArr[4] = 1.0f;
        matrix.setValues(fArr);
    }

    public final void MyBillsEntityDataFactory(float[] fArr, Matrix matrix) {
        matrix.reset();
        matrix.set(this.getAuthRequestContext);
        matrix.postTranslate(-(fArr[0] - this.MyBillsEntityDataFactory.left), -(fArr[1] - this.MyBillsEntityDataFactory.top));
    }

    public final void MyBillsEntityDataFactory(float[] fArr, View view) {
        Matrix matrix = this.PlaceComponentResult;
        matrix.reset();
        matrix.set(this.getAuthRequestContext);
        matrix.postTranslate(-(fArr[0] - this.MyBillsEntityDataFactory.left), -(fArr[1] - this.MyBillsEntityDataFactory.top));
        MyBillsEntityDataFactory(matrix, view, true);
    }

    public final Matrix MyBillsEntityDataFactory(Matrix matrix, View view, boolean z) {
        this.getAuthRequestContext.set(matrix);
        BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, this.MyBillsEntityDataFactory);
        if (z) {
            view.invalidate();
        }
        matrix.set(this.getAuthRequestContext);
        return matrix;
    }

    private void BuiltInFictitiousFunctionClassFactory(Matrix matrix, RectF rectF) {
        float f;
        matrix.getValues(this.lookAheadTest);
        float[] fArr = this.lookAheadTest;
        float f2 = fArr[2];
        float f3 = fArr[0];
        float f4 = fArr[5];
        float f5 = fArr[4];
        this.scheduleImpl = Math.min(Math.max(this.NetworkUserEntityData$$ExternalSyntheticLambda2, f3), this.GetContactSyncConfig);
        this.getErrorConfigVersion = Math.min(Math.max(this.DatabaseTableConfigUtil, f5), this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        float f6 = 0.0f;
        if (rectF != null) {
            f6 = rectF.width();
            f = rectF.height();
        } else {
            f = 0.0f;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = Math.min(Math.max(f2, ((-f6) * (this.scheduleImpl - 1.0f)) - this.moveToNextValue), this.moveToNextValue);
        float max = Math.max(Math.min(f4, (f * (this.getErrorConfigVersion - 1.0f)) + this.NetworkUserEntityData$$ExternalSyntheticLambda0), -this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        this.PrepareContext = max;
        float[] fArr2 = this.lookAheadTest;
        fArr2[2] = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        fArr2[0] = this.scheduleImpl;
        fArr2[5] = max;
        fArr2[4] = this.getErrorConfigVersion;
        matrix.setValues(fArr2);
    }

    public final void moveToNextValue(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = f;
        BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, this.MyBillsEntityDataFactory);
    }

    public final void scheduleImpl(float f) {
        if (f == 0.0f) {
            f = Float.MAX_VALUE;
        }
        this.GetContactSyncConfig = f;
        BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, this.MyBillsEntityDataFactory);
    }

    public final void MyBillsEntityDataFactory(float f, float f2) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = f;
        this.GetContactSyncConfig = f2;
        BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, this.MyBillsEntityDataFactory);
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.DatabaseTableConfigUtil = f;
        BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, this.MyBillsEntityDataFactory);
    }

    public final void lookAheadTest(float f) {
        if (f == 0.0f) {
            f = Float.MAX_VALUE;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = f;
        BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, this.MyBillsEntityDataFactory);
    }

    public final void BuiltInFictitiousFunctionClassFactory(float f, float f2) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.DatabaseTableConfigUtil = f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = f2;
        BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, this.MyBillsEntityDataFactory);
    }

    public final Matrix NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return this.getAuthRequestContext;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        return getAuthRequestContext(f) && MyBillsEntityDataFactory(f);
    }

    public final boolean getErrorConfigVersion(float f) {
        return PlaceComponentResult(f) && BuiltInFictitiousFunctionClassFactory(f);
    }

    public final boolean PlaceComponentResult(float f, float f2) {
        return KClassImpl$Data$declaredNonStaticMembers$2(f) && getErrorConfigVersion(f2);
    }

    public final boolean getAuthRequestContext(float f) {
        return this.MyBillsEntityDataFactory.left <= f + 1.0f;
    }

    public final boolean MyBillsEntityDataFactory(float f) {
        return this.MyBillsEntityDataFactory.right >= (((float) ((int) (f * 100.0f))) / 100.0f) - 1.0f;
    }

    public final boolean PlaceComponentResult(float f) {
        return this.MyBillsEntityDataFactory.top <= f;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(float f) {
        return this.MyBillsEntityDataFactory.bottom >= ((float) ((int) (f * 100.0f))) / 100.0f;
    }

    public final boolean newProxyInstance() {
        return NetworkUserEntityData$$ExternalSyntheticLambda7() && NetworkUserEntityData$$ExternalSyntheticLambda5();
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda5() {
        float f = this.getErrorConfigVersion;
        float f2 = this.DatabaseTableConfigUtil;
        return f <= f2 && f2 <= 1.0f;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda7() {
        float f = this.scheduleImpl;
        float f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        return f <= f2 && f2 <= 1.0f;
    }

    public final boolean isLayoutRequested() {
        return this.moveToNextValue <= 0.0f && this.NetworkUserEntityData$$ExternalSyntheticLambda0 <= 0.0f;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl > this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.scheduleImpl < this.GetContactSyncConfig;
    }

    public final boolean PlaceComponentResult() {
        return this.getErrorConfigVersion > this.DatabaseTableConfigUtil;
    }

    public final boolean getAuthRequestContext() {
        return this.getErrorConfigVersion < this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public final void getAuthRequestContext(float f, float f2) {
        float f3 = this.MyBillsEntityDataFactory.left;
        float f4 = this.MyBillsEntityDataFactory.top;
        float f5 = this.KClassImpl$Data$declaredNonStaticMembers$2 - this.MyBillsEntityDataFactory.right;
        float f6 = this.BuiltInFictitiousFunctionClassFactory - this.MyBillsEntityDataFactory.bottom;
        this.BuiltInFictitiousFunctionClassFactory = f2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        this.MyBillsEntityDataFactory.set(f3, f4, f - f5, f2 - f6);
    }
}

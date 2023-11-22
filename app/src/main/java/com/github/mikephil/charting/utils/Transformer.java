package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;

/* loaded from: classes3.dex */
public class Transformer {
    protected ViewPortHandler getAuthRequestContext;
    protected Matrix BuiltInFictitiousFunctionClassFactory = new Matrix();
    protected Matrix MyBillsEntityDataFactory = new Matrix();
    protected float[] scheduleImpl = new float[1];
    protected float[] getErrorConfigVersion = new float[1];
    protected float[] NetworkUserEntityData$$ExternalSyntheticLambda0 = new float[1];
    protected float[] moveToNextValue = new float[1];
    protected Matrix PlaceComponentResult = new Matrix();
    float[] KClassImpl$Data$declaredNonStaticMembers$2 = new float[2];
    private Matrix lookAheadTest = new Matrix();
    private Matrix NetworkUserEntityData$$ExternalSyntheticLambda2 = new Matrix();

    public Transformer(ViewPortHandler viewPortHandler) {
        this.getAuthRequestContext = viewPortHandler;
    }

    public final void BuiltInFictitiousFunctionClassFactory(float f, float f2, float f3, float f4) {
        float NetworkUserEntityData$$ExternalSyntheticLambda0 = this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0() / f2;
        float errorConfigVersion = this.getAuthRequestContext.getErrorConfigVersion() / f3;
        if (Float.isInfinite(NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            NetworkUserEntityData$$ExternalSyntheticLambda0 = 0.0f;
        }
        if (Float.isInfinite(errorConfigVersion)) {
            errorConfigVersion = 0.0f;
        }
        this.BuiltInFictitiousFunctionClassFactory.reset();
        this.BuiltInFictitiousFunctionClassFactory.postTranslate(-f, -f4);
        this.BuiltInFictitiousFunctionClassFactory.postScale(NetworkUserEntityData$$ExternalSyntheticLambda0, -errorConfigVersion);
    }

    public void BuiltInFictitiousFunctionClassFactory(boolean z) {
        this.MyBillsEntityDataFactory.reset();
        if (!z) {
            this.MyBillsEntityDataFactory.postTranslate(this.getAuthRequestContext.FragmentBottomSheetPaymentSettingBinding(), this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1() - this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda4());
            return;
        }
        this.MyBillsEntityDataFactory.setTranslate(this.getAuthRequestContext.FragmentBottomSheetPaymentSettingBinding(), -this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda3());
        this.MyBillsEntityDataFactory.postScale(1.0f, -1.0f);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    public final float[] KClassImpl$Data$declaredNonStaticMembers$2(IScatterDataSet iScatterDataSet, float f, float f2, int i, int i2) {
        int i3 = ((int) (((i2 - i) * f) + 1.0f)) * 2;
        if (this.scheduleImpl.length != i3) {
            this.scheduleImpl = new float[i3];
        }
        float[] fArr = this.scheduleImpl;
        for (int i4 = 0; i4 < i3; i4 += 2) {
            ?? errorConfigVersion = iScatterDataSet.getErrorConfigVersion((i4 / 2) + i);
            if (errorConfigVersion != 0) {
                fArr[i4] = errorConfigVersion.MyBillsEntityDataFactory();
                fArr[i4 + 1] = errorConfigVersion.getAuthRequestContext() * f2;
            } else {
                fArr[i4] = 0.0f;
                fArr[i4 + 1] = 0.0f;
            }
        }
        MyBillsEntityDataFactory().mapPoints(fArr);
        return fArr;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    public final float[] KClassImpl$Data$declaredNonStaticMembers$2(IBubbleDataSet iBubbleDataSet, float f, int i, int i2) {
        int i3 = ((i2 - i) + 1) * 2;
        if (this.getErrorConfigVersion.length != i3) {
            this.getErrorConfigVersion = new float[i3];
        }
        float[] fArr = this.getErrorConfigVersion;
        for (int i4 = 0; i4 < i3; i4 += 2) {
            ?? errorConfigVersion = iBubbleDataSet.getErrorConfigVersion((i4 / 2) + i);
            if (errorConfigVersion != 0) {
                fArr[i4] = errorConfigVersion.MyBillsEntityDataFactory();
                fArr[i4 + 1] = errorConfigVersion.getAuthRequestContext() * f;
            } else {
                fArr[i4] = 0.0f;
                fArr[i4 + 1] = 0.0f;
            }
        }
        MyBillsEntityDataFactory().mapPoints(fArr);
        return fArr;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    public final float[] KClassImpl$Data$declaredNonStaticMembers$2(ILineDataSet iLineDataSet, float f, float f2, int i, int i2) {
        int i3 = (((int) ((i2 - i) * f)) + 1) * 2;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.length != i3) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new float[i3];
        }
        float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        for (int i4 = 0; i4 < i3; i4 += 2) {
            ?? errorConfigVersion = iLineDataSet.getErrorConfigVersion((i4 / 2) + i);
            if (errorConfigVersion != 0) {
                fArr[i4] = errorConfigVersion.MyBillsEntityDataFactory();
                fArr[i4 + 1] = errorConfigVersion.getAuthRequestContext() * f2;
            } else {
                fArr[i4] = 0.0f;
                fArr[i4 + 1] = 0.0f;
            }
        }
        MyBillsEntityDataFactory().mapPoints(fArr);
        return fArr;
    }

    public final float[] getAuthRequestContext(ICandleDataSet iCandleDataSet, float f, float f2, int i, int i2) {
        int i3 = ((int) (((i2 - i) * f) + 1.0f)) * 2;
        if (this.moveToNextValue.length != i3) {
            this.moveToNextValue = new float[i3];
        }
        float[] fArr = this.moveToNextValue;
        for (int i4 = 0; i4 < i3; i4 += 2) {
            CandleEntry candleEntry = (CandleEntry) iCandleDataSet.getErrorConfigVersion((i4 / 2) + i);
            if (candleEntry != null) {
                fArr[i4] = candleEntry.MyBillsEntityDataFactory();
                fArr[i4 + 1] = candleEntry.getAuthRequestContext * f2;
            } else {
                fArr[i4] = 0.0f;
                fArr[i4 + 1] = 0.0f;
            }
        }
        MyBillsEntityDataFactory().mapPoints(fArr);
        return fArr;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Path path) {
        path.transform(this.BuiltInFictitiousFunctionClassFactory);
        path.transform(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2());
        path.transform(this.MyBillsEntityDataFactory);
    }

    public final void PlaceComponentResult(float[] fArr) {
        this.BuiltInFictitiousFunctionClassFactory.mapPoints(fArr);
        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2().mapPoints(fArr);
        this.MyBillsEntityDataFactory.mapPoints(fArr);
    }

    public final void MyBillsEntityDataFactory(RectF rectF) {
        this.BuiltInFictitiousFunctionClassFactory.mapRect(rectF);
        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2().mapRect(rectF);
        this.MyBillsEntityDataFactory.mapRect(rectF);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(RectF rectF, float f) {
        rectF.top *= f;
        rectF.bottom *= f;
        this.BuiltInFictitiousFunctionClassFactory.mapRect(rectF);
        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2().mapRect(rectF);
        this.MyBillsEntityDataFactory.mapRect(rectF);
    }

    public final void getAuthRequestContext(RectF rectF, float f) {
        rectF.left *= f;
        rectF.right *= f;
        this.BuiltInFictitiousFunctionClassFactory.mapRect(rectF);
        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2().mapRect(rectF);
        this.MyBillsEntityDataFactory.mapRect(rectF);
    }

    public final void getAuthRequestContext(float[] fArr) {
        Matrix matrix = this.PlaceComponentResult;
        matrix.reset();
        this.MyBillsEntityDataFactory.invert(matrix);
        matrix.mapPoints(fArr);
        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2().invert(matrix);
        matrix.mapPoints(fArr);
        this.BuiltInFictitiousFunctionClassFactory.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public final void getAuthRequestContext(float f, float f2, MPPointD mPPointD) {
        float[] fArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        fArr[0] = f;
        fArr[1] = f2;
        getAuthRequestContext(fArr);
        mPPointD.getAuthRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2[0];
        mPPointD.KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2[1];
    }

    public final MPPointD BuiltInFictitiousFunctionClassFactory(float f, float f2) {
        float[] fArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        fArr[0] = f;
        fArr[1] = f2;
        this.BuiltInFictitiousFunctionClassFactory.mapPoints(fArr);
        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2().mapPoints(fArr);
        this.MyBillsEntityDataFactory.mapPoints(fArr);
        float[] fArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(fArr2[0], fArr2[1]);
    }

    private Matrix MyBillsEntityDataFactory() {
        this.lookAheadTest.set(this.BuiltInFictitiousFunctionClassFactory);
        this.lookAheadTest.postConcat(this.getAuthRequestContext.getAuthRequestContext);
        this.lookAheadTest.postConcat(this.MyBillsEntityDataFactory);
        return this.lookAheadTest;
    }
}

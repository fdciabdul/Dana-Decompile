package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* loaded from: classes7.dex */
public class BarBuffer extends AbstractBuffer<IBarDataSet> {
    protected boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    protected int getErrorConfigVersion;
    protected float lookAheadTest;
    protected int scheduleImpl;

    public BarBuffer(int i, int i2, boolean z) {
        super(i);
        this.scheduleImpl = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        this.lookAheadTest = 1.0f;
        this.getErrorConfigVersion = i2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
    }

    public final void getAuthRequestContext(float f) {
        this.lookAheadTest = f;
    }

    public final void MyBillsEntityDataFactory(int i) {
        this.scheduleImpl = i;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(float f, float f2, float f3, float f4) {
        float[] fArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = this.getAuthRequestContext;
        this.getAuthRequestContext = i + 1;
        fArr[i] = f;
        float[] fArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i2 = this.getAuthRequestContext;
        this.getAuthRequestContext = i2 + 1;
        fArr2[i2] = f2;
        float[] fArr3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = this.getAuthRequestContext;
        this.getAuthRequestContext = i3 + 1;
        fArr3[i3] = f3;
        float[] fArr4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i4 = this.getAuthRequestContext;
        this.getAuthRequestContext = i4 + 1;
        fArr4[i4] = f4;
    }

    public void getAuthRequestContext(IBarDataSet iBarDataSet) {
        float f;
        float f2;
        float abs;
        float abs2;
        float f3;
        float BottomSheetCardBindingView$watcherCardNumberView$1 = iBarDataSet.BottomSheetCardBindingView$watcherCardNumberView$1();
        float f4 = this.MyBillsEntityDataFactory;
        float f5 = this.lookAheadTest / 2.0f;
        for (int i = 0; i < BottomSheetCardBindingView$watcherCardNumberView$1 * f4; i++) {
            BarEntry barEntry = (BarEntry) iBarDataSet.getErrorConfigVersion(i);
            if (barEntry != null) {
                float MyBillsEntityDataFactory = barEntry.MyBillsEntityDataFactory();
                float authRequestContext = barEntry.getAuthRequestContext();
                float[] fArr = barEntry.PlaceComponentResult;
                float f6 = 0.0f;
                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0 || fArr == null) {
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                        f = 0.0f;
                        f2 = authRequestContext >= 0.0f ? authRequestContext : 0.0f;
                        if (authRequestContext > 0.0f) {
                            authRequestContext = 0.0f;
                        }
                    } else {
                        f = 0.0f;
                        float f7 = authRequestContext >= 0.0f ? authRequestContext : 0.0f;
                        if (authRequestContext > 0.0f) {
                            authRequestContext = 0.0f;
                        }
                        float f8 = authRequestContext;
                        authRequestContext = f7;
                        f2 = f8;
                    }
                    if (authRequestContext > f) {
                        authRequestContext *= this.moveToNextValue;
                    } else {
                        f2 *= this.moveToNextValue;
                    }
                    MyBillsEntityDataFactory(MyBillsEntityDataFactory - f5, authRequestContext, MyBillsEntityDataFactory + f5, f2);
                } else {
                    float f9 = -barEntry.BuiltInFictitiousFunctionClassFactory;
                    int i2 = 0;
                    float f10 = 0.0f;
                    while (i2 < fArr.length) {
                        float f11 = fArr[i2];
                        if (f11 == f6 && (f10 == f6 || f9 == f6)) {
                            abs = f11;
                            abs2 = f9;
                            f9 = abs;
                        } else if (f11 >= f6) {
                            abs = f11 + f10;
                            abs2 = f9;
                            f9 = f10;
                            f10 = abs;
                        } else {
                            abs = Math.abs(f11) + f9;
                            abs2 = Math.abs(f11) + f9;
                        }
                        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                            f3 = f9 >= abs ? f9 : abs;
                            if (f9 > abs) {
                                f9 = abs;
                            }
                        } else {
                            float f12 = f9 >= abs ? f9 : abs;
                            if (f9 > abs) {
                                f9 = abs;
                            }
                            float f13 = f12;
                            f3 = f9;
                            f9 = f13;
                        }
                        MyBillsEntityDataFactory(MyBillsEntityDataFactory - f5, f9 * this.moveToNextValue, MyBillsEntityDataFactory + f5, f3 * this.moveToNextValue);
                        i2++;
                        f9 = abs2;
                        f6 = 0.0f;
                    }
                }
            }
        }
        MyBillsEntityDataFactory();
    }
}

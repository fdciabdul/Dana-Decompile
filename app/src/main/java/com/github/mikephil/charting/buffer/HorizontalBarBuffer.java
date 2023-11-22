package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* loaded from: classes7.dex */
public class HorizontalBarBuffer extends BarBuffer {
    public HorizontalBarBuffer(int i, int i2, boolean z) {
        super(i, i2, z);
    }

    @Override // com.github.mikephil.charting.buffer.BarBuffer
    public final void getAuthRequestContext(IBarDataSet iBarDataSet) {
        float f;
        float abs;
        float abs2;
        float f2;
        float BottomSheetCardBindingView$watcherCardNumberView$1 = iBarDataSet.BottomSheetCardBindingView$watcherCardNumberView$1();
        float f3 = this.MyBillsEntityDataFactory;
        float f4 = this.lookAheadTest / 2.0f;
        for (int i = 0; i < BottomSheetCardBindingView$watcherCardNumberView$1 * f3; i++) {
            BarEntry barEntry = (BarEntry) iBarDataSet.getErrorConfigVersion(i);
            if (barEntry != null) {
                float MyBillsEntityDataFactory = barEntry.MyBillsEntityDataFactory();
                float authRequestContext = barEntry.getAuthRequestContext();
                float[] fArr = barEntry.PlaceComponentResult;
                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0 || fArr == null) {
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                        f = authRequestContext >= 0.0f ? authRequestContext : 0.0f;
                        if (authRequestContext > 0.0f) {
                            authRequestContext = 0.0f;
                        }
                    } else {
                        float f5 = authRequestContext >= 0.0f ? authRequestContext : 0.0f;
                        if (authRequestContext > 0.0f) {
                            authRequestContext = 0.0f;
                        }
                        float f6 = authRequestContext;
                        authRequestContext = f5;
                        f = f6;
                    }
                    if (authRequestContext > 0.0f) {
                        authRequestContext *= this.moveToNextValue;
                    } else {
                        f *= this.moveToNextValue;
                    }
                    MyBillsEntityDataFactory(f, MyBillsEntityDataFactory + f4, authRequestContext, MyBillsEntityDataFactory - f4);
                } else {
                    float f7 = -barEntry.BuiltInFictitiousFunctionClassFactory;
                    int i2 = 0;
                    float f8 = 0.0f;
                    while (i2 < fArr.length) {
                        float f9 = fArr[i2];
                        if (f9 >= 0.0f) {
                            abs = f9 + f8;
                            abs2 = f7;
                            f7 = f8;
                            f8 = abs;
                        } else {
                            abs = Math.abs(f9) + f7;
                            abs2 = Math.abs(f9) + f7;
                        }
                        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                            f2 = f7 >= abs ? f7 : abs;
                            if (f7 > abs) {
                                f7 = abs;
                            }
                        } else {
                            float f10 = f7 >= abs ? f7 : abs;
                            if (f7 > abs) {
                                f7 = abs;
                            }
                            float f11 = f10;
                            f2 = f7;
                            f7 = f11;
                        }
                        MyBillsEntityDataFactory(f2 * this.moveToNextValue, MyBillsEntityDataFactory + f4, f7 * this.moveToNextValue, MyBillsEntityDataFactory - f4);
                        i2++;
                        f7 = abs2;
                    }
                }
            }
        }
        MyBillsEntityDataFactory();
    }
}

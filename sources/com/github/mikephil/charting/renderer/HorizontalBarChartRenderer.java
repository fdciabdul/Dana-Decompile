package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: classes7.dex */
public class HorizontalBarChartRenderer extends BarChartRenderer {
    private RectF NetworkUserEntityData$$ExternalSyntheticLambda1;

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new RectF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public final void PlaceComponentResult() {
        BarData barData = this.MyBillsEntityDataFactory.getBarData();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new HorizontalBarBuffer[barData.KClassImpl$Data$declaredNonStaticMembers$2()];
        for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.MyBillsEntityDataFactory(i);
            this.KClassImpl$Data$declaredNonStaticMembers$2[i] = new HorizontalBarBuffer(iBarDataSet.BottomSheetCardBindingView$watcherCardNumberView$1() * 4 * (iBarDataSet.lookAheadTest() ? iBarDataSet.getErrorConfigVersion() : 1), barData.KClassImpl$Data$declaredNonStaticMembers$2(), iBarDataSet.lookAheadTest());
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(Canvas canvas, IBarDataSet iBarDataSet, int i) {
        Transformer transformer = this.MyBillsEntityDataFactory.getTransformer(iBarDataSet.scheduleImpl());
        this.getAuthRequestContext.setColor(iBarDataSet.getAuthRequestContext());
        this.getAuthRequestContext.setStrokeWidth(Utils.PlaceComponentResult(iBarDataSet.MyBillsEntityDataFactory()));
        boolean z = iBarDataSet.MyBillsEntityDataFactory() > 0.0f;
        float PlaceComponentResult = this.scheduleImpl.PlaceComponentResult();
        float MyBillsEntityDataFactory = this.scheduleImpl.MyBillsEntityDataFactory();
        if (this.MyBillsEntityDataFactory.isDrawBarShadowEnabled()) {
            this.PlaceComponentResult.setColor(iBarDataSet.KClassImpl$Data$declaredNonStaticMembers$2());
            float f = this.MyBillsEntityDataFactory.getBarData().PlaceComponentResult / 2.0f;
            int min = Math.min((int) Math.ceil(iBarDataSet.BottomSheetCardBindingView$watcherCardNumberView$1() * PlaceComponentResult), iBarDataSet.BottomSheetCardBindingView$watcherCardNumberView$1());
            for (int i2 = 0; i2 < min; i2++) {
                float MyBillsEntityDataFactory2 = ((BarEntry) iBarDataSet.getErrorConfigVersion(i2)).MyBillsEntityDataFactory();
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.top = MyBillsEntityDataFactory2 - f;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.bottom = MyBillsEntityDataFactory2 + f;
                transformer.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1.bottom)) {
                    if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1.top)) {
                        break;
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.left = this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl();
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.right = this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest();
                    canvas.drawRect(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.PlaceComponentResult);
                }
            }
        }
        BarBuffer barBuffer = this.KClassImpl$Data$declaredNonStaticMembers$2[i];
        barBuffer.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, MyBillsEntityDataFactory);
        barBuffer.MyBillsEntityDataFactory(i);
        barBuffer.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.isInverted(iBarDataSet.scheduleImpl()));
        barBuffer.getAuthRequestContext(this.MyBillsEntityDataFactory.getBarData().PlaceComponentResult);
        barBuffer.getAuthRequestContext(iBarDataSet);
        transformer.PlaceComponentResult(barBuffer.KClassImpl$Data$declaredNonStaticMembers$2);
        boolean z2 = iBarDataSet.NetworkUserEntityData$$ExternalSyntheticLambda2().size() == 1;
        if (z2) {
            this.lookAheadTest.setColor(iBarDataSet.moveToNextValue());
        }
        for (int i3 = 0; i3 < barBuffer.KClassImpl$Data$declaredNonStaticMembers$2.length; i3 += 4) {
            int i4 = i3 + 3;
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult(barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i4])) {
                return;
            }
            int i5 = i3 + 1;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory(barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i5])) {
                if (!z2) {
                    this.lookAheadTest.setColor(iBarDataSet.PlaceComponentResult(i3 / 4));
                }
                int i6 = i3 + 2;
                canvas.drawRect(barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i3], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i5], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i6], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i4], this.lookAheadTest);
                if (z) {
                    canvas.drawRect(barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i3], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i5], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i6], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i4], this.getAuthRequestContext);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public final void PlaceComponentResult(Canvas canvas) {
        List list;
        boolean z;
        int i;
        MPPointF mPPointF;
        int i2;
        MPPointF mPPointF2;
        float[] fArr;
        ValueFormatter valueFormatter;
        Transformer transformer;
        boolean z2;
        int i3;
        float[] fArr2;
        int i4;
        MPPointF mPPointF3;
        BarEntry barEntry;
        float f;
        float f2;
        float f3;
        float f4;
        List list2;
        int i5;
        float f5;
        float f6;
        boolean z3;
        int i6;
        MPPointF mPPointF4;
        BarBuffer barBuffer;
        ValueFormatter valueFormatter2;
        if (KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory)) {
            List BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.getBarData().BuiltInFictitiousFunctionClassFactory();
            float PlaceComponentResult = Utils.PlaceComponentResult(5.0f);
            boolean isDrawValueAboveBarEnabled = this.MyBillsEntityDataFactory.isDrawValueAboveBarEnabled();
            int i7 = 0;
            while (i7 < this.MyBillsEntityDataFactory.getBarData().KClassImpl$Data$declaredNonStaticMembers$2()) {
                IBarDataSet iBarDataSet = (IBarDataSet) BuiltInFictitiousFunctionClassFactory.get(i7);
                if (BuiltInFictitiousFunctionClassFactory(iBarDataSet)) {
                    boolean isInverted = this.MyBillsEntityDataFactory.isInverted(iBarDataSet.scheduleImpl());
                    PlaceComponentResult(iBarDataSet);
                    float f7 = 2.0f;
                    float authRequestContext = Utils.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda2, "10") / 2.0f;
                    ValueFormatter NetworkUserEntityData$$ExternalSyntheticLambda7 = iBarDataSet.NetworkUserEntityData$$ExternalSyntheticLambda7();
                    BarBuffer barBuffer2 = this.KClassImpl$Data$declaredNonStaticMembers$2[i7];
                    float MyBillsEntityDataFactory = this.scheduleImpl.MyBillsEntityDataFactory();
                    MPPointF authRequestContext2 = MPPointF.getAuthRequestContext(iBarDataSet.PrepareContext());
                    authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2 = Utils.PlaceComponentResult(authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2);
                    authRequestContext2.PlaceComponentResult = Utils.PlaceComponentResult(authRequestContext2.PlaceComponentResult);
                    if (iBarDataSet.lookAheadTest()) {
                        mPPointF = authRequestContext2;
                        ValueFormatter valueFormatter3 = NetworkUserEntityData$$ExternalSyntheticLambda7;
                        list = BuiltInFictitiousFunctionClassFactory;
                        i = i7;
                        Transformer transformer2 = this.MyBillsEntityDataFactory.getTransformer(iBarDataSet.scheduleImpl());
                        int i8 = 0;
                        int i9 = 0;
                        while (i8 < iBarDataSet.BottomSheetCardBindingView$watcherCardNumberView$1() * this.scheduleImpl.PlaceComponentResult()) {
                            BarEntry barEntry2 = (BarEntry) iBarDataSet.getErrorConfigVersion(i8);
                            int authRequestContext3 = iBarDataSet.getAuthRequestContext(i8);
                            float[] fArr3 = barEntry2.PlaceComponentResult;
                            if (fArr3 == null) {
                                int i10 = i9 + 1;
                                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult(barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i10])) {
                                    break;
                                } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.KClassImpl$Data$declaredNonStaticMembers$2(barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i9]) && this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory(barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i10])) {
                                    String MyBillsEntityDataFactory2 = valueFormatter3.MyBillsEntityDataFactory(barEntry2.getAuthRequestContext());
                                    float MyBillsEntityDataFactory3 = Utils.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2, MyBillsEntityDataFactory2);
                                    float f8 = isDrawValueAboveBarEnabled ? PlaceComponentResult : -(MyBillsEntityDataFactory3 + PlaceComponentResult);
                                    i2 = i8;
                                    float f9 = isDrawValueAboveBarEnabled ? -(MyBillsEntityDataFactory3 + PlaceComponentResult) : PlaceComponentResult;
                                    if (isInverted) {
                                        f8 = (-f8) - MyBillsEntityDataFactory3;
                                        f9 = (-f9) - MyBillsEntityDataFactory3;
                                    }
                                    if (iBarDataSet.NetworkUserEntityData$$ExternalSyntheticLambda6()) {
                                        float f10 = barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i9 + 2];
                                        if (barEntry2.getAuthRequestContext() >= 0.0f) {
                                            f4 = f8;
                                            f2 = f4;
                                        } else {
                                            f2 = f8;
                                            f4 = f9;
                                        }
                                        float f11 = f10 + f4;
                                        float f12 = barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i10] + authRequestContext;
                                        f3 = f9;
                                        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColor(authRequestContext3);
                                        canvas.drawText(MyBillsEntityDataFactory2, f11, f12, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                                    } else {
                                        f2 = f8;
                                        f3 = f9;
                                    }
                                    if (barEntry2.lookAheadTest == null || !iBarDataSet.FragmentBottomSheetPaymentSettingBinding()) {
                                        mPPointF2 = mPPointF;
                                        fArr = fArr3;
                                    } else {
                                        Drawable drawable = barEntry2.lookAheadTest;
                                        float f13 = barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i9 + 2];
                                        float f14 = barEntry2.getAuthRequestContext() < 0.0f ? f3 : f2;
                                        float f15 = barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i10];
                                        float f16 = mPPointF.KClassImpl$Data$declaredNonStaticMembers$2;
                                        mPPointF2 = mPPointF;
                                        fArr = fArr3;
                                        Utils.BuiltInFictitiousFunctionClassFactory(canvas, drawable, (int) (f13 + f14 + f16), (int) (f15 + mPPointF.PlaceComponentResult), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                    }
                                } else {
                                    i8 = i8;
                                    mPPointF = mPPointF;
                                }
                            } else {
                                i2 = i8;
                                mPPointF2 = mPPointF;
                                fArr = fArr3;
                                int length = fArr.length * 2;
                                float[] fArr4 = new float[length];
                                float f17 = -barEntry2.BuiltInFictitiousFunctionClassFactory;
                                int i11 = 0;
                                int i12 = 0;
                                float f18 = 0.0f;
                                while (i11 < length) {
                                    float f19 = fArr[i12];
                                    if (f19 == 0.0f && (f18 == 0.0f || f17 == 0.0f)) {
                                        float f20 = f17;
                                        f17 = f19;
                                        f = f20;
                                    } else if (f19 >= 0.0f) {
                                        f18 += f19;
                                        f = f17;
                                        f17 = f18;
                                    } else {
                                        f = f17 - f19;
                                    }
                                    fArr4[i11] = f17 * MyBillsEntityDataFactory;
                                    i11 += 2;
                                    i12++;
                                    f17 = f;
                                }
                                transformer2.PlaceComponentResult(fArr4);
                                int i13 = 0;
                                while (i13 < length) {
                                    float f21 = fArr[i13 / 2];
                                    String KClassImpl$Data$declaredNonStaticMembers$2 = valueFormatter3.KClassImpl$Data$declaredNonStaticMembers$2(f21, barEntry2);
                                    valueFormatter = valueFormatter3;
                                    float MyBillsEntityDataFactory4 = Utils.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2, KClassImpl$Data$declaredNonStaticMembers$2);
                                    transformer = transformer2;
                                    float f22 = isDrawValueAboveBarEnabled ? PlaceComponentResult : -(MyBillsEntityDataFactory4 + PlaceComponentResult);
                                    z2 = isDrawValueAboveBarEnabled;
                                    float f23 = isDrawValueAboveBarEnabled ? -(MyBillsEntityDataFactory4 + PlaceComponentResult) : PlaceComponentResult;
                                    if (isInverted) {
                                        f22 = (-f22) - MyBillsEntityDataFactory4;
                                        f23 = (-f23) - MyBillsEntityDataFactory4;
                                    }
                                    boolean z4 = (f21 == 0.0f && f17 == 0.0f && f18 > 0.0f) || f21 < 0.0f;
                                    float f24 = fArr4[i13];
                                    if (!z4) {
                                        f23 = f22;
                                    }
                                    float f25 = f24 + f23;
                                    float f26 = (barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i9 + 1] + barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i9 + 3]) / 2.0f;
                                    if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult(f26)) {
                                        break;
                                    }
                                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.KClassImpl$Data$declaredNonStaticMembers$2(f25) && this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory(f26)) {
                                        if (iBarDataSet.NetworkUserEntityData$$ExternalSyntheticLambda6()) {
                                            this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColor(authRequestContext3);
                                            canvas.drawText(KClassImpl$Data$declaredNonStaticMembers$2, f25, f26 + authRequestContext, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                                        }
                                        if (barEntry2.lookAheadTest != null && iBarDataSet.FragmentBottomSheetPaymentSettingBinding()) {
                                            Drawable drawable2 = barEntry2.lookAheadTest;
                                            mPPointF3 = mPPointF2;
                                            i3 = i13;
                                            fArr2 = fArr4;
                                            i4 = authRequestContext3;
                                            barEntry = barEntry2;
                                            Utils.BuiltInFictitiousFunctionClassFactory(canvas, drawable2, (int) (f25 + mPPointF3.KClassImpl$Data$declaredNonStaticMembers$2), (int) (f26 + mPPointF3.PlaceComponentResult), drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                                            i13 = i3 + 2;
                                            fArr4 = fArr2;
                                            authRequestContext3 = i4;
                                            barEntry2 = barEntry;
                                            valueFormatter3 = valueFormatter;
                                            transformer2 = transformer;
                                            mPPointF2 = mPPointF3;
                                            isDrawValueAboveBarEnabled = z2;
                                        }
                                    }
                                    i3 = i13;
                                    fArr2 = fArr4;
                                    i4 = authRequestContext3;
                                    mPPointF3 = mPPointF2;
                                    barEntry = barEntry2;
                                    i13 = i3 + 2;
                                    fArr4 = fArr2;
                                    authRequestContext3 = i4;
                                    barEntry2 = barEntry;
                                    valueFormatter3 = valueFormatter;
                                    transformer2 = transformer;
                                    mPPointF2 = mPPointF3;
                                    isDrawValueAboveBarEnabled = z2;
                                }
                            }
                            z2 = isDrawValueAboveBarEnabled;
                            valueFormatter = valueFormatter3;
                            transformer = transformer2;
                            MPPointF mPPointF5 = mPPointF2;
                            i9 = fArr == null ? i9 + 4 : i9 + (fArr.length * 4);
                            i8 = i2 + 1;
                            mPPointF = mPPointF5;
                            valueFormatter3 = valueFormatter;
                            transformer2 = transformer;
                            isDrawValueAboveBarEnabled = z2;
                        }
                    } else {
                        int i14 = 0;
                        while (i14 < barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2.length * this.scheduleImpl.PlaceComponentResult()) {
                            int i15 = i14 + 1;
                            float f27 = (barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i15] + barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i14 + 3]) / f7;
                            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult(barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i15])) {
                                break;
                            }
                            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.KClassImpl$Data$declaredNonStaticMembers$2(barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i14]) && this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory(barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i15])) {
                                BarEntry barEntry3 = (BarEntry) iBarDataSet.getErrorConfigVersion(i14 / 4);
                                float authRequestContext4 = barEntry3.getAuthRequestContext();
                                String MyBillsEntityDataFactory5 = NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(barEntry3.getAuthRequestContext());
                                ValueFormatter valueFormatter4 = NetworkUserEntityData$$ExternalSyntheticLambda7;
                                float MyBillsEntityDataFactory6 = Utils.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2, MyBillsEntityDataFactory5);
                                list2 = BuiltInFictitiousFunctionClassFactory;
                                float f28 = isDrawValueAboveBarEnabled ? PlaceComponentResult : -(MyBillsEntityDataFactory6 + PlaceComponentResult);
                                i5 = i7;
                                float f29 = isDrawValueAboveBarEnabled ? -(MyBillsEntityDataFactory6 + PlaceComponentResult) : PlaceComponentResult;
                                if (isInverted) {
                                    f28 = (-f28) - MyBillsEntityDataFactory6;
                                    f29 = (-f29) - MyBillsEntityDataFactory6;
                                }
                                if (iBarDataSet.NetworkUserEntityData$$ExternalSyntheticLambda6()) {
                                    f5 = f28;
                                    float f30 = barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i14 + 2] + (authRequestContext4 >= 0.0f ? f28 : f29);
                                    f6 = f29;
                                    z3 = isInverted;
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColor(iBarDataSet.getAuthRequestContext(i14 / 2));
                                    canvas.drawText(MyBillsEntityDataFactory5, f30, f27 + authRequestContext, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                                } else {
                                    f5 = f28;
                                    f6 = f29;
                                    z3 = isInverted;
                                }
                                if (barEntry3.lookAheadTest == null || !iBarDataSet.FragmentBottomSheetPaymentSettingBinding()) {
                                    i6 = i14;
                                    mPPointF4 = authRequestContext2;
                                    barBuffer = barBuffer2;
                                    valueFormatter2 = valueFormatter4;
                                } else {
                                    Drawable drawable3 = barEntry3.lookAheadTest;
                                    float f31 = barBuffer2.KClassImpl$Data$declaredNonStaticMembers$2[i14 + 2];
                                    float f32 = authRequestContext4 < 0.0f ? f6 : f5;
                                    i6 = i14;
                                    mPPointF4 = authRequestContext2;
                                    barBuffer = barBuffer2;
                                    valueFormatter2 = valueFormatter4;
                                    Utils.BuiltInFictitiousFunctionClassFactory(canvas, drawable3, (int) (f31 + f32 + authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2), (int) (f27 + authRequestContext2.PlaceComponentResult), drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
                                }
                            } else {
                                mPPointF4 = authRequestContext2;
                                valueFormatter2 = NetworkUserEntityData$$ExternalSyntheticLambda7;
                                list2 = BuiltInFictitiousFunctionClassFactory;
                                i5 = i7;
                                z3 = isInverted;
                                i6 = i14;
                                barBuffer = barBuffer2;
                            }
                            i14 = i6 + 4;
                            barBuffer2 = barBuffer;
                            NetworkUserEntityData$$ExternalSyntheticLambda7 = valueFormatter2;
                            authRequestContext2 = mPPointF4;
                            BuiltInFictitiousFunctionClassFactory = list2;
                            i7 = i5;
                            isInverted = z3;
                            f7 = 2.0f;
                        }
                        mPPointF = authRequestContext2;
                        list = BuiltInFictitiousFunctionClassFactory;
                        i = i7;
                    }
                    z = isDrawValueAboveBarEnabled;
                    MPPointF.BuiltInFictitiousFunctionClassFactory(mPPointF);
                } else {
                    list = BuiltInFictitiousFunctionClassFactory;
                    z = isDrawValueAboveBarEnabled;
                    i = i7;
                }
                i7 = i + 1;
                BuiltInFictitiousFunctionClassFactory = list;
                isDrawValueAboveBarEnabled = z;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    public final void PlaceComponentResult(Canvas canvas, String str, float f, float f2, int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColor(i);
        canvas.drawText(str, f, f2, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected final void PlaceComponentResult(float f, float f2, float f3, float f4, Transformer transformer) {
        this.BuiltInFictitiousFunctionClassFactory.set(f2, f - f4, f3, f + f4);
        transformer.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, this.scheduleImpl.MyBillsEntityDataFactory());
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(Highlight highlight, RectF rectF) {
        float centerY = rectF.centerY();
        float f = rectF.right;
        highlight.PlaceComponentResult = centerY;
        highlight.BuiltInFictitiousFunctionClassFactory = f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().getAuthRequestContext()) < ((float) chartInterface.getMaxVisibleCount()) * this.NetworkUserEntityData$$ExternalSyntheticLambda7.getErrorConfigVersion;
    }
}

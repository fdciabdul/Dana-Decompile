package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: classes7.dex */
public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {
    protected RectF BuiltInFictitiousFunctionClassFactory;
    protected BarBuffer[] KClassImpl$Data$declaredNonStaticMembers$2;
    protected BarDataProvider MyBillsEntityDataFactory;
    private RectF NetworkUserEntityData$$ExternalSyntheticLambda1;
    protected Paint PlaceComponentResult;
    protected Paint getAuthRequestContext;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void getAuthRequestContext(Canvas canvas) {
    }

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.BuiltInFictitiousFunctionClassFactory = new RectF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new RectF();
        this.MyBillsEntityDataFactory = barDataProvider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Paint(1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setStyle(Paint.Style.FILL);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setColor(Color.rgb(0, 0, 0));
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setAlpha(120);
        Paint paint = new Paint(1);
        this.PlaceComponentResult = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.getAuthRequestContext = paint2;
        paint2.setStyle(Paint.Style.STROKE);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void PlaceComponentResult() {
        BarData barData = this.MyBillsEntityDataFactory.getBarData();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new BarBuffer[barData.KClassImpl$Data$declaredNonStaticMembers$2()];
        for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.MyBillsEntityDataFactory(i);
            this.KClassImpl$Data$declaredNonStaticMembers$2[i] = new BarBuffer(iBarDataSet.BottomSheetCardBindingView$watcherCardNumberView$1() * 4 * (iBarDataSet.lookAheadTest() ? iBarDataSet.getErrorConfigVersion() : 1), barData.KClassImpl$Data$declaredNonStaticMembers$2(), iBarDataSet.lookAheadTest());
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void BuiltInFictitiousFunctionClassFactory(Canvas canvas) {
        BarData barData = this.MyBillsEntityDataFactory.getBarData();
        for (int i = 0; i < barData.KClassImpl$Data$declaredNonStaticMembers$2(); i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.MyBillsEntityDataFactory(i);
            if (iBarDataSet.whenAvailable()) {
                KClassImpl$Data$declaredNonStaticMembers$2(canvas, iBarDataSet, i);
            }
        }
    }

    protected void KClassImpl$Data$declaredNonStaticMembers$2(Canvas canvas, IBarDataSet iBarDataSet, int i) {
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
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.left = MyBillsEntityDataFactory2 - f;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.right = MyBillsEntityDataFactory2 + f;
                transformer.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1.right)) {
                    if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1.left)) {
                        break;
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.top = this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue();
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.bottom = this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory();
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
            int i4 = i3 + 2;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext(barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i4])) {
                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i3])) {
                    return;
                }
                if (!z2) {
                    this.lookAheadTest.setColor(iBarDataSet.PlaceComponentResult(i3 / 4));
                }
                if (iBarDataSet.isLayoutRequested() != null) {
                    GradientColor isLayoutRequested = iBarDataSet.isLayoutRequested();
                    this.lookAheadTest.setShader(new LinearGradient(barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i3], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i3 + 3], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i3], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i3 + 1], isLayoutRequested.BuiltInFictitiousFunctionClassFactory, isLayoutRequested.PlaceComponentResult, Shader.TileMode.MIRROR));
                }
                if (iBarDataSet.NetworkUserEntityData$$ExternalSyntheticLambda8() != null) {
                    int i5 = i3 / 4;
                    this.lookAheadTest.setShader(new LinearGradient(barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i3], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i3 + 3], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i3], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i3 + 1], iBarDataSet.BuiltInFictitiousFunctionClassFactory(i5).BuiltInFictitiousFunctionClassFactory, iBarDataSet.BuiltInFictitiousFunctionClassFactory(i5).PlaceComponentResult, Shader.TileMode.MIRROR));
                }
                int i6 = i3 + 1;
                int i7 = i3 + 3;
                canvas.drawRect(barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i3], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i6], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i4], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i7], this.lookAheadTest);
                if (z) {
                    canvas.drawRect(barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i3], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i6], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i4], barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i7], this.getAuthRequestContext);
                }
            }
        }
    }

    protected void PlaceComponentResult(float f, float f2, float f3, float f4, Transformer transformer) {
        this.BuiltInFictitiousFunctionClassFactory.set(f - f4, f2, f + f4, f3);
        transformer.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, this.scheduleImpl.MyBillsEntityDataFactory());
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void PlaceComponentResult(Canvas canvas) {
        List list;
        float f;
        boolean z;
        MPPointF mPPointF;
        float f2;
        float f3;
        float[] fArr;
        float[] fArr2;
        int i;
        float f4;
        float f5;
        float f6;
        float f7;
        BarEntry barEntry;
        int i2;
        List list2;
        float f8;
        boolean z2;
        MPPointF mPPointF2;
        ValueFormatter valueFormatter;
        float f9;
        BarEntry barEntry2;
        if (KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory)) {
            List BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.getBarData().BuiltInFictitiousFunctionClassFactory();
            float PlaceComponentResult = Utils.PlaceComponentResult(4.5f);
            boolean isDrawValueAboveBarEnabled = this.MyBillsEntityDataFactory.isDrawValueAboveBarEnabled();
            int i3 = 0;
            while (i3 < this.MyBillsEntityDataFactory.getBarData().KClassImpl$Data$declaredNonStaticMembers$2()) {
                IBarDataSet iBarDataSet = (IBarDataSet) BuiltInFictitiousFunctionClassFactory.get(i3);
                if (BuiltInFictitiousFunctionClassFactory(iBarDataSet)) {
                    PlaceComponentResult(iBarDataSet);
                    boolean isInverted = this.MyBillsEntityDataFactory.isInverted(iBarDataSet.scheduleImpl());
                    float authRequestContext = Utils.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda2, "8");
                    float f10 = isDrawValueAboveBarEnabled ? -PlaceComponentResult : authRequestContext + PlaceComponentResult;
                    float f11 = isDrawValueAboveBarEnabled ? authRequestContext + PlaceComponentResult : -PlaceComponentResult;
                    if (isInverted) {
                        f10 = (-f10) - authRequestContext;
                        f11 = (-f11) - authRequestContext;
                    }
                    float f12 = f10;
                    float f13 = f11;
                    BarBuffer barBuffer = this.KClassImpl$Data$declaredNonStaticMembers$2[i3];
                    float MyBillsEntityDataFactory = this.scheduleImpl.MyBillsEntityDataFactory();
                    ValueFormatter NetworkUserEntityData$$ExternalSyntheticLambda7 = iBarDataSet.NetworkUserEntityData$$ExternalSyntheticLambda7();
                    MPPointF authRequestContext2 = MPPointF.getAuthRequestContext(iBarDataSet.PrepareContext());
                    authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2 = Utils.PlaceComponentResult(authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2);
                    authRequestContext2.PlaceComponentResult = Utils.PlaceComponentResult(authRequestContext2.PlaceComponentResult);
                    if (iBarDataSet.lookAheadTest()) {
                        list = BuiltInFictitiousFunctionClassFactory;
                        f = PlaceComponentResult;
                        z = isDrawValueAboveBarEnabled;
                        mPPointF = authRequestContext2;
                        Transformer transformer = this.MyBillsEntityDataFactory.getTransformer(iBarDataSet.scheduleImpl());
                        int i4 = 0;
                        int i5 = 0;
                        while (i4 < iBarDataSet.BottomSheetCardBindingView$watcherCardNumberView$1() * this.scheduleImpl.PlaceComponentResult()) {
                            BarEntry barEntry3 = (BarEntry) iBarDataSet.getErrorConfigVersion(i4);
                            float[] fArr3 = barEntry3.PlaceComponentResult;
                            float f14 = (barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i5] + barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i5 + 2]) / 2.0f;
                            int authRequestContext3 = iBarDataSet.getAuthRequestContext(i4);
                            if (fArr3 == null) {
                                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(f14)) {
                                    break;
                                }
                                int i6 = i5 + 1;
                                if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.getErrorConfigVersion(barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i6]) && this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext(f14)) {
                                    if (iBarDataSet.NetworkUserEntityData$$ExternalSyntheticLambda6()) {
                                        String MyBillsEntityDataFactory2 = NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(barEntry3.getAuthRequestContext());
                                        float f15 = barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i6];
                                        float f16 = barEntry3.getAuthRequestContext() >= 0.0f ? f12 : f13;
                                        f7 = f14;
                                        f2 = f12;
                                        fArr = fArr3;
                                        f3 = f13;
                                        barEntry = barEntry3;
                                        PlaceComponentResult(canvas, MyBillsEntityDataFactory2, f14, f15 + f16, authRequestContext3);
                                    } else {
                                        f7 = f14;
                                        f2 = f12;
                                        f3 = f13;
                                        fArr = fArr3;
                                        barEntry = barEntry3;
                                    }
                                    if (barEntry.lookAheadTest != null && iBarDataSet.FragmentBottomSheetPaymentSettingBinding()) {
                                        Drawable drawable = barEntry.lookAheadTest;
                                        Utils.BuiltInFictitiousFunctionClassFactory(canvas, drawable, (int) (mPPointF.KClassImpl$Data$declaredNonStaticMembers$2 + f7), (int) (barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i6] + (barEntry.getAuthRequestContext() >= 0.0f ? f2 : f3) + mPPointF.PlaceComponentResult), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                    }
                                } else {
                                    f2 = f12;
                                    f3 = f13;
                                    f13 = f3;
                                    f12 = f2;
                                }
                            } else {
                                f2 = f12;
                                f3 = f13;
                                fArr = fArr3;
                                float f17 = f14;
                                int length = fArr.length * 2;
                                float[] fArr4 = new float[length];
                                float f18 = -barEntry3.BuiltInFictitiousFunctionClassFactory;
                                int i7 = 0;
                                int i8 = 0;
                                float f19 = 0.0f;
                                while (i7 < length) {
                                    float f20 = fArr[i8];
                                    if (f20 == 0.0f && (f19 == 0.0f || f18 == 0.0f)) {
                                        float f21 = f18;
                                        f18 = f20;
                                        f6 = f21;
                                    } else if (f20 >= 0.0f) {
                                        f19 += f20;
                                        f6 = f18;
                                        f18 = f19;
                                    } else {
                                        f6 = f18 - f20;
                                    }
                                    fArr4[i7 + 1] = f18 * MyBillsEntityDataFactory;
                                    i7 += 2;
                                    i8++;
                                    f18 = f6;
                                }
                                transformer.PlaceComponentResult(fArr4);
                                int i9 = 0;
                                while (i9 < length) {
                                    float f22 = fArr[i9 / 2];
                                    float f23 = fArr4[i9 + 1] + (((f22 > 0.0f ? 1 : (f22 == 0.0f ? 0 : -1)) == 0 && (f18 > 0.0f ? 1 : (f18 == 0.0f ? 0 : -1)) == 0 && (f19 > 0.0f ? 1 : (f19 == 0.0f ? 0 : -1)) > 0) || (f22 > 0.0f ? 1 : (f22 == 0.0f ? 0 : -1)) < 0 ? f3 : f2);
                                    int i10 = i9;
                                    if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(f17)) {
                                        break;
                                    }
                                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.getErrorConfigVersion(f23) && this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext(f17)) {
                                        if (iBarDataSet.NetworkUserEntityData$$ExternalSyntheticLambda6()) {
                                            f5 = f23;
                                            fArr2 = fArr4;
                                            i = length;
                                            f4 = f17;
                                            PlaceComponentResult(canvas, NetworkUserEntityData$$ExternalSyntheticLambda7.KClassImpl$Data$declaredNonStaticMembers$2(f22, barEntry3), f17, f5, authRequestContext3);
                                        } else {
                                            f5 = f23;
                                            fArr2 = fArr4;
                                            i = length;
                                            f4 = f17;
                                        }
                                        if (barEntry3.lookAheadTest != null && iBarDataSet.FragmentBottomSheetPaymentSettingBinding()) {
                                            Drawable drawable2 = barEntry3.lookAheadTest;
                                            Utils.BuiltInFictitiousFunctionClassFactory(canvas, drawable2, (int) (f4 + mPPointF.KClassImpl$Data$declaredNonStaticMembers$2), (int) (f5 + mPPointF.PlaceComponentResult), drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                                        }
                                    } else {
                                        fArr2 = fArr4;
                                        i = length;
                                        f4 = f17;
                                    }
                                    i9 = i10 + 2;
                                    fArr4 = fArr2;
                                    length = i;
                                    f17 = f4;
                                }
                            }
                            i5 = fArr == null ? i5 + 4 : i5 + (fArr.length * 4);
                            i4++;
                            f13 = f3;
                            f12 = f2;
                        }
                    } else {
                        int i11 = 0;
                        while (i11 < barBuffer.KClassImpl$Data$declaredNonStaticMembers$2.length * this.scheduleImpl.PlaceComponentResult()) {
                            float f24 = (barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i11] + barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i11 + 2]) / 2.0f;
                            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(f24)) {
                                break;
                            }
                            int i12 = i11 + 1;
                            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.getErrorConfigVersion(barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i12]) && this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext(f24)) {
                                int i13 = i11 / 4;
                                BarEntry barEntry4 = (BarEntry) iBarDataSet.getErrorConfigVersion(i13);
                                float authRequestContext4 = barEntry4.getAuthRequestContext();
                                if (iBarDataSet.NetworkUserEntityData$$ExternalSyntheticLambda6()) {
                                    String MyBillsEntityDataFactory3 = NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(barEntry4.getAuthRequestContext());
                                    float[] fArr5 = barBuffer.KClassImpl$Data$declaredNonStaticMembers$2;
                                    list2 = BuiltInFictitiousFunctionClassFactory;
                                    barEntry2 = barEntry4;
                                    f9 = f24;
                                    i2 = i11;
                                    f8 = PlaceComponentResult;
                                    mPPointF2 = authRequestContext2;
                                    z2 = isDrawValueAboveBarEnabled;
                                    valueFormatter = NetworkUserEntityData$$ExternalSyntheticLambda7;
                                    PlaceComponentResult(canvas, MyBillsEntityDataFactory3, f9, authRequestContext4 >= 0.0f ? fArr5[i12] + f12 : fArr5[i11 + 3] + f13, iBarDataSet.getAuthRequestContext(i13));
                                } else {
                                    f9 = f24;
                                    i2 = i11;
                                    list2 = BuiltInFictitiousFunctionClassFactory;
                                    f8 = PlaceComponentResult;
                                    z2 = isDrawValueAboveBarEnabled;
                                    barEntry2 = barEntry4;
                                    mPPointF2 = authRequestContext2;
                                    valueFormatter = NetworkUserEntityData$$ExternalSyntheticLambda7;
                                }
                                if (barEntry2.lookAheadTest != null && iBarDataSet.FragmentBottomSheetPaymentSettingBinding()) {
                                    Drawable drawable3 = barEntry2.lookAheadTest;
                                    Utils.BuiltInFictitiousFunctionClassFactory(canvas, drawable3, (int) (f9 + mPPointF2.KClassImpl$Data$declaredNonStaticMembers$2), (int) ((authRequestContext4 >= 0.0f ? barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i12] + f12 : barBuffer.KClassImpl$Data$declaredNonStaticMembers$2[i2 + 3] + f13) + mPPointF2.PlaceComponentResult), drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
                                }
                            } else {
                                i2 = i11;
                                list2 = BuiltInFictitiousFunctionClassFactory;
                                f8 = PlaceComponentResult;
                                z2 = isDrawValueAboveBarEnabled;
                                mPPointF2 = authRequestContext2;
                                valueFormatter = NetworkUserEntityData$$ExternalSyntheticLambda7;
                            }
                            i11 = i2 + 4;
                            authRequestContext2 = mPPointF2;
                            NetworkUserEntityData$$ExternalSyntheticLambda7 = valueFormatter;
                            isDrawValueAboveBarEnabled = z2;
                            BuiltInFictitiousFunctionClassFactory = list2;
                            PlaceComponentResult = f8;
                        }
                        list = BuiltInFictitiousFunctionClassFactory;
                        f = PlaceComponentResult;
                        z = isDrawValueAboveBarEnabled;
                        mPPointF = authRequestContext2;
                    }
                    MPPointF.BuiltInFictitiousFunctionClassFactory(mPPointF);
                } else {
                    list = BuiltInFictitiousFunctionClassFactory;
                    f = PlaceComponentResult;
                    z = isDrawValueAboveBarEnabled;
                }
                i3++;
                isDrawValueAboveBarEnabled = z;
                BuiltInFictitiousFunctionClassFactory = list;
                PlaceComponentResult = f;
            }
        }
    }

    public void PlaceComponentResult(Canvas canvas, String str, float f, float f2, int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColor(i);
        canvas.drawText(str, f, f2, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void MyBillsEntityDataFactory(Canvas canvas, Highlight[] highlightArr) {
        float authRequestContext;
        float f;
        BarData barData = this.MyBillsEntityDataFactory.getBarData();
        for (Highlight highlight : highlightArr) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.MyBillsEntityDataFactory(highlight.MyBillsEntityDataFactory);
            if (iBarDataSet != null && iBarDataSet.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.getAuthRequestContext(highlight.moveToNextValue, highlight.lookAheadTest);
                if (BuiltInFictitiousFunctionClassFactory(barEntry, iBarDataSet)) {
                    Transformer transformer = this.MyBillsEntityDataFactory.getTransformer(iBarDataSet.scheduleImpl());
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.setColor(iBarDataSet.NetworkUserEntityData$$ExternalSyntheticLambda0());
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.setAlpha(iBarDataSet.PlaceComponentResult());
                    if (highlight.getErrorConfigVersion >= 0 && barEntry.BuiltInFictitiousFunctionClassFactory()) {
                        if (!this.MyBillsEntityDataFactory.isHighlightFullBarEnabled()) {
                            Range range = barEntry.getAuthRequestContext[highlight.getErrorConfigVersion];
                            authRequestContext = range.MyBillsEntityDataFactory;
                            f = range.KClassImpl$Data$declaredNonStaticMembers$2;
                        } else {
                            float f2 = barEntry.MyBillsEntityDataFactory;
                            f = -barEntry.BuiltInFictitiousFunctionClassFactory;
                            authRequestContext = f2;
                        }
                    } else {
                        authRequestContext = barEntry.getAuthRequestContext();
                        f = 0.0f;
                    }
                    PlaceComponentResult(barEntry.MyBillsEntityDataFactory(), authRequestContext, f, barData.PlaceComponentResult / 2.0f, transformer);
                    KClassImpl$Data$declaredNonStaticMembers$2(highlight, this.BuiltInFictitiousFunctionClassFactory);
                    canvas.drawRect(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                }
            }
        }
    }

    protected void KClassImpl$Data$declaredNonStaticMembers$2(Highlight highlight, RectF rectF) {
        float centerX = rectF.centerX();
        float f = rectF.top;
        highlight.PlaceComponentResult = centerX;
        highlight.BuiltInFictitiousFunctionClassFactory = f;
    }
}

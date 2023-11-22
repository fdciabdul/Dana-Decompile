package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class RadarChartRenderer extends LineRadarRenderer {
    protected Paint BuiltInFictitiousFunctionClassFactory;
    protected RadarChart KClassImpl$Data$declaredNonStaticMembers$2;
    protected Path MyBillsEntityDataFactory;
    protected Paint PlaceComponentResult;
    protected Path getAuthRequestContext;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void PlaceComponentResult() {
    }

    public RadarChartRenderer(RadarChart radarChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.MyBillsEntityDataFactory = new Path();
        this.getAuthRequestContext = new Path();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = radarChart;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Paint(1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setStyle(Paint.Style.STROKE);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setStrokeWidth(2.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setColor(Color.rgb(255, 187, 115));
        Paint paint = new Paint(1);
        this.BuiltInFictitiousFunctionClassFactory = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.PlaceComponentResult = new Paint(1);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void BuiltInFictitiousFunctionClassFactory(Canvas canvas) {
        Canvas canvas2;
        RadarData radarData = (RadarData) this.KClassImpl$Data$declaredNonStaticMembers$2.getData();
        int BottomSheetCardBindingView$watcherCardNumberView$1 = radarData.getErrorConfigVersion().BottomSheetCardBindingView$watcherCardNumberView$1();
        Iterator<IRadarDataSet> it = radarData.BuiltInFictitiousFunctionClassFactory().iterator();
        while (it.hasNext()) {
            IRadarDataSet next = it.next();
            if (next.whenAvailable()) {
                float PlaceComponentResult = this.scheduleImpl.PlaceComponentResult();
                float MyBillsEntityDataFactory = this.scheduleImpl.MyBillsEntityDataFactory();
                float sliceAngle = this.KClassImpl$Data$declaredNonStaticMembers$2.getSliceAngle();
                float factor = this.KClassImpl$Data$declaredNonStaticMembers$2.getFactor();
                MPPointF centerOffsets = this.KClassImpl$Data$declaredNonStaticMembers$2.getCenterOffsets();
                MPPointF authRequestContext = MPPointF.getAuthRequestContext(0.0f, 0.0f);
                Path path = this.MyBillsEntityDataFactory;
                path.reset();
                int i = 0;
                boolean z = false;
                while (i < next.BottomSheetCardBindingView$watcherCardNumberView$1()) {
                    this.lookAheadTest.setColor(next.PlaceComponentResult(i));
                    Iterator<IRadarDataSet> it2 = it;
                    Utils.KClassImpl$Data$declaredNonStaticMembers$2(centerOffsets, (((RadarEntry) next.getErrorConfigVersion(i)).getAuthRequestContext() - this.KClassImpl$Data$declaredNonStaticMembers$2.getYChartMin()) * factor * MyBillsEntityDataFactory, (i * sliceAngle * PlaceComponentResult) + this.KClassImpl$Data$declaredNonStaticMembers$2.getRotationAngle(), authRequestContext);
                    if (!Float.isNaN(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2)) {
                        if (!z) {
                            path.moveTo(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.PlaceComponentResult);
                            z = true;
                        } else {
                            path.lineTo(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.PlaceComponentResult);
                        }
                    }
                    i++;
                    it = it2;
                }
                Iterator<IRadarDataSet> it3 = it;
                if (next.BottomSheetCardBindingView$watcherCardNumberView$1() > BottomSheetCardBindingView$watcherCardNumberView$1) {
                    path.lineTo(centerOffsets.KClassImpl$Data$declaredNonStaticMembers$2, centerOffsets.PlaceComponentResult);
                }
                path.close();
                if (next.AppCompatEmojiTextHelper()) {
                    Drawable I = next.I();
                    if (I != null) {
                        canvas2 = canvas;
                        BuiltInFictitiousFunctionClassFactory(canvas2, path, I);
                    } else {
                        canvas2 = canvas;
                        MyBillsEntityDataFactory(canvas2, path, next.VerifyPinStateManager$executeRiskChallenge$2$2(), next.E());
                    }
                } else {
                    canvas2 = canvas;
                }
                this.lookAheadTest.setStrokeWidth(next.F());
                this.lookAheadTest.setStyle(Paint.Style.STROKE);
                if (!next.AppCompatEmojiTextHelper() || next.E() < 255) {
                    canvas2.drawPath(path, this.lookAheadTest);
                }
                MPPointF.BuiltInFictitiousFunctionClassFactory(centerOffsets);
                MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext);
                it = it3;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void PlaceComponentResult(Canvas canvas) {
        float f;
        float f2;
        float f3;
        int i;
        float f4;
        float f5;
        ValueFormatter valueFormatter;
        float PlaceComponentResult = this.scheduleImpl.PlaceComponentResult();
        float MyBillsEntityDataFactory = this.scheduleImpl.MyBillsEntityDataFactory();
        float sliceAngle = this.KClassImpl$Data$declaredNonStaticMembers$2.getSliceAngle();
        float factor = this.KClassImpl$Data$declaredNonStaticMembers$2.getFactor();
        MPPointF centerOffsets = this.KClassImpl$Data$declaredNonStaticMembers$2.getCenterOffsets();
        MPPointF authRequestContext = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        MPPointF authRequestContext2 = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        float PlaceComponentResult2 = Utils.PlaceComponentResult(5.0f);
        int i2 = 0;
        while (i2 < ((RadarData) this.KClassImpl$Data$declaredNonStaticMembers$2.getData()).KClassImpl$Data$declaredNonStaticMembers$2()) {
            IRadarDataSet MyBillsEntityDataFactory2 = ((RadarData) this.KClassImpl$Data$declaredNonStaticMembers$2.getData()).MyBillsEntityDataFactory(i2);
            if (BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2)) {
                PlaceComponentResult(MyBillsEntityDataFactory2);
                ValueFormatter NetworkUserEntityData$$ExternalSyntheticLambda7 = MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda7();
                MPPointF authRequestContext3 = MPPointF.getAuthRequestContext(MyBillsEntityDataFactory2.PrepareContext());
                authRequestContext3.KClassImpl$Data$declaredNonStaticMembers$2 = Utils.PlaceComponentResult(authRequestContext3.KClassImpl$Data$declaredNonStaticMembers$2);
                authRequestContext3.PlaceComponentResult = Utils.PlaceComponentResult(authRequestContext3.PlaceComponentResult);
                int i3 = 0;
                while (i3 < MyBillsEntityDataFactory2.BottomSheetCardBindingView$watcherCardNumberView$1()) {
                    RadarEntry radarEntry = (RadarEntry) MyBillsEntityDataFactory2.getErrorConfigVersion(i3);
                    int i4 = i2;
                    float f6 = i3 * sliceAngle * PlaceComponentResult;
                    float f7 = PlaceComponentResult;
                    Utils.KClassImpl$Data$declaredNonStaticMembers$2(centerOffsets, (radarEntry.getAuthRequestContext() - this.KClassImpl$Data$declaredNonStaticMembers$2.getYChartMin()) * factor * MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2.getRotationAngle() + f6, authRequestContext);
                    if (MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda6()) {
                        String MyBillsEntityDataFactory3 = NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(radarEntry.getAuthRequestContext());
                        float f8 = authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
                        f4 = sliceAngle;
                        float f9 = authRequestContext.PlaceComponentResult - PlaceComponentResult2;
                        f5 = PlaceComponentResult2;
                        valueFormatter = NetworkUserEntityData$$ExternalSyntheticLambda7;
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColor(MyBillsEntityDataFactory2.getAuthRequestContext(i3));
                        canvas.drawText(MyBillsEntityDataFactory3, f8, f9, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                    } else {
                        f4 = sliceAngle;
                        f5 = PlaceComponentResult2;
                        valueFormatter = NetworkUserEntityData$$ExternalSyntheticLambda7;
                    }
                    if (radarEntry.lookAheadTest != null && MyBillsEntityDataFactory2.FragmentBottomSheetPaymentSettingBinding()) {
                        Drawable drawable = radarEntry.lookAheadTest;
                        Utils.KClassImpl$Data$declaredNonStaticMembers$2(centerOffsets, (radarEntry.getAuthRequestContext() * factor * MyBillsEntityDataFactory) + authRequestContext3.PlaceComponentResult, f6 + this.KClassImpl$Data$declaredNonStaticMembers$2.getRotationAngle(), authRequestContext2);
                        authRequestContext2.PlaceComponentResult += authRequestContext3.KClassImpl$Data$declaredNonStaticMembers$2;
                        Utils.BuiltInFictitiousFunctionClassFactory(canvas, drawable, (int) authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2, (int) authRequestContext2.PlaceComponentResult, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    }
                    i3++;
                    sliceAngle = f4;
                    i2 = i4;
                    PlaceComponentResult = f7;
                    PlaceComponentResult2 = f5;
                    NetworkUserEntityData$$ExternalSyntheticLambda7 = valueFormatter;
                }
                f = PlaceComponentResult;
                f2 = sliceAngle;
                f3 = PlaceComponentResult2;
                i = i2;
                MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext3);
            } else {
                f = PlaceComponentResult;
                f2 = sliceAngle;
                f3 = PlaceComponentResult2;
                i = i2;
            }
            i2 = i + 1;
            sliceAngle = f2;
            PlaceComponentResult = f;
            PlaceComponentResult2 = f3;
        }
        MPPointF.BuiltInFictitiousFunctionClassFactory(centerOffsets);
        MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext);
        MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext2);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void MyBillsEntityDataFactory(Canvas canvas, Highlight[] highlightArr) {
        float f;
        RadarData radarData;
        Highlight[] highlightArr2 = highlightArr;
        float sliceAngle = this.KClassImpl$Data$declaredNonStaticMembers$2.getSliceAngle();
        float factor = this.KClassImpl$Data$declaredNonStaticMembers$2.getFactor();
        MPPointF centerOffsets = this.KClassImpl$Data$declaredNonStaticMembers$2.getCenterOffsets();
        MPPointF authRequestContext = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        RadarData radarData2 = (RadarData) this.KClassImpl$Data$declaredNonStaticMembers$2.getData();
        int length = highlightArr2.length;
        int i = 0;
        while (i < length) {
            Highlight highlight = highlightArr2[i];
            IRadarDataSet MyBillsEntityDataFactory = radarData2.MyBillsEntityDataFactory(highlight.MyBillsEntityDataFactory);
            if (MyBillsEntityDataFactory != null && MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                Entry entry = (RadarEntry) MyBillsEntityDataFactory.getErrorConfigVersion((int) highlight.moveToNextValue);
                if (BuiltInFictitiousFunctionClassFactory(entry, MyBillsEntityDataFactory)) {
                    float authRequestContext2 = entry.getAuthRequestContext();
                    float yChartMin = this.KClassImpl$Data$declaredNonStaticMembers$2.getYChartMin();
                    float MyBillsEntityDataFactory2 = this.scheduleImpl.MyBillsEntityDataFactory();
                    float f2 = highlight.moveToNextValue;
                    radarData = radarData2;
                    Utils.KClassImpl$Data$declaredNonStaticMembers$2(centerOffsets, (authRequestContext2 - yChartMin) * factor * MyBillsEntityDataFactory2, (f2 * sliceAngle * this.scheduleImpl.PlaceComponentResult()) + this.KClassImpl$Data$declaredNonStaticMembers$2.getRotationAngle(), authRequestContext);
                    float f3 = authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
                    float f4 = authRequestContext.PlaceComponentResult;
                    highlight.PlaceComponentResult = f3;
                    highlight.BuiltInFictitiousFunctionClassFactory = f4;
                    MyBillsEntityDataFactory(canvas, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.PlaceComponentResult, MyBillsEntityDataFactory);
                    if (!MyBillsEntityDataFactory.getErrorConfigVersion() || Float.isNaN(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2) || Float.isNaN(authRequestContext.PlaceComponentResult)) {
                        f = sliceAngle;
                    } else {
                        int MyBillsEntityDataFactory3 = MyBillsEntityDataFactory.MyBillsEntityDataFactory();
                        if (MyBillsEntityDataFactory3 == 1122867) {
                            MyBillsEntityDataFactory3 = MyBillsEntityDataFactory.PlaceComponentResult(0);
                        }
                        if (MyBillsEntityDataFactory.PlaceComponentResult() < 255) {
                            MyBillsEntityDataFactory3 = ColorTemplate.MyBillsEntityDataFactory(MyBillsEntityDataFactory3, MyBillsEntityDataFactory.PlaceComponentResult());
                        }
                        float authRequestContext3 = MyBillsEntityDataFactory.getAuthRequestContext();
                        float KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                        int BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
                        float lookAheadTest = MyBillsEntityDataFactory.lookAheadTest();
                        canvas.save();
                        float PlaceComponentResult = Utils.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                        float PlaceComponentResult2 = Utils.PlaceComponentResult(authRequestContext3);
                        if (BuiltInFictitiousFunctionClassFactory != 1122867) {
                            Path path = this.getAuthRequestContext;
                            path.reset();
                            f = sliceAngle;
                            path.addCircle(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.PlaceComponentResult, PlaceComponentResult, Path.Direction.CW);
                            if (PlaceComponentResult2 > 0.0f) {
                                path.addCircle(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.PlaceComponentResult, PlaceComponentResult2, Path.Direction.CCW);
                            }
                            this.PlaceComponentResult.setColor(BuiltInFictitiousFunctionClassFactory);
                            this.PlaceComponentResult.setStyle(Paint.Style.FILL);
                            canvas.drawPath(path, this.PlaceComponentResult);
                        } else {
                            f = sliceAngle;
                        }
                        if (MyBillsEntityDataFactory3 != 1122867) {
                            this.PlaceComponentResult.setColor(MyBillsEntityDataFactory3);
                            this.PlaceComponentResult.setStyle(Paint.Style.STROKE);
                            this.PlaceComponentResult.setStrokeWidth(Utils.PlaceComponentResult(lookAheadTest));
                            canvas.drawCircle(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.PlaceComponentResult, PlaceComponentResult, this.PlaceComponentResult);
                        }
                        canvas.restore();
                    }
                    i++;
                    highlightArr2 = highlightArr;
                    radarData2 = radarData;
                    sliceAngle = f;
                }
            }
            f = sliceAngle;
            radarData = radarData2;
            i++;
            highlightArr2 = highlightArr;
            radarData2 = radarData;
            sliceAngle = f;
        }
        MPPointF.BuiltInFictitiousFunctionClassFactory(centerOffsets);
        MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void getAuthRequestContext(Canvas canvas) {
        float sliceAngle = this.KClassImpl$Data$declaredNonStaticMembers$2.getSliceAngle();
        float factor = this.KClassImpl$Data$declaredNonStaticMembers$2.getFactor();
        float rotationAngle = this.KClassImpl$Data$declaredNonStaticMembers$2.getRotationAngle();
        MPPointF centerOffsets = this.KClassImpl$Data$declaredNonStaticMembers$2.getCenterOffsets();
        this.BuiltInFictitiousFunctionClassFactory.setStrokeWidth(this.KClassImpl$Data$declaredNonStaticMembers$2.getWebLineWidth());
        this.BuiltInFictitiousFunctionClassFactory.setColor(this.KClassImpl$Data$declaredNonStaticMembers$2.getWebColor());
        this.BuiltInFictitiousFunctionClassFactory.setAlpha(this.KClassImpl$Data$declaredNonStaticMembers$2.getWebAlpha());
        int skipWebLineCount = this.KClassImpl$Data$declaredNonStaticMembers$2.getSkipWebLineCount();
        int BottomSheetCardBindingView$watcherCardNumberView$1 = ((RadarData) this.KClassImpl$Data$declaredNonStaticMembers$2.getData()).getErrorConfigVersion().BottomSheetCardBindingView$watcherCardNumberView$1();
        MPPointF authRequestContext = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        for (int i = 0; i < BottomSheetCardBindingView$watcherCardNumberView$1; i += skipWebLineCount + 1) {
            Utils.KClassImpl$Data$declaredNonStaticMembers$2(centerOffsets, this.KClassImpl$Data$declaredNonStaticMembers$2.getYRange() * factor, (i * sliceAngle) + rotationAngle, authRequestContext);
            canvas.drawLine(centerOffsets.KClassImpl$Data$declaredNonStaticMembers$2, centerOffsets.PlaceComponentResult, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
        }
        MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext);
        this.BuiltInFictitiousFunctionClassFactory.setStrokeWidth(this.KClassImpl$Data$declaredNonStaticMembers$2.getWebLineWidthInner());
        this.BuiltInFictitiousFunctionClassFactory.setColor(this.KClassImpl$Data$declaredNonStaticMembers$2.getWebColorInner());
        this.BuiltInFictitiousFunctionClassFactory.setAlpha(this.KClassImpl$Data$declaredNonStaticMembers$2.getWebAlpha());
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getYAxis().PrepareContext;
        MPPointF authRequestContext2 = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        MPPointF authRequestContext3 = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = 0;
            while (i4 < ((RadarData) this.KClassImpl$Data$declaredNonStaticMembers$2.getData()).getAuthRequestContext()) {
                float yChartMin = (this.KClassImpl$Data$declaredNonStaticMembers$2.getYAxis().NetworkUserEntityData$$ExternalSyntheticLambda8[i3] - this.KClassImpl$Data$declaredNonStaticMembers$2.getYChartMin()) * factor;
                Utils.KClassImpl$Data$declaredNonStaticMembers$2(centerOffsets, yChartMin, (i4 * sliceAngle) + rotationAngle, authRequestContext2);
                i4++;
                Utils.KClassImpl$Data$declaredNonStaticMembers$2(centerOffsets, yChartMin, (i4 * sliceAngle) + rotationAngle, authRequestContext3);
                canvas.drawLine(authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext2.PlaceComponentResult, authRequestContext3.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext3.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
            }
        }
        MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext2);
        MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext3);
    }
}

package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class PieChartRenderer extends DataRenderer {
    protected PieChart BuiltInFictitiousFunctionClassFactory;
    protected Paint DatabaseTableConfigUtil;
    protected Paint GetContactSyncConfig;
    protected Canvas KClassImpl$Data$declaredNonStaticMembers$2;
    public TextPaint MyBillsEntityDataFactory;
    public Paint NetworkUserEntityData$$ExternalSyntheticLambda1;
    private RectF[] NetworkUserEntityData$$ExternalSyntheticLambda3;
    private RectF NetworkUserEntityData$$ExternalSyntheticLambda4;
    private Path NetworkUserEntityData$$ExternalSyntheticLambda6;
    private Path NetworkUserEntityData$$ExternalSyntheticLambda8;
    protected WeakReference<Bitmap> PlaceComponentResult;
    private CharSequence PrepareContext;
    protected Path getAuthRequestContext;
    protected RectF getErrorConfigVersion;
    protected Paint initRecordTimeStamp;
    private StaticLayout isLayoutRequested;
    private RectF newProxyInstance;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void PlaceComponentResult() {
    }

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.newProxyInstance = new RectF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new Path();
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new RectF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new Path();
        this.getAuthRequestContext = new Path();
        this.getErrorConfigVersion = new RectF();
        this.BuiltInFictitiousFunctionClassFactory = pieChart;
        Paint paint = new Paint(1);
        this.DatabaseTableConfigUtil = paint;
        paint.setColor(-1);
        this.DatabaseTableConfigUtil.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.initRecordTimeStamp = paint2;
        paint2.setColor(-1);
        this.initRecordTimeStamp.setStyle(Paint.Style.FILL);
        this.initRecordTimeStamp.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.MyBillsEntityDataFactory = textPaint;
        textPaint.setColor(-16777216);
        this.MyBillsEntityDataFactory.setTextSize(Utils.PlaceComponentResult(12.0f));
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setTextSize(Utils.PlaceComponentResult(13.0f));
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColor(-1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = paint3;
        paint3.setColor(-1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.setTextAlign(Paint.Align.CENTER);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.setTextSize(Utils.PlaceComponentResult(13.0f));
        Paint paint4 = new Paint(1);
        this.GetContactSyncConfig = paint4;
        paint4.setStyle(Paint.Style.STROKE);
    }

    public final Paint MyBillsEntityDataFactory() {
        return this.DatabaseTableConfigUtil;
    }

    public final Paint KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.initRecordTimeStamp;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void BuiltInFictitiousFunctionClassFactory(Canvas canvas) {
        Iterator<IPieDataSet> it;
        IPieDataSet iPieDataSet;
        float f;
        float f2;
        float f3;
        RectF rectF;
        int i;
        float[] fArr;
        int i2;
        RectF rectF2;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        int i3;
        int initRecordTimeStamp = (int) this.NetworkUserEntityData$$ExternalSyntheticLambda7.initRecordTimeStamp();
        int NetworkUserEntityData$$ExternalSyntheticLambda1 = (int) this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda1();
        WeakReference<Bitmap> weakReference = this.PlaceComponentResult;
        Bitmap bitmap = weakReference == null ? null : weakReference.get();
        if (bitmap == null || bitmap.getWidth() != initRecordTimeStamp || bitmap.getHeight() != NetworkUserEntityData$$ExternalSyntheticLambda1) {
            if (initRecordTimeStamp <= 0 || NetworkUserEntityData$$ExternalSyntheticLambda1 <= 0) {
                return;
            }
            bitmap = Bitmap.createBitmap(initRecordTimeStamp, NetworkUserEntityData$$ExternalSyntheticLambda1, Bitmap.Config.ARGB_4444);
            this.PlaceComponentResult = new WeakReference<>(bitmap);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new Canvas(bitmap);
        }
        int i4 = 0;
        bitmap.eraseColor(0);
        Iterator<IPieDataSet> it2 = ((PieData) this.BuiltInFictitiousFunctionClassFactory.getData()).BuiltInFictitiousFunctionClassFactory().iterator();
        while (it2.hasNext()) {
            IPieDataSet next = it2.next();
            if (next.whenAvailable() && next.BottomSheetCardBindingView$watcherCardNumberView$1() > 0) {
                float rotationAngle = this.BuiltInFictitiousFunctionClassFactory.getRotationAngle();
                float PlaceComponentResult = this.scheduleImpl.PlaceComponentResult();
                float MyBillsEntityDataFactory = this.scheduleImpl.MyBillsEntityDataFactory();
                RectF circleBox = this.BuiltInFictitiousFunctionClassFactory.getCircleBox();
                int BottomSheetCardBindingView$watcherCardNumberView$1 = next.BottomSheetCardBindingView$watcherCardNumberView$1();
                float[] drawAngles = this.BuiltInFictitiousFunctionClassFactory.getDrawAngles();
                MPPointF centerCircleBox = this.BuiltInFictitiousFunctionClassFactory.getCenterCircleBox();
                float radius = this.BuiltInFictitiousFunctionClassFactory.getRadius();
                boolean z = this.BuiltInFictitiousFunctionClassFactory.isDrawHoleEnabled() && !this.BuiltInFictitiousFunctionClassFactory.isDrawSlicesUnderHoleEnabled();
                float holeRadius = z ? (this.BuiltInFictitiousFunctionClassFactory.getHoleRadius() / 100.0f) * radius : 0.0f;
                float holeRadius2 = (radius - ((this.BuiltInFictitiousFunctionClassFactory.getHoleRadius() * radius) / 100.0f)) / 2.0f;
                RectF rectF3 = new RectF();
                boolean z2 = z && this.BuiltInFictitiousFunctionClassFactory.isDrawRoundedSlicesEnabled();
                for (int i5 = 0; i5 < BottomSheetCardBindingView$watcherCardNumberView$1; i5++) {
                    if (Math.abs(next.getErrorConfigVersion(i5).getAuthRequestContext()) > Utils.KClassImpl$Data$declaredNonStaticMembers$2) {
                        i4++;
                    }
                }
                float authRequestContext = i4 <= 1 ? 0.0f : getAuthRequestContext(next);
                int i6 = 0;
                float f9 = 0.0f;
                while (i6 < BottomSheetCardBindingView$watcherCardNumberView$1) {
                    float f10 = drawAngles[i6];
                    if (Math.abs(next.getErrorConfigVersion(i6).getAuthRequestContext()) > Utils.KClassImpl$Data$declaredNonStaticMembers$2 && (!this.BuiltInFictitiousFunctionClassFactory.needsHighlight(i6) || z2)) {
                        boolean z3 = authRequestContext > 0.0f && f10 <= 180.0f;
                        it = it2;
                        this.lookAheadTest.setColor(next.PlaceComponentResult(i6));
                        float f11 = i4 == 1 ? 0.0f : authRequestContext / (radius * 0.017453292f);
                        float f12 = rotationAngle + ((f9 + (f11 / 2.0f)) * MyBillsEntityDataFactory);
                        float f13 = (f10 - f11) * MyBillsEntityDataFactory;
                        if (f13 < 0.0f) {
                            iPieDataSet = next;
                            f6 = 0.0f;
                        } else {
                            iPieDataSet = next;
                            f6 = f13;
                        }
                        this.NetworkUserEntityData$$ExternalSyntheticLambda6.reset();
                        if (z2) {
                            float f14 = radius - holeRadius2;
                            i = BottomSheetCardBindingView$watcherCardNumberView$1;
                            fArr = drawAngles;
                            double d = f12 * 0.017453292f;
                            f = rotationAngle;
                            f2 = PlaceComponentResult;
                            float cos = centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2 + (((float) Math.cos(d)) * f14);
                            float sin = centerCircleBox.PlaceComponentResult + (f14 * ((float) Math.sin(d)));
                            rectF3.set(cos - holeRadius2, sin - holeRadius2, cos + holeRadius2, sin + holeRadius2);
                        } else {
                            f = rotationAngle;
                            f2 = PlaceComponentResult;
                            i = BottomSheetCardBindingView$watcherCardNumberView$1;
                            fArr = drawAngles;
                        }
                        double d2 = f12 * 0.017453292f;
                        f3 = MyBillsEntityDataFactory;
                        float cos2 = centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2 + (((float) Math.cos(d2)) * radius);
                        float sin2 = centerCircleBox.PlaceComponentResult + (((float) Math.sin(d2)) * radius);
                        if (f6 >= 360.0f && f6 % 360.0f <= Utils.KClassImpl$Data$declaredNonStaticMembers$2) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda6.addCircle(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2, centerCircleBox.PlaceComponentResult, radius, Path.Direction.CW);
                        } else {
                            if (z2) {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda6.arcTo(rectF3, f12 + 180.0f, -180.0f);
                            }
                            this.NetworkUserEntityData$$ExternalSyntheticLambda6.arcTo(circleBox, f12, f6);
                        }
                        rectF = circleBox;
                        this.NetworkUserEntityData$$ExternalSyntheticLambda4.set(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2 - holeRadius, centerCircleBox.PlaceComponentResult - holeRadius, centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2 + holeRadius, centerCircleBox.PlaceComponentResult + holeRadius);
                        if (!z) {
                            i2 = i6;
                            rectF2 = rectF3;
                            f4 = holeRadius;
                            f5 = radius;
                            f7 = 360.0f;
                        } else if (holeRadius > 0.0f || z3) {
                            if (z3) {
                                i2 = i6;
                                rectF2 = rectF3;
                                f4 = holeRadius;
                                f8 = 180.0f;
                                i3 = 1;
                                f5 = radius;
                                float MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(centerCircleBox, radius, f10 * f3, cos2, sin2, f12, f6);
                                if (MyBillsEntityDataFactory2 < 0.0f) {
                                    MyBillsEntityDataFactory2 = -MyBillsEntityDataFactory2;
                                }
                                holeRadius = Math.max(f4, MyBillsEntityDataFactory2);
                            } else {
                                i2 = i6;
                                rectF2 = rectF3;
                                f4 = holeRadius;
                                f5 = radius;
                                f8 = 180.0f;
                                i3 = 1;
                            }
                            float f15 = (i4 == i3 || holeRadius == 0.0f) ? 0.0f : authRequestContext / (holeRadius * 0.017453292f);
                            float f16 = f15 / 2.0f;
                            float f17 = (f10 - f15) * f3;
                            if (f17 < 0.0f) {
                                f17 = 0.0f;
                            }
                            float f18 = f + ((f9 + f16) * f3) + f17;
                            if (f6 >= 360.0f && f6 % 360.0f <= Utils.KClassImpl$Data$declaredNonStaticMembers$2) {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda6.addCircle(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2, centerCircleBox.PlaceComponentResult, holeRadius, Path.Direction.CCW);
                            } else {
                                if (z2) {
                                    float f19 = f5 - holeRadius2;
                                    double d3 = 0.017453292f * f18;
                                    float cos3 = centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2 + (((float) Math.cos(d3)) * f19);
                                    float sin3 = centerCircleBox.PlaceComponentResult + (f19 * ((float) Math.sin(d3)));
                                    rectF2.set(cos3 - holeRadius2, sin3 - holeRadius2, cos3 + holeRadius2, sin3 + holeRadius2);
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda6.arcTo(rectF2, f18, f8);
                                } else {
                                    double d4 = 0.017453292f * f18;
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda6.lineTo(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2 + (((float) Math.cos(d4)) * holeRadius), centerCircleBox.PlaceComponentResult + (holeRadius * ((float) Math.sin(d4))));
                                }
                                this.NetworkUserEntityData$$ExternalSyntheticLambda6.arcTo(this.NetworkUserEntityData$$ExternalSyntheticLambda4, f18, -f17);
                            }
                            this.NetworkUserEntityData$$ExternalSyntheticLambda6.close();
                            this.KClassImpl$Data$declaredNonStaticMembers$2.drawPath(this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.lookAheadTest);
                            f9 += f10 * f2;
                        } else {
                            i2 = i6;
                            rectF2 = rectF3;
                            f4 = holeRadius;
                            f5 = radius;
                            f7 = 360.0f;
                        }
                        if (f6 % f7 > Utils.KClassImpl$Data$declaredNonStaticMembers$2) {
                            if (z3) {
                                float f20 = f6 / 2.0f;
                                float MyBillsEntityDataFactory3 = MyBillsEntityDataFactory(centerCircleBox, f5, f10 * f3, cos2, sin2, f12, f6);
                                double d5 = (f12 + f20) * 0.017453292f;
                                this.NetworkUserEntityData$$ExternalSyntheticLambda6.lineTo(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2 + (((float) Math.cos(d5)) * MyBillsEntityDataFactory3), centerCircleBox.PlaceComponentResult + (MyBillsEntityDataFactory3 * ((float) Math.sin(d5))));
                            } else {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda6.lineTo(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2, centerCircleBox.PlaceComponentResult);
                            }
                        }
                        this.NetworkUserEntityData$$ExternalSyntheticLambda6.close();
                        this.KClassImpl$Data$declaredNonStaticMembers$2.drawPath(this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.lookAheadTest);
                        f9 += f10 * f2;
                    } else {
                        f9 += f10 * PlaceComponentResult;
                        it = it2;
                        iPieDataSet = next;
                        f = rotationAngle;
                        f2 = PlaceComponentResult;
                        f3 = MyBillsEntityDataFactory;
                        rectF = circleBox;
                        i = BottomSheetCardBindingView$watcherCardNumberView$1;
                        fArr = drawAngles;
                        i2 = i6;
                        rectF2 = rectF3;
                        f4 = holeRadius;
                        f5 = radius;
                    }
                    i6 = i2 + 1;
                    rectF3 = rectF2;
                    holeRadius = f4;
                    radius = f5;
                    it2 = it;
                    next = iPieDataSet;
                    MyBillsEntityDataFactory = f3;
                    BottomSheetCardBindingView$watcherCardNumberView$1 = i;
                    drawAngles = fArr;
                    rotationAngle = f;
                    PlaceComponentResult = f2;
                    circleBox = rectF;
                }
                MPPointF.BuiltInFictitiousFunctionClassFactory(centerCircleBox);
                i4 = 0;
            }
        }
    }

    private static float MyBillsEntityDataFactory(MPPointF mPPointF, float f, float f2, float f3, float f4, float f5, float f6) {
        double d = (f5 + f6) * 0.017453292f;
        float cos = mPPointF.KClassImpl$Data$declaredNonStaticMembers$2 + (((float) Math.cos(d)) * f);
        float sin = mPPointF.PlaceComponentResult + (((float) Math.sin(d)) * f);
        float f7 = mPPointF.KClassImpl$Data$declaredNonStaticMembers$2;
        double d2 = (f5 + (f6 / 2.0f)) * 0.017453292f;
        float cos2 = (float) Math.cos(d2);
        float f8 = mPPointF.PlaceComponentResult;
        float sin2 = (float) Math.sin(d2);
        double sqrt = Math.sqrt(Math.pow(cos - f3, 2.0d) + Math.pow(sin - f4, 2.0d)) / 2.0d;
        double d3 = f2;
        Double.isNaN(d3);
        double tan = f - ((float) (sqrt * Math.tan(((180.0d - d3) / 2.0d) * 0.017453292519943295d)));
        double sqrt2 = Math.sqrt(Math.pow((f7 + (cos2 * f)) - ((cos + f3) / 2.0f), 2.0d) + Math.pow((f8 + (sin2 * f)) - ((sin + f4) / 2.0f), 2.0d));
        Double.isNaN(tan);
        return (float) (tan - sqrt2);
    }

    private float getAuthRequestContext(IPieDataSet iPieDataSet) {
        if (iPieDataSet.B()) {
            if (iPieDataSet.BuiltInFictitiousFunctionClassFactory() / this.NetworkUserEntityData$$ExternalSyntheticLambda7.PrepareContext() > (iPieDataSet.D() / ((PieData) this.BuiltInFictitiousFunctionClassFactory.getData()).DatabaseTableConfigUtil()) * 2.0f) {
                return 0.0f;
            }
            return iPieDataSet.BuiltInFictitiousFunctionClassFactory();
        }
        return iPieDataSet.BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX WARN: Removed duplicated region for block: B:253:0x03a9  */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(android.graphics.Canvas r55) {
        /*
            Method dump skipped, instructions count: 1079
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.PieChartRenderer.PlaceComponentResult(android.graphics.Canvas):void");
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void MyBillsEntityDataFactory(Canvas canvas, Highlight[] highlightArr) {
        boolean z;
        float f;
        float f2;
        float f3;
        float[] fArr;
        float[] fArr2;
        int i;
        RectF rectF;
        float f4;
        IPieDataSet KClassImpl$Data$declaredNonStaticMembers$2;
        int i2;
        int i3;
        int i4;
        float f5;
        float f6;
        float f7;
        float f8;
        Highlight[] highlightArr2 = highlightArr;
        boolean z2 = this.BuiltInFictitiousFunctionClassFactory.isDrawHoleEnabled() && !this.BuiltInFictitiousFunctionClassFactory.isDrawSlicesUnderHoleEnabled();
        if (z2 && this.BuiltInFictitiousFunctionClassFactory.isDrawRoundedSlicesEnabled()) {
            return;
        }
        float PlaceComponentResult = this.scheduleImpl.PlaceComponentResult();
        float MyBillsEntityDataFactory = this.scheduleImpl.MyBillsEntityDataFactory();
        float rotationAngle = this.BuiltInFictitiousFunctionClassFactory.getRotationAngle();
        float[] drawAngles = this.BuiltInFictitiousFunctionClassFactory.getDrawAngles();
        float[] absoluteAngles = this.BuiltInFictitiousFunctionClassFactory.getAbsoluteAngles();
        MPPointF centerCircleBox = this.BuiltInFictitiousFunctionClassFactory.getCenterCircleBox();
        float radius = this.BuiltInFictitiousFunctionClassFactory.getRadius();
        float holeRadius = z2 ? (this.BuiltInFictitiousFunctionClassFactory.getHoleRadius() / 100.0f) * radius : 0.0f;
        RectF rectF2 = this.getErrorConfigVersion;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i5 = 0;
        while (i5 < highlightArr2.length) {
            int i6 = (int) highlightArr2[i5].moveToNextValue;
            if (i6 >= drawAngles.length || (KClassImpl$Data$declaredNonStaticMembers$2 = ((PieData) this.BuiltInFictitiousFunctionClassFactory.getData()).KClassImpl$Data$declaredNonStaticMembers$2(highlightArr2[i5].MyBillsEntityDataFactory)) == null || !KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                z = z2;
                f = PlaceComponentResult;
                f2 = MyBillsEntityDataFactory;
                f3 = rotationAngle;
                fArr = drawAngles;
                fArr2 = absoluteAngles;
                i = i5;
                rectF = rectF2;
                f4 = holeRadius;
            } else {
                int BottomSheetCardBindingView$watcherCardNumberView$1 = KClassImpl$Data$declaredNonStaticMembers$2.BottomSheetCardBindingView$watcherCardNumberView$1();
                int i7 = 0;
                for (int i8 = 0; i8 < BottomSheetCardBindingView$watcherCardNumberView$1; i8++) {
                    if (Math.abs(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion(i8).getAuthRequestContext()) > Utils.KClassImpl$Data$declaredNonStaticMembers$2) {
                        i7++;
                    }
                }
                float f9 = i6 == 0 ? 0.0f : absoluteAngles[i6 - 1] * PlaceComponentResult;
                float BuiltInFictitiousFunctionClassFactory = i7 <= 1 ? 0.0f : KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
                float f10 = drawAngles[i6];
                float KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
                f = PlaceComponentResult;
                float f11 = radius + KClassImpl$Data$declaredNonStaticMembers$22;
                fArr = drawAngles;
                rectF2.set(this.BuiltInFictitiousFunctionClassFactory.getCircleBox());
                float f12 = -KClassImpl$Data$declaredNonStaticMembers$22;
                rectF2.inset(f12, f12);
                boolean z3 = BuiltInFictitiousFunctionClassFactory > 0.0f && f10 <= 180.0f;
                this.lookAheadTest.setColor(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(i6));
                float f13 = i7 == 1 ? 0.0f : BuiltInFictitiousFunctionClassFactory / (radius * 0.017453292f);
                float f14 = i7 == 1 ? 0.0f : BuiltInFictitiousFunctionClassFactory / (f11 * 0.017453292f);
                float f15 = rotationAngle + (((f13 / 2.0f) + f9) * MyBillsEntityDataFactory);
                float f16 = (f10 - f13) * MyBillsEntityDataFactory;
                float f17 = f16 < 0.0f ? 0.0f : f16;
                float f18 = (((f14 / 2.0f) + f9) * MyBillsEntityDataFactory) + rotationAngle;
                float f19 = (f10 - f14) * MyBillsEntityDataFactory;
                if (f19 < 0.0f) {
                    f19 = 0.0f;
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda6.reset();
                if (f17 >= 360.0f && f17 % 360.0f <= Utils.KClassImpl$Data$declaredNonStaticMembers$2) {
                    fArr2 = absoluteAngles;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda6.addCircle(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2, centerCircleBox.PlaceComponentResult, f11, Path.Direction.CW);
                    i3 = i7;
                    z = z2;
                    f2 = MyBillsEntityDataFactory;
                    f3 = rotationAngle;
                    i2 = i5;
                } else {
                    fArr2 = absoluteAngles;
                    i2 = i5;
                    i3 = i7;
                    z = z2;
                    double d = f18 * 0.017453292f;
                    f2 = MyBillsEntityDataFactory;
                    f3 = rotationAngle;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda6.moveTo(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2 + (((float) Math.cos(d)) * f11), centerCircleBox.PlaceComponentResult + (f11 * ((float) Math.sin(d))));
                    this.NetworkUserEntityData$$ExternalSyntheticLambda6.arcTo(rectF2, f18, f19);
                }
                if (z3) {
                    double d2 = f15 * 0.017453292f;
                    float cos = centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2 + (((float) Math.cos(d2)) * radius);
                    float sin = centerCircleBox.PlaceComponentResult + (((float) Math.sin(d2)) * radius);
                    i4 = i2;
                    rectF = rectF2;
                    f4 = holeRadius;
                    f5 = 0.0f;
                    f6 = MyBillsEntityDataFactory(centerCircleBox, radius, f10 * f2, cos, sin, f15, f17);
                } else {
                    rectF = rectF2;
                    f4 = holeRadius;
                    i4 = i2;
                    f5 = 0.0f;
                    f6 = 0.0f;
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda4.set(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2 - f4, centerCircleBox.PlaceComponentResult - f4, centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2 + f4, centerCircleBox.PlaceComponentResult + f4);
                if (!z) {
                    i = i4;
                    f7 = 360.0f;
                } else if (f4 > f5 || z3) {
                    if (z3) {
                        if (f6 < f5) {
                            f6 = -f6;
                        }
                        f8 = Math.max(f4, f6);
                    } else {
                        f8 = f4;
                    }
                    float f20 = (i3 == 1 || f8 == f5) ? 0.0f : BuiltInFictitiousFunctionClassFactory / (f8 * 0.017453292f);
                    float f21 = f20 / 2.0f;
                    float f22 = (f10 - f20) * f2;
                    if (f22 < f5) {
                        f22 = 0.0f;
                    }
                    float f23 = ((f9 + f21) * f2) + f3 + f22;
                    if (f17 >= 360.0f && f17 % 360.0f <= Utils.KClassImpl$Data$declaredNonStaticMembers$2) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda6.addCircle(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2, centerCircleBox.PlaceComponentResult, f8, Path.Direction.CCW);
                        i = i4;
                    } else {
                        double d3 = 0.017453292f * f23;
                        i = i4;
                        this.NetworkUserEntityData$$ExternalSyntheticLambda6.lineTo(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2 + (((float) Math.cos(d3)) * f8), centerCircleBox.PlaceComponentResult + (f8 * ((float) Math.sin(d3))));
                        this.NetworkUserEntityData$$ExternalSyntheticLambda6.arcTo(this.NetworkUserEntityData$$ExternalSyntheticLambda4, f23, -f22);
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda6.close();
                    this.KClassImpl$Data$declaredNonStaticMembers$2.drawPath(this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.lookAheadTest);
                } else {
                    i = i4;
                    f7 = 360.0f;
                }
                if (f17 % f7 > Utils.KClassImpl$Data$declaredNonStaticMembers$2) {
                    if (z3) {
                        double d4 = 0.017453292f * (f15 + (f17 / 2.0f));
                        this.NetworkUserEntityData$$ExternalSyntheticLambda6.lineTo(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2 + (((float) Math.cos(d4)) * f6), centerCircleBox.PlaceComponentResult + (f6 * ((float) Math.sin(d4))));
                    } else {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda6.lineTo(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2, centerCircleBox.PlaceComponentResult);
                    }
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda6.close();
                this.KClassImpl$Data$declaredNonStaticMembers$2.drawPath(this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.lookAheadTest);
            }
            i5 = i + 1;
            highlightArr2 = highlightArr;
            holeRadius = f4;
            rectF2 = rectF;
            PlaceComponentResult = f;
            drawAngles = fArr;
            absoluteAngles = fArr2;
            z2 = z;
            MyBillsEntityDataFactory = f2;
            rotationAngle = f3;
        }
        MPPointF.BuiltInFictitiousFunctionClassFactory(centerCircleBox);
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        Canvas canvas = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
        WeakReference<Bitmap> weakReference = this.PlaceComponentResult;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.PlaceComponentResult.clear();
            this.PlaceComponentResult = null;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void getAuthRequestContext(Canvas canvas) {
        float radius;
        RectF rectF;
        if (this.BuiltInFictitiousFunctionClassFactory.isDrawHoleEnabled() && this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            float radius2 = this.BuiltInFictitiousFunctionClassFactory.getRadius();
            float holeRadius = (this.BuiltInFictitiousFunctionClassFactory.getHoleRadius() / 100.0f) * radius2;
            MPPointF centerCircleBox = this.BuiltInFictitiousFunctionClassFactory.getCenterCircleBox();
            if (Color.alpha(this.DatabaseTableConfigUtil.getColor()) > 0) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.drawCircle(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2, centerCircleBox.PlaceComponentResult, holeRadius, this.DatabaseTableConfigUtil);
            }
            if (Color.alpha(this.initRecordTimeStamp.getColor()) > 0 && this.BuiltInFictitiousFunctionClassFactory.getTransparentCircleRadius() > this.BuiltInFictitiousFunctionClassFactory.getHoleRadius()) {
                int alpha = this.initRecordTimeStamp.getAlpha();
                float transparentCircleRadius = this.BuiltInFictitiousFunctionClassFactory.getTransparentCircleRadius() / 100.0f;
                this.initRecordTimeStamp.setAlpha((int) (alpha * this.scheduleImpl.PlaceComponentResult() * this.scheduleImpl.MyBillsEntityDataFactory()));
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.reset();
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.addCircle(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2, centerCircleBox.PlaceComponentResult, radius2 * transparentCircleRadius, Path.Direction.CW);
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.addCircle(centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2, centerCircleBox.PlaceComponentResult, holeRadius, Path.Direction.CCW);
                this.KClassImpl$Data$declaredNonStaticMembers$2.drawPath(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.initRecordTimeStamp);
                this.initRecordTimeStamp.setAlpha(alpha);
            }
            MPPointF.BuiltInFictitiousFunctionClassFactory(centerCircleBox);
        }
        canvas.drawBitmap(this.PlaceComponentResult.get(), 0.0f, 0.0f, (Paint) null);
        CharSequence centerText = this.BuiltInFictitiousFunctionClassFactory.getCenterText();
        if (!this.BuiltInFictitiousFunctionClassFactory.isDrawCenterTextEnabled() || centerText == null) {
            return;
        }
        MPPointF centerCircleBox2 = this.BuiltInFictitiousFunctionClassFactory.getCenterCircleBox();
        MPPointF centerTextOffset = this.BuiltInFictitiousFunctionClassFactory.getCenterTextOffset();
        float f = centerCircleBox2.KClassImpl$Data$declaredNonStaticMembers$2 + centerTextOffset.KClassImpl$Data$declaredNonStaticMembers$2;
        float f2 = centerCircleBox2.PlaceComponentResult + centerTextOffset.PlaceComponentResult;
        if (this.BuiltInFictitiousFunctionClassFactory.isDrawHoleEnabled() && !this.BuiltInFictitiousFunctionClassFactory.isDrawSlicesUnderHoleEnabled()) {
            radius = this.BuiltInFictitiousFunctionClassFactory.getRadius() * (this.BuiltInFictitiousFunctionClassFactory.getHoleRadius() / 100.0f);
        } else {
            radius = this.BuiltInFictitiousFunctionClassFactory.getRadius();
        }
        RectF rectF2 = this.NetworkUserEntityData$$ExternalSyntheticLambda3[0];
        rectF2.left = f - radius;
        rectF2.top = f2 - radius;
        rectF2.right = f + radius;
        rectF2.bottom = f2 + radius;
        RectF rectF3 = this.NetworkUserEntityData$$ExternalSyntheticLambda3[1];
        rectF3.set(rectF2);
        float centerTextRadiusPercent = this.BuiltInFictitiousFunctionClassFactory.getCenterTextRadiusPercent() / 100.0f;
        if (centerTextRadiusPercent > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            rectF3.inset((rectF3.width() - (rectF3.width() * centerTextRadiusPercent)) / 2.0f, (rectF3.height() - (rectF3.height() * centerTextRadiusPercent)) / 2.0f);
        }
        if (centerText.equals(this.PrepareContext) && rectF3.equals(this.newProxyInstance)) {
            rectF = rectF3;
        } else {
            this.newProxyInstance.set(rectF3);
            this.PrepareContext = centerText;
            rectF = rectF3;
            this.isLayoutRequested = new StaticLayout(centerText, 0, centerText.length(), this.MyBillsEntityDataFactory, (int) Math.max(Math.ceil(this.newProxyInstance.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        float height = this.isLayoutRequested.getHeight();
        canvas.save();
        if (Build.VERSION.SDK_INT >= 18) {
            Path path = this.getAuthRequestContext;
            path.reset();
            path.addOval(rectF2, Path.Direction.CW);
            canvas.clipPath(path);
        }
        canvas.translate(rectF.left, rectF.top + ((rectF.height() - height) / 2.0f));
        this.isLayoutRequested.draw(canvas);
        canvas.restore();
        MPPointF.BuiltInFictitiousFunctionClassFactory(centerCircleBox2);
        MPPointF.BuiltInFictitiousFunctionClassFactory(centerTextOffset);
    }
}

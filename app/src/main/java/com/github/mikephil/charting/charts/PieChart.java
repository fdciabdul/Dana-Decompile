package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.PieHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* loaded from: classes7.dex */
public class PieChart extends PieRadarChartBase<PieData> {
    private float BuiltInFictitiousFunctionClassFactory;
    private float DatabaseTableConfigUtil;
    private RectF KClassImpl$Data$declaredNonStaticMembers$2;
    private float[] MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private float NetworkUserEntityData$$ExternalSyntheticLambda2;
    private CharSequence PlaceComponentResult;
    private MPPointF getAuthRequestContext;
    private boolean getErrorConfigVersion;
    private boolean initRecordTimeStamp;
    private boolean lookAheadTest;
    protected float mMaxAngle;
    protected float mTransparentCircleRadiusPercent;
    private boolean moveToNextValue;
    private float[] scheduleImpl;

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return 0.0f;
    }

    public PieChart(Context context) {
        super(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new RectF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.scheduleImpl = new float[1];
        this.MyBillsEntityDataFactory = new float[1];
        this.moveToNextValue = true;
        this.initRecordTimeStamp = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        this.getErrorConfigVersion = false;
        this.PlaceComponentResult = "";
        this.getAuthRequestContext = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.lookAheadTest = true;
        this.BuiltInFictitiousFunctionClassFactory = 100.0f;
        this.mMaxAngle = 360.0f;
        this.DatabaseTableConfigUtil = 0.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new RectF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.scheduleImpl = new float[1];
        this.MyBillsEntityDataFactory = new float[1];
        this.moveToNextValue = true;
        this.initRecordTimeStamp = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        this.getErrorConfigVersion = false;
        this.PlaceComponentResult = "";
        this.getAuthRequestContext = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.lookAheadTest = true;
        this.BuiltInFictitiousFunctionClassFactory = 100.0f;
        this.mMaxAngle = 360.0f;
        this.DatabaseTableConfigUtil = 0.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new RectF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.scheduleImpl = new float[1];
        this.MyBillsEntityDataFactory = new float[1];
        this.moveToNextValue = true;
        this.initRecordTimeStamp = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        this.getErrorConfigVersion = false;
        this.PlaceComponentResult = "";
        this.getAuthRequestContext = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.lookAheadTest = true;
        this.BuiltInFictitiousFunctionClassFactory = 100.0f;
        this.mMaxAngle = 360.0f;
        this.DatabaseTableConfigUtil = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mRenderer = new PieChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mXAxis = null;
        this.mHighlighter = new PieHighlighter(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData == 0) {
            return;
        }
        this.mRenderer.BuiltInFictitiousFunctionClassFactory(canvas);
        if (valuesToHighlight()) {
            this.mRenderer.MyBillsEntityDataFactory(canvas, this.mIndicesToHighlight);
        }
        this.mRenderer.getAuthRequestContext(canvas);
        this.mRenderer.PlaceComponentResult(canvas);
        this.mLegendRenderer.getAuthRequestContext(canvas);
        drawDescription(canvas);
        drawMarkers(canvas);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        super.calculateOffsets();
        if (this.mData == 0) {
            return;
        }
        float diameter = getDiameter() / 2.0f;
        MPPointF centerOffsets = getCenterOffsets();
        float KClassImpl$Data$declaredNonStaticMembers$2 = ((PieData) this.mData).initRecordTimeStamp().KClassImpl$Data$declaredNonStaticMembers$2();
        this.KClassImpl$Data$declaredNonStaticMembers$2.set((centerOffsets.KClassImpl$Data$declaredNonStaticMembers$2 - diameter) + KClassImpl$Data$declaredNonStaticMembers$2, (centerOffsets.PlaceComponentResult - diameter) + KClassImpl$Data$declaredNonStaticMembers$2, (centerOffsets.KClassImpl$Data$declaredNonStaticMembers$2 + diameter) - KClassImpl$Data$declaredNonStaticMembers$2, (centerOffsets.PlaceComponentResult + diameter) - KClassImpl$Data$declaredNonStaticMembers$2);
        MPPointF.BuiltInFictitiousFunctionClassFactory(centerOffsets);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart
    public float[] getMarkerPosition(Highlight highlight) {
        MPPointF centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float f = (radius / 10.0f) * 3.6f;
        if (isDrawHoleEnabled()) {
            f = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float rotationAngle = getRotationAngle();
        float f2 = this.scheduleImpl[(int) highlight.moveToNextValue] / 2.0f;
        double d = radius - f;
        double cos = Math.cos(Math.toRadians(((this.MyBillsEntityDataFactory[r11] + rotationAngle) - f2) * this.mAnimator.MyBillsEntityDataFactory()));
        double d2 = centerCircleBox.KClassImpl$Data$declaredNonStaticMembers$2;
        Double.isNaN(d);
        Double.isNaN(d2);
        double sin = Math.sin(Math.toRadians(((rotationAngle + this.MyBillsEntityDataFactory[r11]) - f2) * this.mAnimator.MyBillsEntityDataFactory()));
        double d3 = centerCircleBox.PlaceComponentResult;
        Double.isNaN(d);
        Double.isNaN(d3);
        MPPointF.BuiltInFictitiousFunctionClassFactory(centerCircleBox);
        return new float[]{(float) ((cos * d) + d2), (float) ((d * sin) + d3)};
    }

    public boolean needsHighlight(int i) {
        if (valuesToHighlight()) {
            for (int i2 = 0; i2 < this.mIndicesToHighlight.length; i2++) {
                if (((int) this.mIndicesToHighlight[i2].moveToNextValue) == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int getIndexForAngle(float f) {
        float KClassImpl$Data$declaredNonStaticMembers$2 = Utils.KClassImpl$Data$declaredNonStaticMembers$2(f - getRotationAngle());
        int i = 0;
        while (true) {
            float[] fArr = this.MyBillsEntityDataFactory;
            if (i >= fArr.length) {
                return -1;
            }
            if (fArr[i] > KClassImpl$Data$declaredNonStaticMembers$2) {
                return i;
            }
            i++;
        }
    }

    public int getDataSetIndexForIndex(int i) {
        List<IPieDataSet> BuiltInFictitiousFunctionClassFactory = ((PieData) this.mData).BuiltInFictitiousFunctionClassFactory();
        for (int i2 = 0; i2 < BuiltInFictitiousFunctionClassFactory.size(); i2++) {
            if (BuiltInFictitiousFunctionClassFactory.get(i2).getAuthRequestContext(i, Float.NaN) != null) {
                return i2;
            }
        }
        return -1;
    }

    public float[] getDrawAngles() {
        return this.scheduleImpl;
    }

    public float[] getAbsoluteAngles() {
        return this.MyBillsEntityDataFactory;
    }

    public void setHoleColor(int i) {
        ((PieChartRenderer) this.mRenderer).MyBillsEntityDataFactory().setColor(i);
    }

    public void setDrawSlicesUnderHole(boolean z) {
        this.initRecordTimeStamp = z;
    }

    public boolean isDrawSlicesUnderHoleEnabled() {
        return this.initRecordTimeStamp;
    }

    public void setDrawHoleEnabled(boolean z) {
        this.moveToNextValue = z;
    }

    public boolean isDrawHoleEnabled() {
        return this.moveToNextValue;
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.PlaceComponentResult = "";
        } else {
            this.PlaceComponentResult = charSequence;
        }
    }

    public CharSequence getCenterText() {
        return this.PlaceComponentResult;
    }

    public void setDrawCenterText(boolean z) {
        this.lookAheadTest = z;
    }

    public boolean isDrawCenterTextEnabled() {
        return this.lookAheadTest;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredLegendOffset() {
        return this.mLegendRenderer.BuiltInFictitiousFunctionClassFactory().getTextSize() * 2.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectF = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.KClassImpl$Data$declaredNonStaticMembers$2.height() / 2.0f);
    }

    public RectF getCircleBox() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public MPPointF getCenterCircleBox() {
        return MPPointF.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.centerX(), this.KClassImpl$Data$declaredNonStaticMembers$2.centerY());
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).MyBillsEntityDataFactory.setTypeface(typeface);
    }

    public void setCenterTextSize(float f) {
        ((PieChartRenderer) this.mRenderer).MyBillsEntityDataFactory.setTextSize(Utils.PlaceComponentResult(f));
    }

    public void setCenterTextSizePixels(float f) {
        ((PieChartRenderer) this.mRenderer).MyBillsEntityDataFactory.setTextSize(f);
    }

    public void setCenterTextOffset(float f, float f2) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = Utils.PlaceComponentResult(f);
        this.getAuthRequestContext.PlaceComponentResult = Utils.PlaceComponentResult(f2);
    }

    public MPPointF getCenterTextOffset() {
        return MPPointF.getAuthRequestContext(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext.PlaceComponentResult);
    }

    public void setCenterTextColor(int i) {
        ((PieChartRenderer) this.mRenderer).MyBillsEntityDataFactory.setColor(i);
    }

    public void setHoleRadius(float f) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = f;
    }

    public float getHoleRadius() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public void setTransparentCircleColor(int i) {
        Paint KClassImpl$Data$declaredNonStaticMembers$2 = ((PieChartRenderer) this.mRenderer).KClassImpl$Data$declaredNonStaticMembers$2();
        int alpha = KClassImpl$Data$declaredNonStaticMembers$2.getAlpha();
        KClassImpl$Data$declaredNonStaticMembers$2.setColor(i);
        KClassImpl$Data$declaredNonStaticMembers$2.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f) {
        this.mTransparentCircleRadiusPercent = f;
    }

    public float getTransparentCircleRadius() {
        return this.mTransparentCircleRadiusPercent;
    }

    public void setTransparentCircleAlpha(int i) {
        ((PieChartRenderer) this.mRenderer).KClassImpl$Data$declaredNonStaticMembers$2().setAlpha(i);
    }

    @Deprecated
    public void setDrawSliceText(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
    }

    public void setDrawEntryLabels(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
    }

    public boolean isDrawEntryLabelsEnabled() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public void setEntryLabelColor(int i) {
        ((PieChartRenderer) this.mRenderer).NetworkUserEntityData$$ExternalSyntheticLambda1.setColor(i);
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).NetworkUserEntityData$$ExternalSyntheticLambda1.setTypeface(typeface);
    }

    public void setEntryLabelTextSize(float f) {
        ((PieChartRenderer) this.mRenderer).NetworkUserEntityData$$ExternalSyntheticLambda1.setTextSize(Utils.PlaceComponentResult(f));
    }

    public void setDrawRoundedSlices(boolean z) {
        this.getErrorConfigVersion = z;
    }

    public boolean isDrawRoundedSlicesEnabled() {
        return this.getErrorConfigVersion;
    }

    public void setUsePercentValues(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = z;
    }

    public boolean isUsePercentValuesEnabled() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public void setCenterTextRadiusPercent(float f) {
        this.BuiltInFictitiousFunctionClassFactory = f;
    }

    public float getCenterTextRadiusPercent() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public float getMaxAngle() {
        return this.mMaxAngle;
    }

    public void setMaxAngle(float f) {
        if (f > 360.0f) {
            f = 360.0f;
        }
        if (f < 90.0f) {
            f = 90.0f;
        }
        this.mMaxAngle = f;
    }

    public float getMinAngleForSlices() {
        return this.DatabaseTableConfigUtil;
    }

    public void setMinAngleForSlices(float f) {
        float f2 = this.mMaxAngle / 2.0f;
        if (f > f2) {
            f = f2;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.DatabaseTableConfigUtil = f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        if (this.mRenderer != null && (this.mRenderer instanceof PieChartRenderer)) {
            ((PieChartRenderer) this.mRenderer).BuiltInFictitiousFunctionClassFactory();
        }
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void calcMinMax() {
        int authRequestContext = ((PieData) this.mData).getAuthRequestContext();
        if (this.scheduleImpl.length != authRequestContext) {
            this.scheduleImpl = new float[authRequestContext];
        } else {
            for (int i = 0; i < authRequestContext; i++) {
                this.scheduleImpl[i] = 0.0f;
            }
        }
        if (this.MyBillsEntityDataFactory.length != authRequestContext) {
            this.MyBillsEntityDataFactory = new float[authRequestContext];
        } else {
            for (int i2 = 0; i2 < authRequestContext; i2++) {
                this.MyBillsEntityDataFactory[i2] = 0.0f;
            }
        }
        float DatabaseTableConfigUtil = ((PieData) this.mData).DatabaseTableConfigUtil();
        List<IPieDataSet> BuiltInFictitiousFunctionClassFactory = ((PieData) this.mData).BuiltInFictitiousFunctionClassFactory();
        float f = this.DatabaseTableConfigUtil;
        boolean z = f != 0.0f && ((float) authRequestContext) * f <= this.mMaxAngle;
        float[] fArr = new float[authRequestContext];
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i3 = 0;
        for (int i4 = 0; i4 < ((PieData) this.mData).KClassImpl$Data$declaredNonStaticMembers$2(); i4++) {
            IPieDataSet iPieDataSet = BuiltInFictitiousFunctionClassFactory.get(i4);
            for (int i5 = 0; i5 < iPieDataSet.BottomSheetCardBindingView$watcherCardNumberView$1(); i5++) {
                float abs = (Math.abs(iPieDataSet.getErrorConfigVersion(i5).getAuthRequestContext()) / DatabaseTableConfigUtil) * this.mMaxAngle;
                if (z) {
                    float f4 = this.DatabaseTableConfigUtil;
                    float f5 = abs - f4;
                    if (f5 <= 0.0f) {
                        fArr[i3] = f4;
                        f3 += -f5;
                    } else {
                        fArr[i3] = abs;
                        f2 += f5;
                    }
                }
                this.scheduleImpl[i3] = abs;
                if (i3 == 0) {
                    this.MyBillsEntityDataFactory[i3] = abs;
                } else {
                    float[] fArr2 = this.MyBillsEntityDataFactory;
                    fArr2[i3] = fArr2[i3 - 1] + abs;
                }
                i3++;
            }
        }
        if (z) {
            for (int i6 = 0; i6 < authRequestContext; i6++) {
                float f6 = fArr[i6];
                float f7 = f6 - (((f6 - this.DatabaseTableConfigUtil) / f2) * f3);
                fArr[i6] = f7;
                if (i6 == 0) {
                    this.MyBillsEntityDataFactory[0] = fArr[0];
                } else {
                    float[] fArr3 = this.MyBillsEntityDataFactory;
                    fArr3[i6] = fArr3[i6 - 1] + f7;
                }
            }
            this.scheduleImpl = fArr;
        }
    }
}

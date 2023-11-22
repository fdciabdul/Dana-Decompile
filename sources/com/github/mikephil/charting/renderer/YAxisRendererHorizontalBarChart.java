package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* loaded from: classes7.dex */
public class YAxisRendererHorizontalBarChart extends YAxisRenderer {
    protected float[] NetworkUserEntityData$$ExternalSyntheticLambda8;
    protected Path PrepareContext;
    protected Path newProxyInstance;

    public YAxisRendererHorizontalBarChart(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, yAxis, transformer);
        this.newProxyInstance = new Path();
        this.PrepareContext = new Path();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new float[4];
        this.BuiltInFictitiousFunctionClassFactory.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public final void MyBillsEntityDataFactory(float f, float f2, boolean z) {
        double d;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.getErrorConfigVersion() > 10.0f && !this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
            Transformer transformer = this.lookAheadTest;
            float scheduleImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl();
            float moveToNextValue = this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue();
            MPPointD KClassImpl$Data$declaredNonStaticMembers$2 = MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            transformer.getAuthRequestContext(scheduleImpl, moveToNextValue, KClassImpl$Data$declaredNonStaticMembers$2);
            Transformer transformer2 = this.lookAheadTest;
            float lookAheadTest = this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest();
            float moveToNextValue2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue();
            MPPointD KClassImpl$Data$declaredNonStaticMembers$22 = MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            transformer2.getAuthRequestContext(lookAheadTest, moveToNextValue2, KClassImpl$Data$declaredNonStaticMembers$22);
            if (!z) {
                f = (float) KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                d = KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext;
            } else {
                f = (float) KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext;
                d = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
            }
            f2 = (float) d;
            MPPointD.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((ObjectPool<MPPointD>) KClassImpl$Data$declaredNonStaticMembers$2);
            MPPointD.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((ObjectPool<MPPointD>) KClassImpl$Data$declaredNonStaticMembers$22);
        }
        getAuthRequestContext(f, f2);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Canvas canvas) {
        float BuiltInFictitiousFunctionClassFactory;
        if (this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda3() && this.GetContactSyncConfig.lookAheadTest()) {
            float[] authRequestContext = getAuthRequestContext();
            this.MyBillsEntityDataFactory.setTypeface(this.GetContactSyncConfig.PrepareContext());
            this.MyBillsEntityDataFactory.setTextSize(this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda7());
            this.MyBillsEntityDataFactory.setColor(this.GetContactSyncConfig.isLayoutRequested());
            this.MyBillsEntityDataFactory.setTextAlign(Paint.Align.CENTER);
            float PlaceComponentResult = Utils.PlaceComponentResult(2.5f);
            float authRequestContext2 = Utils.getAuthRequestContext(this.MyBillsEntityDataFactory, "Q");
            YAxis.AxisDependency axisDependency = this.GetContactSyncConfig.getOnBoardingScenario;
            YAxis.YAxisLabelPosition yAxisLabelPosition = this.GetContactSyncConfig.H;
            if (axisDependency == YAxis.AxisDependency.LEFT) {
                YAxis.YAxisLabelPosition yAxisLabelPosition2 = YAxis.YAxisLabelPosition.OUTSIDE_CHART;
                BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue() - PlaceComponentResult;
            } else {
                YAxis.YAxisLabelPosition yAxisLabelPosition3 = YAxis.YAxisLabelPosition.OUTSIDE_CHART;
                BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory() + authRequestContext2 + PlaceComponentResult;
            }
            getAuthRequestContext(canvas, BuiltInFictitiousFunctionClassFactory, authRequestContext, this.GetContactSyncConfig.FragmentBottomSheetPaymentSettingBinding());
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public final void MyBillsEntityDataFactory(Canvas canvas) {
        if (this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda3() && this.GetContactSyncConfig.scheduleImpl()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setColor(this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2);
            this.KClassImpl$Data$declaredNonStaticMembers$2.setStrokeWidth(this.GetContactSyncConfig.PlaceComponentResult);
            if (this.GetContactSyncConfig.getOnBoardingScenario == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue(), this.KClassImpl$Data$declaredNonStaticMembers$2);
            } else {
                canvas.drawLine(this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory(), this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected final void getAuthRequestContext(Canvas canvas, float f, float[] fArr, float f2) {
        this.MyBillsEntityDataFactory.setTypeface(this.GetContactSyncConfig.PrepareContext());
        this.MyBillsEntityDataFactory.setTextSize(this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda7());
        this.MyBillsEntityDataFactory.setColor(this.GetContactSyncConfig.isLayoutRequested());
        int i = this.GetContactSyncConfig.SubSequence() ? this.GetContactSyncConfig.PrepareContext : this.GetContactSyncConfig.PrepareContext - 1;
        for (int i2 = !this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda4(); i2 < i; i2++) {
            canvas.drawText(this.GetContactSyncConfig.getAuthRequestContext(i2), fArr[i2 * 2], f - f2, this.MyBillsEntityDataFactory);
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected final float[] getAuthRequestContext() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.length != this.GetContactSyncConfig.PrepareContext * 2) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new float[this.GetContactSyncConfig.PrepareContext * 2];
        }
        float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        for (int i = 0; i < fArr.length; i += 2) {
            fArr[i] = this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda8[i / 2];
        }
        this.lookAheadTest.PlaceComponentResult(fArr);
        return fArr;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public final RectF KClassImpl$Data$declaredNonStaticMembers$2() {
        this.scheduleImpl.set(this.NetworkUserEntityData$$ExternalSyntheticLambda7.GetContactSyncConfig());
        this.scheduleImpl.inset(-this.getAuthRequestContext.FragmentBottomSheetPaymentSettingBinding, 0.0f);
        return this.scheduleImpl;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected final Path PlaceComponentResult(Path path, int i, float[] fArr) {
        path.moveTo(fArr[i], this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue());
        path.lineTo(fArr[i], this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory());
        return path;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected final void BuiltInFictitiousFunctionClassFactory(Canvas canvas) {
        int save = canvas.save();
        this.DatabaseTableConfigUtil.set(this.NetworkUserEntityData$$ExternalSyntheticLambda7.GetContactSyncConfig());
        this.DatabaseTableConfigUtil.inset(-this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda5(), 0.0f);
        canvas.clipRect(this.moveToNextValue);
        MPPointD BuiltInFictitiousFunctionClassFactory = this.lookAheadTest.BuiltInFictitiousFunctionClassFactory(0.0f, 0.0f);
        this.isLayoutRequested.setColor(this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda6());
        this.isLayoutRequested.setStrokeWidth(this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda5());
        Path path = this.newProxyInstance;
        path.reset();
        path.moveTo(((float) BuiltInFictitiousFunctionClassFactory.getAuthRequestContext) - 1.0f, this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue());
        path.lineTo(((float) BuiltInFictitiousFunctionClassFactory.getAuthRequestContext) - 1.0f, this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory());
        canvas.drawPath(path, this.isLayoutRequested);
        canvas.restoreToCount(save);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public final void PlaceComponentResult(Canvas canvas) {
        List<LimitLine> authRequestContext = this.GetContactSyncConfig.getAuthRequestContext();
        if (authRequestContext == null || authRequestContext.size() <= 0) {
            return;
        }
        float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        float f = 0.0f;
        fArr[0] = 0.0f;
        char c = 1;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        Path path = this.PrepareContext;
        path.reset();
        int i = 0;
        while (i < authRequestContext.size()) {
            LimitLine limitLine = authRequestContext.get(i);
            if (limitLine.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
                int save = canvas.save();
                this.moveToNextValue.set(this.NetworkUserEntityData$$ExternalSyntheticLambda7.GetContactSyncConfig());
                this.moveToNextValue.inset(-limitLine.lookAheadTest, f);
                canvas.clipRect(this.moveToNextValue);
                fArr[0] = limitLine.KClassImpl$Data$declaredNonStaticMembers$2;
                fArr[2] = limitLine.KClassImpl$Data$declaredNonStaticMembers$2;
                this.lookAheadTest.PlaceComponentResult(fArr);
                fArr[c] = this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue();
                fArr[3] = this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory();
                path.moveTo(fArr[0], fArr[c]);
                path.lineTo(fArr[2], fArr[3]);
                this.BuiltInFictitiousFunctionClassFactory.setStyle(Paint.Style.STROKE);
                this.BuiltInFictitiousFunctionClassFactory.setColor(limitLine.PlaceComponentResult);
                this.BuiltInFictitiousFunctionClassFactory.setPathEffect(limitLine.MyBillsEntityDataFactory);
                this.BuiltInFictitiousFunctionClassFactory.setStrokeWidth(limitLine.lookAheadTest);
                canvas.drawPath(path, this.BuiltInFictitiousFunctionClassFactory);
                path.reset();
                String str = limitLine.getAuthRequestContext;
                if (str != null && !str.equals("")) {
                    this.BuiltInFictitiousFunctionClassFactory.setStyle(limitLine.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    this.BuiltInFictitiousFunctionClassFactory.setPathEffect(null);
                    this.BuiltInFictitiousFunctionClassFactory.setColor(limitLine.isLayoutRequested());
                    this.BuiltInFictitiousFunctionClassFactory.setTypeface(limitLine.PrepareContext());
                    this.BuiltInFictitiousFunctionClassFactory.setStrokeWidth(0.5f);
                    this.BuiltInFictitiousFunctionClassFactory.setTextSize(limitLine.NetworkUserEntityData$$ExternalSyntheticLambda7());
                    float newProxyInstance = limitLine.lookAheadTest + limitLine.newProxyInstance();
                    float PlaceComponentResult = Utils.PlaceComponentResult(2.0f) + limitLine.FragmentBottomSheetPaymentSettingBinding();
                    LimitLine.LimitLabelPosition limitLabelPosition = limitLine.BuiltInFictitiousFunctionClassFactory;
                    if (limitLabelPosition == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                        float authRequestContext2 = Utils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, str);
                        this.BuiltInFictitiousFunctionClassFactory.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(str, fArr[0] + newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue() + PlaceComponentResult + authRequestContext2, this.BuiltInFictitiousFunctionClassFactory);
                    } else if (limitLabelPosition == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                        this.BuiltInFictitiousFunctionClassFactory.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(str, fArr[0] + newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory() - PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
                    } else if (limitLabelPosition == LimitLine.LimitLabelPosition.LEFT_TOP) {
                        this.BuiltInFictitiousFunctionClassFactory.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(str, fArr[0] - newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue() + PlaceComponentResult + Utils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, str), this.BuiltInFictitiousFunctionClassFactory);
                    } else {
                        this.BuiltInFictitiousFunctionClassFactory.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(str, fArr[0] - newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory() - PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
                    }
                }
                canvas.restoreToCount(save);
            }
            i++;
            f = 0.0f;
            c = 1;
        }
    }
}

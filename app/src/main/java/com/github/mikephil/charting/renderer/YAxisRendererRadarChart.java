package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* loaded from: classes7.dex */
public class YAxisRendererRadarChart extends YAxisRenderer {
    private Path PrepareContext;
    private RadarChart newProxyInstance;

    public YAxisRendererRadarChart(ViewPortHandler viewPortHandler, YAxis yAxis, RadarChart radarChart) {
        super(viewPortHandler, yAxis, null);
        this.PrepareContext = new Path();
        this.newProxyInstance = radarChart;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public final void getAuthRequestContext(float f, float f2) {
        double ceil;
        double MyBillsEntityDataFactory;
        int i;
        float f3 = f;
        int i2 = this.getAuthRequestContext.SubSequence;
        double abs = Math.abs(f2 - f3);
        if (i2 == 0 || abs <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || Double.isInfinite(abs)) {
            this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8 = new float[0];
            this.getAuthRequestContext.moveToNextValue = new float[0];
            this.getAuthRequestContext.PrepareContext = 0;
            return;
        }
        double d = i2;
        Double.isNaN(abs);
        Double.isNaN(d);
        double KClassImpl$Data$declaredNonStaticMembers$2 = Utils.KClassImpl$Data$declaredNonStaticMembers$2(abs / d);
        if (this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2() && KClassImpl$Data$declaredNonStaticMembers$2 < this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
            KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        double KClassImpl$Data$declaredNonStaticMembers$22 = Utils.KClassImpl$Data$declaredNonStaticMembers$2(Math.pow(10.0d, (int) Math.log10(KClassImpl$Data$declaredNonStaticMembers$2)));
        Double.isNaN(KClassImpl$Data$declaredNonStaticMembers$22);
        if (((int) (KClassImpl$Data$declaredNonStaticMembers$2 / KClassImpl$Data$declaredNonStaticMembers$22)) > 5) {
            Double.isNaN(KClassImpl$Data$declaredNonStaticMembers$22);
            KClassImpl$Data$declaredNonStaticMembers$2 = Math.floor(KClassImpl$Data$declaredNonStaticMembers$22 * 10.0d);
        }
        boolean BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
        if (this.getAuthRequestContext.DatabaseTableConfigUtil()) {
            float f4 = ((float) abs) / ((float) (i2 - 1));
            this.getAuthRequestContext.PrepareContext = i2;
            if (this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8.length < i2) {
                this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8 = new float[i2];
            }
            for (int i3 = 0; i3 < i2; i3++) {
                this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8[i3] = f3;
                f3 += f4;
            }
        } else {
            if (KClassImpl$Data$declaredNonStaticMembers$2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                ceil = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            } else {
                double d2 = f3;
                Double.isNaN(d2);
                ceil = Math.ceil(d2 / KClassImpl$Data$declaredNonStaticMembers$2) * KClassImpl$Data$declaredNonStaticMembers$2;
            }
            if (BuiltInFictitiousFunctionClassFactory) {
                ceil -= KClassImpl$Data$declaredNonStaticMembers$2;
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                MyBillsEntityDataFactory = 0.0d;
            } else {
                double d3 = f2;
                Double.isNaN(d3);
                MyBillsEntityDataFactory = Utils.MyBillsEntityDataFactory(Math.floor(d3 / KClassImpl$Data$declaredNonStaticMembers$2) * KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                i = BuiltInFictitiousFunctionClassFactory;
                for (double d4 = ceil; d4 <= MyBillsEntityDataFactory; d4 += KClassImpl$Data$declaredNonStaticMembers$2) {
                    i++;
                }
            } else {
                i = BuiltInFictitiousFunctionClassFactory;
            }
            int i4 = i + 1;
            this.getAuthRequestContext.PrepareContext = i4;
            if (this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8.length < i4) {
                this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8 = new float[i4];
            }
            for (int i5 = 0; i5 < i4; i5++) {
                if (ceil == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    ceil = 0.0d;
                }
                this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8[i5] = (float) ceil;
                ceil += KClassImpl$Data$declaredNonStaticMembers$2;
            }
            i2 = i4;
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2 < 1.0d) {
            this.getAuthRequestContext.GetContactSyncConfig = (int) Math.ceil(-Math.log10(KClassImpl$Data$declaredNonStaticMembers$2));
        } else {
            this.getAuthRequestContext.GetContactSyncConfig = 0;
        }
        if (BuiltInFictitiousFunctionClassFactory != 0) {
            if (this.getAuthRequestContext.moveToNextValue.length < i2) {
                this.getAuthRequestContext.moveToNextValue = new float[i2];
            }
            float f5 = (this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8[1] - this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8[0]) / 2.0f;
            for (int i6 = 0; i6 < i2; i6++) {
                this.getAuthRequestContext.moveToNextValue[i6] = this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8[i6] + f5;
            }
        }
        this.getAuthRequestContext.MyBillsEntityDataFactory = this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8[0];
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8[i2 - 1];
        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 = Math.abs(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory - this.getAuthRequestContext.MyBillsEntityDataFactory);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Canvas canvas) {
        if (this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda3() && this.GetContactSyncConfig.lookAheadTest()) {
            this.MyBillsEntityDataFactory.setTypeface(this.GetContactSyncConfig.PrepareContext());
            this.MyBillsEntityDataFactory.setTextSize(this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda7());
            this.MyBillsEntityDataFactory.setColor(this.GetContactSyncConfig.isLayoutRequested());
            MPPointF centerOffsets = this.newProxyInstance.getCenterOffsets();
            MPPointF authRequestContext = MPPointF.getAuthRequestContext(0.0f, 0.0f);
            float factor = this.newProxyInstance.getFactor();
            int i = this.GetContactSyncConfig.SubSequence() ? this.GetContactSyncConfig.PrepareContext : this.GetContactSyncConfig.PrepareContext - 1;
            for (int i2 = !this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda4(); i2 < i; i2++) {
                Utils.KClassImpl$Data$declaredNonStaticMembers$2(centerOffsets, (this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda8[i2] - this.GetContactSyncConfig.MyBillsEntityDataFactory) * factor, this.newProxyInstance.getRotationAngle(), authRequestContext);
                canvas.drawText(this.GetContactSyncConfig.getAuthRequestContext(i2), authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 + 10.0f, authRequestContext.PlaceComponentResult, this.MyBillsEntityDataFactory);
            }
            MPPointF.BuiltInFictitiousFunctionClassFactory(centerOffsets);
            MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext);
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public final void PlaceComponentResult(Canvas canvas) {
        List<LimitLine> authRequestContext = this.GetContactSyncConfig.getAuthRequestContext();
        if (authRequestContext == null) {
            return;
        }
        float sliceAngle = this.newProxyInstance.getSliceAngle();
        float factor = this.newProxyInstance.getFactor();
        MPPointF centerOffsets = this.newProxyInstance.getCenterOffsets();
        MPPointF authRequestContext2 = MPPointF.getAuthRequestContext(0.0f, 0.0f);
        for (int i = 0; i < authRequestContext.size(); i++) {
            LimitLine limitLine = authRequestContext.get(i);
            if (limitLine.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
                this.BuiltInFictitiousFunctionClassFactory.setColor(limitLine.PlaceComponentResult);
                this.BuiltInFictitiousFunctionClassFactory.setPathEffect(limitLine.MyBillsEntityDataFactory);
                this.BuiltInFictitiousFunctionClassFactory.setStrokeWidth(limitLine.lookAheadTest);
                float f = limitLine.KClassImpl$Data$declaredNonStaticMembers$2;
                float yChartMin = this.newProxyInstance.getYChartMin();
                Path path = this.PrepareContext;
                path.reset();
                for (int i2 = 0; i2 < ((RadarData) this.newProxyInstance.getData()).getErrorConfigVersion().BottomSheetCardBindingView$watcherCardNumberView$1(); i2++) {
                    Utils.KClassImpl$Data$declaredNonStaticMembers$2(centerOffsets, (f - yChartMin) * factor, (i2 * sliceAngle) + this.newProxyInstance.getRotationAngle(), authRequestContext2);
                    if (i2 == 0) {
                        path.moveTo(authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext2.PlaceComponentResult);
                    } else {
                        path.lineTo(authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext2.PlaceComponentResult);
                    }
                }
                path.close();
                canvas.drawPath(path, this.BuiltInFictitiousFunctionClassFactory);
            }
        }
        MPPointF.BuiltInFictitiousFunctionClassFactory(centerOffsets);
        MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext2);
    }
}

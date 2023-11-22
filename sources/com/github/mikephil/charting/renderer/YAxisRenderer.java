package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: classes3.dex */
public class YAxisRenderer extends AxisRenderer {
    protected RectF DatabaseTableConfigUtil;
    protected YAxis GetContactSyncConfig;
    protected float[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected float[] NetworkUserEntityData$$ExternalSyntheticLambda1;
    protected Path NetworkUserEntityData$$ExternalSyntheticLambda2;
    protected Path getErrorConfigVersion;
    protected Path initRecordTimeStamp;
    protected Paint isLayoutRequested;
    protected RectF moveToNextValue;
    protected RectF scheduleImpl;

    public YAxisRenderer(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, transformer, yAxis);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Path();
        this.scheduleImpl = new RectF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new float[2];
        this.getErrorConfigVersion = new Path();
        this.DatabaseTableConfigUtil = new RectF();
        this.initRecordTimeStamp = new Path();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[2];
        this.moveToNextValue = new RectF();
        this.GetContactSyncConfig = yAxis;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 != null) {
            this.MyBillsEntityDataFactory.setColor(-16777216);
            this.MyBillsEntityDataFactory.setTextSize(Utils.PlaceComponentResult(10.0f));
            Paint paint = new Paint(1);
            this.isLayoutRequested = paint;
            paint.setColor(-7829368);
            this.isLayoutRequested.setStrokeWidth(1.0f);
            this.isLayoutRequested.setStyle(Paint.Style.STROKE);
        }
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(Canvas canvas) {
        float lookAheadTest;
        float lookAheadTest2;
        float f;
        if (this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda3() && this.GetContactSyncConfig.lookAheadTest()) {
            float[] authRequestContext = getAuthRequestContext();
            this.MyBillsEntityDataFactory.setTypeface(this.GetContactSyncConfig.PrepareContext());
            this.MyBillsEntityDataFactory.setTextSize(this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda7());
            this.MyBillsEntityDataFactory.setColor(this.GetContactSyncConfig.isLayoutRequested());
            float newProxyInstance = this.GetContactSyncConfig.newProxyInstance();
            float authRequestContext2 = Utils.getAuthRequestContext(this.MyBillsEntityDataFactory, "A") / 2.5f;
            float FragmentBottomSheetPaymentSettingBinding = this.GetContactSyncConfig.FragmentBottomSheetPaymentSettingBinding();
            YAxis.AxisDependency axisDependency = this.GetContactSyncConfig.getOnBoardingScenario;
            YAxis.YAxisLabelPosition yAxisLabelPosition = this.GetContactSyncConfig.H;
            if (axisDependency == YAxis.AxisDependency.LEFT) {
                if (yAxisLabelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    this.MyBillsEntityDataFactory.setTextAlign(Paint.Align.RIGHT);
                    lookAheadTest = this.NetworkUserEntityData$$ExternalSyntheticLambda7.FragmentBottomSheetPaymentSettingBinding();
                    f = lookAheadTest - newProxyInstance;
                } else {
                    this.MyBillsEntityDataFactory.setTextAlign(Paint.Align.LEFT);
                    lookAheadTest2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.FragmentBottomSheetPaymentSettingBinding();
                    f = lookAheadTest2 + newProxyInstance;
                }
            } else if (yAxisLabelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                this.MyBillsEntityDataFactory.setTextAlign(Paint.Align.LEFT);
                lookAheadTest2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest();
                f = lookAheadTest2 + newProxyInstance;
            } else {
                this.MyBillsEntityDataFactory.setTextAlign(Paint.Align.RIGHT);
                lookAheadTest = this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest();
                f = lookAheadTest - newProxyInstance;
            }
            getAuthRequestContext(canvas, f, authRequestContext, authRequestContext2 + FragmentBottomSheetPaymentSettingBinding);
        }
    }

    public void MyBillsEntityDataFactory(Canvas canvas) {
        if (this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda3() && this.GetContactSyncConfig.scheduleImpl()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setColor(this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2);
            this.KClassImpl$Data$declaredNonStaticMembers$2.setStrokeWidth(this.GetContactSyncConfig.PlaceComponentResult);
            if (this.GetContactSyncConfig.getOnBoardingScenario == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory(), this.KClassImpl$Data$declaredNonStaticMembers$2);
            } else {
                canvas.drawLine(this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory(), this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
    }

    protected void getAuthRequestContext(Canvas canvas, float f, float[] fArr, float f2) {
        int i = this.GetContactSyncConfig.SubSequence() ? this.GetContactSyncConfig.PrepareContext : this.GetContactSyncConfig.PrepareContext - 1;
        for (int i2 = !this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda4(); i2 < i; i2++) {
            canvas.drawText(this.GetContactSyncConfig.getAuthRequestContext(i2), f, fArr[(i2 * 2) + 1] + f2, this.MyBillsEntityDataFactory);
        }
    }

    public final void getAuthRequestContext(Canvas canvas) {
        if (this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
            if (this.GetContactSyncConfig.moveToNextValue()) {
                int save = canvas.save();
                canvas.clipRect(KClassImpl$Data$declaredNonStaticMembers$2());
                float[] authRequestContext = getAuthRequestContext();
                this.PlaceComponentResult.setColor(this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda5);
                this.PlaceComponentResult.setStrokeWidth(this.GetContactSyncConfig.FragmentBottomSheetPaymentSettingBinding);
                this.PlaceComponentResult.setPathEffect(this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda3);
                Path path = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                path.reset();
                for (int i = 0; i < authRequestContext.length; i += 2) {
                    canvas.drawPath(PlaceComponentResult(path, i, authRequestContext), this.PlaceComponentResult);
                    path.reset();
                }
                canvas.restoreToCount(save);
            }
            if (this.GetContactSyncConfig.getCallingPid()) {
                BuiltInFictitiousFunctionClassFactory(canvas);
            }
        }
    }

    public RectF KClassImpl$Data$declaredNonStaticMembers$2() {
        this.scheduleImpl.set(this.NetworkUserEntityData$$ExternalSyntheticLambda7.GetContactSyncConfig());
        this.scheduleImpl.inset(0.0f, -this.getAuthRequestContext.FragmentBottomSheetPaymentSettingBinding);
        return this.scheduleImpl;
    }

    protected Path PlaceComponentResult(Path path, int i, float[] fArr) {
        int i2 = i + 1;
        path.moveTo(this.NetworkUserEntityData$$ExternalSyntheticLambda7.FragmentBottomSheetPaymentSettingBinding(), fArr[i2]);
        path.lineTo(this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest(), fArr[i2]);
        return path;
    }

    protected float[] getAuthRequestContext() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.length != this.GetContactSyncConfig.PrepareContext * 2) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new float[this.GetContactSyncConfig.PrepareContext * 2];
        }
        float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        for (int i = 0; i < fArr.length; i += 2) {
            fArr[i + 1] = this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda8[i / 2];
        }
        this.lookAheadTest.PlaceComponentResult(fArr);
        return fArr;
    }

    protected void BuiltInFictitiousFunctionClassFactory(Canvas canvas) {
        int save = canvas.save();
        this.DatabaseTableConfigUtil.set(this.NetworkUserEntityData$$ExternalSyntheticLambda7.GetContactSyncConfig());
        this.DatabaseTableConfigUtil.inset(0.0f, -this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda5());
        canvas.clipRect(this.DatabaseTableConfigUtil);
        MPPointD BuiltInFictitiousFunctionClassFactory = this.lookAheadTest.BuiltInFictitiousFunctionClassFactory(0.0f, 0.0f);
        this.isLayoutRequested.setColor(this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda6());
        this.isLayoutRequested.setStrokeWidth(this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda5());
        Path path = this.getErrorConfigVersion;
        path.reset();
        path.moveTo(this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl(), (float) BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        path.lineTo(this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest(), (float) BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        canvas.drawPath(path, this.isLayoutRequested);
        canvas.restoreToCount(save);
    }

    public void PlaceComponentResult(Canvas canvas) {
        List<LimitLine> authRequestContext = this.GetContactSyncConfig.getAuthRequestContext();
        if (authRequestContext == null || authRequestContext.size() <= 0) {
            return;
        }
        float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        Path path = this.initRecordTimeStamp;
        path.reset();
        for (int i = 0; i < authRequestContext.size(); i++) {
            LimitLine limitLine = authRequestContext.get(i);
            if (limitLine.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
                int save = canvas.save();
                this.moveToNextValue.set(this.NetworkUserEntityData$$ExternalSyntheticLambda7.GetContactSyncConfig());
                this.moveToNextValue.inset(0.0f, -limitLine.lookAheadTest);
                canvas.clipRect(this.moveToNextValue);
                this.BuiltInFictitiousFunctionClassFactory.setStyle(Paint.Style.STROKE);
                this.BuiltInFictitiousFunctionClassFactory.setColor(limitLine.PlaceComponentResult);
                this.BuiltInFictitiousFunctionClassFactory.setStrokeWidth(limitLine.lookAheadTest);
                this.BuiltInFictitiousFunctionClassFactory.setPathEffect(limitLine.MyBillsEntityDataFactory);
                fArr[1] = limitLine.KClassImpl$Data$declaredNonStaticMembers$2;
                this.lookAheadTest.PlaceComponentResult(fArr);
                path.moveTo(this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl(), fArr[1]);
                path.lineTo(this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest(), fArr[1]);
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
                    float authRequestContext2 = Utils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, str);
                    float PlaceComponentResult = Utils.PlaceComponentResult(4.0f) + limitLine.newProxyInstance();
                    float FragmentBottomSheetPaymentSettingBinding = limitLine.lookAheadTest + authRequestContext2 + limitLine.FragmentBottomSheetPaymentSettingBinding();
                    LimitLine.LimitLabelPosition limitLabelPosition = limitLine.BuiltInFictitiousFunctionClassFactory;
                    if (limitLabelPosition == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                        this.BuiltInFictitiousFunctionClassFactory.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(str, this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest() - PlaceComponentResult, (fArr[1] - FragmentBottomSheetPaymentSettingBinding) + authRequestContext2, this.BuiltInFictitiousFunctionClassFactory);
                    } else if (limitLabelPosition == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                        this.BuiltInFictitiousFunctionClassFactory.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(str, this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest() - PlaceComponentResult, fArr[1] + FragmentBottomSheetPaymentSettingBinding, this.BuiltInFictitiousFunctionClassFactory);
                    } else if (limitLabelPosition == LimitLine.LimitLabelPosition.LEFT_TOP) {
                        this.BuiltInFictitiousFunctionClassFactory.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(str, this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl() + PlaceComponentResult, (fArr[1] - FragmentBottomSheetPaymentSettingBinding) + authRequestContext2, this.BuiltInFictitiousFunctionClassFactory);
                    } else {
                        this.BuiltInFictitiousFunctionClassFactory.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(str, this.NetworkUserEntityData$$ExternalSyntheticLambda7.FragmentBottomSheetPaymentSettingBinding() + PlaceComponentResult, fArr[1] + FragmentBottomSheetPaymentSettingBinding, this.BuiltInFictitiousFunctionClassFactory);
                    }
                }
                canvas.restoreToCount(save);
            }
        }
    }
}

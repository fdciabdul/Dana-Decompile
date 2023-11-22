package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* loaded from: classes7.dex */
public class XAxisRendererHorizontalBarChart extends XAxisRenderer {
    protected BarChart DatabaseTableConfigUtil;
    protected Path NetworkUserEntityData$$ExternalSyntheticLambda2;

    public XAxisRendererHorizontalBarChart(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer, BarChart barChart) {
        super(viewPortHandler, xAxis, transformer);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Path();
        this.DatabaseTableConfigUtil = barChart;
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public final void MyBillsEntityDataFactory(float f, float f2, boolean z) {
        double d;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda0() > 10.0f && !this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
            Transformer transformer = this.lookAheadTest;
            float scheduleImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl();
            float BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory();
            MPPointD KClassImpl$Data$declaredNonStaticMembers$2 = MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            transformer.getAuthRequestContext(scheduleImpl, BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2);
            Transformer transformer2 = this.lookAheadTest;
            float scheduleImpl2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl();
            float moveToNextValue = this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue();
            MPPointD KClassImpl$Data$declaredNonStaticMembers$22 = MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            transformer2.getAuthRequestContext(scheduleImpl2, moveToNextValue, KClassImpl$Data$declaredNonStaticMembers$22);
            if (z) {
                f = (float) KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2;
                d = KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
            } else {
                f = (float) KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
                d = KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            f2 = (float) d;
            MPPointD.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((ObjectPool<MPPointD>) KClassImpl$Data$declaredNonStaticMembers$2);
            MPPointD.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((ObjectPool<MPPointD>) KClassImpl$Data$declaredNonStaticMembers$22);
        }
        getAuthRequestContext(f, f2);
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory.setTypeface(this.GetContactSyncConfig.PrepareContext());
        this.MyBillsEntityDataFactory.setTextSize(this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda7());
        FSize PlaceComponentResult = Utils.PlaceComponentResult(this.MyBillsEntityDataFactory, this.GetContactSyncConfig.MyBillsEntityDataFactory());
        float newProxyInstance = (int) (PlaceComponentResult.PlaceComponentResult + (this.GetContactSyncConfig.newProxyInstance() * 3.5f));
        float f = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
        FSize MyBillsEntityDataFactory = Utils.MyBillsEntityDataFactory(PlaceComponentResult.PlaceComponentResult, f, this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda6());
        this.GetContactSyncConfig.getValueOfTouchPositionAbsolute = Math.round(newProxyInstance);
        this.GetContactSyncConfig.getOnBoardingScenario = Math.round(f);
        this.GetContactSyncConfig.E = (int) (MyBillsEntityDataFactory.PlaceComponentResult + (this.GetContactSyncConfig.newProxyInstance() * 3.5f));
        this.GetContactSyncConfig.D = Math.round(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory);
        FSize.MyBillsEntityDataFactory(MyBillsEntityDataFactory);
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public final void getAuthRequestContext(Canvas canvas) {
        if (this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda3() && this.GetContactSyncConfig.lookAheadTest()) {
            float newProxyInstance = this.GetContactSyncConfig.newProxyInstance();
            this.MyBillsEntityDataFactory.setTypeface(this.GetContactSyncConfig.PrepareContext());
            this.MyBillsEntityDataFactory.setTextSize(this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda7());
            this.MyBillsEntityDataFactory.setColor(this.GetContactSyncConfig.isLayoutRequested());
            MPPointF authRequestContext = MPPointF.getAuthRequestContext(0.0f, 0.0f);
            if (this.GetContactSyncConfig.AppCompatEmojiTextHelper == XAxis.XAxisPosition.TOP) {
                authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
                authRequestContext.PlaceComponentResult = 0.5f;
                KClassImpl$Data$declaredNonStaticMembers$2(canvas, this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest() + newProxyInstance, authRequestContext);
            } else if (this.GetContactSyncConfig.AppCompatEmojiTextHelper == XAxis.XAxisPosition.TOP_INSIDE) {
                authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = 1.0f;
                authRequestContext.PlaceComponentResult = 0.5f;
                KClassImpl$Data$declaredNonStaticMembers$2(canvas, this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest() - newProxyInstance, authRequestContext);
            } else if (this.GetContactSyncConfig.AppCompatEmojiTextHelper == XAxis.XAxisPosition.BOTTOM) {
                authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = 1.0f;
                authRequestContext.PlaceComponentResult = 0.5f;
                KClassImpl$Data$declaredNonStaticMembers$2(canvas, this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl() - newProxyInstance, authRequestContext);
            } else if (this.GetContactSyncConfig.AppCompatEmojiTextHelper == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = 1.0f;
                authRequestContext.PlaceComponentResult = 0.5f;
                KClassImpl$Data$declaredNonStaticMembers$2(canvas, this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl() + newProxyInstance, authRequestContext);
            } else {
                authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
                authRequestContext.PlaceComponentResult = 0.5f;
                KClassImpl$Data$declaredNonStaticMembers$2(canvas, this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest() + newProxyInstance, authRequestContext);
                authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = 1.0f;
                authRequestContext.PlaceComponentResult = 0.5f;
                KClassImpl$Data$declaredNonStaticMembers$2(canvas, this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl() - newProxyInstance, authRequestContext);
            }
            MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext);
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(Canvas canvas, float f, MPPointF mPPointF) {
        float NetworkUserEntityData$$ExternalSyntheticLambda6 = this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda6();
        boolean BuiltInFictitiousFunctionClassFactory = this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory();
        int i = this.GetContactSyncConfig.PrepareContext * 2;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2 += 2) {
            if (BuiltInFictitiousFunctionClassFactory) {
                fArr[i2 + 1] = this.GetContactSyncConfig.moveToNextValue[i2 / 2];
            } else {
                fArr[i2 + 1] = this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda8[i2 / 2];
            }
        }
        this.lookAheadTest.PlaceComponentResult(fArr);
        for (int i3 = 0; i3 < i; i3 += 2) {
            float f2 = fArr[i3 + 1];
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.getErrorConfigVersion(f2)) {
                ValueFormatter PlaceComponentResult = this.GetContactSyncConfig.PlaceComponentResult();
                float f3 = this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda8[i3 / 2];
                XAxis xAxis = this.GetContactSyncConfig;
                MyBillsEntityDataFactory(canvas, PlaceComponentResult.MyBillsEntityDataFactory(f3), f, f2, mPPointF, NetworkUserEntityData$$ExternalSyntheticLambda6);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public final RectF BuiltInFictitiousFunctionClassFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.set(this.NetworkUserEntityData$$ExternalSyntheticLambda7.GetContactSyncConfig());
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.inset(0.0f, -this.getAuthRequestContext.FragmentBottomSheetPaymentSettingBinding);
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected final void PlaceComponentResult(Canvas canvas, float f, float f2, Path path) {
        path.moveTo(this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest(), f2);
        path.lineTo(this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl(), f2);
        canvas.drawPath(path, this.PlaceComponentResult);
        path.reset();
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public final void BuiltInFictitiousFunctionClassFactory(Canvas canvas) {
        if (this.GetContactSyncConfig.scheduleImpl() && this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setColor(this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2);
            this.KClassImpl$Data$declaredNonStaticMembers$2.setStrokeWidth(this.GetContactSyncConfig.PlaceComponentResult);
            if (this.GetContactSyncConfig.AppCompatEmojiTextHelper == XAxis.XAxisPosition.TOP || this.GetContactSyncConfig.AppCompatEmojiTextHelper == XAxis.XAxisPosition.TOP_INSIDE || this.GetContactSyncConfig.AppCompatEmojiTextHelper == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory(), this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (this.GetContactSyncConfig.AppCompatEmojiTextHelper == XAxis.XAxisPosition.BOTTOM || this.GetContactSyncConfig.AppCompatEmojiTextHelper == XAxis.XAxisPosition.BOTTOM_INSIDE || this.GetContactSyncConfig.AppCompatEmojiTextHelper == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory(), this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public final void PlaceComponentResult(Canvas canvas) {
        List<LimitLine> authRequestContext = this.GetContactSyncConfig.getAuthRequestContext();
        if (authRequestContext == null || authRequestContext.size() <= 0) {
            return;
        }
        float[] fArr = this.initRecordTimeStamp;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        Path path = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        path.reset();
        for (int i = 0; i < authRequestContext.size(); i++) {
            LimitLine limitLine = authRequestContext.get(i);
            if (limitLine.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
                int save = canvas.save();
                this.getErrorConfigVersion.set(this.NetworkUserEntityData$$ExternalSyntheticLambda7.GetContactSyncConfig());
                this.getErrorConfigVersion.inset(0.0f, -limitLine.lookAheadTest);
                canvas.clipRect(this.getErrorConfigVersion);
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

package com.github.mikephil.charting.renderer;

import android.graphics.Paint;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes3.dex */
public abstract class AxisRenderer extends Renderer {
    protected Paint BuiltInFictitiousFunctionClassFactory;
    protected Paint KClassImpl$Data$declaredNonStaticMembers$2;
    protected Paint MyBillsEntityDataFactory;
    protected Paint PlaceComponentResult;
    protected AxisBase getAuthRequestContext;
    protected Transformer lookAheadTest;

    public AxisRenderer(ViewPortHandler viewPortHandler, Transformer transformer, AxisBase axisBase) {
        super(viewPortHandler);
        this.lookAheadTest = transformer;
        this.getAuthRequestContext = axisBase;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 != null) {
            this.MyBillsEntityDataFactory = new Paint(1);
            Paint paint = new Paint();
            this.PlaceComponentResult = paint;
            paint.setColor(-7829368);
            this.PlaceComponentResult.setStrokeWidth(1.0f);
            this.PlaceComponentResult.setStyle(Paint.Style.STROKE);
            this.PlaceComponentResult.setAlpha(90);
            Paint paint2 = new Paint();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = paint2;
            paint2.setColor(-16777216);
            this.KClassImpl$Data$declaredNonStaticMembers$2.setStrokeWidth(1.0f);
            this.KClassImpl$Data$declaredNonStaticMembers$2.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint(1);
            this.BuiltInFictitiousFunctionClassFactory = paint3;
            paint3.setStyle(Paint.Style.STROKE);
        }
    }

    public final Paint PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }

    public void MyBillsEntityDataFactory(float f, float f2, boolean z) {
        double d;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 != null && this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda0() > 10.0f && !this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
            Transformer transformer = this.lookAheadTest;
            float scheduleImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl();
            float moveToNextValue = this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue();
            MPPointD KClassImpl$Data$declaredNonStaticMembers$2 = MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            transformer.getAuthRequestContext(scheduleImpl, moveToNextValue, KClassImpl$Data$declaredNonStaticMembers$2);
            Transformer transformer2 = this.lookAheadTest;
            float scheduleImpl2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl();
            float BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory();
            MPPointD KClassImpl$Data$declaredNonStaticMembers$22 = MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            transformer2.getAuthRequestContext(scheduleImpl2, BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$22);
            if (!z) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    public void getAuthRequestContext(float f, float f2) {
        double ceil;
        double MyBillsEntityDataFactory;
        float f3 = f;
        int i = this.getAuthRequestContext.SubSequence;
        double abs = Math.abs(f2 - f3);
        if (i == 0 || abs <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || Double.isInfinite(abs)) {
            this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8 = new float[0];
            this.getAuthRequestContext.moveToNextValue = new float[0];
            this.getAuthRequestContext.PrepareContext = 0;
            return;
        }
        double d = i;
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
        int BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
        if (this.getAuthRequestContext.DatabaseTableConfigUtil()) {
            KClassImpl$Data$declaredNonStaticMembers$2 = ((float) abs) / ((float) (i - 1));
            this.getAuthRequestContext.PrepareContext = i;
            if (this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8.length < i) {
                this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8 = new float[i];
            }
            for (int i2 = 0; i2 < i; i2++) {
                this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8[i2] = f3;
                double d2 = f3;
                Double.isNaN(d2);
                Double.isNaN(KClassImpl$Data$declaredNonStaticMembers$2);
                f3 = (float) (d2 + KClassImpl$Data$declaredNonStaticMembers$2);
            }
        } else {
            if (KClassImpl$Data$declaredNonStaticMembers$2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                ceil = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            } else {
                double d3 = f3;
                Double.isNaN(d3);
                ceil = Math.ceil(d3 / KClassImpl$Data$declaredNonStaticMembers$2) * KClassImpl$Data$declaredNonStaticMembers$2;
            }
            if (this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory()) {
                ceil -= KClassImpl$Data$declaredNonStaticMembers$2;
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                MyBillsEntityDataFactory = 0.0d;
            } else {
                double d4 = f2;
                Double.isNaN(d4);
                MyBillsEntityDataFactory = Utils.MyBillsEntityDataFactory(Math.floor(d4 / KClassImpl$Data$declaredNonStaticMembers$2) * KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d5 = ceil;
                BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
                while (d5 <= MyBillsEntityDataFactory) {
                    d5 += KClassImpl$Data$declaredNonStaticMembers$2;
                    BuiltInFictitiousFunctionClassFactory++;
                }
            }
            this.getAuthRequestContext.PrepareContext = BuiltInFictitiousFunctionClassFactory;
            if (this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8.length < BuiltInFictitiousFunctionClassFactory) {
                this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8 = new float[BuiltInFictitiousFunctionClassFactory];
            }
            for (int i3 = 0; i3 < BuiltInFictitiousFunctionClassFactory; i3++) {
                if (ceil == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    ceil = 0.0d;
                }
                this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8[i3] = (float) ceil;
                ceil += KClassImpl$Data$declaredNonStaticMembers$2;
            }
            i = BuiltInFictitiousFunctionClassFactory;
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2 < 1.0d) {
            this.getAuthRequestContext.GetContactSyncConfig = (int) Math.ceil(-Math.log10(KClassImpl$Data$declaredNonStaticMembers$2));
        } else {
            this.getAuthRequestContext.GetContactSyncConfig = 0;
        }
        if (this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory()) {
            if (this.getAuthRequestContext.moveToNextValue.length < i) {
                this.getAuthRequestContext.moveToNextValue = new float[i];
            }
            float f4 = ((float) KClassImpl$Data$declaredNonStaticMembers$2) / 2.0f;
            for (int i4 = 0; i4 < i; i4++) {
                this.getAuthRequestContext.moveToNextValue[i4] = this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8[i4] + f4;
            }
        }
    }
}

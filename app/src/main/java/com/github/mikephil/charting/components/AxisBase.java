package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class AxisBase extends ComponentBase {
    public int GetContactSyncConfig;
    public int PrepareContext;
    protected ValueFormatter getErrorConfigVersion;
    protected List<LimitLine> readMicros;
    public int NetworkUserEntityData$$ExternalSyntheticLambda5 = -7829368;
    public float FragmentBottomSheetPaymentSettingBinding = 1.0f;
    public int KClassImpl$Data$declaredNonStaticMembers$2 = -7829368;
    public float PlaceComponentResult = 1.0f;
    public float[] NetworkUserEntityData$$ExternalSyntheticLambda8 = new float[0];
    public float[] moveToNextValue = new float[0];
    public int SubSequence = 6;
    protected float NetworkUserEntityData$$ExternalSyntheticLambda6 = 1.0f;
    protected boolean NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
    protected boolean NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
    protected boolean initRecordTimeStamp = true;
    protected boolean DatabaseTableConfigUtil = true;
    protected boolean isLayoutRequested = true;
    protected boolean scheduleImpl = false;
    public DashPathEffect getAuthRequestContext = null;
    public DashPathEffect NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
    protected boolean newProxyInstance = false;
    protected boolean NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
    protected float getCallingPid = 0.0f;
    protected float getSupportButtonTintMode = 0.0f;
    protected boolean NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
    protected boolean lookAheadTest = false;
    public float BuiltInFictitiousFunctionClassFactory = 0.0f;
    public float MyBillsEntityDataFactory = 0.0f;
    public float NetworkUserEntityData$$ExternalSyntheticLambda0 = 0.0f;

    public AxisBase() {
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = Utils.PlaceComponentResult(10.0f);
        this.C = Utils.PlaceComponentResult(5.0f);
        this.B = Utils.PlaceComponentResult(5.0f);
        this.readMicros = new ArrayList();
    }

    public final void getAuthRequestContext(boolean z) {
        this.initRecordTimeStamp = z;
    }

    public final boolean moveToNextValue() {
        return this.initRecordTimeStamp;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        this.DatabaseTableConfigUtil = false;
    }

    public final boolean scheduleImpl() {
        return this.DatabaseTableConfigUtil;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.scheduleImpl && this.PrepareContext > 0;
    }

    public final void PlaceComponentResult(boolean z) {
        this.isLayoutRequested = z;
    }

    public final boolean lookAheadTest() {
        return this.isLayoutRequested;
    }

    public final boolean DatabaseTableConfigUtil() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda4;
    }

    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6;
    }

    public final List<LimitLine> getAuthRequestContext() {
        return this.readMicros;
    }

    public final boolean getErrorConfigVersion() {
        return this.newProxyInstance;
    }

    public final void GetContactSyncConfig() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public final String MyBillsEntityDataFactory() {
        int i = 0;
        String str = "";
        while (true) {
            float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            if (i >= fArr.length) {
                return str;
            }
            String MyBillsEntityDataFactory = (i < 0 || i >= fArr.length) ? "" : PlaceComponentResult().MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8[i]);
            if (MyBillsEntityDataFactory != null && str.length() < MyBillsEntityDataFactory.length()) {
                str = MyBillsEntityDataFactory;
            }
            i++;
        }
    }

    public final String getAuthRequestContext(int i) {
        return (i < 0 || i >= this.NetworkUserEntityData$$ExternalSyntheticLambda8.length) ? "" : PlaceComponentResult().MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8[i]);
    }

    public final void PlaceComponentResult(ValueFormatter valueFormatter) {
        this.getErrorConfigVersion = valueFormatter;
    }

    public final ValueFormatter PlaceComponentResult() {
        ValueFormatter valueFormatter = this.getErrorConfigVersion;
        if (valueFormatter == null || ((valueFormatter instanceof DefaultAxisValueFormatter) && ((DefaultAxisValueFormatter) valueFormatter).MyBillsEntityDataFactory() != this.GetContactSyncConfig)) {
            this.getErrorConfigVersion = new DefaultAxisValueFormatter(this.GetContactSyncConfig);
        }
        return this.getErrorConfigVersion;
    }

    public final void PlaceComponentResult(float f) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        this.MyBillsEntityDataFactory = f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Math.abs(this.BuiltInFictitiousFunctionClassFactory - f);
    }

    public final void BuiltInFictitiousFunctionClassFactory(float f) {
        this.lookAheadTest = true;
        this.BuiltInFictitiousFunctionClassFactory = f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Math.abs(f - this.MyBillsEntityDataFactory);
    }

    public void getAuthRequestContext(float f, float f2) {
        float f3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1 ? this.MyBillsEntityDataFactory : f - this.getCallingPid;
        float f4 = this.lookAheadTest ? this.BuiltInFictitiousFunctionClassFactory : f2 + this.getSupportButtonTintMode;
        if (Math.abs(f4 - f3) == 0.0f) {
            f4 += 1.0f;
            f3 -= 1.0f;
        }
        this.MyBillsEntityDataFactory = f3;
        this.BuiltInFictitiousFunctionClassFactory = f4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Math.abs(f4 - f3);
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        this.getCallingPid = 0.5f;
    }

    public final void initRecordTimeStamp() {
        this.getSupportButtonTintMode = 0.5f;
    }

    public final void BuiltInFictitiousFunctionClassFactory(int i, boolean z) {
        if (i > 25) {
            i = 25;
        }
        if (i < 2) {
            i = 2;
        }
        this.SubSequence = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = z;
    }
}

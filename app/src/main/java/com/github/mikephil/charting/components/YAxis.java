package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes3.dex */
public class YAxis extends AxisBase {
    protected float AppCompatEmojiTextHelper;
    protected float D;
    public boolean E;
    protected int F;
    protected float G;
    public YAxisLabelPosition H;
    protected float I;
    private boolean J;
    protected float K;
    private boolean L;
    protected boolean VerifyPinStateManager$executeRiskChallenge$2$2;
    private boolean getNameOrBuilderList;
    public AxisDependency getOnBoardingScenario;
    protected boolean getValueOfTouchPositionAbsolute;

    /* loaded from: classes3.dex */
    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    /* loaded from: classes3.dex */
    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public YAxis() {
        this.getNameOrBuilderList = true;
        this.E = true;
        this.getValueOfTouchPositionAbsolute = false;
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = false;
        this.L = false;
        this.J = false;
        this.F = -7829368;
        this.K = 1.0f;
        this.G = 10.0f;
        this.AppCompatEmojiTextHelper = 10.0f;
        this.H = YAxisLabelPosition.OUTSIDE_CHART;
        this.I = 0.0f;
        this.D = Float.POSITIVE_INFINITY;
        this.getOnBoardingScenario = AxisDependency.LEFT;
        this.B = 0.0f;
    }

    public YAxis(AxisDependency axisDependency) {
        this.getNameOrBuilderList = true;
        this.E = true;
        this.getValueOfTouchPositionAbsolute = false;
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = false;
        this.L = false;
        this.J = false;
        this.F = -7829368;
        this.K = 1.0f;
        this.G = 10.0f;
        this.AppCompatEmojiTextHelper = 10.0f;
        this.H = YAxisLabelPosition.OUTSIDE_CHART;
        this.I = 0.0f;
        this.D = Float.POSITIVE_INFINITY;
        this.getOnBoardingScenario = axisDependency;
        this.B = 0.0f;
    }

    public final boolean SubSequence() {
        return this.E;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda4() {
        return this.getNameOrBuilderList;
    }

    public final boolean whenAvailable() {
        return this.getValueOfTouchPositionAbsolute;
    }

    public final boolean getCallingPid() {
        return this.VerifyPinStateManager$executeRiskChallenge$2$2;
    }

    public final void readMicros() {
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = false;
    }

    public final int NetworkUserEntityData$$ExternalSyntheticLambda6() {
        return this.F;
    }

    public final float NetworkUserEntityData$$ExternalSyntheticLambda5() {
        return this.K;
    }

    public final float PlaceComponentResult(Paint paint) {
        paint.setTextSize(this.VerifyPinStateManager$executeRiskChallenge$2$1);
        float MyBillsEntityDataFactory = Utils.MyBillsEntityDataFactory(paint, MyBillsEntityDataFactory()) + (newProxyInstance() * 2.0f);
        float f = this.I;
        float f2 = this.D;
        if (f > 0.0f) {
            f = Utils.PlaceComponentResult(f);
        }
        if (f2 > 0.0f && f2 != Float.POSITIVE_INFINITY) {
            f2 = Utils.PlaceComponentResult(f2);
        }
        if (f2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            f2 = MyBillsEntityDataFactory;
        }
        return Math.max(f, Math.min(MyBillsEntityDataFactory, f2));
    }

    public final float MyBillsEntityDataFactory(Paint paint) {
        paint.setTextSize(this.VerifyPinStateManager$executeRiskChallenge$2$1);
        return Utils.getAuthRequestContext(paint, MyBillsEntityDataFactory()) + (FragmentBottomSheetPaymentSettingBinding() * 2.0f);
    }

    public final boolean getSupportButtonTintMode() {
        return NetworkUserEntityData$$ExternalSyntheticLambda3() && lookAheadTest() && this.H == YAxisLabelPosition.OUTSIDE_CHART;
    }

    @Override // com.github.mikephil.charting.components.AxisBase
    public final void getAuthRequestContext(float f, float f2) {
        if (Math.abs(f2 - f) == 0.0f) {
            f2 += 1.0f;
            f -= 1.0f;
        }
        float abs = Math.abs(f2 - f);
        this.MyBillsEntityDataFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda1 ? this.MyBillsEntityDataFactory : f - ((abs / 100.0f) * this.AppCompatEmojiTextHelper);
        this.BuiltInFictitiousFunctionClassFactory = this.lookAheadTest ? this.BuiltInFictitiousFunctionClassFactory : f2 + ((abs / 100.0f) * this.G);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Math.abs(this.MyBillsEntityDataFactory - this.BuiltInFictitiousFunctionClassFactory);
    }
}

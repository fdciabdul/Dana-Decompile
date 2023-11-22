package com.github.mikephil.charting.components;

import android.graphics.Typeface;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes3.dex */
public abstract class ComponentBase {
    protected boolean whenAvailable = true;
    protected float C = 5.0f;
    protected float B = 5.0f;
    protected Typeface A = null;
    protected float VerifyPinStateManager$executeRiskChallenge$2$1 = Utils.PlaceComponentResult(10.0f);
    protected int BottomSheetCardBindingView$watcherCardNumberView$1 = -16777216;

    public final float newProxyInstance() {
        return this.C;
    }

    public final float FragmentBottomSheetPaymentSettingBinding() {
        return this.B;
    }

    public final void MyBillsEntityDataFactory(float f) {
        this.B = Utils.PlaceComponentResult(f);
    }

    public final Typeface PrepareContext() {
        return this.A;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        if (f > 24.0f) {
            f = 24.0f;
        }
        if (f < 6.0f) {
            f = 6.0f;
        }
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = Utils.PlaceComponentResult(f);
    }

    public final float NetworkUserEntityData$$ExternalSyntheticLambda7() {
        return this.VerifyPinStateManager$executeRiskChallenge$2$1;
    }

    public final void PlaceComponentResult(int i) {
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = i;
    }

    public final int isLayoutRequested() {
        return this.BottomSheetCardBindingView$watcherCardNumberView$1;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.whenAvailable = z;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda3() {
        return this.whenAvailable;
    }
}

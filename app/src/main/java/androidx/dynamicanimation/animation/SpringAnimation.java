package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes3.dex */
public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda3;
    private float NetworkUserEntityData$$ExternalSyntheticLambda4;
    public SpringForce NetworkUserEntityData$$ExternalSyntheticLambda6;

    public <K> SpringAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k, floatPropertyCompat);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = Float.MAX_VALUE;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = false;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public final void getAuthRequestContext() {
        PlaceComponentResult();
        SpringForce springForce = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        double abs = Math.abs(MyBillsEntityDataFactory());
        springForce.KClassImpl$Data$declaredNonStaticMembers$2 = abs;
        springForce.NetworkUserEntityData$$ExternalSyntheticLambda0 = abs * 62.5d;
        super.getAuthRequestContext();
    }

    public final void PlaceComponentResult(float f) {
        if (BuiltInFictitiousFunctionClassFactory()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = f;
            return;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda6 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new SpringForce(f);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.PlaceComponentResult = f;
        PlaceComponentResult();
        SpringForce springForce = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        double abs = Math.abs(MyBillsEntityDataFactory());
        springForce.KClassImpl$Data$declaredNonStaticMembers$2 = abs;
        springForce.NetworkUserEntityData$$ExternalSyntheticLambda0 = abs * 62.5d;
        super.getAuthRequestContext();
    }

    private void PlaceComponentResult() {
        SpringForce springForce = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (springForce == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double d = (float) springForce.PlaceComponentResult;
        if (d > this.GetContactSyncConfig) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (d < this.newProxyInstance) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    final boolean MyBillsEntityDataFactory(long j) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda3) {
            float f = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (f != Float.MAX_VALUE) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda6.PlaceComponentResult = f;
                this.NetworkUserEntityData$$ExternalSyntheticLambda4 = Float.MAX_VALUE;
            }
            this.FragmentBottomSheetPaymentSettingBinding = (float) this.NetworkUserEntityData$$ExternalSyntheticLambda6.PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = 0.0f;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = false;
            return true;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda4 == Float.MAX_VALUE) {
            DynamicAnimation.MassState authRequestContext = this.NetworkUserEntityData$$ExternalSyntheticLambda6.getAuthRequestContext(this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda5, j);
            this.FragmentBottomSheetPaymentSettingBinding = authRequestContext.PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = authRequestContext.getAuthRequestContext;
        } else {
            double d = this.NetworkUserEntityData$$ExternalSyntheticLambda6.PlaceComponentResult;
            long j2 = j / 2;
            DynamicAnimation.MassState authRequestContext2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6.getAuthRequestContext(this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda5, j2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6.PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = Float.MAX_VALUE;
            DynamicAnimation.MassState authRequestContext3 = this.NetworkUserEntityData$$ExternalSyntheticLambda6.getAuthRequestContext(authRequestContext2.PlaceComponentResult, authRequestContext2.getAuthRequestContext, j2);
            this.FragmentBottomSheetPaymentSettingBinding = authRequestContext3.PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = authRequestContext3.getAuthRequestContext;
        }
        this.FragmentBottomSheetPaymentSettingBinding = Math.max(this.FragmentBottomSheetPaymentSettingBinding, this.newProxyInstance);
        this.FragmentBottomSheetPaymentSettingBinding = Math.min(this.FragmentBottomSheetPaymentSettingBinding, this.GetContactSyncConfig);
        if (getAuthRequestContext(this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda5)) {
            this.FragmentBottomSheetPaymentSettingBinding = (float) this.NetworkUserEntityData$$ExternalSyntheticLambda6.PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = 0.0f;
            return true;
        }
        return false;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    final boolean getAuthRequestContext(float f, float f2) {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6.getAuthRequestContext(f, f2);
    }
}

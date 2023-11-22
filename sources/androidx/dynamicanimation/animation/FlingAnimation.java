package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes6.dex */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce NetworkUserEntityData$$ExternalSyntheticLambda6;

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    final boolean MyBillsEntityDataFactory(long j) {
        DragForce dragForce = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        float f = this.FragmentBottomSheetPaymentSettingBinding;
        float f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        DynamicAnimation.MassState massState = dragForce.getAuthRequestContext;
        double d = f2;
        float f3 = (float) j;
        double exp = Math.exp((f3 / 1000.0f) * dragForce.MyBillsEntityDataFactory);
        Double.isNaN(d);
        massState.getAuthRequestContext = (float) (d * exp);
        DynamicAnimation.MassState massState2 = dragForce.getAuthRequestContext;
        float f4 = f2 / dragForce.MyBillsEntityDataFactory;
        double d2 = f - f4;
        double d3 = f4;
        double exp2 = Math.exp((r4 * f3) / 1000.0f);
        Double.isNaN(d3);
        Double.isNaN(d2);
        massState2.PlaceComponentResult = (float) (d2 + (d3 * exp2));
        float f5 = dragForce.getAuthRequestContext.PlaceComponentResult;
        if (dragForce.BuiltInFictitiousFunctionClassFactory(dragForce.getAuthRequestContext.getAuthRequestContext)) {
            dragForce.getAuthRequestContext.getAuthRequestContext = 0.0f;
        }
        DynamicAnimation.MassState massState3 = dragForce.getAuthRequestContext;
        this.FragmentBottomSheetPaymentSettingBinding = massState3.PlaceComponentResult;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = massState3.getAuthRequestContext;
        if (this.FragmentBottomSheetPaymentSettingBinding < this.newProxyInstance) {
            this.FragmentBottomSheetPaymentSettingBinding = this.newProxyInstance;
            return true;
        } else if (this.FragmentBottomSheetPaymentSettingBinding <= this.GetContactSyncConfig) {
            return getAuthRequestContext(this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        } else {
            this.FragmentBottomSheetPaymentSettingBinding = this.GetContactSyncConfig;
            return true;
        }
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    final boolean getAuthRequestContext(float f, float f2) {
        return f >= this.GetContactSyncConfig || f <= this.newProxyInstance || this.NetworkUserEntityData$$ExternalSyntheticLambda6.BuiltInFictitiousFunctionClassFactory(f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class DragForce implements Force {
        private float KClassImpl$Data$declaredNonStaticMembers$2;
        float MyBillsEntityDataFactory = -4.2f;
        final DynamicAnimation.MassState getAuthRequestContext = new DynamicAnimation.MassState();

        DragForce() {
        }

        public final boolean BuiltInFictitiousFunctionClassFactory(float f) {
            return Math.abs(f) < this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public final /* bridge */ /* synthetic */ FlingAnimation MyBillsEntityDataFactory(float f) {
        super.MyBillsEntityDataFactory(f);
        return this;
    }
}

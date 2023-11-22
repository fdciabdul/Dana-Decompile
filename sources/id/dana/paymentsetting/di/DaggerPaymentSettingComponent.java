package id.dana.paymentsetting.di;

import android.content.Context;
import dagger.internal.Preconditions;
import id.dana.di.component.ApplicationComponent;
import id.dana.paymentsetting.BottomSheetPaymentSettingFragment;
import id.dana.paymentsetting.BottomSheetPaymentSettingFragment_MembersInjector;

/* loaded from: classes5.dex */
public final class DaggerPaymentSettingComponent {
    private DaggerPaymentSettingComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public PaymentSettingAnalyticModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class PaymentSettingComponentImpl implements PaymentSettingComponent {
        private final PaymentSettingComponentImpl BuiltInFictitiousFunctionClassFactory;
        private final PaymentSettingAnalyticModule KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent getAuthRequestContext;

        public /* synthetic */ PaymentSettingComponentImpl(PaymentSettingAnalyticModule paymentSettingAnalyticModule, ApplicationComponent applicationComponent, byte b) {
            this(paymentSettingAnalyticModule, applicationComponent);
        }

        private PaymentSettingComponentImpl(PaymentSettingAnalyticModule paymentSettingAnalyticModule, ApplicationComponent applicationComponent) {
            this.BuiltInFictitiousFunctionClassFactory = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = paymentSettingAnalyticModule;
            this.getAuthRequestContext = applicationComponent;
        }

        @Override // id.dana.paymentsetting.di.PaymentSettingComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(BottomSheetPaymentSettingFragment bottomSheetPaymentSettingFragment) {
            BottomSheetPaymentSettingFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(bottomSheetPaymentSettingFragment, PaymentSettingAnalyticModule_ProvidePaymentSettingAnalyticTracker$app_productionReleaseFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, (Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue())));
        }
    }
}

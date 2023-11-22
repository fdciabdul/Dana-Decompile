package id.dana.paymentsetting.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.paymentsetting.tracker.PaymentSettingAnalyticalTracker;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PaymentSettingAnalyticModule_ProvidePaymentSettingAnalyticTracker$app_productionReleaseFactory implements Factory<PaymentSettingAnalyticalTracker> {
    private final PaymentSettingAnalyticModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> getAuthRequestContext;

    public static PaymentSettingAnalyticalTracker MyBillsEntityDataFactory(PaymentSettingAnalyticModule paymentSettingAnalyticModule, Context context) {
        return (PaymentSettingAnalyticalTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(paymentSettingAnalyticModule.KClassImpl$Data$declaredNonStaticMembers$2(context));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PaymentSettingAnalyticalTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}

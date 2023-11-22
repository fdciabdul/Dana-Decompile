package id.dana.data.paymentsetting.repository.source.session;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PaymentSettingPreference_Factory implements Factory<PaymentSettingPreference> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Serializer> PlaceComponentResult;

    private PaymentSettingPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.PlaceComponentResult = provider2;
    }

    public static PaymentSettingPreference_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<Serializer> provider2) {
        return new PaymentSettingPreference_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PaymentSettingPreference(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}

package id.dana.data.kycrenewal.repository.source;

import dagger.internal.Factory;
import id.dana.data.kycrenewal.repository.source.session.KycRenewalPreference;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class KycRenewalPreferenceEntityDataFactory_Factory implements Factory<KycRenewalPreferenceEntityDataFactory> {
    private final Provider<KycRenewalPreference> KClassImpl$Data$declaredNonStaticMembers$2;

    private KycRenewalPreferenceEntityDataFactory_Factory(Provider<KycRenewalPreference> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static KycRenewalPreferenceEntityDataFactory_Factory PlaceComponentResult(Provider<KycRenewalPreference> provider) {
        return new KycRenewalPreferenceEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KycRenewalPreferenceEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

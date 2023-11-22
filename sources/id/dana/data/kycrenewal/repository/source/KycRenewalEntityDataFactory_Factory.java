package id.dana.data.kycrenewal.repository.source;

import dagger.internal.Factory;
import id.dana.data.kycrenewal.repository.source.network.NetworkKycRenewalEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class KycRenewalEntityDataFactory_Factory implements Factory<KycRenewalEntityDataFactory> {
    private final Provider<NetworkKycRenewalEntityData> KClassImpl$Data$declaredNonStaticMembers$2;

    private KycRenewalEntityDataFactory_Factory(Provider<NetworkKycRenewalEntityData> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static KycRenewalEntityDataFactory_Factory MyBillsEntityDataFactory(Provider<NetworkKycRenewalEntityData> provider) {
        return new KycRenewalEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KycRenewalEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

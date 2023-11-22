package id.dana.data.kycrenewal.repository.source.session;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class KycRenewalPreference_Factory implements Factory<KycRenewalPreference> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Serializer> getAuthRequestContext;

    private KycRenewalPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
    }

    public static KycRenewalPreference_Factory getAuthRequestContext(Provider<Context> provider, Provider<Serializer> provider2) {
        return new KycRenewalPreference_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KycRenewalPreference(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}

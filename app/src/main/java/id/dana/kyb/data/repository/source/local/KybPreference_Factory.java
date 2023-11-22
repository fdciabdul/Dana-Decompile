package id.dana.kyb.data.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class KybPreference_Factory implements Factory<KybPreference> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Serializer> getAuthRequestContext;

    private KybPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
    }

    public static KybPreference_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<Serializer> provider2) {
        return new KybPreference_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KybPreference(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}

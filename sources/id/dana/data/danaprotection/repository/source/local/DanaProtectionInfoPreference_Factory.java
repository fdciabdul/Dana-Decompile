package id.dana.data.danaprotection.repository.source.local;

import android.content.Context;
import com.google.gson.Gson;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DanaProtectionInfoPreference_Factory implements Factory<DanaProtectionInfoPreference> {
    private final Provider<Gson> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Serializer> getAuthRequestContext;

    private DanaProtectionInfoPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2, Provider<Gson> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static DanaProtectionInfoPreference_Factory getAuthRequestContext(Provider<Context> provider, Provider<Serializer> provider2, Provider<Gson> provider3) {
        return new DanaProtectionInfoPreference_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaProtectionInfoPreference(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

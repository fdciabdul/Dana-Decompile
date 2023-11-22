package id.dana.data.version;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class StorageVersionPreference_Factory implements Factory<StorageVersionPreference> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Serializer> KClassImpl$Data$declaredNonStaticMembers$2;

    private StorageVersionPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static StorageVersionPreference_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<Serializer> provider2) {
        return new StorageVersionPreference_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new StorageVersionPreference(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

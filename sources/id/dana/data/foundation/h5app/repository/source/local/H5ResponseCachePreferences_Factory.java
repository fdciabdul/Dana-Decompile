package id.dana.data.foundation.h5app.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class H5ResponseCachePreferences_Factory implements Factory<H5ResponseCachePreferences> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Serializer> PlaceComponentResult;

    private H5ResponseCachePreferences_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static H5ResponseCachePreferences_Factory PlaceComponentResult(Provider<Context> provider, Provider<Serializer> provider2) {
        return new H5ResponseCachePreferences_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new H5ResponseCachePreferences(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}

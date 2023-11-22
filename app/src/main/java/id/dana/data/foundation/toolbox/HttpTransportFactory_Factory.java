package id.dana.data.foundation.toolbox;

import dagger.internal.Factory;
import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes2.dex */
public final class HttpTransportFactory_Factory implements Factory<HttpTransportFactory> {
    private final Provider<OkHttpClient> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SharedPrefStartupConfig> PlaceComponentResult;

    private HttpTransportFactory_Factory(Provider<OkHttpClient> provider, Provider<SharedPrefStartupConfig> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static HttpTransportFactory_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<OkHttpClient> provider, Provider<SharedPrefStartupConfig> provider2) {
        return new HttpTransportFactory_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HttpTransportFactory(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}

package id.dana.data.network;

import dagger.internal.Factory;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes2.dex */
public final class OkHttpSSLPinningManager_Factory implements Factory<OkHttpSSLPinningManager> {
    private final Provider<OkHttpClient> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<OkHttpClient> PlaceComponentResult;
    private final Provider<OkHttpClient> getAuthRequestContext;

    private OkHttpSSLPinningManager_Factory(Provider<OkHttpClient> provider, Provider<OkHttpClient> provider2, Provider<OkHttpClient> provider3) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
    }

    public static OkHttpSSLPinningManager_Factory getAuthRequestContext(Provider<OkHttpClient> provider, Provider<OkHttpClient> provider2, Provider<OkHttpClient> provider3) {
        return new OkHttpSSLPinningManager_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OkHttpSSLPinningManager(this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

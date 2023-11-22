package id.dana.data.network.interceptor;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkAvailabilityInterceptor_Factory implements Factory<NetworkAvailabilityInterceptor> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;

    private NetworkAvailabilityInterceptor_Factory(Provider<Context> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static NetworkAvailabilityInterceptor_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider) {
        return new NetworkAvailabilityInterceptor_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkAvailabilityInterceptor(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

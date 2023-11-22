package id.dana.data.network.interceptor;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DanaLoggingInterceptor_Factory implements Factory<DanaLoggingInterceptor> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;

    private DanaLoggingInterceptor_Factory(Provider<Context> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static DanaLoggingInterceptor_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider) {
        return new DanaLoggingInterceptor_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaLoggingInterceptor(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

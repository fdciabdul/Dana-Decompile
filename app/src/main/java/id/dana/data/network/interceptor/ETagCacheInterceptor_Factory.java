package id.dana.data.network.interceptor;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ETagCacheInterceptor_Factory implements Factory<ETagCacheInterceptor> {
    public static ETagCacheInterceptor_Factory PlaceComponentResult() {
        return InstanceHolder.PlaceComponentResult;
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final ETagCacheInterceptor_Factory PlaceComponentResult = new ETagCacheInterceptor_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ETagCacheInterceptor();
    }
}

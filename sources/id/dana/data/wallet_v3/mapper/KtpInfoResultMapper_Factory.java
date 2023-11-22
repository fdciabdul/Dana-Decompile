package id.dana.data.wallet_v3.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class KtpInfoResultMapper_Factory implements Factory<KtpInfoResultMapper> {
    @Override // javax.inject.Provider
    public final KtpInfoResultMapper get() {
        return newInstance();
    }

    public static KtpInfoResultMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static KtpInfoResultMapper newInstance() {
        return new KtpInfoResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final KtpInfoResultMapper_Factory getAuthRequestContext = new KtpInfoResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}

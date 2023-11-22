package id.dana.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class PayMethodRiskMapper_Factory implements Factory<PayMethodRiskMapper> {
    public static PayMethodRiskMapper_Factory getAuthRequestContext() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final PayMethodRiskMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new PayMethodRiskMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PayMethodRiskMapper();
    }
}

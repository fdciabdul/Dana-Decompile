package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class PayMethodRiskResultMapper_Factory implements Factory<PayMethodRiskResultMapper> {
    @Override // javax.inject.Provider
    public final PayMethodRiskResultMapper get() {
        return newInstance();
    }

    public static PayMethodRiskResultMapper_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static PayMethodRiskResultMapper newInstance() {
        return new PayMethodRiskResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final PayMethodRiskResultMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new PayMethodRiskResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}

package id.dana.data.referralconfig.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ReferralConfigEntityMapper_Factory implements Factory<ReferralConfigEntityMapper> {
    @Override // javax.inject.Provider
    public final ReferralConfigEntityMapper get() {
        return newInstance();
    }

    public static ReferralConfigEntityMapper_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static ReferralConfigEntityMapper newInstance() {
        return new ReferralConfigEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final ReferralConfigEntityMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new ReferralConfigEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}

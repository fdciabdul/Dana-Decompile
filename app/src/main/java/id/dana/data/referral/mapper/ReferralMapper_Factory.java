package id.dana.data.referral.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ReferralMapper_Factory implements Factory<ReferralMapper> {
    @Override // javax.inject.Provider
    public final ReferralMapper get() {
        return newInstance();
    }

    public static ReferralMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static ReferralMapper newInstance() {
        return new ReferralMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final ReferralMapper_Factory getAuthRequestContext = new ReferralMapper_Factory();

        private InstanceHolder() {
        }
    }
}

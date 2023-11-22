package id.dana.data.referraltracker.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ReferralTrackerResultMapper_Factory implements Factory<ReferralTrackerResultMapper> {
    @Override // javax.inject.Provider
    public final ReferralTrackerResultMapper get() {
        return newInstance();
    }

    public static ReferralTrackerResultMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static ReferralTrackerResultMapper newInstance() {
        return new ReferralTrackerResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final ReferralTrackerResultMapper_Factory MyBillsEntityDataFactory = new ReferralTrackerResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}

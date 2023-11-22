package id.dana.data.referraltracker.source.mock;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class MockReferralTrackerEntityData_Factory implements Factory<MockReferralTrackerEntityData> {
    @Override // javax.inject.Provider
    public final MockReferralTrackerEntityData get() {
        return newInstance();
    }

    public static MockReferralTrackerEntityData_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static MockReferralTrackerEntityData newInstance() {
        return new MockReferralTrackerEntityData();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final MockReferralTrackerEntityData_Factory MyBillsEntityDataFactory = new MockReferralTrackerEntityData_Factory();

        private InstanceHolder() {
        }
    }
}

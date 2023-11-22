package id.dana.data.pushverify.source.mock;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class MockPushVerifyEntityData_Factory implements Factory<MockPushVerifyEntityData> {
    @Override // javax.inject.Provider
    public final MockPushVerifyEntityData get() {
        return newInstance();
    }

    public static MockPushVerifyEntityData_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static MockPushVerifyEntityData newInstance() {
        return new MockPushVerifyEntityData();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final MockPushVerifyEntityData_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new MockPushVerifyEntityData_Factory();

        private InstanceHolder() {
        }
    }
}

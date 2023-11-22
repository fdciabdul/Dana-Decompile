package id.dana.data.synccontact.repository.source.mock;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class MockSyncContactEntityData_Factory implements Factory<MockSyncContactEntityData> {
    @Override // javax.inject.Provider
    public final MockSyncContactEntityData get() {
        return newInstance();
    }

    public static MockSyncContactEntityData_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static MockSyncContactEntityData newInstance() {
        return new MockSyncContactEntityData();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final MockSyncContactEntityData_Factory getAuthRequestContext = new MockSyncContactEntityData_Factory();

        private InstanceHolder() {
        }
    }
}

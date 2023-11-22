package id.dana.data.saving.repository.source.mock;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class MockSavingEntityData_Factory implements Factory<MockSavingEntityData> {
    @Override // javax.inject.Provider
    public final MockSavingEntityData get() {
        return newInstance();
    }

    public static MockSavingEntityData_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static MockSavingEntityData newInstance() {
        return new MockSavingEntityData();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final MockSavingEntityData_Factory PlaceComponentResult = new MockSavingEntityData_Factory();

        private InstanceHolder() {
        }
    }
}

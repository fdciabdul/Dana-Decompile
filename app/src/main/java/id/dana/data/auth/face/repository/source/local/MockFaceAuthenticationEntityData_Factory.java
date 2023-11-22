package id.dana.data.auth.face.repository.source.local;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class MockFaceAuthenticationEntityData_Factory implements Factory<MockFaceAuthenticationEntityData> {
    @Override // javax.inject.Provider
    public final MockFaceAuthenticationEntityData get() {
        return newInstance();
    }

    public static MockFaceAuthenticationEntityData_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static MockFaceAuthenticationEntityData newInstance() {
        return new MockFaceAuthenticationEntityData();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final MockFaceAuthenticationEntityData_Factory PlaceComponentResult = new MockFaceAuthenticationEntityData_Factory();

        private InstanceHolder() {
        }
    }
}

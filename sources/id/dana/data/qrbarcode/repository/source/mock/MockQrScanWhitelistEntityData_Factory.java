package id.dana.data.qrbarcode.repository.source.mock;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class MockQrScanWhitelistEntityData_Factory implements Factory<MockQrScanWhitelistEntityData> {
    @Override // javax.inject.Provider
    public final MockQrScanWhitelistEntityData get() {
        return newInstance();
    }

    public static MockQrScanWhitelistEntityData_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static MockQrScanWhitelistEntityData newInstance() {
        return new MockQrScanWhitelistEntityData();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final MockQrScanWhitelistEntityData_Factory PlaceComponentResult = new MockQrScanWhitelistEntityData_Factory();

        private InstanceHolder() {
        }
    }
}

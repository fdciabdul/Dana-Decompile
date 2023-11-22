package id.dana.data.qrbarcode.repository.source;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.qrbarcode.repository.source.mock.MockQrScanWhitelistEntityData;
import id.dana.data.qrbarcode.repository.source.network.SplitQrScanWhitelistConfig;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class QrScanWhitelistFactory_Factory implements Factory<QrScanWhitelistFactory> {
    private final Provider<MockQrScanWhitelistEntityData> mockQrScanWhitelistEntityDataProvider;
    private final Provider<SplitQrScanWhitelistConfig> splitQrScanWhitelistConfigProvider;

    public QrScanWhitelistFactory_Factory(Provider<SplitQrScanWhitelistConfig> provider, Provider<MockQrScanWhitelistEntityData> provider2) {
        this.splitQrScanWhitelistConfigProvider = provider;
        this.mockQrScanWhitelistEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final QrScanWhitelistFactory get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.splitQrScanWhitelistConfigProvider), DoubleCheck.MyBillsEntityDataFactory(this.mockQrScanWhitelistEntityDataProvider));
    }

    public static QrScanWhitelistFactory_Factory create(Provider<SplitQrScanWhitelistConfig> provider, Provider<MockQrScanWhitelistEntityData> provider2) {
        return new QrScanWhitelistFactory_Factory(provider, provider2);
    }

    public static QrScanWhitelistFactory newInstance(Lazy<SplitQrScanWhitelistConfig> lazy, Lazy<MockQrScanWhitelistEntityData> lazy2) {
        return new QrScanWhitelistFactory(lazy, lazy2);
    }
}

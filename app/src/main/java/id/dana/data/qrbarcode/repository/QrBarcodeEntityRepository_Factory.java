package id.dana.data.qrbarcode.repository;

import dagger.internal.Factory;
import id.dana.data.config.repository.FeatureConfigEntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.qrbarcode.mapper.QrBarcodeMapper;
import id.dana.data.qrbarcode.repository.source.QrBarcodeEntityDataFactory;
import id.dana.data.qrbarcode.repository.source.QrScanWhitelistFactory;
import id.dana.data.splitbill.mapper.SplitBillPayerEntityMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class QrBarcodeEntityRepository_Factory implements Factory<QrBarcodeEntityRepository> {
    private final Provider<FeatureConfigEntityRepository> featureConfigEntityRepositoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<QrBarcodeMapper> mapperProvider;
    private final Provider<QrBarcodeEntityDataFactory> qrBarcodeEntityDataFactoryProvider;
    private final Provider<QrScanWhitelistFactory> qrScanWhitelistFactoryProvider;
    private final Provider<SplitBillPayerEntityMapper> splitBillPayerEntityMapperProvider;

    public QrBarcodeEntityRepository_Factory(Provider<QrBarcodeEntityDataFactory> provider, Provider<QrBarcodeMapper> provider2, Provider<QrScanWhitelistFactory> provider3, Provider<SplitBillPayerEntityMapper> provider4, Provider<FeatureConfigEntityRepository> provider5, Provider<HoldLoginV1EntityRepository> provider6) {
        this.qrBarcodeEntityDataFactoryProvider = provider;
        this.mapperProvider = provider2;
        this.qrScanWhitelistFactoryProvider = provider3;
        this.splitBillPayerEntityMapperProvider = provider4;
        this.featureConfigEntityRepositoryProvider = provider5;
        this.holdLoginV1EntityRepositoryProvider = provider6;
    }

    @Override // javax.inject.Provider
    public final QrBarcodeEntityRepository get() {
        return newInstance(this.qrBarcodeEntityDataFactoryProvider.get(), this.mapperProvider.get(), this.qrScanWhitelistFactoryProvider.get(), this.splitBillPayerEntityMapperProvider.get(), this.featureConfigEntityRepositoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static QrBarcodeEntityRepository_Factory create(Provider<QrBarcodeEntityDataFactory> provider, Provider<QrBarcodeMapper> provider2, Provider<QrScanWhitelistFactory> provider3, Provider<SplitBillPayerEntityMapper> provider4, Provider<FeatureConfigEntityRepository> provider5, Provider<HoldLoginV1EntityRepository> provider6) {
        return new QrBarcodeEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static QrBarcodeEntityRepository newInstance(QrBarcodeEntityDataFactory qrBarcodeEntityDataFactory, QrBarcodeMapper qrBarcodeMapper, QrScanWhitelistFactory qrScanWhitelistFactory, SplitBillPayerEntityMapper splitBillPayerEntityMapper, FeatureConfigEntityRepository featureConfigEntityRepository, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new QrBarcodeEntityRepository(qrBarcodeEntityDataFactory, qrBarcodeMapper, qrScanWhitelistFactory, splitBillPayerEntityMapper, featureConfigEntityRepository, holdLoginV1EntityRepository);
    }
}

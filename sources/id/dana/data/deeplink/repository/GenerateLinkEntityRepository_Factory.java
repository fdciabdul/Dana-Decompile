package id.dana.data.deeplink.repository;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.deeplink.mapper.DeepLinkEntityMapper;
import id.dana.data.deeplink.repository.source.GenerateLinkEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.qrbarcode.repository.source.QrBarcodeEntityDataFactory;
import id.dana.data.referral.repository.source.MyReferralConsultEntityDataFactory;
import id.dana.data.splitbill.mapper.RecentPayerEntityMapper;
import id.dana.data.splitbill.mapper.SplitBillEncodeEntityMapper;
import id.dana.data.splitbill.mapper.SplitBillPayerEntityMapper;
import id.dana.data.splitbill.mapper.SplitBillToSplitBillEntityMapper;
import id.dana.data.splitbill.repository.source.RecentPayerEntityDataFactory;
import id.dana.data.splitbill.repository.source.SplitBillEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GenerateLinkEntityRepository_Factory implements Factory<GenerateLinkEntityRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<DeepLinkEntityMapper> deepLinkEntityMapperProvider;
    private final Provider<GenerateLinkEntityDataFactory> generateLinkEntityDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<MyReferralConsultEntityDataFactory> myReferralConsultEntityDataFactoryProvider;
    private final Provider<QrBarcodeEntityDataFactory> qrBarcodeEntityDataFactoryProvider;
    private final Provider<RecentPayerEntityDataFactory> recentPayerEntityDataFactoryProvider;
    private final Provider<RecentPayerEntityMapper> recentPayerEntityMapperProvider;
    private final Provider<SplitBillEncodeEntityMapper> splitBillEncodeEntityMapperProvider;
    private final Provider<SplitBillEntityDataFactory> splitBillEntityDataFactoryProvider;
    private final Provider<SplitBillPayerEntityMapper> splitBillPayerEntityMapperProvider;
    private final Provider<SplitBillToSplitBillEntityMapper> splitBillToSplitBillEntityMapperProvider;

    public GenerateLinkEntityRepository_Factory(Provider<ConfigEntityDataFactory> provider, Provider<GenerateLinkEntityDataFactory> provider2, Provider<MyReferralConsultEntityDataFactory> provider3, Provider<DeepLinkEntityMapper> provider4, Provider<QrBarcodeEntityDataFactory> provider5, Provider<SplitBillEntityDataFactory> provider6, Provider<RecentPayerEntityDataFactory> provider7, Provider<RecentPayerEntityMapper> provider8, Provider<SplitBillPayerEntityMapper> provider9, Provider<SplitBillToSplitBillEntityMapper> provider10, Provider<SplitBillEncodeEntityMapper> provider11, Provider<HoldLoginV1EntityRepository> provider12) {
        this.configEntityDataFactoryProvider = provider;
        this.generateLinkEntityDataFactoryProvider = provider2;
        this.myReferralConsultEntityDataFactoryProvider = provider3;
        this.deepLinkEntityMapperProvider = provider4;
        this.qrBarcodeEntityDataFactoryProvider = provider5;
        this.splitBillEntityDataFactoryProvider = provider6;
        this.recentPayerEntityDataFactoryProvider = provider7;
        this.recentPayerEntityMapperProvider = provider8;
        this.splitBillPayerEntityMapperProvider = provider9;
        this.splitBillToSplitBillEntityMapperProvider = provider10;
        this.splitBillEncodeEntityMapperProvider = provider11;
        this.holdLoginV1EntityRepositoryProvider = provider12;
    }

    @Override // javax.inject.Provider
    public final GenerateLinkEntityRepository get() {
        return newInstance(this.configEntityDataFactoryProvider.get(), this.generateLinkEntityDataFactoryProvider.get(), this.myReferralConsultEntityDataFactoryProvider.get(), this.deepLinkEntityMapperProvider.get(), this.qrBarcodeEntityDataFactoryProvider.get(), this.splitBillEntityDataFactoryProvider.get(), this.recentPayerEntityDataFactoryProvider.get(), this.recentPayerEntityMapperProvider.get(), this.splitBillPayerEntityMapperProvider.get(), this.splitBillToSplitBillEntityMapperProvider.get(), this.splitBillEncodeEntityMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static GenerateLinkEntityRepository_Factory create(Provider<ConfigEntityDataFactory> provider, Provider<GenerateLinkEntityDataFactory> provider2, Provider<MyReferralConsultEntityDataFactory> provider3, Provider<DeepLinkEntityMapper> provider4, Provider<QrBarcodeEntityDataFactory> provider5, Provider<SplitBillEntityDataFactory> provider6, Provider<RecentPayerEntityDataFactory> provider7, Provider<RecentPayerEntityMapper> provider8, Provider<SplitBillPayerEntityMapper> provider9, Provider<SplitBillToSplitBillEntityMapper> provider10, Provider<SplitBillEncodeEntityMapper> provider11, Provider<HoldLoginV1EntityRepository> provider12) {
        return new GenerateLinkEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static GenerateLinkEntityRepository newInstance(ConfigEntityDataFactory configEntityDataFactory, GenerateLinkEntityDataFactory generateLinkEntityDataFactory, MyReferralConsultEntityDataFactory myReferralConsultEntityDataFactory, DeepLinkEntityMapper deepLinkEntityMapper, QrBarcodeEntityDataFactory qrBarcodeEntityDataFactory, SplitBillEntityDataFactory splitBillEntityDataFactory, RecentPayerEntityDataFactory recentPayerEntityDataFactory, RecentPayerEntityMapper recentPayerEntityMapper, SplitBillPayerEntityMapper splitBillPayerEntityMapper, SplitBillToSplitBillEntityMapper splitBillToSplitBillEntityMapper, SplitBillEncodeEntityMapper splitBillEncodeEntityMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new GenerateLinkEntityRepository(configEntityDataFactory, generateLinkEntityDataFactory, myReferralConsultEntityDataFactory, deepLinkEntityMapper, qrBarcodeEntityDataFactory, splitBillEntityDataFactory, recentPayerEntityDataFactory, recentPayerEntityMapper, splitBillPayerEntityMapper, splitBillToSplitBillEntityMapper, splitBillEncodeEntityMapper, holdLoginV1EntityRepository);
    }
}

package id.dana.cashier.data.repository;

import dagger.internal.Factory;
import id.dana.cashier.data.mapper.CashierAddOnModalTooltipRequestMapper;
import id.dana.cashier.data.mapper.CashierAddOnModalTooltipResultMapper;
import id.dana.cashier.data.mapper.CashierEKtpAgreementRequestMapper;
import id.dana.cashier.data.mapper.CashierEKtpAgreementResultMapper;
import id.dana.cashier.data.mapper.CashierPayInfoRequestMapper;
import id.dana.cashier.data.mapper.CashierPayInfoResultMapper;
import id.dana.cashier.data.mapper.CreateOrderInfoRequestMapper;
import id.dana.cashier.data.mapper.CreateOrderInfoResultMapper;
import id.dana.cashier.data.mapper.LoanRegisterMapper;
import id.dana.cashier.data.mapper.QueryPromotionInfoResultMapper;
import id.dana.cashier.data.mapper.TopUpConsultResultMapper;
import id.dana.cashier.data.mapper.TopUpPayResultMapper;
import id.dana.cashier.data.repository.source.CashierBannerManagementEntityDataFactory;
import id.dana.cashier.data.repository.source.CashierEntityDataFactory;
import id.dana.cashier.data.repository.source.CdpGuideCacheEntityDataFactory;
import id.dana.cashier.data.repository.source.network.result.TimedSpaceRpcResult;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.card.repository.CardCredentialEntityRepository;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.geocode.repository.GeocodeEntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.paylater.repository.PaylaterEntityDataFactory;
import id.dana.data.security.source.SecurityEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CashierEntityRepository_Factory implements Factory<CashierEntityRepository> {
    private final Provider<AccountEntityDataFactory> accountEntityDataFactoryProvider;
    private final Provider<CashierBannerManagementEntityDataFactory> bannerManagementEntityDataFactoryProvider;
    private final Provider<CardCredentialEntityRepository> cardCredentialEntityRepositoryProvider;
    private final Provider<CashierAddOnModalTooltipRequestMapper> cashierAddOnModalTooltipRequestMapperProvider;
    private final Provider<CashierAddOnModalTooltipResultMapper> cashierAddOnModalTooltipResultMapperProvider;
    private final Provider<CashierEKtpAgreementRequestMapper> cashierEKtpAgreementRequestMapperProvider;
    private final Provider<CashierEKtpAgreementResultMapper> cashierEKtpAgreementResultMapperProvider;
    private final Provider<CashierEntityDataFactory> cashierEntityDataFactoryProvider;
    private final Provider<CashierPayInfoRequestMapper> cashierPayInfoRequestMapperProvider;
    private final Provider<CashierPayInfoResultMapper> cashierPayInfoResultMapperProvider;
    private final Provider<CdpGuideCacheEntityDataFactory<TimedSpaceRpcResult>> contentDeliveryCacheEntityDataFactoryProvider;
    private final Provider<ContentDeliveryEntityDataFactory> contentDeliveryEntityDataFactoryProvider;
    private final Provider<CreateOrderInfoRequestMapper> createOrderInfoRequestMapperProvider;
    private final Provider<CreateOrderInfoResultMapper> createOrderInfoResultMapperProvider;
    private final Provider<GeocodeEntityRepository> geocodeEntityRepositoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<LoanRegisterMapper> loanRegisterMapperProvider;
    private final Provider<PaylaterEntityDataFactory> paylaterEntityDataFactoryProvider;
    private final Provider<QueryPromotionInfoResultMapper> queryPromotionInfoResultMapperProvider;
    private final Provider<SecurityEntityDataFactory> securityEntityDataFactoryProvider;
    private final Provider<SpaceResultMapper> spaceResultMapperProvider;
    private final Provider<SplitConfigEntityData> splitConfigEntityDataProvider;
    private final Provider<TopUpConsultResultMapper> topUpConsultResultMapperProvider;
    private final Provider<TopUpPayResultMapper> topUpPayResultMapperProvider;

    public CashierEntityRepository_Factory(Provider<CashierEntityDataFactory> provider, Provider<PaylaterEntityDataFactory> provider2, Provider<SecurityEntityDataFactory> provider3, Provider<CdpGuideCacheEntityDataFactory<TimedSpaceRpcResult>> provider4, Provider<ContentDeliveryEntityDataFactory> provider5, Provider<CashierBannerManagementEntityDataFactory> provider6, Provider<AccountEntityDataFactory> provider7, Provider<CashierEKtpAgreementRequestMapper> provider8, Provider<CashierEKtpAgreementResultMapper> provider9, Provider<CashierPayInfoResultMapper> provider10, Provider<CashierPayInfoRequestMapper> provider11, Provider<CreateOrderInfoRequestMapper> provider12, Provider<CreateOrderInfoResultMapper> provider13, Provider<QueryPromotionInfoResultMapper> provider14, Provider<CashierAddOnModalTooltipRequestMapper> provider15, Provider<CashierAddOnModalTooltipResultMapper> provider16, Provider<TopUpConsultResultMapper> provider17, Provider<SpaceResultMapper> provider18, Provider<TopUpPayResultMapper> provider19, Provider<LoanRegisterMapper> provider20, Provider<SplitConfigEntityData> provider21, Provider<GeocodeEntityRepository> provider22, Provider<HoldLoginV1EntityRepository> provider23, Provider<CardCredentialEntityRepository> provider24) {
        this.cashierEntityDataFactoryProvider = provider;
        this.paylaterEntityDataFactoryProvider = provider2;
        this.securityEntityDataFactoryProvider = provider3;
        this.contentDeliveryCacheEntityDataFactoryProvider = provider4;
        this.contentDeliveryEntityDataFactoryProvider = provider5;
        this.bannerManagementEntityDataFactoryProvider = provider6;
        this.accountEntityDataFactoryProvider = provider7;
        this.cashierEKtpAgreementRequestMapperProvider = provider8;
        this.cashierEKtpAgreementResultMapperProvider = provider9;
        this.cashierPayInfoResultMapperProvider = provider10;
        this.cashierPayInfoRequestMapperProvider = provider11;
        this.createOrderInfoRequestMapperProvider = provider12;
        this.createOrderInfoResultMapperProvider = provider13;
        this.queryPromotionInfoResultMapperProvider = provider14;
        this.cashierAddOnModalTooltipRequestMapperProvider = provider15;
        this.cashierAddOnModalTooltipResultMapperProvider = provider16;
        this.topUpConsultResultMapperProvider = provider17;
        this.spaceResultMapperProvider = provider18;
        this.topUpPayResultMapperProvider = provider19;
        this.loanRegisterMapperProvider = provider20;
        this.splitConfigEntityDataProvider = provider21;
        this.geocodeEntityRepositoryProvider = provider22;
        this.holdLoginV1EntityRepositoryProvider = provider23;
        this.cardCredentialEntityRepositoryProvider = provider24;
    }

    @Override // javax.inject.Provider
    public final CashierEntityRepository get() {
        return newInstance(this.cashierEntityDataFactoryProvider.get(), this.paylaterEntityDataFactoryProvider.get(), this.securityEntityDataFactoryProvider.get(), this.contentDeliveryCacheEntityDataFactoryProvider.get(), this.contentDeliveryEntityDataFactoryProvider.get(), this.bannerManagementEntityDataFactoryProvider.get(), this.accountEntityDataFactoryProvider.get(), this.cashierEKtpAgreementRequestMapperProvider.get(), this.cashierEKtpAgreementResultMapperProvider.get(), this.cashierPayInfoResultMapperProvider.get(), this.cashierPayInfoRequestMapperProvider.get(), this.createOrderInfoRequestMapperProvider.get(), this.createOrderInfoResultMapperProvider.get(), this.queryPromotionInfoResultMapperProvider.get(), this.cashierAddOnModalTooltipRequestMapperProvider.get(), this.cashierAddOnModalTooltipResultMapperProvider.get(), this.topUpConsultResultMapperProvider.get(), this.spaceResultMapperProvider.get(), this.topUpPayResultMapperProvider.get(), this.loanRegisterMapperProvider.get(), this.splitConfigEntityDataProvider.get(), this.geocodeEntityRepositoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get(), this.cardCredentialEntityRepositoryProvider.get());
    }

    public static CashierEntityRepository_Factory create(Provider<CashierEntityDataFactory> provider, Provider<PaylaterEntityDataFactory> provider2, Provider<SecurityEntityDataFactory> provider3, Provider<CdpGuideCacheEntityDataFactory<TimedSpaceRpcResult>> provider4, Provider<ContentDeliveryEntityDataFactory> provider5, Provider<CashierBannerManagementEntityDataFactory> provider6, Provider<AccountEntityDataFactory> provider7, Provider<CashierEKtpAgreementRequestMapper> provider8, Provider<CashierEKtpAgreementResultMapper> provider9, Provider<CashierPayInfoResultMapper> provider10, Provider<CashierPayInfoRequestMapper> provider11, Provider<CreateOrderInfoRequestMapper> provider12, Provider<CreateOrderInfoResultMapper> provider13, Provider<QueryPromotionInfoResultMapper> provider14, Provider<CashierAddOnModalTooltipRequestMapper> provider15, Provider<CashierAddOnModalTooltipResultMapper> provider16, Provider<TopUpConsultResultMapper> provider17, Provider<SpaceResultMapper> provider18, Provider<TopUpPayResultMapper> provider19, Provider<LoanRegisterMapper> provider20, Provider<SplitConfigEntityData> provider21, Provider<GeocodeEntityRepository> provider22, Provider<HoldLoginV1EntityRepository> provider23, Provider<CardCredentialEntityRepository> provider24) {
        return new CashierEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24);
    }

    public static CashierEntityRepository newInstance(CashierEntityDataFactory cashierEntityDataFactory, PaylaterEntityDataFactory paylaterEntityDataFactory, SecurityEntityDataFactory securityEntityDataFactory, CdpGuideCacheEntityDataFactory<TimedSpaceRpcResult> cdpGuideCacheEntityDataFactory, ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, CashierBannerManagementEntityDataFactory cashierBannerManagementEntityDataFactory, AccountEntityDataFactory accountEntityDataFactory, CashierEKtpAgreementRequestMapper cashierEKtpAgreementRequestMapper, CashierEKtpAgreementResultMapper cashierEKtpAgreementResultMapper, CashierPayInfoResultMapper cashierPayInfoResultMapper, CashierPayInfoRequestMapper cashierPayInfoRequestMapper, CreateOrderInfoRequestMapper createOrderInfoRequestMapper, CreateOrderInfoResultMapper createOrderInfoResultMapper, QueryPromotionInfoResultMapper queryPromotionInfoResultMapper, CashierAddOnModalTooltipRequestMapper cashierAddOnModalTooltipRequestMapper, CashierAddOnModalTooltipResultMapper cashierAddOnModalTooltipResultMapper, TopUpConsultResultMapper topUpConsultResultMapper, SpaceResultMapper spaceResultMapper, TopUpPayResultMapper topUpPayResultMapper, LoanRegisterMapper loanRegisterMapper, SplitConfigEntityData splitConfigEntityData, GeocodeEntityRepository geocodeEntityRepository, HoldLoginV1EntityRepository holdLoginV1EntityRepository, CardCredentialEntityRepository cardCredentialEntityRepository) {
        return new CashierEntityRepository(cashierEntityDataFactory, paylaterEntityDataFactory, securityEntityDataFactory, cdpGuideCacheEntityDataFactory, contentDeliveryEntityDataFactory, cashierBannerManagementEntityDataFactory, accountEntityDataFactory, cashierEKtpAgreementRequestMapper, cashierEKtpAgreementResultMapper, cashierPayInfoResultMapper, cashierPayInfoRequestMapper, createOrderInfoRequestMapper, createOrderInfoResultMapper, queryPromotionInfoResultMapper, cashierAddOnModalTooltipRequestMapper, cashierAddOnModalTooltipResultMapper, topUpConsultResultMapper, spaceResultMapper, topUpPayResultMapper, loanRegisterMapper, splitConfigEntityData, geocodeEntityRepository, holdLoginV1EntityRepository, cardCredentialEntityRepository);
    }
}

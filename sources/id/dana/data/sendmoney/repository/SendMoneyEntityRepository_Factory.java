package id.dana.data.sendmoney.repository;

import dagger.internal.Factory;
import id.dana.data.card.repository.CardCredentialEntityRepository;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.content.mapper.ContentMapper;
import id.dana.data.content.mapper.ContentsMapper;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.promotion.repository.source.persistence.PromoEntityDataFactory;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.data.sendmoney.mapper.BizOTCTransferInitMapper;
import id.dana.data.sendmoney.mapper.BizTransferInitMapper;
import id.dana.data.sendmoney.mapper.SendMoneyMapper;
import id.dana.data.sendmoney.mapper.SendMoneyScenariosMapper;
import id.dana.data.sendmoney.mapper.TransferInitParamRequestMapper;
import id.dana.data.sendmoney.mapper.TransferOTCSubmitRequestMapper;
import id.dana.data.sendmoney.mapper.TransferOrderCreateMapper;
import id.dana.data.sendmoney.mapper.TransferPrePayMapper;
import id.dana.data.sendmoney.mapper.TransferSubmitParamMapper;
import id.dana.data.sendmoney.mapper.WithdrawInitMapper;
import id.dana.data.sendmoney.mapper.WithdrawNameCheckMapper;
import id.dana.data.sendmoney.repository.source.AddPayMethodConfigFactory;
import id.dana.data.sendmoney.repository.source.BillerX2BEntityDataFactory;
import id.dana.data.sendmoney.repository.source.DigitalMoneyEntityDataFactory;
import id.dana.data.sendmoney.repository.source.SendMoneyDataFactory;
import id.dana.data.sendmoney.repository.source.SendMoneyPreferenceEntityDataFactory;
import id.dana.data.sendmoney.repository.source.SendMoneyScenariosConfigEntityDataFactory;
import id.dana.data.sendmoney.repository.source.SortingSendMoneyPreferenceEntityDataFactory;
import id.dana.domain.geocode.GeocodeRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SendMoneyEntityRepository_Factory implements Factory<SendMoneyEntityRepository> {
    private final Provider<AddPayMethodConfigFactory> addPayMethodConfigFactoryProvider;
    private final Provider<BillerX2BEntityDataFactory> billerX2BEntityDataFactoryProvider;
    private final Provider<BizOTCTransferInitMapper> bizOTCTransferInitMapperProvider;
    private final Provider<BizTransferInitMapper> bizTransferInitMapperProvider;
    private final Provider<CardCredentialEntityRepository> cardCredentialEntityRepositoryProvider;
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<ContentDeliveryEntityDataFactory> contentDeliveryEntityDataFactoryProvider;
    private final Provider<ContentsMapper> contentsMapperProvider;
    private final Provider<DeviceInformationProvider> deviceInformationProvider;
    private final Provider<DigitalMoneyEntityDataFactory> digitalMoneyDataFactoryProvider;
    private final Provider<GeocodeRepository> geocodeRepositoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<ContentMapper> mapperProvider;
    private final Provider<PromoEntityDataFactory> promoEntityDataFactoryProvider;
    private final Provider<SecurityEntityDataFactory> securityEntityDataFactoryProvider;
    private final Provider<SendMoneyDataFactory> sendMoneyDataFactoryProvider;
    private final Provider<SendMoneyMapper> sendMoneyMapperProvider;
    private final Provider<SendMoneyPreferenceEntityDataFactory> sendMoneyPreferenceEntityDataFactoryProvider;
    private final Provider<SendMoneyScenariosConfigEntityDataFactory> sendMoneyScenariosConfigEntityDataFactoryProvider;
    private final Provider<SendMoneyScenariosMapper> sendMoneyScenariosMapperProvider;
    private final Provider<SortingSendMoneyPreferenceEntityDataFactory> sortingSendMoneyPreferenceEntityDataFactoryProvider;
    private final Provider<SplitConfigEntityData> splitConfigEntityDataProvider;
    private final Provider<TransferInitParamRequestMapper> transferInitParamRequestMapperProvider;
    private final Provider<TransferOTCSubmitRequestMapper> transferOTCSubmitRequestMapperProvider;
    private final Provider<TransferOrderCreateMapper> transferOrderCreateMapperProvider;
    private final Provider<TransferPrePayMapper> transferPrePayMapperProvider;
    private final Provider<TransferSubmitParamMapper> transferSubmitParamMapperProvider;
    private final Provider<WithdrawInitMapper> withdrawInitMapperProvider;
    private final Provider<WithdrawNameCheckMapper> withdrawNameCheckMapperProvider;

    public SendMoneyEntityRepository_Factory(Provider<SendMoneyDataFactory> provider, Provider<DeviceInformationProvider> provider2, Provider<AddPayMethodConfigFactory> provider3, Provider<TransferOTCSubmitRequestMapper> provider4, Provider<ConfigEntityDataFactory> provider5, Provider<BizOTCTransferInitMapper> provider6, Provider<WithdrawInitMapper> provider7, Provider<SendMoneyScenariosConfigEntityDataFactory> provider8, Provider<PromoEntityDataFactory> provider9, Provider<DigitalMoneyEntityDataFactory> provider10, Provider<SecurityEntityDataFactory> provider11, Provider<SendMoneyPreferenceEntityDataFactory> provider12, Provider<SortingSendMoneyPreferenceEntityDataFactory> provider13, Provider<SplitConfigEntityData> provider14, Provider<BillerX2BEntityDataFactory> provider15, Provider<GeocodeRepository> provider16, Provider<HoldLoginV1EntityRepository> provider17, Provider<CardCredentialEntityRepository> provider18, Provider<SendMoneyMapper> provider19, Provider<BizTransferInitMapper> provider20, Provider<WithdrawNameCheckMapper> provider21, Provider<TransferSubmitParamMapper> provider22, Provider<TransferPrePayMapper> provider23, Provider<ContentsMapper> provider24, Provider<TransferInitParamRequestMapper> provider25, Provider<SendMoneyScenariosMapper> provider26, Provider<TransferOrderCreateMapper> provider27, Provider<ContentDeliveryEntityDataFactory> provider28, Provider<ContentMapper> provider29) {
        this.sendMoneyDataFactoryProvider = provider;
        this.deviceInformationProvider = provider2;
        this.addPayMethodConfigFactoryProvider = provider3;
        this.transferOTCSubmitRequestMapperProvider = provider4;
        this.configEntityDataFactoryProvider = provider5;
        this.bizOTCTransferInitMapperProvider = provider6;
        this.withdrawInitMapperProvider = provider7;
        this.sendMoneyScenariosConfigEntityDataFactoryProvider = provider8;
        this.promoEntityDataFactoryProvider = provider9;
        this.digitalMoneyDataFactoryProvider = provider10;
        this.securityEntityDataFactoryProvider = provider11;
        this.sendMoneyPreferenceEntityDataFactoryProvider = provider12;
        this.sortingSendMoneyPreferenceEntityDataFactoryProvider = provider13;
        this.splitConfigEntityDataProvider = provider14;
        this.billerX2BEntityDataFactoryProvider = provider15;
        this.geocodeRepositoryProvider = provider16;
        this.holdLoginV1EntityRepositoryProvider = provider17;
        this.cardCredentialEntityRepositoryProvider = provider18;
        this.sendMoneyMapperProvider = provider19;
        this.bizTransferInitMapperProvider = provider20;
        this.withdrawNameCheckMapperProvider = provider21;
        this.transferSubmitParamMapperProvider = provider22;
        this.transferPrePayMapperProvider = provider23;
        this.contentsMapperProvider = provider24;
        this.transferInitParamRequestMapperProvider = provider25;
        this.sendMoneyScenariosMapperProvider = provider26;
        this.transferOrderCreateMapperProvider = provider27;
        this.contentDeliveryEntityDataFactoryProvider = provider28;
        this.mapperProvider = provider29;
    }

    @Override // javax.inject.Provider
    public final SendMoneyEntityRepository get() {
        SendMoneyEntityRepository newInstance = newInstance(this.sendMoneyDataFactoryProvider.get(), this.deviceInformationProvider.get(), this.addPayMethodConfigFactoryProvider.get(), this.transferOTCSubmitRequestMapperProvider.get(), this.configEntityDataFactoryProvider.get(), this.bizOTCTransferInitMapperProvider.get(), this.withdrawInitMapperProvider.get(), this.sendMoneyScenariosConfigEntityDataFactoryProvider.get(), this.promoEntityDataFactoryProvider.get(), this.digitalMoneyDataFactoryProvider.get(), this.securityEntityDataFactoryProvider.get(), this.sendMoneyPreferenceEntityDataFactoryProvider.get(), this.sortingSendMoneyPreferenceEntityDataFactoryProvider.get(), this.splitConfigEntityDataProvider.get(), this.billerX2BEntityDataFactoryProvider.get(), this.geocodeRepositoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get(), this.cardCredentialEntityRepositoryProvider.get());
        SendMoneyEntityRepository_MembersInjector.injectInjectMapperDependencies(newInstance, this.sendMoneyMapperProvider.get(), this.bizTransferInitMapperProvider.get(), this.withdrawNameCheckMapperProvider.get(), this.transferSubmitParamMapperProvider.get(), this.transferPrePayMapperProvider.get(), this.contentsMapperProvider.get(), this.transferInitParamRequestMapperProvider.get(), this.sendMoneyScenariosMapperProvider.get(), this.transferOrderCreateMapperProvider.get());
        SendMoneyEntityRepository_MembersInjector.injectInjectCdpDependencies(newInstance, this.contentDeliveryEntityDataFactoryProvider.get(), this.mapperProvider.get());
        return newInstance;
    }

    public static SendMoneyEntityRepository_Factory create(Provider<SendMoneyDataFactory> provider, Provider<DeviceInformationProvider> provider2, Provider<AddPayMethodConfigFactory> provider3, Provider<TransferOTCSubmitRequestMapper> provider4, Provider<ConfigEntityDataFactory> provider5, Provider<BizOTCTransferInitMapper> provider6, Provider<WithdrawInitMapper> provider7, Provider<SendMoneyScenariosConfigEntityDataFactory> provider8, Provider<PromoEntityDataFactory> provider9, Provider<DigitalMoneyEntityDataFactory> provider10, Provider<SecurityEntityDataFactory> provider11, Provider<SendMoneyPreferenceEntityDataFactory> provider12, Provider<SortingSendMoneyPreferenceEntityDataFactory> provider13, Provider<SplitConfigEntityData> provider14, Provider<BillerX2BEntityDataFactory> provider15, Provider<GeocodeRepository> provider16, Provider<HoldLoginV1EntityRepository> provider17, Provider<CardCredentialEntityRepository> provider18, Provider<SendMoneyMapper> provider19, Provider<BizTransferInitMapper> provider20, Provider<WithdrawNameCheckMapper> provider21, Provider<TransferSubmitParamMapper> provider22, Provider<TransferPrePayMapper> provider23, Provider<ContentsMapper> provider24, Provider<TransferInitParamRequestMapper> provider25, Provider<SendMoneyScenariosMapper> provider26, Provider<TransferOrderCreateMapper> provider27, Provider<ContentDeliveryEntityDataFactory> provider28, Provider<ContentMapper> provider29) {
        return new SendMoneyEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29);
    }

    public static SendMoneyEntityRepository newInstance(SendMoneyDataFactory sendMoneyDataFactory, DeviceInformationProvider deviceInformationProvider, AddPayMethodConfigFactory addPayMethodConfigFactory, TransferOTCSubmitRequestMapper transferOTCSubmitRequestMapper, ConfigEntityDataFactory configEntityDataFactory, BizOTCTransferInitMapper bizOTCTransferInitMapper, WithdrawInitMapper withdrawInitMapper, SendMoneyScenariosConfigEntityDataFactory sendMoneyScenariosConfigEntityDataFactory, PromoEntityDataFactory promoEntityDataFactory, DigitalMoneyEntityDataFactory digitalMoneyEntityDataFactory, SecurityEntityDataFactory securityEntityDataFactory, SendMoneyPreferenceEntityDataFactory sendMoneyPreferenceEntityDataFactory, SortingSendMoneyPreferenceEntityDataFactory sortingSendMoneyPreferenceEntityDataFactory, SplitConfigEntityData splitConfigEntityData, BillerX2BEntityDataFactory billerX2BEntityDataFactory, GeocodeRepository geocodeRepository, HoldLoginV1EntityRepository holdLoginV1EntityRepository, CardCredentialEntityRepository cardCredentialEntityRepository) {
        return new SendMoneyEntityRepository(sendMoneyDataFactory, deviceInformationProvider, addPayMethodConfigFactory, transferOTCSubmitRequestMapper, configEntityDataFactory, bizOTCTransferInitMapper, withdrawInitMapper, sendMoneyScenariosConfigEntityDataFactory, promoEntityDataFactory, digitalMoneyEntityDataFactory, securityEntityDataFactory, sendMoneyPreferenceEntityDataFactory, sortingSendMoneyPreferenceEntityDataFactory, splitConfigEntityData, billerX2BEntityDataFactory, geocodeRepository, holdLoginV1EntityRepository, cardCredentialEntityRepository);
    }
}

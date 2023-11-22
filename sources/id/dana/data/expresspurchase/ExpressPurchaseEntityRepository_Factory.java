package id.dana.data.expresspurchase;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.expresspurchase.source.DealsExpressPurchaseDataFactory;
import id.dana.data.expresspurchase.source.ExpressPurchaseEntityDataFactory;
import id.dana.data.expresspurchase.source.ExpressPurchaseOfferEntityDataFactory;
import id.dana.data.paylater.repository.PaylaterEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ExpressPurchaseEntityRepository_Factory implements Factory<ExpressPurchaseEntityRepository> {
    private final Provider<AccountEntityDataFactory> accountEntityDataFactoryProvider;
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<ContentDeliveryEntityDataFactory> contentDeliveryEntityDataFactoryProvider;
    private final Provider<DealsExpressPurchaseDataFactory> dealsExpressPurchaseDataFactoryProvider;
    private final Provider<DeviceInformationProvider> deviceInformationProvider;
    private final Provider<ExpressPurchaseEntityDataFactory> expressPurchaseEntityDataFactoryProvider;
    private final Provider<ExpressPurchaseOfferEntityDataFactory> expressPurchaseOfferEntityDataFactoryProvider;
    private final Provider<PaylaterEntityDataFactory> paylaterEntityDataFactoryProvider;
    private final Provider<SpaceResultMapper> spaceRpcResultMapperProvider;

    public ExpressPurchaseEntityRepository_Factory(Provider<ExpressPurchaseEntityDataFactory> provider, Provider<AccountEntityDataFactory> provider2, Provider<DeviceInformationProvider> provider3, Provider<PaylaterEntityDataFactory> provider4, Provider<ConfigEntityDataFactory> provider5, Provider<ContentDeliveryEntityDataFactory> provider6, Provider<SpaceResultMapper> provider7, Provider<DealsExpressPurchaseDataFactory> provider8, Provider<ExpressPurchaseOfferEntityDataFactory> provider9) {
        this.expressPurchaseEntityDataFactoryProvider = provider;
        this.accountEntityDataFactoryProvider = provider2;
        this.deviceInformationProvider = provider3;
        this.paylaterEntityDataFactoryProvider = provider4;
        this.configEntityDataFactoryProvider = provider5;
        this.contentDeliveryEntityDataFactoryProvider = provider6;
        this.spaceRpcResultMapperProvider = provider7;
        this.dealsExpressPurchaseDataFactoryProvider = provider8;
        this.expressPurchaseOfferEntityDataFactoryProvider = provider9;
    }

    @Override // javax.inject.Provider
    public final ExpressPurchaseEntityRepository get() {
        return newInstance(this.expressPurchaseEntityDataFactoryProvider.get(), this.accountEntityDataFactoryProvider.get(), this.deviceInformationProvider.get(), this.paylaterEntityDataFactoryProvider.get(), this.configEntityDataFactoryProvider.get(), this.contentDeliveryEntityDataFactoryProvider.get(), this.spaceRpcResultMapperProvider.get(), this.dealsExpressPurchaseDataFactoryProvider.get(), this.expressPurchaseOfferEntityDataFactoryProvider.get());
    }

    public static ExpressPurchaseEntityRepository_Factory create(Provider<ExpressPurchaseEntityDataFactory> provider, Provider<AccountEntityDataFactory> provider2, Provider<DeviceInformationProvider> provider3, Provider<PaylaterEntityDataFactory> provider4, Provider<ConfigEntityDataFactory> provider5, Provider<ContentDeliveryEntityDataFactory> provider6, Provider<SpaceResultMapper> provider7, Provider<DealsExpressPurchaseDataFactory> provider8, Provider<ExpressPurchaseOfferEntityDataFactory> provider9) {
        return new ExpressPurchaseEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static ExpressPurchaseEntityRepository newInstance(ExpressPurchaseEntityDataFactory expressPurchaseEntityDataFactory, AccountEntityDataFactory accountEntityDataFactory, DeviceInformationProvider deviceInformationProvider, PaylaterEntityDataFactory paylaterEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory, ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, SpaceResultMapper spaceResultMapper, DealsExpressPurchaseDataFactory dealsExpressPurchaseDataFactory, ExpressPurchaseOfferEntityDataFactory expressPurchaseOfferEntityDataFactory) {
        return new ExpressPurchaseEntityRepository(expressPurchaseEntityDataFactory, accountEntityDataFactory, deviceInformationProvider, paylaterEntityDataFactory, configEntityDataFactory, contentDeliveryEntityDataFactory, spaceResultMapper, dealsExpressPurchaseDataFactory, expressPurchaseOfferEntityDataFactory);
    }
}

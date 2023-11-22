package id.dana.data.recentrecipient.repository;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.card.repository.CardCredentialEntityRepository;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.recentbank.mapper.RecentBankEntityMapper;
import id.dana.data.recentrecipient.BankCardConversionFactory;
import id.dana.data.recentrecipient.mapper.BankCardConversionMapper;
import id.dana.data.recentrecipient.mapper.RecentBankMapper;
import id.dana.data.recentrecipient.mapper.RecentRecipientContactEntityMapper;
import id.dana.data.recentrecipient.mapper.RecentRecipientEntityMapper;
import id.dana.data.recentrecipient.mapper.RecentRecipientPayerEntityMapper;
import id.dana.data.recentrecipient.source.RecentRecipientEntityDataFactory;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.data.sendmoney.repository.source.SortingSendMoneyPreferenceEntityDataFactory;
import id.dana.data.splitbill.repository.source.RecentPayerEntityDataFactory;
import id.dana.data.storage.GeneralPreferences;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RecentRecipientEntityRepository_Factory implements Factory<RecentRecipientEntityRepository> {
    private final Provider<AccountEntityDataFactory> accountEntityDataFactoryProvider;
    private final Provider<BankCardConversionFactory> bankCardConversionFactoryProvider;
    private final Provider<BankCardConversionMapper> bankCardConversionMapperProvider;
    private final Provider<CardCredentialEntityRepository> cardCredentialEntityRepositoryProvider;
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<GeneralPreferences> generalPreferencesProvider;
    private final Provider<RecentBankEntityMapper> recentBankEntityMapperProvider;
    private final Provider<RecentBankMapper> recentBankMapperProvider;
    private final Provider<RecentPayerEntityDataFactory> recentPayerEntityDataFactoryProvider;
    private final Provider<RecentRecipientContactEntityMapper> recentRecipientContactEntityMapperProvider;
    private final Provider<RecentRecipientEntityDataFactory> recentRecipientEntityDataFactoryProvider;
    private final Provider<RecentRecipientEntityMapper> recentRecipientEntityMapperProvider;
    private final Provider<RecentRecipientPayerEntityMapper> recentRecipientPayerEntityMapperProvider;
    private final Provider<SecurityEntityDataFactory> securityEntityDataFactoryProvider;
    private final Provider<SortingSendMoneyPreferenceEntityDataFactory> sortingSendMoneyPreferenceEntityDataFactoryProvider;
    private final Provider<UserConfigEntityRepository> userConfigEntityRepositoryProvider;

    public RecentRecipientEntityRepository_Factory(Provider<ConfigEntityDataFactory> provider, Provider<RecentPayerEntityDataFactory> provider2, Provider<RecentRecipientPayerEntityMapper> provider3, Provider<RecentRecipientContactEntityMapper> provider4, Provider<RecentRecipientEntityMapper> provider5, Provider<RecentBankEntityMapper> provider6, Provider<UserConfigEntityRepository> provider7, Provider<GeneralPreferences> provider8, Provider<RecentBankMapper> provider9, Provider<BankCardConversionFactory> provider10, Provider<SecurityEntityDataFactory> provider11, Provider<BankCardConversionMapper> provider12, Provider<AccountEntityDataFactory> provider13, Provider<FeatureConfigRepository> provider14, Provider<SortingSendMoneyPreferenceEntityDataFactory> provider15, Provider<RecentRecipientEntityDataFactory> provider16, Provider<CardCredentialEntityRepository> provider17) {
        this.configEntityDataFactoryProvider = provider;
        this.recentPayerEntityDataFactoryProvider = provider2;
        this.recentRecipientPayerEntityMapperProvider = provider3;
        this.recentRecipientContactEntityMapperProvider = provider4;
        this.recentRecipientEntityMapperProvider = provider5;
        this.recentBankEntityMapperProvider = provider6;
        this.userConfigEntityRepositoryProvider = provider7;
        this.generalPreferencesProvider = provider8;
        this.recentBankMapperProvider = provider9;
        this.bankCardConversionFactoryProvider = provider10;
        this.securityEntityDataFactoryProvider = provider11;
        this.bankCardConversionMapperProvider = provider12;
        this.accountEntityDataFactoryProvider = provider13;
        this.featureConfigRepositoryProvider = provider14;
        this.sortingSendMoneyPreferenceEntityDataFactoryProvider = provider15;
        this.recentRecipientEntityDataFactoryProvider = provider16;
        this.cardCredentialEntityRepositoryProvider = provider17;
    }

    @Override // javax.inject.Provider
    public final RecentRecipientEntityRepository get() {
        return newInstance(this.configEntityDataFactoryProvider.get(), this.recentPayerEntityDataFactoryProvider.get(), this.recentRecipientPayerEntityMapperProvider.get(), this.recentRecipientContactEntityMapperProvider.get(), this.recentRecipientEntityMapperProvider.get(), this.recentBankEntityMapperProvider.get(), this.userConfigEntityRepositoryProvider.get(), this.generalPreferencesProvider.get(), this.recentBankMapperProvider.get(), this.bankCardConversionFactoryProvider.get(), this.securityEntityDataFactoryProvider.get(), this.bankCardConversionMapperProvider.get(), this.accountEntityDataFactoryProvider.get(), this.featureConfigRepositoryProvider.get(), this.sortingSendMoneyPreferenceEntityDataFactoryProvider.get(), this.recentRecipientEntityDataFactoryProvider.get(), this.cardCredentialEntityRepositoryProvider.get());
    }

    public static RecentRecipientEntityRepository_Factory create(Provider<ConfigEntityDataFactory> provider, Provider<RecentPayerEntityDataFactory> provider2, Provider<RecentRecipientPayerEntityMapper> provider3, Provider<RecentRecipientContactEntityMapper> provider4, Provider<RecentRecipientEntityMapper> provider5, Provider<RecentBankEntityMapper> provider6, Provider<UserConfigEntityRepository> provider7, Provider<GeneralPreferences> provider8, Provider<RecentBankMapper> provider9, Provider<BankCardConversionFactory> provider10, Provider<SecurityEntityDataFactory> provider11, Provider<BankCardConversionMapper> provider12, Provider<AccountEntityDataFactory> provider13, Provider<FeatureConfigRepository> provider14, Provider<SortingSendMoneyPreferenceEntityDataFactory> provider15, Provider<RecentRecipientEntityDataFactory> provider16, Provider<CardCredentialEntityRepository> provider17) {
        return new RecentRecipientEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    public static RecentRecipientEntityRepository newInstance(ConfigEntityDataFactory configEntityDataFactory, RecentPayerEntityDataFactory recentPayerEntityDataFactory, RecentRecipientPayerEntityMapper recentRecipientPayerEntityMapper, RecentRecipientContactEntityMapper recentRecipientContactEntityMapper, RecentRecipientEntityMapper recentRecipientEntityMapper, RecentBankEntityMapper recentBankEntityMapper, UserConfigEntityRepository userConfigEntityRepository, GeneralPreferences generalPreferences, RecentBankMapper recentBankMapper, BankCardConversionFactory bankCardConversionFactory, SecurityEntityDataFactory securityEntityDataFactory, BankCardConversionMapper bankCardConversionMapper, AccountEntityDataFactory accountEntityDataFactory, FeatureConfigRepository featureConfigRepository, SortingSendMoneyPreferenceEntityDataFactory sortingSendMoneyPreferenceEntityDataFactory, RecentRecipientEntityDataFactory recentRecipientEntityDataFactory, CardCredentialEntityRepository cardCredentialEntityRepository) {
        return new RecentRecipientEntityRepository(configEntityDataFactory, recentPayerEntityDataFactory, recentRecipientPayerEntityMapper, recentRecipientContactEntityMapper, recentRecipientEntityMapper, recentBankEntityMapper, userConfigEntityRepository, generalPreferences, recentBankMapper, bankCardConversionFactory, securityEntityDataFactory, bankCardConversionMapper, accountEntityDataFactory, featureConfigRepository, sortingSendMoneyPreferenceEntityDataFactory, recentRecipientEntityDataFactory, cardCredentialEntityRepository);
    }
}

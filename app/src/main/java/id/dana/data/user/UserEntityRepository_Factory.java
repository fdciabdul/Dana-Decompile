package id.dana.data.user;

import android.content.Context;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.config.source.sharedpreference.SharedPrefSplitAttributes;
import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.sendmoney.mapper.CurrencyAmountResultMapper;
import id.dana.data.user.source.UserInfoEntityDataFactory;
import id.dana.data.user.source.persistence.UserInfoPreference;
import id.dana.domain.home.HomeWidgetRepository;
import id.dana.domain.tracker.MixpanelRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserEntityRepository_Factory implements Factory<UserEntityRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<Context> contextProvider;
    private final Provider<CurrencyAmountResultMapper> currencyAmountResultMapperProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<HomeWidgetRepository> homeWidgetRepositoryProvider;
    private final Provider<MixpanelRepository> mixpanelRepositoryProvider;
    private final Provider<SharedPrefSplitAttributes> sharedPrefSplitAttributesProvider;
    private final Provider<SharedPrefStartupConfig> sharedPrefStartupConfigProvider;
    private final Provider<UserInfoEntityDataFactory> userInfoEntityDataFactoryProvider;
    private final Provider<UserInfoMapper> userInfoMapperProvider;
    private final Provider<UserInfoPreference> userInfoPreferenceProvider;

    public UserEntityRepository_Factory(Provider<UserInfoEntityDataFactory> provider, Provider<CurrencyAmountResultMapper> provider2, Provider<UserInfoMapper> provider3, Provider<ConfigEntityDataFactory> provider4, Provider<HoldLoginV1EntityRepository> provider5, Provider<UserInfoPreference> provider6, Provider<SharedPrefSplitAttributes> provider7, Provider<MixpanelRepository> provider8, Provider<SharedPrefStartupConfig> provider9, Provider<HomeWidgetRepository> provider10, Provider<Context> provider11) {
        this.userInfoEntityDataFactoryProvider = provider;
        this.currencyAmountResultMapperProvider = provider2;
        this.userInfoMapperProvider = provider3;
        this.configEntityDataFactoryProvider = provider4;
        this.holdLoginV1EntityRepositoryProvider = provider5;
        this.userInfoPreferenceProvider = provider6;
        this.sharedPrefSplitAttributesProvider = provider7;
        this.mixpanelRepositoryProvider = provider8;
        this.sharedPrefStartupConfigProvider = provider9;
        this.homeWidgetRepositoryProvider = provider10;
        this.contextProvider = provider11;
    }

    @Override // javax.inject.Provider
    public final UserEntityRepository get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.userInfoEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.currencyAmountResultMapperProvider), DoubleCheck.MyBillsEntityDataFactory(this.userInfoMapperProvider), DoubleCheck.MyBillsEntityDataFactory(this.configEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.holdLoginV1EntityRepositoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.userInfoPreferenceProvider), DoubleCheck.MyBillsEntityDataFactory(this.sharedPrefSplitAttributesProvider), DoubleCheck.MyBillsEntityDataFactory(this.mixpanelRepositoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.sharedPrefStartupConfigProvider), DoubleCheck.MyBillsEntityDataFactory(this.homeWidgetRepositoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.contextProvider));
    }

    public static UserEntityRepository_Factory create(Provider<UserInfoEntityDataFactory> provider, Provider<CurrencyAmountResultMapper> provider2, Provider<UserInfoMapper> provider3, Provider<ConfigEntityDataFactory> provider4, Provider<HoldLoginV1EntityRepository> provider5, Provider<UserInfoPreference> provider6, Provider<SharedPrefSplitAttributes> provider7, Provider<MixpanelRepository> provider8, Provider<SharedPrefStartupConfig> provider9, Provider<HomeWidgetRepository> provider10, Provider<Context> provider11) {
        return new UserEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static UserEntityRepository newInstance(Lazy<UserInfoEntityDataFactory> lazy, Lazy<CurrencyAmountResultMapper> lazy2, Lazy<UserInfoMapper> lazy3, Lazy<ConfigEntityDataFactory> lazy4, Lazy<HoldLoginV1EntityRepository> lazy5, Lazy<UserInfoPreference> lazy6, Lazy<SharedPrefSplitAttributes> lazy7, Lazy<MixpanelRepository> lazy8, Lazy<SharedPrefStartupConfig> lazy9, Lazy<HomeWidgetRepository> lazy10, Lazy<Context> lazy11) {
        return new UserEntityRepository(lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8, lazy9, lazy10, lazy11);
    }
}

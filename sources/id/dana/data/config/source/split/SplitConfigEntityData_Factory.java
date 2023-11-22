package id.dana.data.config.source.split;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig;
import id.dana.data.config.source.sharedpreference.SharedPrefScannerConfig;
import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitConfigEntityData_Factory implements Factory<SplitConfigEntityData> {
    private final Provider<GeneralPreferencesDataFactory> generalPreferencesDataFactoryProvider;
    private final Provider<SharedPrefCashierConfig> sharedPrefCashierConfigProvider;
    private final Provider<SharedPrefScannerConfig> sharedPrefScannerConfigProvider;
    private final Provider<SharedPrefStartupConfig> sharedPrefStartupConfigProvider;
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitConfigEntityData_Factory(Provider<SplitFacade> provider, Provider<SharedPrefStartupConfig> provider2, Provider<SharedPrefScannerConfig> provider3, Provider<SharedPrefCashierConfig> provider4, Provider<GeneralPreferencesDataFactory> provider5) {
        this.splitFacadeProvider = provider;
        this.sharedPrefStartupConfigProvider = provider2;
        this.sharedPrefScannerConfigProvider = provider3;
        this.sharedPrefCashierConfigProvider = provider4;
        this.generalPreferencesDataFactoryProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final SplitConfigEntityData get() {
        return newInstance(this.splitFacadeProvider.get(), this.sharedPrefStartupConfigProvider.get(), this.sharedPrefScannerConfigProvider.get(), this.sharedPrefCashierConfigProvider.get(), DoubleCheck.MyBillsEntityDataFactory(this.generalPreferencesDataFactoryProvider));
    }

    public static SplitConfigEntityData_Factory create(Provider<SplitFacade> provider, Provider<SharedPrefStartupConfig> provider2, Provider<SharedPrefScannerConfig> provider3, Provider<SharedPrefCashierConfig> provider4, Provider<GeneralPreferencesDataFactory> provider5) {
        return new SplitConfigEntityData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SplitConfigEntityData newInstance(SplitFacade splitFacade, SharedPrefStartupConfig sharedPrefStartupConfig, SharedPrefScannerConfig sharedPrefScannerConfig, SharedPrefCashierConfig sharedPrefCashierConfig, Lazy<GeneralPreferencesDataFactory> lazy) {
        return new SplitConfigEntityData(splitFacade, sharedPrefStartupConfig, sharedPrefScannerConfig, sharedPrefCashierConfig, lazy);
    }
}

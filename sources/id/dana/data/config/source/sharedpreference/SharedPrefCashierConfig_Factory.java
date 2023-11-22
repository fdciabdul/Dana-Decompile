package id.dana.data.config.source.sharedpreference;

import com.google.gson.Gson;
import dagger.internal.Factory;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SharedPrefCashierConfig_Factory implements Factory<SharedPrefCashierConfig> {
    private final Provider<Gson> gsonProvider;
    private final Provider<PreferenceFacade> preferenceFacadeProvider;

    public SharedPrefCashierConfig_Factory(Provider<PreferenceFacade> provider, Provider<Gson> provider2) {
        this.preferenceFacadeProvider = provider;
        this.gsonProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final SharedPrefCashierConfig get() {
        return newInstance(this.preferenceFacadeProvider.get(), this.gsonProvider.get());
    }

    public static SharedPrefCashierConfig_Factory create(Provider<PreferenceFacade> provider, Provider<Gson> provider2) {
        return new SharedPrefCashierConfig_Factory(provider, provider2);
    }

    public static SharedPrefCashierConfig newInstance(PreferenceFacade preferenceFacade, Gson gson) {
        return new SharedPrefCashierConfig(preferenceFacade, gson);
    }
}

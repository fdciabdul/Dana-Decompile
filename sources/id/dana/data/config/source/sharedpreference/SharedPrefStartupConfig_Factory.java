package id.dana.data.config.source.sharedpreference;

import com.google.gson.Gson;
import dagger.internal.Factory;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SharedPrefStartupConfig_Factory implements Factory<SharedPrefStartupConfig> {
    private final Provider<Gson> gsonProvider;
    private final Provider<PreferenceFacade> preferenceFacadeProvider;

    public SharedPrefStartupConfig_Factory(Provider<PreferenceFacade> provider, Provider<Gson> provider2) {
        this.preferenceFacadeProvider = provider;
        this.gsonProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final SharedPrefStartupConfig get() {
        return newInstance(this.preferenceFacadeProvider.get(), this.gsonProvider.get());
    }

    public static SharedPrefStartupConfig_Factory create(Provider<PreferenceFacade> provider, Provider<Gson> provider2) {
        return new SharedPrefStartupConfig_Factory(provider, provider2);
    }

    public static SharedPrefStartupConfig newInstance(PreferenceFacade preferenceFacade, Gson gson) {
        return new SharedPrefStartupConfig(preferenceFacade, gson);
    }
}

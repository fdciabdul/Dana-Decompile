package id.dana.data.tracker;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.tracker.repository.source.local.MixpanelPreferences;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MixpanelEntityRepository_Factory implements Factory<MixpanelEntityRepository> {
    private final Provider<Context> contextProvider;
    private final Provider<MixpanelPreferences> mixpanelPreferencesProvider;

    public MixpanelEntityRepository_Factory(Provider<Context> provider, Provider<MixpanelPreferences> provider2) {
        this.contextProvider = provider;
        this.mixpanelPreferencesProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final MixpanelEntityRepository get() {
        return newInstance(this.contextProvider.get(), this.mixpanelPreferencesProvider.get());
    }

    public static MixpanelEntityRepository_Factory create(Provider<Context> provider, Provider<MixpanelPreferences> provider2) {
        return new MixpanelEntityRepository_Factory(provider, provider2);
    }

    public static MixpanelEntityRepository newInstance(Context context, MixpanelPreferences mixpanelPreferences) {
        return new MixpanelEntityRepository(context, mixpanelPreferences);
    }
}

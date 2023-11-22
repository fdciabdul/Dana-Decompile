package id.dana.data.here;

import com.google.gson.Gson;
import dagger.internal.Factory;
import id.dana.data.here.source.local.HereAuthenticationPreference;
import id.dana.data.here.source.network.HereTokenApi;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.tracker.HereApiMixpanelTracker;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HereOauthManager_Factory implements Factory<HereOauthManager> {
    private final Provider<Gson> gsonProvider;
    private final Provider<HereAuthenticationPreference> hereAuthenticationPreferenceProvider;
    private final Provider<HereApiMixpanelTracker> hereMixPanelTrackerProvider;
    private final Provider<HereTokenApi> hereTokenApiProvider;
    private final Provider<SplitFacade> splitFacadeProvider;

    public HereOauthManager_Factory(Provider<HereTokenApi> provider, Provider<HereAuthenticationPreference> provider2, Provider<HereApiMixpanelTracker> provider3, Provider<Gson> provider4, Provider<SplitFacade> provider5) {
        this.hereTokenApiProvider = provider;
        this.hereAuthenticationPreferenceProvider = provider2;
        this.hereMixPanelTrackerProvider = provider3;
        this.gsonProvider = provider4;
        this.splitFacadeProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final HereOauthManager get() {
        return newInstance(this.hereTokenApiProvider.get(), this.hereAuthenticationPreferenceProvider.get(), this.hereMixPanelTrackerProvider.get(), this.gsonProvider.get(), this.splitFacadeProvider.get());
    }

    public static HereOauthManager_Factory create(Provider<HereTokenApi> provider, Provider<HereAuthenticationPreference> provider2, Provider<HereApiMixpanelTracker> provider3, Provider<Gson> provider4, Provider<SplitFacade> provider5) {
        return new HereOauthManager_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static HereOauthManager newInstance(HereTokenApi hereTokenApi, HereAuthenticationPreference hereAuthenticationPreference, HereApiMixpanelTracker hereApiMixpanelTracker, Gson gson, SplitFacade splitFacade) {
        return new HereOauthManager(hereTokenApi, hereAuthenticationPreference, hereApiMixpanelTracker, gson, splitFacade);
    }
}

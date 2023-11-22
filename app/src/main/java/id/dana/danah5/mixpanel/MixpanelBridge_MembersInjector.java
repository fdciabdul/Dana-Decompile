package id.dana.danah5.mixpanel;

import dagger.MembersInjector;
import id.dana.data.toggle.SplitFacade;
import id.dana.domain.services.interactor.GetService;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MixpanelBridge_MembersInjector implements MembersInjector<MixpanelBridge> {
    private final Provider<GetService> getServiceProvider;
    private final Provider<SplitFacade> splitFacadeProvider;

    public MixpanelBridge_MembersInjector(Provider<SplitFacade> provider, Provider<GetService> provider2) {
        this.splitFacadeProvider = provider;
        this.getServiceProvider = provider2;
    }

    public static MembersInjector<MixpanelBridge> create(Provider<SplitFacade> provider, Provider<GetService> provider2) {
        return new MixpanelBridge_MembersInjector(provider, provider2);
    }

    public final void injectMembers(MixpanelBridge mixpanelBridge) {
        StrictBaseBridge_MembersInjector.injectSplitFacade(mixpanelBridge, this.splitFacadeProvider.get());
        injectGetService(mixpanelBridge, this.getServiceProvider.get());
    }

    public static void injectGetService(MixpanelBridge mixpanelBridge, GetService getService) {
        mixpanelBridge.getService = getService;
    }
}

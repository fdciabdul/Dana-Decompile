package id.dana.danah5.mixpanel;

import dagger.MembersInjector;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class StrictBaseBridge_MembersInjector implements MembersInjector<StrictBaseBridge> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public StrictBaseBridge_MembersInjector(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    public static MembersInjector<StrictBaseBridge> create(Provider<SplitFacade> provider) {
        return new StrictBaseBridge_MembersInjector(provider);
    }

    public final void injectMembers(StrictBaseBridge strictBaseBridge) {
        injectSplitFacade(strictBaseBridge, this.splitFacadeProvider.get());
    }

    public static void injectSplitFacade(StrictBaseBridge strictBaseBridge, SplitFacade splitFacade) {
        strictBaseBridge.splitFacade = splitFacade;
    }
}

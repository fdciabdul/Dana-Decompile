package id.dana.danah5.locationpicker;

import dagger.MembersInjector;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MapsUtilityBridge_MembersInjector implements MembersInjector<MapsUtilityBridge> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public MapsUtilityBridge_MembersInjector(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    public static MembersInjector<MapsUtilityBridge> create(Provider<SplitFacade> provider) {
        return new MapsUtilityBridge_MembersInjector(provider);
    }

    public final void injectMembers(MapsUtilityBridge mapsUtilityBridge) {
        injectSplitFacade(mapsUtilityBridge, this.splitFacadeProvider.get());
    }

    public static void injectSplitFacade(MapsUtilityBridge mapsUtilityBridge, SplitFacade splitFacade) {
        mapsUtilityBridge.splitFacade = splitFacade;
    }
}

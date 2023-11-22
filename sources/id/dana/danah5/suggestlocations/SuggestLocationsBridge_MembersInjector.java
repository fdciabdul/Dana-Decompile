package id.dana.danah5.suggestlocations;

import dagger.MembersInjector;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.nearbyplaces.interactor.GetListSuggestedLocations;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SuggestLocationsBridge_MembersInjector implements MembersInjector<SuggestLocationsBridge> {
    private final Provider<DeviceInformationProvider> deviceInformationProvider;
    private final Provider<GetListSuggestedLocations> getListSuggestedLocationsProvider;

    public SuggestLocationsBridge_MembersInjector(Provider<GetListSuggestedLocations> provider, Provider<DeviceInformationProvider> provider2) {
        this.getListSuggestedLocationsProvider = provider;
        this.deviceInformationProvider = provider2;
    }

    public static MembersInjector<SuggestLocationsBridge> create(Provider<GetListSuggestedLocations> provider, Provider<DeviceInformationProvider> provider2) {
        return new SuggestLocationsBridge_MembersInjector(provider, provider2);
    }

    public final void injectMembers(SuggestLocationsBridge suggestLocationsBridge) {
        injectGetListSuggestedLocations(suggestLocationsBridge, this.getListSuggestedLocationsProvider.get());
        injectDeviceInformationProvider(suggestLocationsBridge, this.deviceInformationProvider.get());
    }

    public static void injectGetListSuggestedLocations(SuggestLocationsBridge suggestLocationsBridge, GetListSuggestedLocations getListSuggestedLocations) {
        suggestLocationsBridge.getListSuggestedLocations = getListSuggestedLocations;
    }

    public static void injectDeviceInformationProvider(SuggestLocationsBridge suggestLocationsBridge, DeviceInformationProvider deviceInformationProvider) {
        suggestLocationsBridge.deviceInformationProvider = deviceInformationProvider;
    }
}

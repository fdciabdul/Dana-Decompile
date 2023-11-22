package id.dana.danah5.location;

import dagger.MembersInjector;
import id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetLocationNameBridge_MembersInjector implements MembersInjector<GetLocationNameBridge> {
    private final Provider<GetIndoSubdivisionsByLocation> getIndoSubdivisionsByLocationProvider;

    public GetLocationNameBridge_MembersInjector(Provider<GetIndoSubdivisionsByLocation> provider) {
        this.getIndoSubdivisionsByLocationProvider = provider;
    }

    public static MembersInjector<GetLocationNameBridge> create(Provider<GetIndoSubdivisionsByLocation> provider) {
        return new GetLocationNameBridge_MembersInjector(provider);
    }

    public final void injectMembers(GetLocationNameBridge getLocationNameBridge) {
        injectGetIndoSubdivisionsByLocation(getLocationNameBridge, this.getIndoSubdivisionsByLocationProvider.get());
    }

    public static void injectGetIndoSubdivisionsByLocation(GetLocationNameBridge getLocationNameBridge, GetIndoSubdivisionsByLocation getIndoSubdivisionsByLocation) {
        getLocationNameBridge.getIndoSubdivisionsByLocation = getIndoSubdivisionsByLocation;
    }
}

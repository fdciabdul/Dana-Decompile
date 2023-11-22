package id.dana.danah5.locationpicker.presenter;

import dagger.internal.Factory;
import id.dana.danah5.locationpicker.contract.MapPageContract;
import id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class MapPagePresenter_Factory implements Factory<MapPagePresenter> {
    private final Provider<GetIndoSubdivisionsByLocation> getIndoSubdivisionsByLocationProvider;
    private final Provider<MapPageContract.View> viewProvider;

    public MapPagePresenter_Factory(Provider<MapPageContract.View> provider, Provider<GetIndoSubdivisionsByLocation> provider2) {
        this.viewProvider = provider;
        this.getIndoSubdivisionsByLocationProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final MapPagePresenter get() {
        return newInstance(this.viewProvider.get(), this.getIndoSubdivisionsByLocationProvider.get());
    }

    public static MapPagePresenter_Factory create(Provider<MapPageContract.View> provider, Provider<GetIndoSubdivisionsByLocation> provider2) {
        return new MapPagePresenter_Factory(provider, provider2);
    }

    public static MapPagePresenter newInstance(MapPageContract.View view, GetIndoSubdivisionsByLocation getIndoSubdivisionsByLocation) {
        return new MapPagePresenter(view, getIndoSubdivisionsByLocation);
    }
}

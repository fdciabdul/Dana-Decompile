package id.dana.danah5.locationpicker.presenter;

import android.location.Location;
import id.dana.base.AbstractContractKt;
import id.dana.danah5.locationpicker.contract.MapPageContract;
import id.dana.danah5.locationpicker.model.MapPageResult;
import id.dana.domain.DefaultObserver;
import id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation;
import id.dana.domain.geocode.model.IndoSubdivisions;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/danah5/locationpicker/presenter/MapPagePresenter;", "Lid/dana/danah5/locationpicker/contract/MapPageContract$Presenter;", "Landroid/location/Location;", "location", "Lid/dana/danah5/locationpicker/presenter/MapPagePresenter$createDetailLocationObserver$1;", "createDetailLocationObserver", "(Landroid/location/Location;)Lid/dana/danah5/locationpicker/presenter/MapPagePresenter$createDetailLocationObserver$1;", "Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation$Params;", "createDetailLocationParam", "(Landroid/location/Location;)Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation$Params;", "", "getDetailLocation", "(Landroid/location/Location;)V", "onDestroy", "()V", "Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation;", "getIndoSubdivisionsByLocation", "Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation;", "Lid/dana/danah5/locationpicker/contract/MapPageContract$View;", "view", "Lid/dana/danah5/locationpicker/contract/MapPageContract$View;", "<init>", "(Lid/dana/danah5/locationpicker/contract/MapPageContract$View;Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MapPagePresenter implements MapPageContract.Presenter {
    private final GetIndoSubdivisionsByLocation getIndoSubdivisionsByLocation;
    private final MapPageContract.View view;

    @Inject
    public MapPagePresenter(MapPageContract.View view, GetIndoSubdivisionsByLocation getIndoSubdivisionsByLocation) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getIndoSubdivisionsByLocation, "");
        this.view = view;
        this.getIndoSubdivisionsByLocation = getIndoSubdivisionsByLocation;
    }

    @Override // id.dana.danah5.locationpicker.contract.MapPageContract.Presenter
    public final void getDetailLocation(Location location) {
        Intrinsics.checkNotNullParameter(location, "");
        this.view.showProgress();
        this.getIndoSubdivisionsByLocation.execute(createDetailLocationObserver(location), createDetailLocationParam(location));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.danah5.locationpicker.presenter.MapPagePresenter$createDetailLocationObserver$1] */
    private final MapPagePresenter$createDetailLocationObserver$1 createDetailLocationObserver(final Location location) {
        return new DefaultObserver<IndoSubdivisions>() { // from class: id.dana.danah5.locationpicker.presenter.MapPagePresenter$createDetailLocationObserver$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onNext(IndoSubdivisions indoSubdivisions) {
                MapPageContract.View view;
                MapPageContract.View view2;
                Intrinsics.checkNotNullParameter(indoSubdivisions, "");
                view = MapPagePresenter.this.view;
                view.dismissProgress();
                MapPageResult mapPageResult = new MapPageResult(location.getLatitude(), location.getLongitude(), indoSubdivisions.getCountryCode(), indoSubdivisions.getCountryName(), indoSubdivisions.getProviceName(), indoSubdivisions.getCityName(), indoSubdivisions.getDistrictName(), indoSubdivisions.getSubdistrictName(), indoSubdivisions.getStreetName(), indoSubdivisions.getPostalCode());
                view2 = MapPagePresenter.this.view;
                view2.onGetDetailLocationSuccess(mapPageResult);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable e) {
                MapPageContract.View view;
                MapPageContract.View view2;
                Intrinsics.checkNotNullParameter(e, "");
                view = MapPagePresenter.this.view;
                view.dismissProgress();
                view2 = MapPagePresenter.this.view;
                view2.onError(e.getMessage());
            }
        };
    }

    private final GetIndoSubdivisionsByLocation.Params createDetailLocationParam(Location location) {
        GetIndoSubdivisionsByLocation.Params.Companion companion = GetIndoSubdivisionsByLocation.Params.INSTANCE;
        HereMixPanelTrackerData hereMixPanelTrackerData = new HereMixPanelTrackerData(null, null, false, null, null, 31, null);
        hereMixPanelTrackerData.setSource("JSAPI");
        Unit unit = Unit.INSTANCE;
        return GetIndoSubdivisionsByLocation.Params.Companion.forLocation$default(companion, location, false, false, hereMixPanelTrackerData, true, 6, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.getIndoSubdivisionsByLocation.dispose();
    }
}

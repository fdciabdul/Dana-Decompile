package pl.charmas.android.reactivelocation2.observables.location;

import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import java.lang.ref.WeakReference;
import pl.charmas.android.reactivelocation2.observables.BaseLocationObservableOnSubscribe;
import pl.charmas.android.reactivelocation2.observables.ObservableContext;
import pl.charmas.android.reactivelocation2.observables.ObservableFactory;

/* loaded from: classes6.dex */
public class LocationUpdatesObservableOnSubscribe extends BaseLocationObservableOnSubscribe<Location> {
    private LocationListener MyBillsEntityDataFactory;
    private final LocationRequest PlaceComponentResult;

    public static Observable<Location> BuiltInFictitiousFunctionClassFactory(ObservableContext observableContext, ObservableFactory observableFactory, LocationRequest locationRequest) {
        Observable<Location> compose = Observable.create(new LocationUpdatesObservableOnSubscribe(observableContext, locationRequest)).compose(new ObservableFactory.RetryOnConnectionSuspension(observableFactory.getAuthRequestContext.getAuthRequestContext()));
        int numUpdates = locationRequest.getNumUpdates();
        return (numUpdates <= 0 || numUpdates >= Integer.MAX_VALUE) ? compose : compose.take(numUpdates);
    }

    private LocationUpdatesObservableOnSubscribe(ObservableContext observableContext, LocationRequest locationRequest) {
        super(observableContext);
        this.PlaceComponentResult = locationRequest;
    }

    @Override // pl.charmas.android.reactivelocation2.observables.BaseObservableOnSubscribe
    public final void KClassImpl$Data$declaredNonStaticMembers$2(GoogleApiClient googleApiClient, ObservableEmitter<? super Location> observableEmitter) {
        this.MyBillsEntityDataFactory = new LocationUpdatesLocationListener(observableEmitter);
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, this.PlaceComponentResult, this.MyBillsEntityDataFactory);
    }

    @Override // pl.charmas.android.reactivelocation2.observables.BaseObservableOnSubscribe
    public final void getAuthRequestContext(GoogleApiClient googleApiClient) {
        if (googleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this.MyBillsEntityDataFactory);
        }
    }

    /* loaded from: classes6.dex */
    static class LocationUpdatesLocationListener implements LocationListener {
        private final WeakReference<ObservableEmitter<? super Location>> getAuthRequestContext;

        LocationUpdatesLocationListener(ObservableEmitter<? super Location> observableEmitter) {
            this.getAuthRequestContext = new WeakReference<>(observableEmitter);
        }

        @Override // com.google.android.gms.location.LocationListener
        public void onLocationChanged(Location location) {
            ObservableEmitter<? super Location> observableEmitter = this.getAuthRequestContext.get();
            if (observableEmitter == null || observableEmitter.isDisposed()) {
                return;
            }
            observableEmitter.onNext(location);
        }
    }
}

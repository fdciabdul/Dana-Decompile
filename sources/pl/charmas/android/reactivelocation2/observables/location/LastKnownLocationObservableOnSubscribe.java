package pl.charmas.android.reactivelocation2.observables.location;

import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import pl.charmas.android.reactivelocation2.observables.BaseLocationObservableOnSubscribe;
import pl.charmas.android.reactivelocation2.observables.ObservableContext;
import pl.charmas.android.reactivelocation2.observables.ObservableFactory;

/* loaded from: classes2.dex */
public class LastKnownLocationObservableOnSubscribe extends BaseLocationObservableOnSubscribe<Location> {
    public static Observable<Location> MyBillsEntityDataFactory(ObservableContext observableContext, ObservableFactory observableFactory) {
        return Observable.create(new LastKnownLocationObservableOnSubscribe(observableContext)).compose(new ObservableFactory.RetryOnConnectionSuspension(observableFactory.getAuthRequestContext.getAuthRequestContext()));
    }

    private LastKnownLocationObservableOnSubscribe(ObservableContext observableContext) {
        super(observableContext);
    }

    @Override // pl.charmas.android.reactivelocation2.observables.BaseObservableOnSubscribe
    public final void KClassImpl$Data$declaredNonStaticMembers$2(GoogleApiClient googleApiClient, ObservableEmitter<? super Location> observableEmitter) {
        Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if (observableEmitter.isDisposed()) {
            return;
        }
        if (lastLocation != null) {
            observableEmitter.onNext(lastLocation);
        }
        observableEmitter.onComplete();
    }
}

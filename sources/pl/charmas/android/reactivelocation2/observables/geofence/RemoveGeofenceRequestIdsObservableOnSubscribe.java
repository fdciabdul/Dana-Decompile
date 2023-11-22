package pl.charmas.android.reactivelocation2.observables.geofence;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationServices;
import io.reactivex.ObservableEmitter;
import java.util.List;
import pl.charmas.android.reactivelocation2.observables.StatusException;

/* loaded from: classes9.dex */
class RemoveGeofenceRequestIdsObservableOnSubscribe extends RemoveGeofenceObservableOnSubscribe<Status> {
    private final List<String> BuiltInFictitiousFunctionClassFactory;

    @Override // pl.charmas.android.reactivelocation2.observables.geofence.RemoveGeofenceObservableOnSubscribe
    protected final void PlaceComponentResult(GoogleApiClient googleApiClient, final ObservableEmitter<? super Status> observableEmitter) {
        LocationServices.GeofencingApi.removeGeofences(googleApiClient, this.BuiltInFictitiousFunctionClassFactory).setResultCallback(new ResultCallback<Status>() { // from class: pl.charmas.android.reactivelocation2.observables.geofence.RemoveGeofenceRequestIdsObservableOnSubscribe.1
            @Override // com.google.android.gms.common.api.ResultCallback
            public /* synthetic */ void onResult(Status status) {
                Status status2 = status;
                if (observableEmitter.isDisposed()) {
                    return;
                }
                if (status2.isSuccess()) {
                    observableEmitter.onNext(status2);
                    observableEmitter.onComplete();
                    return;
                }
                observableEmitter.onError(new StatusException(status2));
            }
        });
    }
}

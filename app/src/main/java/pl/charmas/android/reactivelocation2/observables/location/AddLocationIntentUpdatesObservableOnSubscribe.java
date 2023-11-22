package pl.charmas.android.reactivelocation2.observables.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import io.reactivex.ObservableEmitter;
import pl.charmas.android.reactivelocation2.observables.BaseLocationObservableOnSubscribe;
import pl.charmas.android.reactivelocation2.observables.StatusException;

/* loaded from: classes9.dex */
public class AddLocationIntentUpdatesObservableOnSubscribe extends BaseLocationObservableOnSubscribe<Status> {
    private final PendingIntent BuiltInFictitiousFunctionClassFactory;
    private final LocationRequest KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // pl.charmas.android.reactivelocation2.observables.BaseObservableOnSubscribe
    public final void KClassImpl$Data$declaredNonStaticMembers$2(GoogleApiClient googleApiClient, final ObservableEmitter<? super Status> observableEmitter) {
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory).setResultCallback(new ResultCallback<Status>() { // from class: pl.charmas.android.reactivelocation2.observables.location.AddLocationIntentUpdatesObservableOnSubscribe.1
            @Override // com.google.android.gms.common.api.ResultCallback
            public /* synthetic */ void onResult(Status status) {
                Status status2 = status;
                if (observableEmitter.isDisposed()) {
                    return;
                }
                if (!status2.isSuccess()) {
                    observableEmitter.onError(new StatusException(status2));
                    return;
                }
                observableEmitter.onNext(status2);
                observableEmitter.onComplete();
            }
        });
    }
}

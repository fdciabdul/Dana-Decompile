package pl.charmas.android.reactivelocation2.observables.geofence;

import com.google.android.gms.common.api.GoogleApiClient;
import io.reactivex.ObservableEmitter;
import pl.charmas.android.reactivelocation2.observables.BaseLocationObservableOnSubscribe;

/* loaded from: classes9.dex */
public abstract class RemoveGeofenceObservableOnSubscribe<T> extends BaseLocationObservableOnSubscribe<T> {
    protected abstract void PlaceComponentResult(GoogleApiClient googleApiClient, ObservableEmitter<? super T> observableEmitter);

    @Override // pl.charmas.android.reactivelocation2.observables.BaseObservableOnSubscribe
    public final void KClassImpl$Data$declaredNonStaticMembers$2(GoogleApiClient googleApiClient, ObservableEmitter<? super T> observableEmitter) {
        PlaceComponentResult(googleApiClient, observableEmitter);
    }
}

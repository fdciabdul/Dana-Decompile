package pl.charmas.android.reactivelocation2.observables.location;

import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationServices;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import pl.charmas.android.reactivelocation2.observables.BaseLocationObservableOnSubscribe;
import pl.charmas.android.reactivelocation2.observables.StatusException;

/* loaded from: classes9.dex */
public class MockLocationObservableOnSubscribe extends BaseLocationObservableOnSubscribe<Status> {
    private final Observable<Location> KClassImpl$Data$declaredNonStaticMembers$2;
    private Disposable MyBillsEntityDataFactory;

    @Override // pl.charmas.android.reactivelocation2.observables.BaseObservableOnSubscribe
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final GoogleApiClient googleApiClient, final ObservableEmitter<? super Status> observableEmitter) {
        LocationServices.FusedLocationApi.setMockMode(googleApiClient, true).setResultCallback(new ResultCallback<Status>() { // from class: pl.charmas.android.reactivelocation2.observables.location.MockLocationObservableOnSubscribe.1
            @Override // com.google.android.gms.common.api.ResultCallback
            public /* synthetic */ void onResult(Status status) {
                Status status2 = status;
                if (status2.isSuccess()) {
                    MockLocationObservableOnSubscribe.PlaceComponentResult(MockLocationObservableOnSubscribe.this, googleApiClient, observableEmitter);
                } else {
                    observableEmitter.onError(new StatusException(status2));
                }
            }
        });
    }

    @Override // pl.charmas.android.reactivelocation2.observables.BaseObservableOnSubscribe
    public final void getAuthRequestContext(GoogleApiClient googleApiClient) {
        if (googleApiClient.isConnected()) {
            try {
                LocationServices.FusedLocationApi.setMockMode(googleApiClient, false);
            } catch (SecurityException unused) {
            }
        }
        Disposable disposable = this.MyBillsEntityDataFactory;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.MyBillsEntityDataFactory.dispose();
    }

    static /* synthetic */ void PlaceComponentResult(MockLocationObservableOnSubscribe mockLocationObservableOnSubscribe, final GoogleApiClient googleApiClient, final ObservableEmitter observableEmitter) {
        mockLocationObservableOnSubscribe.MyBillsEntityDataFactory = mockLocationObservableOnSubscribe.KClassImpl$Data$declaredNonStaticMembers$2.subscribe(new Consumer<Location>() { // from class: pl.charmas.android.reactivelocation2.observables.location.MockLocationObservableOnSubscribe.2
            @Override // io.reactivex.functions.Consumer
            public /* synthetic */ void accept(Location location) throws Exception {
                LocationServices.FusedLocationApi.setMockLocation(googleApiClient, location).setResultCallback(new ResultCallback<Status>() { // from class: pl.charmas.android.reactivelocation2.observables.location.MockLocationObservableOnSubscribe.2.1
                    @Override // com.google.android.gms.common.api.ResultCallback
                    public /* synthetic */ void onResult(Status status) {
                        Status status2 = status;
                        if (status2.isSuccess()) {
                            observableEmitter.onNext(status2);
                        } else {
                            observableEmitter.onError(new StatusException(status2));
                        }
                    }
                });
            }
        }, new Consumer<Throwable>() { // from class: pl.charmas.android.reactivelocation2.observables.location.MockLocationObservableOnSubscribe.3
            @Override // io.reactivex.functions.Consumer
            public /* synthetic */ void accept(Throwable th) throws Exception {
                observableEmitter.onError(th);
            }
        }, new Action() { // from class: pl.charmas.android.reactivelocation2.observables.location.MockLocationObservableOnSubscribe.4
            @Override // io.reactivex.functions.Action
            public void run() throws Exception {
                observableEmitter.onComplete();
            }
        });
    }
}

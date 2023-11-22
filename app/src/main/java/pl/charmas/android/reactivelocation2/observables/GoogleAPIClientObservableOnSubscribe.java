package pl.charmas.android.reactivelocation2.observables;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import pl.charmas.android.reactivelocation2.observables.ObservableFactory;

/* loaded from: classes6.dex */
public class GoogleAPIClientObservableOnSubscribe extends BaseObservableOnSubscribe<GoogleApiClient> {
    @SafeVarargs
    public static Observable<GoogleApiClient> KClassImpl$Data$declaredNonStaticMembers$2(ObservableContext observableContext, ObservableFactory observableFactory, Api<? extends Api.ApiOptions.NotRequiredOptions>... apiArr) {
        return Observable.create(new GoogleAPIClientObservableOnSubscribe(observableContext, apiArr)).compose(new ObservableFactory.RetryOnConnectionSuspension(observableFactory.getAuthRequestContext.getAuthRequestContext()));
    }

    @SafeVarargs
    private GoogleAPIClientObservableOnSubscribe(ObservableContext observableContext, Api<? extends Api.ApiOptions.NotRequiredOptions>... apiArr) {
        super(observableContext, apiArr);
    }

    @Override // pl.charmas.android.reactivelocation2.observables.BaseObservableOnSubscribe
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(GoogleApiClient googleApiClient, ObservableEmitter<? super GoogleApiClient> observableEmitter) {
        if (observableEmitter.isDisposed()) {
            return;
        }
        observableEmitter.onNext(googleApiClient);
    }
}

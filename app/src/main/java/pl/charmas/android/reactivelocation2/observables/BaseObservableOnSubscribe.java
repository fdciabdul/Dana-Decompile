package pl.charmas.android.reactivelocation2.observables;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseObservableOnSubscribe<T> implements ObservableOnSubscribe<T> {
    private final List<Api<? extends Api.ApiOptions.NotRequiredOptions>> BuiltInFictitiousFunctionClassFactory;
    private final Handler MyBillsEntityDataFactory;
    private final Context PlaceComponentResult;

    protected abstract void KClassImpl$Data$declaredNonStaticMembers$2(GoogleApiClient googleApiClient, ObservableEmitter<? super T> observableEmitter);

    protected void getAuthRequestContext(GoogleApiClient googleApiClient) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SafeVarargs
    public BaseObservableOnSubscribe(ObservableContext observableContext, Api<? extends Api.ApiOptions.NotRequiredOptions>... apiArr) {
        this.PlaceComponentResult = observableContext.KClassImpl$Data$declaredNonStaticMembers$2;
        this.MyBillsEntityDataFactory = observableContext.BuiltInFictitiousFunctionClassFactory;
        this.BuiltInFictitiousFunctionClassFactory = Arrays.asList(apiArr);
    }

    /* loaded from: classes6.dex */
    class ApiClientConnectionCallbacks implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private final ObservableEmitter<? super T> BuiltInFictitiousFunctionClassFactory;
        GoogleApiClient MyBillsEntityDataFactory;

        /* synthetic */ ApiClientConnectionCallbacks(BaseObservableOnSubscribe baseObservableOnSubscribe, ObservableEmitter observableEmitter, byte b) {
            this(observableEmitter);
        }

        private ApiClientConnectionCallbacks(ObservableEmitter<? super T> observableEmitter) {
            this.BuiltInFictitiousFunctionClassFactory = observableEmitter;
        }

        @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
        public void onConnected(Bundle bundle) {
            try {
                BaseObservableOnSubscribe.this.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
            } catch (Throwable th) {
                if (this.BuiltInFictitiousFunctionClassFactory.isDisposed()) {
                    return;
                }
                this.BuiltInFictitiousFunctionClassFactory.onError(th);
            }
        }

        @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
        public void onConnectionSuspended(int i) {
            if (this.BuiltInFictitiousFunctionClassFactory.isDisposed()) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory.onError(new GoogleAPIConnectionSuspendedException(i));
        }

        @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult connectionResult) {
            if (this.BuiltInFictitiousFunctionClassFactory.isDisposed()) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory.onError(new GoogleAPIConnectionException("Error connecting to GoogleApiClient.", connectionResult));
        }
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public void subscribe(ObservableEmitter<T> observableEmitter) throws Exception {
        ApiClientConnectionCallbacks apiClientConnectionCallbacks = new ApiClientConnectionCallbacks(this, observableEmitter, (byte) 0);
        GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.PlaceComponentResult);
        Iterator<Api<? extends Api.ApiOptions.NotRequiredOptions>> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            builder = builder.addApi(it.next());
        }
        GoogleApiClient.Builder addOnConnectionFailedListener = builder.addConnectionCallbacks(apiClientConnectionCallbacks).addOnConnectionFailedListener(apiClientConnectionCallbacks);
        Handler handler = this.MyBillsEntityDataFactory;
        if (handler != null) {
            addOnConnectionFailedListener = addOnConnectionFailedListener.setHandler(handler);
        }
        final GoogleApiClient build = addOnConnectionFailedListener.build();
        apiClientConnectionCallbacks.MyBillsEntityDataFactory = build;
        try {
            build.connect();
        } catch (Throwable th) {
            if (!observableEmitter.isDisposed()) {
                observableEmitter.onError(th);
            }
        }
        observableEmitter.setDisposable(Disposables.BuiltInFictitiousFunctionClassFactory(new Action() { // from class: pl.charmas.android.reactivelocation2.observables.BaseObservableOnSubscribe.1
            @Override // io.reactivex.functions.Action
            public void run() throws Exception {
                BaseObservableOnSubscribe.this.getAuthRequestContext(build);
                build.disconnect();
            }
        }));
    }
}

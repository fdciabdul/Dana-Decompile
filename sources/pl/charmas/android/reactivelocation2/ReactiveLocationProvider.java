package pl.charmas.android.reactivelocation2;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLngBounds;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import pl.charmas.android.reactivelocation2.observables.GoogleAPIClientObservableOnSubscribe;
import pl.charmas.android.reactivelocation2.observables.ObservableContext;
import pl.charmas.android.reactivelocation2.observables.ObservableFactory;
import pl.charmas.android.reactivelocation2.observables.PendingResultObservableOnSubscribe;

/* loaded from: classes2.dex */
public class ReactiveLocationProvider {
    public final ObservableFactory KClassImpl$Data$declaredNonStaticMembers$2;
    public final ObservableContext MyBillsEntityDataFactory;

    public ReactiveLocationProvider(Context context) {
        this(context, new ReactiveLocationProviderConfiguration(ReactiveLocationProviderConfiguration.PlaceComponentResult(), (byte) 0));
    }

    private ReactiveLocationProvider(Context context, ReactiveLocationProviderConfiguration reactiveLocationProviderConfiguration) {
        ObservableContext observableContext = new ObservableContext(context, reactiveLocationProviderConfiguration);
        this.MyBillsEntityDataFactory = observableContext;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ObservableFactory(observableContext);
    }

    public final Observable<LocationSettingsResult> BuiltInFictitiousFunctionClassFactory(final LocationSettingsRequest locationSettingsRequest) {
        Observable<GoogleApiClient> compose;
        compose = Observable.create(new GoogleAPIClientObservableOnSubscribe(this.MyBillsEntityDataFactory, LocationServices.API)).compose(new ObservableFactory.RetryOnConnectionSuspension(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getAuthRequestContext()));
        return compose.flatMap(new Function<GoogleApiClient, Observable<LocationSettingsResult>>() { // from class: pl.charmas.android.reactivelocation2.ReactiveLocationProvider.1
            {
                ReactiveLocationProvider.this = this;
            }

            @Override // io.reactivex.functions.Function
            public /* synthetic */ Observable<LocationSettingsResult> apply(GoogleApiClient googleApiClient) throws Exception {
                return ReactiveLocationProvider.PlaceComponentResult(LocationServices.SettingsApi.checkLocationSettings(googleApiClient, locationSettingsRequest));
            }
        });
    }

    /* renamed from: pl.charmas.android.reactivelocation2.ReactiveLocationProvider$2 */
    /* loaded from: classes2.dex */
    class AnonymousClass2 implements Function<GoogleApiClient, Observable<PlaceLikelihoodBuffer>> {
        final /* synthetic */ PlaceFilter BuiltInFictitiousFunctionClassFactory;

        @Override // io.reactivex.functions.Function
        public /* synthetic */ Observable<PlaceLikelihoodBuffer> apply(GoogleApiClient googleApiClient) throws Exception {
            return ReactiveLocationProvider.PlaceComponentResult(Places.PlaceDetectionApi.getCurrentPlace(googleApiClient, this.BuiltInFictitiousFunctionClassFactory));
        }
    }

    /* renamed from: pl.charmas.android.reactivelocation2.ReactiveLocationProvider$3 */
    /* loaded from: classes2.dex */
    class AnonymousClass3 implements Function<GoogleApiClient, Observable<PlaceBuffer>> {
        final /* synthetic */ String getAuthRequestContext;

        @Override // io.reactivex.functions.Function
        public /* synthetic */ Observable<PlaceBuffer> apply(GoogleApiClient googleApiClient) throws Exception {
            return ReactiveLocationProvider.PlaceComponentResult(Places.GeoDataApi.getPlaceById(googleApiClient, new String[]{this.getAuthRequestContext}));
        }
    }

    /* renamed from: pl.charmas.android.reactivelocation2.ReactiveLocationProvider$4 */
    /* loaded from: classes2.dex */
    class AnonymousClass4 implements Function<GoogleApiClient, Observable<AutocompletePredictionBuffer>> {
        final /* synthetic */ AutocompleteFilter BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ LatLngBounds KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ String getAuthRequestContext;

        @Override // io.reactivex.functions.Function
        public /* synthetic */ Observable<AutocompletePredictionBuffer> apply(GoogleApiClient googleApiClient) throws Exception {
            return ReactiveLocationProvider.PlaceComponentResult(Places.GeoDataApi.getAutocompletePredictions(googleApiClient, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory));
        }
    }

    /* renamed from: pl.charmas.android.reactivelocation2.ReactiveLocationProvider$5 */
    /* loaded from: classes2.dex */
    class AnonymousClass5 implements Function<GoogleApiClient, Observable<PlacePhotoMetadataResult>> {
        final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // io.reactivex.functions.Function
        public /* synthetic */ Observable<PlacePhotoMetadataResult> apply(GoogleApiClient googleApiClient) throws Exception {
            return ReactiveLocationProvider.PlaceComponentResult(Places.GeoDataApi.getPlacePhotos(googleApiClient, this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    /* renamed from: pl.charmas.android.reactivelocation2.ReactiveLocationProvider$6 */
    /* loaded from: classes2.dex */
    class AnonymousClass6 implements Function<GoogleApiClient, Observable<PlacePhotoResult>> {
        final /* synthetic */ PlacePhotoMetadata MyBillsEntityDataFactory;

        @Override // io.reactivex.functions.Function
        public /* synthetic */ Observable<PlacePhotoResult> apply(GoogleApiClient googleApiClient) throws Exception {
            return ReactiveLocationProvider.PlaceComponentResult(this.MyBillsEntityDataFactory.getPhoto(googleApiClient));
        }
    }

    public static <T extends Result> Observable<T> PlaceComponentResult(PendingResult<T> pendingResult) {
        return Observable.create(new PendingResultObservableOnSubscribe(pendingResult));
    }
}

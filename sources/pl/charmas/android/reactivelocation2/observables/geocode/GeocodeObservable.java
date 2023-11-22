package pl.charmas.android.reactivelocation2.observables.geocode;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import com.google.android.gms.maps.model.LatLngBounds;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/* loaded from: classes9.dex */
public class GeocodeObservable implements ObservableOnSubscribe<List<Address>> {
    private final LatLngBounds BuiltInFictitiousFunctionClassFactory;
    private final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final Locale MyBillsEntityDataFactory;
    private final int PlaceComponentResult;
    private final Context getAuthRequestContext;

    @Override // io.reactivex.ObservableOnSubscribe
    public void subscribe(ObservableEmitter<List<Address>> observableEmitter) throws Exception {
        List<Address> fromLocationName;
        Geocoder geocoder = this.MyBillsEntityDataFactory != null ? new Geocoder(this.getAuthRequestContext, this.MyBillsEntityDataFactory) : new Geocoder(this.getAuthRequestContext);
        try {
            LatLngBounds latLngBounds = this.BuiltInFictitiousFunctionClassFactory;
            if (latLngBounds != null) {
                fromLocationName = geocoder.getFromLocationName(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, latLngBounds.southwest.latitude, this.BuiltInFictitiousFunctionClassFactory.southwest.longitude, this.BuiltInFictitiousFunctionClassFactory.northeast.latitude, this.BuiltInFictitiousFunctionClassFactory.northeast.longitude);
            } else {
                fromLocationName = geocoder.getFromLocationName(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
            }
            if (observableEmitter.isDisposed()) {
                return;
            }
            observableEmitter.onNext(fromLocationName);
            observableEmitter.onComplete();
        } catch (IOException e) {
            if (observableEmitter.isDisposed()) {
                return;
            }
            observableEmitter.onError(e);
        }
    }
}

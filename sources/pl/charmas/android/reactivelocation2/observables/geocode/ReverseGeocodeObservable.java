package pl.charmas.android.reactivelocation2.observables.geocode;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import pl.charmas.android.reactivelocation2.observables.ObservableEmitterWrapper;

/* loaded from: classes9.dex */
public class ReverseGeocodeObservable implements ObservableOnSubscribe<List<Address>> {
    private final int BuiltInFictitiousFunctionClassFactory;
    private final Locale KClassImpl$Data$declaredNonStaticMembers$2;
    private final double MyBillsEntityDataFactory;
    private final Context PlaceComponentResult;
    private final double getAuthRequestContext;

    @Override // io.reactivex.ObservableOnSubscribe
    public void subscribe(ObservableEmitter<List<Address>> observableEmitter) throws Exception {
        try {
            List<Address> fromLocation = new Geocoder(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2).getFromLocation(this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory);
            if (observableEmitter.isDisposed()) {
                return;
            }
            observableEmitter.onNext(fromLocation);
            observableEmitter.onComplete();
        } catch (IOException unused) {
            if (observableEmitter.isDisposed()) {
                return;
            }
            Observable.create(new FallbackReverseGeocodeObservable(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory)).subscribeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new ObservableEmitterWrapper(observableEmitter));
        }
    }
}

package pl.charmas.android.reactivelocation2.observables;

import com.google.android.gms.location.LocationServices;

/* loaded from: classes2.dex */
public abstract class BaseLocationObservableOnSubscribe<T> extends BaseObservableOnSubscribe<T> {
    public BaseLocationObservableOnSubscribe(ObservableContext observableContext) {
        super(observableContext, LocationServices.API);
    }
}

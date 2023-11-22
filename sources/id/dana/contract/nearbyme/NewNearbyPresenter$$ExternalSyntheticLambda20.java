package id.dana.contract.nearbyme;

import com.google.android.gms.location.LocationSettingsResult;
import io.reactivex.functions.Consumer;

/* loaded from: classes8.dex */
public final /* synthetic */ class NewNearbyPresenter$$ExternalSyntheticLambda20 implements Consumer {
    public final /* synthetic */ NewNearbyPresenter MyBillsEntityDataFactory;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object obj) {
        NewNearbyPresenter.PlaceComponentResult(this.MyBillsEntityDataFactory, (LocationSettingsResult) obj);
    }
}

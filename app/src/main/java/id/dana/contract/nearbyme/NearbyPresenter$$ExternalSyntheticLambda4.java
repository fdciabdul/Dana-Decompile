package id.dana.contract.nearbyme;

import com.google.android.gms.location.LocationSettingsResult;
import io.reactivex.functions.Consumer;

/* loaded from: classes8.dex */
public final /* synthetic */ class NearbyPresenter$$ExternalSyntheticLambda4 implements Consumer {
    public final /* synthetic */ NearbyPresenter getAuthRequestContext;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object obj) {
        NearbyPresenter.PlaceComponentResult(this.getAuthRequestContext, (LocationSettingsResult) obj);
    }
}

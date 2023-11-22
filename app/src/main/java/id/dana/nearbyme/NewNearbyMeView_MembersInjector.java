package id.dana.nearbyme;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.contract.nearbyme.NewNearbyMeContract;

/* loaded from: classes5.dex */
public final class NewNearbyMeView_MembersInjector implements MembersInjector<NewNearbyMeView> {
    public static void BuiltInFictitiousFunctionClassFactory(NewNearbyMeView newNearbyMeView, Lazy<NewNearbyMeContract.Presenter> lazy) {
        newNearbyMeView.presenter = lazy;
    }
}

package id.dana.richview;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.contract.maintenance.MaintenanceBroadcastContract;

/* loaded from: classes5.dex */
public final class MaintenanceBroadcastView_MembersInjector implements MembersInjector<MaintenanceBroadcastView> {
    public static void PlaceComponentResult(MaintenanceBroadcastView maintenanceBroadcastView, Lazy<MaintenanceBroadcastContract.Presenter> lazy) {
        maintenanceBroadcastView.presenter = lazy;
    }
}

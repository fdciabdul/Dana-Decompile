package id.dana.maintenance;

import dagger.MembersInjector;
import id.dana.maintenance.EmergencyNotifContract;

/* loaded from: classes5.dex */
public final class EmergencyNotifActivity_MembersInjector implements MembersInjector<EmergencyNotifActivity> {
    public static void PlaceComponentResult(EmergencyNotifActivity emergencyNotifActivity, EmergencyNotifContract.Presenter presenter) {
        emergencyNotifActivity.presenter = presenter;
    }
}

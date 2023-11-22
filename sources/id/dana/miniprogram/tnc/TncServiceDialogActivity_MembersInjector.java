package id.dana.miniprogram.tnc;

import dagger.MembersInjector;
import id.dana.data.tracker.UserConsentTracker;

/* loaded from: classes9.dex */
public final class TncServiceDialogActivity_MembersInjector implements MembersInjector<TncServiceDialogActivity> {
    public static void PlaceComponentResult(TncServiceDialogActivity tncServiceDialogActivity, UserConsentTracker userConsentTracker) {
        tncServiceDialogActivity.userConsentTracker = userConsentTracker;
    }
}

package id.dana.miniprogram.tnc;

import dagger.MembersInjector;
import id.dana.data.tracker.UserConsentTracker;
import id.dana.globalnetwork.currency.GlobalNetworkContract;

/* loaded from: classes5.dex */
public final class TncMiniProgramDialogActivity_MembersInjector implements MembersInjector<TncMiniProgramDialogActivity> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(TncMiniProgramDialogActivity tncMiniProgramDialogActivity, GlobalNetworkContract.Presenter presenter) {
        tncMiniProgramDialogActivity.presenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(TncMiniProgramDialogActivity tncMiniProgramDialogActivity, UserConsentTracker userConsentTracker) {
        tncMiniProgramDialogActivity.userConsentTracker = userConsentTracker;
    }
}

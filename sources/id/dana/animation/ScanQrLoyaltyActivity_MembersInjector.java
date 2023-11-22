package id.dana.animation;

import dagger.MembersInjector;
import id.dana.animation.ScanQrLoyaltyContract;
import id.dana.utils.TimerUtil;

/* loaded from: classes9.dex */
public final class ScanQrLoyaltyActivity_MembersInjector implements MembersInjector<ScanQrLoyaltyActivity> {
    public static void MyBillsEntityDataFactory(ScanQrLoyaltyActivity scanQrLoyaltyActivity, ScanQrLoyaltyContract.Presenter presenter) {
        scanQrLoyaltyActivity.presenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ScanQrLoyaltyActivity scanQrLoyaltyActivity, TimerUtil timerUtil) {
        scanQrLoyaltyActivity.timerUtil = timerUtil;
    }
}

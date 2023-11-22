package id.dana.initializer;

import dagger.MembersInjector;
import id.dana.toggle.userloginlogout.LoginLogoutObserver;

/* loaded from: classes2.dex */
public final class FirebaseCrashlyticsInitializer_MembersInjector implements MembersInjector<FirebaseCrashlyticsInitializer> {
    public static void PlaceComponentResult(FirebaseCrashlyticsInitializer firebaseCrashlyticsInitializer, LoginLogoutObserver loginLogoutObserver) {
        firebaseCrashlyticsInitializer.loginLogoutObserver = loginLogoutObserver;
    }
}

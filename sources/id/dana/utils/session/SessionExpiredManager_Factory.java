package id.dana.utils.session;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.AppLifeCycleObserver;
import id.dana.ApplicationOrientationCallback;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SessionExpiredManager_Factory implements Factory<SessionExpiredManager> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SessionManager> MyBillsEntityDataFactory;
    private final Provider<AppLifeCycleObserver> PlaceComponentResult;
    private final Provider<ApplicationOrientationCallback> getAuthRequestContext;

    private SessionExpiredManager_Factory(Provider<Context> provider, Provider<AppLifeCycleObserver> provider2, Provider<ApplicationOrientationCallback> provider3, Provider<SessionManager> provider4) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
        this.getAuthRequestContext = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static SessionExpiredManager_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<AppLifeCycleObserver> provider2, Provider<ApplicationOrientationCallback> provider3, Provider<SessionManager> provider4) {
        return new SessionExpiredManager_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SessionExpiredManager(DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}

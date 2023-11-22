package id.dana.data.foundation.facade;

import android.app.Application;
import dagger.internal.Factory;
import id.dana.data.foundation.amcs.AMCSManager;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class IAPPushFacade_Factory implements Factory<IAPPushFacade> {
    private final Provider<Application> BuiltInFictitiousFunctionClassFactory;
    private final Provider<AMCSManager> PlaceComponentResult;

    private IAPPushFacade_Factory(Provider<Application> provider, Provider<AMCSManager> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static IAPPushFacade_Factory getAuthRequestContext(Provider<Application> provider, Provider<AMCSManager> provider2) {
        return new IAPPushFacade_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new IAPPushFacade(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}

package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.h5event.CheckoutH5EventContract;

/* loaded from: classes4.dex */
public final class CheckoutH5EventModule_ProvideViewFactory implements Factory<CheckoutH5EventContract.View> {
    private final CheckoutH5EventModule getAuthRequestContext;

    private CheckoutH5EventModule_ProvideViewFactory(CheckoutH5EventModule checkoutH5EventModule) {
        this.getAuthRequestContext = checkoutH5EventModule;
    }

    public static CheckoutH5EventModule_ProvideViewFactory PlaceComponentResult(CheckoutH5EventModule checkoutH5EventModule) {
        return new CheckoutH5EventModule_ProvideViewFactory(checkoutH5EventModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CheckoutH5EventContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult());
    }
}

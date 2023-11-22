package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.h5event.CheckoutH5EventPresenter;

@Module
/* loaded from: classes4.dex */
public class CheckoutH5EventModule {
    private final CheckoutH5EventContract.View BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public CheckoutH5EventContract.Presenter PlaceComponentResult(CheckoutH5EventPresenter checkoutH5EventPresenter) {
        return checkoutH5EventPresenter;
    }

    public CheckoutH5EventModule(CheckoutH5EventContract.View view) {
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public CheckoutH5EventContract.View PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}

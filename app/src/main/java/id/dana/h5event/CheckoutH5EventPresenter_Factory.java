package id.dana.h5event;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.h5event.CheckoutH5EventContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CheckoutH5EventPresenter_Factory implements Factory<CheckoutH5EventPresenter> {
    private final Provider<GetCheckoutH5Event> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CheckoutH5EventContract.View> MyBillsEntityDataFactory;

    private CheckoutH5EventPresenter_Factory(Provider<GetCheckoutH5Event> provider, Provider<CheckoutH5EventContract.View> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static CheckoutH5EventPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<GetCheckoutH5Event> provider, Provider<CheckoutH5EventContract.View> provider2) {
        return new CheckoutH5EventPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CheckoutH5EventPresenter(DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}

package id.dana.h5event;

import dagger.Lazy;
import id.dana.domain.DefaultObserver;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.h5event.CheckoutH5EventContract;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class CheckoutH5EventPresenter implements CheckoutH5EventContract.Presenter {
    private final Lazy<CheckoutH5EventContract.View> MyBillsEntityDataFactory;
    private DefaultObserver<Boolean> PlaceComponentResult;
    private final Lazy<GetCheckoutH5Event> getAuthRequestContext;

    @Inject
    public CheckoutH5EventPresenter(Lazy<GetCheckoutH5Event> lazy, Lazy<CheckoutH5EventContract.View> lazy2) {
        this.getAuthRequestContext = lazy;
        this.MyBillsEntityDataFactory = lazy2;
    }

    @Override // id.dana.h5event.CheckoutH5EventContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        DefaultObserver<Boolean> defaultObserver = this.PlaceComponentResult;
        if (defaultObserver != null) {
            defaultObserver.dispose();
            this.PlaceComponentResult = null;
        }
    }

    @Override // id.dana.h5event.CheckoutH5EventContract.Presenter
    public final void MyBillsEntityDataFactory() {
        DefaultObserver<Boolean> defaultObserver = this.PlaceComponentResult;
        if (defaultObserver != null) {
            defaultObserver.dispose();
            this.PlaceComponentResult = null;
        }
        GetCheckoutH5Event getCheckoutH5Event = this.getAuthRequestContext.get();
        if (this.PlaceComponentResult == null) {
            this.PlaceComponentResult = new DefaultObserver<Boolean>() { // from class: id.dana.h5event.CheckoutH5EventPresenter.1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public /* synthetic */ void onNext(Object obj) {
                    ((CheckoutH5EventContract.View) CheckoutH5EventPresenter.this.MyBillsEntityDataFactory.get()).getAuthRequestContext(((Boolean) obj).booleanValue());
                }
            };
        }
        getCheckoutH5Event.execute(this.PlaceComponentResult);
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        DefaultObserver<Boolean> defaultObserver = this.PlaceComponentResult;
        if (defaultObserver != null) {
            defaultObserver.dispose();
            this.PlaceComponentResult = null;
        }
        this.getAuthRequestContext.get().dispose();
    }
}

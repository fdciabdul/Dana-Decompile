package id.dana.h5event;

import id.dana.domain.DefaultObserver;
import id.dana.domain.h5event.interactor.GetChangePhoneNumberH5Event;
import id.dana.h5event.ChangePhoneNumberH5EventContract;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ChangePhoneNumberH5EventPresenter implements ChangePhoneNumberH5EventContract.Presenter {
    private final ChangePhoneNumberH5EventContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetChangePhoneNumberH5Event MyBillsEntityDataFactory;
    private DefaultObserver<Boolean> PlaceComponentResult;

    @Inject
    public ChangePhoneNumberH5EventPresenter(GetChangePhoneNumberH5Event getChangePhoneNumberH5Event, ChangePhoneNumberH5EventContract.View view) {
        this.MyBillsEntityDataFactory = getChangePhoneNumberH5Event;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    @Override // id.dana.h5event.ChangePhoneNumberH5EventContract.Presenter
    public final void MyBillsEntityDataFactory() {
        DefaultObserver<Boolean> defaultObserver = this.PlaceComponentResult;
        if (defaultObserver != null) {
            defaultObserver.dispose();
            this.PlaceComponentResult = null;
        }
    }

    @Override // id.dana.h5event.ChangePhoneNumberH5EventContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        DefaultObserver<Boolean> defaultObserver = this.PlaceComponentResult;
        if (defaultObserver != null) {
            defaultObserver.dispose();
            this.PlaceComponentResult = null;
        }
        GetChangePhoneNumberH5Event getChangePhoneNumberH5Event = this.MyBillsEntityDataFactory;
        if (this.PlaceComponentResult == null) {
            this.PlaceComponentResult = new DefaultObserver<Boolean>() { // from class: id.dana.h5event.ChangePhoneNumberH5EventPresenter.1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public /* synthetic */ void onNext(Object obj) {
                    ChangePhoneNumberH5EventPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(((Boolean) obj).booleanValue());
                }
            };
        }
        getChangePhoneNumberH5Event.execute(this.PlaceComponentResult);
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        DefaultObserver<Boolean> defaultObserver = this.PlaceComponentResult;
        if (defaultObserver != null) {
            defaultObserver.dispose();
            this.PlaceComponentResult = null;
        }
        this.MyBillsEntityDataFactory.dispose();
    }
}

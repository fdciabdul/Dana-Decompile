package id.dana.contract.account;

import dagger.Lazy;
import id.dana.contract.account.FirstTimeContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.FinishFirstTime;
import id.dana.domain.account.interactor.IsFirstTime;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes4.dex */
public class FirstTimePresenter implements FirstTimeContract.Presenter {
    private final Lazy<IsFirstTime> MyBillsEntityDataFactory;
    private final Lazy<FinishFirstTime> PlaceComponentResult;
    private final Lazy<FirstTimeContract.View> getAuthRequestContext;

    @Inject
    public FirstTimePresenter(Lazy<FirstTimeContract.View> lazy, Lazy<IsFirstTime> lazy2, Lazy<FinishFirstTime> lazy3) {
        this.getAuthRequestContext = lazy;
        this.MyBillsEntityDataFactory = lazy2;
        this.PlaceComponentResult = lazy3;
    }

    @Override // id.dana.contract.account.FirstTimeContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.account.FirstTimePresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                ((FirstTimeContract.View) FirstTimePresenter.this.getAuthRequestContext.get()).getAuthRequestContext(((Boolean) obj).booleanValue());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                ((FirstTimeContract.View) FirstTimePresenter.this.getAuthRequestContext.get()).onError(th.getMessage());
            }
        });
    }

    @Override // id.dana.contract.account.FirstTimeContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.PlaceComponentResult.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.account.FirstTimePresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                FirstTimeContract.View view = (FirstTimeContract.View) FirstTimePresenter.this.getAuthRequestContext.get();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                ((FirstTimeContract.View) FirstTimePresenter.this.getAuthRequestContext.get()).onError(th.getMessage());
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.get().dispose();
        this.PlaceComponentResult.get().dispose();
    }
}

package id.dana.contract.permission;

import dagger.Lazy;
import id.dana.contract.permission.PermissionStateContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.permission.interactor.CheckDeniedLocationPermission;
import id.dana.domain.permission.interactor.SetDeniedLocationPermission;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes4.dex */
public class PermissionStatePresenter implements PermissionStateContract.Presenter {
    private final Lazy<CheckDeniedLocationPermission> BuiltInFictitiousFunctionClassFactory;
    private final Lazy<SetDeniedLocationPermission> MyBillsEntityDataFactory;
    private final Lazy<PermissionStateContract.View> PlaceComponentResult;

    @Inject
    public PermissionStatePresenter(Lazy<PermissionStateContract.View> lazy, Lazy<SetDeniedLocationPermission> lazy2, Lazy<CheckDeniedLocationPermission> lazy3) {
        this.PlaceComponentResult = lazy;
        this.MyBillsEntityDataFactory = lazy2;
        this.BuiltInFictitiousFunctionClassFactory = lazy3;
    }

    @Override // id.dana.contract.permission.PermissionStateContract.Presenter
    public final void MyBillsEntityDataFactory(boolean z) {
        this.MyBillsEntityDataFactory.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.permission.PermissionStatePresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                PermissionStateContract.View view = (PermissionStateContract.View) PermissionStatePresenter.this.PlaceComponentResult.get();
            }
        }, SetDeniedLocationPermission.Params.forDenyLocationPermission(z));
    }

    @Override // id.dana.contract.permission.PermissionStateContract.Presenter
    public final void PlaceComponentResult() {
        this.BuiltInFictitiousFunctionClassFactory.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.permission.PermissionStatePresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                ((PermissionStateContract.View) PermissionStatePresenter.this.PlaceComponentResult.get()).PlaceComponentResult(((Boolean) obj).booleanValue());
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
    }
}

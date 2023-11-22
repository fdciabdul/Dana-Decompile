package id.dana.contract.maintenance;

import android.text.TextUtils;
import dagger.Lazy;
import id.dana.contract.maintenance.MaintenanceBroadcastContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.maintenance.interactor.ObserveMaintenanceBroadcast;
import id.dana.domain.maintenance.model.MaintenanceBroadcast;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes4.dex */
public class MaintenanceBroadcastPresenter implements MaintenanceBroadcastContract.Presenter {
    private final Lazy<ObserveMaintenanceBroadcast> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy<MaintenanceBroadcastContract.View> PlaceComponentResult;

    @Inject
    public MaintenanceBroadcastPresenter(Lazy<MaintenanceBroadcastContract.View> lazy, Lazy<ObserveMaintenanceBroadcast> lazy2) {
        this.PlaceComponentResult = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
    }

    @Override // id.dana.contract.maintenance.MaintenanceBroadcastContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(new DefaultObserver<MaintenanceBroadcast>() { // from class: id.dana.contract.maintenance.MaintenanceBroadcastPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                MaintenanceBroadcast maintenanceBroadcast = (MaintenanceBroadcast) obj;
                if (!maintenanceBroadcast.isVisible() || TextUtils.isEmpty(maintenanceBroadcast.getText())) {
                    ((MaintenanceBroadcastContract.View) MaintenanceBroadcastPresenter.this.PlaceComponentResult.get()).hideMaintenanceBroadcast();
                } else {
                    ((MaintenanceBroadcastContract.View) MaintenanceBroadcastPresenter.this.PlaceComponentResult.get()).showMaintenanceBroadcast(maintenanceBroadcast.getText());
                }
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
    }
}

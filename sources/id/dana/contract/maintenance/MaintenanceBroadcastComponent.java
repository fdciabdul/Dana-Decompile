package id.dana.contract.maintenance;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.component.ApplicationComponent;
import id.dana.richview.MaintenanceBroadcastView;

@Component(dependencies = {ApplicationComponent.class}, modules = {MaintenanceBroadcastModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface MaintenanceBroadcastComponent {
    void BuiltInFictitiousFunctionClassFactory(MaintenanceBroadcastView maintenanceBroadcastView);
}

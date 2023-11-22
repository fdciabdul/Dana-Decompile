package id.dana.di.component;

import dagger.Component;
import id.dana.animation.view.ZoomDialog;
import id.dana.contract.payqr.OfflinePayModule;
import id.dana.contract.payqr.PayQrModule;
import id.dana.di.PerActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {PayQrModule.class, OfflinePayModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface ZoomDialogComponent {
    void PlaceComponentResult(ZoomDialog zoomDialog);
}

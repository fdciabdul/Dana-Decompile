package id.dana.di.component;

import dagger.Component;
import id.dana.contract.staticqr.GetStaticQrModule;
import id.dana.di.PerActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {GetStaticQrModule.class})
@PerActivity
/* loaded from: classes8.dex */
public interface ShareQrComponent {
}

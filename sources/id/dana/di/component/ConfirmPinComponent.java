package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.ConfirmPinModule;
import id.dana.di.modules.TncSummaryModules;
import id.dana.onboarding.confirmpin.ConfirmPinFragment;

@Component(dependencies = {ApplicationComponent.class}, modules = {ConfirmPinModule.class, TncSummaryModules.class})
@PerActivity
/* loaded from: classes4.dex */
public interface ConfirmPinComponent {
    void PlaceComponentResult(ConfirmPinFragment confirmPinFragment);
}

package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.model.SelectedPayerModule;
import id.dana.richview.splitbill.SelectedPayerView;

@Component(dependencies = {ApplicationComponent.class}, modules = {SelectedPayerModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface SelectedPayerComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(SelectedPayerView selectedPayerView);
}

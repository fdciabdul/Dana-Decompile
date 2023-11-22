package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.AutoCompleteBankModule;
import id.dana.richview.bank.AutoCompleteBankView;

@Component(dependencies = {ApplicationComponent.class}, modules = {AutoCompleteBankModule.class})
@PerActivity
/* loaded from: classes8.dex */
public interface AutoCompleteBankComponent {
    void PlaceComponentResult(AutoCompleteBankView autoCompleteBankView);
}

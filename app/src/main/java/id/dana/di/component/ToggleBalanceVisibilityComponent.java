package id.dana.di.component;

import dagger.Component;
import id.dana.contract.user.GetBalanceModule;
import id.dana.di.PerActivity;
import id.dana.richview.ToggleBalanceView;

@Component(dependencies = {ApplicationComponent.class}, modules = {GetBalanceModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface ToggleBalanceVisibilityComponent {
    void MyBillsEntityDataFactory(ToggleBalanceView toggleBalanceView);
}

package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.SavingModule;
import id.dana.richview.boundcard.DanaBalanceCardView;

@Component(dependencies = {ApplicationComponent.class}, modules = {SavingModule.class})
@PerActivity
/* loaded from: classes8.dex */
public interface WalletComponent {
    void PlaceComponentResult(DanaBalanceCardView danaBalanceCardView);
}

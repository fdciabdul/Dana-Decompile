package id.dana.di.component;

import dagger.Component;
import id.dana.contract.payqr.AddNewCardModule;
import id.dana.contract.payqr.OfflinePayModule;
import id.dana.di.PerActivity;
import id.dana.pay.screen.AddNewCardFragment;

@Component(dependencies = {ApplicationComponent.class}, modules = {AddNewCardModule.class, OfflinePayModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface AddNewCardComponent {
    void PlaceComponentResult(AddNewCardFragment addNewCardFragment);
}

package id.dana.di.component;

import dagger.Component;
import id.dana.contract.boundcard.BoundCardModule;
import id.dana.contract.payasset.QueryPayMethodModule;
import id.dana.contract.user.GetUserInfoModule;
import id.dana.di.PerActivity;
import id.dana.richview.boundcard.BoundCardView;

@Component(dependencies = {ApplicationComponent.class}, modules = {BoundCardModule.class, QueryPayMethodModule.class, GetUserInfoModule.class})
@PerActivity
/* loaded from: classes8.dex */
public interface BoundCardComponent {
    void MyBillsEntityDataFactory(BoundCardView boundCardView);
}

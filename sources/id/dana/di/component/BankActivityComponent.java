package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.BillerX2BModule;
import id.dana.di.modules.RecipientActivityModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {RecipientActivityModule.class, BillerX2BModule.class, SendMoneyTrackerModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface BankActivityComponent {
    void PlaceComponentResult(BankRecipientActivity bankRecipientActivity);
}

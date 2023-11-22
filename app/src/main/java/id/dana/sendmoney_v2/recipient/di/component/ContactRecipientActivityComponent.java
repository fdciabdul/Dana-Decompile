package id.dana.sendmoney_v2.recipient.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.RecipientActivityModule;
import id.dana.di.modules.ReferralTrackerModule;
import id.dana.di.modules.SendMoneyModule;
import id.dana.sendmoney.di.module.SendMoneyCoreModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.recipient.activity.ContactRecipientActivity;
import kotlin.Metadata;

@Component(dependencies = {ApplicationComponent.class}, modules = {RecipientActivityModule.class, ReferralTrackerModule.class, SendMoneyModule.class, SendMoneyTrackerModule.class, SendMoneyCoreModule.class})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney_v2/recipient/di/component/ContactRecipientActivityComponent;", "", "Lid/dana/sendmoney_v2/recipient/activity/ContactRecipientActivity;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney_v2/recipient/activity/ContactRecipientActivity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public interface ContactRecipientActivityComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(ContactRecipientActivity p0);
}

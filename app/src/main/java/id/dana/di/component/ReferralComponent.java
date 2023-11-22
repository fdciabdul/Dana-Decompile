package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.ReferralModule;
import id.dana.onboarding.referral.VerifyReferralCodeFragment;

@Component(dependencies = {ApplicationComponent.class}, modules = {ReferralModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface ReferralComponent {
    void MyBillsEntityDataFactory(VerifyReferralCodeFragment verifyReferralCodeFragment);
}

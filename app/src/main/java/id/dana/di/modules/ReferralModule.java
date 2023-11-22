package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.onboarding.referral.ReferralContract;
import id.dana.onboarding.referral.VerifyReferralCodePresenter;
import javax.inject.Named;

@Module
/* loaded from: classes4.dex */
public class ReferralModule {
    private ReferralContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    @Named("verifyReferralCodePresenter")
    public ReferralContract.Presenter PlaceComponentResult(VerifyReferralCodePresenter verifyReferralCodePresenter) {
        return verifyReferralCodePresenter;
    }

    public ReferralModule(ReferralContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ReferralContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory;
    }
}

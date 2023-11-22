package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.referraltracker.ReferralTrackerContract;
import id.dana.contract.referraltracker.ReferralTrackerPresenter;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class ReferralTrackerModule {
    private ReferralTrackerContract.View getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ReferralTrackerContract.Presenter BuiltInFictitiousFunctionClassFactory(ReferralTrackerPresenter referralTrackerPresenter) {
        return referralTrackerPresenter;
    }

    public ReferralTrackerModule(ReferralTrackerContract.View view) {
        this.getAuthRequestContext = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ReferralTrackerContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext;
    }
}

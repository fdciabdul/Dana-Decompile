package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.richview.homereferral.HomeReferralContract;
import id.dana.richview.homereferral.HomeReferralPresenter;

@Module
/* loaded from: classes8.dex */
public class HomeReferralModule {
    private HomeReferralContract.View BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public HomeReferralContract.Presenter getAuthRequestContext(HomeReferralPresenter homeReferralPresenter) {
        return homeReferralPresenter;
    }

    public HomeReferralModule(HomeReferralContract.View view) {
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public HomeReferralContract.View MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}

package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.promoquest.redeem.RedeemMissionContract;
import id.dana.contract.promoquest.redeem.RedeemMissionPresenter;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class RedeemUserMissionModule {
    private final RedeemMissionContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public RedeemMissionContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(RedeemMissionPresenter redeemMissionPresenter) {
        return redeemMissionPresenter;
    }

    public RedeemUserMissionModule(RedeemMissionContract.View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public RedeemMissionContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}

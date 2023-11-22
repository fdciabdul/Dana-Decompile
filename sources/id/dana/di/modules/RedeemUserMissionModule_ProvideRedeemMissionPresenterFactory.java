package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promoquest.redeem.RedeemMissionContract;
import id.dana.contract.promoquest.redeem.RedeemMissionPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RedeemUserMissionModule_ProvideRedeemMissionPresenterFactory implements Factory<RedeemMissionContract.Presenter> {
    private final Provider<RedeemMissionPresenter> BuiltInFictitiousFunctionClassFactory;
    private final RedeemUserMissionModule MyBillsEntityDataFactory;

    private RedeemUserMissionModule_ProvideRedeemMissionPresenterFactory(RedeemUserMissionModule redeemUserMissionModule, Provider<RedeemMissionPresenter> provider) {
        this.MyBillsEntityDataFactory = redeemUserMissionModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static RedeemUserMissionModule_ProvideRedeemMissionPresenterFactory MyBillsEntityDataFactory(RedeemUserMissionModule redeemUserMissionModule, Provider<RedeemMissionPresenter> provider) {
        return new RedeemUserMissionModule_ProvideRedeemMissionPresenterFactory(redeemUserMissionModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RedeemMissionContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

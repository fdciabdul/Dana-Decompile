package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promoquest.redeem.RedeemMissionContract;

/* loaded from: classes4.dex */
public final class RedeemUserMissionModule_ProvideRedeemMissionViewFactory implements Factory<RedeemMissionContract.View> {
    private final RedeemUserMissionModule BuiltInFictitiousFunctionClassFactory;

    private RedeemUserMissionModule_ProvideRedeemMissionViewFactory(RedeemUserMissionModule redeemUserMissionModule) {
        this.BuiltInFictitiousFunctionClassFactory = redeemUserMissionModule;
    }

    public static RedeemUserMissionModule_ProvideRedeemMissionViewFactory MyBillsEntityDataFactory(RedeemUserMissionModule redeemUserMissionModule) {
        return new RedeemUserMissionModule_ProvideRedeemMissionViewFactory(redeemUserMissionModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RedeemMissionContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory());
    }
}

package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promoquest.redeem.RedeemQuestContract;

/* loaded from: classes4.dex */
public final class RedeemQuestModule_ProvideRedeemQuestViewFactory implements Factory<RedeemQuestContract.View> {
    private final RedeemQuestModule getAuthRequestContext;

    private RedeemQuestModule_ProvideRedeemQuestViewFactory(RedeemQuestModule redeemQuestModule) {
        this.getAuthRequestContext = redeemQuestModule;
    }

    public static RedeemQuestModule_ProvideRedeemQuestViewFactory MyBillsEntityDataFactory(RedeemQuestModule redeemQuestModule) {
        return new RedeemQuestModule_ProvideRedeemQuestViewFactory(redeemQuestModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RedeemQuestContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}

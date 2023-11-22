package id.dana.contract.promoquest.redeem;

import dagger.internal.Factory;
import id.dana.contract.promoquest.redeem.RedeemMissionContract;
import id.dana.domain.promoquest.interactor.RedeemMission;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RedeemMissionPresenter_Factory implements Factory<RedeemMissionPresenter> {
    private final Provider<RedeemMission> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<RedeemMissionContract.View> getAuthRequestContext;

    private RedeemMissionPresenter_Factory(Provider<RedeemMissionContract.View> provider, Provider<RedeemMission> provider2) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static RedeemMissionPresenter_Factory MyBillsEntityDataFactory(Provider<RedeemMissionContract.View> provider, Provider<RedeemMission> provider2) {
        return new RedeemMissionPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RedeemMissionPresenter(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

package id.dana.contract.promoquest.redeem;

import dagger.internal.Factory;
import id.dana.contract.promoquest.redeem.RedeemQuestContract;
import id.dana.domain.promoquest.interactor.RedeemQuest;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RedeemQuestPresenter_Factory implements Factory<RedeemQuestPresenter> {
    private final Provider<RedeemQuest> PlaceComponentResult;
    private final Provider<RedeemQuestContract.View> getAuthRequestContext;

    private RedeemQuestPresenter_Factory(Provider<RedeemQuestContract.View> provider, Provider<RedeemQuest> provider2) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
    }

    public static RedeemQuestPresenter_Factory getAuthRequestContext(Provider<RedeemQuestContract.View> provider, Provider<RedeemQuest> provider2) {
        return new RedeemQuestPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RedeemQuestPresenter(this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}

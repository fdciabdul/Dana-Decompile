package id.dana.cashier.guide.contract;

import dagger.internal.Factory;
import id.dana.cashier.domain.interactor.GetCdpGuide;
import id.dana.cashier.guide.contract.GuideContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GuidePresenter_Factory implements Factory<GuidePresenter> {
    private final Provider<GetCdpGuide> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GuideContract.View> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GuidePresenter(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

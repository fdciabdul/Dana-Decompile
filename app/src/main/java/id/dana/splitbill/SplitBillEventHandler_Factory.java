package id.dana.splitbill;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SplitBillEventHandler_Factory implements Factory<SplitBillEventHandler> {
    private final Provider<GetRequestMoneyInfoFeature> PlaceComponentResult;
    private final Provider<GetSplitBillConfig> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitBillEventHandler(this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}

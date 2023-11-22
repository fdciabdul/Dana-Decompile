package id.dana.splitbill;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.splitbill.SplitBillSectionContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SplitBillSectionPresenter_Factory implements Factory<SplitBillSectionPresenter> {
    private final Provider<SplitBillSectionContract.View> MyBillsEntityDataFactory;
    private final Provider<GetSplitBillConfig> getAuthRequestContext;

    private SplitBillSectionPresenter_Factory(Provider<SplitBillSectionContract.View> provider, Provider<GetSplitBillConfig> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
    }

    public static SplitBillSectionPresenter_Factory getAuthRequestContext(Provider<SplitBillSectionContract.View> provider, Provider<GetSplitBillConfig> provider2) {
        return new SplitBillSectionPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitBillSectionPresenter(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}

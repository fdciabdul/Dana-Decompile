package id.dana.sendmoney_v2.smartfriction.contract;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.interactor.GetStateSuspiciousAccountSmartFriction;
import id.dana.domain.sendmoney.interactor.SaveStateSuspiciousAccountSmartFriction;
import id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SuspiciousAccountPresenter_Factory implements Factory<SuspiciousAccountPresenter> {
    private final Provider<SuspiciousAccountContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetStateSuspiciousAccountSmartFriction> MyBillsEntityDataFactory;
    private final Provider<SaveStateSuspiciousAccountSmartFriction> getAuthRequestContext;

    private SuspiciousAccountPresenter_Factory(Provider<SuspiciousAccountContract.View> provider, Provider<GetStateSuspiciousAccountSmartFriction> provider2, Provider<SaveStateSuspiciousAccountSmartFriction> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static SuspiciousAccountPresenter_Factory PlaceComponentResult(Provider<SuspiciousAccountContract.View> provider, Provider<GetStateSuspiciousAccountSmartFriction> provider2, Provider<SaveStateSuspiciousAccountSmartFriction> provider3) {
        return new SuspiciousAccountPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SuspiciousAccountPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}

package id.dana.splitbill;

import dagger.internal.Factory;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.mapper.HomeInfoMapper;
import id.dana.splitbill.SplitBillShareQRContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SplitBillShareQRPresenter_Factory implements Factory<SplitBillShareQRPresenter> {
    private final Provider<HomeInfoMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetHomeInfo> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SplitBillShareQRContract.View> getAuthRequestContext;

    private SplitBillShareQRPresenter_Factory(Provider<SplitBillShareQRContract.View> provider, Provider<GetHomeInfo> provider2, Provider<HomeInfoMapper> provider3) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static SplitBillShareQRPresenter_Factory getAuthRequestContext(Provider<SplitBillShareQRContract.View> provider, Provider<GetHomeInfo> provider2, Provider<HomeInfoMapper> provider3) {
        return new SplitBillShareQRPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitBillShareQRPresenter(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

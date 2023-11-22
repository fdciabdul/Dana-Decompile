package id.dana.contract.sendmoney.v2;

import dagger.internal.Factory;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.senddigitalmoney.interactor.CheckCardNoPrefixFeature;
import id.dana.domain.senddigitalmoney.interactor.QueryCardWithoutPrefix;
import id.dana.domain.sendmoney.interactor.GetAllBillerX2B;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class BillerX2BPresenter_Factory implements Factory<BillerX2BPresenter> {
    private final Provider<DeviceInformationProvider> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CheckCardNoPrefixFeature> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<QueryCardWithoutPrefix> MyBillsEntityDataFactory;
    private final Provider<SaveRecentBank> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetAuthCode> PlaceComponentResult;
    private final Provider<GetAllBillerX2B> getAuthRequestContext;
    private final Provider<BillerX2BContract.View> lookAheadTest;

    private BillerX2BPresenter_Factory(Provider<BillerX2BContract.View> provider, Provider<GetAllBillerX2B> provider2, Provider<CheckCardNoPrefixFeature> provider3, Provider<QueryCardWithoutPrefix> provider4, Provider<GetAuthCode> provider5, Provider<DeviceInformationProvider> provider6, Provider<SaveRecentBank> provider7) {
        this.lookAheadTest = provider;
        this.getAuthRequestContext = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.PlaceComponentResult = provider5;
        this.BuiltInFictitiousFunctionClassFactory = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider7;
    }

    public static BillerX2BPresenter_Factory PlaceComponentResult(Provider<BillerX2BContract.View> provider, Provider<GetAllBillerX2B> provider2, Provider<CheckCardNoPrefixFeature> provider3, Provider<QueryCardWithoutPrefix> provider4, Provider<GetAuthCode> provider5, Provider<DeviceInformationProvider> provider6, Provider<SaveRecentBank> provider7) {
        return new BillerX2BPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BillerX2BPresenter(this.lookAheadTest.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get());
    }
}

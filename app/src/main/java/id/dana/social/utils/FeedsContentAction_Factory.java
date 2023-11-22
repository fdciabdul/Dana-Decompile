package id.dana.social.utils;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.cashier.CashierEventHandler;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.tracker.DeeplinkTracker;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.domain.deeplink.interactor.ReadDeepLinkProperties;
import id.dana.domain.featureconfig.interactor.GetDealsConfig;
import id.dana.domain.paylater.interactor.GetUserLoanInfo;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FeedsContentAction_Factory implements Factory<FeedsContentAction> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DeeplinkTracker> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CashierEventHandler> MyBillsEntityDataFactory;
    private final Provider<DeepLinkContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<DeepLinkPayloadModelMapper> PlaceComponentResult;
    private final Provider<DynamicUrlWrapper> getAuthRequestContext;
    private final Provider<GetUserLoanInfo> lookAheadTest;
    private final Provider<GetDealsConfig> moveToNextValue;
    private final Provider<ReadDeepLinkProperties> scheduleImpl;

    private FeedsContentAction_Factory(Provider<Context> provider, Provider<ReadDeepLinkProperties> provider2, Provider<DeepLinkContract.View> provider3, Provider<DeepLinkPayloadModelMapper> provider4, Provider<DeeplinkTracker> provider5, Provider<DynamicUrlWrapper> provider6, Provider<GetDealsConfig> provider7, Provider<CashierEventHandler> provider8, Provider<GetUserLoanInfo> provider9) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.scheduleImpl = provider2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider3;
        this.PlaceComponentResult = provider4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider5;
        this.getAuthRequestContext = provider6;
        this.moveToNextValue = provider7;
        this.MyBillsEntityDataFactory = provider8;
        this.lookAheadTest = provider9;
    }

    public static FeedsContentAction_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<ReadDeepLinkProperties> provider2, Provider<DeepLinkContract.View> provider3, Provider<DeepLinkPayloadModelMapper> provider4, Provider<DeeplinkTracker> provider5, Provider<DynamicUrlWrapper> provider6, Provider<GetDealsConfig> provider7, Provider<CashierEventHandler> provider8, Provider<GetUserLoanInfo> provider9) {
        return new FeedsContentAction_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsContentAction(this.BuiltInFictitiousFunctionClassFactory.get(), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest));
    }
}

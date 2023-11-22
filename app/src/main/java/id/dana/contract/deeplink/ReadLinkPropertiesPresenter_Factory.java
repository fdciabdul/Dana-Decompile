package id.dana.contract.deeplink;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.tracker.DeeplinkTracker;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.deeplink.interactor.ReadDeepLinkProperties;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ReadLinkPropertiesPresenter_Factory implements Factory<ReadLinkPropertiesPresenter> {
    private final Provider<DeepLinkContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DeepLinkPayloadModelMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ReadDeepLinkProperties> MyBillsEntityDataFactory;
    private final Provider<GetUserId> PlaceComponentResult;
    private final Provider<DeeplinkTracker> getAuthRequestContext;

    private ReadLinkPropertiesPresenter_Factory(Provider<DeepLinkContract.View> provider, Provider<ReadDeepLinkProperties> provider2, Provider<DeepLinkPayloadModelMapper> provider3, Provider<GetUserId> provider4, Provider<DeeplinkTracker> provider5) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.PlaceComponentResult = provider4;
        this.getAuthRequestContext = provider5;
    }

    public static ReadLinkPropertiesPresenter_Factory getAuthRequestContext(Provider<DeepLinkContract.View> provider, Provider<ReadDeepLinkProperties> provider2, Provider<DeepLinkPayloadModelMapper> provider3, Provider<GetUserId> provider4, Provider<DeeplinkTracker> provider5) {
        return new ReadLinkPropertiesPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ReadLinkPropertiesPresenter(DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}

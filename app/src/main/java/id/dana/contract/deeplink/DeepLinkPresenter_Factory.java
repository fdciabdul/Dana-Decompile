package id.dana.contract.deeplink;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.tracker.AbstractDeeplinkTrackerFactory;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.deeplink.interactor.GetDeepLinkPayload;
import id.dana.domain.deeplink.interactor.InitSessionDeepLink;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DeepLinkPresenter_Factory implements Factory<DeepLinkPresenter> {
    private final Provider<DeepLinkPayloadModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetDeepLinkPayload> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetPhoneNumber> MyBillsEntityDataFactory;
    private final Provider<RemoveDeepLinkPayload> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<AbstractDeeplinkTrackerFactory> PlaceComponentResult;
    private final Provider<InitSessionDeepLink> getAuthRequestContext;
    private final Provider<DeepLinkContract.View> lookAheadTest;

    private DeepLinkPresenter_Factory(Provider<DeepLinkContract.View> provider, Provider<InitSessionDeepLink> provider2, Provider<GetDeepLinkPayload> provider3, Provider<GetPhoneNumber> provider4, Provider<DeepLinkPayloadModelMapper> provider5, Provider<RemoveDeepLinkPayload> provider6, Provider<AbstractDeeplinkTrackerFactory> provider7) {
        this.lookAheadTest = provider;
        this.getAuthRequestContext = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider6;
        this.PlaceComponentResult = provider7;
    }

    public static DeepLinkPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<DeepLinkContract.View> provider, Provider<InitSessionDeepLink> provider2, Provider<GetDeepLinkPayload> provider3, Provider<GetPhoneNumber> provider4, Provider<DeepLinkPayloadModelMapper> provider5, Provider<RemoveDeepLinkPayload> provider6, Provider<AbstractDeeplinkTrackerFactory> provider7) {
        return new DeepLinkPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DeepLinkPresenter(DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), this.BuiltInFictitiousFunctionClassFactory.get(), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
    }
}

package id.dana.contract.deeplink;

import dagger.internal.Factory;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.domain.deeplink.interactor.InitSessionDeepLink;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class InitSessionDeepLinkPresenter_Factory implements Factory<InitSessionDeepLinkPresenter> {
    private final Provider<DeepLinkPayloadModelMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<InitSessionDeepLink> MyBillsEntityDataFactory;
    private final Provider<DeepLinkContract.View> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InitSessionDeepLinkPresenter(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

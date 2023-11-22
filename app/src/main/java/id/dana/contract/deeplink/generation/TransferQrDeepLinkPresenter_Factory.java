package id.dana.contract.deeplink.generation;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.domain.deeplink.interactor.GenerateTransferQrDeepLink;
import id.dana.sendmoney_v2.tracker.ApiHitTimer;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TransferQrDeepLinkPresenter_Factory implements Factory<TransferQrDeepLinkPresenter> {
    private final Provider<ApiHitTimer> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GenerateTransferQrDeepLink> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GenerateDeepLinkContract.TransferView> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;

    private TransferQrDeepLinkPresenter_Factory(Provider<Context> provider, Provider<GenerateTransferQrDeepLink> provider2, Provider<GenerateDeepLinkContract.TransferView> provider3, Provider<ApiHitTimer> provider4) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.PlaceComponentResult = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
    }

    public static TransferQrDeepLinkPresenter_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<GenerateTransferQrDeepLink> provider2, Provider<GenerateDeepLinkContract.TransferView> provider3, Provider<ApiHitTimer> provider4) {
        return new TransferQrDeepLinkPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TransferQrDeepLinkPresenter(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

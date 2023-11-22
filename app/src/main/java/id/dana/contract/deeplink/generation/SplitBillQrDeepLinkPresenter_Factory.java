package id.dana.contract.deeplink.generation;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.domain.deeplink.interactor.GenerateSplitBillQrDeepLink;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SplitBillQrDeepLinkPresenter_Factory implements Factory<SplitBillQrDeepLinkPresenter> {
    private final Provider<GenerateDeepLinkContract.SplitBillView> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<GenerateSplitBillQrDeepLink> PlaceComponentResult;

    private SplitBillQrDeepLinkPresenter_Factory(Provider<Context> provider, Provider<GenerateSplitBillQrDeepLink> provider2, Provider<GenerateDeepLinkContract.SplitBillView> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static SplitBillQrDeepLinkPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<GenerateSplitBillQrDeepLink> provider2, Provider<GenerateDeepLinkContract.SplitBillView> provider3) {
        return new SplitBillQrDeepLinkPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitBillQrDeepLinkPresenter(this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

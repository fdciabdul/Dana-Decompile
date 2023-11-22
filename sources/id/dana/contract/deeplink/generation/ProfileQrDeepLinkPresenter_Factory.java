package id.dana.contract.deeplink.generation;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.domain.deeplink.interactor.GenerateProfileQrDeepLink;
import id.dana.sendmoney_v2.tracker.ApiHitTimer;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ProfileQrDeepLinkPresenter_Factory implements Factory<ProfileQrDeepLinkPresenter> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GenerateProfileQrDeepLink> MyBillsEntityDataFactory;
    private final Provider<GenerateDeepLinkContract.ProfileView> PlaceComponentResult;
    private final Provider<ApiHitTimer> getAuthRequestContext;

    private ProfileQrDeepLinkPresenter_Factory(Provider<Context> provider, Provider<GenerateProfileQrDeepLink> provider2, Provider<GenerateDeepLinkContract.ProfileView> provider3, Provider<ApiHitTimer> provider4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.PlaceComponentResult = provider3;
        this.getAuthRequestContext = provider4;
    }

    public static ProfileQrDeepLinkPresenter_Factory PlaceComponentResult(Provider<Context> provider, Provider<GenerateProfileQrDeepLink> provider2, Provider<GenerateDeepLinkContract.ProfileView> provider3, Provider<ApiHitTimer> provider4) {
        return new ProfileQrDeepLinkPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ProfileQrDeepLinkPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}

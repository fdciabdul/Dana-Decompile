package id.dana.wallet_v3.view.addasset.presenter;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetKycLevel;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.pocket.interactor.GetLoyaltyToken;
import id.dana.domain.wallet_v3.interactor.GetBottomSheetAllService;
import id.dana.domain.wallet_v3.interactor.GetBottomSheetServices;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class BottomSheetAddAssetPresenter_Factory implements Factory<BottomSheetAddAssetPresenter> {
    private final Provider<GetAuthCode> getAuthCodeProvider;
    private final Provider<GetBottomSheetAllService> getBottomSheetAllServiceProvider;
    private final Provider<GetBottomSheetServices> getBottomSheetServicesProvider;
    private final Provider<GetKycLevel> getKycLevelProvider;
    private final Provider<GetLoyaltyToken> getLoyaltyAccessTokenProvider;
    private final Provider<ThirdPartyServicesMapper> mapperProvider;
    private final Provider<BottomSheetAddAssetContract.View> viewProvider;

    public BottomSheetAddAssetPresenter_Factory(Provider<BottomSheetAddAssetContract.View> provider, Provider<GetBottomSheetServices> provider2, Provider<ThirdPartyServicesMapper> provider3, Provider<GetAuthCode> provider4, Provider<GetKycLevel> provider5, Provider<GetLoyaltyToken> provider6, Provider<GetBottomSheetAllService> provider7) {
        this.viewProvider = provider;
        this.getBottomSheetServicesProvider = provider2;
        this.mapperProvider = provider3;
        this.getAuthCodeProvider = provider4;
        this.getKycLevelProvider = provider5;
        this.getLoyaltyAccessTokenProvider = provider6;
        this.getBottomSheetAllServiceProvider = provider7;
    }

    @Override // javax.inject.Provider
    public final BottomSheetAddAssetPresenter get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.viewProvider), DoubleCheck.MyBillsEntityDataFactory(this.getBottomSheetServicesProvider), this.mapperProvider.get(), DoubleCheck.MyBillsEntityDataFactory(this.getAuthCodeProvider), DoubleCheck.MyBillsEntityDataFactory(this.getKycLevelProvider), DoubleCheck.MyBillsEntityDataFactory(this.getLoyaltyAccessTokenProvider), DoubleCheck.MyBillsEntityDataFactory(this.getBottomSheetAllServiceProvider));
    }

    public static BottomSheetAddAssetPresenter_Factory create(Provider<BottomSheetAddAssetContract.View> provider, Provider<GetBottomSheetServices> provider2, Provider<ThirdPartyServicesMapper> provider3, Provider<GetAuthCode> provider4, Provider<GetKycLevel> provider5, Provider<GetLoyaltyToken> provider6, Provider<GetBottomSheetAllService> provider7) {
        return new BottomSheetAddAssetPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static BottomSheetAddAssetPresenter newInstance(Lazy<BottomSheetAddAssetContract.View> lazy, Lazy<GetBottomSheetServices> lazy2, ThirdPartyServicesMapper thirdPartyServicesMapper, Lazy<GetAuthCode> lazy3, Lazy<GetKycLevel> lazy4, Lazy<GetLoyaltyToken> lazy5, Lazy<GetBottomSheetAllService> lazy6) {
        return new BottomSheetAddAssetPresenter(lazy, lazy2, thirdPartyServicesMapper, lazy3, lazy4, lazy5, lazy6);
    }
}

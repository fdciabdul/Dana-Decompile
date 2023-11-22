package id.dana.social.contract;

import dagger.internal.Factory;
import id.dana.feeds.domain.activation.interactor.SetDeviceFeedFeatureSwitch;
import id.dana.feeds.domain.activation.interactor.UpdateFeedUserConfig;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.social.contract.PrivacySettingContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PrivacySettingPresenter_Factory implements Factory<PrivacySettingPresenter> {
    private final Provider<PrivacySettingContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SetDeviceFeedFeatureSwitch> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<UpdateFeedUserConfig> MyBillsEntityDataFactory;
    private final Provider<GetShareFeedConsent> PlaceComponentResult;
    private final Provider<SaveShareFeedConsent> getAuthRequestContext;

    private PrivacySettingPresenter_Factory(Provider<GetShareFeedConsent> provider, Provider<SetDeviceFeedFeatureSwitch> provider2, Provider<SaveShareFeedConsent> provider3, Provider<UpdateFeedUserConfig> provider4, Provider<PrivacySettingContract.View> provider5) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.getAuthRequestContext = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
    }

    public static PrivacySettingPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GetShareFeedConsent> provider, Provider<SetDeviceFeedFeatureSwitch> provider2, Provider<SaveShareFeedConsent> provider3, Provider<UpdateFeedUserConfig> provider4, Provider<PrivacySettingContract.View> provider5) {
        return new PrivacySettingPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PrivacySettingPresenter(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

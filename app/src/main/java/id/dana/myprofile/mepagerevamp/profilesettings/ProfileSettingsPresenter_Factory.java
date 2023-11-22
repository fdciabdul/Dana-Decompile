package id.dana.myprofile.mepagerevamp.profilesettings;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.account.interactor.UploadAvatar;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.domain.useremailaddress.interactor.GetUserEmailAddress;
import id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.myprofile.UserInfoMapper;
import id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ProfileSettingsPresenter_Factory implements Factory<ProfileSettingsPresenter> {
    private final Provider<GetUserEmailAddress> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetAvatarUrl> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<InitFeedWithoutContact> MyBillsEntityDataFactory;
    private final Provider<UserInfoMapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetUserInfo> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;
    private final Provider<SaveShareFeedConsent> lookAheadTest;
    private final Provider<ProfileSettingsContract.View> moveToNextValue;
    private final Provider<UploadAvatar> scheduleImpl;

    private ProfileSettingsPresenter_Factory(Provider<Context> provider, Provider<ProfileSettingsContract.View> provider2, Provider<GetAvatarUrl> provider3, Provider<UploadAvatar> provider4, Provider<InitFeedWithoutContact> provider5, Provider<SaveShareFeedConsent> provider6, Provider<GetUserInfo> provider7, Provider<UserInfoMapper> provider8, Provider<GetUserEmailAddress> provider9) {
        this.getAuthRequestContext = provider;
        this.moveToNextValue = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.scheduleImpl = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.lookAheadTest = provider6;
        this.PlaceComponentResult = provider7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider8;
        this.BuiltInFictitiousFunctionClassFactory = provider9;
    }

    public static ProfileSettingsPresenter_Factory PlaceComponentResult(Provider<Context> provider, Provider<ProfileSettingsContract.View> provider2, Provider<GetAvatarUrl> provider3, Provider<UploadAvatar> provider4, Provider<InitFeedWithoutContact> provider5, Provider<SaveShareFeedConsent> provider6, Provider<GetUserInfo> provider7, Provider<UserInfoMapper> provider8, Provider<GetUserEmailAddress> provider9) {
        return new ProfileSettingsPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ProfileSettingsPresenter(this.getAuthRequestContext.get(), this.moveToNextValue.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.scheduleImpl.get(), this.MyBillsEntityDataFactory.get(), this.lookAheadTest.get(), this.PlaceComponentResult.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

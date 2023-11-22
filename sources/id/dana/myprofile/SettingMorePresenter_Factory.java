package id.dana.myprofile;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.account.interactor.UploadAvatar;
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting;
import id.dana.domain.profilemenu.interactor.GetSettingCollection;
import id.dana.domain.twilio.interactor.CheckTwilioEnrollmentStatus;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.domain.useremailaddress.interactor.GetUserEmailAddress;
import id.dana.domain.usersecurityquestions.interactor.GetSecurityQuestionState;
import id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.myprofile.SettingMoreContract;
import id.dana.myprofile.settingconfig.FeedSharingConfigRunner;
import id.dana.myprofile.settingconfig.NicknameChangeConfigRunner;
import id.dana.myprofile.settingconfig.RestrictedContactConfigRunner;
import id.dana.myprofile.settingconfig.ShareFeedSettingConfigRunner;
import id.dana.myprofile.settingconfig.UsernameChangeConfigRunner;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SettingMorePresenter_Factory implements Factory<SettingMorePresenter> {
    private final Provider<GetAvatarUrl> BuiltInFictitiousFunctionClassFactory;
    private final Provider<UploadAvatar> DatabaseTableConfigUtil;
    private final Provider<ShareFeedSettingConfigRunner> GetContactSyncConfig;
    private final Provider<CheckTwilioEnrollmentStatus> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<GetSettingCollection> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<RestrictedContactConfigRunner> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<NicknameChangeConfigRunner> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<FeedSharingConfigRunner> PlaceComponentResult;
    private final Provider<UsernameChangeConfigRunner> PrepareContext;
    private final Provider<GetAutoRouteInitialSetting> getAuthRequestContext;
    private final Provider<InitFeedWithoutContact> getErrorConfigVersion;
    private final Provider<SaveShareFeedConsent> initRecordTimeStamp;
    private final Provider<SettingMoreContract.View> isLayoutRequested;
    private final Provider<GetUserInfo> lookAheadTest;
    private final Provider<GetSecurityQuestionState> moveToNextValue;
    private final Provider<UserInfoMapper> newProxyInstance;
    private final Provider<GetUserEmailAddress> scheduleImpl;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SettingMorePresenter(this.MyBillsEntityDataFactory.get(), this.isLayoutRequested.get(), this.newProxyInstance.get(), this.DatabaseTableConfigUtil.get(), this.GetContactSyncConfig.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.PlaceComponentResult.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), this.PrepareContext.get(), this.lookAheadTest.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.scheduleImpl.get(), this.moveToNextValue.get(), this.initRecordTimeStamp.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.getErrorConfigVersion.get());
    }
}

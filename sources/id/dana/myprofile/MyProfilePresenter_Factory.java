package id.dana.myprofile;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.UploadAvatar;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload;
import id.dana.domain.familyaccount.interactor.CheckConsultFamilyAccount;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature;
import id.dana.domain.profilecompletion.interactor.CheckUsernameConfig;
import id.dana.domain.profilecompletion.interactor.GetProfileCompletionData;
import id.dana.domain.profilecompletion.interactor.GetProfileCompletionVisibility;
import id.dana.domain.profilemenu.interactor.GetLastHideRedDotTimestamp;
import id.dana.domain.profilemenu.interactor.GetSettingCollection;
import id.dana.domain.profilemenu.interactor.GetUserConfigProfileNewFlag;
import id.dana.domain.profilemenu.interactor.SaveLastHideRedDotTimestamp;
import id.dana.domain.profilemenu.interactor.SaveProfileNewFlagUserConfig;
import id.dana.domain.recurring.subscription.interactor.GetCountRecurringSubscription;
import id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache;
import id.dana.domain.referraltracker.interactor.GetReferralTracker;
import id.dana.domain.registration.interactor.GetChatBotTimestamp;
import id.dana.domain.services.interactor.GetService;
import id.dana.domain.uploadfiles.ClearFiles;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.domain.wallet_v3.interactor.GetWalletConfigFromLocal;
import id.dana.mapper.ReferralTrackerModelMapper;
import id.dana.myprofile.MyProfileContract;
import id.dana.myprofile.settingconfig.DanaPlusSettingConfigRunner;
import id.dana.myprofile.settingconfig.DanaPlusStarAmSettingConfigRunner;
import id.dana.myprofile.settingconfig.FamilyAccountSettingConfigRunner;
import id.dana.myprofile.settingconfig.GoldSettingConfigRunner;
import id.dana.myprofile.settingconfig.KybSettingConfigRunner;
import id.dana.myprofile.settingconfig.ReferralSettingConfigRunner;
import id.dana.referral.model.MyReferralConsultMapper;
import id.dana.utils.session.SessionManager;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class MyProfilePresenter_Factory implements Factory<MyProfilePresenter> {
    private final Provider<SessionManager> A;
    private final Provider<UserInfoMapper> B;
    private final Provider<SaveShowToolTip> BottomSheetCardBindingView$watcherCardNumberView$1;
    private final Provider<ClearFiles> BuiltInFictitiousFunctionClassFactory;
    private final Provider<UploadAvatar> C;
    private final Provider<GetProfileCompletionData> DatabaseTableConfigUtil;
    private final Provider<IsNeedToShowToolTip> FragmentBottomSheetPaymentSettingBinding;
    private final Provider<GetReferralTracker> GetContactSyncConfig;
    private final Provider<CheckConsultFamilyAccount> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<GetAvatarUrl> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetCountRecurringSubscription> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<GetLastHideRedDotTimestamp> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<MyReferralConsultMapper> NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final Provider<GoldSettingConfigRunner> NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final Provider<GetWalletConfigFromLocal> NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final Provider<KybSettingConfigRunner> NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final Provider<GetUserInfoWithKyc> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<GetUserId> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final Provider<CheckUsernameConfig> PlaceComponentResult;
    private final Provider<GetService> PrepareContext;
    private final Provider<SaveLastHideRedDotTimestamp> SubSequence;
    private final Provider<SaveReferralEngagementDialogCache> VerifyPinStateManager$executeRiskChallenge$2$1;
    private final Provider<MyProfileContract.View> VerifyPinStateManager$executeRiskChallenge$2$2;
    private final Provider<CheckShowReferralCodeFeature> getAuthRequestContext;
    private final Provider<SaveProfileNewFlagUserConfig> getCallingPid;
    private final Provider<FamilyAccountSettingConfigRunner> getErrorConfigVersion;
    private final Provider<RemoveDeepLinkPayload> getSupportButtonTintMode;
    private final Provider<GetProfileCompletionVisibility> initRecordTimeStamp;
    private final Provider<GetSettingCollection> isLayoutRequested;
    private final Provider<DanaPlusSettingConfigRunner> lookAheadTest;
    private final Provider<DanaPlusStarAmSettingConfigRunner> moveToNextValue;
    private final Provider<GetUserConfigProfileNewFlag> newProxyInstance;
    private final Provider<ReferralTrackerModelMapper> readMicros;
    private final Provider<GetChatBotTimestamp> scheduleImpl;
    private final Provider<ReferralSettingConfigRunner> whenAvailable;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MyProfilePresenter(DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.VerifyPinStateManager$executeRiskChallenge$2$2), DoubleCheck.MyBillsEntityDataFactory(this.B), DoubleCheck.MyBillsEntityDataFactory(this.C), DoubleCheck.MyBillsEntityDataFactory(this.A), DoubleCheck.MyBillsEntityDataFactory(this.FragmentBottomSheetPaymentSettingBinding), DoubleCheck.MyBillsEntityDataFactory(this.BottomSheetCardBindingView$watcherCardNumberView$1), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.isLayoutRequested), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda6), DoubleCheck.MyBillsEntityDataFactory(this.whenAvailable), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda4), DoubleCheck.MyBillsEntityDataFactory(this.VerifyPinStateManager$executeRiskChallenge$2$1), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda5), DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig), DoubleCheck.MyBillsEntityDataFactory(this.readMicros), DoubleCheck.MyBillsEntityDataFactory(this.newProxyInstance), DoubleCheck.MyBillsEntityDataFactory(this.getCallingPid), DoubleCheck.MyBillsEntityDataFactory(this.getSupportButtonTintMode), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2), DoubleCheck.MyBillsEntityDataFactory(this.SubSequence), DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext));
    }
}

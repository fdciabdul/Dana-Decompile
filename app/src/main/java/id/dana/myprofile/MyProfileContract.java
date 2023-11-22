package id.dana.myprofile;

import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.griver.core.GriverParams;
import id.dana.base.AbstractContract;
import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.domain.familyaccount.model.ConsultFamilyAccountResult;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.model.UserConfigProfileNewFlag;
import id.dana.model.UserInfo;
import id.dana.referral.model.MyReferralConsult;
import id.dana.referral.referraltracker.model.ReferralTrackerModel;
import id.dana.utils.StringWrapper;
import id.dana.wallet_v3.constant.WalletConstant;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/myprofile/MyProfileContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MyProfileContract {

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\bH&J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\u0016\u0010\"\u001a\u00020\u00032\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0003H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\rH\u0016J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\rH&J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\bH&J\u0010\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u000203H&J\u001c\u00104\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u00010\b2\b\u00106\u001a\u0004\u0018\u00010\bH&J\u0010\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020%H&J\u0010\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\bH&J\b\u0010;\u001a\u00020\u0003H&J\u0010\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\bH&J\b\u0010>\u001a\u00020\u0003H&J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006AÀ\u0006\u0001"}, d2 = {"Lid/dana/myprofile/MyProfileContract$View;", "Lid/dana/base/AbstractContract$AbstractView;", "dismissBalanceProgress", "", "dismissLoadingProgress", "dismissProgress", "notifyBalance", "balance", "", "notifyPaymentCards", "cards", "onCheckShowReferralCodeSuccess", "showReferralCodeEnable", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "errorMessage", "onErrorGetPromoQuestService", "onFinishLogout", "onGetChatbotTimestamp", "timestamp", "", "onGetConsultFamilyAccount", "consultFamilyAccountResult", "Lid/dana/domain/familyaccount/model/ConsultFamilyAccountResult;", "onGetCountBills", "countBills", "Lid/dana/utils/StringWrapper;", "onGetPromoQuestService", "service", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "onGetReferralTracker", "referralTrackerModel", "Lid/dana/referral/referraltracker/model/ReferralTrackerModel;", "onGetReferralTrackerError", "onGetSettingCollectionSuccess", "settingModels", "", "Lid/dana/domain/profilemenu/model/SettingModel;", "onGetUserConfigNewBadge", "userConfigProfileNewFlag", "Lid/dana/domain/profilemenu/model/UserConfigProfileNewFlag;", "onGetUserInfoFailed", "onGetWalletFeatureNewConfig", "isWalletFeatureEnabled", "onSaveUserConfigNewBadge", "onShowProfileCompletionTrigger", "shouldShow", "onSubscribeEasterPluginSuccess", "message", "onUserKybInfo", "userInfo", "Lid/dana/model/UserInfo;", "onUserKycInfo", WalletConstant.KYC_LEVEL, "kycStatus", "populateProfileCompletionData", MyProfileBundleKey.SETTING_MODEL, "showAvatar", GriverParams.ShareParams.IMAGE_URL, "showLoadingProgress", "showPhoneNumber", "phoneNumber", "showProgress", "showUserName", "name", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface View extends AbstractContract.AbstractView {

        /* renamed from: id.dana.myprofile.MyProfileContract$View$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void MyBillsEntityDataFactory() {
            }

            public static void MyBillsEntityDataFactory(ReferralTrackerModel referralTrackerModel) {
                Intrinsics.checkNotNullParameter(referralTrackerModel, "");
            }

            public static void PlaceComponentResult() {
            }

            public static void PlaceComponentResult(ThirdPartyServiceResponse thirdPartyServiceResponse) {
                Intrinsics.checkNotNullParameter(thirdPartyServiceResponse, "");
            }

            public static void PlaceComponentResult(UserConfigProfileNewFlag userConfigProfileNewFlag) {
                Intrinsics.checkNotNullParameter(userConfigProfileNewFlag, "");
            }

            public static void PlaceComponentResult(StringWrapper stringWrapper) {
                Intrinsics.checkNotNullParameter(stringWrapper, "");
            }

            public static void getAuthRequestContext(UserConfigProfileNewFlag userConfigProfileNewFlag) {
                Intrinsics.checkNotNullParameter(userConfigProfileNewFlag, "");
            }
        }

        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(ConsultFamilyAccountResult consultFamilyAccountResult);

        void BuiltInFictitiousFunctionClassFactory(ThirdPartyServiceResponse thirdPartyServiceResponse);

        void BuiltInFictitiousFunctionClassFactory(String str, String str2);

        void BuiltInFictitiousFunctionClassFactory(boolean z);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(long j);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean z);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(SettingModel settingModel);

        void MyBillsEntityDataFactory(UserConfigProfileNewFlag userConfigProfileNewFlag);

        void MyBillsEntityDataFactory(String str);

        void PlaceComponentResult();

        void PlaceComponentResult(UserConfigProfileNewFlag userConfigProfileNewFlag);

        @Override // id.dana.base.AbstractContract.AbstractView
        void dismissProgress();

        void getAuthRequestContext();

        void getAuthRequestContext(UserInfo userInfo);

        void getAuthRequestContext(ReferralTrackerModel referralTrackerModel);

        void getAuthRequestContext(StringWrapper stringWrapper);

        void getAuthRequestContext(String str);

        void getAuthRequestContext(List<? extends SettingModel> list);

        void getAuthRequestContext(boolean z);

        void lookAheadTest();

        @Override // id.dana.base.AbstractContract.AbstractView
        void onError(String errorMessage);

        @Override // id.dana.base.AbstractContract.AbstractView
        void showProgress();
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\fH&J\b\u0010\u0011\u001a\u00020\fH&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH&J\b\u0010\u0015\u001a\u00020\fH&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\fH&J\b\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\fH&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u0003H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\fH&J\u001a\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0005H&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0005H&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0005H&J\b\u0010-\u001a\u00020\u0003H&J \u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0005H&J\u0018\u00104\u001a\u00020\u00032\u0006\u0010/\u001a\u0002002\u0006\u00105\u001a\u000206H&J\b\u00107\u001a\u00020\u0003H&J\u0010\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020:H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006;À\u0006\u0001"}, d2 = {"Lid/dana/myprofile/MyProfileContract$Presenter;", "Lid/dana/base/AbstractContract$AbstractPresenter;", "checkConsultFamilyAccount", "", "withLimit", "", "checkProfileCompletionVisibility", "checkPromoQuestService", "checkShowReferralCodeFeature", "clearUploadFilesData", "getAvatarUrl", "getAvatarUrlValue", "", "getChatbotTimestamp", "chatbotKey", "getCountBills", "getDeepLinkReferral", "getKycLevel", "getLastHideRedDotTimestamp", "", "settingName", "getLoginId", "getMyProfile", "getReferralConsult", "Lid/dana/referral/model/MyReferralConsult;", "getReferralTracker", "getSettingsCollection", MyProfileMenuAction.COLLECTION, "getTaskCount", "", "getUserConfigNewBadge", "getUserId", "getWalletFeatureNewConfig", "loadProfileCompletionData", "loadUserId", "logout", "saveLastHideRedDotTimestamp", "saveUserConfigNewBadge", "userConfig", "Lid/dana/domain/profilemenu/model/UserConfigProfileNewFlag;", "isFirstTime", "setProfileCompletionTooltipShown", "shown", "setProfileCompletionWidgetClosed", "closed", "setReferralEngagementDialog", "setSettingWithFamilyAccountInfo", "setting", "Lid/dana/domain/profilemenu/model/SettingModel;", "consultFamilyAccountResult", "Lid/dana/domain/familyaccount/model/ConsultFamilyAccountResult;", "isNewMePage", "setSettingWithKybInfo", "userInfo", "Lid/dana/model/UserInfo;", "unsubscribeObserver", "uploadAvatar", "avatarFile", "Ljava/io/File;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(File file);

        void BuiltInFictitiousFunctionClassFactory(String str);

        int DatabaseTableConfigUtil();

        MyReferralConsult GetContactSyncConfig();

        long KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(String str);

        void MyBillsEntityDataFactory(boolean z);

        void NetworkUserEntityData$$ExternalSyntheticLambda0();

        void NetworkUserEntityData$$ExternalSyntheticLambda1();

        String NetworkUserEntityData$$ExternalSyntheticLambda2();

        void NetworkUserEntityData$$ExternalSyntheticLambda4();

        void NetworkUserEntityData$$ExternalSyntheticLambda5();

        void NetworkUserEntityData$$ExternalSyntheticLambda6();

        void NetworkUserEntityData$$ExternalSyntheticLambda7();

        void NetworkUserEntityData$$ExternalSyntheticLambda8();

        void PlaceComponentResult();

        void PlaceComponentResult(SettingModel settingModel, ConsultFamilyAccountResult consultFamilyAccountResult, boolean z);

        void PlaceComponentResult(UserConfigProfileNewFlag userConfigProfileNewFlag, boolean z);

        String PrepareContext();

        void getAuthRequestContext();

        void getAuthRequestContext(SettingModel settingModel, UserInfo userInfo);

        void getAuthRequestContext(String str);

        String getErrorConfigVersion();

        void initRecordTimeStamp();

        void isLayoutRequested();

        void lookAheadTest();

        String moveToNextValue();

        void newProxyInstance();

        String scheduleImpl();

        /* renamed from: id.dana.myprofile.MyProfileContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes2.dex */
        public final /* synthetic */ class CC {
        }
    }
}

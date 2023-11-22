package id.dana.di.component;

import android.content.Context;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule_ProvideProfilePresenterFactory;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule_ProvideProfileViewFactory;
import id.dana.contract.deeplink.generation.ProfileQrDeepLinkPresenter;
import id.dana.contract.deeplink.generation.ProfileQrDeepLinkPresenter_Factory;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.contract.payasset.QueryPayMethodModule;
import id.dana.contract.payasset.QueryPayMethodModule_ProvidePresenterFactory;
import id.dana.contract.payasset.QueryPayMethodModule_ProvideViewFactory;
import id.dana.contract.payasset.QueryPayMethodPresenter;
import id.dana.contract.payasset.QueryPayMethodPresenter_Factory;
import id.dana.contract.staticqr.GetStaticQrContract;
import id.dana.contract.staticqr.GetStaticQrModule;
import id.dana.contract.staticqr.GetStaticQrModule_ProvidePresenterFactory;
import id.dana.contract.staticqr.GetStaticQrModule_ProvideViewFactory;
import id.dana.contract.staticqr.GetStaticQrPresenter;
import id.dana.contract.staticqr.GetStaticQrPresenter_Factory;
import id.dana.contract.user.GetBalanceContract;
import id.dana.contract.user.GetBalanceModule;
import id.dana.contract.user.GetBalanceModule_ProvidePresenterFactory;
import id.dana.contract.user.GetBalanceModule_ProvideViewFactory;
import id.dana.contract.user.GetBalancePresenter;
import id.dana.contract.user.GetBalancePresenter_Factory;
import id.dana.danapoly.domain.clear.DanapolyClearRepository;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory;
import id.dana.di.modules.InvestmentModule;
import id.dana.di.modules.InvestmentModule_ProvideInvestmentPresenterFactory;
import id.dana.di.modules.InvestmentModule_ProvideInvestmentViewFactory;
import id.dana.di.modules.MyProfileModule;
import id.dana.di.modules.MyProfileModule_ProvidePresenterFactory;
import id.dana.di.modules.MyProfileModule_ProvideViewFactory;
import id.dana.di.modules.SavingModule;
import id.dana.di.modules.SavingModule_ProvideSavingPresenterFactory;
import id.dana.di.modules.SavingModule_ProvideSavingViewFactory;
import id.dana.di.modules.UserStatementModule;
import id.dana.di.modules.UserStatementModule_ProvidePresenterFactory;
import id.dana.di.modules.UserStatementModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetAllBalanceVisibility;
import id.dana.domain.account.interactor.GetAllBalanceVisibility_Factory;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.account.interactor.GetAvatarUrl_Factory;
import id.dana.domain.account.interactor.GetBalanceVisibility;
import id.dana.domain.account.interactor.GetBalanceVisibility_Factory;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.GetUserId_Factory;
import id.dana.domain.account.interactor.SetBalanceVisibility;
import id.dana.domain.account.interactor.SetBalanceVisibility_Factory;
import id.dana.domain.account.interactor.UploadAvatar;
import id.dana.domain.account.interactor.UploadAvatar_Factory;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.deeplink.interactor.GenerateProfileQrDeepLink;
import id.dana.domain.deeplink.interactor.GenerateProfileQrDeepLink_Factory;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload_Factory;
import id.dana.domain.deeplink.repository.DeepLinkRepository;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.familyaccount.interactor.CheckConsultFamilyAccount;
import id.dana.domain.familyaccount.interactor.CheckConsultFamilyAccount_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckGoalsBalanceFeature;
import id.dana.domain.featureconfig.interactor.CheckGoalsBalanceFeature_Factory;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature_Factory;
import id.dana.domain.featureconfig.interactor.GetPayCardConfig;
import id.dana.domain.featureconfig.interactor.GetPayCardConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetQrisTcicoConfig;
import id.dana.domain.featureconfig.interactor.GetQrisTcicoConfig_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.homeinfo.HomeWidgetClearable;
import id.dana.domain.investment.InvestmentRepository;
import id.dana.domain.investment.interactor.CheckFeatureInvestment;
import id.dana.domain.investment.interactor.CheckFeatureInvestment_Factory;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary_Factory;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.login.interactor.ForceLogout;
import id.dana.domain.login.interactor.ForceLogout_Factory;
import id.dana.domain.login.interactor.Logout;
import id.dana.domain.login.interactor.Logout_Factory;
import id.dana.domain.payasset.interactor.GetEnableAddNewCard;
import id.dana.domain.payasset.interactor.GetEnableAddNewCard_Factory;
import id.dana.domain.payasset.interactor.QueryPayMethod;
import id.dana.domain.payasset.interactor.QueryPayMethod_Factory;
import id.dana.domain.payasset.repository.PayAssetRepository;
import id.dana.domain.profilecompletion.interactor.CheckUsernameConfig;
import id.dana.domain.profilecompletion.interactor.CheckUsernameConfig_Factory;
import id.dana.domain.profilecompletion.interactor.GetProfileCompletionData;
import id.dana.domain.profilecompletion.interactor.GetProfileCompletionData_Factory;
import id.dana.domain.profilecompletion.interactor.GetProfileCompletionVisibility;
import id.dana.domain.profilecompletion.interactor.GetProfileCompletionVisibility_Factory;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.profilemenu.interactor.GetLastHideRedDotTimestamp;
import id.dana.domain.profilemenu.interactor.GetLastHideRedDotTimestamp_Factory;
import id.dana.domain.profilemenu.interactor.GetSettingCollection;
import id.dana.domain.profilemenu.interactor.GetSettingCollection_Factory;
import id.dana.domain.profilemenu.interactor.GetUserConfigProfileNewFlag;
import id.dana.domain.profilemenu.interactor.GetUserConfigProfileNewFlag_Factory;
import id.dana.domain.profilemenu.interactor.SaveLastHideRedDotTimestamp;
import id.dana.domain.profilemenu.interactor.SaveLastHideRedDotTimestamp_Factory;
import id.dana.domain.profilemenu.interactor.SaveProfileNewFlagUserConfig;
import id.dana.domain.profilemenu.interactor.SaveProfileNewFlagUserConfig_Factory;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import id.dana.domain.qrbarcode.interactor.GetUserDynamicQr;
import id.dana.domain.qrbarcode.interactor.GetUserDynamicQr_Factory;
import id.dana.domain.qrbarcode.interactor.GetUserStaticQr;
import id.dana.domain.qrbarcode.interactor.GetUserStaticQr_Factory;
import id.dana.domain.qrpay.QrPayRepository;
import id.dana.domain.qrpay.interactor.InitOfflinePay;
import id.dana.domain.qrpay.interactor.InitOfflinePay_Factory;
import id.dana.domain.qrpay.interactor.IsOfflinePayInitialized;
import id.dana.domain.qrpay.interactor.IsOfflinePayInitialized_Factory;
import id.dana.domain.qrpay.interactor.StopOfflinePay;
import id.dana.domain.qrpay.interactor.StopOfflinePay_Factory;
import id.dana.domain.recurring.subscription.RecurringSubscriptionRepository;
import id.dana.domain.recurring.subscription.interactor.GetCountRecurringSubscription;
import id.dana.domain.recurring.subscription.interactor.GetCountRecurringSubscription_Factory;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.domain.referral.ReferralRepository;
import id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache;
import id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache_Factory;
import id.dana.domain.referraltracker.ReferralTrackerRepository;
import id.dana.domain.referraltracker.interactor.GetReferralTracker;
import id.dana.domain.referraltracker.interactor.GetReferralTracker_Factory;
import id.dana.domain.registration.RegistrationRepository;
import id.dana.domain.registration.interactor.GetChatBotTimestamp;
import id.dana.domain.registration.interactor.GetChatBotTimestamp_Factory;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import id.dana.domain.saving.interactor.GetSavingEmptyState;
import id.dana.domain.saving.interactor.GetSavingEmptyState_Factory;
import id.dana.domain.saving.interactor.GetSavingSummary;
import id.dana.domain.saving.interactor.GetSavingSummary_Factory;
import id.dana.domain.saving.interactor.InitSavingCreate;
import id.dana.domain.saving.interactor.InitSavingCreate_Factory;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.interactor.ClearCacheFavoriteServices;
import id.dana.domain.services.interactor.ClearCacheFavoriteServices_Factory;
import id.dana.domain.services.interactor.GetService;
import id.dana.domain.services.interactor.GetService_Factory;
import id.dana.domain.statement.UserStatementRepository;
import id.dana.domain.statement.interactor.CheckFeatureDownloadStatement;
import id.dana.domain.statement.interactor.CheckFeatureDownloadStatement_Factory;
import id.dana.domain.statement.interactor.GetAllStatementDetail;
import id.dana.domain.statement.interactor.GetAllStatementDetail_Factory;
import id.dana.domain.statement.interactor.GetAllStatementSummary;
import id.dana.domain.statement.interactor.GetAllStatementSummary_Factory;
import id.dana.domain.statement.interactor.GetStatementDetail;
import id.dana.domain.statement.interactor.GetStatementDetail_Factory;
import id.dana.domain.statement.interactor.GetStatementDisableDetail;
import id.dana.domain.statement.interactor.GetStatementDisableDetail_Factory;
import id.dana.domain.statement.interactor.GetStatementSummary;
import id.dana.domain.statement.interactor.GetStatementSummary_Factory;
import id.dana.domain.statement.interactor.GetTotalStatements;
import id.dana.domain.statement.interactor.GetTotalStatements_Factory;
import id.dana.domain.twilio.TwilioEnrollmentEligibilityRepository;
import id.dana.domain.uploadfiles.ClearFiles;
import id.dana.domain.uploadfiles.ClearFiles_Factory;
import id.dana.domain.uploadfiles.UploadFilesRepository;
import id.dana.domain.user.interactor.GetBalance;
import id.dana.domain.user.interactor.GetBalance_Factory;
import id.dana.domain.user.interactor.GetDanaHomeBalanceConfig;
import id.dana.domain.user.interactor.GetDanaHomeBalanceConfig_Factory;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.domain.user.interactor.GetSingleBalance_Factory;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.interactor.GetUserInfoWithKyc_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip_Factory;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.domain.useremailaddress.repository.UserEmailAddressRepository;
import id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository;
import id.dana.domain.wallet_v3.interactor.GetWalletConfigFromLocal;
import id.dana.domain.wallet_v3.interactor.GetWalletConfigFromLocal_Factory;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase_Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.investment.contract.InvestmentContract;
import id.dana.investment.presenter.DanaPlusInvestmentPresenter;
import id.dana.investment.presenter.DanaPlusInvestmentPresenter_Factory;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.interactor.ClearKybData;
import id.dana.kyb.domain.interactor.ClearKybData_Factory;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.mapper.ReferralTrackerModelMapper_Factory;
import id.dana.myprofile.MyProfileContract;
import id.dana.myprofile.MyProfileFragment;
import id.dana.myprofile.MyProfileFragment_MembersInjector;
import id.dana.myprofile.MyProfilePresenter;
import id.dana.myprofile.UserInfoMapper;
import id.dana.myprofile.UserInfoMapper_Factory;
import id.dana.myprofile.settingconfig.DanaPlusSettingConfigRunner;
import id.dana.myprofile.settingconfig.DanaPlusSettingConfigRunner_Factory;
import id.dana.myprofile.settingconfig.DanaPlusStarAmSettingConfigRunner;
import id.dana.myprofile.settingconfig.DanaPlusStarAmSettingConfigRunner_Factory;
import id.dana.myprofile.settingconfig.FamilyAccountSettingConfigRunner;
import id.dana.myprofile.settingconfig.FamilyAccountSettingConfigRunner_Factory;
import id.dana.myprofile.settingconfig.GoldSettingConfigRunner;
import id.dana.myprofile.settingconfig.GoldSettingConfigRunner_Factory;
import id.dana.myprofile.settingconfig.KybSettingConfigRunner;
import id.dana.myprofile.settingconfig.KybSettingConfigRunner_Factory;
import id.dana.myprofile.settingconfig.ReferralSettingConfigRunner;
import id.dana.myprofile.settingconfig.ReferralSettingConfigRunner_Factory;
import id.dana.pay.PayCardInfoMapper_Factory;
import id.dana.referral.model.MyReferralConsultMapper;
import id.dana.referral.model.MyReferralConsultMapper_Factory;
import id.dana.savings.contract.SavingContract;
import id.dana.savings.presenter.SavingPresenter;
import id.dana.savings.presenter.SavingPresenter_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.sendmoney_v2.tracker.ApiHitTimer_Factory;
import id.dana.statement.UserStatementContract;
import id.dana.statement.UserStatementPresenter;
import id.dana.statement.UserStatementPresenter_Factory;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase_Factory;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;
import id.dana.usereducation.BottomSheetOnBoardingPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.session.DanaSessionManager;
import id.dana.utils.session.DanaSessionManager_Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerMyProfileComponent {
    private DaggerMyProfileComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public GetStaticQrModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public GenerateDeepLinkModule MyBillsEntityDataFactory;
        public UserStatementModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public GetBalanceModule PlaceComponentResult;
        public BottomSheetOnBoardingModule getAuthRequestContext;
        public MyProfileModule getErrorConfigVersion;
        public SavingModule lookAheadTest;
        public QueryPayMethodModule moveToNextValue;
        public InvestmentModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MyProfileComponentImpl implements MyProfileComponent {
        private Provider<GetAllStatementDetail> A;
        private Provider<SavingRepository> ApiStatus$AvailableSince;
        private Provider<GetProfileCompletionData> AppCompatEmojiTextHelper;
        private Provider<GetAllStatementSummary> B;
        private Provider<GetBalancePresenter> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckConsultFamilyAccount> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetAvatarUrl> C;
        private Provider<UserRepository> CYFMonitor$ChallengeActionCallback;
        private Provider<GetBottomSheetOnBoarding> D;
        private Provider<GetBalanceContract.Presenter> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<ClearAllFeedsUsecase> DatabaseTableConfigUtil;
        private Provider<GetChatBotTimestamp> E;
        private Provider<GetEnableAddNewCard> F;
        private Provider<Logout> FillAnimation;
        private Provider<ProfileQrDeepLinkPresenter> FlowViewUtil$textChanges$1;
        private Provider<PostExecutionThread> FlowViewUtil$textChanges$2;
        private Provider<ReferralTrackerRepository> FlowableCreate$BufferAsyncEmitter;
        private Provider<UserInfoMapper> FlowableKt$toIterable$1;
        private Provider<QueryPayMethod> FlowableReduce$ReduceSubscriber;
        private Provider<DeepLinkRepository> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetProfileCompletionVisibility> G;
        private Provider<ClearAllSyncEngineUseCase> GetContactSyncConfig;
        private Provider<GetLastHideRedDotTimestamp> H;
        private Provider<GetPayCardConfig> I;
        private Provider<StopOfflinePay> InitSecurePreferenceAccount;
        private Provider<GetSavingEmptyState> J;
        private Provider<RemoveDeepLinkPayload> JsonParseException;
        private Provider<GetReferralTracker> K;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetService> L;
        private Provider<GetQrisTcicoConfig> M;
        private Provider<AccountRepository> MyBillsEntityDataFactory;
        private Provider<GetSingleBalance> N;
        private Provider<ClearAllDanapolyData> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ClearFiles> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<ClearCacheFavoriteServices> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<FaceAuthPopUpConsultationRepository> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<DeviceInformationProvider> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<FamilyAccountSettingConfigRunner> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<DanaSessionManager> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<DanaPlusSettingConfigRunner> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<DanaPlusStarAmSettingConfigRunner> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<UploadAvatar> NewMerchantCategoryAdapter;
        private Provider<GetStatementDetail> O;
        private Provider<ReferralRepository> OtpRegistrationPresenter$input$1;
        private Provider<InvestmentContract.View> OtpRegistrationPresenter$input$2;
        private Provider<GetStatementDisableDetail> P;
        private Provider<BottomSheetOnBoardingPresenter> PlaceComponentResult;
        private Provider<Context> PrepareContext;
        private Provider<ServicesRepository> PromoCategoryPresenter$1;
        private Provider<GetSettingCollection> Q;
        private Provider<LoginRepository> QrExpiredActivity;
        private Provider<GetTotalStatements> R;
        private Provider<SetBalanceVisibility> ReferralMapper_Factory;
        private Provider<WalletConfigRepository> RequestMoneyQrContract$View;
        private Provider<GetUserId> S;
        private Provider<ThreadExecutor> SendMoneyScenario;
        private Provider<QueryPayMethodContract.Presenter> SizeSelectors$OrSelector;
        private Provider<GenerateProfileQrDeepLink> SubSequence;
        private Provider<GetStatementSummary> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<GetUserDynamicQr> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<GetStaticQrPresenter> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<GetWalletConfigFromLocal> T;
        private final MyProfileModule TypeProjectionImpl;
        private Provider<UserStatementContract.View> TypefaceCompatApi26Impl;
        private Provider<GlobalNetworkRepository> U;
        private Provider<GetUserStaticQr> V;
        private Provider<GetBalance> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetBalanceVisibility> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<GetUserInfoWithKyc> W;
        private Provider<GetUserInvestmentSummary> X;
        private Provider<GoldSettingConfigRunner> Y;
        private Provider<InitSavingCreate> Z;

        /* renamed from: a */
        private Provider<KybRepository> f8132a;
        private Provider<SavingCategoryRepository> access$getCapacity$p;
        private Provider<TwilioEnrollmentEligibilityRepository> access$setShowcaseShowing$p;
        private Provider<FamilyAccountRepository> access$throwIllegalArgumentType;
        private Provider<KybSettingConfigRunner> b;
        private Provider<LiteAccountRepository> c;
        private Provider<SaveReferralEngagementDialogCache> checkRegisteredUserAndSendOtp;
        private Provider<PayAssetRepository> connectForeground;
        private Provider<IsOfflinePayInitialized> d;
        private final MyProfileComponentImpl e;
        private Provider<MyReferralConsultRepository> f;
        private Provider<IsNeedToShowToolTip> flip;
        private Provider<MyReferralConsultMapper> g;
        private Provider<CheckFeatureDownloadStatement> getAuthRequestContext;
        private Provider<ForceLogout> getCallingPid;
        private Provider<ReferralSettingConfigRunner> getCardNumberOCR;
        private Provider<RegistrationRepository> getContainerAuth;
        private Provider<SaveProfileNewFlagUserConfig> getDefaultSenderId;
        private Provider<CheckFeatureInvestment> getErrorConfigVersion;
        private Provider<UserStatementPresenter> getFontAssetManager;
        private Provider<SavingPresenter> getIndexName;
        private Provider<GetSavingSummary> getNameOrBuilderList;
        private Provider<GetCountRecurringSubscription> getOnBoardingScenario;
        private Provider<UserEmailAddressRepository> getReadyFragment;
        private Provider<FeatureConfigRepository> getSupportButtonTintMode;
        private Provider<GetDanaHomeBalanceConfig> getValueOfTouchPositionAbsolute;
        private Provider<BottomSheetOnBoardingContract.Presenter> h;
        private Provider<BottomSheetOnBoardingContract.View> i;
        private Provider<MyProfileContract.View> initAnimators;
        private Provider<ClearKybData> initRecordTimeStamp;
        private Provider<UserEducationRepository> insertActivities;
        private Provider<GetUserConfigProfileNewFlag> isAuth;
        private Provider<IsOfflineF2FPay> isAuto;
        private Provider<ContactRepository> isLayoutRequested;
        private Provider<UserSecurityQuestionStateRepository> isRegionMiniProgram;
        private Provider<InvestmentContract.Presenter> j;
        private Provider<HomeWidgetClearable> k;
        private Provider<FeedInitRepository> l;
        private Provider<CheckGoalsBalanceFeature> lookAheadTest;
        private Provider<DanapolyClearRepository> m;
        private Provider<CheckUsernameConfig> moveToNextValue;
        private Provider<GetStaticQrContract.Presenter> n;
        private Provider<DanaPlusInvestmentPresenter> newProxyInstance;

        /* renamed from: o */
        private Provider<UserStatementContract.Presenter> f8133o;
        private Provider<SaveDisplayBottomSheetOnBoarding> onDecodeSuccess;
        private Provider<InvestmentRepository> p;
        private Provider<SavingContract.Presenter> q;
        private Provider<RecurringSubscriptionRepository> r;
        private Provider<GetAllBalanceVisibility> readMicros;

        /* renamed from: reduceIndexed-z1zDJgo */
        private Provider<SaveShowToolTip> f5859reduceIndexedz1zDJgo;
        private Provider<SettingRepository> retainOrRemoveAllInternal;
        private Provider<UserStatementRepository> rotateTo;
        private Provider<GenerateDeepLinkContract.ProfilePresenter> s;
        private Provider<CheckShowReferralCodeFeature> scheduleImpl;
        private Provider<SaveLastHideRedDotTimestamp> secondaryHash;
        private Provider<QrBarcodeRepository> setNetAuthId;
        private Provider<InitOfflinePay> shouldRecycleViewType;
        private Provider<GenerateDeepLinkContract.ProfileView> t;
        private Provider<GetBalanceContract.View> u;
        private Provider<GetStaticQrContract.View> v;
        private Provider<QueryPayMethodPresenter> verifyNotNull;
        private Provider<SavingContract.View> w;
        private Provider<GenerateLinkRepository> whenAvailable;
        private Provider<UploadFilesRepository> x;
        private Provider<QueryPayMethodContract.View> y;
        private Provider<QrPayRepository> z;

        public /* synthetic */ MyProfileComponentImpl(MyProfileModule myProfileModule, GetBalanceModule getBalanceModule, GetStaticQrModule getStaticQrModule, GenerateDeepLinkModule generateDeepLinkModule, QueryPayMethodModule queryPayMethodModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, UserStatementModule userStatementModule, SavingModule savingModule, InvestmentModule investmentModule, ApplicationComponent applicationComponent, byte b) {
            this(myProfileModule, getBalanceModule, getStaticQrModule, generateDeepLinkModule, queryPayMethodModule, bottomSheetOnBoardingModule, userStatementModule, savingModule, investmentModule, applicationComponent);
        }

        private MyProfileComponentImpl(MyProfileModule myProfileModule, GetBalanceModule getBalanceModule, GetStaticQrModule getStaticQrModule, GenerateDeepLinkModule generateDeepLinkModule, QueryPayMethodModule queryPayMethodModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, UserStatementModule userStatementModule, SavingModule savingModule, InvestmentModule investmentModule, ApplicationComponent applicationComponent) {
            ApiHitTimer_Factory apiHitTimer_Factory;
            ApiHitTimer_Factory apiHitTimer_Factory2;
            PayCardInfoMapper_Factory payCardInfoMapper_Factory;
            this.e = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.TypeProjectionImpl = myProfileModule;
            this.u = DoubleCheck.getAuthRequestContext(GetBalanceModule_ProvideViewFactory.MyBillsEntityDataFactory(getBalanceModule));
            this.SendMoneyScenario = new ThreadExecutorProvider(applicationComponent);
            this.FlowViewUtil$textChanges$2 = new PostExecutionThreadProvider(applicationComponent);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.CYFMonitor$ChallengeActionCallback = userRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = GetBalance_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, userRepositoryProvider);
            this.N = GetSingleBalance_Factory.create(this.CYFMonitor$ChallengeActionCallback);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = accountRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetBalanceVisibility_Factory.create(accountRepositoryProvider);
            this.ReferralMapper_Factory = SetBalanceVisibility_Factory.create(this.MyBillsEntityDataFactory);
            this.readMicros = GetAllBalanceVisibility_Factory.create(this.MyBillsEntityDataFactory);
            this.getValueOfTouchPositionAbsolute = GetDanaHomeBalanceConfig_Factory.create(this.CYFMonitor$ChallengeActionCallback);
            ProvideInvestmentRepositoryProvider provideInvestmentRepositoryProvider = new ProvideInvestmentRepositoryProvider(applicationComponent);
            this.p = provideInvestmentRepositoryProvider;
            this.X = GetUserInvestmentSummary_Factory.create(provideInvestmentRepositoryProvider);
            Provider<GetBalancePresenter> authRequestContext = DoubleCheck.getAuthRequestContext(GetBalancePresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.u, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.N, CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.VerifyPinStateManager$executeRiskChallenge$2$2, this.ReferralMapper_Factory, this.readMicros, this.getValueOfTouchPositionAbsolute, this.X));
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = authRequestContext;
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = DoubleCheck.getAuthRequestContext(GetBalanceModule_ProvidePresenterFactory.getAuthRequestContext(getBalanceModule, authRequestContext));
            this.PrepareContext = new ContextProvider(applicationComponent);
            this.v = DoubleCheck.getAuthRequestContext(GetStaticQrModule_ProvideViewFactory.MyBillsEntityDataFactory(getStaticQrModule));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.setNetAuthId = qrBarcodeRepositoryProvider;
            this.V = GetUserStaticQr_Factory.create(qrBarcodeRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getSupportButtonTintMode = featureConfigRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = GetUserDynamicQr_Factory.create(this.setNetAuthId, featureConfigRepositoryProvider);
            GetQrisTcicoConfig_Factory create = GetQrisTcicoConfig_Factory.create(this.getSupportButtonTintMode);
            this.M = create;
            Provider<Context> provider = this.PrepareContext;
            Provider<GetStaticQrContract.View> provider2 = this.v;
            Provider<GetUserStaticQr> provider3 = this.V;
            Provider<GetUserDynamicQr> provider4 = this.SummaryVoucherView$$ExternalSyntheticLambda1;
            apiHitTimer_Factory = ApiHitTimer_Factory.InstanceHolder.getAuthRequestContext;
            Provider<GetStaticQrPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(GetStaticQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(provider, provider2, provider3, provider4, create, apiHitTimer_Factory));
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = authRequestContext2;
            this.n = DoubleCheck.getAuthRequestContext(GetStaticQrModule_ProvidePresenterFactory.PlaceComponentResult(getStaticQrModule, authRequestContext2));
            this.TypefaceCompatApi26Impl = DoubleCheck.getAuthRequestContext(UserStatementModule_ProvideViewFactory.getAuthRequestContext(userStatementModule));
            UserStatementRepositoryProvider userStatementRepositoryProvider = new UserStatementRepositoryProvider(applicationComponent);
            this.rotateTo = userStatementRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = GetStatementSummary_Factory.create(userStatementRepositoryProvider);
            this.O = GetStatementDetail_Factory.create(this.rotateTo);
            this.B = GetAllStatementSummary_Factory.create(this.rotateTo);
            this.R = GetTotalStatements_Factory.create(this.rotateTo);
            this.A = GetAllStatementDetail_Factory.create(this.rotateTo);
            this.getAuthRequestContext = CheckFeatureDownloadStatement_Factory.create(this.getSupportButtonTintMode);
            GetStatementDisableDetail_Factory create2 = GetStatementDisableDetail_Factory.create(this.getSupportButtonTintMode);
            this.P = create2;
            Provider<UserStatementPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(UserStatementPresenter_Factory.getAuthRequestContext(this.TypefaceCompatApi26Impl, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.O, this.B, this.R, this.A, this.getAuthRequestContext, create2));
            this.getFontAssetManager = authRequestContext3;
            this.f8133o = DoubleCheck.getAuthRequestContext(UserStatementModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(userStatementModule, authRequestContext3));
            this.initAnimators = MyProfileModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(myProfileModule);
            this.FlowableKt$toIterable$1 = UserInfoMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.NewMerchantCategoryAdapter = UploadAvatar_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, this.MyBillsEntityDataFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new DeviceInformationProviderProvider(applicationComponent);
            this.QrExpiredActivity = new LoginRepositoryProvider(applicationComponent);
            this.U = new GlobalNetworkRepositoryProvider(applicationComponent);
            ProvideHomeWidgetClearableProvider provideHomeWidgetClearableProvider = new ProvideHomeWidgetClearableProvider(applicationComponent);
            this.k = provideHomeWidgetClearableProvider;
            this.getCallingPid = ForceLogout_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, this.QrExpiredActivity, this.U, provideHomeWidgetClearableProvider);
            this.FillAnimation = Logout_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, this.QrExpiredActivity, this.k, this.U);
            ContractRepositoryProvider contractRepositoryProvider = new ContractRepositoryProvider(applicationComponent);
            this.isLayoutRequested = contractRepositoryProvider;
            this.GetContactSyncConfig = ClearAllSyncEngineUseCase_Factory.PlaceComponentResult(contractRepositoryProvider);
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.l = provideFeedInitRepositoryProvider;
            this.DatabaseTableConfigUtil = ClearAllFeedsUsecase_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideFeedInitRepositoryProvider);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.PromoCategoryPresenter$1 = servicesRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = ClearCacheFavoriteServices_Factory.create(servicesRepositoryProvider);
            ProvideDanapolyClearRepositoryProvider provideDanapolyClearRepositoryProvider = new ProvideDanapolyClearRepositoryProvider(applicationComponent);
            this.m = provideDanapolyClearRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ClearAllDanapolyData_Factory.MyBillsEntityDataFactory(provideDanapolyClearRepositoryProvider);
            KybRepositoryProvider kybRepositoryProvider = new KybRepositoryProvider(applicationComponent);
            this.f8132a = kybRepositoryProvider;
            ClearKybData_Factory authRequestContext4 = ClearKybData_Factory.getAuthRequestContext(kybRepositoryProvider);
            this.initRecordTimeStamp = authRequestContext4;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = DanaSessionManager_Factory.getAuthRequestContext(this.PrepareContext, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.getCallingPid, this.FillAnimation, this.GetContactSyncConfig, this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, authRequestContext4);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.insertActivities = userEducationRepositoryProvider;
            this.flip = IsNeedToShowToolTip_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, userEducationRepositoryProvider);
            this.f5859reduceIndexedz1zDJgo = SaveShowToolTip_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, this.insertActivities);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new FaceAuthPopUpConsultationRepositoryProvider(applicationComponent);
            this.access$setShowcaseShowing$p = new TwilioEnrollmentEligibilityRepositoryProvider(applicationComponent);
            this.getReadyFragment = new UserEmailAddressRepositoryProvider(applicationComponent);
            UserSecurityQuestionStateRepositoryProvider userSecurityQuestionStateRepositoryProvider = new UserSecurityQuestionStateRepositoryProvider(applicationComponent);
            this.isRegionMiniProgram = userSecurityQuestionStateRepositoryProvider;
            this.AppCompatEmojiTextHelper = GetProfileCompletionData_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.access$setShowcaseShowing$p, this.CYFMonitor$ChallengeActionCallback, this.getReadyFragment, userSecurityQuestionStateRepositoryProvider);
            this.G = GetProfileCompletionVisibility_Factory.create(this.getSupportButtonTintMode);
            this.moveToNextValue = CheckUsernameConfig_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, this.getSupportButtonTintMode);
            this.W = GetUserInfoWithKyc_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, this.CYFMonitor$ChallengeActionCallback);
            this.C = GetAvatarUrl_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, this.MyBillsEntityDataFactory);
            SettingRepositoryProvider settingRepositoryProvider = new SettingRepositoryProvider(applicationComponent);
            this.retainOrRemoveAllInternal = settingRepositoryProvider;
            this.Q = GetSettingCollection_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, settingRepositoryProvider);
            this.scheduleImpl = CheckShowReferralCodeFeature_Factory.create(this.getSupportButtonTintMode);
            this.g = MyReferralConsultMapper_Factory.BuiltInFictitiousFunctionClassFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.b = KybSettingConfigRunner_Factory.getAuthRequestContext(this.CYFMonitor$ChallengeActionCallback, this.PrepareContext, this.FlowableKt$toIterable$1);
            this.whenAvailable = new GenerateLinkRepositoryProvider(applicationComponent);
            MyReferralConsultRepositoryProvider myReferralConsultRepositoryProvider = new MyReferralConsultRepositoryProvider(applicationComponent);
            this.f = myReferralConsultRepositoryProvider;
            this.getCardNumberOCR = ReferralSettingConfigRunner_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.whenAvailable, myReferralConsultRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = DanaPlusSettingConfigRunner_Factory.PlaceComponentResult(this.PrepareContext, this.X);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = DanaPlusStarAmSettingConfigRunner_Factory.BuiltInFictitiousFunctionClassFactory(this.PrepareContext, this.X);
            this.Y = GoldSettingConfigRunner_Factory.MyBillsEntityDataFactory(this.PrepareContext, this.X);
            ReferralRepositoryProvider referralRepositoryProvider = new ReferralRepositoryProvider(applicationComponent);
            this.OtpRegistrationPresenter$input$1 = referralRepositoryProvider;
            this.checkRegisteredUserAndSendOtp = SaveReferralEngagementDialogCache_Factory.create(referralRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = FamilyAccountSettingConfigRunner_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext);
            ProvideFamilyAccountRepositoryProvider provideFamilyAccountRepositoryProvider = new ProvideFamilyAccountRepositoryProvider(applicationComponent);
            this.access$throwIllegalArgumentType = provideFamilyAccountRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = CheckConsultFamilyAccount_Factory.create(provideFamilyAccountRepositoryProvider);
            ProvideUploadFilesRepositoryProvider provideUploadFilesRepositoryProvider = new ProvideUploadFilesRepositoryProvider(applicationComponent);
            this.x = provideUploadFilesRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = ClearFiles_Factory.create(provideUploadFilesRepositoryProvider);
            ProvideWalletConfigRepositoryProvider provideWalletConfigRepositoryProvider = new ProvideWalletConfigRepositoryProvider(applicationComponent);
            this.RequestMoneyQrContract$View = provideWalletConfigRepositoryProvider;
            this.T = GetWalletConfigFromLocal_Factory.create(provideWalletConfigRepositoryProvider);
            ReferralTrackerRepositoryProvider referralTrackerRepositoryProvider = new ReferralTrackerRepositoryProvider(applicationComponent);
            this.FlowableCreate$BufferAsyncEmitter = referralTrackerRepositoryProvider;
            this.K = GetReferralTracker_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, referralTrackerRepositoryProvider);
            this.isAuth = GetUserConfigProfileNewFlag_Factory.create(this.retainOrRemoveAllInternal);
            this.getDefaultSenderId = SaveProfileNewFlagUserConfig_Factory.create(this.retainOrRemoveAllInternal);
            DeepLinkRepositoryProvider deepLinkRepositoryProvider = new DeepLinkRepositoryProvider(applicationComponent);
            this.FragmentBottomSheetPaymentSettingBinding = deepLinkRepositoryProvider;
            this.JsonParseException = RemoveDeepLinkPayload_Factory.create(deepLinkRepositoryProvider);
            ProvideRecurringSubscriptionRepositoryProvider provideRecurringSubscriptionRepositoryProvider = new ProvideRecurringSubscriptionRepositoryProvider(applicationComponent);
            this.r = provideRecurringSubscriptionRepositoryProvider;
            this.getOnBoardingScenario = GetCountRecurringSubscription_Factory.create(provideRecurringSubscriptionRepositoryProvider);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.c = liteAccountRepositoryProvider;
            this.S = GetUserId_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, liteAccountRepositoryProvider);
            RegistrationRepositoryProvider registrationRepositoryProvider = new RegistrationRepositoryProvider(applicationComponent);
            this.getContainerAuth = registrationRepositoryProvider;
            this.E = GetChatBotTimestamp_Factory.create(registrationRepositoryProvider);
            this.H = GetLastHideRedDotTimestamp_Factory.create(this.retainOrRemoveAllInternal);
            this.secondaryHash = SaveLastHideRedDotTimestamp_Factory.create(this.retainOrRemoveAllInternal);
            this.L = GetService_Factory.create(this.PromoCategoryPresenter$1);
            this.SubSequence = GenerateProfileQrDeepLink_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, this.whenAvailable);
            Provider<GenerateDeepLinkContract.ProfileView> authRequestContext5 = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideProfileViewFactory.MyBillsEntityDataFactory(generateDeepLinkModule));
            this.t = authRequestContext5;
            Provider<Context> provider5 = this.PrepareContext;
            Provider<GenerateProfileQrDeepLink> provider6 = this.SubSequence;
            apiHitTimer_Factory2 = ApiHitTimer_Factory.InstanceHolder.getAuthRequestContext;
            Provider<ProfileQrDeepLinkPresenter> authRequestContext6 = DoubleCheck.getAuthRequestContext(ProfileQrDeepLinkPresenter_Factory.PlaceComponentResult(provider5, provider6, authRequestContext5, apiHitTimer_Factory2));
            this.FlowViewUtil$textChanges$1 = authRequestContext6;
            this.s = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideProfilePresenterFactory.PlaceComponentResult(generateDeepLinkModule, authRequestContext6));
            this.y = DoubleCheck.getAuthRequestContext(QueryPayMethodModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(queryPayMethodModule));
            PayAssetRepositoryProvider payAssetRepositoryProvider = new PayAssetRepositoryProvider(applicationComponent);
            this.connectForeground = payAssetRepositoryProvider;
            this.F = GetEnableAddNewCard_Factory.create(payAssetRepositoryProvider);
            this.FlowableReduce$ReduceSubscriber = QueryPayMethod_Factory.create(this.connectForeground);
            this.isAuto = IsOfflineF2FPay_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, this.getSupportButtonTintMode);
            QrPayRepositoryProvider qrPayRepositoryProvider = new QrPayRepositoryProvider(applicationComponent);
            this.z = qrPayRepositoryProvider;
            this.shouldRecycleViewType = InitOfflinePay_Factory.create(qrPayRepositoryProvider);
            this.InitSecurePreferenceAccount = StopOfflinePay_Factory.create(this.z);
            this.d = IsOfflinePayInitialized_Factory.create(this.z);
            this.I = GetPayCardConfig_Factory.create(this.getSupportButtonTintMode, this.connectForeground);
            Provider<QueryPayMethodContract.View> provider7 = this.y;
            Provider<GetEnableAddNewCard> provider8 = this.F;
            Provider<QueryPayMethod> provider9 = this.FlowableReduce$ReduceSubscriber;
            payCardInfoMapper_Factory = PayCardInfoMapper_Factory.InstanceHolder.BuiltInFictitiousFunctionClassFactory;
            Provider<QueryPayMethodPresenter> authRequestContext7 = DoubleCheck.getAuthRequestContext(QueryPayMethodPresenter_Factory.MyBillsEntityDataFactory(provider7, provider8, provider9, payCardInfoMapper_Factory, this.isAuto, this.shouldRecycleViewType, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.InitSecurePreferenceAccount, this.d, this.PrepareContext, this.I));
            this.verifyNotNull = authRequestContext7;
            this.SizeSelectors$OrSelector = DoubleCheck.getAuthRequestContext(QueryPayMethodModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(queryPayMethodModule, authRequestContext7));
            this.i = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            this.D = GetBottomSheetOnBoarding_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, this.insertActivities);
            SaveDisplayBottomSheetOnBoarding_Factory create3 = SaveDisplayBottomSheetOnBoarding_Factory.create(this.SendMoneyScenario, this.FlowViewUtil$textChanges$2, this.insertActivities);
            this.onDecodeSuccess = create3;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.i, this.D, create3);
            this.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
            this.h = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory));
            this.w = DoubleCheck.getAuthRequestContext(SavingModule_ProvideSavingViewFactory.MyBillsEntityDataFactory(savingModule));
            this.ApiStatus$AvailableSince = new SavingRepositoryProvider(applicationComponent);
            SavingCategoryRepositoryProvider savingCategoryRepositoryProvider = new SavingCategoryRepositoryProvider(applicationComponent);
            this.access$getCapacity$p = savingCategoryRepositoryProvider;
            this.getNameOrBuilderList = GetSavingSummary_Factory.create(this.ApiStatus$AvailableSince, savingCategoryRepositoryProvider);
            this.Z = InitSavingCreate_Factory.create(this.ApiStatus$AvailableSince, this.access$getCapacity$p);
            this.lookAheadTest = CheckGoalsBalanceFeature_Factory.create(this.getSupportButtonTintMode);
            GetSavingEmptyState_Factory create4 = GetSavingEmptyState_Factory.create(this.ApiStatus$AvailableSince);
            this.J = create4;
            Provider<SavingPresenter> authRequestContext8 = DoubleCheck.getAuthRequestContext(SavingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.w, this.getNameOrBuilderList, this.W, this.Z, this.lookAheadTest, create4));
            this.getIndexName = authRequestContext8;
            this.q = DoubleCheck.getAuthRequestContext(SavingModule_ProvideSavingPresenterFactory.BuiltInFictitiousFunctionClassFactory(savingModule, authRequestContext8));
            this.OtpRegistrationPresenter$input$2 = DoubleCheck.getAuthRequestContext(InvestmentModule_ProvideInvestmentViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(investmentModule));
            CheckFeatureInvestment_Factory create5 = CheckFeatureInvestment_Factory.create(this.getSupportButtonTintMode);
            this.getErrorConfigVersion = create5;
            Provider<DanaPlusInvestmentPresenter> authRequestContext9 = DoubleCheck.getAuthRequestContext(DanaPlusInvestmentPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.OtpRegistrationPresenter$input$2, create5, this.X));
            this.newProxyInstance = authRequestContext9;
            this.j = DoubleCheck.getAuthRequestContext(InvestmentModule_ProvideInvestmentPresenterFactory.PlaceComponentResult(investmentModule, authRequestContext9));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent getAuthRequestContext;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.getAuthRequestContext.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BannerEntityDataFactory_Factory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideInvestmentRepositoryProvider implements Provider<InvestmentRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideInvestmentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ InvestmentRepository get() {
                return (InvestmentRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.TypefaceCompatApi26Impl());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class QrBarcodeRepositoryProvider implements Provider<QrBarcodeRepository> {
            private final ApplicationComponent getAuthRequestContext;

            QrBarcodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrBarcodeRepository get() {
                return (QrBarcodeRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.SendMoneyScenario());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserStatementRepositoryProvider implements Provider<UserStatementRepository> {
            private final ApplicationComponent getAuthRequestContext;

            UserStatementRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserStatementRepository get() {
                return (UserStatementRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.DebugCoroutineInfoImpl());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class LoginRepositoryProvider implements Provider<LoginRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            LoginRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LoginRepository get() {
                return (LoginRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.G());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class GlobalNetworkRepositoryProvider implements Provider<GlobalNetworkRepository> {
            private final ApplicationComponent PlaceComponentResult;

            GlobalNetworkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalNetworkRepository get() {
                return (GlobalNetworkRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SubSequence());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideHomeWidgetClearableProvider implements Provider<HomeWidgetClearable> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideHomeWidgetClearableProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ HomeWidgetClearable get() {
                return (HomeWidgetClearable) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.r());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContractRepositoryProvider implements Provider<ContactRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ContractRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContactRepository get() {
                return (ContactRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFeedInitRepositoryProvider implements Provider<FeedInitRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideFeedInitRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedInitRepository get() {
                return (FeedInitRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.l());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ServicesRepositoryProvider implements Provider<ServicesRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.SecuritySettingsActivity$createPinLauncher$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideDanapolyClearRepositoryProvider implements Provider<DanapolyClearRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideDanapolyClearRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DanapolyClearRepository get() {
                return (DanapolyClearRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.i());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class KybRepositoryProvider implements Provider<KybRepository> {
            private final ApplicationComponent getAuthRequestContext;

            KybRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ KybRepository get() {
                return (KybRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.VerifyPinStateManager$executeRiskChallenge$2$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ArrayTable$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FaceAuthPopUpConsultationRepositoryProvider implements Provider<FaceAuthPopUpConsultationRepository> {
            private final ApplicationComponent PlaceComponentResult;

            FaceAuthPopUpConsultationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FaceAuthPopUpConsultationRepository get() {
                return (FaceAuthPopUpConsultationRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda3());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class TwilioEnrollmentEligibilityRepositoryProvider implements Provider<TwilioEnrollmentEligibilityRepository> {
            private final ApplicationComponent getAuthRequestContext;

            TwilioEnrollmentEligibilityRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ TwilioEnrollmentEligibilityRepository get() {
                return (TwilioEnrollmentEligibilityRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.mo2240x461046d9());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserEmailAddressRepositoryProvider implements Provider<UserEmailAddressRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserEmailAddressRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEmailAddressRepository get() {
                return (UserEmailAddressRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.mo2241x461046da());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserSecurityQuestionStateRepositoryProvider implements Provider<UserSecurityQuestionStateRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserSecurityQuestionStateRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserSecurityQuestionStateRepository get() {
                return (UserSecurityQuestionStateRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getPhoneMask());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SettingRepositoryProvider implements Provider<SettingRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SettingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SettingRepository get() {
                return (SettingRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isInfoWindowShown());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class GenerateLinkRepositoryProvider implements Provider<GenerateLinkRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            GenerateLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GenerateLinkRepository get() {
                return (GenerateLinkRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda6());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class MyReferralConsultRepositoryProvider implements Provider<MyReferralConsultRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            MyReferralConsultRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MyReferralConsultRepository get() {
                return (MyReferralConsultRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.P());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ReferralRepositoryProvider implements Provider<ReferralRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ReferralRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ReferralRepository get() {
                return (ReferralRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NewMerchantCategoryAdapter());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFamilyAccountRepositoryProvider implements Provider<FamilyAccountRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideFamilyAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FamilyAccountRepository get() {
                return (FamilyAccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.k());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideUploadFilesRepositoryProvider implements Provider<UploadFilesRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideUploadFilesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UploadFilesRepository get() {
                return (UploadFilesRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.ApiStatus$AvailableSince());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideWalletConfigRepositoryProvider implements Provider<WalletConfigRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideWalletConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ WalletConfigRepository get() {
                return (WalletConfigRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getIndexName());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ReferralTrackerRepositoryProvider implements Provider<ReferralTrackerRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ReferralTrackerRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ReferralTrackerRepository get() {
                return (ReferralTrackerRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.getReadyFragment());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DeepLinkRepositoryProvider implements Provider<DeepLinkRepository> {
            private final ApplicationComponent getAuthRequestContext;

            DeepLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeepLinkRepository get() {
                return (DeepLinkRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideRecurringSubscriptionRepositoryProvider implements Provider<RecurringSubscriptionRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideRecurringSubscriptionRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecurringSubscriptionRepository get() {
                return (RecurringSubscriptionRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.OtpRegistrationPresenter$input$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent PlaceComponentResult;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.AppCompatEmojiTextHelper());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class RegistrationRepositoryProvider implements Provider<RegistrationRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            RegistrationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RegistrationRepository get() {
                return (RegistrationRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.rotateTo());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PayAssetRepositoryProvider implements Provider<PayAssetRepository> {
            private final ApplicationComponent PlaceComponentResult;

            PayAssetRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PayAssetRepository get() {
                return (PayAssetRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.X());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class QrPayRepositoryProvider implements Provider<QrPayRepository> {
            private final ApplicationComponent getAuthRequestContext;

            QrPayRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrPayRepository get() {
                return (QrPayRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.PromoCategoryPresenter$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SavingRepositoryProvider implements Provider<SavingRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SavingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SavingRepository get() {
                return (SavingRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.useDaemonThreadFactory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SavingCategoryRepositoryProvider implements Provider<SavingCategoryRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SavingCategoryRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SavingCategoryRepository get() {
                return (SavingCategoryRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getTextEndPadding());
            }
        }

        @Override // id.dana.di.component.MyProfileComponent
        public final void getAuthRequestContext(MyProfileFragment myProfileFragment) {
            ReferralTrackerModelMapper_Factory referralTrackerModelMapper_Factory;
            MyProfileFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(myProfileFragment, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider.get());
            MyProfileFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(myProfileFragment, this.n.get());
            myProfileFragment.getUserStatementPresenter = this.f8133o.get();
            myProfileFragment.productPageManager = (ProductPageManager) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.shouldRecycleViewType());
            MyProfileFragment_MembersInjector.PlaceComponentResult(myProfileFragment, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.PrepareContext()));
            MyProfileModule myProfileModule = this.TypeProjectionImpl;
            Lazy MyBillsEntityDataFactory = DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext);
            Lazy MyBillsEntityDataFactory2 = DoubleCheck.MyBillsEntityDataFactory(this.initAnimators);
            Lazy MyBillsEntityDataFactory3 = DoubleCheck.MyBillsEntityDataFactory(this.FlowableKt$toIterable$1);
            Lazy MyBillsEntityDataFactory4 = DoubleCheck.MyBillsEntityDataFactory(this.NewMerchantCategoryAdapter);
            Lazy MyBillsEntityDataFactory5 = DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            Lazy MyBillsEntityDataFactory6 = DoubleCheck.MyBillsEntityDataFactory(this.flip);
            Lazy MyBillsEntityDataFactory7 = DoubleCheck.MyBillsEntityDataFactory(this.f5859reduceIndexedz1zDJgo);
            Lazy MyBillsEntityDataFactory8 = DoubleCheck.MyBillsEntityDataFactory(this.AppCompatEmojiTextHelper);
            Lazy MyBillsEntityDataFactory9 = DoubleCheck.MyBillsEntityDataFactory(this.G);
            Lazy MyBillsEntityDataFactory10 = DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue);
            Lazy MyBillsEntityDataFactory11 = DoubleCheck.MyBillsEntityDataFactory(this.W);
            Lazy MyBillsEntityDataFactory12 = DoubleCheck.MyBillsEntityDataFactory(this.C);
            Lazy MyBillsEntityDataFactory13 = DoubleCheck.MyBillsEntityDataFactory(this.Q);
            Lazy MyBillsEntityDataFactory14 = DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl);
            Lazy MyBillsEntityDataFactory15 = DoubleCheck.MyBillsEntityDataFactory(this.g);
            Lazy MyBillsEntityDataFactory16 = DoubleCheck.MyBillsEntityDataFactory(this.b);
            Lazy MyBillsEntityDataFactory17 = DoubleCheck.MyBillsEntityDataFactory(this.getCardNumberOCR);
            Lazy MyBillsEntityDataFactory18 = DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            Lazy MyBillsEntityDataFactory19 = DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            Lazy MyBillsEntityDataFactory20 = DoubleCheck.MyBillsEntityDataFactory(this.Y);
            Lazy MyBillsEntityDataFactory21 = DoubleCheck.MyBillsEntityDataFactory(this.checkRegisteredUserAndSendOtp);
            Lazy MyBillsEntityDataFactory22 = DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            Lazy MyBillsEntityDataFactory23 = DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
            Lazy MyBillsEntityDataFactory24 = DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            Lazy MyBillsEntityDataFactory25 = DoubleCheck.MyBillsEntityDataFactory(this.T);
            Lazy MyBillsEntityDataFactory26 = DoubleCheck.MyBillsEntityDataFactory(this.K);
            referralTrackerModelMapper_Factory = ReferralTrackerModelMapper_Factory.InstanceHolder.getAuthRequestContext;
            myProfileFragment.myProfilePresenter = MyProfileModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(myProfileModule, new MyProfilePresenter(MyBillsEntityDataFactory, MyBillsEntityDataFactory2, MyBillsEntityDataFactory3, MyBillsEntityDataFactory4, MyBillsEntityDataFactory5, MyBillsEntityDataFactory6, MyBillsEntityDataFactory7, MyBillsEntityDataFactory8, MyBillsEntityDataFactory9, MyBillsEntityDataFactory10, MyBillsEntityDataFactory11, MyBillsEntityDataFactory12, MyBillsEntityDataFactory13, MyBillsEntityDataFactory14, MyBillsEntityDataFactory15, MyBillsEntityDataFactory16, MyBillsEntityDataFactory17, MyBillsEntityDataFactory18, MyBillsEntityDataFactory19, MyBillsEntityDataFactory20, MyBillsEntityDataFactory21, MyBillsEntityDataFactory22, MyBillsEntityDataFactory23, MyBillsEntityDataFactory24, MyBillsEntityDataFactory25, MyBillsEntityDataFactory26, DoubleCheck.MyBillsEntityDataFactory(referralTrackerModelMapper_Factory), DoubleCheck.MyBillsEntityDataFactory(this.isAuth), DoubleCheck.MyBillsEntityDataFactory(this.getDefaultSenderId), DoubleCheck.MyBillsEntityDataFactory(this.JsonParseException), DoubleCheck.MyBillsEntityDataFactory(this.getOnBoardingScenario), DoubleCheck.MyBillsEntityDataFactory(this.S), DoubleCheck.MyBillsEntityDataFactory(this.E), DoubleCheck.MyBillsEntityDataFactory(this.H), DoubleCheck.MyBillsEntityDataFactory(this.secondaryHash), DoubleCheck.MyBillsEntityDataFactory(this.L)));
            MyProfileFragment_MembersInjector.PlaceComponentResult(myProfileFragment, this.s.get());
            MyProfileFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(myProfileFragment, this.SizeSelectors$OrSelector.get());
            MyProfileFragment_MembersInjector.getAuthRequestContext(myProfileFragment, this.h.get());
            myProfileFragment.savingPresenter = this.q.get();
            myProfileFragment.investmentPresenter = this.j.get();
        }
    }
}

package id.dana.di.component;

import android.content.Context;
import com.google.gson.Gson;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.analytics.firebase.FirebaseAnalytics;
import id.dana.analytics.firebase.FirebaseAnalytics_Factory;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.fullstory.FullStoryAnalytics;
import id.dana.analytics.fullstory.FullStoryAnalytics_Factory;
import id.dana.analytics.mixpanel.MixpanelAnalytics;
import id.dana.analytics.mixpanel.MixpanelAnalytics_Factory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.AnalyticsTrackerFactory_Factory;
import id.dana.analytics.tracker.EventTrackerQueue;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.cashier.CashierAddOnContract;
import id.dana.cashier.CashierAddOnModule;
import id.dana.cashier.CashierAddOnModule_ProvideCashierAddOnPresenterFactory;
import id.dana.cashier.CashierAddOnModule_ProvideCashierAddOnViewFactory;
import id.dana.cashier.CashierCardBindingContract;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierCardBindingModule_ProvideCashierCardBindingViewFactory;
import id.dana.cashier.CashierContract;
import id.dana.cashier.CashierHighlightContract;
import id.dana.cashier.CashierHighlightModule;
import id.dana.cashier.CashierHighlightModule_ProvideCashierHighlightViewFactory;
import id.dana.cashier.CashierPayLaterContract;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierPayLaterModule_ProvideCashierPayLaterPresenterFactory;
import id.dana.cashier.CashierPayLaterModule_ProvideCashierPayLaterViewFactory;
import id.dana.cashier.CashierRiskChallengeContract;
import id.dana.cashier.CashierUserRelatedContract;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.CashierUserRelatedModule_ProvideCashierUserRelatedPresenterFactory;
import id.dana.cashier.CashierUserRelatedModule_ProvideCashierUserRelatedViewFactory;
import id.dana.cashier.TncCardPaymentEventHandler;
import id.dana.cashier.TopUpAndPayContract;
import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.interactor.AddAssetCardForUser;
import id.dana.cashier.domain.interactor.AddAssetCardForUser_Factory;
import id.dana.cashier.domain.interactor.CashierUpdateOrder;
import id.dana.cashier.domain.interactor.CashierUpdateOrder_Factory;
import id.dana.cashier.domain.interactor.CheckNeedToShowSmartpayDialog;
import id.dana.cashier.domain.interactor.CheckNeedToShowSmartpayDialog_Factory;
import id.dana.cashier.domain.interactor.CreateCashierAgreement;
import id.dana.cashier.domain.interactor.CreateCashierOrder;
import id.dana.cashier.domain.interactor.CreateCashierOrder_Factory;
import id.dana.cashier.domain.interactor.DoTopUpSubmit;
import id.dana.cashier.domain.interactor.DoTopUpSubmit_Factory;
import id.dana.cashier.domain.interactor.DoTopUpVerify;
import id.dana.cashier.domain.interactor.DoTopUpVerify_Factory;
import id.dana.cashier.domain.interactor.GetCashierAddOnInfo;
import id.dana.cashier.domain.interactor.GetCashierAddOnInfo_Factory;
import id.dana.cashier.domain.interactor.GetCashierCheckoutInfo;
import id.dana.cashier.domain.interactor.GetCashierCheckoutInfo_Factory;
import id.dana.cashier.domain.interactor.GetCashierHighlightCache;
import id.dana.cashier.domain.interactor.GetCashierHighlightCache_Factory;
import id.dana.cashier.domain.interactor.GetCashierHighlightConfig;
import id.dana.cashier.domain.interactor.GetCashierHighlightConfig_Factory;
import id.dana.cashier.domain.interactor.GetCashierKybProduct;
import id.dana.cashier.domain.interactor.GetCashierKybProduct_Factory;
import id.dana.cashier.domain.interactor.GetCurrencyFromCdn;
import id.dana.cashier.domain.interactor.GetCurrencyFromCdn_Factory;
import id.dana.cashier.domain.interactor.GetCustomLoading3dsUrls;
import id.dana.cashier.domain.interactor.GetCustomLoading3dsUrls_Factory;
import id.dana.cashier.domain.interactor.GetHighlightNewInstId;
import id.dana.cashier.domain.interactor.GetHighlightNewInstId_Factory;
import id.dana.cashier.domain.interactor.GetLoanRegistrationInfo;
import id.dana.cashier.domain.interactor.GetLoanRegistrationInfo_Factory;
import id.dana.cashier.domain.interactor.GetOneklikRedirectUrl;
import id.dana.cashier.domain.interactor.GetOneklikRedirectUrl_Factory;
import id.dana.cashier.domain.interactor.GetPaylaterCicilOnboardingContent;
import id.dana.cashier.domain.interactor.GetPaylaterCicilOnboardingContent_Factory;
import id.dana.cashier.domain.interactor.GetPaylaterCicilRegistrationCooldownCache;
import id.dana.cashier.domain.interactor.GetPaylaterCicilRegistrationCooldownCache_Factory;
import id.dana.cashier.domain.interactor.GetQueryCardPolicy;
import id.dana.cashier.domain.interactor.GetQueryCardPolicy_Factory;
import id.dana.cashier.domain.interactor.GetQueryInstallment;
import id.dana.cashier.domain.interactor.GetQueryInstallment_Factory;
import id.dana.cashier.domain.interactor.GetQueryPromotion;
import id.dana.cashier.domain.interactor.GetQueryPromotion_Factory;
import id.dana.cashier.domain.interactor.GetTopUpAgent;
import id.dana.cashier.domain.interactor.GetTopUpAgent_Factory;
import id.dana.cashier.domain.interactor.GetTopUpConsult;
import id.dana.cashier.domain.interactor.GetTopUpConsult_Factory;
import id.dana.cashier.domain.interactor.PayCashier;
import id.dana.cashier.domain.interactor.PayCashier_Factory;
import id.dana.cashier.domain.interactor.PayQueryCashier;
import id.dana.cashier.domain.interactor.PayQueryCashier_Factory;
import id.dana.cashier.domain.interactor.SaveHighlightNewInstId;
import id.dana.cashier.domain.interactor.SaveHighlightNewInstId_Factory;
import id.dana.cashier.domain.interactor.SaveHighlightTimeShown;
import id.dana.cashier.domain.interactor.SaveHighlightTimeShown_Factory;
import id.dana.cashier.domain.interactor.SaveHighlightVersion;
import id.dana.cashier.domain.interactor.SaveHighlightVersion_Factory;
import id.dana.cashier.domain.interactor.SaveLastSmartpayActivationShow;
import id.dana.cashier.domain.interactor.SaveLastSmartpayActivationShow_Factory;
import id.dana.cashier.domain.interactor.SavePaylaterCicilRegistrationCacheCooldownCount;
import id.dana.cashier.domain.interactor.SavePaylaterCicilRegistrationCacheCooldownCount_Factory;
import id.dana.cashier.domain.interactor.SavePaylaterCicilRegistrationCacheCooldownDelay;
import id.dana.cashier.domain.interactor.SavePaylaterCicilRegistrationCacheCooldownDelay_Factory;
import id.dana.cashier.domain.interactor.TopUpPayCashier;
import id.dana.cashier.domain.interactor.TopUpPayCashier_Factory;
import id.dana.cashier.fragment.AddNewCardCashierFragment;
import id.dana.cashier.fragment.AddNewCardCashierFragment_MembersInjector;
import id.dana.cashier.fragment.CashierCvvChallengeFragment;
import id.dana.cashier.fragment.CashierCvvChallengeFragment_MembersInjector;
import id.dana.cashier.fragment.CashierDailyLimitVerifyFragment;
import id.dana.cashier.fragment.CashierDailyLimitVerifyFragment_MembersInjector;
import id.dana.cashier.fragment.CashierGeneralProcessingFragment;
import id.dana.cashier.fragment.CashierGeneralProcessingFragment_MembersInjector;
import id.dana.cashier.fragment.CashierOneKlikChallengeFragment;
import id.dana.cashier.fragment.CashierOneKlikChallengeFragment_MembersInjector;
import id.dana.cashier.fragment.CashierOtpChallengeFragment;
import id.dana.cashier.fragment.CashierOtpChallengeFragment_MembersInjector;
import id.dana.cashier.fragment.CashierPhoneChallengeFragment;
import id.dana.cashier.fragment.CashierPhoneChallengeFragment_MembersInjector;
import id.dana.cashier.fragment.CashierPinChallengeFragment;
import id.dana.cashier.fragment.CashierPinChallengeFragment_MembersInjector;
import id.dana.cashier.fragment.CashierPromoSelectionFragment;
import id.dana.cashier.fragment.CashierPromoSelectionFragment_MembersInjector;
import id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment;
import id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment_MembersInjector;
import id.dana.cashier.fragment.InputAmountFragment;
import id.dana.cashier.fragment.PayConfirmationFragment;
import id.dana.cashier.fragment.PayConfirmationFragment_MembersInjector;
import id.dana.cashier.fragment.PaylaterInstallmentFragment;
import id.dana.cashier.fragment.PaylaterInstallmentFragment_MembersInjector;
import id.dana.cashier.mapper.AttributeModelMapper;
import id.dana.cashier.mapper.AttributeModelMapper_Factory;
import id.dana.cashier.mapper.CashierCheckoutModelMapper;
import id.dana.cashier.mapper.CashierCheckoutModelMapper_Factory;
import id.dana.cashier.mapper.CashierPayChannelModelsMapper;
import id.dana.cashier.mapper.CashierPayChannelModelsMapper_Factory;
import id.dana.cashier.mapper.CashierPayMethodModelMapper;
import id.dana.cashier.mapper.CashierPayMethodModelMapper_Factory;
import id.dana.cashier.mapper.CashierPayModelMapper;
import id.dana.cashier.mapper.CashierPayModelMapper_Factory;
import id.dana.cashier.mapper.QueryPromotionModelMapper;
import id.dana.cashier.mapper.QueryPromotionModelMapper_Factory;
import id.dana.cashier.mapper.TopUpConsultModelMapper;
import id.dana.cashier.mapper.TopUpConsultModelMapper_Factory;
import id.dana.cashier.mapper.TopUpPayModelMapper;
import id.dana.cashier.mapper.TopUpPayModelMapper_Factory;
import id.dana.cashier.mapper.VoucherCashierModelsMapper;
import id.dana.cashier.mapper.VoucherCashierModelsMapper_Factory;
import id.dana.cashier.presenter.CashierAddOnPresenter;
import id.dana.cashier.presenter.CashierAddOnPresenter_Factory;
import id.dana.cashier.presenter.CashierCardBindingPresenter;
import id.dana.cashier.presenter.CashierCardBindingPresenter_Factory;
import id.dana.cashier.presenter.CashierHighlightPresenter;
import id.dana.cashier.presenter.CashierPayLaterPresenter;
import id.dana.cashier.presenter.CashierPayLaterPresenter_Factory;
import id.dana.cashier.presenter.CashierPresenter;
import id.dana.cashier.presenter.CashierPresenter_Factory;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.presenter.CashierUserRelatedPresenter;
import id.dana.cashier.presenter.CashierUserRelatedPresenter_Factory;
import id.dana.cashier.presenter.TopUpAndPayPresenter;
import id.dana.cashier.presenter.TopUpAndPayPresenter_Factory;
import id.dana.cashier.tracker.PaylaterMixpanelTracker;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig;
import id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig_Factory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierAnalyticModule_ProvideCashierAnalyticTrackerFactory;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierModule_ProvideCashierPresenterFactory;
import id.dana.di.modules.CashierModule_ProvideCashierViewFactory;
import id.dana.di.modules.CashierRiskChallengeModule;
import id.dana.di.modules.CashierRiskChallengeModule_ProvideCashierRiskChallengeViewFactory;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.di.modules.TopUpAndPayModule_ProvideTopUpAndPayPresenterFactory;
import id.dana.di.modules.TopUpAndPayModule_ProvideTopUpAndPayViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting;
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting_Factory;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting_Factory;
import id.dana.domain.autoroute.repository.AutoRouteRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckAutoRouteSmartPayFeature;
import id.dana.domain.featureconfig.interactor.CheckAutoRouteSmartPayFeature_Factory;
import id.dana.domain.featureconfig.interactor.CheckMixPayFeature;
import id.dana.domain.featureconfig.interactor.CheckMixPayFeature_Factory;
import id.dana.domain.featureconfig.interactor.CheckQrisCardPaymentTncFeature;
import id.dana.domain.featureconfig.interactor.CheckQrisCardPaymentTncFeature_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.investment.InvestmentRepository;
import id.dana.domain.otp.OtpRepository;
import id.dana.domain.otp.interactor.ReceiveSms;
import id.dana.domain.otp.interactor.SendBankOtp;
import id.dana.domain.otp.interactor.SendOtp;
import id.dana.domain.otp.interactor.VerifyOtpOneKlik;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.paylater.interactor.ClearCachePayLaterLoanWhitelist;
import id.dana.domain.paylater.interactor.ClearCachePayLaterLoanWhitelist_Factory;
import id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache;
import id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache_Factory;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import id.dana.domain.qrbarcode.interactor.PreCreateCashierOrder;
import id.dana.domain.qrbarcode.interactor.PreCreateCashierOrder_Factory;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.domain.user.interactor.GetSingleBalance_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes_Factory;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey_Factory;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip_Factory;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.pay.PayActivity;
import id.dana.pay.PayActivity_MembersInjector;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule_ProvideFaceAuthenticationFactory;
import id.dana.sendmoney.mapper.CouponPayMethodInfoListModelMapper;
import id.dana.sendmoney.mapper.CouponPayMethodInfoListModelMapper_Factory;
import id.dana.sendmoney.mapper.CouponPayMethodInfoModelMapper;
import id.dana.sendmoney.mapper.CouponPayMethodInfoModelMapper_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerCashierComponent {
    private DaggerCashierComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public CashierAddOnModule KClassImpl$Data$declaredNonStaticMembers$2;
        public CashierAnalyticModule MyBillsEntityDataFactory;
        public CashierRiskChallengeModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public CashierCardBindingModule PlaceComponentResult;
        public CashierHighlightModule getAuthRequestContext;
        public TopUpAndPayModule getErrorConfigVersion;
        private FaceAuthenticationModule initRecordTimeStamp;
        public CashierUserRelatedModule lookAheadTest;
        public CashierPayLaterModule moveToNextValue;
        public CashierModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final CashierComponent MyBillsEntityDataFactory() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl, CashierModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, CashierRiskChallengeModule.class);
            if (this.MyBillsEntityDataFactory == null) {
                this.MyBillsEntityDataFactory = new CashierAnalyticModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, TopUpAndPayModule.class);
            if (this.initRecordTimeStamp == null) {
                this.initRecordTimeStamp = new FaceAuthenticationModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, CashierCardBindingModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue, CashierPayLaterModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, CashierAddOnModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, CashierUserRelatedModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, CashierHighlightModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            return new CashierComponentImpl(this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.MyBillsEntityDataFactory, this.getErrorConfigVersion, this.initRecordTimeStamp, this.PlaceComponentResult, this.moveToNextValue, this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, (byte) 0);
        }
    }

    /* loaded from: classes4.dex */
    public static final class CashierComponentImpl implements CashierComponent {
        private Provider<FeatureConfigRepository> A;
        private Provider<GetHighlightNewInstId> AppCompatEmojiTextHelper;
        private Provider<DoTopUpSubmit> B;
        private Provider<DeviceInformationProvider> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<AnalyticsTrackerFactory> BuiltInFictitiousFunctionClassFactory;
        private final FaceAuthenticationModule C;
        private Provider<GetCashierAddOnInfo> D;
        private Provider<SavePaylaterCicilRegistrationCacheCooldownDelay> DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
        private Provider<CashierPayMethodModelMapper> DatabaseTableConfigUtil;
        private Provider<GetAutoRouteInitialSetting> E;
        private Provider<GetCustomLoading3dsUrls> F;
        private Provider<PaylaterRepository> FillAnimation;
        private Provider<QueryPromotionModelMapper> FlowViewUtil$textChanges$1;
        private Provider<TopUpAndPayContract.Presenter> FlowViewUtil$textChanges$2;
        private Provider<ClearCachePayLaterLoanWhitelist> FragmentBottomSheetPaymentSettingBinding;
        private Provider<GetCashierKybProduct> G;
        private Provider<CashierPayLaterPresenter> GetContactSyncConfig;
        private Provider<GetCurrencyFromCdn> H;
        private Provider<GetCashierHighlightConfig> I;
        private Provider<GetPaylaterCicilRegistrationCooldownCache> J;
        private Provider<GetPaylaterCicilOnboardingContent> K;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetQueryCardPolicy> L;
        private Provider<GetLoanRegistrationInfo> M;
        private Provider<AddAssetCardForUser> MyBillsEntityDataFactory;
        private Provider<GetQueryInstallment> N;
        private Provider<CashierCardBindingPresenter> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<CashierPayModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<CashierPresenter> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ConnectionStatusReceiver> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<CheckQrisCardPaymentTncFeature> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<CheckNeedToShowSmartpayDialog> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<ConsultAgreementOnlyParamSpaceCodes> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<CheckMixPayFeature> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<CashierUpdateOrder> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<GetQueryPromotion> O;
        private Provider<SavePaylaterCicilRegistrationCacheCooldownCount> OtpRegistrationPresenter$input$2;
        private Provider<GetTopUpConsult> P;
        private Provider<AttributeModelMapper> PlaceComponentResult;
        private Provider<CheckAutoRouteSmartPayFeature> PrepareContext;
        private Provider<GetTopUpAgent> Q;
        private Provider<CashierUserRelatedContract.Presenter> QrExpiredActivity;
        private Provider<IsOfflineF2FPay> R;
        private Provider<VoucherCashierModelsMapper> RequestMoneyQrContract$View;
        private Provider<MixpanelAnalytics> S;
        private Provider<TopUpConsultModelMapper> SizeSelectors$OrSelector;
        private Provider<Context> SubSequence;
        private Provider<GetSingleBalance> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<Gson> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<IsNeedToShowToolTip> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<PostExecutionThread> T;
        private Provider<FaceAuthentication> TypeProjectionImpl;
        private Provider<UpdatePayLaterLoanCache> TypefaceCompatApi26Impl;
        private Provider<PreCreateCashierOrder> U;
        private Provider<CashierAddOnContract.View> V;
        private Provider<DoTopUpVerify> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<GetCashierCheckoutInfo> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<PayQueryCashier> W;
        private Provider<CashierAddOnContract.Presenter> X;
        private Provider<CashierHighlightContract.View> Y;
        private Provider<CashierPayLaterContract.Presenter> Z;

        /* renamed from: a */
        private Provider<CashierContract.View> f8100a;
        private Provider<SaveHighlightTimeShown> access$throwIllegalArgumentType;
        private Provider<CashierUserRelatedContract.View> b;
        private Provider<EventTrackerQueue> c;
        private Provider<RecordAgreementOnlyAgreementKey> connectForeground;
        private Provider<CashierRiskChallengeContract.View> d;
        private Provider<PreferenceFacade> e;
        private Provider<FirebasePerformanceMonitor> f;
        private Provider<CashierPayLaterContract.View> flip;
        private Provider<InvestmentRepository> g;
        private Provider<AutoRouteRepository> getAuthRequestContext;
        private Provider<CouponPayMethodInfoModelMapper> getCallingPid;
        private final CashierComponentImpl getErrorConfigVersion;
        private Provider<GetOneklikRedirectUrl> getNameOrBuilderList;
        private Provider<FirebaseAnalytics> getOnBoardingScenario;
        private Provider<CreateCashierOrder> getSupportButtonTintMode;
        private Provider<GetCashierHighlightCache> getValueOfTouchPositionAbsolute;
        private Provider<TopUpAndPayContract.View> h;
        private Provider<QrBarcodeRepository> i;
        private Provider<CashierPayChannelModelsMapper> initRecordTimeStamp;
        private Provider<PayCashier> isAuth;
        private Provider<CashierCardBindingContract.View> isAuto;
        private Provider<CashierUserRelatedPresenter> isLayoutRequested;
        private Provider<SaveLastSmartpayActivationShow> j;
        private Provider<SaveHighlightVersion> k;
        private Provider<SaveHighlightNewInstId> l;
        private Provider<CashierAddOnPresenter> lookAheadTest;
        private Provider<SSLPinningRepository> m;
        private final CashierAnalyticModule moveToNextValue;
        private Provider<ServicesRepository> n;
        private Provider<CashierRepository> newProxyInstance;

        /* renamed from: o */
        private Provider<SharedPrefCashierConfig> f8101o;
        private Provider<SaveShowToolTip> p;
        private Provider<ThreadExecutor> q;
        private Provider<SwitchAutoRouting> r;
        private Provider<DanaVizTrackerImpl> readMicros;
        private Provider<TopUpPayCashier> s;
        private Provider<CashierCheckoutModelMapper> scheduleImpl;
        private Provider<CashierContract.Presenter> shouldRecycleViewType;
        private Provider<TopUpAndPayPresenter> t;
        private Provider<UserConsentRepository> u;
        private Provider<TopUpPayModelMapper> v;
        private Provider<UserRepository> w;
        private Provider<CouponPayMethodInfoListModelMapper> whenAvailable;
        private Provider<UserEducationRepository> x;

        /* synthetic */ CashierComponentImpl(CashierModule cashierModule, CashierRiskChallengeModule cashierRiskChallengeModule, CashierAnalyticModule cashierAnalyticModule, TopUpAndPayModule topUpAndPayModule, FaceAuthenticationModule faceAuthenticationModule, CashierCardBindingModule cashierCardBindingModule, CashierPayLaterModule cashierPayLaterModule, CashierAddOnModule cashierAddOnModule, CashierUserRelatedModule cashierUserRelatedModule, CashierHighlightModule cashierHighlightModule, ApplicationComponent applicationComponent, byte b) {
            this(cashierModule, cashierRiskChallengeModule, cashierAnalyticModule, topUpAndPayModule, faceAuthenticationModule, cashierCardBindingModule, cashierPayLaterModule, cashierAddOnModule, cashierUserRelatedModule, cashierHighlightModule, applicationComponent);
        }

        private CashierComponentImpl(CashierModule cashierModule, CashierRiskChallengeModule cashierRiskChallengeModule, CashierAnalyticModule cashierAnalyticModule, TopUpAndPayModule topUpAndPayModule, FaceAuthenticationModule faceAuthenticationModule, CashierCardBindingModule cashierCardBindingModule, CashierPayLaterModule cashierPayLaterModule, CashierAddOnModule cashierAddOnModule, CashierUserRelatedModule cashierUserRelatedModule, CashierHighlightModule cashierHighlightModule, ApplicationComponent applicationComponent) {
            FullStoryAnalytics_Factory fullStoryAnalytics_Factory;
            this.getErrorConfigVersion = this;
            this.moveToNextValue = cashierAnalyticModule;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.C = faceAuthenticationModule;
            this.SubSequence = new ContextProvider(applicationComponent);
            this.f8100a = DoubleCheck.getAuthRequestContext(CashierModule_ProvideCashierViewFactory.PlaceComponentResult(cashierModule));
            CouponPayMethodInfoModelMapper_Factory PlaceComponentResult = CouponPayMethodInfoModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.getCallingPid = PlaceComponentResult;
            CouponPayMethodInfoListModelMapper_Factory BuiltInFictitiousFunctionClassFactory = CouponPayMethodInfoListModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult);
            this.whenAvailable = BuiltInFictitiousFunctionClassFactory;
            VoucherCashierModelsMapper_Factory authRequestContext = VoucherCashierModelsMapper_Factory.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
            this.RequestMoneyQrContract$View = authRequestContext;
            CashierPayChannelModelsMapper_Factory PlaceComponentResult2 = CashierPayChannelModelsMapper_Factory.PlaceComponentResult(authRequestContext);
            this.initRecordTimeStamp = PlaceComponentResult2;
            AttributeModelMapper_Factory BuiltInFictitiousFunctionClassFactory2 = AttributeModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2);
            this.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory2;
            CashierCheckoutModelMapper_Factory BuiltInFictitiousFunctionClassFactory3 = CashierCheckoutModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2);
            this.scheduleImpl = BuiltInFictitiousFunctionClassFactory3;
            this.DatabaseTableConfigUtil = CashierPayMethodModelMapper_Factory.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory3);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = CashierPayModelMapper_Factory.getAuthRequestContext(this.PlaceComponentResult);
            this.FlowViewUtil$textChanges$1 = QueryPromotionModelMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.RequestMoneyQrContract$View);
            this.newProxyInstance = new CashierRepositoryProvider(applicationComponent);
            ProvideInvestmentRepositoryProvider provideInvestmentRepositoryProvider = new ProvideInvestmentRepositoryProvider(applicationComponent);
            this.g = provideInvestmentRepositoryProvider;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = GetCashierCheckoutInfo_Factory.create(this.newProxyInstance, provideInvestmentRepositoryProvider);
            this.isAuth = PayCashier_Factory.create(this.newProxyInstance);
            this.W = PayQueryCashier_Factory.create(this.newProxyInstance);
            this.getSupportButtonTintMode = CreateCashierOrder_Factory.create(this.newProxyInstance);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = new DeviceInformationProviderProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.A = featureConfigRepositoryProvider;
            this.PrepareContext = CheckAutoRouteSmartPayFeature_Factory.create(featureConfigRepositoryProvider);
            AutoRouteRepositoryProvider autoRouteRepositoryProvider = new AutoRouteRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = autoRouteRepositoryProvider;
            this.E = GetAutoRouteInitialSetting_Factory.create(autoRouteRepositoryProvider);
            this.TypeProjectionImpl = FaceAuthenticationModule_ProvideFaceAuthenticationFactory.getAuthRequestContext(faceAuthenticationModule);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = CheckMixPayFeature_Factory.create(this.A);
            this.O = GetQueryPromotion_Factory.create(this.newProxyInstance);
            this.q = new ThreadExecutorProvider(applicationComponent);
            this.T = new PostExecutionThreadProvider(applicationComponent);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.x = userEducationRepositoryProvider;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = IsNeedToShowToolTip_Factory.create(this.q, this.T, userEducationRepositoryProvider);
            this.p = SaveShowToolTip_Factory.create(this.q, this.T, this.x);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = CashierUpdateOrder_Factory.create(this.newProxyInstance);
            this.G = GetCashierKybProduct_Factory.create(this.newProxyInstance);
            this.f = new ProvideFirebasePerformanceMonitorProvider(applicationComponent);
            ProvideEventTrackerQueueProvider provideEventTrackerQueueProvider = new ProvideEventTrackerQueueProvider(applicationComponent);
            this.c = provideEventTrackerQueueProvider;
            this.getOnBoardingScenario = FirebaseAnalytics_Factory.PlaceComponentResult(this.SubSequence, this.f, provideEventTrackerQueueProvider);
            MixpanelAnalytics_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MixpanelAnalytics_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.SubSequence, this.c);
            this.S = KClassImpl$Data$declaredNonStaticMembers$2;
            Provider<FirebaseAnalytics> provider = this.getOnBoardingScenario;
            fullStoryAnalytics_Factory = FullStoryAnalytics_Factory.InstanceHolder.MyBillsEntityDataFactory;
            AnalyticsTrackerFactory_Factory PlaceComponentResult3 = AnalyticsTrackerFactory_Factory.PlaceComponentResult(provider, KClassImpl$Data$declaredNonStaticMembers$2, fullStoryAnalytics_Factory);
            this.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult3;
            this.readMicros = DanaVizTrackerImpl_Factory.PlaceComponentResult(PlaceComponentResult3);
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.i = qrBarcodeRepositoryProvider;
            this.U = PreCreateCashierOrder_Factory.create(qrBarcodeRepositoryProvider);
            this.e = new ProvideSharedPrefCashierConfigProvider(applicationComponent);
            GsonProvider gsonProvider = new GsonProvider(applicationComponent);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = gsonProvider;
            SharedPrefCashierConfig_Factory create = SharedPrefCashierConfig_Factory.create(this.e, gsonProvider);
            this.f8101o = create;
            this.F = GetCustomLoading3dsUrls_Factory.create(this.A, create);
            this.r = SwitchAutoRouting_Factory.create(this.getAuthRequestContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = CheckNeedToShowSmartpayDialog_Factory.create(this.A, this.newProxyInstance);
            this.j = SaveLastSmartpayActivationShow_Factory.create(this.newProxyInstance);
            GetCurrencyFromCdn_Factory create2 = GetCurrencyFromCdn_Factory.create(this.newProxyInstance);
            this.H = create2;
            Provider<CashierPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(CashierPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.SubSequence, this.f8100a, this.scheduleImpl, this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.FlowViewUtil$textChanges$1, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.isAuth, this.W, this.getSupportButtonTintMode, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.PrepareContext, this.E, this.TypeProjectionImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.O, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.p, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.G, this.readMicros, this.U, this.F, this.r, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.j, create2));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = authRequestContext2;
            this.shouldRecycleViewType = DoubleCheck.getAuthRequestContext(CashierModule_ProvideCashierPresenterFactory.PlaceComponentResult(cashierModule, authRequestContext2));
            this.flip = DoubleCheck.getAuthRequestContext(CashierPayLaterModule_ProvideCashierPayLaterViewFactory.getAuthRequestContext(cashierPayLaterModule));
            this.u = new UserConsentRepositoryProvider(applicationComponent);
            ProvidePaylaterRepositoryProvider providePaylaterRepositoryProvider = new ProvidePaylaterRepositoryProvider(applicationComponent);
            this.FillAnimation = providePaylaterRepositoryProvider;
            this.N = GetQueryInstallment_Factory.create(this.newProxyInstance, this.u, providePaylaterRepositoryProvider);
            this.K = GetPaylaterCicilOnboardingContent_Factory.create(this.u, this.FillAnimation);
            this.M = GetLoanRegistrationInfo_Factory.create(this.newProxyInstance);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = ConsultAgreementOnlyParamSpaceCodes_Factory.create(this.u);
            ServicesRepositoryProvider servicesRepositoryProvider = new ServicesRepositoryProvider(applicationComponent);
            this.n = servicesRepositoryProvider;
            this.FragmentBottomSheetPaymentSettingBinding = ClearCachePayLaterLoanWhitelist_Factory.create(this.FillAnimation, servicesRepositoryProvider);
            this.J = GetPaylaterCicilRegistrationCooldownCache_Factory.create(this.newProxyInstance);
            this.OtpRegistrationPresenter$input$2 = SavePaylaterCicilRegistrationCacheCooldownCount_Factory.create(this.newProxyInstance);
            this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = SavePaylaterCicilRegistrationCacheCooldownDelay_Factory.create(this.newProxyInstance);
            UpdatePayLaterLoanCache_Factory create3 = UpdatePayLaterLoanCache_Factory.create(this.FillAnimation, this.n);
            this.TypefaceCompatApi26Impl = create3;
            Provider<CashierPayLaterPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(CashierPayLaterPresenter_Factory.MyBillsEntityDataFactory(this.SubSequence, this.flip, this.N, this.K, this.M, this.DatabaseTableConfigUtil, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.FragmentBottomSheetPaymentSettingBinding, this.J, this.OtpRegistrationPresenter$input$2, this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, create3));
            this.GetContactSyncConfig = authRequestContext3;
            this.Z = DoubleCheck.getAuthRequestContext(CashierPayLaterModule_ProvideCashierPayLaterPresenterFactory.PlaceComponentResult(cashierPayLaterModule, authRequestContext3));
            this.D = GetCashierAddOnInfo_Factory.create(this.newProxyInstance);
            Provider<CashierAddOnContract.View> authRequestContext4 = DoubleCheck.getAuthRequestContext(CashierAddOnModule_ProvideCashierAddOnViewFactory.BuiltInFictitiousFunctionClassFactory(cashierAddOnModule));
            this.V = authRequestContext4;
            CashierAddOnPresenter_Factory PlaceComponentResult4 = CashierAddOnPresenter_Factory.PlaceComponentResult(this.D, authRequestContext4, this.SubSequence);
            this.lookAheadTest = PlaceComponentResult4;
            this.X = DoubleCheck.getAuthRequestContext(CashierAddOnModule_ProvideCashierAddOnPresenterFactory.PlaceComponentResult(cashierAddOnModule, PlaceComponentResult4));
            this.b = DoubleCheck.getAuthRequestContext(CashierUserRelatedModule_ProvideCashierUserRelatedViewFactory.BuiltInFictitiousFunctionClassFactory(cashierUserRelatedModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = CheckQrisCardPaymentTncFeature_Factory.create(this.A);
            this.connectForeground = RecordAgreementOnlyAgreementKey_Factory.create(this.u);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.w = userRepositoryProvider;
            GetSingleBalance_Factory create4 = GetSingleBalance_Factory.create(userRepositoryProvider);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = create4;
            CashierUserRelatedPresenter_Factory PlaceComponentResult5 = CashierUserRelatedPresenter_Factory.PlaceComponentResult(this.SubSequence, this.b, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.connectForeground, create4);
            this.isLayoutRequested = PlaceComponentResult5;
            this.QrExpiredActivity = DoubleCheck.getAuthRequestContext(CashierUserRelatedModule_ProvideCashierUserRelatedPresenterFactory.getAuthRequestContext(cashierUserRelatedModule, PlaceComponentResult5));
            this.d = DoubleCheck.getAuthRequestContext(CashierRiskChallengeModule_ProvideCashierRiskChallengeViewFactory.PlaceComponentResult(cashierRiskChallengeModule));
            this.I = GetCashierHighlightConfig_Factory.create(this.newProxyInstance);
            this.getValueOfTouchPositionAbsolute = GetCashierHighlightCache_Factory.create(this.newProxyInstance);
            this.AppCompatEmojiTextHelper = GetHighlightNewInstId_Factory.create(this.newProxyInstance);
            this.k = SaveHighlightVersion_Factory.create(this.newProxyInstance);
            this.l = SaveHighlightNewInstId_Factory.create(this.newProxyInstance);
            this.access$throwIllegalArgumentType = SaveHighlightTimeShown_Factory.create(this.newProxyInstance);
            this.Y = DoubleCheck.getAuthRequestContext(CashierHighlightModule_ProvideCashierHighlightViewFactory.MyBillsEntityDataFactory(cashierHighlightModule));
            this.h = DoubleCheck.getAuthRequestContext(TopUpAndPayModule_ProvideTopUpAndPayViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(topUpAndPayModule));
            this.SizeSelectors$OrSelector = TopUpConsultModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp);
            this.v = TopUpPayModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult);
            this.P = GetTopUpConsult_Factory.create(this.newProxyInstance);
            this.B = DoTopUpSubmit_Factory.create(this.newProxyInstance);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = DoTopUpVerify_Factory.create(this.newProxyInstance);
            this.Q = GetTopUpAgent_Factory.create(this.newProxyInstance);
            TopUpPayCashier_Factory create5 = TopUpPayCashier_Factory.create(this.newProxyInstance);
            this.s = create5;
            TopUpAndPayPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$22 = TopUpAndPayPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.SubSequence, this.h, this.SizeSelectors$OrSelector, this.v, this.P, this.B, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.Q, create5, this.W, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.TypeProjectionImpl, this.readMicros);
            this.t = KClassImpl$Data$declaredNonStaticMembers$22;
            this.FlowViewUtil$textChanges$2 = DoubleCheck.getAuthRequestContext(TopUpAndPayModule_ProvideTopUpAndPayPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(topUpAndPayModule, KClassImpl$Data$declaredNonStaticMembers$22));
            this.isAuto = DoubleCheck.getAuthRequestContext(CashierCardBindingModule_ProvideCashierCardBindingViewFactory.BuiltInFictitiousFunctionClassFactory(cashierCardBindingModule));
            this.L = GetQueryCardPolicy_Factory.create(this.newProxyInstance);
            this.MyBillsEntityDataFactory = AddAssetCardForUser_Factory.create(this.newProxyInstance);
            GetOneklikRedirectUrl_Factory create6 = GetOneklikRedirectUrl_Factory.create(this.newProxyInstance);
            this.getNameOrBuilderList = create6;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = DoubleCheck.getAuthRequestContext(CashierCardBindingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.SubSequence, this.isAuto, this.L, this.MyBillsEntityDataFactory, this.BottomSheetCardBindingView$watcherCardNumberView$1, create6));
            this.m = new SSLPinningRepositoryProvider(applicationComponent);
            IsOfflineF2FPay_Factory create7 = IsOfflineF2FPay_Factory.create(this.q, this.T, this.A);
            this.R = create7;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.q, this.m, create7);
        }

        private CashierRiskChallengePresenter PlaceComponentResult() {
            return new CashierRiskChallengePresenter((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()), this.d.get(), new CreateCashierAgreement((CashierRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest())), new SendOtp((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (OtpRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.W())), new SendBankOtp((OtpRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.W())), new ReceiveSms((OtpRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.W())), new VerifyOtpOneKlik((OtpRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.W())), (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7()));
        }

        private static AttributeModelMapper getAuthRequestContext() {
            return new AttributeModelMapper(new CashierPayChannelModelsMapper(new VoucherCashierModelsMapper(new CouponPayMethodInfoListModelMapper(new CouponPayMethodInfoModelMapper(new CurrencyAmountModelMapper())))));
        }

        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue());
            }
        }

        /* loaded from: classes4.dex */
        public static final class CashierRepositoryProvider implements Provider<CashierRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            CashierRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CashierRepository get() {
                return (CashierRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideInvestmentRepositoryProvider implements Provider<InvestmentRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideInvestmentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ InvestmentRepository get() {
                return (InvestmentRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.TypefaceCompatApi26Impl());
            }
        }

        /* loaded from: classes4.dex */
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* loaded from: classes4.dex */
        public static final class AutoRouteRepositoryProvider implements Provider<AutoRouteRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            AutoRouteRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AutoRouteRepository get() {
                return (AutoRouteRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.scheduleImpl());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent PlaceComponentResult;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.CheckPromoQuestFeature());
            }
        }

        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent PlaceComponentResult;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.ArrayTable$1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideFirebasePerformanceMonitorProvider implements Provider<FirebasePerformanceMonitor> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideFirebasePerformanceMonitorProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FirebasePerformanceMonitor get() {
                return (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.OtpRegistrationPresenter$input$2());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideEventTrackerQueueProvider implements Provider<EventTrackerQueue> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideEventTrackerQueueProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ EventTrackerQueue get() {
                return (EventTrackerQueue) Preconditions.PlaceComponentResult(this.PlaceComponentResult.j());
            }
        }

        /* loaded from: classes4.dex */
        public static final class QrBarcodeRepositoryProvider implements Provider<QrBarcodeRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            QrBarcodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrBarcodeRepository get() {
                return (QrBarcodeRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SendMoneyScenario());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvideSharedPrefCashierConfigProvider implements Provider<PreferenceFacade> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideSharedPrefCashierConfigProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PreferenceFacade get() {
                return (PreferenceFacade) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.JsonParseException());
            }
        }

        /* loaded from: classes4.dex */
        public static final class GsonProvider implements Provider<Gson> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            GsonProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Gson get() {
                return (Gson) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.C());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent getAuthRequestContext;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.WithdrawSavedCardChannelView());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ProvidePaylaterRepositoryProvider implements Provider<PaylaterRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvidePaylaterRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PaylaterRepository get() {
                return (PaylaterRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.setNetAuthId());
            }
        }

        /* loaded from: classes4.dex */
        public static final class ServicesRepositoryProvider implements Provider<ServicesRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ServicesRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ServicesRepository get() {
                return (ServicesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SecuritySettingsActivity$createPinLauncher$2$1());
            }
        }

        /* loaded from: classes4.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent getAuthRequestContext;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.BannerEntityDataFactory_Factory());
            }
        }

        /* loaded from: classes4.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent getAuthRequestContext;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getRawPath());
            }
        }

        @Override // id.dana.di.component.CashierComponent
        public final void BuiltInFictitiousFunctionClassFactory(AddNewCardCashierFragment addNewCardCashierFragment) {
            AddNewCardCashierFragment_MembersInjector.MyBillsEntityDataFactory(addNewCardCashierFragment, this.shouldRecycleViewType.get());
            addNewCardCashierFragment.cashierRiskChallengePresenter = PlaceComponentResult();
            AddNewCardCashierFragment_MembersInjector.MyBillsEntityDataFactory(addNewCardCashierFragment, this.NetworkUserEntityData$$ExternalSyntheticLambda0.get());
            AddNewCardCashierFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(addNewCardCashierFragment, CashierAnalyticModule_ProvideCashierAnalyticTrackerFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue, (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue())));
            AddNewCardCashierFragment_MembersInjector.getAuthRequestContext(addNewCardCashierFragment, this.X.get());
        }

        @Override // id.dana.di.component.CashierComponent
        public final void MyBillsEntityDataFactory(CashierCvvChallengeFragment cashierCvvChallengeFragment) {
            CashierCvvChallengeFragment_MembersInjector.MyBillsEntityDataFactory(cashierCvvChallengeFragment, this.shouldRecycleViewType.get());
        }

        @Override // id.dana.di.component.CashierComponent
        public final void MyBillsEntityDataFactory(CashierDailyLimitVerifyFragment cashierDailyLimitVerifyFragment) {
            CashierDailyLimitVerifyFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(cashierDailyLimitVerifyFragment, PlaceComponentResult());
        }

        @Override // id.dana.di.component.CashierComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(CashierGeneralProcessingFragment cashierGeneralProcessingFragment) {
            CashierGeneralProcessingFragment_MembersInjector.PlaceComponentResult(cashierGeneralProcessingFragment, this.shouldRecycleViewType.get());
            CashierGeneralProcessingFragment_MembersInjector.getAuthRequestContext(cashierGeneralProcessingFragment, CashierAnalyticModule_ProvideCashierAnalyticTrackerFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue, (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue())));
            CashierGeneralProcessingFragment_MembersInjector.MyBillsEntityDataFactory(cashierGeneralProcessingFragment, PlaceComponentResult());
        }

        @Override // id.dana.di.component.CashierComponent
        public final void PlaceComponentResult(CashierOneKlikChallengeFragment cashierOneKlikChallengeFragment) {
            CashierOneKlikChallengeFragment_MembersInjector.PlaceComponentResult(cashierOneKlikChallengeFragment, PlaceComponentResult());
            cashierOneKlikChallengeFragment.cashierPresenter = this.NetworkUserEntityData$$ExternalSyntheticLambda2.get();
            CashierOneKlikChallengeFragment_MembersInjector.getAuthRequestContext(cashierOneKlikChallengeFragment, new TopUpAndPayPresenter((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()), this.h.get(), new TopUpConsultModelMapper(new CashierPayChannelModelsMapper(new VoucherCashierModelsMapper(new CouponPayMethodInfoListModelMapper(new CouponPayMethodInfoModelMapper(new CurrencyAmountModelMapper()))))), new TopUpPayModelMapper(getAuthRequestContext()), new GetTopUpConsult((CashierRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest())), new DoTopUpSubmit((CashierRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest())), new DoTopUpVerify((CashierRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest())), new GetTopUpAgent((CashierRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest())), new TopUpPayCashier((CashierRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest())), new PayQueryCashier((CashierRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest())), new CashierPayModelMapper(getAuthRequestContext()), FaceAuthenticationModule_ProvideFaceAuthenticationFactory.MyBillsEntityDataFactory(this.C), new DanaVizTrackerImpl(new AnalyticsTrackerFactory(new FirebaseAnalytics((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()), (FirebasePerformanceMonitor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.OtpRegistrationPresenter$input$2()), (EventTrackerQueue) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.j())), new MixpanelAnalytics((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()), (EventTrackerQueue) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.j())), new FullStoryAnalytics()))));
        }

        @Override // id.dana.di.component.CashierComponent
        public final void MyBillsEntityDataFactory(CashierOtpChallengeFragment cashierOtpChallengeFragment) {
            CashierOtpChallengeFragment_MembersInjector.PlaceComponentResult(cashierOtpChallengeFragment, PlaceComponentResult());
            CashierOtpChallengeFragment_MembersInjector.getAuthRequestContext(cashierOtpChallengeFragment, this.NetworkUserEntityData$$ExternalSyntheticLambda2.get());
            CashierOtpChallengeFragment_MembersInjector.getAuthRequestContext(cashierOtpChallengeFragment, CashierAnalyticModule_ProvideCashierAnalyticTrackerFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue, (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue())));
            cashierOtpChallengeFragment.topUpAndPayPresenter = this.FlowViewUtil$textChanges$2.get();
        }

        @Override // id.dana.di.component.CashierComponent
        public final void getAuthRequestContext(CashierPhoneChallengeFragment cashierPhoneChallengeFragment) {
            CashierPhoneChallengeFragment_MembersInjector.getAuthRequestContext(cashierPhoneChallengeFragment, PlaceComponentResult());
        }

        @Override // id.dana.di.component.CashierComponent
        public final void PlaceComponentResult(CashierPinChallengeFragment cashierPinChallengeFragment) {
            CashierPinChallengeFragment_MembersInjector.PlaceComponentResult(cashierPinChallengeFragment, CashierAnalyticModule_ProvideCashierAnalyticTrackerFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue, (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue())));
            CashierPinChallengeFragment_MembersInjector.getAuthRequestContext(cashierPinChallengeFragment, this.shouldRecycleViewType.get());
            CashierPinChallengeFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(cashierPinChallengeFragment, this.FlowViewUtil$textChanges$2.get());
        }

        @Override // id.dana.di.component.CashierComponent
        public final void getAuthRequestContext(CashierPromoSelectionFragment cashierPromoSelectionFragment) {
            CashierPromoSelectionFragment_MembersInjector.getAuthRequestContext(cashierPromoSelectionFragment, this.shouldRecycleViewType.get());
        }

        @Override // id.dana.di.component.CashierComponent
        public final void getAuthRequestContext(CashierVerifyElementsChallengeFragment cashierVerifyElementsChallengeFragment) {
            CashierVerifyElementsChallengeFragment_MembersInjector.getAuthRequestContext(cashierVerifyElementsChallengeFragment, PlaceComponentResult());
        }

        @Override // id.dana.di.component.CashierComponent
        public final void BuiltInFictitiousFunctionClassFactory(InputAmountFragment inputAmountFragment) {
            inputAmountFragment.cashierPresenter = this.shouldRecycleViewType.get();
        }

        @Override // id.dana.di.component.CashierComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(PayConfirmationFragment payConfirmationFragment) {
            PayConfirmationFragment_MembersInjector.MyBillsEntityDataFactory(payConfirmationFragment, this.shouldRecycleViewType.get());
            PayConfirmationFragment_MembersInjector.getAuthRequestContext(payConfirmationFragment, this.Z.get());
            PayConfirmationFragment_MembersInjector.PlaceComponentResult(payConfirmationFragment, CashierAnalyticModule_ProvideCashierAnalyticTrackerFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue, (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue())));
            PayConfirmationFragment_MembersInjector.MyBillsEntityDataFactory(payConfirmationFragment, new PaylaterMixpanelTracker((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue())));
            PayConfirmationFragment_MembersInjector.MyBillsEntityDataFactory(payConfirmationFragment, new TncCardPaymentEventHandler(new ConsultAgreementOnlyParamSpaceCodes((UserConsentRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.WithdrawSavedCardChannelView())), new RecordAgreementOnlyAgreementKey((UserConsentRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.WithdrawSavedCardChannelView()))));
            payConfirmationFragment.cashierAddOnPresenter = this.X.get();
            payConfirmationFragment.cashierUserRelatedPresenter = this.QrExpiredActivity.get();
            PayConfirmationFragment_MembersInjector.MyBillsEntityDataFactory(payConfirmationFragment, PlaceComponentResult());
            PayConfirmationFragment_MembersInjector.MyBillsEntityDataFactory(payConfirmationFragment, new CashierHighlightPresenter(DoubleCheck.MyBillsEntityDataFactory(this.I), DoubleCheck.MyBillsEntityDataFactory(this.getValueOfTouchPositionAbsolute), DoubleCheck.MyBillsEntityDataFactory(this.AppCompatEmojiTextHelper), DoubleCheck.MyBillsEntityDataFactory(this.k), DoubleCheck.MyBillsEntityDataFactory(this.l), DoubleCheck.MyBillsEntityDataFactory(this.access$throwIllegalArgumentType), DoubleCheck.MyBillsEntityDataFactory(this.Y)));
        }

        @Override // id.dana.di.component.CashierComponent
        public final void getAuthRequestContext(PaylaterInstallmentFragment paylaterInstallmentFragment) {
            PaylaterInstallmentFragment_MembersInjector.MyBillsEntityDataFactory(paylaterInstallmentFragment, this.shouldRecycleViewType.get());
            paylaterInstallmentFragment.cashierAnalyticTracker = CashierAnalyticModule_ProvideCashierAnalyticTrackerFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue, (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()));
            PaylaterInstallmentFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(paylaterInstallmentFragment, new PaylaterMixpanelTracker((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue())));
            PaylaterInstallmentFragment_MembersInjector.getAuthRequestContext(paylaterInstallmentFragment, PlaceComponentResult());
        }

        @Override // id.dana.di.component.CashierComponent
        public final void MyBillsEntityDataFactory(PayActivity payActivity) {
            ((BaseActivity) payActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(payActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(payActivity, DoubleCheck.MyBillsEntityDataFactory(this.A));
            PayActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(payActivity, DoubleCheck.MyBillsEntityDataFactory(this.shouldRecycleViewType));
        }
    }
}

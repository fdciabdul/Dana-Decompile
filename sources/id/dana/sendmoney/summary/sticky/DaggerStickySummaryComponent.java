package id.dana.sendmoney.summary.sticky;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.contract.sendmoney.ExpiryContract;
import id.dana.contract.sendmoney.ExpiryPresenter;
import id.dana.contract.sendmoney.ExpiryPresenter_Factory;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.ExpiryModule;
import id.dana.di.modules.ExpiryModule_ProvideExpiryPresenterFactory;
import id.dana.di.modules.ExpiryModule_ProvideExpiryViewFactory;
import id.dana.di.modules.SendMoneyConfirmationModule;
import id.dana.di.modules.SendMoneyConfirmationModule_ProvidePresenterConfirmBankFactory;
import id.dana.di.modules.SendMoneyConfirmationModule_ProvidePresenterFactory;
import id.dana.di.modules.SendMoneyConfirmationModule_ProvideViewConfirmBankFactory;
import id.dana.di.modules.SendMoneyConfirmationModule_ProvideViewFactory;
import id.dana.di.modules.SendMoneySummaryModule;
import id.dana.di.modules.SendMoneySummaryModule_ProvidePresenterFactory;
import id.dana.di.modules.SendMoneySummaryModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.card.interactor.SaveLastCardUsed;
import id.dana.domain.card.interactor.SaveLastCardUsed_Factory;
import id.dana.domain.card.repository.CardRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetExpiryChoices;
import id.dana.domain.featureconfig.interactor.GetExpiryChoices_Factory;
import id.dana.domain.featureconfig.interactor.GetExpiryTimeConfig;
import id.dana.domain.featureconfig.interactor.GetExpiryTimeConfig_Factory;
import id.dana.domain.featureconfig.interactor.GetSendMoneyFeedConfig;
import id.dana.domain.featureconfig.interactor.GetSendMoneyFeedConfig_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.h5event.H5EventRepository;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event_Factory;
import id.dana.domain.promotion.interactor.DecrementFreeTransferCount;
import id.dana.domain.promotion.interactor.DecrementFreeTransferCount_Factory;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.recentbank.interactor.SaveRecentBank_Factory;
import id.dana.domain.recentcontact.interactor.SaveRecentContact;
import id.dana.domain.recentcontact.interactor.SaveRecentContact_Factory;
import id.dana.domain.recentrecipient.interactor.GetRecentTransaction;
import id.dana.domain.recentrecipient.interactor.GetRecentTransaction_Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature_Factory;
import id.dana.domain.sendmoney.interactor.CheckX2PAndX2XVoucherFeature;
import id.dana.domain.sendmoney.interactor.CheckX2PAndX2XVoucherFeature_Factory;
import id.dana.domain.sendmoney.interactor.CheckX2XVoucherFeature;
import id.dana.domain.sendmoney.interactor.CheckX2XVoucherFeature_Factory;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoney;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoneyBank;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoneyBank_Factory;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoneyContact;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoneyContact_Factory;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoneyOTC;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoneyOTC_Factory;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoney_Factory;
import id.dana.domain.sendmoney.interactor.GetFeatureSendMoneyCashierNative;
import id.dana.domain.sendmoney.interactor.GetFeatureSendMoneyCashierNative_Factory;
import id.dana.domain.sendmoney.interactor.GetRefundTimeout;
import id.dana.domain.sendmoney.interactor.GetRefundTimeout_Factory;
import id.dana.domain.sendmoney.interactor.GetSmartFrictionConfig;
import id.dana.domain.sendmoney.interactor.GetSmartFrictionConfig_Factory;
import id.dana.domain.sendmoney.interactor.GetStateSendMoneyShareFeed;
import id.dana.domain.sendmoney.interactor.GetStateSendMoneyShareFeed_Factory;
import id.dana.domain.sendmoney.interactor.InitTransferOTC;
import id.dana.domain.sendmoney.interactor.InitTransferOTC_Factory;
import id.dana.domain.sendmoney.interactor.SaveStateSendMoneyShareFeed;
import id.dana.domain.sendmoney.interactor.SaveStateSendMoneyShareFeed_Factory;
import id.dana.domain.sendmoney.interactor.SendMoneyNameCheck;
import id.dana.domain.sendmoney.interactor.SendMoneyNameCheck_Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.domain.user.interactor.GetSingleBalance_Factory;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.interactor.GetUserInfoWithKyc_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.activation.interactor.GetFeedStatus;
import id.dana.feeds.domain.activation.interactor.GetFeedStatus_Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.feeds.domain.share.interactor.GetFeedsSharingLastCheckedState;
import id.dana.feeds.domain.share.interactor.GetFeedsSharingLastCheckedState_Factory;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent_Factory;
import id.dana.feeds.domain.share.interactor.SaveFeedsSharingLastCheckedState;
import id.dana.feeds.domain.share.interactor.SaveFeedsSharingLastCheckedState_Factory;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent_Factory;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankPresenter;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankPresenter_Factory;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationContract;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationData;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationData_Factory;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter_Factory;
import id.dana.sendmoney.mapper.AttributesModelMapper;
import id.dana.sendmoney.mapper.AttributesModelMapper_Factory;
import id.dana.sendmoney.mapper.ConfirmToBankMapper_Factory;
import id.dana.sendmoney.mapper.ConfirmToContactMapper_Factory;
import id.dana.sendmoney.mapper.ConfirmationMapper;
import id.dana.sendmoney.mapper.ConfirmationMapper_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.sendmoney.mapper.ExpiryInfoMapper_Factory;
import id.dana.sendmoney.mapper.PayMethodRiskMapper_Factory;
import id.dana.sendmoney.mapper.RecentRecipientModelMapper_Factory;
import id.dana.sendmoney.mapper.SendMoneyBankMapper;
import id.dana.sendmoney.mapper.SendMoneyBankMapper_Factory;
import id.dana.sendmoney.mapper.SendMoneyConfirmModelMapper;
import id.dana.sendmoney.mapper.SendMoneyConfirmModelMapper_Factory;
import id.dana.sendmoney.namecheck.SendMoneySummaryContract;
import id.dana.sendmoney.namecheck.SendMoneySummaryPresenter;
import id.dana.sendmoney.namecheck.SendMoneySummaryPresenter_Factory;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.sendmoney.summary.SummaryActivity_MembersInjector;
import id.dana.sendmoney.summary.factory.SendMoneySummaryFactory;
import id.dana.sendmoney.summary.state.BankSendMoneySummary;
import id.dana.sendmoney.summary.state.ContactSendMoneySummary;
import id.dana.sendmoney.summary.state.LinkSendMoneySummary;
import id.dana.sendmoney.summary.state.OtcSendMoneySummary;
import id.dana.sendmoney.summary.state.confirmation.BankConfirmationSummary;
import id.dana.sendmoney.summary.state.confirmation.ContactConfirmationSummary;
import id.dana.sendmoney.summary.state.confirmation.LinkConfirmationSummary;
import id.dana.sendmoney.summary.state.confirmation.OtcConfirmationSummary;
import id.dana.sendmoney.summary.state.lasttransfer.BankLastTransferSummary;
import id.dana.sendmoney.summary.state.lasttransfer.ContactLastTransferSummary;
import id.dana.sendmoney.summary.state.validation.BankValidationSummary;
import id.dana.sendmoney.summary.state.validation.ContactValidationSummary;
import id.dana.sendmoney.summary.state.validation.LinkValidationSummary;
import id.dana.sendmoney.summary.state.validation.OtcValidationSummary;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule_ProvideTrackerFactory;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker_Factory;
import id.dana.social.contract.share.ShareToFeedsContract;
import id.dana.social.contract.share.ShareToFeedsModule;
import id.dana.social.contract.share.ShareToFeedsModule_ProvideShareToFeedsPresenterFactory;
import id.dana.social.contract.share.ShareToFeedsModule_ProvideShareToFeedsViewFactory;
import id.dana.social.contract.share.ShareToFeedsPresenter;
import id.dana.social.contract.share.ShareToFeedsPresenter_Factory;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.DateTimeUtil_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerStickySummaryComponent {
    private DaggerStickySummaryComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public SendMoneySummaryModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public ExpiryModule MyBillsEntityDataFactory;
        public ShareToFeedsModule NetworkUserEntityData$$ExternalSyntheticLambda0;
        public SendMoneyConfirmationModule PlaceComponentResult;
        public SendMoneyTrackerModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class StickySummaryComponentImpl implements StickySummaryComponent {
        private Provider<GetUserInfoWithKyc> A;
        private Provider<SendMoneySummaryContract.Presenter> AppCompatEmojiTextHelper;
        private Provider<H5EventRepository> B;
        private Provider<IsOfflineF2FPay> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<CheckX2PAndX2XVoucherFeature> BuiltInFictitiousFunctionClassFactory;
        private Provider<PostExecutionThread> C;
        private Provider<FeedInitRepository> D;
        private Provider<ConnectionStatusReceiver> DatabaseTableConfigUtil;
        private Provider<PromotionRepository> E;
        private Provider<ShareToFeedsContract.View> F;
        private Provider<GetFeatureSendMoneyCashierNative> FragmentBottomSheetPaymentSettingBinding;
        private Provider<SendMoneyConfirmationContract.Presenter> G;
        private Provider<ConfirmationMapper> GetContactSyncConfig;
        private Provider<ShareToFeedsContract.Presenter> H;
        private Provider<SendMoneyConfirmationBankContract.Presenter> I;
        private Provider<RecentRecipientRepository> J;
        private Provider<SendMoneyConfirmationBankContract.View> K;
        private Provider<CardRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<SendMoneyAnalyticTracker> L;
        private Provider<SendMoneyConfirmationContract.View> M;
        private Provider<CheckTransferX2PFeature> MyBillsEntityDataFactory;
        private Provider<SaveLastCardUsed> N;
        private Provider<ConfirmSendMoneyContact> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<DateTimeUtil> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<DecrementFreeTransferCount> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<GetFeedStatus> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<GetFeedsSharingLastCheckedState> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<GetRecentTransaction> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<GetRefundTimeout> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<ExpiryPresenter> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<GetCheckoutH5Event> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<SaveRecentBank> O;
        private Provider<SSLPinningRepository> P;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<FeatureConfigRepository> PrepareContext;
        private Provider<SaveRecentContact> Q;
        private Provider<SendMoneyBankMapper> R;
        private Provider<SendMoneyConfirmModelMapper> S;
        private Provider<GetSendMoneyFeedConfig> SubSequence;
        private Provider<SaveFeedsSharingLastCheckedState> SummaryVoucherView$$ExternalSyntheticLambda0;
        private Provider<SaveShareFeedConsent> SummaryVoucherView$$ExternalSyntheticLambda1;
        private Provider<SaveStateSendMoneyShareFeed> SummaryVoucherView$$ExternalSyntheticLambda2;
        private Provider<SendMoneyMixpanelTracker> T;
        private Provider<SendMoneyNameCheck> U;
        private Provider<SendMoneyRepository> V;
        private Provider<InitTransferOTC> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<ExpiryContract.Presenter> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<SendMoneyConfirmationData> W;
        private Provider<SendMoneyConfirmationPresenter> X;
        private Provider<SendMoneySummaryPresenter> Y;
        private final StickySummaryComponentImpl Z;
        private Provider<ShareToFeedsPresenter> flip;
        private Provider<AttributesModelMapper> getAuthRequestContext;
        private Provider<GetSingleBalance> getCallingPid;
        private Provider<ConfirmSendMoneyBank> getErrorConfigVersion;
        private Provider<SendMoneySummaryContract.View> getNameOrBuilderList;
        private Provider<FeedsShareRepository> getOnBoardingScenario;
        private Provider<GetSmartFrictionConfig> getSupportButtonTintMode;
        private Provider<ExpiryContract.View> getValueOfTouchPositionAbsolute;
        private Provider<Context> initRecordTimeStamp;
        private Provider<SendMoneyConfirmationBankPresenter> isAuth;
        private Provider<ThreadExecutor> isAuto;
        private Provider<GetExpiryChoices> isLayoutRequested;
        private Provider<CheckX2XVoucherFeature> lookAheadTest;
        private Provider<ConfirmSendMoney> moveToNextValue;
        private Provider<GetExpiryTimeConfig> newProxyInstance;
        private Provider<GetShareFeedConsent> readMicros;
        private Provider<ConfirmSendMoneyOTC> scheduleImpl;
        private Provider<UserRepository> shouldRecycleViewType;
        private Provider<GetStateSendMoneyShareFeed> whenAvailable;

        public /* synthetic */ StickySummaryComponentImpl(SendMoneySummaryModule sendMoneySummaryModule, SendMoneyConfirmationModule sendMoneyConfirmationModule, ExpiryModule expiryModule, ShareToFeedsModule shareToFeedsModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(sendMoneySummaryModule, sendMoneyConfirmationModule, expiryModule, shareToFeedsModule, sendMoneyTrackerModule, applicationComponent);
        }

        private StickySummaryComponentImpl(SendMoneySummaryModule sendMoneySummaryModule, SendMoneyConfirmationModule sendMoneyConfirmationModule, ExpiryModule expiryModule, ShareToFeedsModule shareToFeedsModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent) {
            ConfirmToBankMapper_Factory confirmToBankMapper_Factory;
            this.Z = this;
            this.PlaceComponentResult = applicationComponent;
            this.isAuto = new ThreadExecutorProvider(applicationComponent);
            this.P = new SSLPinningRepositoryProvider(applicationComponent);
            this.C = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PrepareContext = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.isAuto, this.C, featureConfigRepositoryProvider);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = create;
            this.DatabaseTableConfigUtil = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.isAuto, this.P, create);
            this.initRecordTimeStamp = new ContextProvider(applicationComponent);
            SendMoneyRepositoryProvider sendMoneyRepositoryProvider = new SendMoneyRepositoryProvider(applicationComponent);
            this.V = sendMoneyRepositoryProvider;
            this.U = SendMoneyNameCheck_Factory.create(this.isAuto, this.C, sendMoneyRepositoryProvider);
            this.R = SendMoneyBankMapper_Factory.PlaceComponentResult(PayMethodRiskMapper_Factory.getAuthRequestContext(), CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.GetContactSyncConfig = ConfirmationMapper_Factory.getAuthRequestContext(this.initRecordTimeStamp);
            this.getNameOrBuilderList = DoubleCheck.getAuthRequestContext(SendMoneySummaryModule_ProvideViewFactory.MyBillsEntityDataFactory(sendMoneySummaryModule));
            this.lookAheadTest = CheckX2XVoucherFeature_Factory.create(this.isAuto, this.C, this.PrepareContext);
            this.BuiltInFictitiousFunctionClassFactory = CheckX2PAndX2XVoucherFeature_Factory.create(this.isAuto, this.C, this.PrepareContext);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = InitTransferOTC_Factory.create(this.isAuto, this.C, this.V);
            this.SubSequence = GetSendMoneyFeedConfig_Factory.create(this.PrepareContext);
            this.whenAvailable = GetStateSendMoneyShareFeed_Factory.create(this.V);
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = SaveStateSendMoneyShareFeed_Factory.create(this.V);
            this.FragmentBottomSheetPaymentSettingBinding = GetFeatureSendMoneyCashierNative_Factory.create(this.PrepareContext);
            this.getSupportButtonTintMode = GetSmartFrictionConfig_Factory.create(this.PrepareContext);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.shouldRecycleViewType = userRepositoryProvider;
            this.A = GetUserInfoWithKyc_Factory.create(this.isAuto, this.C, userRepositoryProvider);
            GetExpiryTimeConfig_Factory create2 = GetExpiryTimeConfig_Factory.create(this.PrepareContext);
            this.newProxyInstance = create2;
            SendMoneySummaryPresenter_Factory BuiltInFictitiousFunctionClassFactory = SendMoneySummaryPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp, this.U, this.R, this.GetContactSyncConfig, this.getNameOrBuilderList, this.lookAheadTest, this.BuiltInFictitiousFunctionClassFactory, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.SubSequence, this.whenAvailable, this.SummaryVoucherView$$ExternalSyntheticLambda2, this.FragmentBottomSheetPaymentSettingBinding, this.getSupportButtonTintMode, this.A, create2);
            this.Y = BuiltInFictitiousFunctionClassFactory;
            this.AppCompatEmojiTextHelper = DoubleCheck.getAuthRequestContext(SendMoneySummaryModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(sendMoneySummaryModule, BuiltInFictitiousFunctionClassFactory));
            this.moveToNextValue = ConfirmSendMoney_Factory.create(this.isAuto, this.C, this.V);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = GetRefundTimeout_Factory.create(this.isAuto, this.C, this.PrepareContext);
            this.M = DoubleCheck.getAuthRequestContext(SendMoneyConfirmationModule_ProvideViewFactory.MyBillsEntityDataFactory(sendMoneyConfirmationModule));
            H5eventRepositoryProvider h5eventRepositoryProvider = new H5eventRepositoryProvider(applicationComponent);
            this.B = h5eventRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = GetCheckoutH5Event_Factory.create(this.isAuto, this.C, h5eventRepositoryProvider);
            CardRepositoryProvider cardRepositoryProvider = new CardRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = cardRepositoryProvider;
            this.N = SaveLastCardUsed_Factory.create(cardRepositoryProvider);
            this.W = DoubleCheck.getAuthRequestContext(SendMoneyConfirmationData_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayMethodRiskMapper_Factory.getAuthRequestContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.N));
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DateTimeUtil_Factory.PlaceComponentResult(this.initRecordTimeStamp);
            RecentRecipientRepositoryProvider recentRecipientRepositoryProvider = new RecentRecipientRepositoryProvider(applicationComponent);
            this.J = recentRecipientRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = GetRecentTransaction_Factory.create(recentRecipientRepositoryProvider);
            this.getCallingPid = GetSingleBalance_Factory.create(this.shouldRecycleViewType);
            this.getAuthRequestContext = AttributesModelMapper_Factory.MyBillsEntityDataFactory(PayMethodRiskMapper_Factory.getAuthRequestContext());
            this.S = SendMoneyConfirmModelMapper_Factory.KClassImpl$Data$declaredNonStaticMembers$2(PayMethodRiskMapper_Factory.getAuthRequestContext(), this.getAuthRequestContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ConfirmSendMoneyContact_Factory.create(this.isAuto, this.C, this.V);
            this.Q = SaveRecentContact_Factory.create(this.isAuto, this.C, this.J);
            this.MyBillsEntityDataFactory = CheckTransferX2PFeature_Factory.create(this.isAuto, this.C, this.PrepareContext);
            this.scheduleImpl = ConfirmSendMoneyOTC_Factory.create(this.isAuto, this.C, this.V);
            Provider<SendMoneyConfirmationPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(SendMoneyConfirmationPresenter_Factory.getAuthRequestContext(this.moveToNextValue, this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.M, this.W, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.NetworkUserEntityData$$ExternalSyntheticLambda5, RecentRecipientModelMapper_Factory.PlaceComponentResult(), this.getCallingPid, this.S, this.NetworkUserEntityData$$ExternalSyntheticLambda0, ConfirmToContactMapper_Factory.MyBillsEntityDataFactory(), this.Q, this.MyBillsEntityDataFactory, this.scheduleImpl));
            this.X = authRequestContext;
            this.G = DoubleCheck.getAuthRequestContext(SendMoneyConfirmationModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(sendMoneyConfirmationModule, authRequestContext));
            this.K = DoubleCheck.getAuthRequestContext(SendMoneyConfirmationModule_ProvideViewConfirmBankFactory.PlaceComponentResult(sendMoneyConfirmationModule));
            this.getErrorConfigVersion = ConfirmSendMoneyBank_Factory.create(this.isAuto, this.C, this.V);
            this.O = SaveRecentBank_Factory.create(this.isAuto, this.C, this.J);
            PromotionRepositoryProvider promotionRepositoryProvider = new PromotionRepositoryProvider(applicationComponent);
            this.E = promotionRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = DecrementFreeTransferCount_Factory.create(promotionRepositoryProvider);
            Provider<SendMoneyConfirmationBankContract.View> provider = this.K;
            Provider<ConfirmSendMoneyBank> provider2 = this.getErrorConfigVersion;
            Provider<SaveRecentBank> provider3 = this.O;
            confirmToBankMapper_Factory = ConfirmToBankMapper_Factory.InstanceHolder.MyBillsEntityDataFactory;
            SendMoneyConfirmationBankPresenter_Factory MyBillsEntityDataFactory = SendMoneyConfirmationBankPresenter_Factory.MyBillsEntityDataFactory(provider, provider2, provider3, confirmToBankMapper_Factory, this.S, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.initRecordTimeStamp);
            this.isAuth = MyBillsEntityDataFactory;
            this.I = DoubleCheck.getAuthRequestContext(SendMoneyConfirmationModule_ProvidePresenterConfirmBankFactory.MyBillsEntityDataFactory(sendMoneyConfirmationModule, MyBillsEntityDataFactory));
            this.getValueOfTouchPositionAbsolute = DoubleCheck.getAuthRequestContext(ExpiryModule_ProvideExpiryViewFactory.getAuthRequestContext(expiryModule));
            GetExpiryChoices_Factory create3 = GetExpiryChoices_Factory.create(this.isAuto, this.C, this.PrepareContext);
            this.isLayoutRequested = create3;
            ExpiryPresenter_Factory BuiltInFictitiousFunctionClassFactory2 = ExpiryPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.getValueOfTouchPositionAbsolute, create3, ExpiryInfoMapper_Factory.PlaceComponentResult());
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = BuiltInFictitiousFunctionClassFactory2;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = DoubleCheck.getAuthRequestContext(ExpiryModule_ProvideExpiryPresenterFactory.MyBillsEntityDataFactory(expiryModule, BuiltInFictitiousFunctionClassFactory2));
            ProvideFeedsShareRepositoryProvider provideFeedsShareRepositoryProvider = new ProvideFeedsShareRepositoryProvider(applicationComponent);
            this.getOnBoardingScenario = provideFeedsShareRepositoryProvider;
            this.readMicros = GetShareFeedConsent_Factory.getAuthRequestContext(provideFeedsShareRepositoryProvider);
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = SaveShareFeedConsent_Factory.MyBillsEntityDataFactory(this.getOnBoardingScenario);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = GetFeedsSharingLastCheckedState_Factory.MyBillsEntityDataFactory(this.getOnBoardingScenario);
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = SaveFeedsSharingLastCheckedState_Factory.MyBillsEntityDataFactory(this.getOnBoardingScenario);
            this.F = DoubleCheck.getAuthRequestContext(ShareToFeedsModule_ProvideShareToFeedsViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(shareToFeedsModule));
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.D = provideFeedInitRepositoryProvider;
            GetFeedStatus_Factory KClassImpl$Data$declaredNonStaticMembers$2 = GetFeedStatus_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideFeedInitRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = KClassImpl$Data$declaredNonStaticMembers$2;
            ShareToFeedsPresenter_Factory PlaceComponentResult = ShareToFeedsPresenter_Factory.PlaceComponentResult(this.readMicros, this.SummaryVoucherView$$ExternalSyntheticLambda1, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.SummaryVoucherView$$ExternalSyntheticLambda0, this.F, KClassImpl$Data$declaredNonStaticMembers$2);
            this.flip = PlaceComponentResult;
            this.H = DoubleCheck.getAuthRequestContext(ShareToFeedsModule_ProvideShareToFeedsPresenterFactory.getAuthRequestContext(shareToFeedsModule, PlaceComponentResult));
            SendMoneyMixpanelTracker_Factory authRequestContext2 = SendMoneyMixpanelTracker_Factory.getAuthRequestContext(this.initRecordTimeStamp);
            this.T = authRequestContext2;
            this.L = DoubleCheck.getAuthRequestContext(SendMoneyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(sendMoneyTrackerModule, authRequestContext2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent PlaceComponentResult;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class SendMoneyRepositoryProvider implements Provider<SendMoneyRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SendMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SendMoneyRepository get() {
                return (SendMoneyRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BaseSocialFeedContract$Presenter());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class H5eventRepositoryProvider implements Provider<H5EventRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            H5eventRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ H5EventRepository get() {
                return (H5EventRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.VerifyPinStateManager$executeRiskChallenge$2$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class CardRepositoryProvider implements Provider<CardRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            CardRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CardRepository get() {
                return (CardRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class RecentRecipientRepositoryProvider implements Provider<RecentRecipientRepository> {
            private final ApplicationComponent getAuthRequestContext;

            RecentRecipientRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentRecipientRepository get() {
                return (RecentRecipientRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.access$setShowcaseShowing$p());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class PromotionRepositoryProvider implements Provider<PromotionRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            PromotionRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromotionRepository get() {
                return (PromotionRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.a());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ProvideFeedsShareRepositoryProvider implements Provider<FeedsShareRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideFeedsShareRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsShareRepository get() {
                return (FeedsShareRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ProvideFeedInitRepositoryProvider implements Provider<FeedInitRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideFeedInitRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedInitRepository get() {
                return (FeedInitRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.l());
            }
        }

        @Override // id.dana.sendmoney.summary.sticky.StickySummaryComponent
        public final void BuiltInFictitiousFunctionClassFactory(SummaryActivity summaryActivity) {
            ((BaseActivity) summaryActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(summaryActivity, DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(summaryActivity, DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext));
            summaryActivity.sendMoneySummaryPresenter = this.AppCompatEmojiTextHelper.get();
            SummaryActivity_MembersInjector.getAuthRequestContext(summaryActivity, this.G.get());
            SummaryActivity_MembersInjector.PlaceComponentResult(summaryActivity, this.I.get());
            SummaryActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(summaryActivity, this.VerifyPinStateManager$executeRiskChallenge$2$2.get());
            SummaryActivity_MembersInjector.PlaceComponentResult(summaryActivity, this.H.get());
            SummaryActivity_MembersInjector.MyBillsEntityDataFactory(summaryActivity, this.L.get());
            SummaryActivity_MembersInjector.getAuthRequestContext(summaryActivity, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.PlaceComponentResult.PrepareContext()));
            SummaryActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(summaryActivity, new SendMoneySummaryFactory(new BankSendMoneySummary(new BankValidationSummary(this.AppCompatEmojiTextHelper.get()), new BankConfirmationSummary(this.I.get()), new BankLastTransferSummary(this.G.get())), new ContactSendMoneySummary(new ContactValidationSummary(this.AppCompatEmojiTextHelper.get()), new ContactConfirmationSummary(this.G.get()), new ContactLastTransferSummary(this.G.get())), new OtcSendMoneySummary(new OtcValidationSummary(this.AppCompatEmojiTextHelper.get()), new OtcConfirmationSummary(this.G.get())), new LinkSendMoneySummary(new LinkValidationSummary(this.VerifyPinStateManager$executeRiskChallenge$2$2.get()), new LinkConfirmationSummary(this.I.get()))));
        }
    }
}

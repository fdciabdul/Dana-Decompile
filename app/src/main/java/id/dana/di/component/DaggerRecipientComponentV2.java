package id.dana.di.component;

import android.content.ContentResolver;
import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.contact.DanaContactContract;
import id.dana.contract.contact.DanaContactPresenter;
import id.dana.contract.sendmoney.bank.SavedBankCardContract;
import id.dana.contract.sendmoney.bank.SavedBankCardPresenter;
import id.dana.contract.sendmoney.bank.SavedBankCardPresenter_Factory;
import id.dana.contract.sendmoney.v2.SortingSendMoneyContract;
import id.dana.contract.sendmoney.v2.SortingSendMoneyPresenter;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory;
import id.dana.di.modules.BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory;
import id.dana.di.modules.DanaContactModule;
import id.dana.di.modules.DanaContactModule_ProvidePresenterFactory;
import id.dana.di.modules.DanaContactModule_ProvideViewFactory;
import id.dana.di.modules.SavedBankModule;
import id.dana.di.modules.SavedBankModule_ProvidePresenterFactory;
import id.dana.di.modules.SavedBankModule_ProvideViewFactory;
import id.dana.di.modules.SortingSendMoneyModule;
import id.dana.di.modules.SortingSendMoneyModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.contactinjection.ContactInjectionRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckContactSyncFeature;
import id.dana.domain.featureconfig.interactor.CheckContactSyncFeature_Factory;
import id.dana.domain.featureconfig.interactor.CheckSendMoneyPeerToCash;
import id.dana.domain.featureconfig.interactor.CheckSendMoneyPeerToCash_Factory;
import id.dana.domain.featureconfig.interactor.CheckTransferToLinkFeature;
import id.dana.domain.featureconfig.interactor.CheckTransferToLinkFeature_Factory;
import id.dana.domain.featureconfig.interactor.GetContactInjectionConfig;
import id.dana.domain.featureconfig.interactor.GetContactInjectionConfig_Factory;
import id.dana.domain.recentbank.interactor.GetMaxSavedBank;
import id.dana.domain.recentbank.interactor.GetMaxSavedBank_Factory;
import id.dana.domain.recentbank.interactor.GetRecentBank;
import id.dana.domain.recentbank.interactor.GetRecentBank_Factory;
import id.dana.domain.recentbank.interactor.SearchRecentBank;
import id.dana.domain.recentbank.interactor.SearchRecentBank_Factory;
import id.dana.domain.recentcontact.interactor.GetDanaContact;
import id.dana.domain.recentcontact.interactor.GetDanaContact_Factory;
import id.dana.domain.recentcontact.repository.RecentContactRepository;
import id.dana.domain.recentrecipient.interactor.GetIsRecentRecipientMigratedToRoom;
import id.dana.domain.recentrecipient.interactor.GetIsRecentRecipientMigratedToRoom_Factory;
import id.dana.domain.recentrecipient.interactor.GetMaxRecentRecipient;
import id.dana.domain.recentrecipient.interactor.GetMaxRecentRecipient_Factory;
import id.dana.domain.recentrecipient.interactor.GetRecentContact;
import id.dana.domain.recentrecipient.interactor.GetRecentContact_Factory;
import id.dana.domain.recentrecipient.interactor.GetRecentRecipient;
import id.dana.domain.recentrecipient.interactor.GetRecentRecipient_Factory;
import id.dana.domain.recentrecipient.interactor.GetRecentTransaction;
import id.dana.domain.recentrecipient.interactor.GetRecentTransaction_Factory;
import id.dana.domain.recentrecipient.interactor.MaskingRecentRecipient;
import id.dana.domain.recentrecipient.interactor.MaskingRecentRecipient_Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.domain.sendmoney.interactor.GetRecentGroup;
import id.dana.domain.sendmoney.interactor.GetRecentGroup_Factory;
import id.dana.domain.sendmoney.interactor.GetSortingSendMoney;
import id.dana.domain.sendmoney.interactor.SaveSortingSendMoney;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.domain.synccontact.SyncContactRepository;
import id.dana.domain.synccontact.interactor.CheckSyncProcessCompleteState;
import id.dana.domain.synccontact.interactor.CheckSyncProcessCompleteState_Factory;
import id.dana.domain.synccontact.interactor.GetLastSyncedContact;
import id.dana.domain.synccontact.interactor.GetLastSyncedContact_Factory;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent_Factory;
import id.dana.richview.contactselector.UserContactMapper_Factory;
import id.dana.sendmoney.contact.provider.ContactProvider;
import id.dana.sendmoney.contact.provider.ContactProvider_Factory;
import id.dana.sendmoney.mapper.RecentBankModelMapper_Factory;
import id.dana.sendmoney.mapper.RecentRecipientModelMapper_Factory;
import id.dana.sendmoney.recipient.recent.RecentRecipientContract;
import id.dana.sendmoney.recipient.recent.RecentRecipientModule;
import id.dana.sendmoney.recipient.recent.RecentRecipientModule_ProvidePresenterFactory;
import id.dana.sendmoney.recipient.recent.RecentRecipientModule_ProvideViewFactory;
import id.dana.sendmoney.recipient.recent.RecentRecipientPresenter;
import id.dana.sendmoney.recipient.recent.RecentRecipientPresenter_Factory;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule_ProvideTrackerFactory;
import id.dana.sendmoney_v2.recipient.view.RecipientView;
import id.dana.sendmoney_v2.recipient.view.RecipientView_MembersInjector;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker_Factory;
import id.dana.sync_engine.domain.interactor.GetContactsUseCase;
import id.dana.synccontact.SyncContactUtil_Factory;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;
import id.dana.usereducation.BottomSheetOnBoardingPresenter_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerRecipientComponentV2 {
    private DaggerRecipientComponentV2() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public BottomSheetOnBoardingModule BuiltInFictitiousFunctionClassFactory;
        public RecentRecipientModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public DanaContactModule PlaceComponentResult;
        public SavedBankModule getAuthRequestContext;
        public SendMoneyTrackerModule lookAheadTest;
        public SortingSendMoneyModule scheduleImpl;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class RecipientComponentV2Impl implements RecipientComponentV2 {
        private Provider<SavedBankCardContract.View> A;
        private Provider<SavedBankCardPresenter> AppCompatEmojiTextHelper;
        private Provider<DanaContactContract.View> B;
        private Provider<SavedBankCardContract.Presenter> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<BottomSheetOnBoardingPresenter> BuiltInFictitiousFunctionClassFactory;
        private Provider<RecentRecipientContract.Presenter> C;
        private Provider<RecentContactRepository> D;
        private Provider<GetDanaContact> DatabaseTableConfigUtil;
        private Provider<SortingSendMoneyContract.View> E;
        private Provider<SaveShareFeedConsent> F;
        private Provider<GetRecentTransaction> FragmentBottomSheetPaymentSettingBinding;
        private Provider<SearchRecentBank> G;
        private Provider<GetIsRecentRecipientMigratedToRoom> GetContactSyncConfig;
        private final RecipientComponentV2Impl H;
        private Provider<SaveDisplayBottomSheetOnBoarding> I;
        private Provider<ThreadExecutor> J;
        private Provider<SendMoneyMixpanelTracker> K;
        private Provider<CheckContactSyncFeature> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<SyncContactRepository> L;
        private Provider<CheckSyncProcessCompleteState> MyBillsEntityDataFactory;
        private Provider<CheckTransferToLinkFeature> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetContactInjectionConfig> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<MaskingRecentRecipient> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<GetRecentRecipient> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<GetRecentGroup> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<GetRecentBank> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<GetLastSyncedContact> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<GetRecentContact> PrepareContext;
        private Provider<BottomSheetOnBoardingContract.View> SubSequence;
        private Provider<SendMoneyAnalyticTracker> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<RecentRecipientPresenter> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<CheckSendMoneyPeerToCash> getAuthRequestContext;
        private Provider<GetContactsUseCase> getCallingPid;
        private Provider<Context> getErrorConfigVersion;
        private Provider<UserEducationRepository> getNameOrBuilderList;
        private Provider<RecentRecipientRepository> getOnBoardingScenario;
        private Provider<FeedsShareRepository> getSupportButtonTintMode;
        private Provider<RecentRecipientContract.View> getValueOfTouchPositionAbsolute;
        private Provider<GetBottomSheetOnBoarding> initRecordTimeStamp;
        private Provider<GetMaxRecentRecipient> isLayoutRequested;
        private final DanaContactModule lookAheadTest;
        private Provider<ContactProvider> moveToNextValue;
        private Provider<GetMaxSavedBank> newProxyInstance;
        private Provider<BottomSheetOnBoardingContract.Presenter> readMicros;
        private Provider<ContentResolver> scheduleImpl;
        private Provider<ContactInjectionRepository> whenAvailable;

        public /* synthetic */ RecipientComponentV2Impl(DanaContactModule danaContactModule, SavedBankModule savedBankModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, SortingSendMoneyModule sortingSendMoneyModule, RecentRecipientModule recentRecipientModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(danaContactModule, savedBankModule, bottomSheetOnBoardingModule, sortingSendMoneyModule, recentRecipientModule, sendMoneyTrackerModule, applicationComponent);
        }

        private RecipientComponentV2Impl(DanaContactModule danaContactModule, SavedBankModule savedBankModule, BottomSheetOnBoardingModule bottomSheetOnBoardingModule, SortingSendMoneyModule sortingSendMoneyModule, RecentRecipientModule recentRecipientModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent) {
            this.H = this;
            this.lookAheadTest = danaContactModule;
            this.PlaceComponentResult = applicationComponent;
            this.B = DanaContactModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(danaContactModule);
            this.J = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new PostExecutionThreadProvider(applicationComponent);
            RecentContactRepositoryProvider recentContactRepositoryProvider = new RecentContactRepositoryProvider(applicationComponent);
            this.D = recentContactRepositoryProvider;
            this.DatabaseTableConfigUtil = GetDanaContact_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda5, recentContactRepositoryProvider);
            SyncContactRepositoryProvider syncContactRepositoryProvider = new SyncContactRepositoryProvider(applicationComponent);
            this.L = syncContactRepositoryProvider;
            this.MyBillsEntityDataFactory = CheckSyncProcessCompleteState_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda5, syncContactRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = GetLastSyncedContact_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.L);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = featureConfigRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckContactSyncFeature_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda5, featureConfigRepositoryProvider);
            ProvideFeedsShareRepositoryProvider provideFeedsShareRepositoryProvider = new ProvideFeedsShareRepositoryProvider(applicationComponent);
            this.getSupportButtonTintMode = provideFeedsShareRepositoryProvider;
            this.F = SaveShareFeedConsent_Factory.MyBillsEntityDataFactory(provideFeedsShareRepositoryProvider);
            ContentResolverProvider contentResolverProvider = new ContentResolverProvider(applicationComponent);
            this.scheduleImpl = contentResolverProvider;
            this.moveToNextValue = ContactProvider_Factory.PlaceComponentResult(contentResolverProvider);
            this.getCallingPid = new ProvideGetContactsUseCaseProvider(applicationComponent);
            ProvideContactInjectionRepositoryProvider provideContactInjectionRepositoryProvider = new ProvideContactInjectionRepositoryProvider(applicationComponent);
            this.whenAvailable = provideContactInjectionRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = GetContactInjectionConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1, provideContactInjectionRepositoryProvider);
            this.A = DoubleCheck.getAuthRequestContext(SavedBankModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(savedBankModule));
            RecentRecipientRepositoryProvider recentRecipientRepositoryProvider = new RecentRecipientRepositoryProvider(applicationComponent);
            this.getOnBoardingScenario = recentRecipientRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = GetRecentBank_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda5, recentRecipientRepositoryProvider);
            this.newProxyInstance = GetMaxSavedBank_Factory.create(this.getOnBoardingScenario);
            SearchRecentBank_Factory create = SearchRecentBank_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.getOnBoardingScenario);
            this.G = create;
            SavedBankCardPresenter_Factory BuiltInFictitiousFunctionClassFactory = SavedBankCardPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.A, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.newProxyInstance, create, RecentBankModelMapper_Factory.PlaceComponentResult());
            this.AppCompatEmojiTextHelper = BuiltInFictitiousFunctionClassFactory;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = DoubleCheck.getAuthRequestContext(SavedBankModule_ProvidePresenterFactory.PlaceComponentResult(savedBankModule, BuiltInFictitiousFunctionClassFactory));
            this.SubSequence = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory.getAuthRequestContext(bottomSheetOnBoardingModule));
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.getNameOrBuilderList = userEducationRepositoryProvider;
            this.initRecordTimeStamp = GetBottomSheetOnBoarding_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda5, userEducationRepositoryProvider);
            SaveDisplayBottomSheetOnBoarding_Factory create2 = SaveDisplayBottomSheetOnBoarding_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.getNameOrBuilderList);
            this.I = create2;
            BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory2 = BottomSheetOnBoardingPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.SubSequence, this.initRecordTimeStamp, create2);
            this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory2;
            this.readMicros = DoubleCheck.getAuthRequestContext(BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory.PlaceComponentResult(bottomSheetOnBoardingModule, BuiltInFictitiousFunctionClassFactory2));
            this.E = DoubleCheck.getAuthRequestContext(SortingSendMoneyModule_ProvideViewFactory.MyBillsEntityDataFactory(sortingSendMoneyModule));
            this.getValueOfTouchPositionAbsolute = DoubleCheck.getAuthRequestContext(RecentRecipientModule_ProvideViewFactory.MyBillsEntityDataFactory(recentRecipientModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = GetRecentRecipient_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.getOnBoardingScenario);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CheckTransferToLinkFeature_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.getAuthRequestContext = CheckSendMoneyPeerToCash_Factory.create(this.J, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = MaskingRecentRecipient_Factory.create(this.getOnBoardingScenario);
            this.isLayoutRequested = GetMaxRecentRecipient_Factory.create(this.getOnBoardingScenario);
            this.FragmentBottomSheetPaymentSettingBinding = GetRecentTransaction_Factory.create(this.getOnBoardingScenario);
            this.PrepareContext = GetRecentContact_Factory.create(this.getOnBoardingScenario);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = GetRecentGroup_Factory.create(this.getOnBoardingScenario);
            this.GetContactSyncConfig = GetIsRecentRecipientMigratedToRoom_Factory.create(this.getOnBoardingScenario);
            RecentRecipientPresenter_Factory MyBillsEntityDataFactory = RecentRecipientPresenter_Factory.MyBillsEntityDataFactory(this.getValueOfTouchPositionAbsolute, this.NetworkUserEntityData$$ExternalSyntheticLambda4, RecentRecipientModelMapper_Factory.PlaceComponentResult(), this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getAuthRequestContext, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.isLayoutRequested, this.FragmentBottomSheetPaymentSettingBinding, this.PrepareContext, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.GetContactSyncConfig);
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = MyBillsEntityDataFactory;
            this.C = DoubleCheck.getAuthRequestContext(RecentRecipientModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(recentRecipientModule, MyBillsEntityDataFactory));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.getErrorConfigVersion = contextProvider;
            SendMoneyMixpanelTracker_Factory authRequestContext = SendMoneyMixpanelTracker_Factory.getAuthRequestContext(contextProvider);
            this.K = authRequestContext;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = DoubleCheck.getAuthRequestContext(SendMoneyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(sendMoneyTrackerModule, authRequestContext));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent getAuthRequestContext;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.getAuthRequestContext.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent PlaceComponentResult;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class RecentContactRepositoryProvider implements Provider<RecentContactRepository> {
            private final ApplicationComponent getAuthRequestContext;

            RecentContactRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentContactRepository get() {
                return (RecentContactRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.ReferralMapper_Factory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SyncContactRepositoryProvider implements Provider<SyncContactRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SyncContactRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SyncContactRepository get() {
                return (SyncContactRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.containsObjectForKey());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent getAuthRequestContext;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFeedsShareRepositoryProvider implements Provider<FeedsShareRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideFeedsShareRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsShareRepository get() {
                return (FeedsShareRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContentResolverProvider implements Provider<ContentResolver> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ContentResolverProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContentResolver get() {
                return (ContentResolver) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideGetContactsUseCaseProvider implements Provider<GetContactsUseCase> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideGetContactsUseCaseProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GetContactsUseCase get() {
                return (GetContactsUseCase) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.p());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideContactInjectionRepositoryProvider implements Provider<ContactInjectionRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideContactInjectionRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContactInjectionRepository get() {
                return (ContactInjectionRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.h());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class RecentRecipientRepositoryProvider implements Provider<RecentRecipientRepository> {
            private final ApplicationComponent PlaceComponentResult;

            RecentRecipientRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentRecipientRepository get() {
                return (RecentRecipientRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.access$setShowcaseShowing$p());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.ArrayTable$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue());
            }
        }

        @Override // id.dana.di.component.RecipientComponentV2
        public final void KClassImpl$Data$declaredNonStaticMembers$2(RecipientView recipientView) {
            RecipientView_MembersInjector.MyBillsEntityDataFactory(recipientView, DanaContactModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, new DanaContactPresenter((Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue()), DoubleCheck.MyBillsEntityDataFactory(this.B), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(SyncContactUtil_Factory.BuiltInFictitiousFunctionClassFactory()), DoubleCheck.MyBillsEntityDataFactory(this.F), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.getCallingPid), DoubleCheck.MyBillsEntityDataFactory(UserContactMapper_Factory.MyBillsEntityDataFactory()), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2))));
            RecipientView_MembersInjector.BuiltInFictitiousFunctionClassFactory(recipientView, this.BottomSheetCardBindingView$watcherCardNumberView$1.get());
            RecipientView_MembersInjector.getAuthRequestContext(recipientView, this.readMicros.get());
            RecipientView_MembersInjector.PlaceComponentResult(recipientView, new SortingSendMoneyPresenter(new GetSortingSendMoney((SendMoneyRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.BaseSocialFeedContract$Presenter())), new SaveSortingSendMoney((SendMoneyRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.BaseSocialFeedContract$Presenter())), this.E.get()));
            RecipientView_MembersInjector.PlaceComponentResult(recipientView, this.C.get());
            recipientView.sendMoneyAnalyticTracker = this.VerifyPinStateManager$executeRiskChallenge$2$1.get();
        }
    }
}

package id.dana.cardbinding.di.component;

import android.app.Application;
import android.content.Context;
import com.google.common.collect.ImmutableMap;
import dagger.internal.Preconditions;
import id.dana.cardbinding.activity.CardBindingActivity;
import id.dana.cardbinding.activity.CardBindingCameraActivity;
import id.dana.cardbinding.activity.CardBindingCameraActivity_MembersInjector;
import id.dana.cardbinding.di.module.CardBindingAnalyticModule;
import id.dana.cardbinding.di.module.CardBindingAnalyticModule_ProvideCardBindingAnalyticTrackerFactory;
import id.dana.cardbinding.di.module.ViewModelFactory;
import id.dana.cardbinding.domain.CardBindingRepository;
import id.dana.cardbinding.domain.interactor.BindingCardAdd;
import id.dana.cardbinding.domain.interactor.BindingCardAdd_Factory;
import id.dana.cardbinding.domain.interactor.GetCardInfoFromImage;
import id.dana.cardbinding.domain.interactor.GetCardInfoFromImage_Factory;
import id.dana.cardbinding.domain.interactor.GetSupportedCardsConfig;
import id.dana.cardbinding.domain.interactor.GetSupportedCardsConfig_Factory;
import id.dana.cardbinding.fragment.CardBindingOtpChallengeFragment;
import id.dana.cardbinding.fragment.CardBindingOtpChallengeFragment_MembersInjector;
import id.dana.cardbinding.viewmodel.CardBindingViewModel;
import id.dana.cardbinding.viewmodel.CardBindingViewModel_Factory;
import id.dana.cardbinding.viewmodel.OtpCardBindingViewModel;
import id.dana.cardbinding.viewmodel.OtpCardBindingViewModel_Factory;
import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.interactor.CreateCashierAgreement;
import id.dana.cashier.domain.interactor.CreateCashierAgreementFlow;
import id.dana.cashier.domain.interactor.CreateCashierAgreementFlow_Factory;
import id.dana.cashier.domain.interactor.CreateCashierAgreement_Factory;
import id.dana.cashier.domain.interactor.GetCashierCheckoutInfo;
import id.dana.cashier.domain.interactor.GetCashierCheckoutInfoFlow;
import id.dana.cashier.domain.interactor.GetCashierCheckoutInfoFlow_Factory;
import id.dana.cashier.domain.interactor.GetCashierCheckoutInfo_Factory;
import id.dana.cashier.domain.interactor.GetOneklikRedirectUrl;
import id.dana.cashier.domain.interactor.GetOneklikRedirectUrlFlow;
import id.dana.cashier.domain.interactor.GetOneklikRedirectUrlFlow_Factory;
import id.dana.cashier.domain.interactor.GetOneklikRedirectUrl_Factory;
import id.dana.cashier.domain.interactor.GetQueryCardPolicy;
import id.dana.cashier.domain.interactor.GetQueryCardPolicyFlow;
import id.dana.cashier.domain.interactor.GetQueryCardPolicyFlow_Factory;
import id.dana.cashier.domain.interactor.GetQueryCardPolicy_Factory;
import id.dana.cashier.domain.interactor.PayCashier;
import id.dana.cashier.domain.interactor.PayCashierFlow;
import id.dana.cashier.domain.interactor.PayCashierFlow_Factory;
import id.dana.cashier.domain.interactor.PayCashier_Factory;
import id.dana.cashier.domain.interactor.PayQueryCashier;
import id.dana.cashier.domain.interactor.PayQueryCashierFlow;
import id.dana.cashier.domain.interactor.PayQueryCashierFlow_Factory;
import id.dana.cashier.domain.interactor.PayQueryCashier_Factory;
import id.dana.cashier.mapper.AttributeModelMapper;
import id.dana.cashier.mapper.AttributeModelMapper_Factory;
import id.dana.cashier.mapper.CashierCheckoutModelMapper;
import id.dana.cashier.mapper.CashierCheckoutModelMapper_Factory;
import id.dana.cashier.mapper.CashierPayChannelModelsMapper;
import id.dana.cashier.mapper.CashierPayChannelModelsMapper_Factory;
import id.dana.cashier.mapper.CashierPayModelMapper;
import id.dana.cashier.mapper.CashierPayModelMapper_Factory;
import id.dana.cashier.mapper.VoucherCashierModelsMapper;
import id.dana.cashier.mapper.VoucherCashierModelsMapper_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.investment.InvestmentRepository;
import id.dana.domain.otp.OtpRepository;
import id.dana.domain.otp.interactor.ReceiveSms;
import id.dana.domain.otp.interactor.ReceiveSmsFlow;
import id.dana.domain.otp.interactor.ReceiveSmsFlow_Factory;
import id.dana.domain.otp.interactor.ReceiveSms_Factory;
import id.dana.domain.otp.interactor.SendBankOtp;
import id.dana.domain.otp.interactor.SendBankOtpFlow;
import id.dana.domain.otp.interactor.SendBankOtpFlow_Factory;
import id.dana.domain.otp.interactor.SendBankOtp_Factory;
import id.dana.domain.otp.interactor.SendOtp;
import id.dana.domain.otp.interactor.SendOtpFlow;
import id.dana.domain.otp.interactor.SendOtpFlow_Factory;
import id.dana.domain.otp.interactor.SendOtp_Factory;
import id.dana.domain.otp.interactor.VerifyOtpOneKlik;
import id.dana.domain.otp.interactor.VerifyOtpOneKlikFlow;
import id.dana.domain.otp.interactor.VerifyOtpOneKlikFlow_Factory;
import id.dana.domain.otp.interactor.VerifyOtpOneKlik_Factory;
import id.dana.domain.payasset.interactor.QueryPayMethod;
import id.dana.domain.payasset.interactor.QueryPayMethod_Factory;
import id.dana.domain.payasset.repository.PayAssetRepository;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip_Factory;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip_Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.sendmoney.mapper.CouponPayMethodInfoListModelMapper;
import id.dana.sendmoney.mapper.CouponPayMethodInfoListModelMapper_Factory;
import id.dana.sendmoney.mapper.CouponPayMethodInfoModelMapper;
import id.dana.sendmoney.mapper.CouponPayMethodInfoModelMapper_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DaggerCardBindingComponent {
    private DaggerCardBindingComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private CardBindingAnalyticModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final CardBindingComponent BuiltInFictitiousFunctionClassFactory() {
            if (this.getAuthRequestContext == null) {
                this.getAuthRequestContext = new CardBindingAnalyticModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
            return new CardBindingComponentImpl(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
        }
    }

    /* loaded from: classes4.dex */
    public static final class CardBindingComponentImpl implements CardBindingComponent {
        private Provider<PostExecutionThread> A;
        private Provider<SendBankOtp> AppCompatEmojiTextHelper;
        private Provider<PayQueryCashier> B;
        private Provider<PayQueryCashierFlow> BottomSheetCardBindingView$watcherCardNumberView$1;
        private Provider<Application> BuiltInFictitiousFunctionClassFactory;
        private Provider<CardBindingRepository> C;
        private Provider<ReceiveSms> D;
        private Provider<CouponPayMethodInfoListModelMapper> DatabaseTableConfigUtil;
        private Provider<QueryPayMethod> E;
        private Provider<UserEducationRepository> F;
        private Provider<IsNeedToShowToolTip> FragmentBottomSheetPaymentSettingBinding;
        private Provider<SendOtp> G;
        private Provider<CashierRepository> GetContactSyncConfig;
        private Provider<SendOtpFlow> H;
        private Provider<ThreadExecutor> I;
        private Provider<VerifyOtpOneKlik> J;
        private Provider<VerifyOtpOneKlikFlow> K;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<VoucherCashierModelsMapper> M;
        private final CardBindingAnalyticModule MyBillsEntityDataFactory;
        private final CardBindingComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<CouponPayMethodInfoModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<CreateCashierAgreementFlow> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<GetSupportedCardsConfig> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<GetQueryCardPolicyFlow> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<GetOneklikRedirectUrl> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<GetQueryCardPolicy> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<GetCardInfoFromImage> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<GetOneklikRedirectUrlFlow> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<AttributeModelMapper> PlaceComponentResult;
        private Provider<GetCashierCheckoutInfoFlow> PrepareContext;
        private Provider<OtpCardBindingViewModel> SubSequence;
        private Provider<InvestmentRepository> VerifyPinStateManager$executeRiskChallenge$2$1;
        private Provider<SendBankOtpFlow> VerifyPinStateManager$executeRiskChallenge$2$2;
        private Provider<BindingCardAdd> getAuthRequestContext;
        private Provider<PayCashier> getCallingPid;
        private Provider<CashierPayModelMapper> getErrorConfigVersion;
        private Provider<SaveShowToolTip> getOnBoardingScenario;
        private Provider<OtpRepository> getSupportButtonTintMode;
        private Provider<ReceiveSmsFlow> getValueOfTouchPositionAbsolute;
        private Provider<CreateCashierAgreement> initRecordTimeStamp;
        private Provider<DeviceInformationProvider> isLayoutRequested;
        private Provider<CashierPayChannelModelsMapper> lookAheadTest;
        private Provider<CashierCheckoutModelMapper> moveToNextValue;
        private Provider<GetCashierCheckoutInfo> newProxyInstance;
        private Provider<PayAssetRepository> readMicros;
        private Provider<CardBindingViewModel> scheduleImpl;
        private Provider<PayCashierFlow> whenAvailable;

        /* synthetic */ CardBindingComponentImpl(CardBindingAnalyticModule cardBindingAnalyticModule, ApplicationComponent applicationComponent, byte b) {
            this(cardBindingAnalyticModule, applicationComponent);
        }

        private CardBindingComponentImpl(CardBindingAnalyticModule cardBindingAnalyticModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this;
            this.MyBillsEntityDataFactory = cardBindingAnalyticModule;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.BuiltInFictitiousFunctionClassFactory = new ApplicationProvider(applicationComponent);
            ProvideNewCardBindingRepositoryProvider provideNewCardBindingRepositoryProvider = new ProvideNewCardBindingRepositoryProvider(applicationComponent);
            this.C = provideNewCardBindingRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = GetCardInfoFromImage_Factory.PlaceComponentResult(provideNewCardBindingRepositoryProvider);
            this.I = new ThreadExecutorProvider(applicationComponent);
            this.A = new PostExecutionThreadProvider(applicationComponent);
            UserEducationRepositoryProvider userEducationRepositoryProvider = new UserEducationRepositoryProvider(applicationComponent);
            this.F = userEducationRepositoryProvider;
            this.FragmentBottomSheetPaymentSettingBinding = IsNeedToShowToolTip_Factory.create(this.I, this.A, userEducationRepositoryProvider);
            this.getOnBoardingScenario = SaveShowToolTip_Factory.create(this.I, this.A, this.F);
            this.getAuthRequestContext = BindingCardAdd_Factory.getAuthRequestContext(this.C);
            CashierRepositoryProvider cashierRepositoryProvider = new CashierRepositoryProvider(applicationComponent);
            this.GetContactSyncConfig = cashierRepositoryProvider;
            GetQueryCardPolicy_Factory create = GetQueryCardPolicy_Factory.create(cashierRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = create;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = GetQueryCardPolicyFlow_Factory.create(create);
            ProvideInvestmentRepositoryProvider provideInvestmentRepositoryProvider = new ProvideInvestmentRepositoryProvider(applicationComponent);
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = provideInvestmentRepositoryProvider;
            GetCashierCheckoutInfo_Factory create2 = GetCashierCheckoutInfo_Factory.create(this.GetContactSyncConfig, provideInvestmentRepositoryProvider);
            this.newProxyInstance = create2;
            this.PrepareContext = GetCashierCheckoutInfoFlow_Factory.create(create2);
            CouponPayMethodInfoModelMapper_Factory PlaceComponentResult = CouponPayMethodInfoModelMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = PlaceComponentResult;
            CouponPayMethodInfoListModelMapper_Factory BuiltInFictitiousFunctionClassFactory = CouponPayMethodInfoListModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult);
            this.DatabaseTableConfigUtil = BuiltInFictitiousFunctionClassFactory;
            VoucherCashierModelsMapper_Factory authRequestContext = VoucherCashierModelsMapper_Factory.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
            this.M = authRequestContext;
            CashierPayChannelModelsMapper_Factory PlaceComponentResult2 = CashierPayChannelModelsMapper_Factory.PlaceComponentResult(authRequestContext);
            this.lookAheadTest = PlaceComponentResult2;
            AttributeModelMapper_Factory BuiltInFictitiousFunctionClassFactory2 = AttributeModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2);
            this.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory2;
            this.moveToNextValue = CashierCheckoutModelMapper_Factory.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2);
            this.getErrorConfigVersion = CashierPayModelMapper_Factory.getAuthRequestContext(this.PlaceComponentResult);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = GetSupportedCardsConfig_Factory.MyBillsEntityDataFactory(this.C);
            PayCashier_Factory create3 = PayCashier_Factory.create(this.GetContactSyncConfig);
            this.getCallingPid = create3;
            this.whenAvailable = PayCashierFlow_Factory.create(create3);
            PayQueryCashier_Factory create4 = PayQueryCashier_Factory.create(this.GetContactSyncConfig);
            this.B = create4;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = PayQueryCashierFlow_Factory.create(create4);
            this.isLayoutRequested = new DeviceInformationProviderProvider(applicationComponent);
            GetOneklikRedirectUrl_Factory create5 = GetOneklikRedirectUrl_Factory.create(this.GetContactSyncConfig);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = create5;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = GetOneklikRedirectUrlFlow_Factory.create(create5);
            PayAssetRepositoryProvider payAssetRepositoryProvider = new PayAssetRepositoryProvider(applicationComponent);
            this.readMicros = payAssetRepositoryProvider;
            QueryPayMethod_Factory create6 = QueryPayMethod_Factory.create(payAssetRepositoryProvider);
            this.E = create6;
            this.scheduleImpl = CardBindingViewModel_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.FragmentBottomSheetPaymentSettingBinding, this.getOnBoardingScenario, this.getAuthRequestContext, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.PrepareContext, this.moveToNextValue, this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.whenAvailable, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda8, create6);
            CreateCashierAgreement_Factory create7 = CreateCashierAgreement_Factory.create(this.GetContactSyncConfig);
            this.initRecordTimeStamp = create7;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = CreateCashierAgreementFlow_Factory.create(create7);
            OtpRepositoryProvider otpRepositoryProvider = new OtpRepositoryProvider(applicationComponent);
            this.getSupportButtonTintMode = otpRepositoryProvider;
            SendOtp_Factory create8 = SendOtp_Factory.create(this.I, this.A, otpRepositoryProvider);
            this.G = create8;
            this.H = SendOtpFlow_Factory.create(create8);
            SendBankOtp_Factory create9 = SendBankOtp_Factory.create(this.getSupportButtonTintMode);
            this.AppCompatEmojiTextHelper = create9;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = SendBankOtpFlow_Factory.create(create9);
            ReceiveSms_Factory create10 = ReceiveSms_Factory.create(this.getSupportButtonTintMode);
            this.D = create10;
            this.getValueOfTouchPositionAbsolute = ReceiveSmsFlow_Factory.create(create10);
            VerifyOtpOneKlik_Factory create11 = VerifyOtpOneKlik_Factory.create(this.getSupportButtonTintMode);
            this.J = create11;
            VerifyOtpOneKlikFlow_Factory create12 = VerifyOtpOneKlikFlow_Factory.create(create11);
            this.K = create12;
            this.SubSequence = OtpCardBindingViewModel_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.H, this.VerifyPinStateManager$executeRiskChallenge$2$2, this.getValueOfTouchPositionAbsolute, create12, this.isLayoutRequested);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ApplicationProvider implements Provider<Application> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ApplicationProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Application get() {
                return (Application) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideNewCardBindingRepositoryProvider implements Provider<CardBindingRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ProvideNewCardBindingRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CardBindingRepository get() {
                return (CardBindingRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.z());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class UserEducationRepositoryProvider implements Provider<UserEducationRepository> {
            private final ApplicationComponent getAuthRequestContext;

            UserEducationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserEducationRepository get() {
                return (UserEducationRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.ArrayTable$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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
        public static final class OtpRepositoryProvider implements Provider<OtpRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            OtpRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OtpRepository get() {
                return (OtpRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.W());
            }
        }

        @Override // id.dana.cardbinding.di.component.CardBindingComponent
        public final void getAuthRequestContext(CardBindingActivity cardBindingActivity) {
            cardBindingActivity.viewModelFactory = new ViewModelFactory(ImmutableMap.of(CardBindingViewModel.class, (Provider<OtpCardBindingViewModel>) this.scheduleImpl, OtpCardBindingViewModel.class, this.SubSequence));
            cardBindingActivity.cardBindingAnalyticTracker = CardBindingAnalyticModule_ProvideCardBindingAnalyticTrackerFactory.PlaceComponentResult(this.MyBillsEntityDataFactory, (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()));
        }

        @Override // id.dana.cardbinding.di.component.CardBindingComponent
        public final void BuiltInFictitiousFunctionClassFactory(CardBindingCameraActivity cardBindingCameraActivity) {
            CardBindingCameraActivity_MembersInjector.MyBillsEntityDataFactory(cardBindingCameraActivity, new ViewModelFactory(ImmutableMap.of(CardBindingViewModel.class, (Provider<OtpCardBindingViewModel>) this.scheduleImpl, OtpCardBindingViewModel.class, this.SubSequence)));
            CardBindingCameraActivity_MembersInjector.PlaceComponentResult(cardBindingCameraActivity, CardBindingAnalyticModule_ProvideCardBindingAnalyticTrackerFactory.PlaceComponentResult(this.MyBillsEntityDataFactory, (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue())));
        }

        @Override // id.dana.cardbinding.di.component.CardBindingComponent
        public final void MyBillsEntityDataFactory(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment) {
            CardBindingOtpChallengeFragment_MembersInjector.PlaceComponentResult(cardBindingOtpChallengeFragment, new ViewModelFactory(ImmutableMap.of(CardBindingViewModel.class, (Provider<OtpCardBindingViewModel>) this.scheduleImpl, OtpCardBindingViewModel.class, this.SubSequence)));
        }
    }
}

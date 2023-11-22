package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.data.tracker.UserConsentTracker;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.GlobalNetworkModule_ProvidesPresenterFactory;
import id.dana.di.modules.GlobalNetworkModule_ProvidesViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.authcode.interactor.GetAuthCode_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.globalnetwork.interactor.DecodeGnQr;
import id.dana.domain.globalnetwork.interactor.DecodeGnQr_Factory;
import id.dana.domain.globalnetwork.interactor.GetCountryCodeByLocationBlacklistedCountry;
import id.dana.domain.globalnetwork.interactor.GetCountryCodeByLocationBlacklistedCountry_Factory;
import id.dana.domain.globalnetwork.interactor.GetGnCScanBBlacklistedCountry;
import id.dana.domain.globalnetwork.interactor.GetGnCScanBBlacklistedCountry_Factory;
import id.dana.domain.globalnetwork.interactor.GetPayRequest;
import id.dana.domain.globalnetwork.interactor.GetPayRequest_Factory;
import id.dana.domain.globalnetwork.interactor.GetWalletOauth;
import id.dana.domain.globalnetwork.interactor.GetWalletOauth_Factory;
import id.dana.domain.globalnetwork.interactor.IsAlipayConnectServiceFirstTime;
import id.dana.domain.globalnetwork.interactor.IsAlipayConnectServiceFirstTime_Factory;
import id.dana.domain.globalnetwork.interactor.IsCScanBEnabled;
import id.dana.domain.globalnetwork.interactor.IsCScanBEnabled_Factory;
import id.dana.domain.globalnetwork.interactor.OpenMerchantCashier;
import id.dana.domain.globalnetwork.interactor.OpenMerchantCashier_Factory;
import id.dana.domain.globalnetwork.interactor.SaveAlipayConnectServiceFirstTime;
import id.dana.domain.globalnetwork.interactor.SaveAlipayConnectServiceFirstTime_Factory;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.interactor.GetUserInfoWithKyc_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo_Factory;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.currency.GlobalNetworkPresenter;
import id.dana.globalnetwork.currency.GlobalNetworkPresenter_Factory;
import id.dana.globalnetwork.tracker.MixpanelGlobalNetworkTracker;
import id.dana.globalnetwork.tracker.MixpanelGlobalNetworkTracker_Factory;
import id.dana.miniprogram.tnc.TncMiniProgramDialogActivity;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerMiniProgramAgreementComponent {
    private DaggerMiniProgramAgreementComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public GlobalNetworkModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MiniProgramAgreementComponentImpl implements MiniProgramAgreementComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<GlobalNetworkRepository> DatabaseTableConfigUtil;
        private Provider<OpenMerchantCashier> FragmentBottomSheetPaymentSettingBinding;
        private Provider<IsAlipayConnectServiceFirstTime> GetContactSyncConfig;
        private Provider<DecodeGnQr> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<Context> MyBillsEntityDataFactory;
        private Provider<GetGnCScanBBlacklistedCountry> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetWalletOauth> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GlobalNetworkPresenter> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<GlobalNetworkContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<GlobalNetworkContract.View> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<MixpanelGlobalNetworkTracker> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private final MiniProgramAgreementComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda8;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<IsOfflineF2FPay> PrepareContext;
        private Provider<UserRepository> SubSequence;
        private Provider<ConnectionStatusReceiver> getAuthRequestContext;
        private Provider<SaveAlipayConnectServiceFirstTime> getCallingPid;
        private Provider<GetAuthCode> getErrorConfigVersion;
        private Provider<UserConsentRepository> getSupportButtonTintMode;
        private Provider<GetUserInfoWithKyc> initRecordTimeStamp;
        private Provider<IsCScanBEnabled> isLayoutRequested;
        private Provider<GetEmptyUserInfo> lookAheadTest;
        private Provider<GetCountryCodeByLocationBlacklistedCountry> moveToNextValue;
        private Provider<OauthRepository> newProxyInstance;
        private Provider<GetPayRequest> scheduleImpl;
        private Provider<ThreadExecutor> whenAvailable;

        public /* synthetic */ MiniProgramAgreementComponentImpl(GlobalNetworkModule globalNetworkModule, ApplicationComponent applicationComponent, byte b) {
            this(globalNetworkModule, applicationComponent);
        }

        private MiniProgramAgreementComponentImpl(GlobalNetworkModule globalNetworkModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = this;
            this.PlaceComponentResult = applicationComponent;
            this.whenAvailable = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new SSLPinningRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda5, featureConfigRepositoryProvider);
            this.PrepareContext = create;
            this.getAuthRequestContext = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda6, create);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = DoubleCheck.getAuthRequestContext(GlobalNetworkModule_ProvidesViewFactory.MyBillsEntityDataFactory(globalNetworkModule));
            GlobalNetworkRepositoryProvider globalNetworkRepositoryProvider = new GlobalNetworkRepositoryProvider(applicationComponent);
            this.DatabaseTableConfigUtil = globalNetworkRepositoryProvider;
            this.isLayoutRequested = IsCScanBEnabled_Factory.create(this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda5, globalNetworkRepositoryProvider);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DecodeGnQr_Factory.create(this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.DatabaseTableConfigUtil);
            this.FragmentBottomSheetPaymentSettingBinding = OpenMerchantCashier_Factory.create(this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.DatabaseTableConfigUtil);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GetGnCScanBBlacklistedCountry_Factory.create(this.DatabaseTableConfigUtil);
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.SubSequence = userRepositoryProvider;
            this.initRecordTimeStamp = GetUserInfoWithKyc_Factory.create(this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda5, userRepositoryProvider);
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.MyBillsEntityDataFactory = contextProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = MixpanelGlobalNetworkTracker_Factory.PlaceComponentResult(contextProvider);
            this.moveToNextValue = GetCountryCodeByLocationBlacklistedCountry_Factory.create(this.DatabaseTableConfigUtil);
            this.GetContactSyncConfig = IsAlipayConnectServiceFirstTime_Factory.create(this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.DatabaseTableConfigUtil);
            this.getCallingPid = SaveAlipayConnectServiceFirstTime_Factory.create(this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.DatabaseTableConfigUtil);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = GetWalletOauth_Factory.create(this.DatabaseTableConfigUtil);
            this.newProxyInstance = new OauthRepositoryProvider(applicationComponent);
            UserConsentRepositoryProvider userConsentRepositoryProvider = new UserConsentRepositoryProvider(applicationComponent);
            this.getSupportButtonTintMode = userConsentRepositoryProvider;
            GetEmptyUserInfo_Factory create2 = GetEmptyUserInfo_Factory.create(userConsentRepositoryProvider);
            this.lookAheadTest = create2;
            this.getErrorConfigVersion = GetAuthCode_Factory.create(this.newProxyInstance, create2);
            GetPayRequest_Factory create3 = GetPayRequest_Factory.create(this.DatabaseTableConfigUtil);
            this.scheduleImpl = create3;
            Provider<GlobalNetworkPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(GlobalNetworkPresenter_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.isLayoutRequested, this.KClassImpl$Data$declaredNonStaticMembers$2, this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.moveToNextValue, this.GetContactSyncConfig, this.getCallingPid, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.getErrorConfigVersion, create3));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = authRequestContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = DoubleCheck.getAuthRequestContext(GlobalNetworkModule_ProvidesPresenterFactory.PlaceComponentResult(globalNetworkModule, authRequestContext));
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
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getRawPath());
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
        public static final class GlobalNetworkRepositoryProvider implements Provider<GlobalNetworkRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            GlobalNetworkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GlobalNetworkRepository get() {
                return (GlobalNetworkRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.SubSequence());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class OauthRepositoryProvider implements Provider<OauthRepository> {
            private final ApplicationComponent getAuthRequestContext;

            OauthRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ OauthRepository get() {
                return (OauthRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.SummaryVoucherView$$ExternalSyntheticLambda1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class UserConsentRepositoryProvider implements Provider<UserConsentRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            UserConsentRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserConsentRepository get() {
                return (UserConsentRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.WithdrawSavedCardChannelView());
            }
        }

        @Override // id.dana.di.component.MiniProgramAgreementComponent
        public final void PlaceComponentResult(TncMiniProgramDialogActivity tncMiniProgramDialogActivity) {
            ((BaseActivity) tncMiniProgramDialogActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(tncMiniProgramDialogActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(tncMiniProgramDialogActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            tncMiniProgramDialogActivity.presenter = this.NetworkUserEntityData$$ExternalSyntheticLambda3.get();
            tncMiniProgramDialogActivity.userConsentTracker = new UserConsentTracker((Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue()));
        }
    }
}

package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule_ProvideProfilePresenterFactory;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule_ProvideProfileViewFactory;
import id.dana.contract.deeplink.generation.ProfileQrDeepLinkPresenter;
import id.dana.contract.deeplink.generation.ProfileQrDeepLinkPresenter_Factory;
import id.dana.contract.staticqr.GetStaticQrContract;
import id.dana.contract.staticqr.GetStaticQrModule;
import id.dana.contract.staticqr.GetStaticQrModule_ProvidePresenterFactory;
import id.dana.contract.staticqr.GetStaticQrModule_ProvideViewFactory;
import id.dana.contract.staticqr.GetStaticQrPresenter;
import id.dana.contract.staticqr.GetStaticQrPresenter_Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.deeplink.interactor.GenerateProfileQrDeepLink;
import id.dana.domain.deeplink.interactor.GenerateProfileQrDeepLink_Factory;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetQrisTcicoConfig;
import id.dana.domain.featureconfig.interactor.GetQrisTcicoConfig_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import id.dana.domain.qrbarcode.interactor.GetUserDynamicQr;
import id.dana.domain.qrbarcode.interactor.GetUserDynamicQr_Factory;
import id.dana.domain.qrbarcode.interactor.GetUserStaticQr;
import id.dana.domain.qrbarcode.interactor.GetUserStaticQr_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.myprofile.ProfileQrisDialogActivity;
import id.dana.myprofile.ProfileQrisDialogActivity_MembersInjector;
import id.dana.sendmoney_v2.tracker.ApiHitTimer_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerProfileQrisDialogComponent {
    private DaggerProfileQrisDialogComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public GenerateDeepLinkModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;
        public GetStaticQrModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class ProfileQrisDialogComponentImpl implements ProfileQrisDialogComponent {
        private Provider<GenerateLinkRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetStaticQrContract.Presenter> DatabaseTableConfigUtil;
        private Provider<PostExecutionThread> GetContactSyncConfig;
        private Provider<ConnectionStatusReceiver> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<Context> MyBillsEntityDataFactory;
        private Provider<GenerateProfileQrDeepLink> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final ProfileQrisDialogComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<IsOfflineF2FPay> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<GetStaticQrContract.View> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<QrBarcodeRepository> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private final ApplicationComponent PlaceComponentResult;
        private Provider<GenerateDeepLinkContract.ProfileView> PrepareContext;
        private Provider<FeatureConfigRepository> getAuthRequestContext;
        private Provider<GetStaticQrPresenter> getErrorConfigVersion;
        private Provider<ProfileQrDeepLinkPresenter> initRecordTimeStamp;
        private Provider<SSLPinningRepository> isLayoutRequested;
        private Provider<GetQrisTcicoConfig> lookAheadTest;
        private Provider<GetUserDynamicQr> moveToNextValue;
        private Provider<GenerateDeepLinkContract.ProfilePresenter> newProxyInstance;
        private Provider<GetUserStaticQr> scheduleImpl;

        public /* synthetic */ ProfileQrisDialogComponentImpl(GetStaticQrModule getStaticQrModule, GenerateDeepLinkModule generateDeepLinkModule, ApplicationComponent applicationComponent, byte b) {
            this(getStaticQrModule, generateDeepLinkModule, applicationComponent);
        }

        private ProfileQrisDialogComponentImpl(GetStaticQrModule getStaticQrModule, GenerateDeepLinkModule generateDeepLinkModule, ApplicationComponent applicationComponent) {
            ApiHitTimer_Factory apiHitTimer_Factory;
            ApiHitTimer_Factory apiHitTimer_Factory2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = this;
            this.PlaceComponentResult = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new ThreadExecutorProvider(applicationComponent);
            this.isLayoutRequested = new SSLPinningRepositoryProvider(applicationComponent);
            this.GetContactSyncConfig = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.GetContactSyncConfig, featureConfigRepositoryProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = create;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.isLayoutRequested, create);
            this.MyBillsEntityDataFactory = new ContextProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = DoubleCheck.getAuthRequestContext(GetStaticQrModule_ProvideViewFactory.MyBillsEntityDataFactory(getStaticQrModule));
            QrBarcodeRepositoryProvider qrBarcodeRepositoryProvider = new QrBarcodeRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = qrBarcodeRepositoryProvider;
            this.scheduleImpl = GetUserStaticQr_Factory.create(qrBarcodeRepositoryProvider);
            this.moveToNextValue = GetUserDynamicQr_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.getAuthRequestContext);
            GetQrisTcicoConfig_Factory create2 = GetQrisTcicoConfig_Factory.create(this.getAuthRequestContext);
            this.lookAheadTest = create2;
            Provider<Context> provider = this.MyBillsEntityDataFactory;
            Provider<GetStaticQrContract.View> provider2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            Provider<GetUserStaticQr> provider3 = this.scheduleImpl;
            Provider<GetUserDynamicQr> provider4 = this.moveToNextValue;
            apiHitTimer_Factory = ApiHitTimer_Factory.InstanceHolder.getAuthRequestContext;
            Provider<GetStaticQrPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(GetStaticQrPresenter_Factory.BuiltInFictitiousFunctionClassFactory(provider, provider2, provider3, provider4, create2, apiHitTimer_Factory));
            this.getErrorConfigVersion = authRequestContext;
            this.DatabaseTableConfigUtil = DoubleCheck.getAuthRequestContext(GetStaticQrModule_ProvidePresenterFactory.PlaceComponentResult(getStaticQrModule, authRequestContext));
            GenerateLinkRepositoryProvider generateLinkRepositoryProvider = new GenerateLinkRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = generateLinkRepositoryProvider;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GenerateProfileQrDeepLink_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.GetContactSyncConfig, generateLinkRepositoryProvider);
            Provider<GenerateDeepLinkContract.ProfileView> authRequestContext2 = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideProfileViewFactory.MyBillsEntityDataFactory(generateDeepLinkModule));
            this.PrepareContext = authRequestContext2;
            Provider<Context> provider5 = this.MyBillsEntityDataFactory;
            Provider<GenerateProfileQrDeepLink> provider6 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            apiHitTimer_Factory2 = ApiHitTimer_Factory.InstanceHolder.getAuthRequestContext;
            Provider<ProfileQrDeepLinkPresenter> authRequestContext3 = DoubleCheck.getAuthRequestContext(ProfileQrDeepLinkPresenter_Factory.PlaceComponentResult(provider5, provider6, authRequestContext2, apiHitTimer_Factory2));
            this.initRecordTimeStamp = authRequestContext3;
            this.newProxyInstance = DoubleCheck.getAuthRequestContext(GenerateDeepLinkModule_ProvideProfilePresenterFactory.PlaceComponentResult(generateDeepLinkModule, authRequestContext3));
        }

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

        /* loaded from: classes4.dex */
        public static final class QrBarcodeRepositoryProvider implements Provider<QrBarcodeRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            QrBarcodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrBarcodeRepository get() {
                return (QrBarcodeRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SendMoneyScenario());
            }
        }

        /* loaded from: classes4.dex */
        public static final class GenerateLinkRepositoryProvider implements Provider<GenerateLinkRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            GenerateLinkRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GenerateLinkRepository get() {
                return (GenerateLinkRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda6());
            }
        }

        @Override // id.dana.di.component.ProfileQrisDialogComponent
        public final void getAuthRequestContext(ProfileQrisDialogActivity profileQrisDialogActivity) {
            ((BaseActivity) profileQrisDialogActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.PlaceComponentResult.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(profileQrisDialogActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(profileQrisDialogActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            ProfileQrisDialogActivity_MembersInjector.PlaceComponentResult(profileQrisDialogActivity, this.DatabaseTableConfigUtil.get());
            profileQrisDialogActivity.profileQrDeepLinkPresenter = this.newProxyInstance.get();
        }
    }
}

package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.AddOutletReceiverModule;
import id.dana.di.modules.AddOutletReceiverModule_ProvidePresenterFactory;
import id.dana.di.modules.AddOutletReceiverModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sendmoney.interactor.GetSendMoneyVendorLogo;
import id.dana.domain.sendmoney.interactor.GetSendMoneyVendorLogo_Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.sendmoney.external.outlet.AddOutletReceiverActivity;
import id.dana.sendmoney.external.outlet.AddOutletReceiverActivity_MembersInjector;
import id.dana.sendmoney.external.outlet.AddOutletReceiverContract;
import id.dana.sendmoney.external.outlet.AddOutletReceiverPresenter;
import id.dana.sendmoney.external.outlet.AddOutletReceiverPresenter_Factory;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule_ProvideTrackerFactory;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerAddOutletReceiverComponent {
    private DaggerAddOutletReceiverComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public SendMoneyTrackerModule KClassImpl$Data$declaredNonStaticMembers$2;
        public AddOutletReceiverModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class AddOutletReceiverComponentImpl implements AddOutletReceiverComponent {
        private Provider<Context> BuiltInFictitiousFunctionClassFactory;
        private Provider<SendMoneyRepository> DatabaseTableConfigUtil;
        private Provider<AddOutletReceiverContract.View> GetContactSyncConfig;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ConnectionStatusReceiver> MyBillsEntityDataFactory;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<SendMoneyAnalyticTracker> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private final AddOutletReceiverComponentImpl PlaceComponentResult;
        private Provider<AddOutletReceiverPresenter> getAuthRequestContext;
        private Provider<AddOutletReceiverContract.Presenter> getErrorConfigVersion;
        private Provider<SendMoneyMixpanelTracker> initRecordTimeStamp;
        private Provider<IsOfflineF2FPay> lookAheadTest;
        private Provider<PostExecutionThread> moveToNextValue;
        private Provider<GetSendMoneyVendorLogo> scheduleImpl;

        public /* synthetic */ AddOutletReceiverComponentImpl(AddOutletReceiverModule addOutletReceiverModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(addOutletReceiverModule, sendMoneyTrackerModule, applicationComponent);
        }

        private AddOutletReceiverComponentImpl(AddOutletReceiverModule addOutletReceiverModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent) {
            this.PlaceComponentResult = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new SSLPinningRepositoryProvider(applicationComponent);
            this.moveToNextValue = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.moveToNextValue, featureConfigRepositoryProvider);
            this.lookAheadTest = create;
            this.MyBillsEntityDataFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.NetworkUserEntityData$$ExternalSyntheticLambda2, create);
            SendMoneyRepositoryProvider sendMoneyRepositoryProvider = new SendMoneyRepositoryProvider(applicationComponent);
            this.DatabaseTableConfigUtil = sendMoneyRepositoryProvider;
            this.scheduleImpl = GetSendMoneyVendorLogo_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.moveToNextValue, sendMoneyRepositoryProvider);
            Provider<AddOutletReceiverContract.View> authRequestContext = DoubleCheck.getAuthRequestContext(AddOutletReceiverModule_ProvideViewFactory.getAuthRequestContext(addOutletReceiverModule));
            this.GetContactSyncConfig = authRequestContext;
            AddOutletReceiverPresenter_Factory PlaceComponentResult = AddOutletReceiverPresenter_Factory.PlaceComponentResult(this.scheduleImpl, authRequestContext);
            this.getAuthRequestContext = PlaceComponentResult;
            this.getErrorConfigVersion = DoubleCheck.getAuthRequestContext(AddOutletReceiverModule_ProvidePresenterFactory.MyBillsEntityDataFactory(addOutletReceiverModule, PlaceComponentResult));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = contextProvider;
            SendMoneyMixpanelTracker_Factory authRequestContext2 = SendMoneyMixpanelTracker_Factory.getAuthRequestContext(contextProvider);
            this.initRecordTimeStamp = authRequestContext2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = DoubleCheck.getAuthRequestContext(SendMoneyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(sendMoneyTrackerModule, authRequestContext2));
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
            private final ApplicationComponent PlaceComponentResult;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto());
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
        public static final class SendMoneyRepositoryProvider implements Provider<SendMoneyRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            SendMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SendMoneyRepository get() {
                return (SendMoneyRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BaseSocialFeedContract$Presenter());
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

        @Override // id.dana.di.component.AddOutletReceiverComponent
        public final void getAuthRequestContext(AddOutletReceiverActivity addOutletReceiverActivity) {
            ((BaseActivity) addOutletReceiverActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(addOutletReceiverActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(addOutletReceiverActivity, DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            addOutletReceiverActivity.addOutletReceiverPresenter = this.getErrorConfigVersion.get();
            AddOutletReceiverActivity_MembersInjector.PlaceComponentResult(addOutletReceiverActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
        }
    }
}

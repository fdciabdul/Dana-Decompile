package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.contract.promoquest.mission.MissionListPresenter;
import id.dana.di.modules.PromoQuestModule;
import id.dana.di.modules.PromoQuestModule_ProvideMissionViewFactory;
import id.dana.di.modules.PromoQuestModule_ProvidePresenterFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.promoquest.interactor.GetMissionsWithQuestByStatus;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.promoquest.activity.MissionListActivity;
import id.dana.promoquest.activity.MissionListActivity_MembersInjector;
import id.dana.promoquest.mapper.PromoQuestMapper;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerPromoQuestComponent {
    private DaggerPromoQuestComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public PromoQuestModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class PromoQuestComponentImpl implements PromoQuestComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<ConnectionStatusReceiver> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<SSLPinningRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<PostExecutionThread> PlaceComponentResult;
        private Provider<IsOfflineF2FPay> getAuthRequestContext;
        private final PromoQuestComponentImpl getErrorConfigVersion;
        private final PromoQuestModule lookAheadTest;
        private Provider<ThreadExecutor> moveToNextValue;

        public /* synthetic */ PromoQuestComponentImpl(PromoQuestModule promoQuestModule, ApplicationComponent applicationComponent, byte b) {
            this(promoQuestModule, applicationComponent);
        }

        private PromoQuestComponentImpl(PromoQuestModule promoQuestModule, ApplicationComponent applicationComponent) {
            this.getErrorConfigVersion = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.lookAheadTest = promoQuestModule;
            this.moveToNextValue = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SSLPinningRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.moveToNextValue, this.PlaceComponentResult, featureConfigRepositoryProvider);
            this.getAuthRequestContext = create;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda0, create);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        @Override // id.dana.di.component.PromoQuestComponent
        public final void getAuthRequestContext(MissionListActivity missionListActivity) {
            ((BaseActivity) missionListActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(missionListActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(missionListActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            MissionListActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(missionListActivity, PromoQuestModule_ProvidePresenterFactory.getAuthRequestContext(this.lookAheadTest, new MissionListPresenter(new GetMissionsWithQuestByStatus((PromoQuestRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.QrExpiredActivity())), new GetMissionsWithQuestByStatus((PromoQuestRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.QrExpiredActivity())), PromoQuestModule_ProvideMissionViewFactory.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest), new PromoQuestMapper())));
        }
    }
}

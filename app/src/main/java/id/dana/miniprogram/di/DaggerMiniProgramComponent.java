package id.dana.miniprogram.di;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.MiniProgramModule;
import id.dana.di.modules.MiniProgramModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.miniprogram.MiniProgramRepository;
import id.dana.domain.miniprogram.interactor.GetMiniPrograms;
import id.dana.domain.miniprogram.interactor.GetMiniPrograms_Factory;
import id.dana.domain.miniprogram.interactor.SetFavoriteMiniPrograms;
import id.dana.domain.miniprogram.interactor.SetFavoriteMiniPrograms_Factory;
import id.dana.domain.miniprogram.interactor.SetRecentMiniProgram;
import id.dana.domain.miniprogram.interactor.SetRecentMiniProgram_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.miniprogram.MiniProgramStoreActivity;
import id.dana.miniprogram.MiniProgramStoreActivity_MembersInjector;
import id.dana.miniprogram.di.MiniProgramContract;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerMiniProgramComponent {
    private DaggerMiniProgramComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public ApplicationComponent MyBillsEntityDataFactory;
        public MiniProgramModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class MiniProgramComponentImpl implements MiniProgramComponent {
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<SetFavoriteMiniPrograms> DatabaseTableConfigUtil;
        private Provider<SetRecentMiniProgram> GetContactSyncConfig;
        private Provider<IsOfflineF2FPay> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private final MiniProgramComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<GetMiniPrograms> PlaceComponentResult;
        private Provider<ConnectionStatusReceiver> getAuthRequestContext;
        private Provider<MiniProgramContract.View> getErrorConfigVersion;
        private Provider<SSLPinningRepository> lookAheadTest;
        private Provider<MiniProgramRepository> moveToNextValue;
        private Provider<PostExecutionThread> scheduleImpl;

        public /* synthetic */ MiniProgramComponentImpl(MiniProgramModule miniProgramModule, ApplicationComponent applicationComponent, byte b) {
            this(miniProgramModule, applicationComponent);
        }

        private MiniProgramComponentImpl(MiniProgramModule miniProgramModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ThreadExecutorProvider(applicationComponent);
            this.lookAheadTest = new SSLPinningRepositoryProvider(applicationComponent);
            this.scheduleImpl = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.scheduleImpl, featureConfigRepositoryProvider);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = create;
            this.getAuthRequestContext = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.lookAheadTest, create);
            this.getErrorConfigVersion = DoubleCheck.getAuthRequestContext(MiniProgramModule_ProvideViewFactory.PlaceComponentResult(miniProgramModule));
            MiniProgramRepositoryProvider miniProgramRepositoryProvider = new MiniProgramRepositoryProvider(applicationComponent);
            this.moveToNextValue = miniProgramRepositoryProvider;
            this.PlaceComponentResult = GetMiniPrograms_Factory.create(miniProgramRepositoryProvider);
            this.DatabaseTableConfigUtil = SetFavoriteMiniPrograms_Factory.create(this.moveToNextValue);
            this.GetContactSyncConfig = SetRecentMiniProgram_Factory.create(this.moveToNextValue);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class SSLPinningRepositoryProvider implements Provider<SSLPinningRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            SSLPinningRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SSLPinningRepository get() {
                return (SSLPinningRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getRawPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class MiniProgramRepositoryProvider implements Provider<MiniProgramRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            MiniProgramRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MiniProgramRepository get() {
                return (MiniProgramRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SummaryVoucherView$$ExternalSyntheticLambda0());
            }
        }

        @Override // id.dana.miniprogram.di.MiniProgramComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(MiniProgramStoreActivity miniProgramStoreActivity) {
            ((BaseActivity) miniProgramStoreActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(miniProgramStoreActivity, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(miniProgramStoreActivity, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
            MiniProgramStoreActivity_MembersInjector.getAuthRequestContext(miniProgramStoreActivity, new MiniProgramPresenter(this.getErrorConfigVersion.get(), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig)));
        }
    }
}

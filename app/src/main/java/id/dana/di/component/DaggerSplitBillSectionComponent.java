package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.SplitBillSectionModule;
import id.dana.di.modules.SplitBillSectionModule_ProvideSplitBillSectionPresenterFactory;
import id.dana.di.modules.SplitBillSectionModule_ProvideSplitBillSectionViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig_Factory;
import id.dana.splitbill.SplitBillSectionContract;
import id.dana.splitbill.SplitBillSectionPresenter;
import id.dana.splitbill.SplitBillSectionPresenter_Factory;
import id.dana.splitbill.view.SplitBillSectionView;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerSplitBillSectionComponent {
    private DaggerSplitBillSectionComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public SplitBillSectionModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class SplitBillSectionComponentImpl implements SplitBillSectionComponent {
        private Provider<PostExecutionThread> BuiltInFictitiousFunctionClassFactory;
        private Provider<SplitBillSectionContract.Presenter> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<SplitBillSectionContract.View> MyBillsEntityDataFactory;
        private final SplitBillSectionComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetSplitBillConfig> PlaceComponentResult;
        private Provider<FeatureConfigRepository> getAuthRequestContext;
        private Provider<SplitBillSectionPresenter> lookAheadTest;
        private Provider<ThreadExecutor> scheduleImpl;

        public /* synthetic */ SplitBillSectionComponentImpl(SplitBillSectionModule splitBillSectionModule, ApplicationComponent applicationComponent, byte b) {
            this(splitBillSectionModule, applicationComponent);
        }

        private SplitBillSectionComponentImpl(SplitBillSectionModule splitBillSectionModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this;
            this.MyBillsEntityDataFactory = DoubleCheck.getAuthRequestContext(SplitBillSectionModule_ProvideSplitBillSectionViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(splitBillSectionModule));
            this.scheduleImpl = new ThreadExecutorProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = featureConfigRepositoryProvider;
            GetSplitBillConfig_Factory create = GetSplitBillConfig_Factory.create(this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory, featureConfigRepositoryProvider);
            this.PlaceComponentResult = create;
            SplitBillSectionPresenter_Factory authRequestContext = SplitBillSectionPresenter_Factory.getAuthRequestContext(this.MyBillsEntityDataFactory, create);
            this.lookAheadTest = authRequestContext;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DoubleCheck.getAuthRequestContext(SplitBillSectionModule_ProvideSplitBillSectionPresenterFactory.BuiltInFictitiousFunctionClassFactory(splitBillSectionModule, authRequestContext));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        @Override // id.dana.di.component.SplitBillSectionComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(SplitBillSectionView splitBillSectionView) {
            splitBillSectionView.presenter = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        }
    }
}

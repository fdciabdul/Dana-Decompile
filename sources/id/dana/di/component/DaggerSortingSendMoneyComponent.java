package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.contract.sendmoney.v2.SortingSendMoneyContract;
import id.dana.contract.sendmoney.v2.SortingSendMoneyPresenter;
import id.dana.di.modules.SortingSendMoneyModule;
import id.dana.di.modules.SortingSendMoneyModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sendmoney.interactor.GetSortingSendMoney;
import id.dana.domain.sendmoney.interactor.SaveSortingSendMoney;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.sendmoney_v2.recipient.activity.SortBankAccountBottomSheetActivity;
import id.dana.sendmoney_v2.recipient.activity.SortBankAccountBottomSheetActivity_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSortingSendMoneyComponent {
    private DaggerSortingSendMoneyComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public SortingSendMoneyModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class SortingSendMoneyComponentImpl implements SortingSendMoneyComponent {
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private Provider<ConnectionStatusReceiver> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<IsOfflineF2FPay> MyBillsEntityDataFactory;
        private final SortingSendMoneyComponentImpl NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<FeatureConfigRepository> PlaceComponentResult;
        private Provider<PostExecutionThread> getAuthRequestContext;
        private Provider<ThreadExecutor> lookAheadTest;
        private Provider<SSLPinningRepository> moveToNextValue;
        private Provider<SortingSendMoneyContract.View> scheduleImpl;

        public /* synthetic */ SortingSendMoneyComponentImpl(SortingSendMoneyModule sortingSendMoneyModule, ApplicationComponent applicationComponent, byte b) {
            this(sortingSendMoneyModule, applicationComponent);
        }

        private SortingSendMoneyComponentImpl(SortingSendMoneyModule sortingSendMoneyModule, ApplicationComponent applicationComponent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            this.lookAheadTest = new ThreadExecutorProvider(applicationComponent);
            this.moveToNextValue = new SSLPinningRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.lookAheadTest, this.getAuthRequestContext, featureConfigRepositoryProvider);
            this.MyBillsEntityDataFactory = create;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.lookAheadTest, this.moveToNextValue, create);
            this.scheduleImpl = DoubleCheck.getAuthRequestContext(SortingSendMoneyModule_ProvideViewFactory.MyBillsEntityDataFactory(sortingSendMoneyModule));
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

        @Override // id.dana.di.component.SortingSendMoneyComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(SortBankAccountBottomSheetActivity sortBankAccountBottomSheetActivity) {
            ((BaseActivity) sortBankAccountBottomSheetActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(sortBankAccountBottomSheetActivity, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(sortBankAccountBottomSheetActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            SortBankAccountBottomSheetActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(sortBankAccountBottomSheetActivity, new SortingSendMoneyPresenter(new GetSortingSendMoney((SendMoneyRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BaseSocialFeedContract$Presenter())), new SaveSortingSendMoney((SendMoneyRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BaseSocialFeedContract$Presenter())), this.scheduleImpl.get()));
        }
    }
}

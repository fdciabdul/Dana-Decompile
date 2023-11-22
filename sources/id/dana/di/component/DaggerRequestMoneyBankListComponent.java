package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.bank.BottomSheetBankListActivity;
import id.dana.bank.BottomSheetBankListActivity_MembersInjector;
import id.dana.bank.contract.BankListContract;
import id.dana.bank.contract.BankListPresenter;
import id.dana.bank.contract.BankListPresenter_Factory;
import id.dana.di.modules.RequestMoneyBankListModule;
import id.dana.di.modules.RequestMoneyBankListModule_ProvideRequestMoneyBankBankListPresenterFactory;
import id.dana.di.modules.RequestMoneyBankListModule_ProvideRequestMoneyBankBankListViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.requestmoney.RequestMoneyRepository;
import id.dana.domain.requestmoney.interactor.GetTopFeaturedBanks;
import id.dana.domain.requestmoney.interactor.GetTopFeaturedBanks_Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.domain.withdraw.interactor.GetAvailableBanks;
import id.dana.domain.withdraw.interactor.GetAvailableBanks_Factory;
import id.dana.sendmoney.mapper.BankModelMapper_Factory;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule_ProvideTrackerFactory;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerRequestMoneyBankListComponent {
    private DaggerRequestMoneyBankListComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public RequestMoneyBankListModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent PlaceComponentResult;
        public SendMoneyTrackerModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class RequestMoneyBankListComponentImpl implements RequestMoneyBankListComponent {
        private Provider<GetTopFeaturedBanks> BuiltInFictitiousFunctionClassFactory;
        private Provider<SendMoneyRepository> DatabaseTableConfigUtil;
        private Provider<SendMoneyMixpanelTracker> GetContactSyncConfig;
        private Provider<PostExecutionThread> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<Context> MyBillsEntityDataFactory;
        private Provider<SendMoneyAnalyticTracker> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<BankListPresenter> PlaceComponentResult;
        private Provider<GetAvailableBanks> getAuthRequestContext;
        private Provider<BankListContract.Presenter> getErrorConfigVersion;
        private Provider<ThreadExecutor> initRecordTimeStamp;
        private Provider<BankListContract.View> lookAheadTest;
        private final RequestMoneyBankListComponentImpl moveToNextValue;
        private Provider<RequestMoneyRepository> scheduleImpl;

        public /* synthetic */ RequestMoneyBankListComponentImpl(RequestMoneyBankListModule requestMoneyBankListModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent, byte b) {
            this(requestMoneyBankListModule, sendMoneyTrackerModule, applicationComponent);
        }

        private RequestMoneyBankListComponentImpl(RequestMoneyBankListModule requestMoneyBankListModule, SendMoneyTrackerModule sendMoneyTrackerModule, ApplicationComponent applicationComponent) {
            this.moveToNextValue = this;
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(RequestMoneyBankListModule_ProvideRequestMoneyBankBankListViewFactory.getAuthRequestContext(requestMoneyBankListModule));
            RequestMoneyRepositoryProvider requestMoneyRepositoryProvider = new RequestMoneyRepositoryProvider(applicationComponent);
            this.scheduleImpl = requestMoneyRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = GetTopFeaturedBanks_Factory.create(requestMoneyRepositoryProvider);
            this.initRecordTimeStamp = new ThreadExecutorProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new PostExecutionThreadProvider(applicationComponent);
            SendMoneyRepositoryProvider sendMoneyRepositoryProvider = new SendMoneyRepositoryProvider(applicationComponent);
            this.DatabaseTableConfigUtil = sendMoneyRepositoryProvider;
            GetAvailableBanks_Factory create = GetAvailableBanks_Factory.create(this.initRecordTimeStamp, this.KClassImpl$Data$declaredNonStaticMembers$2, sendMoneyRepositoryProvider);
            this.getAuthRequestContext = create;
            BankListPresenter_Factory MyBillsEntityDataFactory = BankListPresenter_Factory.MyBillsEntityDataFactory(this.lookAheadTest, this.BuiltInFictitiousFunctionClassFactory, create, BankModelMapper_Factory.MyBillsEntityDataFactory());
            this.PlaceComponentResult = MyBillsEntityDataFactory;
            this.getErrorConfigVersion = DoubleCheck.getAuthRequestContext(RequestMoneyBankListModule_ProvideRequestMoneyBankBankListPresenterFactory.MyBillsEntityDataFactory(requestMoneyBankListModule, MyBillsEntityDataFactory));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.MyBillsEntityDataFactory = contextProvider;
            SendMoneyMixpanelTracker_Factory authRequestContext = SendMoneyMixpanelTracker_Factory.getAuthRequestContext(contextProvider);
            this.GetContactSyncConfig = authRequestContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = DoubleCheck.getAuthRequestContext(SendMoneyTrackerModule_ProvideTrackerFactory.MyBillsEntityDataFactory(sendMoneyTrackerModule, authRequestContext));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class RequestMoneyRepositoryProvider implements Provider<RequestMoneyRepository> {
            private final ApplicationComponent getAuthRequestContext;

            RequestMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RequestMoneyRepository get() {
                return (RequestMoneyRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.FlowableConcatMapEagerPublisher());
            }
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

        @Override // id.dana.di.component.RequestMoneyBankListComponent
        public final void MyBillsEntityDataFactory(BottomSheetBankListActivity bottomSheetBankListActivity) {
            BottomSheetBankListActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(bottomSheetBankListActivity, this.getErrorConfigVersion.get());
            BottomSheetBankListActivity_MembersInjector.MyBillsEntityDataFactory(bottomSheetBankListActivity, this.NetworkUserEntityData$$ExternalSyntheticLambda0.get());
        }
    }
}

package id.dana.sendmoney_v2.landing.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.recentbank.interactor.RemoveRecentSavedBank;
import id.dana.domain.recentbank.interactor.RemoveRecentSavedBank_Factory;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.recentbank.interactor.SaveRecentBank_Factory;
import id.dana.domain.recentcontact.interactor.RemoveRecentSavedContact;
import id.dana.domain.recentcontact.interactor.RemoveRecentSavedContact_Factory;
import id.dana.domain.recentrecipient.interactor.GetMaxFavoriteAccount;
import id.dana.domain.recentrecipient.interactor.GetMaxFavoriteAccount_Factory;
import id.dana.domain.recentrecipient.interactor.RemoveRecentGroup;
import id.dana.domain.recentrecipient.interactor.RemoveRecentGroup_Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.domain.sendmoney.interactor.DeleteGroup;
import id.dana.domain.sendmoney.interactor.DeleteGroup_Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.sendmoney_v2.landing.contract.ManageAccountContract;
import id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter;
import id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter_Factory;
import id.dana.sendmoney_v2.landing.di.module.ManageAccountModule;
import id.dana.sendmoney_v2.landing.di.module.ManageAccountModule_ProvidePresenterFactory;
import id.dana.sendmoney_v2.landing.di.module.ManageAccountModule_ProvideViewFactory;
import id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerManageAccountComponent {
    private DaggerManageAccountComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public ManageAccountModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class ManageAccountComponentImpl implements ManageAccountComponent {
        private Provider<DeleteGroup> BuiltInFictitiousFunctionClassFactory;
        private Provider<RemoveRecentSavedBank> DatabaseTableConfigUtil;
        private Provider<RemoveRecentSavedContact> GetContactSyncConfig;
        private Provider<GetMaxFavoriteAccount> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ManageAccountComponentImpl MyBillsEntityDataFactory;
        private Provider<ManageAccountContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<SendMoneyRepository> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<Context> PlaceComponentResult;
        private Provider<ManageAccountPresenter> getAuthRequestContext;
        private Provider<RecentRecipientRepository> getErrorConfigVersion;
        private Provider<SaveRecentBank> initRecordTimeStamp;
        private Provider<RemoveRecentGroup> lookAheadTest;
        private Provider<ManageAccountContract.View> moveToNextValue;
        private Provider<PostExecutionThread> scheduleImpl;

        public /* synthetic */ ManageAccountComponentImpl(ManageAccountModule manageAccountModule, ApplicationComponent applicationComponent, byte b) {
            this(manageAccountModule, applicationComponent);
        }

        private ManageAccountComponentImpl(ManageAccountModule manageAccountModule, ApplicationComponent applicationComponent) {
            this.MyBillsEntityDataFactory = this;
            this.PlaceComponentResult = new ContextProvider(applicationComponent);
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(ManageAccountModule_ProvideViewFactory.MyBillsEntityDataFactory(manageAccountModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ThreadExecutorProvider(applicationComponent);
            this.scheduleImpl = new PostExecutionThreadProvider(applicationComponent);
            RecentRecipientRepositoryProvider recentRecipientRepositoryProvider = new RecentRecipientRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = recentRecipientRepositoryProvider;
            this.initRecordTimeStamp = SaveRecentBank_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.scheduleImpl, recentRecipientRepositoryProvider);
            this.DatabaseTableConfigUtil = RemoveRecentSavedBank_Factory.create(this.getErrorConfigVersion);
            this.GetContactSyncConfig = RemoveRecentSavedContact_Factory.create(this.getErrorConfigVersion);
            this.lookAheadTest = RemoveRecentGroup_Factory.create(this.getErrorConfigVersion);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = GetMaxFavoriteAccount_Factory.create(this.getErrorConfigVersion);
            SendMoneyRepositoryProvider sendMoneyRepositoryProvider = new SendMoneyRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = sendMoneyRepositoryProvider;
            DeleteGroup_Factory create = DeleteGroup_Factory.create(sendMoneyRepositoryProvider);
            this.BuiltInFictitiousFunctionClassFactory = create;
            ManageAccountPresenter_Factory PlaceComponentResult = ManageAccountPresenter_Factory.PlaceComponentResult(this.PlaceComponentResult, this.moveToNextValue, this.initRecordTimeStamp, this.DatabaseTableConfigUtil, this.GetContactSyncConfig, this.lookAheadTest, this.KClassImpl$Data$declaredNonStaticMembers$2, create);
            this.getAuthRequestContext = PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = DoubleCheck.getAuthRequestContext(ManageAccountModule_ProvidePresenterFactory.getAuthRequestContext(manageAccountModule, PlaceComponentResult));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
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
        /* loaded from: classes5.dex */
        public static final class RecentRecipientRepositoryProvider implements Provider<RecentRecipientRepository> {
            private final ApplicationComponent getAuthRequestContext;

            RecentRecipientRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentRecipientRepository get() {
                return (RecentRecipientRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.access$setShowcaseShowing$p());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SendMoneyRepositoryProvider implements Provider<SendMoneyRepository> {
            private final ApplicationComponent getAuthRequestContext;

            SendMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SendMoneyRepository get() {
                return (SendMoneyRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.BaseSocialFeedContract$Presenter());
            }
        }

        @Override // id.dana.sendmoney_v2.landing.di.component.ManageAccountComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(ManageAccountBottomSheet manageAccountBottomSheet) {
            manageAccountBottomSheet.presenter = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get();
        }
    }
}

package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.VerificationListModule;
import id.dana.di.modules.VerificationListModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.VerificationListModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.pushverify.interactor.GetActivePushVerificationList;
import id.dana.domain.pushverify.interactor.GetActivePushVerificationList_Factory;
import id.dana.domain.pushverify.interactor.GetHistoryPushVerificationList;
import id.dana.domain.pushverify.interactor.GetHistoryPushVerificationList_Factory;
import id.dana.domain.pushverify.repository.PushVerifyRepository;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.pushverify.view.verificationlist.list.VerificationListActiveFragment;
import id.dana.pushverify.view.verificationlist.list.VerificationListActiveFragment_MembersInjector;
import id.dana.pushverify.view.verificationlist.list.VerificationListContract;
import id.dana.pushverify.view.verificationlist.list.VerificationListHistoryFragment;
import id.dana.pushverify.view.verificationlist.list.VerificationListHistoryFragment_MembersInjector;
import id.dana.pushverify.view.verificationlist.list.VerificationListPresenter;
import id.dana.pushverify.view.verificationlist.list.VerificationListPresenter_Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerVerificationListComponent {
    private DaggerVerificationListComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public VerificationListModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final VerificationListComponent BuiltInFictitiousFunctionClassFactory() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, VerificationListModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            return new VerificationListComponentImpl(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory, (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class VerificationListComponentImpl implements VerificationListComponent {
        private Provider<GetHistoryPushVerificationList> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetActivePushVerificationList> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<VerificationListContract.View> MyBillsEntityDataFactory;
        private Provider<VerificationListPresenter> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<VerificationListContract.Presenter> PlaceComponentResult;
        private Provider<PushVerifyTracker> getAuthRequestContext;
        private final VerificationListComponentImpl lookAheadTest;
        private Provider<PushVerifyRepository> scheduleImpl;

        /* synthetic */ VerificationListComponentImpl(VerificationListModule verificationListModule, ApplicationComponent applicationComponent, byte b) {
            this(verificationListModule, applicationComponent);
        }

        private VerificationListComponentImpl(VerificationListModule verificationListModule, ApplicationComponent applicationComponent) {
            this.lookAheadTest = this;
            this.MyBillsEntityDataFactory = VerificationListModule_ProvideView$app_productionReleaseFactory.KClassImpl$Data$declaredNonStaticMembers$2(verificationListModule);
            this.getAuthRequestContext = new ProvidePushVerifyTrackerProvider(applicationComponent);
            PushVerifyRepositoryProvider pushVerifyRepositoryProvider = new PushVerifyRepositoryProvider(applicationComponent);
            this.scheduleImpl = pushVerifyRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = GetActivePushVerificationList_Factory.create(pushVerifyRepositoryProvider);
            GetHistoryPushVerificationList_Factory create = GetHistoryPushVerificationList_Factory.create(this.scheduleImpl);
            this.BuiltInFictitiousFunctionClassFactory = create;
            VerificationListPresenter_Factory BuiltInFictitiousFunctionClassFactory = VerificationListPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, create);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = BuiltInFictitiousFunctionClassFactory;
            this.PlaceComponentResult = VerificationListModule_ProvidePresenter$app_productionReleaseFactory.getAuthRequestContext(verificationListModule, BuiltInFictitiousFunctionClassFactory);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvidePushVerifyTrackerProvider implements Provider<PushVerifyTracker> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvidePushVerifyTrackerProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushVerifyTracker get() {
                return (PushVerifyTracker) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.FlowableCreate$BufferAsyncEmitter());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PushVerifyRepositoryProvider implements Provider<PushVerifyRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PushVerifyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PushVerifyRepository get() {
                return (PushVerifyRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.InitSecurePreferenceAccount());
            }
        }

        @Override // id.dana.di.component.VerificationListComponent
        public final void BuiltInFictitiousFunctionClassFactory(VerificationListActiveFragment verificationListActiveFragment) {
            VerificationListActiveFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(verificationListActiveFragment, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            VerificationListActiveFragment_MembersInjector.PlaceComponentResult(verificationListActiveFragment, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
        }

        @Override // id.dana.di.component.VerificationListComponent
        public final void getAuthRequestContext(VerificationListHistoryFragment verificationListHistoryFragment) {
            VerificationListHistoryFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(verificationListHistoryFragment, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            verificationListHistoryFragment.pushVerifyTracker = DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext);
        }
    }
}

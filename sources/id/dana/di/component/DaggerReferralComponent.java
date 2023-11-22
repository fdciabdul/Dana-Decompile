package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.ReferralModule;
import id.dana.di.modules.ReferralModule_ProvidePresenterFactory;
import id.dana.di.modules.ReferralModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetPersonalizedReferralConfig;
import id.dana.domain.featureconfig.interactor.GetPersonalizedReferralConfig_Factory;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation;
import id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation_Factory;
import id.dana.domain.referral.ReferralRepository;
import id.dana.domain.referral.interactor.VerifyReferralCode;
import id.dana.domain.referral.interactor.VerifyReferralCode_Factory;
import id.dana.onboarding.referral.ReferralContract;
import id.dana.onboarding.referral.VerifyReferralCodeFragment;
import id.dana.onboarding.referral.VerifyReferralCodeFragment_MembersInjector;
import id.dana.onboarding.referral.VerifyReferralCodePresenter;
import id.dana.onboarding.referral.VerifyReferralCodePresenter_Factory;
import id.dana.toggle.locationpermission.LocationPermissionSubject;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerReferralComponent {
    private DaggerReferralComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent MyBillsEntityDataFactory;
        public ReferralModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class ReferralComponentImpl implements ReferralComponent {
        private Provider<FeatureConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<VerifyReferralCodePresenter> DatabaseTableConfigUtil;
        private Provider<VerifyReferralCode> GetContactSyncConfig;
        private Provider<GetIndoSubdivisionsByLocation> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<ReferralContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GeocodeRepository> PlaceComponentResult;
        private Provider<GetPersonalizedReferralConfig> getAuthRequestContext;
        private Provider<ReferralRepository> getErrorConfigVersion;
        private Provider<ThreadExecutor> initRecordTimeStamp;
        private final ReferralComponentImpl lookAheadTest;
        private Provider<ReferralContract.Presenter> moveToNextValue;
        private Provider<PostExecutionThread> scheduleImpl;

        public /* synthetic */ ReferralComponentImpl(ReferralModule referralModule, ApplicationComponent applicationComponent, byte b) {
            this(referralModule, applicationComponent);
        }

        private ReferralComponentImpl(ReferralModule referralModule, ApplicationComponent applicationComponent) {
            this.lookAheadTest = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = DoubleCheck.getAuthRequestContext(ReferralModule_ProvideViewFactory.getAuthRequestContext(referralModule));
            this.initRecordTimeStamp = new ThreadExecutorProvider(applicationComponent);
            this.scheduleImpl = new PostExecutionThreadProvider(applicationComponent);
            ReferralRepositoryProvider referralRepositoryProvider = new ReferralRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = referralRepositoryProvider;
            this.GetContactSyncConfig = VerifyReferralCode_Factory.create(this.initRecordTimeStamp, this.scheduleImpl, referralRepositoryProvider);
            GeocodeRepositoryProvider geocodeRepositoryProvider = new GeocodeRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = geocodeRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = GetIndoSubdivisionsByLocation_Factory.create(this.initRecordTimeStamp, this.scheduleImpl, geocodeRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = featureConfigRepositoryProvider;
            GetPersonalizedReferralConfig_Factory create = GetPersonalizedReferralConfig_Factory.create(featureConfigRepositoryProvider);
            this.getAuthRequestContext = create;
            VerifyReferralCodePresenter_Factory authRequestContext = VerifyReferralCodePresenter_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.GetContactSyncConfig, this.KClassImpl$Data$declaredNonStaticMembers$2, create);
            this.DatabaseTableConfigUtil = authRequestContext;
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(ReferralModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(referralModule, authRequestContext));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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
        /* loaded from: classes4.dex */
        public static final class ReferralRepositoryProvider implements Provider<ReferralRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ReferralRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ReferralRepository get() {
                return (ReferralRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NewMerchantCategoryAdapter());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class GeocodeRepositoryProvider implements Provider<GeocodeRepository> {
            private final ApplicationComponent getAuthRequestContext;

            GeocodeRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GeocodeRepository get() {
                return (GeocodeRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getSupportButtonTintMode());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent getAuthRequestContext;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        @Override // id.dana.di.component.ReferralComponent
        public final void MyBillsEntityDataFactory(VerifyReferralCodeFragment verifyReferralCodeFragment) {
            verifyReferralCodeFragment.locationPermissionSubject = (LocationPermissionSubject) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.w());
            VerifyReferralCodeFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(verifyReferralCodeFragment, this.moveToNextValue.get());
        }
    }
}

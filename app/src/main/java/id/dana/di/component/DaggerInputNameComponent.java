package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.ConnectionStatusReceiver_Factory;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.di.modules.InputNameModule;
import id.dana.di.modules.InputNameModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.InputNameModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.userprofileinfo.UserProfileInfoRepository;
import id.dana.domain.userprofileinfo.interactor.CheckSkipButtonMerchantList;
import id.dana.domain.userprofileinfo.interactor.UpdateNicknameProfile;
import id.dana.oauth.activity.InputNameActivity;
import id.dana.oauth.activity.InputNameActivity_MembersInjector;
import id.dana.oauth.presenter.InputNamePresenter;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerInputNameComponent {
    private DaggerInputNameComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public InputNameModule KClassImpl$Data$declaredNonStaticMembers$2;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class InputNameComponentImpl implements InputNameComponent {
        private Provider<ConnectionStatusReceiver> BuiltInFictitiousFunctionClassFactory;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private final InputNameModule MyBillsEntityDataFactory;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<FeatureConfigRepository> PlaceComponentResult;
        private final InputNameComponentImpl getAuthRequestContext;
        private Provider<PostExecutionThread> getErrorConfigVersion;
        private Provider<IsOfflineF2FPay> moveToNextValue;
        private Provider<SSLPinningRepository> scheduleImpl;

        public /* synthetic */ InputNameComponentImpl(InputNameModule inputNameModule, ApplicationComponent applicationComponent, byte b) {
            this(inputNameModule, applicationComponent);
        }

        private InputNameComponentImpl(InputNameModule inputNameModule, ApplicationComponent applicationComponent) {
            this.getAuthRequestContext = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.MyBillsEntityDataFactory = inputNameModule;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ThreadExecutorProvider(applicationComponent);
            this.scheduleImpl = new SSLPinningRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = featureConfigRepositoryProvider;
            IsOfflineF2FPay_Factory create = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getErrorConfigVersion, featureConfigRepositoryProvider);
            this.moveToNextValue = create;
            this.BuiltInFictitiousFunctionClassFactory = ConnectionStatusReceiver_Factory.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.scheduleImpl, create);
        }

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

        @Override // id.dana.di.component.InputNameComponent
        public final void BuiltInFictitiousFunctionClassFactory(InputNameActivity inputNameActivity) {
            ((BaseActivity) inputNameActivity).appLifeCycleObserver = (AppLifeCycleObserver) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
            BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(inputNameActivity, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            BaseActivity_MembersInjector.MyBillsEntityDataFactory(inputNameActivity, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
            InputNameActivity_MembersInjector.PlaceComponentResult(inputNameActivity, InputNameModule_ProvidePresenter$app_productionReleaseFactory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, new InputNamePresenter(InputNameModule_ProvideView$app_productionReleaseFactory.PlaceComponentResult(this.MyBillsEntityDataFactory), new UpdateNicknameProfile((UserProfileInfoRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.View$OnClickListener())), new GetUserInfoWithKyc((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (UserRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BannerEntityDataFactory_Factory())), new CheckSkipButtonMerchantList((FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5())))));
        }
    }
}

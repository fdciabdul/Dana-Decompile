package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.danaviz.DanaVizPromptActivity;
import id.dana.danaviz.DanaVizPromptPresenter;
import id.dana.di.modules.DanaVizPromptModule;
import id.dana.di.modules.DanaVizPromptModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.DanaVizPromptModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetPhoneNumber_Factory;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.auth.face.interactor.SwitchFaceAuthentication;
import id.dana.domain.auth.face.repository.FaceAuthenticationRepository;
import id.dana.domain.resetpin.ResetPinRepository;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll_Factory;
import id.dana.domain.resetpin.interactor.SaveDanaVizPromptAfterResetPin;
import id.dana.domain.resetpin.interactor.SaveDanaVizPromptAfterResetPin_Factory;
import id.dana.domain.resetpin.interactor.SaveForceDanaVizPrompt;
import id.dana.domain.resetpin.interactor.SaveForceDanaVizPrompt_Factory;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule_ProvideFaceAuthenticationFactory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerDanaVizPromptComponent {
    private DaggerDanaVizPromptComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public DanaVizPromptModule BuiltInFictitiousFunctionClassFactory;
        public FaceAuthenticationModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class DanaVizPromptComponentImpl implements DanaVizPromptComponent {
        private Provider<FinishForceDanaVizEnroll> BuiltInFictitiousFunctionClassFactory;
        private Provider<ThreadExecutor> GetContactSyncConfig;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private final DanaVizPromptModule MyBillsEntityDataFactory;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final DanaVizPromptComponentImpl PlaceComponentResult;
        private final FaceAuthenticationModule getAuthRequestContext;
        private Provider<SaveDanaVizPromptAfterResetPin> getErrorConfigVersion;
        private Provider<SaveForceDanaVizPrompt> initRecordTimeStamp;
        private Provider<ResetPinRepository> lookAheadTest;
        private Provider<LiteAccountRepository> moveToNextValue;
        private Provider<GetPhoneNumber> scheduleImpl;

        public /* synthetic */ DanaVizPromptComponentImpl(DanaVizPromptModule danaVizPromptModule, FaceAuthenticationModule faceAuthenticationModule, ApplicationComponent applicationComponent, byte b) {
            this(danaVizPromptModule, faceAuthenticationModule, applicationComponent);
        }

        private DanaVizPromptComponentImpl(DanaVizPromptModule danaVizPromptModule, FaceAuthenticationModule faceAuthenticationModule, ApplicationComponent applicationComponent) {
            this.PlaceComponentResult = this;
            this.MyBillsEntityDataFactory = danaVizPromptModule;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.getAuthRequestContext = faceAuthenticationModule;
            ProvideResetPinRepositoryProvider provideResetPinRepositoryProvider = new ProvideResetPinRepositoryProvider(applicationComponent);
            this.lookAheadTest = provideResetPinRepositoryProvider;
            this.initRecordTimeStamp = SaveForceDanaVizPrompt_Factory.create(provideResetPinRepositoryProvider);
            this.BuiltInFictitiousFunctionClassFactory = FinishForceDanaVizEnroll_Factory.create(this.lookAheadTest);
            this.GetContactSyncConfig = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new PostExecutionThreadProvider(applicationComponent);
            LiteAccountRepositoryProvider liteAccountRepositoryProvider = new LiteAccountRepositoryProvider(applicationComponent);
            this.moveToNextValue = liteAccountRepositoryProvider;
            this.scheduleImpl = GetPhoneNumber_Factory.create(this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda0, liteAccountRepositoryProvider);
            this.getErrorConfigVersion = SaveDanaVizPromptAfterResetPin_Factory.create(this.lookAheadTest);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideResetPinRepositoryProvider implements Provider<ResetPinRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideResetPinRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ResetPinRepository get() {
                return (ResetPinRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.getContainerAuth());
            }
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
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class LiteAccountRepositoryProvider implements Provider<LiteAccountRepository> {
            private final ApplicationComponent getAuthRequestContext;

            LiteAccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ LiteAccountRepository get() {
                return (LiteAccountRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.AppCompatEmojiTextHelper());
            }
        }

        @Override // id.dana.di.component.DanaVizPromptComponent
        public final void MyBillsEntityDataFactory(DanaVizPromptActivity danaVizPromptActivity) {
            danaVizPromptActivity.presenter = DanaVizPromptModule_ProvidePresenter$app_productionReleaseFactory.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, new DanaVizPromptPresenter(DanaVizPromptModule_ProvideView$app_productionReleaseFactory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), new SwitchFaceAuthentication((FaceAuthenticationRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.FragmentBottomSheetPaymentSettingBinding())), new GetUserId((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (LiteAccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.AppCompatEmojiTextHelper())), FaceAuthenticationModule_ProvideFaceAuthenticationFactory.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion)));
        }
    }
}

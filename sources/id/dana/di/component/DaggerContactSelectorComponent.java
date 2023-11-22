package id.dana.di.component;

import android.content.ContentResolver;
import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.contact.DanaContactContract;
import id.dana.contract.contact.DanaContactPresenter;
import id.dana.di.modules.DanaContactModule;
import id.dana.di.modules.DanaContactModule_ProvidePresenterFactory;
import id.dana.di.modules.DanaContactModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.contactinjection.ContactInjectionRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckContactSyncFeature;
import id.dana.domain.featureconfig.interactor.CheckContactSyncFeature_Factory;
import id.dana.domain.featureconfig.interactor.GetContactInjectionConfig;
import id.dana.domain.featureconfig.interactor.GetContactInjectionConfig_Factory;
import id.dana.domain.recentcontact.interactor.GetDanaContact;
import id.dana.domain.recentcontact.interactor.GetDanaContact_Factory;
import id.dana.domain.recentcontact.repository.RecentContactRepository;
import id.dana.domain.synccontact.SyncContactRepository;
import id.dana.domain.synccontact.interactor.CheckSyncProcessCompleteState;
import id.dana.domain.synccontact.interactor.CheckSyncProcessCompleteState_Factory;
import id.dana.domain.synccontact.interactor.GetLastSyncedContact;
import id.dana.domain.synccontact.interactor.GetLastSyncedContact_Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent_Factory;
import id.dana.richview.contactselector.ContactSelectorView;
import id.dana.richview.contactselector.ContactSelectorView_MembersInjector;
import id.dana.richview.contactselector.UserContactMapper_Factory;
import id.dana.sendmoney.contact.provider.ContactProvider;
import id.dana.sendmoney.contact.provider.ContactProvider_Factory;
import id.dana.sync_engine.domain.interactor.GetContactsUseCase;
import id.dana.synccontact.SyncContactUtil_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerContactSelectorComponent {
    private DaggerContactSelectorComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public DanaContactModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class ContactSelectorComponentImpl implements ContactSelectorComponent {
        private final ContactSelectorComponentImpl BuiltInFictitiousFunctionClassFactory;
        private Provider<ContactInjectionRepository> DatabaseTableConfigUtil;
        private Provider<PostExecutionThread> GetContactSyncConfig;
        private Provider<CheckSyncProcessCompleteState> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<ContactProvider> MyBillsEntityDataFactory;
        private Provider<ContentResolver> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetContactsUseCase> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<FeedsShareRepository> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<RecentContactRepository> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<SyncContactRepository> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<CheckContactSyncFeature> PlaceComponentResult;
        private Provider<SaveShareFeedConsent> PrepareContext;
        private final ApplicationComponent getAuthRequestContext;
        private final DanaContactModule getErrorConfigVersion;
        private Provider<GetLastSyncedContact> initRecordTimeStamp;
        private Provider<ThreadExecutor> isLayoutRequested;
        private Provider<FeatureConfigRepository> lookAheadTest;
        private Provider<GetDanaContact> moveToNextValue;
        private Provider<DanaContactContract.View> newProxyInstance;
        private Provider<GetContactInjectionConfig> scheduleImpl;

        public /* synthetic */ ContactSelectorComponentImpl(DanaContactModule danaContactModule, ApplicationComponent applicationComponent, byte b) {
            this(danaContactModule, applicationComponent);
        }

        private ContactSelectorComponentImpl(DanaContactModule danaContactModule, ApplicationComponent applicationComponent) {
            this.BuiltInFictitiousFunctionClassFactory = this;
            this.getErrorConfigVersion = danaContactModule;
            this.getAuthRequestContext = applicationComponent;
            this.newProxyInstance = DanaContactModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(danaContactModule);
            this.isLayoutRequested = new ThreadExecutorProvider(applicationComponent);
            this.GetContactSyncConfig = new PostExecutionThreadProvider(applicationComponent);
            RecentContactRepositoryProvider recentContactRepositoryProvider = new RecentContactRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = recentContactRepositoryProvider;
            this.moveToNextValue = GetDanaContact_Factory.create(this.isLayoutRequested, this.GetContactSyncConfig, recentContactRepositoryProvider);
            SyncContactRepositoryProvider syncContactRepositoryProvider = new SyncContactRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = syncContactRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = CheckSyncProcessCompleteState_Factory.create(this.isLayoutRequested, this.GetContactSyncConfig, syncContactRepositoryProvider);
            this.initRecordTimeStamp = GetLastSyncedContact_Factory.create(this.isLayoutRequested, this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.lookAheadTest = featureConfigRepositoryProvider;
            this.PlaceComponentResult = CheckContactSyncFeature_Factory.create(this.isLayoutRequested, this.GetContactSyncConfig, featureConfigRepositoryProvider);
            ProvideFeedsShareRepositoryProvider provideFeedsShareRepositoryProvider = new ProvideFeedsShareRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provideFeedsShareRepositoryProvider;
            this.PrepareContext = SaveShareFeedConsent_Factory.MyBillsEntityDataFactory(provideFeedsShareRepositoryProvider);
            ContentResolverProvider contentResolverProvider = new ContentResolverProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = contentResolverProvider;
            this.MyBillsEntityDataFactory = ContactProvider_Factory.PlaceComponentResult(contentResolverProvider);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ProvideGetContactsUseCaseProvider(applicationComponent);
            ProvideContactInjectionRepositoryProvider provideContactInjectionRepositoryProvider = new ProvideContactInjectionRepositoryProvider(applicationComponent);
            this.DatabaseTableConfigUtil = provideContactInjectionRepositoryProvider;
            this.scheduleImpl = GetContactInjectionConfig_Factory.create(this.lookAheadTest, provideContactInjectionRepositoryProvider);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature());
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
        public static final class RecentContactRepositoryProvider implements Provider<RecentContactRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            RecentContactRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RecentContactRepository get() {
                return (RecentContactRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.ReferralMapper_Factory());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SyncContactRepositoryProvider implements Provider<SyncContactRepository> {
            private final ApplicationComponent PlaceComponentResult;

            SyncContactRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SyncContactRepository get() {
                return (SyncContactRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.containsObjectForKey());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideFeedsShareRepositoryProvider implements Provider<FeedsShareRepository> {
            private final ApplicationComponent getAuthRequestContext;

            ProvideFeedsShareRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsShareRepository get() {
                return (FeedsShareRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ContentResolverProvider implements Provider<ContentResolver> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ContentResolverProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContentResolver get() {
                return (ContentResolver) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideGetContactsUseCaseProvider implements Provider<GetContactsUseCase> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideGetContactsUseCaseProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ GetContactsUseCase get() {
                return (GetContactsUseCase) Preconditions.PlaceComponentResult(this.PlaceComponentResult.p());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ProvideContactInjectionRepositoryProvider implements Provider<ContactInjectionRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            ProvideContactInjectionRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ContactInjectionRepository get() {
                return (ContactInjectionRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.h());
            }
        }

        @Override // id.dana.di.component.ContactSelectorComponent
        public final void BuiltInFictitiousFunctionClassFactory(ContactSelectorView contactSelectorView) {
            ContactSelectorView_MembersInjector.MyBillsEntityDataFactory(contactSelectorView, DanaContactModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, new DanaContactPresenter((Context) Preconditions.PlaceComponentResult(this.getAuthRequestContext.moveToNextValue()), DoubleCheck.MyBillsEntityDataFactory(this.newProxyInstance), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(SyncContactUtil_Factory.BuiltInFictitiousFunctionClassFactory()), DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), DoubleCheck.MyBillsEntityDataFactory(UserContactMapper_Factory.MyBillsEntityDataFactory()), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl))));
        }
    }
}

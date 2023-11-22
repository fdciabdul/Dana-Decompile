package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.appshortcut.DanaAppShortcut;
import id.dana.appshortcut.DanaAppShortcutContract;
import id.dana.appshortcut.DanaAppShortcutPresenter;
import id.dana.appshortcut.DanaAppShortcutPresenter_Factory;
import id.dana.appshortcut.DanaAppShortcut_MembersInjector;
import id.dana.di.modules.DanaAppShortcutModule;
import id.dana.di.modules.DanaAppShortcutModule_ProvidePresenter$app_productionReleaseFactory;
import id.dana.di.modules.DanaAppShortcutModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.appshortcut.interactor.GetAppShortcutConfig;
import id.dana.domain.appshortcut.interactor.GetAppShortcutConfig_Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerDanaAppShortcutComponent {
    private DaggerDanaAppShortcutComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent MyBillsEntityDataFactory;
        public DanaAppShortcutModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class DanaAppShortcutComponentImpl implements DanaAppShortcutComponent {
        private Provider<DanaAppShortcutContract.Presenter> BuiltInFictitiousFunctionClassFactory;
        private final DanaAppShortcutComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private Provider<GetAppShortcutConfig> PlaceComponentResult;
        private Provider<DanaAppShortcutPresenter> getAuthRequestContext;
        private Provider<DanaAppShortcutContract.View> lookAheadTest;

        public /* synthetic */ DanaAppShortcutComponentImpl(DanaAppShortcutModule danaAppShortcutModule, ApplicationComponent applicationComponent, byte b) {
            this(danaAppShortcutModule, applicationComponent);
        }

        private DanaAppShortcutComponentImpl(DanaAppShortcutModule danaAppShortcutModule, ApplicationComponent applicationComponent) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(DanaAppShortcutModule_ProvideView$app_productionReleaseFactory.getAuthRequestContext(danaAppShortcutModule));
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            GetAppShortcutConfig_Factory create = GetAppShortcutConfig_Factory.create(featureConfigRepositoryProvider);
            this.PlaceComponentResult = create;
            DanaAppShortcutPresenter_Factory MyBillsEntityDataFactory = DanaAppShortcutPresenter_Factory.MyBillsEntityDataFactory(this.lookAheadTest, create);
            this.getAuthRequestContext = MyBillsEntityDataFactory;
            this.BuiltInFictitiousFunctionClassFactory = DoubleCheck.getAuthRequestContext(DanaAppShortcutModule_ProvidePresenter$app_productionReleaseFactory.getAuthRequestContext(danaAppShortcutModule, MyBillsEntityDataFactory));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent PlaceComponentResult;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        @Override // id.dana.di.component.DanaAppShortcutComponent
        public final void BuiltInFictitiousFunctionClassFactory(DanaAppShortcut danaAppShortcut) {
            DanaAppShortcut_MembersInjector.getAuthRequestContext(danaAppShortcut, this.BuiltInFictitiousFunctionClassFactory.get());
        }
    }
}

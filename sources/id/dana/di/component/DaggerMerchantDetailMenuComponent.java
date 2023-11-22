package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.H5Launcher;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.modules.MerchantDetailConfigModule;
import id.dana.di.modules.MerchantDetailConfigModule_ProvidesPresenterFactory;
import id.dana.di.modules.MerchantDetailConfigModule_ProvidesViewFactory;
import id.dana.di.modules.MerchantDetailMenuModule;
import id.dana.di.modules.MerchantDetailMenuModule_ProvideH5LauncherFactory;
import id.dana.domain.nearbyme.MerchantConfigRepository;
import id.dana.domain.nearbyme.interactor.GetMerchantDetailActionConfig;
import id.dana.domain.nearbyme.interactor.GetMerchantDetailActionConfig_Factory;
import id.dana.domain.nearbyme.interactor.GetMerchantDetailPromoConfig;
import id.dana.domain.nearbyme.interactor.GetMerchantDetailPromoConfig_Factory;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigPresenter;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigPresenter_Factory;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailMenuView;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailMenuView_MembersInjector;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerMerchantDetailMenuComponent {
    private DaggerMerchantDetailMenuComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public MerchantDetailConfigModule KClassImpl$Data$declaredNonStaticMembers$2;
        public MerchantDetailMenuModule PlaceComponentResult;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MerchantDetailMenuComponentImpl implements MerchantDetailMenuComponent {
        private Provider<MerchantConfigRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<MerchantDetailConfigPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetMerchantDetailActionConfig> MyBillsEntityDataFactory;
        private Provider<MerchantDetailConfigContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetMerchantDetailPromoConfig> PlaceComponentResult;
        private Provider<DynamicUrlWrapper> getAuthRequestContext;
        private final MerchantDetailMenuComponentImpl getErrorConfigVersion;
        private Provider<H5Launcher> moveToNextValue;
        private Provider<MerchantDetailConfigContract.Presenter> scheduleImpl;

        public /* synthetic */ MerchantDetailMenuComponentImpl(MerchantDetailConfigModule merchantDetailConfigModule, MerchantDetailMenuModule merchantDetailMenuModule, ApplicationComponent applicationComponent, byte b) {
            this(merchantDetailConfigModule, merchantDetailMenuModule, applicationComponent);
        }

        private MerchantDetailMenuComponentImpl(MerchantDetailConfigModule merchantDetailConfigModule, MerchantDetailMenuModule merchantDetailMenuModule, ApplicationComponent applicationComponent) {
            this.getErrorConfigVersion = this;
            DynamicUrlWrapperProvider dynamicUrlWrapperProvider = new DynamicUrlWrapperProvider(applicationComponent);
            this.getAuthRequestContext = dynamicUrlWrapperProvider;
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(MerchantDetailMenuModule_ProvideH5LauncherFactory.BuiltInFictitiousFunctionClassFactory(merchantDetailMenuModule, dynamicUrlWrapperProvider));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = DoubleCheck.getAuthRequestContext(MerchantDetailConfigModule_ProvidesViewFactory.PlaceComponentResult(merchantDetailConfigModule));
            MerchantConfigRepositoryProvider merchantConfigRepositoryProvider = new MerchantConfigRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = merchantConfigRepositoryProvider;
            this.MyBillsEntityDataFactory = GetMerchantDetailActionConfig_Factory.create(merchantConfigRepositoryProvider);
            GetMerchantDetailPromoConfig_Factory create = GetMerchantDetailPromoConfig_Factory.create(this.BuiltInFictitiousFunctionClassFactory);
            this.PlaceComponentResult = create;
            Provider<MerchantDetailConfigPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(MerchantDetailConfigPresenter_Factory.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.MyBillsEntityDataFactory, create));
            this.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
            this.scheduleImpl = DoubleCheck.getAuthRequestContext(MerchantDetailConfigModule_ProvidesPresenterFactory.MyBillsEntityDataFactory(merchantDetailConfigModule, authRequestContext));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class DynamicUrlWrapperProvider implements Provider<DynamicUrlWrapper> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            DynamicUrlWrapperProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DynamicUrlWrapper get() {
                return (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.PrepareContext());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class MerchantConfigRepositoryProvider implements Provider<MerchantConfigRepository> {
            private final ApplicationComponent getAuthRequestContext;

            MerchantConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantConfigRepository get() {
                return (MerchantConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.getNameOrBuilderList());
            }
        }

        @Override // id.dana.di.component.MerchantDetailMenuComponent
        public final void MyBillsEntityDataFactory(MerchantDetailMenuView merchantDetailMenuView) {
            MerchantDetailMenuView_MembersInjector.getAuthRequestContext(merchantDetailMenuView, this.moveToNextValue.get());
            MerchantDetailMenuView_MembersInjector.BuiltInFictitiousFunctionClassFactory(merchantDetailMenuView, this.scheduleImpl.get());
        }
    }
}

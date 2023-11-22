package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.SwitchAutoRouteModule;
import id.dana.di.modules.SwitchAutoRouteModule_ProvideView$app_productionReleaseFactory;
import id.dana.domain.autoroute.interactor.IsHavingAutoRouteAsset;
import id.dana.domain.autoroute.interactor.IsHavingAutoRouteAsset_Factory;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting_Factory;
import id.dana.domain.autoroute.repository.AutoRouteRepository;
import id.dana.myprofile.mepagerevamp.smartpay.view.NewSwitchAutoRouteView;
import id.dana.myprofile.mepagerevamp.smartpay.view.NewSwitchAutoRouteView_MembersInjector;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteAnalyticsTracker;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteAnalyticsTracker_Factory;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract;
import id.dana.richview.profile.switchautoroute.SwitchAutoRoutePresenter;
import id.dana.richview.profile.switchautoroute.SwitchAutoRoutePresenter_Factory;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteView;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteView_MembersInjector;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerSwitchAutoRouteComponent {
    private DaggerSwitchAutoRouteComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public SwitchAutoRouteModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final SwitchAutoRouteComponent BuiltInFictitiousFunctionClassFactory() {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, SwitchAutoRouteModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, ApplicationComponent.class);
            return new SwitchAutoRouteComponentImpl(this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class SwitchAutoRouteComponentImpl implements SwitchAutoRouteComponent {
        private Provider<AutoRouteRepository> BuiltInFictitiousFunctionClassFactory;
        private Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<SwitchAutoRouteContract.View> MyBillsEntityDataFactory;
        private Provider<IsHavingAutoRouteAsset> PlaceComponentResult;
        private Provider<SwitchAutoRouteAnalyticsTracker> getAuthRequestContext;
        private Provider<SwitchAutoRouting> getErrorConfigVersion;
        private final SwitchAutoRouteComponentImpl lookAheadTest;
        private Provider<SwitchAutoRoutePresenter> moveToNextValue;

        /* synthetic */ SwitchAutoRouteComponentImpl(SwitchAutoRouteModule switchAutoRouteModule, ApplicationComponent applicationComponent, byte b) {
            this(switchAutoRouteModule, applicationComponent);
        }

        private SwitchAutoRouteComponentImpl(SwitchAutoRouteModule switchAutoRouteModule, ApplicationComponent applicationComponent) {
            this.lookAheadTest = this;
            this.MyBillsEntityDataFactory = SwitchAutoRouteModule_ProvideView$app_productionReleaseFactory.MyBillsEntityDataFactory(switchAutoRouteModule);
            AutoRouteRepositoryProvider autoRouteRepositoryProvider = new AutoRouteRepositoryProvider(applicationComponent);
            this.BuiltInFictitiousFunctionClassFactory = autoRouteRepositoryProvider;
            this.getErrorConfigVersion = SwitchAutoRouting_Factory.create(autoRouteRepositoryProvider);
            IsHavingAutoRouteAsset_Factory create = IsHavingAutoRouteAsset_Factory.create(this.BuiltInFictitiousFunctionClassFactory);
            this.PlaceComponentResult = create;
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(SwitchAutoRoutePresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, this.getErrorConfigVersion, create));
            ContextProvider contextProvider = new ContextProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = contextProvider;
            this.getAuthRequestContext = DoubleCheck.getAuthRequestContext(SwitchAutoRouteAnalyticsTracker_Factory.getAuthRequestContext(contextProvider));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class AutoRouteRepositoryProvider implements Provider<AutoRouteRepository> {
            private final ApplicationComponent getAuthRequestContext;

            AutoRouteRepositoryProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AutoRouteRepository get() {
                return (AutoRouteRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.scheduleImpl());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        @Override // id.dana.di.component.SwitchAutoRouteComponent
        public final void MyBillsEntityDataFactory(NewSwitchAutoRouteView newSwitchAutoRouteView) {
            newSwitchAutoRouteView.switchAutoRoutePresenter = this.moveToNextValue.get();
            NewSwitchAutoRouteView_MembersInjector.MyBillsEntityDataFactory(newSwitchAutoRouteView, this.getAuthRequestContext.get());
        }

        @Override // id.dana.di.component.SwitchAutoRouteComponent
        public final void MyBillsEntityDataFactory(SwitchAutoRouteView switchAutoRouteView) {
            switchAutoRouteView.switchAutoRoutePresenter = this.moveToNextValue.get();
            SwitchAutoRouteView_MembersInjector.MyBillsEntityDataFactory(switchAutoRouteView, this.getAuthRequestContext.get());
        }
    }
}

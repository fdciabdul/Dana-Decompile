package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.DeviceLimitErrorModule;
import id.dana.di.modules.DeviceLimitErrorModule_ProvideViewFactory;
import id.dana.di.modules.DeviceLimitErrorModule_ProvidesPresenterFactory;
import id.dana.domain.registration.RegistrationRepository;
import id.dana.domain.registration.interactor.GetHelpButtonOtpLimitDevice;
import id.dana.domain.registration.interactor.GetHelpButtonOtpLimitDevice_Factory;
import id.dana.onboarding.verify.devicelimit.DeviceLimitErrorContract;
import id.dana.onboarding.verify.devicelimit.DeviceLimitErrorFragment;
import id.dana.onboarding.verify.devicelimit.DeviceLimitErrorFragment_MembersInjector;
import id.dana.onboarding.verify.devicelimit.DeviceLimitErrorPresenter;
import id.dana.onboarding.verify.devicelimit.DeviceLimitErrorPresenter_Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerDeviceLimitErrorComponent {
    private DaggerDeviceLimitErrorComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public DeviceLimitErrorModule MyBillsEntityDataFactory;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class DeviceLimitErrorComponentImpl implements DeviceLimitErrorComponent {
        private Provider<DeviceLimitErrorPresenter> BuiltInFictitiousFunctionClassFactory;
        private final DeviceLimitErrorComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<DeviceLimitErrorContract.Presenter> MyBillsEntityDataFactory;
        private Provider<DeviceLimitErrorContract.View> PlaceComponentResult;
        private Provider<GetHelpButtonOtpLimitDevice> getAuthRequestContext;
        private Provider<RegistrationRepository> getErrorConfigVersion;

        public /* synthetic */ DeviceLimitErrorComponentImpl(DeviceLimitErrorModule deviceLimitErrorModule, ApplicationComponent applicationComponent, byte b) {
            this(deviceLimitErrorModule, applicationComponent);
        }

        private DeviceLimitErrorComponentImpl(DeviceLimitErrorModule deviceLimitErrorModule, ApplicationComponent applicationComponent) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            RegistrationRepositoryProvider registrationRepositoryProvider = new RegistrationRepositoryProvider(applicationComponent);
            this.getErrorConfigVersion = registrationRepositoryProvider;
            this.getAuthRequestContext = GetHelpButtonOtpLimitDevice_Factory.create(registrationRepositoryProvider);
            Provider<DeviceLimitErrorContract.View> authRequestContext = DoubleCheck.getAuthRequestContext(DeviceLimitErrorModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(deviceLimitErrorModule));
            this.PlaceComponentResult = authRequestContext;
            DeviceLimitErrorPresenter_Factory BuiltInFictitiousFunctionClassFactory = DeviceLimitErrorPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, authRequestContext);
            this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
            this.MyBillsEntityDataFactory = DoubleCheck.getAuthRequestContext(DeviceLimitErrorModule_ProvidesPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(deviceLimitErrorModule, BuiltInFictitiousFunctionClassFactory));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class RegistrationRepositoryProvider implements Provider<RegistrationRepository> {
            private final ApplicationComponent PlaceComponentResult;

            RegistrationRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ RegistrationRepository get() {
                return (RegistrationRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.rotateTo());
            }
        }

        @Override // id.dana.di.component.DeviceLimitErrorComponent
        public final void getAuthRequestContext(DeviceLimitErrorFragment deviceLimitErrorFragment) {
            DeviceLimitErrorFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(deviceLimitErrorFragment, DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
        }
    }
}

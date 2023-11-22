package id.dana.sendmoney_v2.x2l.di;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.sendmoney.x2l.interactor.GetSendToLinkBannerConfig;
import id.dana.domain.sendmoney.x2l.interactor.GetSendToLinkBannerConfig_Factory;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkBannerContract;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkBannerPresenter;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkBannerPresenter_Factory;
import id.dana.sendmoney_v2.x2l.view.SendToLinkBannerView;
import id.dana.sendmoney_v2.x2l.view.SendToLinkBannerView_MembersInjector;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerSendToLinkBannerComponent {
    private DaggerSendToLinkBannerComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public ApplicationComponent PlaceComponentResult;
        public SendToLinkBannerModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class SendToLinkBannerComponentImpl implements SendToLinkBannerComponent {
        private Provider<SendToLinkBannerContract.View> BuiltInFictitiousFunctionClassFactory;
        private final SendToLinkBannerComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private Provider<GetSendToLinkBannerConfig> PlaceComponentResult;
        private Provider<SendToLinkBannerContract.Presenter> getAuthRequestContext;
        private Provider<SendToLinkBannerPresenter> getErrorConfigVersion;

        public /* synthetic */ SendToLinkBannerComponentImpl(SendToLinkBannerModule sendToLinkBannerModule, ApplicationComponent applicationComponent, byte b) {
            this(sendToLinkBannerModule, applicationComponent);
        }

        private SendToLinkBannerComponentImpl(SendToLinkBannerModule sendToLinkBannerModule, ApplicationComponent applicationComponent) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.BuiltInFictitiousFunctionClassFactory = DoubleCheck.getAuthRequestContext(SendToLinkBannerModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(sendToLinkBannerModule));
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            GetSendToLinkBannerConfig_Factory create = GetSendToLinkBannerConfig_Factory.create(featureConfigRepositoryProvider);
            this.PlaceComponentResult = create;
            SendToLinkBannerPresenter_Factory authRequestContext = SendToLinkBannerPresenter_Factory.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, create);
            this.getErrorConfigVersion = authRequestContext;
            this.getAuthRequestContext = DoubleCheck.getAuthRequestContext(SendToLinkBannerModule_ProvidePresenterFactory.getAuthRequestContext(sendToLinkBannerModule, authRequestContext));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
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

        @Override // id.dana.sendmoney_v2.x2l.di.SendToLinkBannerComponent
        public final void BuiltInFictitiousFunctionClassFactory(SendToLinkBannerView sendToLinkBannerView) {
            SendToLinkBannerView_MembersInjector.BuiltInFictitiousFunctionClassFactory(sendToLinkBannerView, this.getAuthRequestContext.get());
        }
    }
}

package id.dana.sendmoney_v2.x2l.di;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.sendmoney.x2l.interactor.GetSocialLinks;
import id.dana.domain.sendmoney.x2l.interactor.GetSocialLinks_Factory;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkSelectorContract;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkSelectorPresenter;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkSelectorPresenter_Factory;
import id.dana.sendmoney_v2.x2l.view.SendToLinkSelectorView;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerSendToLinkSelectorComponent {
    private DaggerSendToLinkSelectorComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public SendToLinkSelectorModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class SendToLinkSelectorComponentImpl implements SendToLinkSelectorComponent {
        private Provider<SendToLinkSelectorContract.Presenter> BuiltInFictitiousFunctionClassFactory;
        private Provider<SendToLinkSelectorContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeatureConfigRepository> MyBillsEntityDataFactory;
        private final SendToLinkSelectorComponentImpl PlaceComponentResult;
        private Provider<GetSocialLinks> getAuthRequestContext;
        private Provider<SendToLinkSelectorPresenter> scheduleImpl;

        public /* synthetic */ SendToLinkSelectorComponentImpl(SendToLinkSelectorModule sendToLinkSelectorModule, ApplicationComponent applicationComponent, byte b) {
            this(sendToLinkSelectorModule, applicationComponent);
        }

        private SendToLinkSelectorComponentImpl(SendToLinkSelectorModule sendToLinkSelectorModule, ApplicationComponent applicationComponent) {
            this.PlaceComponentResult = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = DoubleCheck.getAuthRequestContext(SendToLinkSelectorModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(sendToLinkSelectorModule));
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = featureConfigRepositoryProvider;
            GetSocialLinks_Factory create = GetSocialLinks_Factory.create(featureConfigRepositoryProvider);
            this.getAuthRequestContext = create;
            SendToLinkSelectorPresenter_Factory MyBillsEntityDataFactory = SendToLinkSelectorPresenter_Factory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, create);
            this.scheduleImpl = MyBillsEntityDataFactory;
            this.BuiltInFictitiousFunctionClassFactory = DoubleCheck.getAuthRequestContext(SendToLinkSelectorModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(sendToLinkSelectorModule, MyBillsEntityDataFactory));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        @Override // id.dana.sendmoney_v2.x2l.di.SendToLinkSelectorComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(SendToLinkSelectorView sendToLinkSelectorView) {
            sendToLinkSelectorView.sendToLinkSelectorPresenter = this.BuiltInFictitiousFunctionClassFactory.get();
        }
    }
}

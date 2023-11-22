package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.PayMethodContract;
import id.dana.contract.sendmoney.PayMethodPresenter;
import id.dana.contract.sendmoney.PayMethodPresenter_Factory;
import id.dana.di.modules.PayMethodModule;
import id.dana.di.modules.PayMethodModule_ProvidePresenterFactory;
import id.dana.di.modules.PayMethodModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.card.interactor.GetDefaultCard;
import id.dana.domain.card.interactor.GetDefaultCard_Factory;
import id.dana.domain.card.repository.CardRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature_Factory;
import id.dana.domain.sendmoney.interactor.GetSendMoneyOption;
import id.dana.domain.sendmoney.interactor.GetSendMoneyOption_Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.sendmoney.mapper.ContactPayMethodMapper_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.sendmoney.mapper.TransferMethodMapper;
import id.dana.sendmoney.mapper.TransferMethodMapper_Factory;
import id.dana.sendmoney.mapper.WithdrawChannelModelMapper_Factory;
import id.dana.sendmoney.mapper.WithdrawMethodOptionModelMapper;
import id.dana.sendmoney.mapper.WithdrawMethodOptionModelMapper_Factory;
import id.dana.sendmoney.mapper.WithdrawSavedCardChannelModelMapper_Factory;
import id.dana.sendmoney.paymethod.PayMethodAdapter_Factory;
import id.dana.sendmoney_v2.paymethod.PayMethodView;
import id.dana.sendmoney_v2.paymethod.PayMethodView_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerPayMethodComponent {
    private DaggerPayMethodComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent MyBillsEntityDataFactory;
        public PayMethodModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class PayMethodComponentImpl implements PayMethodComponent {
        private Provider<GetSendMoneyOption> BuiltInFictitiousFunctionClassFactory;
        private Provider<ThreadExecutor> DatabaseTableConfigUtil;
        private Provider<FeatureConfigRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<CardRepository> MyBillsEntityDataFactory;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<WithdrawMethodOptionModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<TransferMethodMapper> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<CheckTransferX2PFeature> PlaceComponentResult;
        private Provider<GetDefaultCard> getAuthRequestContext;
        private Provider<PayMethodPresenter> getErrorConfigVersion;
        private Provider<SendMoneyRepository> initRecordTimeStamp;
        private final PayMethodComponentImpl lookAheadTest;
        private Provider<PayMethodContract.View> moveToNextValue;
        private final PayMethodModule scheduleImpl;

        public /* synthetic */ PayMethodComponentImpl(PayMethodModule payMethodModule, ApplicationComponent applicationComponent, byte b) {
            this(payMethodModule, applicationComponent);
        }

        private PayMethodComponentImpl(PayMethodModule payMethodModule, ApplicationComponent applicationComponent) {
            this.lookAheadTest = this;
            this.scheduleImpl = payMethodModule;
            CardRepositoryProvider cardRepositoryProvider = new CardRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = cardRepositoryProvider;
            this.getAuthRequestContext = GetDefaultCard_Factory.create(cardRepositoryProvider);
            this.moveToNextValue = PayMethodModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(payMethodModule);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = WithdrawMethodOptionModelMapper_Factory.getAuthRequestContext(WithdrawSavedCardChannelModelMapper_Factory.MyBillsEntityDataFactory(), WithdrawChannelModelMapper_Factory.PlaceComponentResult());
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = TransferMethodMapper_Factory.MyBillsEntityDataFactory(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.DatabaseTableConfigUtil = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new PostExecutionThreadProvider(applicationComponent);
            SendMoneyRepositoryProvider sendMoneyRepositoryProvider = new SendMoneyRepositoryProvider(applicationComponent);
            this.initRecordTimeStamp = sendMoneyRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = GetSendMoneyOption_Factory.create(this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda0, sendMoneyRepositoryProvider);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = featureConfigRepositoryProvider;
            this.PlaceComponentResult = CheckTransferX2PFeature_Factory.create(this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda0, featureConfigRepositoryProvider);
            this.getErrorConfigVersion = DoubleCheck.getAuthRequestContext(PayMethodPresenter_Factory.BuiltInFictitiousFunctionClassFactory(ContactPayMethodMapper_Factory.BuiltInFictitiousFunctionClassFactory(), this.getAuthRequestContext, this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class CardRepositoryProvider implements Provider<CardRepository> {
            private final ApplicationComponent PlaceComponentResult;

            CardRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CardRepository get() {
                return (CardRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.getErrorConfigVersion());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class ThreadExecutorProvider implements Provider<ThreadExecutor> {
            private final ApplicationComponent PlaceComponentResult;

            ThreadExecutorProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ ThreadExecutor get() {
                return (ThreadExecutor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.CheckPromoQuestFeature());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class PostExecutionThreadProvider implements Provider<PostExecutionThread> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PostExecutionThreadProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PostExecutionThread get() {
                return (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class SendMoneyRepositoryProvider implements Provider<SendMoneyRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            SendMoneyRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ SendMoneyRepository get() {
                return (SendMoneyRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BaseSocialFeedContract$Presenter());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
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

        @Override // id.dana.di.component.PayMethodComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(PayMethodView payMethodView) {
            PayMethodView_MembersInjector.PlaceComponentResult(payMethodView, PayMethodModule_ProvidePresenterFactory.getAuthRequestContext(this.scheduleImpl, this.getErrorConfigVersion.get()));
            PayMethodView_MembersInjector.BuiltInFictitiousFunctionClassFactory(payMethodView, PayMethodAdapter_Factory.BuiltInFictitiousFunctionClassFactory());
        }
    }
}

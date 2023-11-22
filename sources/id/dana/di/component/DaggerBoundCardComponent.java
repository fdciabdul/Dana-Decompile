package id.dana.di.component;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.cardbinding.domain.CardBindingRepository;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled;
import id.dana.contract.boundcard.BoundCardModule;
import id.dana.contract.boundcard.BoundCardModule_ProvidePresenterFactory;
import id.dana.contract.boundcard.BoundCardModule_ProvideViewFactory;
import id.dana.contract.boundcard.BoundCardPresenter;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.contract.payasset.QueryPayMethodModule;
import id.dana.contract.payasset.QueryPayMethodModule_ProvidePresenterFactory;
import id.dana.contract.payasset.QueryPayMethodModule_ProvideViewFactory;
import id.dana.contract.payasset.QueryPayMethodPresenter;
import id.dana.contract.payasset.QueryPayMethodPresenter_Factory;
import id.dana.contract.user.GetUserInfoContract;
import id.dana.contract.user.GetUserInfoModule;
import id.dana.contract.user.GetUserInfoModule_ProvidePresenterFactory;
import id.dana.contract.user.GetUserInfoModule_ProvideViewFactory;
import id.dana.contract.user.GetUserInfoPresenter;
import id.dana.contract.user.GetUserInfoPresenter_Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.card.interactor.GetDefaultCard;
import id.dana.domain.card.interactor.SaveLastCardUsed;
import id.dana.domain.card.repository.CardRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckEnableExpressPayFeature;
import id.dana.domain.featureconfig.interactor.GetPayCardConfig;
import id.dana.domain.featureconfig.interactor.GetPayCardConfig_Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay_Factory;
import id.dana.domain.payasset.interactor.GetEnableAddNewCard;
import id.dana.domain.payasset.interactor.GetEnableAddNewCard_Factory;
import id.dana.domain.payasset.interactor.QueryPayMethod;
import id.dana.domain.payasset.interactor.QueryPayMethod_Factory;
import id.dana.domain.payasset.repository.PayAssetRepository;
import id.dana.domain.qrpay.QrPayRepository;
import id.dana.domain.qrpay.interactor.InitOfflinePay;
import id.dana.domain.qrpay.interactor.InitOfflinePay_Factory;
import id.dana.domain.qrpay.interactor.IsOfflinePayInitialized;
import id.dana.domain.qrpay.interactor.IsOfflinePayInitialized_Factory;
import id.dana.domain.qrpay.interactor.StopOfflinePay;
import id.dana.domain.qrpay.interactor.StopOfflinePay_Factory;
import id.dana.domain.sendmoney.interactor.GetSendMoneyOption;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.domain.user.interactor.GetUserInfo_Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.myprofile.UserInfoMapper;
import id.dana.myprofile.UserInfoMapper_Factory;
import id.dana.pay.PayCardInfoMapper_Factory;
import id.dana.richview.boundcard.BoundCardView;
import id.dana.richview.boundcard.BoundCardView_MembersInjector;
import id.dana.richview.boundcard.mapper.BoundCardMapper_Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper_Factory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerBoundCardComponent {
    private DaggerBoundCardComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public BoundCardModule BuiltInFictitiousFunctionClassFactory;
        public QueryPayMethodModule MyBillsEntityDataFactory;
        public ApplicationComponent PlaceComponentResult;
        public GetUserInfoModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class BoundCardComponentImpl implements BoundCardComponent {
        private final BoundCardModule BuiltInFictitiousFunctionClassFactory;
        private Provider<IsOfflineF2FPay> DatabaseTableConfigUtil;
        private Provider<QueryPayMethod> FragmentBottomSheetPaymentSettingBinding;
        private Provider<PayAssetRepository> GetContactSyncConfig;
        private Provider<DeviceInformationProvider> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<FeatureConfigRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<IsOfflinePayInitialized> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Provider<PostExecutionThread> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Provider<StopOfflinePay> NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Provider<ThreadExecutor> NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Provider<UserInfoMapper> NetworkUserEntityData$$ExternalSyntheticLambda5;
        private Provider<QueryPayMethodPresenter> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Provider<GetUserInfoContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda7;
        private Provider<QrPayRepository> NetworkUserEntityData$$ExternalSyntheticLambda8;
        private Provider<Context> PlaceComponentResult;
        private Provider<QueryPayMethodContract.View> PrepareContext;
        private final BoundCardComponentImpl getAuthRequestContext;
        private Provider<GetUserInfo> getErrorConfigVersion;
        private Provider<InitOfflinePay> initRecordTimeStamp;
        private Provider<GetUserInfoContract.View> isLayoutRequested;
        private Provider<GetEnableAddNewCard> lookAheadTest;
        private Provider<GetUserInfoPresenter> moveToNextValue;
        private Provider<QueryPayMethodContract.Presenter> newProxyInstance;
        private Provider<UserRepository> readMicros;
        private Provider<GetPayCardConfig> scheduleImpl;

        public /* synthetic */ BoundCardComponentImpl(BoundCardModule boundCardModule, QueryPayMethodModule queryPayMethodModule, GetUserInfoModule getUserInfoModule, ApplicationComponent applicationComponent, byte b) {
            this(boundCardModule, queryPayMethodModule, getUserInfoModule, applicationComponent);
        }

        private BoundCardComponentImpl(BoundCardModule boundCardModule, QueryPayMethodModule queryPayMethodModule, GetUserInfoModule getUserInfoModule, ApplicationComponent applicationComponent) {
            PayCardInfoMapper_Factory payCardInfoMapper_Factory;
            this.getAuthRequestContext = this;
            this.BuiltInFictitiousFunctionClassFactory = boundCardModule;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.PrepareContext = DoubleCheck.getAuthRequestContext(QueryPayMethodModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(queryPayMethodModule));
            PayAssetRepositoryProvider payAssetRepositoryProvider = new PayAssetRepositoryProvider(applicationComponent);
            this.GetContactSyncConfig = payAssetRepositoryProvider;
            this.lookAheadTest = GetEnableAddNewCard_Factory.create(payAssetRepositoryProvider);
            this.FragmentBottomSheetPaymentSettingBinding = QueryPayMethod_Factory.create(this.GetContactSyncConfig);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new ThreadExecutorProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new PostExecutionThreadProvider(applicationComponent);
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = featureConfigRepositoryProvider;
            this.DatabaseTableConfigUtil = IsOfflineF2FPay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.NetworkUserEntityData$$ExternalSyntheticLambda2, featureConfigRepositoryProvider);
            QrPayRepositoryProvider qrPayRepositoryProvider = new QrPayRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = qrPayRepositoryProvider;
            this.initRecordTimeStamp = InitOfflinePay_Factory.create(qrPayRepositoryProvider);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new DeviceInformationProviderProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = StopOfflinePay_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = IsOfflinePayInitialized_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            this.PlaceComponentResult = new ContextProvider(applicationComponent);
            this.scheduleImpl = GetPayCardConfig_Factory.create(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.GetContactSyncConfig);
            Provider<QueryPayMethodContract.View> provider = this.PrepareContext;
            Provider<GetEnableAddNewCard> provider2 = this.lookAheadTest;
            Provider<QueryPayMethod> provider3 = this.FragmentBottomSheetPaymentSettingBinding;
            payCardInfoMapper_Factory = PayCardInfoMapper_Factory.InstanceHolder.BuiltInFictitiousFunctionClassFactory;
            Provider<QueryPayMethodPresenter> authRequestContext = DoubleCheck.getAuthRequestContext(QueryPayMethodPresenter_Factory.MyBillsEntityDataFactory(provider, provider2, provider3, payCardInfoMapper_Factory, this.DatabaseTableConfigUtil, this.initRecordTimeStamp, this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.PlaceComponentResult, this.scheduleImpl));
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = authRequestContext;
            this.newProxyInstance = DoubleCheck.getAuthRequestContext(QueryPayMethodModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(queryPayMethodModule, authRequestContext));
            this.isLayoutRequested = DoubleCheck.getAuthRequestContext(GetUserInfoModule_ProvideViewFactory.getAuthRequestContext(getUserInfoModule));
            UserRepositoryProvider userRepositoryProvider = new UserRepositoryProvider(applicationComponent);
            this.readMicros = userRepositoryProvider;
            this.getErrorConfigVersion = GetUserInfo_Factory.create(userRepositoryProvider);
            UserInfoMapper_Factory PlaceComponentResult = UserInfoMapper_Factory.PlaceComponentResult(CurrencyAmountModelMapper_Factory.MyBillsEntityDataFactory());
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = PlaceComponentResult;
            Provider<GetUserInfoPresenter> authRequestContext2 = DoubleCheck.getAuthRequestContext(GetUserInfoPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.isLayoutRequested, this.getErrorConfigVersion, PlaceComponentResult));
            this.moveToNextValue = authRequestContext2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = DoubleCheck.getAuthRequestContext(GetUserInfoModule_ProvidePresenterFactory.MyBillsEntityDataFactory(getUserInfoModule, authRequestContext2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class PayAssetRepositoryProvider implements Provider<PayAssetRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            PayAssetRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PayAssetRepository get() {
                return (PayAssetRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.X());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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
        /* loaded from: classes8.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class QrPayRepositoryProvider implements Provider<QrPayRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            QrPayRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ QrPayRepository get() {
                return (QrPayRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.PromoCategoryPresenter$1());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class DeviceInformationProviderProvider implements Provider<DeviceInformationProvider> {
            private final ApplicationComponent getAuthRequestContext;

            DeviceInformationProviderProvider(ApplicationComponent applicationComponent) {
                this.getAuthRequestContext = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ DeviceInformationProvider get() {
                return (DeviceInformationProvider) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda7());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class ContextProvider implements Provider<Context> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ Context get() {
                return (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class UserRepositoryProvider implements Provider<UserRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            UserRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ UserRepository get() {
                return (UserRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.BannerEntityDataFactory_Factory());
            }
        }

        @Override // id.dana.di.component.BoundCardComponent
        public final void MyBillsEntityDataFactory(BoundCardView boundCardView) {
            BoundCardView_MembersInjector.BuiltInFictitiousFunctionClassFactory(boundCardView, BoundCardModule_ProvidePresenterFactory.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, new BoundCardPresenter((Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue()), BoundCardModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory), BoundCardMapper_Factory.PlaceComponentResult(), new GetDefaultCard((CardRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getErrorConfigVersion())), new GetPhoneNumber((ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto()), (LiteAccountRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.AppCompatEmojiTextHelper())), new GetSendMoneyOption((ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto()), (SendMoneyRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.BaseSocialFeedContract$Presenter())), new SaveLastCardUsed((CardRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.getErrorConfigVersion())), new CheckEnableExpressPayFeature((ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto()), (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5())), new GetIsCardBindingV2Enabled((CardBindingRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.z())))));
            BoundCardView_MembersInjector.PlaceComponentResult(boundCardView, this.newProxyInstance.get());
            BoundCardView_MembersInjector.MyBillsEntityDataFactory(boundCardView, this.NetworkUserEntityData$$ExternalSyntheticLambda7.get());
            BoundCardView_MembersInjector.MyBillsEntityDataFactory(boundCardView, BoundCardMapper_Factory.PlaceComponentResult());
            BoundCardView_MembersInjector.PlaceComponentResult(boundCardView, (DynamicUrlWrapper) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.PrepareContext()));
        }
    }
}

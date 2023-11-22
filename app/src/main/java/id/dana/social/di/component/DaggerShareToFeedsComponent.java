package id.dana.social.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.component.ApplicationComponent;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.activation.interactor.GetFeedStatus;
import id.dana.feeds.domain.activation.interactor.GetFeedStatus_Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.feeds.domain.share.interactor.GetFeedsSharingLastCheckedState;
import id.dana.feeds.domain.share.interactor.GetFeedsSharingLastCheckedState_Factory;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent_Factory;
import id.dana.feeds.domain.share.interactor.SaveFeedsSharingLastCheckedState;
import id.dana.feeds.domain.share.interactor.SaveFeedsSharingLastCheckedState_Factory;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent_Factory;
import id.dana.sendmoney.feed.ShareToFeedsView;
import id.dana.sendmoney.feed.ShareToFeedsView_MembersInjector;
import id.dana.social.contract.share.ShareToFeedsContract;
import id.dana.social.contract.share.ShareToFeedsModule;
import id.dana.social.contract.share.ShareToFeedsModule_ProvideShareToFeedsPresenterFactory;
import id.dana.social.contract.share.ShareToFeedsModule_ProvideShareToFeedsViewFactory;
import id.dana.social.contract.share.ShareToFeedsPresenter;
import id.dana.social.contract.share.ShareToFeedsPresenter_Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DaggerShareToFeedsComponent {
    private DaggerShareToFeedsComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public ShareToFeedsModule PlaceComponentResult;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class ShareToFeedsComponentImpl implements ShareToFeedsComponent {
        private Provider<GetFeedsSharingLastCheckedState> BuiltInFictitiousFunctionClassFactory;
        private Provider<GetShareFeedConsent> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<FeedsShareRepository> MyBillsEntityDataFactory;
        private Provider<ShareToFeedsContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<GetFeedStatus> PlaceComponentResult;
        private Provider<FeedInitRepository> getAuthRequestContext;
        private Provider<SaveShareFeedConsent> getErrorConfigVersion;
        private Provider<ShareToFeedsPresenter> initRecordTimeStamp;
        private Provider<ShareToFeedsContract.View> lookAheadTest;
        private final ShareToFeedsComponentImpl moveToNextValue;
        private Provider<SaveFeedsSharingLastCheckedState> scheduleImpl;

        public /* synthetic */ ShareToFeedsComponentImpl(ShareToFeedsModule shareToFeedsModule, ApplicationComponent applicationComponent, byte b) {
            this(shareToFeedsModule, applicationComponent);
        }

        private ShareToFeedsComponentImpl(ShareToFeedsModule shareToFeedsModule, ApplicationComponent applicationComponent) {
            this.moveToNextValue = this;
            ProvideFeedsShareRepositoryProvider provideFeedsShareRepositoryProvider = new ProvideFeedsShareRepositoryProvider(applicationComponent);
            this.MyBillsEntityDataFactory = provideFeedsShareRepositoryProvider;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = GetShareFeedConsent_Factory.getAuthRequestContext(provideFeedsShareRepositoryProvider);
            this.getErrorConfigVersion = SaveShareFeedConsent_Factory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
            this.BuiltInFictitiousFunctionClassFactory = GetFeedsSharingLastCheckedState_Factory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
            this.scheduleImpl = SaveFeedsSharingLastCheckedState_Factory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(ShareToFeedsModule_ProvideShareToFeedsViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(shareToFeedsModule));
            ProvideFeedInitRepositoryProvider provideFeedInitRepositoryProvider = new ProvideFeedInitRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = provideFeedInitRepositoryProvider;
            GetFeedStatus_Factory KClassImpl$Data$declaredNonStaticMembers$2 = GetFeedStatus_Factory.KClassImpl$Data$declaredNonStaticMembers$2(provideFeedInitRepositoryProvider);
            this.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2;
            ShareToFeedsPresenter_Factory PlaceComponentResult = ShareToFeedsPresenter_Factory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, this.getErrorConfigVersion, this.BuiltInFictitiousFunctionClassFactory, this.scheduleImpl, this.lookAheadTest, KClassImpl$Data$declaredNonStaticMembers$2);
            this.initRecordTimeStamp = PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = DoubleCheck.getAuthRequestContext(ShareToFeedsModule_ProvideShareToFeedsPresenterFactory.getAuthRequestContext(shareToFeedsModule, PlaceComponentResult));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ProvideFeedsShareRepositoryProvider implements Provider<FeedsShareRepository> {
            private final ApplicationComponent PlaceComponentResult;

            ProvideFeedsShareRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedsShareRepository get() {
                return (FeedsShareRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ProvideFeedInitRepositoryProvider implements Provider<FeedInitRepository> {
            private final ApplicationComponent MyBillsEntityDataFactory;

            ProvideFeedInitRepositoryProvider(ApplicationComponent applicationComponent) {
                this.MyBillsEntityDataFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeedInitRepository get() {
                return (FeedInitRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.l());
            }
        }

        @Override // id.dana.social.di.component.ShareToFeedsComponent
        public final void BuiltInFictitiousFunctionClassFactory(ShareToFeedsView shareToFeedsView) {
            ShareToFeedsView_MembersInjector.BuiltInFictitiousFunctionClassFactory(shareToFeedsView, this.NetworkUserEntityData$$ExternalSyntheticLambda0.get());
        }
    }
}

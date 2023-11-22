package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.MerchantLatestReviewModule;
import id.dana.di.modules.MerchantLatestReviewModule_ProvideMerchantLatestReviewPresenterFactory;
import id.dana.di.modules.MerchantLatestReviewModule_ProvideMerchantLatestReviewViewFactory;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.interactor.GetMerchantReviews;
import id.dana.domain.nearbyme.interactor.GetMerchantReviews_Factory;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewPresenter;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewPresenter_Factory;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewView;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewView_MembersInjector;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerMerchantLatestReviewComponent {
    private DaggerMerchantLatestReviewComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public MerchantLatestReviewModule KClassImpl$Data$declaredNonStaticMembers$2;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MerchantLatestReviewComponentImpl implements MerchantLatestReviewComponent {
        private final MerchantLatestReviewComponentImpl BuiltInFictitiousFunctionClassFactory;
        private Provider<MerchantLatestReviewPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetMerchantReviews> MyBillsEntityDataFactory;
        private Provider<MerchantInfoRepository> PlaceComponentResult;
        private Provider<AccountRepository> getAuthRequestContext;
        private Provider<MerchantLatestReviewContract.View> lookAheadTest;
        private Provider<MerchantLatestReviewContract.Presenter> scheduleImpl;

        public /* synthetic */ MerchantLatestReviewComponentImpl(MerchantLatestReviewModule merchantLatestReviewModule, ApplicationComponent applicationComponent, byte b) {
            this(merchantLatestReviewModule, applicationComponent);
        }

        private MerchantLatestReviewComponentImpl(MerchantLatestReviewModule merchantLatestReviewModule, ApplicationComponent applicationComponent) {
            this.BuiltInFictitiousFunctionClassFactory = this;
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(MerchantLatestReviewModule_ProvideMerchantLatestReviewViewFactory.getAuthRequestContext(merchantLatestReviewModule));
            this.PlaceComponentResult = new MerchantInfoRepositoryProvider(applicationComponent);
            AccountRepositoryProvider accountRepositoryProvider = new AccountRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = accountRepositoryProvider;
            GetMerchantReviews_Factory create = GetMerchantReviews_Factory.create(this.PlaceComponentResult, accountRepositoryProvider);
            this.MyBillsEntityDataFactory = create;
            MerchantLatestReviewPresenter_Factory BuiltInFictitiousFunctionClassFactory = MerchantLatestReviewPresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest, create);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
            this.scheduleImpl = DoubleCheck.getAuthRequestContext(MerchantLatestReviewModule_ProvideMerchantLatestReviewPresenterFactory.getAuthRequestContext(merchantLatestReviewModule, BuiltInFictitiousFunctionClassFactory));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class MerchantInfoRepositoryProvider implements Provider<MerchantInfoRepository> {
            private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

            MerchantInfoRepositoryProvider(ApplicationComponent applicationComponent) {
                this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantInfoRepository get() {
                return (MerchantInfoRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.M());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class AccountRepositoryProvider implements Provider<AccountRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            AccountRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ AccountRepository get() {
                return (AccountRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory());
            }
        }

        @Override // id.dana.di.component.MerchantLatestReviewComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(MerchantLatestReviewView merchantLatestReviewView) {
            MerchantLatestReviewView_MembersInjector.BuiltInFictitiousFunctionClassFactory(merchantLatestReviewView, this.scheduleImpl.get());
        }
    }
}

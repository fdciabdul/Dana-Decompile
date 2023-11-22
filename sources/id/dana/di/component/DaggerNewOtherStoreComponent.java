package id.dana.di.component;

import android.content.Context;
import dagger.internal.Preconditions;
import id.dana.contract.nearbyme.OtherStoreListPresenter;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.domain.nearbyme.interactor.GetOtherStoreList;
import id.dana.drawable.otherstore.OtherStoreResultView;
import id.dana.drawable.otherstore.OtherStoreResultView_MembersInjector;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.di.module.OtherStoreListModule;
import id.dana.nearbyme.di.module.OtherStoreListModule_ProvideNearbyAnalyticTrackerFactory;
import id.dana.nearbyme.di.module.OtherStoreListModule_ProvideOtherStoreListViewFactory;
import id.dana.nearbyme.di.module.OtherStoreListModule_ProvideOtherStorePresenterFactory;
import id.dana.nearbyme.mapper.ContactAddressMapper;
import id.dana.nearbyme.mapper.MerchantSubcategoriesMapper;
import id.dana.nearbyme.mapper.OtherStoreListResultModelMapper;
import id.dana.nearbyme.mapper.PromoInfoMapper;
import id.dana.nearbyme.mapper.PromoLimitInfoMapper;
import id.dana.nearbyme.mapper.ShopOpenHourListMapper;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;

/* loaded from: classes4.dex */
public final class DaggerNewOtherStoreComponent {
    private DaggerNewOtherStoreComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public OtherStoreListModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class NewOtherStoreComponentImpl implements NewOtherStoreComponent {
        private final NewOtherStoreComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private final OtherStoreListModule PlaceComponentResult;

        public /* synthetic */ NewOtherStoreComponentImpl(OtherStoreListModule otherStoreListModule, ApplicationComponent applicationComponent, byte b) {
            this(otherStoreListModule, applicationComponent);
        }

        private NewOtherStoreComponentImpl(OtherStoreListModule otherStoreListModule, ApplicationComponent applicationComponent) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.PlaceComponentResult = otherStoreListModule;
            this.MyBillsEntityDataFactory = applicationComponent;
        }

        @Override // id.dana.di.component.NewOtherStoreComponent
        public final void PlaceComponentResult(OtherStoreResultView otherStoreResultView) {
            OtherStoreResultView_MembersInjector.MyBillsEntityDataFactory(otherStoreResultView, OtherStoreListModule_ProvideOtherStorePresenterFactory.MyBillsEntityDataFactory(this.PlaceComponentResult, new OtherStoreListPresenter(new GetOtherStoreList((NearbyMeRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuth())), new GetNearbyShopsPromo((NearbyMeRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuth())), new NearbyPromoModelMapper(new CurrencyAmountModelMapper()), OtherStoreListModule_ProvideOtherStoreListViewFactory.getAuthRequestContext(this.PlaceComponentResult), new OtherStoreListResultModelMapper(new ShopOpenHourListMapper(), new ContactAddressMapper(), new PromoInfoMapper(new CurrencyAmountModelMapper(), new PromoLimitInfoMapper()), new MerchantSubcategoriesMapper()))));
            OtherStoreResultView_MembersInjector.MyBillsEntityDataFactory(otherStoreResultView, OtherStoreListModule_ProvideNearbyAnalyticTrackerFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, new NearbyDefaultTracker((Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue()))));
        }
    }
}

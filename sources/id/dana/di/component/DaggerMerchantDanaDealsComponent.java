package id.dana.di.component;

import dagger.internal.Preconditions;
import id.dana.di.modules.MerchantDanaDealsModule;
import id.dana.di.modules.MerchantDanaDealsModule_ProvideMerchantDealsPresenterFactory;
import id.dana.di.modules.MerchantDanaDealsModule_ProvideViewFactory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.interactor.CreateDanaDealsVoucherOrder;
import id.dana.domain.nearbyme.interactor.GetMerchantDanaDeals;
import id.dana.domain.nearbyme.interactor.GetShopPromoAndDeals;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.mapper.DanaDealsOrderRequestMapper;
import id.dana.nearbyme.merchantdetail.mapper.CreateProductVoucherOrderMapper;
import id.dana.nearbyme.merchantdetail.mapper.MerchantDanaDealsMapper;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsPresenter;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsView;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsView_MembersInjector;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes4.dex */
public final class DaggerMerchantDanaDealsComponent {
    private DaggerMerchantDanaDealsComponent() {
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public MerchantDanaDealsModule MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MerchantDanaDealsComponentImpl implements MerchantDanaDealsComponent {
        private final MerchantDanaDealsModule BuiltInFictitiousFunctionClassFactory;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private final MerchantDanaDealsComponentImpl PlaceComponentResult;

        public /* synthetic */ MerchantDanaDealsComponentImpl(MerchantDanaDealsModule merchantDanaDealsModule, ApplicationComponent applicationComponent, byte b) {
            this(merchantDanaDealsModule, applicationComponent);
        }

        private MerchantDanaDealsComponentImpl(MerchantDanaDealsModule merchantDanaDealsModule, ApplicationComponent applicationComponent) {
            this.PlaceComponentResult = this;
            this.BuiltInFictitiousFunctionClassFactory = merchantDanaDealsModule;
            this.MyBillsEntityDataFactory = applicationComponent;
        }

        @Override // id.dana.di.component.MerchantDanaDealsComponent
        public final void getAuthRequestContext(MerchantDanaDealsView merchantDanaDealsView) {
            MerchantDanaDealsView_MembersInjector.MyBillsEntityDataFactory(merchantDanaDealsView, MerchantDanaDealsModule_ProvideMerchantDealsPresenterFactory.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, new MerchantDanaDealsPresenter(new CreateDanaDealsVoucherOrder((MerchantInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.M())), new GetShopPromoAndDeals((MerchantInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.M()), (CoroutineDispatcher) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.GetContactSyncConfig())), new GetMerchantDanaDeals((MerchantInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.M())), MerchantDanaDealsModule_ProvideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory), new MerchantDanaDealsMapper(), new NearbyPromoModelMapper(new CurrencyAmountModelMapper()), new CreateProductVoucherOrderMapper(), new DanaDealsOrderRequestMapper())));
        }
    }
}

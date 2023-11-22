package id.dana.di.component;

import dagger.internal.Preconditions;
import id.dana.di.modules.MerchantInfoModule;
import id.dana.di.modules.MerchantInfoModule_ProvideMerchantInfoPresenterFactory;
import id.dana.di.modules.MerchantInfoModule_ProvideViewFactory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.domain.nearbyme.interactor.GetMerchantInfo;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.merchantdetail.mapper.MerchantInfoMapper;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoPresenter;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoView;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;

/* loaded from: classes4.dex */
public final class DaggerMerchantInfoComponent {
    private DaggerMerchantInfoComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent MyBillsEntityDataFactory;
        public MerchantInfoModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MerchantInfoComponentImpl implements MerchantInfoComponent {
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private final MerchantInfoComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private final MerchantInfoModule getAuthRequestContext;

        public /* synthetic */ MerchantInfoComponentImpl(MerchantInfoModule merchantInfoModule, ApplicationComponent applicationComponent, byte b) {
            this(merchantInfoModule, applicationComponent);
        }

        private MerchantInfoComponentImpl(MerchantInfoModule merchantInfoModule, ApplicationComponent applicationComponent) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.getAuthRequestContext = merchantInfoModule;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
        }

        @Override // id.dana.di.component.MerchantInfoComponent
        public final void MyBillsEntityDataFactory(MerchantInfoView merchantInfoView) {
            merchantInfoView.merchantInfoPresenter = MerchantInfoModule_ProvideMerchantInfoPresenterFactory.MyBillsEntityDataFactory(this.getAuthRequestContext, new MerchantInfoPresenter(MerchantInfoModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext), new GetMerchantInfo((MerchantInfoRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.M())), new GetNearbyShopsPromo((NearbyMeRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuth())), new NearbyPromoModelMapper(new CurrencyAmountModelMapper()), new MerchantInfoMapper()));
        }
    }
}

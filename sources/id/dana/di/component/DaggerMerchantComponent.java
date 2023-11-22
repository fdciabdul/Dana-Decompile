package id.dana.di.component;

import dagger.internal.Preconditions;
import id.dana.di.modules.MerchantModule;
import id.dana.di.modules.MerchantModule_ProvidePresenterFactory;
import id.dana.di.modules.MerchantModule_ProvideViewFactory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.merchant.MerchantCategoriesRepository;
import id.dana.domain.merchant.interactor.CheckMerchantCategoriesFeature;
import id.dana.domain.merchant.interactor.GetMerchantCategories;
import id.dana.domain.merchant.interactor.GetNewMerchantCategories;
import id.dana.domain.merchant.interactor.InitNewMerchantCategories;
import id.dana.nearbyme.MerchantPresenter;
import id.dana.nearbyme.mapper.MerchantCategoriesMapper;
import id.dana.nearbyme.summary.MerchantListView;

/* loaded from: classes8.dex */
public final class DaggerMerchantComponent {
    private DaggerMerchantComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public MerchantModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class MerchantComponentImpl implements MerchantComponent {
        private final MerchantComponentImpl BuiltInFictitiousFunctionClassFactory;
        private final MerchantModule PlaceComponentResult;
        private final ApplicationComponent getAuthRequestContext;

        public /* synthetic */ MerchantComponentImpl(MerchantModule merchantModule, ApplicationComponent applicationComponent, byte b) {
            this(merchantModule, applicationComponent);
        }

        private MerchantComponentImpl(MerchantModule merchantModule, ApplicationComponent applicationComponent) {
            this.BuiltInFictitiousFunctionClassFactory = this;
            this.PlaceComponentResult = merchantModule;
            this.getAuthRequestContext = applicationComponent;
        }

        @Override // id.dana.di.component.MerchantComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(MerchantListView merchantListView) {
            merchantListView.presenter = MerchantModule_ProvidePresenterFactory.getAuthRequestContext(this.PlaceComponentResult, new MerchantPresenter(MerchantModule_ProvideViewFactory.MyBillsEntityDataFactory(this.PlaceComponentResult), new GetMerchantCategories((MerchantCategoriesRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.K())), new CheckMerchantCategoriesFeature((FeatureConfigRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5())), new GetNewMerchantCategories((MerchantCategoriesRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.K())), new MerchantCategoriesMapper(), new InitNewMerchantCategories((MerchantCategoriesRepository) Preconditions.PlaceComponentResult(this.getAuthRequestContext.K()))));
        }
    }
}

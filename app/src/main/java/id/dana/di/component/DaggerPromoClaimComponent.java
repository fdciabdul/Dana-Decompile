package id.dana.di.component;

import android.content.Context;
import dagger.internal.Preconditions;
import id.dana.di.modules.PromoClaimModule;
import id.dana.di.modules.PromoClaimModule_GetPresenterFactory;
import id.dana.di.modules.PromoClaimModule_GetViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.GetPromoClaimConfig;
import id.dana.domain.promotion.interactor.GetPromoClaimBanner;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.mapper.LeaderboardMapper;
import id.dana.richview.promoclaim.PromoClaimPresenter;
import id.dana.richview.promoclaim.PromoClaimView;
import id.dana.richview.promoclaim.PromoClaimView_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;

/* loaded from: classes8.dex */
public final class DaggerPromoClaimComponent {
    private DaggerPromoClaimComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public PromoClaimModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class PromoClaimComponentImpl implements PromoClaimComponent {
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private final PromoClaimComponentImpl MyBillsEntityDataFactory;
        private final PromoClaimModule getAuthRequestContext;

        public /* synthetic */ PromoClaimComponentImpl(PromoClaimModule promoClaimModule, ApplicationComponent applicationComponent, byte b) {
            this(promoClaimModule, applicationComponent);
        }

        private PromoClaimComponentImpl(PromoClaimModule promoClaimModule, ApplicationComponent applicationComponent) {
            this.MyBillsEntityDataFactory = this;
            this.getAuthRequestContext = promoClaimModule;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
        }

        @Override // id.dana.di.component.PromoClaimComponent
        public final void MyBillsEntityDataFactory(PromoClaimView promoClaimView) {
            PromoClaimView_MembersInjector.MyBillsEntityDataFactory(promoClaimView, PromoClaimModule_GetPresenterFactory.MyBillsEntityDataFactory(this.getAuthRequestContext, new PromoClaimPresenter((Context) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.moveToNextValue()), PromoClaimModule_GetViewFactory.getAuthRequestContext(this.getAuthRequestContext), new GetPromoClaimBanner((ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto()), (PromotionRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.a())), new GetPromoClaimConfig((ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto()), (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5())), new LeaderboardMapper())));
        }
    }
}

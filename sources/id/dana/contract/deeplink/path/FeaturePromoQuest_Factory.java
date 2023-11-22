package id.dana.contract.deeplink.path;

import dagger.internal.Factory;
import id.dana.domain.promoquest.interactor.GetMissionDetail;
import id.dana.promoquest.mapper.PromoQuestMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FeaturePromoQuest_Factory implements Factory<FeaturePromoQuest> {
    private final Provider<GetMissionDetail> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PromoQuestMapper> PlaceComponentResult;

    private FeaturePromoQuest_Factory(Provider<GetMissionDetail> provider, Provider<PromoQuestMapper> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static FeaturePromoQuest_Factory getAuthRequestContext(Provider<GetMissionDetail> provider, Provider<PromoQuestMapper> provider2) {
        return new FeaturePromoQuest_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeaturePromoQuest(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}

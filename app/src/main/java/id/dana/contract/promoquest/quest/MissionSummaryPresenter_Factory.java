package id.dana.contract.promoquest.quest;

import dagger.internal.Factory;
import id.dana.contract.promoquest.quest.MissionSummaryContract;
import id.dana.domain.featureconfig.interactor.CheckPromoQuestFeature;
import id.dana.domain.promoquest.interactor.GetMissions;
import id.dana.promoquest.mapper.PromoQuestMapper;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class MissionSummaryPresenter_Factory implements Factory<MissionSummaryPresenter> {
    private final Provider<PromoQuestMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CheckPromoQuestFeature> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MissionSummaryContract.View> MyBillsEntityDataFactory;
    private final Provider<GetMissions> PlaceComponentResult;

    private MissionSummaryPresenter_Factory(Provider<CheckPromoQuestFeature> provider, Provider<GetMissions> provider2, Provider<PromoQuestMapper> provider3, Provider<MissionSummaryContract.View> provider4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.PlaceComponentResult = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static MissionSummaryPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<CheckPromoQuestFeature> provider, Provider<GetMissions> provider2, Provider<PromoQuestMapper> provider3, Provider<MissionSummaryContract.View> provider4) {
        return new MissionSummaryPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MissionSummaryPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}

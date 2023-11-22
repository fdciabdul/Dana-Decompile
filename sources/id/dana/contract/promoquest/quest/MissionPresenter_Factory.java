package id.dana.contract.promoquest.quest;

import dagger.internal.Factory;
import id.dana.contract.promoquest.quest.MissionContract;
import id.dana.domain.featureconfig.interactor.GetTnCReferralMissionConfig;
import id.dana.domain.promoquest.interactor.GetMissionDetail;
import id.dana.promoquest.mapper.PromoQuestMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MissionPresenter_Factory implements Factory<MissionPresenter> {
    private final Provider<PromoQuestMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetTnCReferralMissionConfig> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetMissionDetail> PlaceComponentResult;
    private final Provider<MissionContract.View> getAuthRequestContext;

    private MissionPresenter_Factory(Provider<MissionContract.View> provider, Provider<GetMissionDetail> provider2, Provider<GetTnCReferralMissionConfig> provider3, Provider<PromoQuestMapper> provider4) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
    }

    public static MissionPresenter_Factory PlaceComponentResult(Provider<MissionContract.View> provider, Provider<GetMissionDetail> provider2, Provider<GetTnCReferralMissionConfig> provider3, Provider<PromoQuestMapper> provider4) {
        return new MissionPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MissionPresenter(this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promoquest.mission.MissionListContract;
import id.dana.contract.promoquest.mission.MissionListPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PromoQuestModule_ProvidePresenterFactory implements Factory<MissionListContract.Presenter> {
    private final Provider<MissionListPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final PromoQuestModule MyBillsEntityDataFactory;

    public static MissionListContract.Presenter getAuthRequestContext(PromoQuestModule promoQuestModule, MissionListPresenter missionListPresenter) {
        return (MissionListContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(promoQuestModule.PlaceComponentResult(missionListPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MissionListContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}

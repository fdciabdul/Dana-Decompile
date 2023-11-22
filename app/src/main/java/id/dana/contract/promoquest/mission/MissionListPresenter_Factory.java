package id.dana.contract.promoquest.mission;

import dagger.internal.Factory;
import id.dana.contract.promoquest.mission.MissionListContract;
import id.dana.domain.promoquest.interactor.GetMissionsWithQuestByStatus;
import id.dana.promoquest.mapper.PromoQuestMapper;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class MissionListPresenter_Factory implements Factory<MissionListPresenter> {
    private final Provider<GetMissionsWithQuestByStatus> BuiltInFictitiousFunctionClassFactory;
    private final Provider<MissionListContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetMissionsWithQuestByStatus> MyBillsEntityDataFactory;
    private final Provider<PromoQuestMapper> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MissionListPresenter(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}

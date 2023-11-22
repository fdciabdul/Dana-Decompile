package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promoquest.mission.MissionListContract;

/* loaded from: classes4.dex */
public final class PromoQuestModule_ProvideMissionViewFactory implements Factory<MissionListContract.View> {
    private final PromoQuestModule MyBillsEntityDataFactory;

    public static MissionListContract.View BuiltInFictitiousFunctionClassFactory(PromoQuestModule promoQuestModule) {
        return (MissionListContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(promoQuestModule.getGetAuthRequestContext());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MissionListContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getGetAuthRequestContext());
    }
}

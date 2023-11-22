package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promoquest.quest.MissionContract;

/* loaded from: classes4.dex */
public final class MissionModule_ProvideQuestViewFactory implements Factory<MissionContract.View> {
    private final MissionModule getAuthRequestContext;

    private MissionModule_ProvideQuestViewFactory(MissionModule missionModule) {
        this.getAuthRequestContext = missionModule;
    }

    public static MissionModule_ProvideQuestViewFactory MyBillsEntityDataFactory(MissionModule missionModule) {
        return new MissionModule_ProvideQuestViewFactory(missionModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MissionContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getPlaceComponentResult());
    }
}

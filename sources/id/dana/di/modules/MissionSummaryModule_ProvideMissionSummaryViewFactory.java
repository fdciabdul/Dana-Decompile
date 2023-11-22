package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promoquest.quest.MissionSummaryContract;

/* loaded from: classes8.dex */
public final class MissionSummaryModule_ProvideMissionSummaryViewFactory implements Factory<MissionSummaryContract.View> {
    private final MissionSummaryModule MyBillsEntityDataFactory;

    private MissionSummaryModule_ProvideMissionSummaryViewFactory(MissionSummaryModule missionSummaryModule) {
        this.MyBillsEntityDataFactory = missionSummaryModule;
    }

    public static MissionSummaryModule_ProvideMissionSummaryViewFactory getAuthRequestContext(MissionSummaryModule missionSummaryModule) {
        return new MissionSummaryModule_ProvideMissionSummaryViewFactory(missionSummaryModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MissionSummaryContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext());
    }
}

package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promoquest.quest.MissionSummaryContract;
import id.dana.contract.promoquest.quest.MissionSummaryPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class MissionSummaryModule_ProvideMissionSummaryPresenterFactory implements Factory<MissionSummaryContract.Presenter> {
    private final MissionSummaryModule MyBillsEntityDataFactory;
    private final Provider<MissionSummaryPresenter> getAuthRequestContext;

    private MissionSummaryModule_ProvideMissionSummaryPresenterFactory(MissionSummaryModule missionSummaryModule, Provider<MissionSummaryPresenter> provider) {
        this.MyBillsEntityDataFactory = missionSummaryModule;
        this.getAuthRequestContext = provider;
    }

    public static MissionSummaryModule_ProvideMissionSummaryPresenterFactory MyBillsEntityDataFactory(MissionSummaryModule missionSummaryModule, Provider<MissionSummaryPresenter> provider) {
        return new MissionSummaryModule_ProvideMissionSummaryPresenterFactory(missionSummaryModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MissionSummaryContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}

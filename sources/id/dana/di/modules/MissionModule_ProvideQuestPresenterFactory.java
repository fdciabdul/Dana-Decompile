package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promoquest.quest.MissionContract;
import id.dana.contract.promoquest.quest.MissionPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MissionModule_ProvideQuestPresenterFactory implements Factory<MissionContract.Presenter> {
    private final Provider<MissionPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final MissionModule getAuthRequestContext;

    private MissionModule_ProvideQuestPresenterFactory(MissionModule missionModule, Provider<MissionPresenter> provider) {
        this.getAuthRequestContext = missionModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static MissionModule_ProvideQuestPresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(MissionModule missionModule, Provider<MissionPresenter> provider) {
        return new MissionModule_ProvideQuestPresenterFactory(missionModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MissionContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}

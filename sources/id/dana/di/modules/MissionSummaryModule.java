package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.promoquest.quest.MissionSummaryContract;
import id.dana.contract.promoquest.quest.MissionSummaryPresenter;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes8.dex */
public class MissionSummaryModule {
    private final MissionSummaryContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public MissionSummaryContract.Presenter PlaceComponentResult(MissionSummaryPresenter missionSummaryPresenter) {
        return missionSummaryPresenter;
    }

    public MissionSummaryModule(MissionSummaryContract.View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public MissionSummaryContract.View getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}

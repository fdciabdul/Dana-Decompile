package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.richview.leaderboardentry.LeaderboardEntryContract;
import id.dana.richview.leaderboardentry.LeaderboardEntryPresenter;

@Module
/* loaded from: classes8.dex */
public class LeaderboardEntryModule {
    private LeaderboardEntryContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public LeaderboardEntryContract.Presenter getAuthRequestContext(LeaderboardEntryPresenter leaderboardEntryPresenter) {
        return leaderboardEntryPresenter;
    }

    public LeaderboardEntryModule(LeaderboardEntryContract.View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public LeaderboardEntryContract.View MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}

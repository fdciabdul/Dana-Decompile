package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.leaderboardentry.LeaderboardEntryContract;
import id.dana.richview.leaderboardentry.LeaderboardEntryPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class LeaderboardEntryModule_ProvidePresenterFactory implements Factory<LeaderboardEntryContract.Presenter> {
    private final Provider<LeaderboardEntryPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final LeaderboardEntryModule getAuthRequestContext;

    public static LeaderboardEntryContract.Presenter MyBillsEntityDataFactory(LeaderboardEntryModule leaderboardEntryModule, LeaderboardEntryPresenter leaderboardEntryPresenter) {
        return (LeaderboardEntryContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(leaderboardEntryModule.getAuthRequestContext(leaderboardEntryPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LeaderboardEntryContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}

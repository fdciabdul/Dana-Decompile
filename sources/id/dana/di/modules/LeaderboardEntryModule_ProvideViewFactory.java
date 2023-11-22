package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.leaderboardentry.LeaderboardEntryContract;

/* loaded from: classes8.dex */
public final class LeaderboardEntryModule_ProvideViewFactory implements Factory<LeaderboardEntryContract.View> {
    private final LeaderboardEntryModule MyBillsEntityDataFactory;

    public static LeaderboardEntryContract.View MyBillsEntityDataFactory(LeaderboardEntryModule leaderboardEntryModule) {
        return (LeaderboardEntryContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(leaderboardEntryModule.MyBillsEntityDataFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LeaderboardEntryContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
    }
}

package id.dana.danapoly.ui.leaderboard.viewmodel;

import dagger.internal.Factory;
import id.dana.danapoly.domain.play.interactor.FetchLeaderboard;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class LeaderboardViewModel_Factory implements Factory<LeaderboardViewModel> {
    private final Provider<FetchLeaderboard> PlaceComponentResult;

    private LeaderboardViewModel_Factory(Provider<FetchLeaderboard> provider) {
        this.PlaceComponentResult = provider;
    }

    public static LeaderboardViewModel_Factory PlaceComponentResult(Provider<FetchLeaderboard> provider) {
        return new LeaderboardViewModel_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LeaderboardViewModel(this.PlaceComponentResult.get());
    }
}

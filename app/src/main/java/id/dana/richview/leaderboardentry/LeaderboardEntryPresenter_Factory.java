package id.dana.richview.leaderboardentry;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.CheckLeaderboardEntryFeature;
import id.dana.domain.promotion.interactor.GetLeaderboardEntryBanner;
import id.dana.mapper.LeaderboardMapper;
import id.dana.richview.leaderboardentry.LeaderboardEntryContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class LeaderboardEntryPresenter_Factory implements Factory<LeaderboardEntryPresenter> {
    private final Provider<GetLeaderboardEntryBanner> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<LeaderboardEntryContract.View> MyBillsEntityDataFactory;
    private final Provider<LeaderboardMapper> PlaceComponentResult;
    private final Provider<CheckLeaderboardEntryFeature> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LeaderboardEntryPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}

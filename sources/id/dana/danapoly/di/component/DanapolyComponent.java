package id.dana.danapoly.di.component;

import dagger.Subcomponent;
import id.dana.danapoly.di.DanapolyScope;
import id.dana.danapoly.di.module.DanapolyDataModule;
import id.dana.danapoly.di.module.DanapolyTrackerModule;
import id.dana.danapoly.di.module.DanapolyViewModelModule;
import id.dana.danapoly.ui.board.DanapolyBoardFragment;
import id.dana.danapoly.ui.board.DanapolyBoardTabActivity;
import id.dana.danapoly.ui.cards.CardListDetailFragment;
import id.dana.danapoly.ui.cards.CardsListFragment;
import id.dana.danapoly.ui.dailycheck.DailyCheckActivity;
import id.dana.danapoly.ui.leaderboard.LeaderboardFragment;
import id.dana.danapoly.ui.splash.DanapolySplashActivity;
import kotlin.Metadata;

@DanapolyScope
@Subcomponent(modules = {DanapolyDataModule.class, DanapolyViewModelModule.class, DanapolyTrackerModule.class})
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0013H&¢\u0006\u0004\b\b\u0010\u0014J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0015H&¢\u0006\u0004\b\u0011\u0010\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/danapoly/di/component/DanapolyComponent;", "", "Lid/dana/danapoly/ui/board/DanapolyBoardFragment;", "p0", "", "getAuthRequestContext", "(Lid/dana/danapoly/ui/board/DanapolyBoardFragment;)V", "Lid/dana/danapoly/ui/board/DanapolyBoardTabActivity;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/danapoly/ui/board/DanapolyBoardTabActivity;)V", "Lid/dana/danapoly/ui/cards/CardListDetailFragment;", "PlaceComponentResult", "(Lid/dana/danapoly/ui/cards/CardListDetailFragment;)V", "Lid/dana/danapoly/ui/cards/CardsListFragment;", "MyBillsEntityDataFactory", "(Lid/dana/danapoly/ui/cards/CardsListFragment;)V", "Lid/dana/danapoly/ui/dailycheck/DailyCheckActivity;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/danapoly/ui/dailycheck/DailyCheckActivity;)V", "Lid/dana/danapoly/ui/leaderboard/LeaderboardFragment;", "(Lid/dana/danapoly/ui/leaderboard/LeaderboardFragment;)V", "Lid/dana/danapoly/ui/splash/DanapolySplashActivity;", "(Lid/dana/danapoly/ui/splash/DanapolySplashActivity;)V", "Factory"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DanapolyComponent {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/danapoly/di/component/DanapolyComponent$Factory;", "", "Lid/dana/danapoly/di/component/DanapolyComponent;", "MyBillsEntityDataFactory", "()Lid/dana/danapoly/di/component/DanapolyComponent;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Subcomponent.Factory
    /* loaded from: classes.dex */
    public interface Factory {
        DanapolyComponent MyBillsEntityDataFactory();
    }

    void BuiltInFictitiousFunctionClassFactory(DailyCheckActivity p0);

    void BuiltInFictitiousFunctionClassFactory(DanapolySplashActivity p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(DanapolyBoardTabActivity p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(LeaderboardFragment p0);

    void MyBillsEntityDataFactory(CardsListFragment p0);

    void PlaceComponentResult(CardListDetailFragment p0);

    void getAuthRequestContext(DanapolyBoardFragment p0);
}

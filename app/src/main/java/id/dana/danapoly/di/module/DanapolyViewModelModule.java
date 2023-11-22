package id.dana.danapoly.di.module;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.di.module.ViewModelKey;
import id.dana.danapoly.di.DanapolyScope;
import id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel;
import id.dana.danapoly.ui.cards.viewmodel.DanapolyCardsDetailViewModel;
import id.dana.danapoly.ui.cards.viewmodel.DanapolyCardsViewModel;
import id.dana.danapoly.ui.dailycheck.viewmodel.DailyCheckViewModel;
import id.dana.danapoly.ui.leaderboard.viewmodel.LeaderboardViewModel;
import id.dana.danapoly.ui.splash.viewmodel.DanapolyConfigViewModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\u0005\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\n\u0010\u0010J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0011H'¢\u0006\u0004\b\n\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/danapoly/di/module/DanapolyViewModelModule;", "", "Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckViewModel;", "p0", "Landroidx/lifecycle/ViewModel;", "MyBillsEntityDataFactory", "(Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardViewModel;", "(Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailViewModel;", "PlaceComponentResult", "(Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsViewModel;", "getAuthRequestContext", "(Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigViewModel;", "(Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardViewModel;", "(Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/core/ui/di/module/ViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public abstract class DanapolyViewModelModule {
    @DanapolyScope
    @Binds
    public abstract ViewModelProvider.Factory KClassImpl$Data$declaredNonStaticMembers$2(ViewModelFactory p0);

    @Binds
    @DanapolyScope
    @IntoMap
    @ViewModelKey(DanapolyBoardViewModel.class)
    public abstract ViewModel MyBillsEntityDataFactory(DanapolyBoardViewModel p0);

    @Binds
    @DanapolyScope
    @IntoMap
    @ViewModelKey(DailyCheckViewModel.class)
    public abstract ViewModel MyBillsEntityDataFactory(DailyCheckViewModel p0);

    @Binds
    @DanapolyScope
    @IntoMap
    @ViewModelKey(DanapolyCardsDetailViewModel.class)
    public abstract ViewModel PlaceComponentResult(DanapolyCardsDetailViewModel p0);

    @Binds
    @DanapolyScope
    @IntoMap
    @ViewModelKey(LeaderboardViewModel.class)
    public abstract ViewModel PlaceComponentResult(LeaderboardViewModel p0);

    @Binds
    @DanapolyScope
    @IntoMap
    @ViewModelKey(DanapolyConfigViewModel.class)
    public abstract ViewModel PlaceComponentResult(DanapolyConfigViewModel p0);

    @Binds
    @DanapolyScope
    @IntoMap
    @ViewModelKey(DanapolyCardsViewModel.class)
    public abstract ViewModel getAuthRequestContext(DanapolyCardsViewModel p0);
}

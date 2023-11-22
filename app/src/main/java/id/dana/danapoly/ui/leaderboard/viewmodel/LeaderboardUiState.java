package id.dana.danapoly.ui.leaderboard.viewmodel;

import id.dana.danapoly.ui.model.leaderboard.LeaderboardModel;
import id.dana.danapoly.ui.model.leaderboard.PrizeInfoModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardUiState;", "", "<init>", "()V", "None", "OnFetchLeaderboardFailed", "OnFetchLeaderboardSuccess", "Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardUiState$None;", "Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardUiState$OnFetchLeaderboardSuccess;", "Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardUiState$OnFetchLeaderboardFailed;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class LeaderboardUiState {
    public /* synthetic */ LeaderboardUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LeaderboardUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardUiState$None;", "Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class None extends LeaderboardUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u000b"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardUiState$OnFetchLeaderboardSuccess;", "Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Long;", "", "Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;", "getAuthRequestContext", "Ljava/util/List;", "MyBillsEntityDataFactory", "Lid/dana/danapoly/ui/model/leaderboard/PrizeInfoModel;", "Lid/dana/danapoly/ui/model/leaderboard/PrizeInfoModel;", "p0", "p1", "p2", "<init>", "(Ljava/util/List;Ljava/lang/Long;Lid/dana/danapoly/ui/model/leaderboard/PrizeInfoModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnFetchLeaderboardSuccess extends LeaderboardUiState {
        public final Long BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final PrizeInfoModel getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final List<LeaderboardModel> MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnFetchLeaderboardSuccess(List<LeaderboardModel> list, Long l, PrizeInfoModel prizeInfoModel) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.MyBillsEntityDataFactory = list;
            this.BuiltInFictitiousFunctionClassFactory = l;
            this.getAuthRequestContext = prizeInfoModel;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardUiState$OnFetchLeaderboardFailed;", "Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnFetchLeaderboardFailed extends LeaderboardUiState {
        public static final OnFetchLeaderboardFailed INSTANCE = new OnFetchLeaderboardFailed();

        private OnFetchLeaderboardFailed() {
            super(null);
        }
    }
}

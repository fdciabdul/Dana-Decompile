package id.dana.danapoly.ui.model.mapper;

import id.dana.danapoly.domain.play.model.GetLeaderboard;
import id.dana.danapoly.domain.play.model.Leaderboard;
import id.dana.danapoly.domain.play.model.Me;
import id.dana.danapoly.domain.play.model.PrizeInfo;
import id.dana.danapoly.ui.model.leaderboard.LeaderboardModel;
import id.dana.danapoly.ui.model.leaderboard.PrizeInfoModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\b\u001a\u0011\u0010\u0003\u001a\u00020\u0002*\u00020\t¢\u0006\u0004\b\u0003\u0010\n\u001a\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u0010\u001a\u00020\u000f*\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/danapoly/domain/play/model/GetLeaderboard;", "", "Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;", "toLeaderboardModel", "(Lid/dana/danapoly/domain/play/model/GetLeaderboard;)Ljava/util/List;", "Lid/dana/danapoly/domain/play/model/Leaderboard;", "", "rank", "(Lid/dana/danapoly/domain/play/model/Leaderboard;I)Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;", "Lid/dana/danapoly/domain/play/model/Me;", "(Lid/dana/danapoly/domain/play/model/Me;)Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;", "", "toLeaderboardModels", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/danapoly/domain/play/model/PrizeInfo;", "Lid/dana/danapoly/ui/model/leaderboard/PrizeInfoModel;", "toPrizeInfoModel", "(Lid/dana/danapoly/domain/play/model/PrizeInfo;)Lid/dana/danapoly/ui/model/leaderboard/PrizeInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LeaderboardMapperKt {
    public static final List<LeaderboardModel> toLeaderboardModel(GetLeaderboard getLeaderboard) {
        Intrinsics.checkNotNullParameter(getLeaderboard, "");
        List<LeaderboardModel> leaderboardModels = toLeaderboardModels(getLeaderboard.getLeaderboards());
        Me me2 = getLeaderboard.getMe();
        if (me2 != null) {
            if (me2.getRank() > 11) {
                leaderboardModels.add(LeaderboardModel.INSTANCE.generateDivider(me2.getUsersAboveMe()));
            }
            leaderboardModels.add(toLeaderboardModel(me2));
        }
        return leaderboardModels;
    }

    public static final PrizeInfoModel toPrizeInfoModel(PrizeInfo prizeInfo) {
        Intrinsics.checkNotNullParameter(prizeInfo, "");
        return new PrizeInfoModel(prizeInfo.getMedalImageUrl(), prizeInfo.getPrizeImageUrl(), RollDiceModelMapperKt.toLocalizationModel(prizeInfo.getPrize()), RollDiceModelMapperKt.toLocalizationModel(prizeInfo.getActionButton()), prizeInfo.getRedirectLink());
    }

    public static final List<LeaderboardModel> toLeaderboardModels(List<Leaderboard> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<Leaderboard> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i = 0;
        for (Object obj : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(toLeaderboardModel((Leaderboard) obj, i2));
            i = i2;
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }

    public static final LeaderboardModel toLeaderboardModel(Leaderboard leaderboard, int i) {
        Intrinsics.checkNotNullParameter(leaderboard, "");
        return new LeaderboardModel(i, leaderboard.getPhotoUrl(), leaderboard.getName(), leaderboard.getRankIdentifierValue(), leaderboard.getMyself(), 0, leaderboard.getMyself() ? 2 : 0, 32, null);
    }

    public static final LeaderboardModel toLeaderboardModel(Me me2) {
        Intrinsics.checkNotNullParameter(me2, "");
        return new LeaderboardModel(me2.getRank(), me2.getPhotoUrl(), me2.getName(), me2.getRankIdentifierValue(), true, me2.getUsersAboveMe(), 2);
    }
}

package id.dana.danapoly.data.play.model.mapper;

import id.dana.danapoly.data.play.model.response.GetLeaderboardResponse;
import id.dana.danapoly.data.play.model.response.LeaderboardResponse;
import id.dana.danapoly.data.play.model.response.LocalizationResponse;
import id.dana.danapoly.data.play.model.response.MeResponse;
import id.dana.danapoly.data.play.model.response.PaginatorResponse;
import id.dana.danapoly.data.play.model.response.PrizeInfoResponse;
import id.dana.danapoly.domain.play.model.GetLeaderboard;
import id.dana.danapoly.domain.play.model.Leaderboard;
import id.dana.danapoly.domain.play.model.Localization;
import id.dana.danapoly.domain.play.model.Me;
import id.dana.danapoly.domain.play.model.Paginator;
import id.dana.danapoly.domain.play.model.PrizeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b*\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\r\u001a\u00020\f*\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u0011\u001a\u00020\u0010*\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0011\u0010\u0015\u001a\u00020\u0014*\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/danapoly/data/play/model/response/GetLeaderboardResponse;", "Lid/dana/danapoly/domain/play/model/GetLeaderboard;", "toGetLeaderboard", "(Lid/dana/danapoly/data/play/model/response/GetLeaderboardResponse;)Lid/dana/danapoly/domain/play/model/GetLeaderboard;", "Lid/dana/danapoly/data/play/model/response/LeaderboardResponse;", "Lid/dana/danapoly/domain/play/model/Leaderboard;", "toLeaderboard", "(Lid/dana/danapoly/data/play/model/response/LeaderboardResponse;)Lid/dana/danapoly/domain/play/model/Leaderboard;", "", "toLeaderboards", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/danapoly/data/play/model/response/MeResponse;", "Lid/dana/danapoly/domain/play/model/Me;", "toMe", "(Lid/dana/danapoly/data/play/model/response/MeResponse;)Lid/dana/danapoly/domain/play/model/Me;", "Lid/dana/danapoly/data/play/model/response/PaginatorResponse;", "Lid/dana/danapoly/domain/play/model/Paginator;", "toPaginator", "(Lid/dana/danapoly/data/play/model/response/PaginatorResponse;)Lid/dana/danapoly/domain/play/model/Paginator;", "Lid/dana/danapoly/data/play/model/response/PrizeInfoResponse;", "Lid/dana/danapoly/domain/play/model/PrizeInfo;", "toPrizeInfo", "(Lid/dana/danapoly/data/play/model/response/PrizeInfoResponse;)Lid/dana/danapoly/domain/play/model/PrizeInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LeaderboardMapperKt {
    public static final GetLeaderboard toGetLeaderboard(GetLeaderboardResponse getLeaderboardResponse) {
        List<Leaderboard> emptyList;
        Paginator paginator;
        Intrinsics.checkNotNullParameter(getLeaderboardResponse, "");
        List<LeaderboardResponse> leaderboards = getLeaderboardResponse.getLeaderboards();
        if (leaderboards == null || (emptyList = toLeaderboards(leaderboards)) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        List<Leaderboard> list = emptyList;
        PrizeInfoResponse prizeInfo = getLeaderboardResponse.getPrizeInfo();
        PrizeInfo prizeInfo2 = prizeInfo != null ? toPrizeInfo(prizeInfo) : null;
        MeResponse me2 = getLeaderboardResponse.getMe();
        Me me3 = me2 != null ? toMe(me2) : null;
        PaginatorResponse paginator2 = getLeaderboardResponse.getPaginator();
        return new GetLeaderboard(list, prizeInfo2, me3, (paginator2 == null || (paginator = toPaginator(paginator2)) == null) ? new Paginator(0, 0, 0, false, 15, null) : paginator, null, 16, null);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public static final PrizeInfo toPrizeInfo(PrizeInfoResponse prizeInfoResponse) {
        Localization localization;
        Localization localization2;
        Intrinsics.checkNotNullParameter(prizeInfoResponse, "");
        String medalImageUrl = prizeInfoResponse.getMedalImageUrl();
        String str = medalImageUrl == null ? "" : medalImageUrl;
        String prizeImageUrl = prizeInfoResponse.getPrizeImageUrl();
        String str2 = prizeImageUrl == null ? "" : prizeImageUrl;
        LocalizationResponse prize = prizeInfoResponse.getPrize();
        int i = 3;
        ?? r5 = 0;
        if (prize == null || (localization = RollDiceMapperKt.toLocalization(prize)) == null) {
            localization = new Localization(r5, r5, i, r5);
        }
        LocalizationResponse actionButton = prizeInfoResponse.getActionButton();
        if (actionButton == null || (localization2 = RollDiceMapperKt.toLocalization(actionButton)) == null) {
            localization2 = new Localization(r5, r5, i, r5);
        }
        String redirectLink = prizeInfoResponse.getRedirectLink();
        return new PrizeInfo(str, str2, localization, localization2, redirectLink == null ? "" : redirectLink);
    }

    public static final List<Leaderboard> toLeaderboards(List<LeaderboardResponse> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<LeaderboardResponse> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toLeaderboard((LeaderboardResponse) it.next()));
        }
        return arrayList;
    }

    public static final Leaderboard toLeaderboard(LeaderboardResponse leaderboardResponse) {
        Intrinsics.checkNotNullParameter(leaderboardResponse, "");
        String name = leaderboardResponse.getName();
        if (name == null) {
            name = "";
        }
        String photoUrl = leaderboardResponse.getPhotoUrl();
        String str = photoUrl != null ? photoUrl : "";
        Integer rankIdentifierValue = leaderboardResponse.getRankIdentifierValue();
        int intValue = rankIdentifierValue != null ? rankIdentifierValue.intValue() : 0;
        Boolean myself = leaderboardResponse.getMyself();
        return new Leaderboard(name, str, intValue, myself != null ? myself.booleanValue() : false);
    }

    public static final Me toMe(MeResponse meResponse) {
        Intrinsics.checkNotNullParameter(meResponse, "");
        String name = meResponse.getName();
        String str = name == null ? "" : name;
        Integer rank = meResponse.getRank();
        int intValue = rank != null ? rank.intValue() : 0;
        String photoUrl = meResponse.getPhotoUrl();
        String str2 = photoUrl == null ? "" : photoUrl;
        Integer rankIdentifierValue = meResponse.getRankIdentifierValue();
        int intValue2 = rankIdentifierValue != null ? rankIdentifierValue.intValue() : 0;
        Integer usersAboveMe = meResponse.getUsersAboveMe();
        return new Me(str, intValue, str2, intValue2, usersAboveMe != null ? usersAboveMe.intValue() : 0);
    }

    public static final Paginator toPaginator(PaginatorResponse paginatorResponse) {
        Intrinsics.checkNotNullParameter(paginatorResponse, "");
        Integer page = paginatorResponse.getPage();
        int intValue = page != null ? page.intValue() : 0;
        Integer size = paginatorResponse.getSize();
        int intValue2 = size != null ? size.intValue() : 0;
        Integer totalItems = paginatorResponse.getTotalItems();
        int intValue3 = totalItems != null ? totalItems.intValue() : 0;
        Boolean hasMore = paginatorResponse.getHasMore();
        return new Paginator(intValue, intValue2, intValue3, hasMore != null ? hasMore.booleanValue() : false);
    }
}

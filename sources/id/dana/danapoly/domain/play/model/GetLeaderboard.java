package id.dana.danapoly.domain.play.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BE\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/danapoly/domain/play/model/GetLeaderboard;", "", "", "eventExpiryDate", "Ljava/lang/Long;", "getEventExpiryDate", "()Ljava/lang/Long;", "setEventExpiryDate", "(Ljava/lang/Long;)V", "", "Lid/dana/danapoly/domain/play/model/Leaderboard;", "leaderboards", "Ljava/util/List;", "getLeaderboards", "()Ljava/util/List;", "Lid/dana/danapoly/domain/play/model/Me;", "me", "Lid/dana/danapoly/domain/play/model/Me;", "getMe", "()Lid/dana/danapoly/domain/play/model/Me;", "Lid/dana/danapoly/domain/play/model/Paginator;", "paginator", "Lid/dana/danapoly/domain/play/model/Paginator;", "getPaginator", "()Lid/dana/danapoly/domain/play/model/Paginator;", "Lid/dana/danapoly/domain/play/model/PrizeInfo;", "prizeInfo", "Lid/dana/danapoly/domain/play/model/PrizeInfo;", "getPrizeInfo", "()Lid/dana/danapoly/domain/play/model/PrizeInfo;", "<init>", "(Ljava/util/List;Lid/dana/danapoly/domain/play/model/PrizeInfo;Lid/dana/danapoly/domain/play/model/Me;Lid/dana/danapoly/domain/play/model/Paginator;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetLeaderboard {
    private Long eventExpiryDate;
    private final List<Leaderboard> leaderboards;
    private final Me me;
    private final Paginator paginator;
    private final PrizeInfo prizeInfo;

    public GetLeaderboard() {
        this(null, null, null, null, null, 31, null);
    }

    public GetLeaderboard(List<Leaderboard> list, PrizeInfo prizeInfo, Me me2, Paginator paginator, Long l) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(paginator, "");
        this.leaderboards = list;
        this.prizeInfo = prizeInfo;
        this.me = me2;
        this.paginator = paginator;
        this.eventExpiryDate = l;
    }

    public /* synthetic */ GetLeaderboard(List list, PrizeInfo prizeInfo, Me me2, Paginator paginator, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : prizeInfo, (i & 4) == 0 ? me2 : null, (i & 8) != 0 ? new Paginator(0, 0, 0, false, 15, null) : paginator, (i & 16) != 0 ? 0L : l);
    }

    @JvmName(name = "getLeaderboards")
    public final List<Leaderboard> getLeaderboards() {
        return this.leaderboards;
    }

    @JvmName(name = "getPrizeInfo")
    public final PrizeInfo getPrizeInfo() {
        return this.prizeInfo;
    }

    @JvmName(name = "getMe")
    public final Me getMe() {
        return this.me;
    }

    @JvmName(name = "getPaginator")
    public final Paginator getPaginator() {
        return this.paginator;
    }

    @JvmName(name = "getEventExpiryDate")
    public final Long getEventExpiryDate() {
        return this.eventExpiryDate;
    }

    @JvmName(name = "setEventExpiryDate")
    public final void setEventExpiryDate(Long l) {
        this.eventExpiryDate = l;
    }
}

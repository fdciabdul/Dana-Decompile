package id.dana.danapoly.data.play.model.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/danapoly/data/play/model/response/GetLeaderboardResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/danapoly/data/play/model/response/LeaderboardResponse;", "leaderboards", "Ljava/util/List;", "getLeaderboards", "()Ljava/util/List;", "Lid/dana/danapoly/data/play/model/response/MeResponse;", "me", "Lid/dana/danapoly/data/play/model/response/MeResponse;", "getMe", "()Lid/dana/danapoly/data/play/model/response/MeResponse;", "Lid/dana/danapoly/data/play/model/response/PaginatorResponse;", "paginator", "Lid/dana/danapoly/data/play/model/response/PaginatorResponse;", "getPaginator", "()Lid/dana/danapoly/data/play/model/response/PaginatorResponse;", "Lid/dana/danapoly/data/play/model/response/PrizeInfoResponse;", "prizeInfo", "Lid/dana/danapoly/data/play/model/response/PrizeInfoResponse;", "getPrizeInfo", "()Lid/dana/danapoly/data/play/model/response/PrizeInfoResponse;", "<init>", "(Ljava/util/List;Lid/dana/danapoly/data/play/model/response/MeResponse;Lid/dana/danapoly/data/play/model/response/PaginatorResponse;Lid/dana/danapoly/data/play/model/response/PrizeInfoResponse;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetLeaderboardResponse extends BaseRpcResult {
    @SerializedName("leaderboards")
    private final List<LeaderboardResponse> leaderboards;
    @SerializedName("me")
    private final MeResponse me;
    @SerializedName("paginator")
    private final PaginatorResponse paginator;
    @SerializedName("prizeInfo")
    private final PrizeInfoResponse prizeInfo;

    public GetLeaderboardResponse() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ GetLeaderboardResponse(List list, MeResponse meResponse, PaginatorResponse paginatorResponse, PrizeInfoResponse prizeInfoResponse, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : meResponse, (i & 4) != 0 ? new PaginatorResponse(null, null, null, null, 15, null) : paginatorResponse, (i & 8) != 0 ? null : prizeInfoResponse);
    }

    @JvmName(name = "getLeaderboards")
    public final List<LeaderboardResponse> getLeaderboards() {
        return this.leaderboards;
    }

    @JvmName(name = "getMe")
    public final MeResponse getMe() {
        return this.me;
    }

    @JvmName(name = "getPaginator")
    public final PaginatorResponse getPaginator() {
        return this.paginator;
    }

    @JvmName(name = "getPrizeInfo")
    public final PrizeInfoResponse getPrizeInfo() {
        return this.prizeInfo;
    }

    public GetLeaderboardResponse(List<LeaderboardResponse> list, MeResponse meResponse, PaginatorResponse paginatorResponse, PrizeInfoResponse prizeInfoResponse) {
        this.leaderboards = list;
        this.me = meResponse;
        this.paginator = paginatorResponse;
        this.prizeInfo = prizeInfoResponse;
    }
}

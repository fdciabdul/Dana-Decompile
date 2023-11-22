package id.dana.danapoly.data.rewards.model.response;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/danapoly/data/rewards/model/response/RewardResponse;", "", "", "Lid/dana/danapoly/data/rewards/model/response/RewardItemResponse;", FirebaseAnalytics.Param.ITEMS, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "Lid/dana/danapoly/data/rewards/model/response/PaginatorResponse;", "itemsPaginator", "Lid/dana/danapoly/data/rewards/model/response/PaginatorResponse;", "getItemsPaginator", "()Lid/dana/danapoly/data/rewards/model/response/PaginatorResponse;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lid/dana/danapoly/data/rewards/model/response/PaginatorResponse;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RewardResponse {
    private final List<RewardItemResponse> items;
    private final PaginatorResponse itemsPaginator;
    private final String type;

    public RewardResponse() {
        this(null, null, null, 7, null);
    }

    public RewardResponse(String str, List<RewardItemResponse> list, PaginatorResponse paginatorResponse) {
        this.type = str;
        this.items = list;
        this.itemsPaginator = paginatorResponse;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    public /* synthetic */ RewardResponse(String str, List list, PaginatorResponse paginatorResponse, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? new PaginatorResponse(null, null, null, 7, null) : paginatorResponse);
    }

    @JvmName(name = "getItems")
    public final List<RewardItemResponse> getItems() {
        return this.items;
    }

    @JvmName(name = "getItemsPaginator")
    public final PaginatorResponse getItemsPaginator() {
        return this.itemsPaginator;
    }
}

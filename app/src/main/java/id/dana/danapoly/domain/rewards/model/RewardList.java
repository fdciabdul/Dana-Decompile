package id.dana.danapoly.domain.rewards.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/danapoly/domain/rewards/model/RewardList;", "", "", "Lid/dana/danapoly/domain/rewards/model/RewardItem;", FirebaseAnalytics.Param.ITEMS, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "Lid/dana/danapoly/domain/rewards/model/PaginatorInfo;", "itemsPaginator", "Lid/dana/danapoly/domain/rewards/model/PaginatorInfo;", "getItemsPaginator", "()Lid/dana/danapoly/domain/rewards/model/PaginatorInfo;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lid/dana/danapoly/domain/rewards/model/PaginatorInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RewardList {
    private final List<RewardItem> items;
    private final PaginatorInfo itemsPaginator;
    private final String type;

    public RewardList(String str, List<RewardItem> list, PaginatorInfo paginatorInfo) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(paginatorInfo, "");
        this.type = str;
        this.items = list;
        this.itemsPaginator = paginatorInfo;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getItems")
    public final List<RewardItem> getItems() {
        return this.items;
    }

    @JvmName(name = "getItemsPaginator")
    public final PaginatorInfo getItemsPaginator() {
        return this.itemsPaginator;
    }
}

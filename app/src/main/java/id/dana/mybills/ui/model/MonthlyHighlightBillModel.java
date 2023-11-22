package id.dana.mybills.ui.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/mybills/ui/model/MonthlyHighlightBillModel;", "", "", "hasMore", "Z", "getHasMore", "()Z", "", "Lid/dana/mybills/ui/model/BillSubscriptionHighlightModel;", "subscriptionHighlightViews", "Ljava/util/List;", "getSubscriptionHighlightViews", "()Ljava/util/List;", "", "totalCount", "Ljava/lang/Integer;", "getTotalCount", "()Ljava/lang/Integer;", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MonthlyHighlightBillModel {
    private final boolean hasMore;
    private final List<BillSubscriptionHighlightModel> subscriptionHighlightViews;
    private final Integer totalCount;

    public MonthlyHighlightBillModel(List<BillSubscriptionHighlightModel> list, Integer num, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        this.subscriptionHighlightViews = list;
        this.totalCount = num;
        this.hasMore = z;
    }

    public /* synthetic */ MonthlyHighlightBillModel(List list, Integer num, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, num, z);
    }

    @JvmName(name = "getSubscriptionHighlightViews")
    public final List<BillSubscriptionHighlightModel> getSubscriptionHighlightViews() {
        return this.subscriptionHighlightViews;
    }

    @JvmName(name = "getTotalCount")
    public final Integer getTotalCount() {
        return this.totalCount;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }
}

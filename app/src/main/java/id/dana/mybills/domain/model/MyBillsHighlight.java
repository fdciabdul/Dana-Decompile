package id.dana.mybills.domain.model;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b \u0010!J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000e\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\b"}, d2 = {"Lid/dana/mybills/domain/model/MyBillsHighlight;", "Ljava/io/Serializable;", "", "Lid/dana/mybills/domain/model/MyBillsItemHighlightView;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/Integer;", "", "component3", "()Z", "subscriptionHighlightViews", "totalCount", "hasMore", "copy", "(Ljava/util/List;Ljava/lang/Integer;Z)Lid/dana/mybills/domain/model/MyBillsHighlight;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getHasMore", "Ljava/util/List;", "getSubscriptionHighlightViews", "Ljava/lang/Integer;", "getTotalCount", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MyBillsHighlight implements Serializable {
    private final boolean hasMore;
    private final List<MyBillsItemHighlightView> subscriptionHighlightViews;
    private final Integer totalCount;

    public MyBillsHighlight() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyBillsHighlight copy$default(MyBillsHighlight myBillsHighlight, List list, Integer num, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = myBillsHighlight.subscriptionHighlightViews;
        }
        if ((i & 2) != 0) {
            num = myBillsHighlight.totalCount;
        }
        if ((i & 4) != 0) {
            z = myBillsHighlight.hasMore;
        }
        return myBillsHighlight.copy(list, num, z);
    }

    public final List<MyBillsItemHighlightView> component1() {
        return this.subscriptionHighlightViews;
    }

    /* renamed from: component2  reason: from getter */
    public final Integer getTotalCount() {
        return this.totalCount;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final MyBillsHighlight copy(List<MyBillsItemHighlightView> subscriptionHighlightViews, Integer totalCount, boolean hasMore) {
        Intrinsics.checkNotNullParameter(subscriptionHighlightViews, "");
        return new MyBillsHighlight(subscriptionHighlightViews, totalCount, hasMore);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MyBillsHighlight) {
            MyBillsHighlight myBillsHighlight = (MyBillsHighlight) other;
            return Intrinsics.areEqual(this.subscriptionHighlightViews, myBillsHighlight.subscriptionHighlightViews) && Intrinsics.areEqual(this.totalCount, myBillsHighlight.totalCount) && this.hasMore == myBillsHighlight.hasMore;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.subscriptionHighlightViews.hashCode();
        Integer num = this.totalCount;
        int hashCode2 = num == null ? 0 : num.hashCode();
        boolean z = this.hasMore;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((hashCode * 31) + hashCode2) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyBillsHighlight(subscriptionHighlightViews=");
        sb.append(this.subscriptionHighlightViews);
        sb.append(", totalCount=");
        sb.append(this.totalCount);
        sb.append(", hasMore=");
        sb.append(this.hasMore);
        sb.append(')');
        return sb.toString();
    }

    public MyBillsHighlight(List<MyBillsItemHighlightView> list, Integer num, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        this.subscriptionHighlightViews = list;
        this.totalCount = num;
        this.hasMore = z;
    }

    public /* synthetic */ MyBillsHighlight(List list, Integer num, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? false : z);
    }

    @JvmName(name = "getSubscriptionHighlightViews")
    public final List<MyBillsItemHighlightView> getSubscriptionHighlightViews() {
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

package id.dana.domain.mybills.model;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b"}, d2 = {"Lid/dana/domain/mybills/model/MyBillsHighlight;", "Ljava/io/Serializable;", "", "Lid/dana/domain/mybills/model/MyBillsItemHighlightView;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/Integer;", "subscriptionHighlightViews", "totalCount", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lid/dana/domain/mybills/model/MyBillsHighlight;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getSubscriptionHighlightViews", "Ljava/lang/Integer;", "getTotalCount", "<init>", "(Ljava/util/List;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MyBillsHighlight implements Serializable {
    private final List<MyBillsItemHighlightView> subscriptionHighlightViews;
    private final Integer totalCount;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MyBillsHighlight() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.mybills.model.MyBillsHighlight.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyBillsHighlight copy$default(MyBillsHighlight myBillsHighlight, List list, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            list = myBillsHighlight.subscriptionHighlightViews;
        }
        if ((i & 2) != 0) {
            num = myBillsHighlight.totalCount;
        }
        return myBillsHighlight.copy(list, num);
    }

    public final List<MyBillsItemHighlightView> component1() {
        return this.subscriptionHighlightViews;
    }

    /* renamed from: component2  reason: from getter */
    public final Integer getTotalCount() {
        return this.totalCount;
    }

    public final MyBillsHighlight copy(List<MyBillsItemHighlightView> subscriptionHighlightViews, Integer totalCount) {
        return new MyBillsHighlight(subscriptionHighlightViews, totalCount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MyBillsHighlight) {
            MyBillsHighlight myBillsHighlight = (MyBillsHighlight) other;
            return Intrinsics.areEqual(this.subscriptionHighlightViews, myBillsHighlight.subscriptionHighlightViews) && Intrinsics.areEqual(this.totalCount, myBillsHighlight.totalCount);
        }
        return false;
    }

    public final int hashCode() {
        List<MyBillsItemHighlightView> list = this.subscriptionHighlightViews;
        int hashCode = list == null ? 0 : list.hashCode();
        Integer num = this.totalCount;
        return (hashCode * 31) + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyBillsHighlight(subscriptionHighlightViews=");
        sb.append(this.subscriptionHighlightViews);
        sb.append(", totalCount=");
        sb.append(this.totalCount);
        sb.append(')');
        return sb.toString();
    }

    public MyBillsHighlight(List<MyBillsItemHighlightView> list, Integer num) {
        this.subscriptionHighlightViews = list;
        this.totalCount = num;
    }

    public /* synthetic */ MyBillsHighlight(List list, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? 0 : num);
    }

    @JvmName(name = "getSubscriptionHighlightViews")
    public final List<MyBillsItemHighlightView> getSubscriptionHighlightViews() {
        return this.subscriptionHighlightViews;
    }

    @JvmName(name = "getTotalCount")
    public final Integer getTotalCount() {
        return this.totalCount;
    }
}

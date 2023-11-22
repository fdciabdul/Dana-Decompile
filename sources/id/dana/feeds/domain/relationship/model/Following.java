package id.dana.feeds.domain.relationship.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001c\u0010\b"}, d2 = {"Lid/dana/feeds/domain/relationship/model/Following;", "", "", "Lid/dana/feeds/domain/relationship/model/RelationshipItem;", "component1", "()Ljava/util/List;", "Lid/dana/feeds/domain/relationship/model/Paginator;", "component2", "()Lid/dana/feeds/domain/relationship/model/Paginator;", "followingItemList", "paginator", "copy", "(Ljava/util/List;Lid/dana/feeds/domain/relationship/model/Paginator;)Lid/dana/feeds/domain/relationship/model/Following;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getFollowingItemList", "setFollowingItemList", "(Ljava/util/List;)V", "Lid/dana/feeds/domain/relationship/model/Paginator;", "getPaginator", "<init>", "(Ljava/util/List;Lid/dana/feeds/domain/relationship/model/Paginator;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Following {
    private List<RelationshipItem> followingItemList;
    private final Paginator paginator;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, id.dana.feeds.domain.relationship.model.Paginator, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Following() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.relationship.model.Following.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Following copy$default(Following following, List list, Paginator paginator, int i, Object obj) {
        if ((i & 1) != 0) {
            list = following.followingItemList;
        }
        if ((i & 2) != 0) {
            paginator = following.paginator;
        }
        return following.copy(list, paginator);
    }

    public final List<RelationshipItem> component1() {
        return this.followingItemList;
    }

    /* renamed from: component2  reason: from getter */
    public final Paginator getPaginator() {
        return this.paginator;
    }

    public final Following copy(List<RelationshipItem> followingItemList, Paginator paginator) {
        Intrinsics.checkNotNullParameter(followingItemList, "");
        Intrinsics.checkNotNullParameter(paginator, "");
        return new Following(followingItemList, paginator);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Following) {
            Following following = (Following) other;
            return Intrinsics.areEqual(this.followingItemList, following.followingItemList) && Intrinsics.areEqual(this.paginator, following.paginator);
        }
        return false;
    }

    public final int hashCode() {
        return (this.followingItemList.hashCode() * 31) + this.paginator.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Following(followingItemList=");
        sb.append(this.followingItemList);
        sb.append(", paginator=");
        sb.append(this.paginator);
        sb.append(')');
        return sb.toString();
    }

    public Following(List<RelationshipItem> list, Paginator paginator) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(paginator, "");
        this.followingItemList = list;
        this.paginator = paginator;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ Following(java.util.List r19, id.dana.feeds.domain.relationship.model.Paginator r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r18 = this;
            r0 = r21 & 1
            if (r0 == 0) goto Lc
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            goto Le
        Lc:
            r0 = r19
        Le:
            r1 = r21 & 2
            if (r1 == 0) goto L2c
            id.dana.feeds.domain.relationship.model.Paginator r1 = new id.dana.feeds.domain.relationship.model.Paginator
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 8191(0x1fff, float:1.1478E-41)
            r17 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r2 = r18
            goto L30
        L2c:
            r2 = r18
            r1 = r20
        L30:
            r2.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.relationship.model.Following.<init>(java.util.List, id.dana.feeds.domain.relationship.model.Paginator, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getFollowingItemList")
    public final List<RelationshipItem> getFollowingItemList() {
        return this.followingItemList;
    }

    @JvmName(name = "setFollowingItemList")
    public final void setFollowingItemList(List<RelationshipItem> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.followingItemList = list;
    }

    @JvmName(name = "getPaginator")
    public final Paginator getPaginator() {
        return this.paginator;
    }
}

package id.dana.feeds.data.relationship.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u001a\u0010\n\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\b"}, d2 = {"Lid/dana/feeds/data/relationship/source/network/response/FollowingResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/feeds/data/relationship/source/network/response/RelationshipItemResponse;", "component1", "()Ljava/util/List;", "Lid/dana/feeds/data/relationship/source/network/response/PaginatorResponse;", "component2", "()Lid/dana/feeds/data/relationship/source/network/response/PaginatorResponse;", "followingList", "paginator", "copy", "(Ljava/util/List;Lid/dana/feeds/data/relationship/source/network/response/PaginatorResponse;)Lid/dana/feeds/data/relationship/source/network/response/FollowingResponse;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getFollowingList", "Lid/dana/feeds/data/relationship/source/network/response/PaginatorResponse;", "getPaginator", "<init>", "(Ljava/util/List;Lid/dana/feeds/data/relationship/source/network/response/PaginatorResponse;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FollowingResponse extends BaseRpcResult {
    private final List<RelationshipItemResponse> followingList;
    private final PaginatorResponse paginator;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, id.dana.feeds.data.relationship.source.network.response.PaginatorResponse, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FollowingResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.relationship.source.network.response.FollowingResponse.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FollowingResponse copy$default(FollowingResponse followingResponse, List list, PaginatorResponse paginatorResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            list = followingResponse.followingList;
        }
        if ((i & 2) != 0) {
            paginatorResponse = followingResponse.paginator;
        }
        return followingResponse.copy(list, paginatorResponse);
    }

    public final List<RelationshipItemResponse> component1() {
        return this.followingList;
    }

    /* renamed from: component2  reason: from getter */
    public final PaginatorResponse getPaginator() {
        return this.paginator;
    }

    public final FollowingResponse copy(List<RelationshipItemResponse> followingList, PaginatorResponse paginator) {
        Intrinsics.checkNotNullParameter(followingList, "");
        Intrinsics.checkNotNullParameter(paginator, "");
        return new FollowingResponse(followingList, paginator);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FollowingResponse) {
            FollowingResponse followingResponse = (FollowingResponse) other;
            return Intrinsics.areEqual(this.followingList, followingResponse.followingList) && Intrinsics.areEqual(this.paginator, followingResponse.paginator);
        }
        return false;
    }

    public final int hashCode() {
        return (this.followingList.hashCode() * 31) + this.paginator.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FollowingResponse(followingList=");
        sb.append(this.followingList);
        sb.append(", paginator=");
        sb.append(this.paginator);
        sb.append(')');
        return sb.toString();
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ FollowingResponse(java.util.List r19, id.dana.feeds.data.relationship.source.network.response.PaginatorResponse r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r18 = this;
            r0 = r21 & 1
            if (r0 == 0) goto L9
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            goto Lb
        L9:
            r0 = r19
        Lb:
            r1 = r21 & 2
            if (r1 == 0) goto L29
            id.dana.feeds.data.relationship.source.network.response.PaginatorResponse r1 = new id.dana.feeds.data.relationship.source.network.response.PaginatorResponse
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
            goto L2d
        L29:
            r2 = r18
            r1 = r20
        L2d:
            r2.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.relationship.source.network.response.FollowingResponse.<init>(java.util.List, id.dana.feeds.data.relationship.source.network.response.PaginatorResponse, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getFollowingList")
    public final List<RelationshipItemResponse> getFollowingList() {
        return this.followingList;
    }

    @JvmName(name = "getPaginator")
    public final PaginatorResponse getPaginator() {
        return this.paginator;
    }

    public FollowingResponse(List<RelationshipItemResponse> list, PaginatorResponse paginatorResponse) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(paginatorResponse, "");
        this.followingList = list;
        this.paginator = paginatorResponse;
    }
}

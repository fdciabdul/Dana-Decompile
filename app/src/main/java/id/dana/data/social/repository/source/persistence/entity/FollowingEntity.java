package id.dana.data.social.repository.source.persistence.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u001a\u0010\n\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b"}, d2 = {"Lid/dana/data/social/repository/source/persistence/entity/FollowingEntity;", "", "", "Lid/dana/data/social/repository/source/persistence/entity/FollowingItemEntity;", "component1", "()Ljava/util/List;", "Lid/dana/data/social/repository/source/persistence/entity/PaginatorEntity;", "component2", "()Lid/dana/data/social/repository/source/persistence/entity/PaginatorEntity;", "followingList", "paginator", "copy", "(Ljava/util/List;Lid/dana/data/social/repository/source/persistence/entity/PaginatorEntity;)Lid/dana/data/social/repository/source/persistence/entity/FollowingEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getFollowingList", "Lid/dana/data/social/repository/source/persistence/entity/PaginatorEntity;", "getPaginator", "<init>", "(Ljava/util/List;Lid/dana/data/social/repository/source/persistence/entity/PaginatorEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FollowingEntity {
    private final List<FollowingItemEntity> followingList;
    private final PaginatorEntity paginator;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.data.social.repository.source.persistence.entity.PaginatorEntity, java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FollowingEntity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.social.repository.source.persistence.entity.FollowingEntity.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FollowingEntity copy$default(FollowingEntity followingEntity, List list, PaginatorEntity paginatorEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            list = followingEntity.followingList;
        }
        if ((i & 2) != 0) {
            paginatorEntity = followingEntity.paginator;
        }
        return followingEntity.copy(list, paginatorEntity);
    }

    public final List<FollowingItemEntity> component1() {
        return this.followingList;
    }

    /* renamed from: component2  reason: from getter */
    public final PaginatorEntity getPaginator() {
        return this.paginator;
    }

    public final FollowingEntity copy(List<FollowingItemEntity> followingList, PaginatorEntity paginator) {
        Intrinsics.checkNotNullParameter(followingList, "");
        Intrinsics.checkNotNullParameter(paginator, "");
        return new FollowingEntity(followingList, paginator);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FollowingEntity) {
            FollowingEntity followingEntity = (FollowingEntity) other;
            return Intrinsics.areEqual(this.followingList, followingEntity.followingList) && Intrinsics.areEqual(this.paginator, followingEntity.paginator);
        }
        return false;
    }

    public final int hashCode() {
        return (this.followingList.hashCode() * 31) + this.paginator.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FollowingEntity(followingList=");
        sb.append(this.followingList);
        sb.append(", paginator=");
        sb.append(this.paginator);
        sb.append(')');
        return sb.toString();
    }

    public FollowingEntity(List<FollowingItemEntity> list, PaginatorEntity paginatorEntity) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(paginatorEntity, "");
        this.followingList = list;
        this.paginator = paginatorEntity;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ FollowingEntity(java.util.List r19, id.dana.data.social.repository.source.persistence.entity.PaginatorEntity r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
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
            id.dana.data.social.repository.source.persistence.entity.PaginatorEntity r1 = new id.dana.data.social.repository.source.persistence.entity.PaginatorEntity
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.social.repository.source.persistence.entity.FollowingEntity.<init>(java.util.List, id.dana.data.social.repository.source.persistence.entity.PaginatorEntity, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getFollowingList")
    public final List<FollowingItemEntity> getFollowingList() {
        return this.followingList;
    }

    @JvmName(name = "getPaginator")
    public final PaginatorEntity getPaginator() {
        return this.paginator;
    }
}

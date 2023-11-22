package id.dana.feeds.data.relationship.source.network.request;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004JX\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010\u0007R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b%\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b&\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/relationship/source/network/request/RelationshipRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Long;", "", "component3", "()Ljava/lang/Integer;", "component4", "component5", "component6", "status", "modifiedTime", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "followingId", "followerId", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lid/dana/feeds/data/relationship/source/network/request/RelationshipRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getFollowerId", "getFollowingId", "Ljava/lang/Long;", "getModifiedTime", "Ljava/lang/Integer;", "getPageNum", "getPageSize", "getStatus", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RelationshipRequest extends BaseRpcRequest {
    private final String followerId;
    private final String followingId;
    private final Long modifiedTime;
    private final Integer pageNum;
    private final Integer pageSize;
    private final String status;

    public RelationshipRequest() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ RelationshipRequest copy$default(RelationshipRequest relationshipRequest, String str, Long l, Integer num, Integer num2, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = relationshipRequest.status;
        }
        if ((i & 2) != 0) {
            l = relationshipRequest.modifiedTime;
        }
        Long l2 = l;
        if ((i & 4) != 0) {
            num = relationshipRequest.pageNum;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            num2 = relationshipRequest.pageSize;
        }
        Integer num4 = num2;
        if ((i & 16) != 0) {
            str2 = relationshipRequest.followingId;
        }
        String str4 = str2;
        if ((i & 32) != 0) {
            str3 = relationshipRequest.followerId;
        }
        return relationshipRequest.copy(str, l2, num3, num4, str4, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component2  reason: from getter */
    public final Long getModifiedTime() {
        return this.modifiedTime;
    }

    /* renamed from: component3  reason: from getter */
    public final Integer getPageNum() {
        return this.pageNum;
    }

    /* renamed from: component4  reason: from getter */
    public final Integer getPageSize() {
        return this.pageSize;
    }

    /* renamed from: component5  reason: from getter */
    public final String getFollowingId() {
        return this.followingId;
    }

    /* renamed from: component6  reason: from getter */
    public final String getFollowerId() {
        return this.followerId;
    }

    public final RelationshipRequest copy(String status, Long modifiedTime, Integer pageNum, Integer pageSize, String followingId, String followerId) {
        return new RelationshipRequest(status, modifiedTime, pageNum, pageSize, followingId, followerId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RelationshipRequest) {
            RelationshipRequest relationshipRequest = (RelationshipRequest) other;
            return Intrinsics.areEqual(this.status, relationshipRequest.status) && Intrinsics.areEqual(this.modifiedTime, relationshipRequest.modifiedTime) && Intrinsics.areEqual(this.pageNum, relationshipRequest.pageNum) && Intrinsics.areEqual(this.pageSize, relationshipRequest.pageSize) && Intrinsics.areEqual(this.followingId, relationshipRequest.followingId) && Intrinsics.areEqual(this.followerId, relationshipRequest.followerId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.status;
        int hashCode = str == null ? 0 : str.hashCode();
        Long l = this.modifiedTime;
        int hashCode2 = l == null ? 0 : l.hashCode();
        Integer num = this.pageNum;
        int hashCode3 = num == null ? 0 : num.hashCode();
        Integer num2 = this.pageSize;
        int hashCode4 = num2 == null ? 0 : num2.hashCode();
        String str2 = this.followingId;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.followerId;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RelationshipRequest(status=");
        sb.append(this.status);
        sb.append(", modifiedTime=");
        sb.append(this.modifiedTime);
        sb.append(", pageNum=");
        sb.append(this.pageNum);
        sb.append(", pageSize=");
        sb.append(this.pageSize);
        sb.append(", followingId=");
        sb.append(this.followingId);
        sb.append(", followerId=");
        sb.append(this.followerId);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getModifiedTime")
    public final Long getModifiedTime() {
        return this.modifiedTime;
    }

    public /* synthetic */ RelationshipRequest(String str, Long l, Integer num, Integer num2, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? 1 : num, (i & 8) != 0 ? 10 : num2, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3);
    }

    @JvmName(name = "getPageNum")
    public final Integer getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "getPageSize")
    public final Integer getPageSize() {
        return this.pageSize;
    }

    @JvmName(name = "getFollowingId")
    public final String getFollowingId() {
        return this.followingId;
    }

    @JvmName(name = "getFollowerId")
    public final String getFollowerId() {
        return this.followerId;
    }

    public RelationshipRequest(String str, Long l, Integer num, Integer num2, String str2, String str3) {
        this.status = str;
        this.modifiedTime = l;
        this.pageNum = num;
        this.pageSize = num2;
        this.followingId = str2;
        this.followerId = str3;
    }
}
